/*
 * Copyright (c) 2018 stanwood Gmbh
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.stanwood.bitrise.ui.artifacts.vm

import android.Manifest
import android.app.DownloadManager
import android.app.DownloadManager.Query
import android.app.DownloadManager.Request
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableBoolean
import android.databinding.ObservableInt
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.text.format.Formatter
import io.stanwood.bitrise.BuildConfig
import io.stanwood.bitrise.PermissionActivity
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.model.Artifact
import io.stanwood.bitrise.navigation.SCREEN_ERROR
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI
import ru.terrakok.cicerone.Router
import timber.log.Timber


private enum class DownloadStatus {
    RUNNING,
    SUCCESS,
    FAILED
}

class ArtifactItemViewModel(
        private val activity: PermissionActivity,
        private val router: Router,
        private val artifact: Artifact) : BaseObservable() {

    val icon: Drawable?
        get() = artifact.artifactType?.getIcon(activity.resources)

    val title: String
        get() = artifact.title

    @get:Bindable("downloadedSize", "isDownloading")
    val size: String
        get() = when {
            isAwaitingDownload -> activity.getString(R.string.download_awaiting_message)
            isDownloading.get() -> {
                val progress = (downloadedSize.get() / totalSize.get().toFloat() * 100).toInt()
                val totalSizeFormatted = Formatter.formatShortFileSize(activity, totalSize.get().toLong())
                val downloadedSizeFormatted = Formatter.formatShortFileSize(activity, downloadedSize.get().toLong())
                "$downloadedSizeFormatted/$totalSizeFormatted ($progress%)"
            }
            else -> Formatter.formatShortFileSize(activity, artifact.fileSizeBytes.toLong())
        }

    val totalSize = ObservableInt(0)

    val downloadedSize = ObservableInt(0)

    val isDownloading = ObservableBoolean()

    @get:Bindable("downloadedSize", "isDownloading")
    val isAwaitingDownload
        get() = isDownloading.get() && downloadedSize.get() == 0

    private val downloadUri: Uri
        get() = Uri.parse(artifact.expiringDownloadUrl)

    private val downloadErrorMessage: String
        get() = activity.getString(R.string.download_error_message, title)

    private val downloadCancelledMessage: String
        get() = activity.getString(R.string.download_cancelled_message, title)

    private val downloadManager: DownloadManager
            by lazy { activity.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager }

    private var downloadingJob: Job? = null

    fun stop() {
        downloadingJob?.cancel()
    }

    fun onClick() {
        if (isDownloading.get()) {
            downloadingJob?.cancel()
            return
        }
        try {
            downloadingJob = launch {
                if (activity.requestPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    download()
                }
            }
        } catch (exception: Exception) {
            onDownloadStop()
            Timber.e(exception)
            router.navigateTo(SCREEN_ERROR, exception.message)
        }
    }

    private suspend fun download() {
        isDownloading.set(true)
        val request = Request(downloadUri).apply {
            setTitle(title)
            setNotificationVisibility(Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title)
        }
        downloadManager.apply {
            val id = enqueue(request)
            var status = DownloadStatus.RUNNING
            try {
                do {
                    val progressQuery = Query().setFilterById(id)
                    query(progressQuery).let { status = updateDownloadProgress(it) }
                    delay(BuildConfig.DOWNLOAD_STATUS_REFRESH_DELAY)
                } while (status == DownloadStatus.RUNNING)
            } catch (e: CancellationException) {
                Timber.d("Download canceled: $title")
                showMessage(downloadCancelledMessage)
                remove(id)
                return
            } finally {
                onDownloadStop()
            }

            if(status == DownloadStatus.SUCCESS) {
                Timber.d("Download completed: $title")
                installApk(id)
            } else {
                Timber.d("Download failed: $title")
                showMessage(downloadErrorMessage)
            }
        }
    }

    private fun updateDownloadProgress(cursor: Cursor): DownloadStatus {
        cursor.apply {
            if (moveToFirst()) {
                val downloadedColIndex = getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR)
                val totalColIndex = getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES)
                val statusColIndex = getColumnIndex(DownloadManager.COLUMN_STATUS)
                downloadedSize.set(getInt(downloadedColIndex))
                totalSize.set(getInt(totalColIndex))
                return when(getInt(statusColIndex)) {
                    DownloadManager.STATUS_SUCCESSFUL -> DownloadStatus.SUCCESS
                    DownloadManager.STATUS_FAILED -> DownloadStatus.FAILED
                    else -> DownloadStatus.RUNNING
                }
            }
        }
        return DownloadStatus.FAILED
    }

    private fun getDownloadedApkUri(downloadId: Long): Uri {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            downloadManager.getUriForDownloadedFile(downloadId)
        } else {
            val query = DownloadManager.Query()
            query.setFilterById(downloadId)
            downloadManager.query(query).use {
                it.moveToFirst()
                val path = it.getString(it.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI))
                Uri.parse(path)
            }
        }
    }

    private fun installApk(downloadId: Long) {
        val uri = getDownloadedApkUri(downloadId)
        Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, "application/vnd.android.package-archive")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            } else {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
        }.let {
            activity.startActivity(it)
        }
    }

    private fun onDownloadStop() {
        isDownloading.set(false)
        totalSize.set(0)
        downloadedSize.set(0)
    }

    private fun showMessage(message: String) {
        async(UI) {
            router.showSystemMessage(message)
        }
    }
}
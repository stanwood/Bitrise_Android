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
import android.databinding.ObservableInt
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.text.format.Formatter
import io.stanwood.bitrise.PermissionActivity
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.model.Artifact
import io.stanwood.bitrise.navigation.SCREEN_ERROR
import kotlinx.coroutines.experimental.async
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

    val icon: Drawable
        get() = artifact.artifactType.getIcon(activity.resources)

    val title: String
        get() = artifact.title

    @get:Bindable("downloadedSize")
    val size: String
        get() = if (isDownloading) {
            val progress = (downloadedSize.get() / totalSize.get().toFloat() * 100).toInt()
            val totalSizeFormatted = Formatter.formatShortFileSize(activity, totalSize.get().toLong())
            val downloadedSizeFormatted = Formatter.formatShortFileSize(activity, downloadedSize.get().toLong())
            "$downloadedSizeFormatted/$totalSizeFormatted ($progress%)"
        } else {
            Formatter.formatShortFileSize(activity, artifact.fileSizeBytes.toLong())
        }

    val totalSize = ObservableInt(0)

    val downloadedSize = ObservableInt(0)

    @get:Bindable("downloadedSize")
    val isDownloading
        get() = totalSize.get() != downloadedSize.get()

    val downloadUri: Uri
        get() = Uri.parse(artifact.expiringDownloadUrl)

    private val downloadErrorMessage: String
        get() = activity.getString(R.string.download_error_message, title)

    private val downloadManager: DownloadManager
            by lazy { activity.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager }

    fun onClick() {
        if (isDownloading) {
            return
        }
        try {
            async {
                if (activity.requestPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    download()
                }
            }
        } catch (exception: Exception) {
            onDownloadFailed()
            Timber.e(exception)
            router.navigateTo(SCREEN_ERROR, exception.message)
        }
    }

    suspend private fun download() {
        val request = Request(downloadUri).apply {
            setTitle(title)
            setNotificationVisibility(Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title)
        }
        downloadManager.apply {
            val id = enqueue(request)
            var status = DownloadStatus.RUNNING
            do {
                val progressQuery = Query().setFilterById(id)
                query(progressQuery)
                        .let { status = updateDownloadProgress(it) }

                if(status == DownloadStatus.FAILED) {
                    onDownloadFailed()
                    return
                }

            } while (status == DownloadStatus.RUNNING)
            installApk(id)
        }
    }

    suspend private fun updateDownloadProgress(cursor: Cursor): DownloadStatus {
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

    private fun installApk(downloadId: Long) {
        val uri = downloadManager.getUriForDownloadedFile(downloadId)
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

    private fun onDownloadFailed() {
        totalSize.set(0)
        downloadedSize.set(0)
        router.showSystemMessage(downloadErrorMessage)
    }
}
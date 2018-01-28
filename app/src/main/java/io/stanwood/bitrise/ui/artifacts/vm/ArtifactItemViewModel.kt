package io.stanwood.bitrise.ui.artifacts.vm

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.format.Formatter
import io.stanwood.bitrise.data.model.Artifact
import io.stanwood.bitrise.navigation.SCREEN_INSTALL
import ru.terrakok.cicerone.Router


class ArtifactItemViewModel(
        private val context: Context,
        private val router: Router,
        private val artifact: Artifact) {

    val icon: Drawable
        get() = artifact.artifactType.getIcon(context.resources)

    val title: String
        get() = artifact.title

    val size: String
        get() = Formatter.formatShortFileSize(context, artifact.fileSizeBytes.toLong())

    fun onClick() {
        router.navigateTo(SCREEN_INSTALL, artifact.expiringDownloadUrl)
    }
}
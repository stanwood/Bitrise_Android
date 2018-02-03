package io.stanwood.bitrise.ui.artifacts.vm;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0011\u0010(\u001a\u00020)H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-H\u0002J\u0006\u0010.\u001a\u00020)J\b\u0010/\u001a\u00020)H\u0002J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00104R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8G\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020\n8G\u00a2\u0006\u0006\u001a\u0004\b#\u0010\fR\u0011\u0010$\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b%\u0010\fR\u0011\u0010&\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001a\u0082\u0002\u0004\n\u0002\b\t\u00a8\u00065"}, d2 = {"Lio/stanwood/bitrise/ui/artifacts/vm/ArtifactItemViewModel;", "Landroid/databinding/BaseObservable;", "activity", "Lio/stanwood/bitrise/PermissionActivity;", "router", "Lru/terrakok/cicerone/Router;", "artifact", "Lio/stanwood/bitrise/data/model/Artifact;", "(Lio/stanwood/bitrise/PermissionActivity;Lru/terrakok/cicerone/Router;Lio/stanwood/bitrise/data/model/Artifact;)V", "downloadErrorMessage", "", "getDownloadErrorMessage", "()Ljava/lang/String;", "downloadManager", "Landroid/app/DownloadManager;", "getDownloadManager", "()Landroid/app/DownloadManager;", "downloadManager$delegate", "Lkotlin/Lazy;", "downloadUri", "Landroid/net/Uri;", "getDownloadUri", "()Landroid/net/Uri;", "downloadedSize", "Landroid/databinding/ObservableInt;", "getDownloadedSize", "()Landroid/databinding/ObservableInt;", "icon", "Landroid/graphics/drawable/Drawable;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "isDownloading", "", "()Z", "size", "getSize", "title", "getTitle", "totalSize", "getTotalSize", "download", "", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "installApk", "downloadId", "", "onClick", "onDownloadFailed", "updateDownloadProgress", "Lio/stanwood/bitrise/ui/artifacts/vm/DownloadStatus;", "cursor", "Landroid/database/Cursor;", "(Landroid/database/Cursor;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ArtifactItemViewModel extends android.databinding.BaseObservable {
    @org.jetbrains.annotations.NotNull()
    private final android.databinding.ObservableInt totalSize = null;
    @org.jetbrains.annotations.NotNull()
    private final android.databinding.ObservableInt downloadedSize = null;
    private final kotlin.Lazy downloadManager$delegate = null;
    private final io.stanwood.bitrise.PermissionActivity activity = null;
    private final ru.terrakok.cicerone.Router router = null;
    private final io.stanwood.bitrise.data.model.Artifact artifact = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.drawable.Drawable getIcon() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.databinding.Bindable(value = {"downloadedSize"})
    public final java.lang.String getSize() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.databinding.ObservableInt getTotalSize() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.databinding.ObservableInt getDownloadedSize() {
        return null;
    }
    
    @android.databinding.Bindable(value = {"downloadedSize"})
    public final boolean isDownloading() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.net.Uri getDownloadUri() {
        return null;
    }
    
    private final java.lang.String getDownloadErrorMessage() {
        return null;
    }
    
    private final android.app.DownloadManager getDownloadManager() {
        return null;
    }
    
    public final void onClick() {
    }
    
    @org.jetbrains.annotations.Nullable()
    final java.lang.Object download(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.experimental.Continuation<? super kotlin.Unit> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    final java.lang.Object updateDownloadProgress(@org.jetbrains.annotations.NotNull()
    android.database.Cursor cursor, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.experimental.Continuation<? super io.stanwood.bitrise.ui.artifacts.vm.DownloadStatus> p1) {
        return null;
    }
    
    private final void installApk(long downloadId) {
    }
    
    private final void onDownloadFailed() {
    }
    
    public ArtifactItemViewModel(@org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.PermissionActivity activity, @org.jetbrains.annotations.NotNull()
    ru.terrakok.cicerone.Router router, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.model.Artifact artifact) {
        super();
    }
}
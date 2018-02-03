package io.stanwood.bitrise.ui.dashboard.vm;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0013\u0010#\u001a\u0004\u0018\u00010\u001bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020&J\u0006\u0010\'\u001a\u00020&J\u0006\u0010(\u001a\u00020&R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8G\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128G\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00058G\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\t\u00a8\u0006)"}, d2 = {"Lio/stanwood/bitrise/ui/dashboard/vm/AppViewModel;", "Landroid/databinding/BaseObservable;", "service", "Lio/stanwood/bitrise/data/net/BitriseService;", "token", "", "resources", "Landroid/content/res/Resources;", "router", "Lru/terrakok/cicerone/Router;", "app", "Lio/stanwood/bitrise/data/model/App;", "(Lio/stanwood/bitrise/data/net/BitriseService;Ljava/lang/String;Landroid/content/res/Resources;Lru/terrakok/cicerone/Router;Lio/stanwood/bitrise/data/model/App;)V", "buildStatusColor", "", "getBuildStatusColor", "()I", "buildStatusIcon", "Landroid/graphics/drawable/Drawable;", "getBuildStatusIcon", "()Landroid/graphics/drawable/Drawable;", "deferred", "Lkotlinx/coroutines/experimental/Deferred;", "", "icon", "getIcon", "lastBuild", "Lio/stanwood/bitrise/data/model/Build;", "lastBuildTime", "getLastBuildTime", "()Ljava/lang/String;", "repoOwner", "getRepoOwner", "title", "getTitle", "fetchLastBuild", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "onClick", "", "start", "stop", "app_debug"})
public final class AppViewModel extends android.databinding.BaseObservable {
    private kotlinx.coroutines.experimental.Deferred<? extends java.lang.Object> deferred;
    private io.stanwood.bitrise.data.model.Build lastBuild;
    private final io.stanwood.bitrise.data.net.BitriseService service = null;
    private final java.lang.String token = null;
    private final android.content.res.Resources resources = null;
    private final ru.terrakok.cicerone.Router router = null;
    private final io.stanwood.bitrise.data.model.App app = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRepoOwner() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.drawable.Drawable getIcon() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @android.databinding.Bindable()
    public final java.lang.String getLastBuildTime() {
        return null;
    }
    
    @android.databinding.Bindable(value = {"lastBuildTime"})
    public final int getBuildStatusColor() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @android.databinding.Bindable(value = {"lastBuildTime"})
    public final android.graphics.drawable.Drawable getBuildStatusIcon() {
        return null;
    }
    
    public final void start() {
    }
    
    public final void stop() {
    }
    
    public final void onClick() {
    }
    
    @org.jetbrains.annotations.Nullable()
    final java.lang.Object fetchLastBuild(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.experimental.Continuation<? super io.stanwood.bitrise.data.model.Build> p0) {
        return null;
    }
    
    public AppViewModel(@org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.net.BitriseService service, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    android.content.res.Resources resources, @org.jetbrains.annotations.NotNull()
    ru.terrakok.cicerone.Router router, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.model.App app) {
        super();
    }
}
package io.stanwood.bitrise.ui.artifacts.vm;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\'H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180+H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,J\b\u0010-\u001a\u00020.H\u0002J\u000e\u0010/\u001a\u00020.2\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020.J\b\u00103\u001a\u00020.H\u0007J\b\u00104\u001a\u00020.H\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\t\u00a8\u00065"}, d2 = {"Lio/stanwood/bitrise/ui/artifacts/vm/ArtifactsViewModel;", "Landroid/arch/lifecycle/LifecycleObserver;", "Landroid/databinding/BaseObservable;", "router", "Lru/terrakok/cicerone/Router;", "service", "Lio/stanwood/bitrise/data/net/BitriseService;", "token", "", "activity", "Lio/stanwood/bitrise/PermissionActivity;", "app", "Lio/stanwood/bitrise/data/model/App;", "build", "Lio/stanwood/bitrise/data/model/Build;", "(Lru/terrakok/cicerone/Router;Lio/stanwood/bitrise/data/net/BitriseService;Ljava/lang/String;Lio/stanwood/bitrise/PermissionActivity;Lio/stanwood/bitrise/data/model/App;Lio/stanwood/bitrise/data/model/Build;)V", "deferred", "Lkotlinx/coroutines/experimental/Deferred;", "", "isLoading", "Landroid/databinding/ObservableBoolean;", "()Landroid/databinding/ObservableBoolean;", "items", "Landroid/databinding/ObservableArrayList;", "Lio/stanwood/bitrise/ui/artifacts/vm/ArtifactItemViewModel;", "getItems", "()Landroid/databinding/ObservableArrayList;", "log", "Landroid/databinding/ObservableField;", "getLog", "()Landroid/databinding/ObservableField;", "setLog", "(Landroid/databinding/ObservableField;)V", "nextCursor", "shouldLoadMoreItems", "", "getShouldLoadMoreItems", "()Z", "fetchArtifact", "Lio/stanwood/bitrise/data/model/Artifact;", "artifact", "(Lio/stanwood/bitrise/data/model/Artifact;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "fetchItems", "", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "loadMoreItems", "", "onEndOfListReached", "itemCount", "", "onRefresh", "start", "stop", "app_debug"})
public final class ArtifactsViewModel extends android.databinding.BaseObservable implements android.arch.lifecycle.LifecycleObserver {
    @org.jetbrains.annotations.NotNull()
    private final android.databinding.ObservableBoolean isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private android.databinding.ObservableField<java.lang.String> log;
    @org.jetbrains.annotations.NotNull()
    private final android.databinding.ObservableArrayList<io.stanwood.bitrise.ui.artifacts.vm.ArtifactItemViewModel> items = null;
    private kotlinx.coroutines.experimental.Deferred<? extends java.lang.Object> deferred;
    private java.lang.String nextCursor;
    private final ru.terrakok.cicerone.Router router = null;
    private final io.stanwood.bitrise.data.net.BitriseService service = null;
    private final java.lang.String token = null;
    private final io.stanwood.bitrise.PermissionActivity activity = null;
    private final io.stanwood.bitrise.data.model.App app = null;
    private final io.stanwood.bitrise.data.model.Build build = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.databinding.ObservableBoolean isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.databinding.ObservableField<java.lang.String> getLog() {
        return null;
    }
    
    public final void setLog(@org.jetbrains.annotations.NotNull()
    android.databinding.ObservableField<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.databinding.ObservableArrayList<io.stanwood.bitrise.ui.artifacts.vm.ArtifactItemViewModel> getItems() {
        return null;
    }
    
    private final boolean getShouldLoadMoreItems() {
        return false;
    }
    
    @android.arch.lifecycle.OnLifecycleEvent(value = android.arch.lifecycle.Lifecycle.Event.ON_CREATE)
    public final void start() {
    }
    
    @android.arch.lifecycle.OnLifecycleEvent(value = android.arch.lifecycle.Lifecycle.Event.ON_DESTROY)
    public final void stop() {
    }
    
    public final void onRefresh() {
    }
    
    public final void onEndOfListReached(int itemCount) {
    }
    
    private final void loadMoreItems() {
    }
    
    @org.jetbrains.annotations.Nullable()
    final java.lang.Object fetchItems(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.experimental.Continuation<? super java.util.List<io.stanwood.bitrise.ui.artifacts.vm.ArtifactItemViewModel>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    final java.lang.Object fetchArtifact(@org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.model.Artifact artifact, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.experimental.Continuation<? super io.stanwood.bitrise.data.model.Artifact> p1) {
        return null;
    }
    
    public ArtifactsViewModel(@org.jetbrains.annotations.NotNull()
    ru.terrakok.cicerone.Router router, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.net.BitriseService service, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.PermissionActivity activity, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.model.App app, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.model.Build build) {
        super();
    }
}
package io.stanwood.bitrise.ui.builds.vm;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170#H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J\b\u0010%\u001a\u00020&H\u0002J\u000e\u0010\'\u001a\u00020&2\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020&J\b\u0010+\u001a\u00020&H\u0007J\b\u0010,\u001a\u00020&H\u0007R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\t\u00a8\u0006-"}, d2 = {"Lio/stanwood/bitrise/ui/builds/vm/BuildsViewModel;", "Landroid/arch/lifecycle/LifecycleObserver;", "router", "Lru/terrakok/cicerone/Router;", "service", "Lio/stanwood/bitrise/data/net/BitriseService;", "token", "", "resources", "Landroid/content/res/Resources;", "periodFormatter", "Lorg/joda/time/format/PeriodFormatter;", "app", "Lio/stanwood/bitrise/data/model/App;", "(Lru/terrakok/cicerone/Router;Lio/stanwood/bitrise/data/net/BitriseService;Ljava/lang/String;Landroid/content/res/Resources;Lorg/joda/time/format/PeriodFormatter;Lio/stanwood/bitrise/data/model/App;)V", "deferred", "Lkotlinx/coroutines/experimental/Deferred;", "", "isLoading", "Landroid/databinding/ObservableBoolean;", "()Landroid/databinding/ObservableBoolean;", "items", "Landroid/databinding/ObservableArrayList;", "Lio/stanwood/bitrise/ui/builds/vm/BuildItemViewModel;", "getItems", "()Landroid/databinding/ObservableArrayList;", "nextCursor", "shouldLoadMoreItems", "", "getShouldLoadMoreItems", "()Z", "title", "getTitle", "()Ljava/lang/String;", "fetchItems", "", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "loadMoreItems", "", "onEndOfListReached", "itemCount", "", "onRefresh", "start", "stop", "app_debug"})
public final class BuildsViewModel implements android.arch.lifecycle.LifecycleObserver {
    @org.jetbrains.annotations.NotNull()
    private final android.databinding.ObservableBoolean isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final android.databinding.ObservableArrayList<io.stanwood.bitrise.ui.builds.vm.BuildItemViewModel> items = null;
    private kotlinx.coroutines.experimental.Deferred<? extends java.lang.Object> deferred;
    private java.lang.String nextCursor;
    private final ru.terrakok.cicerone.Router router = null;
    private final io.stanwood.bitrise.data.net.BitriseService service = null;
    private final java.lang.String token = null;
    private final android.content.res.Resources resources = null;
    private final org.joda.time.format.PeriodFormatter periodFormatter = null;
    private final io.stanwood.bitrise.data.model.App app = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.databinding.ObservableBoolean isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.databinding.ObservableArrayList<io.stanwood.bitrise.ui.builds.vm.BuildItemViewModel> getItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
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
    kotlin.coroutines.experimental.Continuation<? super java.util.List<io.stanwood.bitrise.ui.builds.vm.BuildItemViewModel>> p0) {
        return null;
    }
    
    public BuildsViewModel(@org.jetbrains.annotations.NotNull()
    ru.terrakok.cicerone.Router router, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.net.BitriseService service, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    android.content.res.Resources resources, @org.jetbrains.annotations.NotNull()
    org.joda.time.format.PeriodFormatter periodFormatter, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.model.App app) {
        super();
    }
}
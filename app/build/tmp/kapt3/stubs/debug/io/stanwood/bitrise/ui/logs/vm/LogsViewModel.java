package io.stanwood.bitrise.ui.logs.vm;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u0011\u0010\u001a\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001dH\u0007J\b\u0010\u001f\u001a\u00020\u001dH\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\t\u00a8\u0006 "}, d2 = {"Lio/stanwood/bitrise/ui/logs/vm/LogsViewModel;", "Landroid/arch/lifecycle/LifecycleObserver;", "Landroid/databinding/BaseObservable;", "service", "Lio/stanwood/bitrise/data/net/BitriseService;", "token", "", "router", "Lru/terrakok/cicerone/Router;", "app", "Lio/stanwood/bitrise/data/model/App;", "build", "Lio/stanwood/bitrise/data/model/Build;", "(Lio/stanwood/bitrise/data/net/BitriseService;Ljava/lang/String;Lru/terrakok/cicerone/Router;Lio/stanwood/bitrise/data/model/App;Lio/stanwood/bitrise/data/model/Build;)V", "deferred", "Lkotlinx/coroutines/experimental/Deferred;", "", "isLoading", "Landroid/databinding/ObservableBoolean;", "()Landroid/databinding/ObservableBoolean;", "log", "Landroid/databinding/ObservableField;", "getLog", "()Landroid/databinding/ObservableField;", "setLog", "(Landroid/databinding/ObservableField;)V", "fetchLog", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "onRefresh", "", "start", "stop", "app_debug"})
public final class LogsViewModel extends android.databinding.BaseObservable implements android.arch.lifecycle.LifecycleObserver {
    @org.jetbrains.annotations.NotNull()
    private final android.databinding.ObservableBoolean isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private android.databinding.ObservableField<java.lang.String> log;
    private kotlinx.coroutines.experimental.Deferred<? extends java.lang.Object> deferred;
    private final io.stanwood.bitrise.data.net.BitriseService service = null;
    private final java.lang.String token = null;
    private final ru.terrakok.cicerone.Router router = null;
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
    
    @android.arch.lifecycle.OnLifecycleEvent(value = android.arch.lifecycle.Lifecycle.Event.ON_CREATE)
    public final void start() {
    }
    
    @android.arch.lifecycle.OnLifecycleEvent(value = android.arch.lifecycle.Lifecycle.Event.ON_DESTROY)
    public final void stop() {
    }
    
    public final void onRefresh() {
    }
    
    @org.jetbrains.annotations.Nullable()
    final java.lang.Object fetchLog(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.experimental.Continuation<? super java.lang.String> p0) {
        return null;
    }
    
    public LogsViewModel(@org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.net.BitriseService service, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    ru.terrakok.cicerone.Router router, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.model.App app, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.model.Build build) {
        super();
    }
}
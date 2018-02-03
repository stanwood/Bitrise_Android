package io.stanwood.bitrise.ui.login.vm;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012J\b\u0010\u001b\u001a\u00020\u0019H\u0007J\b\u0010\u001c\u001a\u00020\u0019H\u0007J\u0019\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eR\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128G@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\t\u00a8\u0006\u001f"}, d2 = {"Lio/stanwood/bitrise/ui/login/vm/LoginViewModel;", "Landroid/arch/lifecycle/LifecycleObserver;", "Landroid/databinding/BaseObservable;", "service", "Lio/stanwood/bitrise/data/net/BitriseService;", "router", "Lru/terrakok/cicerone/Router;", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Lio/stanwood/bitrise/data/net/BitriseService;Lru/terrakok/cicerone/Router;Landroid/content/SharedPreferences;)V", "deferred", "Lkotlinx/coroutines/experimental/Deferred;", "", "isError", "Landroid/databinding/ObservableBoolean;", "()Landroid/databinding/ObservableBoolean;", "isLoading", "value", "", "token", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "onTokenEntered", "", "newToken", "start", "stop", "tryLogin", "(Ljava/lang/String;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class LoginViewModel extends android.databinding.BaseObservable implements android.arch.lifecycle.LifecycleObserver {
    @org.jetbrains.annotations.NotNull()
    private final android.databinding.ObservableBoolean isError = null;
    @org.jetbrains.annotations.NotNull()
    private final android.databinding.ObservableBoolean isLoading = null;
    private kotlinx.coroutines.experimental.Deferred<? extends java.lang.Object> deferred;
    private final io.stanwood.bitrise.data.net.BitriseService service = null;
    private final ru.terrakok.cicerone.Router router = null;
    private final android.content.SharedPreferences sharedPreferences = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.databinding.ObservableBoolean isError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.databinding.ObservableBoolean isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @android.databinding.Bindable()
    public final java.lang.String getToken() {
        return null;
    }
    
    public final void setToken(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @android.arch.lifecycle.OnLifecycleEvent(value = android.arch.lifecycle.Lifecycle.Event.ON_CREATE)
    public final void start() {
    }
    
    @android.arch.lifecycle.OnLifecycleEvent(value = android.arch.lifecycle.Lifecycle.Event.ON_DESTROY)
    public final void stop() {
    }
    
    public final void onTokenEntered(@org.jetbrains.annotations.NotNull()
    java.lang.String newToken) {
    }
    
    @org.jetbrains.annotations.Nullable()
    final java.lang.Object tryLogin(@org.jetbrains.annotations.NotNull()
    java.lang.String newToken, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.experimental.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.net.BitriseService service, @org.jetbrains.annotations.NotNull()
    ru.terrakok.cicerone.Router router, @org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences sharedPreferences) {
        super();
    }
}
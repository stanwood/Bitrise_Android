package io.stanwood.bitrise.ui.build.vm;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u0010H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lio/stanwood/bitrise/ui/build/vm/BuildViewModel;", "Landroid/arch/lifecycle/LifecycleObserver;", "adapter", "Lio/stanwood/bitrise/ui/build/ui/FragmentAdapter;", "app", "Lio/stanwood/bitrise/data/model/App;", "build", "Lio/stanwood/bitrise/data/model/Build;", "(Lio/stanwood/bitrise/ui/build/ui/FragmentAdapter;Lio/stanwood/bitrise/data/model/App;Lio/stanwood/bitrise/data/model/Build;)V", "getAdapter", "()Lio/stanwood/bitrise/ui/build/ui/FragmentAdapter;", "title", "", "getTitle", "()Ljava/lang/String;", "start", "", "stop", "app_debug"})
public final class BuildViewModel implements android.arch.lifecycle.LifecycleObserver {
    @org.jetbrains.annotations.NotNull()
    private final io.stanwood.bitrise.ui.build.ui.FragmentAdapter adapter = null;
    private final io.stanwood.bitrise.data.model.App app = null;
    private final io.stanwood.bitrise.data.model.Build build = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @android.arch.lifecycle.OnLifecycleEvent(value = android.arch.lifecycle.Lifecycle.Event.ON_CREATE)
    public final void start() {
    }
    
    @android.arch.lifecycle.OnLifecycleEvent(value = android.arch.lifecycle.Lifecycle.Event.ON_DESTROY)
    public final void stop() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.stanwood.bitrise.ui.build.ui.FragmentAdapter getAdapter() {
        return null;
    }
    
    public BuildViewModel(@org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.ui.build.ui.FragmentAdapter adapter, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.model.App app, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.model.Build build) {
        super();
    }
}
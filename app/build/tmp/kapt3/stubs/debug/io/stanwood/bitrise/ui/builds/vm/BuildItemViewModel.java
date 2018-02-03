package io.stanwood.bitrise.ui.builds.vm;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u001f\u001a\u00020 R\u0011\u0010\u000b\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0015\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u000eR\u0011\u0010\u001d\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u000e\u00a8\u0006!"}, d2 = {"Lio/stanwood/bitrise/ui/builds/vm/BuildItemViewModel;", "", "resources", "Landroid/content/res/Resources;", "periodFormatter", "Lorg/joda/time/format/PeriodFormatter;", "router", "Lru/terrakok/cicerone/Router;", "build", "Lio/stanwood/bitrise/data/model/Build;", "(Landroid/content/res/Resources;Lorg/joda/time/format/PeriodFormatter;Lru/terrakok/cicerone/Router;Lio/stanwood/bitrise/data/model/Build;)V", "branch", "", "getBranch", "()Ljava/lang/String;", "color", "", "getColor", "()I", "duration", "getDuration", "icon", "Landroid/graphics/drawable/Drawable;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "number", "getNumber", "status", "getStatus", "triggeredAt", "getTriggeredAt", "onClick", "", "app_debug"})
public final class BuildItemViewModel {
    private final android.content.res.Resources resources = null;
    private final org.joda.time.format.PeriodFormatter periodFormatter = null;
    private final ru.terrakok.cicerone.Router router = null;
    private final io.stanwood.bitrise.data.model.Build build = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final int getColor() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTriggeredAt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDuration() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.drawable.Drawable getIcon() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBranch() {
        return null;
    }
    
    public final void onClick() {
    }
    
    public BuildItemViewModel(@org.jetbrains.annotations.NotNull()
    android.content.res.Resources resources, @org.jetbrains.annotations.NotNull()
    org.joda.time.format.PeriodFormatter periodFormatter, @org.jetbrains.annotations.NotNull()
    ru.terrakok.cicerone.Router router, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.model.Build build) {
        super();
    }
}
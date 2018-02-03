package io.stanwood.bitrise.data.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000e0\u000e2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2 = {"Lio/stanwood/bitrise/data/model/BuildStatus;", "", "titleResId", "", "colorResId", "iconResId", "(Ljava/lang/String;IIII)V", "getColor", "resources", "Landroid/content/res/Resources;", "getIcon", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getTitle", "", "IN_PROGRESS", "SUCCESS", "FAILURE", "ABORTED", "app_debug"})
public enum BuildStatus {
    @com.google.gson.annotations.SerializedName(value = "0")
    /*public static final*/ IN_PROGRESS /* = new IN_PROGRESS(0, 0, 0) */,
    @com.google.gson.annotations.SerializedName(value = "1")
    /*public static final*/ SUCCESS /* = new SUCCESS(0, 0, 0) */,
    @com.google.gson.annotations.SerializedName(value = "2")
    /*public static final*/ FAILURE /* = new FAILURE(0, 0, 0) */,
    @com.google.gson.annotations.SerializedName(value = "3")
    /*public static final*/ ABORTED /* = new ABORTED(0, 0, 0) */;
    private final int titleResId = 0;
    private final int colorResId = 0;
    private final int iconResId = 0;
    
    public final java.lang.String getTitle(@org.jetbrains.annotations.NotNull()
    android.content.res.Resources resources) {
        return null;
    }
    
    public final int getColor(@org.jetbrains.annotations.NotNull()
    android.content.res.Resources resources) {
        return 0;
    }
    
    public final android.graphics.drawable.Drawable getIcon(@org.jetbrains.annotations.NotNull()
    android.content.res.Resources resources) {
        return null;
    }
    
    BuildStatus(@android.support.annotation.StringRes()
    int titleResId, @android.support.annotation.ColorRes()
    int colorResId, @android.support.annotation.DrawableRes()
    int iconResId) {
    }
}
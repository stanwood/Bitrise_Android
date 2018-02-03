package io.stanwood.bitrise.data.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\f0\f2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lio/stanwood/bitrise/data/model/ArtifactType;", "", "titleResId", "", "iconResId", "(Ljava/lang/String;III)V", "getIcon", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "resources", "Landroid/content/res/Resources;", "getTitle", "", "FILE", "APK", "app_debug"})
public enum ArtifactType {
    @com.google.gson.annotations.SerializedName(value = "file")
    /*public static final*/ FILE /* = new FILE(0, 0) */,
    @com.google.gson.annotations.SerializedName(value = "android-apk")
    /*public static final*/ APK /* = new APK(0, 0) */;
    private final int titleResId = 0;
    private final int iconResId = 0;
    
    public final java.lang.String getTitle(@org.jetbrains.annotations.NotNull()
    android.content.res.Resources resources) {
        return null;
    }
    
    public final android.graphics.drawable.Drawable getIcon(@org.jetbrains.annotations.NotNull()
    android.content.res.Resources resources) {
        return null;
    }
    
    ArtifactType(@android.support.annotation.StringRes()
    int titleResId, @android.support.annotation.DrawableRes()
    int iconResId) {
    }
}
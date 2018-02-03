package io.stanwood.bitrise.data.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lio/stanwood/bitrise/data/model/Platform;", "", "iconResId", "", "(Ljava/lang/String;II)V", "getIcon", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "resources", "Landroid/content/res/Resources;", "ANDROID", "IOS", "XAMARIN", "MACOS", "app_debug"})
public enum Platform {
    @com.google.gson.annotations.SerializedName(value = "android")
    /*public static final*/ ANDROID /* = new ANDROID(0) */,
    @com.google.gson.annotations.SerializedName(value = "ios")
    /*public static final*/ IOS /* = new IOS(0) */,
    @com.google.gson.annotations.SerializedName(value = "xamarin")
    /*public static final*/ XAMARIN /* = new XAMARIN(0) */,
    @com.google.gson.annotations.SerializedName(value = "macos")
    /*public static final*/ MACOS /* = new MACOS(0) */;
    private final int iconResId = 0;
    
    public final android.graphics.drawable.Drawable getIcon(@org.jetbrains.annotations.NotNull()
    android.content.res.Resources resources) {
        return null;
    }
    
    Platform(@android.support.annotation.DrawableRes()
    int iconResId) {
    }
}
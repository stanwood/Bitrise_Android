package io.stanwood.bitrise.navigation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lio/stanwood/bitrise/navigation/Navigator;", "Lru/terrakok/cicerone/android/SupportAppNavigator;", "activity", "Landroid/support/v4/app/FragmentActivity;", "cointainerId", "", "(Landroid/support/v4/app/FragmentActivity;I)V", "createActivityIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "screenKey", "", "data", "", "createFragment", "Landroid/support/v4/app/Fragment;", "showSystemMessage", "", "message", "app_debug"})
public final class Navigator extends ru.terrakok.cicerone.android.SupportAppNavigator {
    private final android.support.v4.app.FragmentActivity activity = null;
    private final int cointainerId = 0;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected android.content.Intent createActivityIntent(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String screenKey, @org.jetbrains.annotations.Nullable()
    java.lang.Object data) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected android.support.v4.app.Fragment createFragment(@org.jetbrains.annotations.Nullable()
    java.lang.String screenKey, @org.jetbrains.annotations.Nullable()
    java.lang.Object data) {
        return null;
    }
    
    @java.lang.Override()
    protected void showSystemMessage(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    public Navigator(@org.jetbrains.annotations.NotNull()
    android.support.v4.app.FragmentActivity activity, int cointainerId) {
        super(null, 0);
    }
}
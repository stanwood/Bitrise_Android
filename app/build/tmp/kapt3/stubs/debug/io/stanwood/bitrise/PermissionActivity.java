package io.stanwood.bitrise;

import java.lang.System;

@android.annotation.SuppressLint(value = {"Registered"})
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J-\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016\u00a2\u0006\u0002\u0010\u0015J%\u0010\u0016\u001a\u00020\u00072\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J/\u0010\u0016\u001a\u00020\u000e2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u00a2\u0006\u0002\u0010\u0019R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\t\u00a8\u0006\u001a"}, d2 = {"Lio/stanwood/bitrise/PermissionActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "permissionListeners", "", "", "Lkotlinx/coroutines/experimental/CancellableContinuation;", "", "permissionRequestCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "uid", "getUid", "()I", "onRequestPermissionsResult", "", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestPermissions", "([Ljava/lang/String;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "continuation", "([Ljava/lang/String;Lkotlinx/coroutines/experimental/CancellableContinuation;)V", "app_debug"})
public class PermissionActivity extends android.support.v7.app.AppCompatActivity {
    private final java.util.concurrent.atomic.AtomicInteger permissionRequestCounter = null;
    private final java.util.Map<java.lang.Integer, kotlinx.coroutines.experimental.CancellableContinuation<java.lang.Boolean>> permissionListeners = null;
    
    private final int getUid() {
        return 0;
    }
    
    private final void requestPermissions(java.lang.String[] permissions, kotlinx.coroutines.experimental.CancellableContinuation<? super java.lang.Boolean> continuation) {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object requestPermissions(@org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.experimental.Continuation<? super java.lang.Boolean> p1) {
        return null;
    }
    
    public PermissionActivity() {
        super();
    }
}
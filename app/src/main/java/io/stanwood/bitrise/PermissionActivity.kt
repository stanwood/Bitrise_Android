package io.stanwood.bitrise

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.coroutines.experimental.CancellableContinuation
import kotlinx.coroutines.experimental.suspendCancellableCoroutine
import java.util.concurrent.atomic.AtomicInteger

@SuppressLint("Registered")
open class PermissionActivity: AppCompatActivity() {
    private val permissionRequestCounter = AtomicInteger(0)
    private val uid: Int
        get() = permissionRequestCounter.getAndIncrement()
    private val permissionListeners: MutableMap<Int, CancellableContinuation<Boolean>> = mutableMapOf()

    private fun requestPermissions(vararg permissions: String, continuation: CancellableContinuation<Boolean>) {
        val isRequestRequired =
                permissions
                        .map { ContextCompat.checkSelfPermission(this, it) }
                        .any { result -> result == PackageManager.PERMISSION_DENIED }

        if(isRequestRequired) {
            ActivityCompat.requestPermissions(this, permissions, uid)
        } else {
            continuation.resume(true)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val isGranted = grantResults.all { result -> result == PackageManager.PERMISSION_GRANTED }
        permissionListeners
                .remove(requestCode)
                ?.resume(isGranted)
    }

    suspend fun requestPermissions(vararg permissions: String): Boolean =
        suspendCancellableCoroutine { continuation -> requestPermissions(*permissions, continuation = continuation) }
}
/*
 * Copyright 2018 stanwood Gmbh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
/*
 * Copyright (c) 2018 stanwood Gmbh
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.stanwood.bitrise.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Artifact(
        @SerializedName("artifact_type") val artifactType: ArtifactType?, //android-apk
        @SerializedName("expiring_download_url") val expiringDownloadUrl: String, //https://bitrise-prod-build-storage.s3.amazonaws.com/builds/ddf4134555e833d8/artifacts/3205846/app-debug.apk?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAIOC7N256G7J2W2TQ%2F20171122%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20171122T135501Z&X-Amz-Expires=600&X-Amz-SignedHeaders=host&X-Amz-Signature=bad4467b83a1d98a6046b59a1b232bb0888decf203e039c9b3798f7b4950b68c
        @SerializedName("file_size_bytes") val fileSizeBytes: Int, //607185
        @SerializedName("is_public_page_enabled") val isPublicPageEnabled: Boolean, //true
        @SerializedName("public_install_page_url") val publicInstallPageUrl: String?, //https://www.bitrise.io/artifact/3205846/p/300e0121b50985fd631fe304d549006f
        @SerializedName("slug") val slug: String, //5a9f5da8d5f1057c
        @SerializedName("title") val title: String //app-debug.apk
): Parcelable
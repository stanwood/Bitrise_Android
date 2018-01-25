package io.stanwood.bitrise.data.model
import com.google.gson.annotations.SerializedName


data class Log(
		@SerializedName("expiring_raw_log_url") val expiringRawLogUrl: String, //https://bitrise-build-log-archives-production.s3.amazonaws.com/build-logs-v2/669403bffbe35909/3247e2920496e846/2194500/3247e2920496e846.log?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIOC7N256G7J2W2TQ%2F20171122%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20171122T135458Z&X-Amz-Expires=600&X-Amz-SignedHeaders=host&X-Amz-Signature=611793356be42a86b618f53effa74a4297f3970abc2ebc47b8b1a298a29ae649
		@SerializedName("generated_log_chunks_num") val generatedLogChunksNum: Int, //6
		@SerializedName("is_archived") val isArchived: Boolean, //true
		@SerializedName("log_chunks") val logChunks: List<LogChunk>,
		@SerializedName("timestamp") val timestamp: String //2017-05-30T15:47:39.567+00:00
)

data class LogChunk(
		@SerializedName("chunk") val chunk: String,
		@SerializedName("position") val position: Int)
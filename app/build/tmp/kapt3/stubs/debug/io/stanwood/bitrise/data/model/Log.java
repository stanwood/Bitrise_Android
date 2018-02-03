package io.stanwood.bitrise.data.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e\u00a8\u0006\u001f"}, d2 = {"Lio/stanwood/bitrise/data/model/Log;", "", "expiringRawLogUrl", "", "generatedLogChunksNum", "", "isArchived", "", "logChunks", "", "Lio/stanwood/bitrise/data/model/LogChunk;", "timestamp", "(Ljava/lang/String;IZLjava/util/List;Ljava/lang/String;)V", "getExpiringRawLogUrl", "()Ljava/lang/String;", "getGeneratedLogChunksNum", "()I", "()Z", "getLogChunks", "()Ljava/util/List;", "getTimestamp", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Log {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "expiring_raw_log_url")
    private final java.lang.String expiringRawLogUrl = null;
    @com.google.gson.annotations.SerializedName(value = "generated_log_chunks_num")
    private final int generatedLogChunksNum = 0;
    @com.google.gson.annotations.SerializedName(value = "is_archived")
    private final boolean isArchived = false;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "log_chunks")
    private final java.util.List<io.stanwood.bitrise.data.model.LogChunk> logChunks = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "timestamp")
    private final java.lang.String timestamp = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getExpiringRawLogUrl() {
        return null;
    }
    
    public final int getGeneratedLogChunksNum() {
        return 0;
    }
    
    public final boolean isArchived() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<io.stanwood.bitrise.data.model.LogChunk> getLogChunks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTimestamp() {
        return null;
    }
    
    public Log(@org.jetbrains.annotations.NotNull()
    java.lang.String expiringRawLogUrl, int generatedLogChunksNum, boolean isArchived, @org.jetbrains.annotations.NotNull()
    java.util.List<io.stanwood.bitrise.data.model.LogChunk> logChunks, @org.jetbrains.annotations.NotNull()
    java.lang.String timestamp) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final boolean component3() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<io.stanwood.bitrise.data.model.LogChunk> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.stanwood.bitrise.data.model.Log copy(@org.jetbrains.annotations.NotNull()
    java.lang.String expiringRawLogUrl, int generatedLogChunksNum, boolean isArchived, @org.jetbrains.annotations.NotNull()
    java.util.List<io.stanwood.bitrise.data.model.LogChunk> logChunks, @org.jetbrains.annotations.NotNull()
    java.lang.String timestamp) {
        return null;
    }
    
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(java.lang.Object p0) {
        return false;
    }
}
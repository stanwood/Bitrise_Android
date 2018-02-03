package io.stanwood.bitrise.data.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 a2\u00020\u0001:\u0001aB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u00cd\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u001f\u001a\u00020\u000e\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\u0006\u0010!\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\"J\u000b\u0010?\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010@\u001a\u00020\u0013H\u00c6\u0003J\t\u0010A\u001a\u00020\tH\u00c6\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010D\u001a\u00020\u0006H\u00c6\u0003J\t\u0010E\u001a\u00020\u0006H\u00c6\u0003J\t\u0010F\u001a\u00020\u0006H\u00c6\u0003J\t\u0010G\u001a\u00020\u0006H\u00c6\u0003J\t\u0010H\u001a\u00020\u001cH\u00c6\u0003J\t\u0010I\u001a\u00020\u0006H\u00c6\u0003J\t\u0010J\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010L\u001a\u00020\u000eH\u00c6\u0003J\t\u0010M\u001a\u00020\u0006H\u00c6\u0003J\t\u0010N\u001a\u00020\u0006H\u00c6\u0003J\t\u0010O\u001a\u00020\tH\u00c6\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\t\u0010U\u001a\u00020\u0011H\u00c6\u0003J\u00ff\u0001\u0010V\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u0006H\u00c6\u0001J\b\u0010W\u001a\u00020\tH\u0016J\u0013\u0010X\u001a\u00020\u00112\b\u0010Y\u001a\u0004\u0018\u00010ZH\u00d6\u0003J\t\u0010[\u001a\u00020\tH\u00d6\u0001J\t\u0010\\\u001a\u00020\u0006H\u00d6\u0001J\u0018\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\tH\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010$R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010,R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0016\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0016\u0010\u0014\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010.R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010$R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u0016\u0010\u0017\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010$R\u0016\u0010\u0018\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u0016\u0010\u0019\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010$R\u0016\u0010\u001a\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u0016\u0010\u001b\u001a\u00020\u001c8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0016\u0010\u001d\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010$R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010$R\u0016\u0010\u001f\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010*R\u0016\u0010 \u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010$R\u0016\u0010!\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010$\u00a8\u0006b"}, d2 = {"Lio/stanwood/bitrise/data/model/Build;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "abortReason", "", "branch", "number", "", "commitHash", "commitMessage", "commitViewUrl", "environmentPrepareFinishedAt", "Ljava/util/Date;", "finishedAt", "isOnHold", "", "originalBuildParams", "Lio/stanwood/bitrise/data/model/OriginalBuildParams;", "pullRequestId", "pullRequestTargetBranch", "pullRequestViewUrl", "slug", "stackConfigType", "stackIdentifier", "startedOnWorkerAt", "status", "Lio/stanwood/bitrise/data/model/BuildStatus;", "statusText", "tag", "triggeredAt", "triggeredBy", "triggeredWorkflow", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;ZLio/stanwood/bitrise/data/model/OriginalBuildParams;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/stanwood/bitrise/data/model/BuildStatus;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;)V", "getAbortReason", "()Ljava/lang/String;", "getBranch", "getCommitHash", "getCommitMessage", "getCommitViewUrl", "getEnvironmentPrepareFinishedAt", "()Ljava/util/Date;", "getFinishedAt", "()Z", "getNumber", "()I", "getOriginalBuildParams", "()Lio/stanwood/bitrise/data/model/OriginalBuildParams;", "getPullRequestId", "getPullRequestTargetBranch", "getPullRequestViewUrl", "getSlug", "getStackConfigType", "getStackIdentifier", "getStartedOnWorkerAt", "getStatus", "()Lio/stanwood/bitrise/data/model/BuildStatus;", "getStatusText", "getTag", "getTriggeredAt", "getTriggeredBy", "getTriggeredWorkflow", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "flags", "Companion", "app_debug"})
public final class Build implements android.os.Parcelable {
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "abort_reason")
    private final java.lang.String abortReason = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "branch")
    private final java.lang.String branch = null;
    @com.google.gson.annotations.SerializedName(value = "build_number")
    private final int number = 0;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "commit_hash")
    private final java.lang.String commitHash = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "commit_message")
    private final java.lang.String commitMessage = null;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "commit_view_url")
    private final java.lang.String commitViewUrl = null;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "environment_prepare_finished_at")
    private final java.util.Date environmentPrepareFinishedAt = null;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "finished_at")
    private final java.util.Date finishedAt = null;
    @com.google.gson.annotations.SerializedName(value = "is_on_hold")
    private final boolean isOnHold = false;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "original_build_params")
    private final io.stanwood.bitrise.data.model.OriginalBuildParams originalBuildParams = null;
    @com.google.gson.annotations.SerializedName(value = "pull_request_id")
    private final int pullRequestId = 0;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "pull_request_target_branch")
    private final java.lang.String pullRequestTargetBranch = null;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "pull_request_view_url")
    private final java.lang.String pullRequestViewUrl = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "slug")
    private final java.lang.String slug = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "stack_config_type")
    private final java.lang.String stackConfigType = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "stack_identifier")
    private final java.lang.String stackIdentifier = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "started_on_worker_at")
    private final java.lang.String startedOnWorkerAt = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "status")
    private final io.stanwood.bitrise.data.model.BuildStatus status = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "status_text")
    private final java.lang.String statusText = null;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "tag")
    private final java.lang.String tag = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "triggered_at")
    private final java.util.Date triggeredAt = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "triggered_by")
    private final java.lang.String triggeredBy = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "triggered_workflow")
    private final java.lang.String triggeredWorkflow = null;
    @org.jetbrains.annotations.NotNull()
    public static final android.os.Parcelable.Creator<io.stanwood.bitrise.data.model.Build> CREATOR = null;
    public static final io.stanwood.bitrise.data.model.Build.Companion Companion = null;
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel dest, int flags) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAbortReason() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBranch() {
        return null;
    }
    
    public final int getNumber() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCommitHash() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCommitMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCommitViewUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getEnvironmentPrepareFinishedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getFinishedAt() {
        return null;
    }
    
    public final boolean isOnHold() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.stanwood.bitrise.data.model.OriginalBuildParams getOriginalBuildParams() {
        return null;
    }
    
    public final int getPullRequestId() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPullRequestTargetBranch() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPullRequestViewUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSlug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStackConfigType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStackIdentifier() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStartedOnWorkerAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.stanwood.bitrise.data.model.BuildStatus getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatusText() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTag() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getTriggeredAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTriggeredBy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTriggeredWorkflow() {
        return null;
    }
    
    public Build(@org.jetbrains.annotations.Nullable()
    java.lang.String abortReason, @org.jetbrains.annotations.NotNull()
    java.lang.String branch, int number, @org.jetbrains.annotations.Nullable()
    java.lang.String commitHash, @org.jetbrains.annotations.NotNull()
    java.lang.String commitMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String commitViewUrl, @org.jetbrains.annotations.Nullable()
    java.util.Date environmentPrepareFinishedAt, @org.jetbrains.annotations.Nullable()
    java.util.Date finishedAt, boolean isOnHold, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.model.OriginalBuildParams originalBuildParams, int pullRequestId, @org.jetbrains.annotations.Nullable()
    java.lang.String pullRequestTargetBranch, @org.jetbrains.annotations.Nullable()
    java.lang.String pullRequestViewUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String slug, @org.jetbrains.annotations.NotNull()
    java.lang.String stackConfigType, @org.jetbrains.annotations.NotNull()
    java.lang.String stackIdentifier, @org.jetbrains.annotations.NotNull()
    java.lang.String startedOnWorkerAt, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.model.BuildStatus status, @org.jetbrains.annotations.NotNull()
    java.lang.String statusText, @org.jetbrains.annotations.Nullable()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.util.Date triggeredAt, @org.jetbrains.annotations.NotNull()
    java.lang.String triggeredBy, @org.jetbrains.annotations.NotNull()
    java.lang.String triggeredWorkflow) {
        super();
    }
    
    public Build(@org.jetbrains.annotations.NotNull()
    android.os.Parcel source) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date component8() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.stanwood.bitrise.data.model.OriginalBuildParams component10() {
        return null;
    }
    
    public final int component11() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.stanwood.bitrise.data.model.BuildStatus component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component22() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.stanwood.bitrise.data.model.Build copy(@org.jetbrains.annotations.Nullable()
    java.lang.String abortReason, @org.jetbrains.annotations.NotNull()
    java.lang.String branch, int number, @org.jetbrains.annotations.Nullable()
    java.lang.String commitHash, @org.jetbrains.annotations.NotNull()
    java.lang.String commitMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String commitViewUrl, @org.jetbrains.annotations.Nullable()
    java.util.Date environmentPrepareFinishedAt, @org.jetbrains.annotations.Nullable()
    java.util.Date finishedAt, boolean isOnHold, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.model.OriginalBuildParams originalBuildParams, int pullRequestId, @org.jetbrains.annotations.Nullable()
    java.lang.String pullRequestTargetBranch, @org.jetbrains.annotations.Nullable()
    java.lang.String pullRequestViewUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String slug, @org.jetbrains.annotations.NotNull()
    java.lang.String stackConfigType, @org.jetbrains.annotations.NotNull()
    java.lang.String stackIdentifier, @org.jetbrains.annotations.NotNull()
    java.lang.String startedOnWorkerAt, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.data.model.BuildStatus status, @org.jetbrains.annotations.NotNull()
    java.lang.String statusText, @org.jetbrains.annotations.Nullable()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.util.Date triggeredAt, @org.jetbrains.annotations.NotNull()
    java.lang.String triggeredBy, @org.jetbrains.annotations.NotNull()
    java.lang.String triggeredWorkflow) {
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
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lio/stanwood/bitrise/data/model/Build$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lio/stanwood/bitrise/data/model/Build;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}
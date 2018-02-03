package io.stanwood.bitrise.data.net;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0003\u0010\n\u001a\u00020\u000bH\'J<\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\bH\'JN\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\u000f\u001a\u00020\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0003\u0010\n\u001a\u00020\u000bH\'JB\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\u0014\u001a\u00020\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0003\u0010\n\u001a\u00020\u000bH\'JD\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u000e\u001a\u00020\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0003\u0010\n\u001a\u00020\u000bH\'J\u001e\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH\'\u00a8\u0006\u0019"}, d2 = {"Lio/stanwood/bitrise/data/net/BitriseService;", "", "getApps", "Lkotlinx/coroutines/experimental/Deferred;", "Lio/stanwood/bitrise/data/model/Response;", "", "Lio/stanwood/bitrise/data/model/App;", "token", "", "cursor", "limit", "", "getBuildArtifact", "Lio/stanwood/bitrise/data/model/Artifact;", "appSlug", "buildSlug", "artifactSlug", "getBuildArtifacts", "getBuildLog", "Lio/stanwood/bitrise/data/model/Log;", "buildLog", "getBuilds", "Lio/stanwood/bitrise/data/model/Build;", "login", "Lio/stanwood/bitrise/data/model/Me;", "app_debug"})
public abstract interface BitriseService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v0.1/me")
    public abstract kotlinx.coroutines.experimental.Deferred<io.stanwood.bitrise.data.model.Response<io.stanwood.bitrise.data.model.Me>> login(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v0.1/me/apps")
    public abstract kotlinx.coroutines.experimental.Deferred<io.stanwood.bitrise.data.model.Response<java.util.List<io.stanwood.bitrise.data.model.App>>> getApps(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "next")
    java.lang.String cursor, @retrofit2.http.Query(value = "limit")
    int limit);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v0.1/apps/{APP-SLUG}/builds")
    public abstract kotlinx.coroutines.experimental.Deferred<io.stanwood.bitrise.data.model.Response<java.util.List<io.stanwood.bitrise.data.model.Build>>> getBuilds(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "APP-SLUG")
    java.lang.String appSlug, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "next")
    java.lang.String cursor, @retrofit2.http.Query(value = "limit")
    int limit);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v0.1/apps/{APP-SLUG}/builds/{BUILD-SLUG}/log")
    public abstract kotlinx.coroutines.experimental.Deferred<io.stanwood.bitrise.data.model.Log> getBuildLog(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "APP-SLUG")
    java.lang.String appSlug, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "BUILD-SLUG")
    java.lang.String buildLog, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "next")
    java.lang.String cursor, @retrofit2.http.Query(value = "limit")
    int limit);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v0.1/apps/{APP-SLUG}/builds/{BUILD-SLUG}/artifacts")
    public abstract kotlinx.coroutines.experimental.Deferred<io.stanwood.bitrise.data.model.Response<java.util.List<io.stanwood.bitrise.data.model.Artifact>>> getBuildArtifacts(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "APP-SLUG")
    java.lang.String appSlug, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "BUILD-SLUG")
    java.lang.String buildSlug, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "next")
    java.lang.String cursor, @retrofit2.http.Query(value = "limit")
    int limit);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v0.1/apps/{APP-SLUG}/builds/{BUILD-SLUG}/artifacts/{ARTIFACT-SLUG}")
    public abstract kotlinx.coroutines.experimental.Deferred<io.stanwood.bitrise.data.model.Response<io.stanwood.bitrise.data.model.Artifact>> getBuildArtifact(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "APP-SLUG")
    java.lang.String appSlug, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "BUILD-SLUG")
    java.lang.String buildSlug, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "ARTIFACT-SLUG")
    java.lang.String artifactSlug);
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 3)
    public final class DefaultImpls {
    }
}
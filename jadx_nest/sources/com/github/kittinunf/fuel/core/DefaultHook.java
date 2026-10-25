package com.github.kittinunf.fuel.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultHook.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/github/kittinunf/fuel/core/DefaultHook;", "Lcom/github/kittinunf/fuel/core/Client$Hook;", "()V", "httpExchangeFailed", "", "request", "Lcom/github/kittinunf/fuel/core/Request;", "exception", "Ljava/io/IOException;", "interpretResponseStream", "Ljava/io/InputStream;", "inputStream", "postConnect", "preConnect", "connection", "Ljava/net/HttpURLConnection;", "fuel"}, k = 1, mv = {1, 4, 0})
public final class DefaultHook implements Client.Hook {
    @Override // com.github.kittinunf.fuel.core.Client.Hook
    public void httpExchangeFailed(Request request, IOException exception) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(exception, "exception");
    }

    @Override // com.github.kittinunf.fuel.core.Client.Hook
    public InputStream interpretResponseStream(Request request, InputStream inputStream) {
        Intrinsics.checkNotNullParameter(request, "request");
        return inputStream;
    }

    @Override // com.github.kittinunf.fuel.core.Client.Hook
    public void postConnect(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
    }

    @Override // com.github.kittinunf.fuel.core.Client.Hook
    public void preConnect(HttpURLConnection connection, Request request) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(request, "request");
    }
}

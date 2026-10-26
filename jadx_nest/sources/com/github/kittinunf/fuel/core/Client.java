package com.github.kittinunf.fuel.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* INFO: compiled from: Client.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/github/kittinunf/fuel/core/Client;", "", "awaitRequest", "Lcom/github/kittinunf/fuel/core/Response;", "request", "Lcom/github/kittinunf/fuel/core/Request;", "(Lcom/github/kittinunf/fuel/core/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeRequest", "Hook", "fuel"}, k = 1, mv = {1, 4, 0})
public interface Client {

    /* INFO: compiled from: Client.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/github/kittinunf/fuel/core/Client$Hook;", "", "httpExchangeFailed", "", "request", "Lcom/github/kittinunf/fuel/core/Request;", "exception", "Ljava/io/IOException;", "interpretResponseStream", "Ljava/io/InputStream;", "inputStream", "postConnect", "preConnect", "connection", "Ljava/net/HttpURLConnection;", "fuel"}, k = 1, mv = {1, 4, 0})
    public interface Hook {
        void httpExchangeFailed(Request request, IOException exception);

        InputStream interpretResponseStream(Request request, InputStream inputStream);

        void postConnect(Request request);

        void preConnect(HttpURLConnection connection, Request request);
    }

    Object awaitRequest(Request request, Continuation<? super Response> continuation);

    Response executeRequest(Request request);

    /* INFO: compiled from: Client.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static Object awaitRequest(Client client, Request request, Continuation<? super Response> continuation) {
            return client.executeRequest(request);
        }
    }
}

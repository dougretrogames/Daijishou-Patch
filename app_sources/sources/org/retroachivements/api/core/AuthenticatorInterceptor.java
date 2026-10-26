package org.retroachivements.api.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.retroachivements.api.data.RetroCredentials;

/* INFO: compiled from: AuthenticatorInterceptor.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lorg/retroachivements/api/core/AuthenticatorInterceptor;", "Lokhttp3/Interceptor;", "retroCredentials", "Lorg/retroachivements/api/data/RetroCredentials;", "(Lorg/retroachivements/api/data/RetroCredentials;)V", "createAuthenticatedRequest", "Lokhttp3/Request;", "request", "authenticatedUrl", "Lokhttp3/HttpUrl;", "createAuthenticatedUrl", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AuthenticatorInterceptor implements Interceptor {
    private final RetroCredentials retroCredentials;

    public AuthenticatorInterceptor(RetroCredentials retroCredentials) {
        Intrinsics.checkNotNullParameter(retroCredentials, "retroCredentials");
        this.retroCredentials = retroCredentials;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        return chain.proceed(createAuthenticatedRequest(request, createAuthenticatedUrl(request)));
    }

    private final Request createAuthenticatedRequest(Request request, HttpUrl authenticatedUrl) {
        return request.newBuilder().url(authenticatedUrl).build();
    }

    private final HttpUrl createAuthenticatedUrl(Request request) {
        HttpUrl httpUrl = HttpUrl.INSTANCE.parse(request.url().getUrl());
        if (httpUrl == null) {
            throw new IllegalArgumentException("Invalid URL: " + request.url());
        }
        return httpUrl.newBuilder().addQueryParameter("z", this.retroCredentials.getUsername()).addQueryParameter("y", this.retroCredentials.getApiKey()).build();
    }
}

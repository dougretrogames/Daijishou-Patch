package com.google.api.client.http;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface HttpResponseInterceptor {
    void interceptResponse(HttpResponse httpResponse) throws IOException;
}

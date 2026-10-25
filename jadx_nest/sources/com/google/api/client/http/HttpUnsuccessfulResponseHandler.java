package com.google.api.client.http;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface HttpUnsuccessfulResponseHandler {
    boolean handleResponse(HttpRequest httpRequest, HttpResponse httpResponse, boolean z) throws IOException;
}

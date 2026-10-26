package com.google.api.client.http;

import java.io.IOException;

/* INFO: loaded from: classes3.dex */
public interface HttpIOExceptionHandler {
    boolean handleIOException(HttpRequest httpRequest, boolean z) throws IOException;
}

package com.google.api.client.util;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface StreamingContent {
    void writeTo(OutputStream outputStream) throws IOException;
}

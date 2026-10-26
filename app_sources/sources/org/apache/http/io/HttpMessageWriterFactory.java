package org.apache.http.io;

import org.apache.http.HttpMessage;

/* INFO: loaded from: classes5.dex */
public interface HttpMessageWriterFactory<T extends HttpMessage> {
    HttpMessageWriter<T> create(SessionOutputBuffer sessionOutputBuffer);
}

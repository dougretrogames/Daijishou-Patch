package org.eclipse.jgit.transport.http;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;

/* INFO: loaded from: classes5.dex */
public interface HttpConnectionFactory {
    HttpConnection create(URL url) throws IOException;

    HttpConnection create(URL url, Proxy proxy) throws IOException;
}

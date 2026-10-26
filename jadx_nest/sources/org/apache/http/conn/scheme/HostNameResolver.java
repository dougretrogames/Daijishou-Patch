package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.InetAddress;

/* INFO: loaded from: classes5.dex */
@Deprecated
public interface HostNameResolver {
    InetAddress resolve(String str) throws IOException;
}

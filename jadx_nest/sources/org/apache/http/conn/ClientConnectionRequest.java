package org.apache.http.conn;

import java.util.concurrent.TimeUnit;

/* INFO: loaded from: classes5.dex */
@Deprecated
public interface ClientConnectionRequest {
    void abortRequest();

    ManagedClientConnection getConnection(long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException;
}

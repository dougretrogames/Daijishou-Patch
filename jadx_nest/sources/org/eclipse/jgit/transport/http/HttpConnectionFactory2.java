package org.eclipse.jgit.transport.http;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpConnectionFactory2 extends HttpConnectionFactory {

    public interface GitSession {
        void close();

        HttpConnection configure(HttpConnection httpConnection, boolean z) throws GeneralSecurityException, IOException;
    }

    GitSession newSession();
}

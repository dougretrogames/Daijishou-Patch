package org.eclipse.jgit.transport;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.http.HttpConnectionFactory;
import org.eclipse.jgit.transport.http.JDKHttpConnectionFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HttpTransport extends Transport {
    protected static volatile HttpConnectionFactory connectionFactory = new JDKHttpConnectionFactory();

    public static HttpConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    public static void setConnectionFactory(HttpConnectionFactory httpConnectionFactory) {
        connectionFactory = httpConnectionFactory;
    }

    protected HttpTransport(Repository repository, URIish uRIish) {
        super(repository, uRIish);
    }

    protected HttpTransport(URIish uRIish) {
        super(uRIish);
    }
}

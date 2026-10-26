package org.eclipse.jgit.transport;

import java.util.Collection;
import java.util.Map;
import org.eclipse.jgit.lib.Ref;

/* INFO: loaded from: classes5.dex */
public interface Connection extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    String getMessages();

    String getPeerUserAgent();

    Ref getRef(String str);

    Collection<Ref> getRefs();

    Map<String, Ref> getRefsMap();
}

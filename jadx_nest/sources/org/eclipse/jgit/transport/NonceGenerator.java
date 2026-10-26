package org.eclipse.jgit.transport;

import org.eclipse.jgit.lib.Repository;

/* INFO: loaded from: classes5.dex */
public interface NonceGenerator {
    String createNonce(Repository repository, long j);

    PushCertificate.NonceStatus verify(String str, String str2, Repository repository, boolean z, int i);
}

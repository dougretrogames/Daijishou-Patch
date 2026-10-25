package org.eclipse.jgit.transport;

import java.util.Comparator;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class PushCertificateStore$$ExternalSyntheticLambda0 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return Long.signum(((PushCertificateStore.PendingCert) obj).ident.getWhen().getTime() - ((PushCertificateStore.PendingCert) obj2).ident.getWhen().getTime());
    }
}

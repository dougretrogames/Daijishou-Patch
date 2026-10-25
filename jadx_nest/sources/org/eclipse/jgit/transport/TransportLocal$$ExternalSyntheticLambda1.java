package org.eclipse.jgit.transport;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.resolver.UploadPackFactory;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class TransportLocal$$ExternalSyntheticLambda1 implements UploadPackFactory {
    public final /* synthetic */ TransportLocal f$0;

    public /* synthetic */ TransportLocal$$ExternalSyntheticLambda1(TransportLocal transportLocal) {
        this.f$0 = transportLocal;
    }

    @Override // org.eclipse.jgit.transport.resolver.UploadPackFactory
    public final UploadPack create(Object obj, Repository repository) {
        return this.f$0.m5845lambda$0$orgeclipsejgittransportTransportLocal((Void) obj, repository);
    }
}

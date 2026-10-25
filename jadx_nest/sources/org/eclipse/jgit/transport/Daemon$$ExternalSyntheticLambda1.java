package org.eclipse.jgit.transport;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.resolver.ReceivePackFactory;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Daemon$$ExternalSyntheticLambda1 implements ReceivePackFactory {
    public final /* synthetic */ Daemon f$0;

    public /* synthetic */ Daemon$$ExternalSyntheticLambda1(Daemon daemon) {
        this.f$0 = daemon;
    }

    @Override // org.eclipse.jgit.transport.resolver.ReceivePackFactory
    public final ReceivePack create(Object obj, Repository repository) {
        return this.f$0.m5804lambda$1$orgeclipsejgittransportDaemon((DaemonClient) obj, repository);
    }
}

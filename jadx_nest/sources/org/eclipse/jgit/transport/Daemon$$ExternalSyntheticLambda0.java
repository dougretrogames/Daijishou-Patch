package org.eclipse.jgit.transport;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.resolver.UploadPackFactory;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Daemon$$ExternalSyntheticLambda0 implements UploadPackFactory {
    public final /* synthetic */ Daemon f$0;

    public /* synthetic */ Daemon$$ExternalSyntheticLambda0(Daemon daemon) {
        this.f$0 = daemon;
    }

    @Override // org.eclipse.jgit.transport.resolver.UploadPackFactory
    public final UploadPack create(Object obj, Repository repository) {
        return this.f$0.m5803lambda$0$orgeclipsejgittransportDaemon((DaemonClient) obj, repository);
    }
}

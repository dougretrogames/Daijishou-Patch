package org.eclipse.jgit.transport.resolver;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.ReceivePack;

/* JADX INFO: loaded from: classes5.dex */
public interface ReceivePackFactory<C> {
    public static final ReceivePackFactory<?> DISABLED = new ReceivePackFactory$$ExternalSyntheticLambda0();

    ReceivePack create(C c, Repository repository) throws ServiceNotEnabledException, ServiceNotAuthorizedException;

    static /* synthetic */ ReceivePack lambda$0(Object obj, Repository repository) throws ServiceNotEnabledException, ServiceNotAuthorizedException {
        throw new ServiceNotEnabledException();
    }
}

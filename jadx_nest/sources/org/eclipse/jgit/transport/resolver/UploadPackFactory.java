package org.eclipse.jgit.transport.resolver;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UploadPack;

/* INFO: loaded from: classes5.dex */
public interface UploadPackFactory<C> {
    public static final UploadPackFactory<?> DISABLED = new UploadPackFactory$$ExternalSyntheticLambda0();

    UploadPack create(C c, Repository repository) throws ServiceNotEnabledException, ServiceNotAuthorizedException;

    static /* synthetic */ UploadPack lambda$0(Object obj, Repository repository) throws ServiceNotEnabledException, ServiceNotAuthorizedException {
        throw new ServiceNotEnabledException();
    }
}

package org.eclipse.jgit.transport;

import java.io.OutputStream;
import java.util.Collection;
import java.util.Set;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;

/* INFO: loaded from: classes5.dex */
abstract class BaseFetchConnection extends BaseConnection implements FetchConnection {
    @Override // org.eclipse.jgit.transport.FetchConnection
    public boolean didFetchIncludeTags() {
        return false;
    }

    protected abstract void doFetch(ProgressMonitor progressMonitor, Collection<Ref> collection, Set<ObjectId> set) throws TransportException;

    BaseFetchConnection() {
    }

    @Override // org.eclipse.jgit.transport.FetchConnection
    public final void fetch(ProgressMonitor progressMonitor, Collection<Ref> collection, Set<ObjectId> set) throws TransportException {
        fetch(progressMonitor, collection, set, null);
    }

    @Override // org.eclipse.jgit.transport.FetchConnection
    public final void fetch(ProgressMonitor progressMonitor, Collection<Ref> collection, Set<ObjectId> set, OutputStream outputStream) throws TransportException {
        markStartedOperation();
        doFetch(progressMonitor, collection, set);
    }
}

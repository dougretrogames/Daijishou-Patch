package org.eclipse.jgit.transport;

import java.io.OutputStream;
import java.util.Collection;
import java.util.Set;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;

/* JADX INFO: loaded from: classes5.dex */
public interface FetchConnection extends Connection {
    boolean didFetchIncludeTags();

    boolean didFetchTestConnectivity();

    void fetch(ProgressMonitor progressMonitor, Collection<Ref> collection, Set<ObjectId> set) throws TransportException;

    void fetch(ProgressMonitor progressMonitor, Collection<Ref> collection, Set<ObjectId> set, OutputStream outputStream) throws TransportException;

    Collection<PackLock> getPackLocks();

    void setPackLockMessage(String str);
}

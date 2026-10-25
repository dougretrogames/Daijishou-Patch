package org.eclipse.jgit.internal.storage.dfs;

import org.eclipse.jgit.events.RepositoryEvent;

/* JADX INFO: loaded from: classes5.dex */
public class BeforeDfsPackIndexLoadedEvent extends RepositoryEvent<BeforeDfsPackIndexLoadedListener> {
    private final DfsPackFile pack;

    public BeforeDfsPackIndexLoadedEvent(DfsPackFile dfsPackFile) {
        this.pack = dfsPackFile;
    }

    public DfsPackFile getPackFile() {
        return this.pack;
    }

    @Override // org.eclipse.jgit.events.RepositoryEvent
    public Class<BeforeDfsPackIndexLoadedListener> getListenerType() {
        return BeforeDfsPackIndexLoadedListener.class;
    }

    @Override // org.eclipse.jgit.events.RepositoryEvent
    public void dispatch(BeforeDfsPackIndexLoadedListener beforeDfsPackIndexLoadedListener) {
        beforeDfsPackIndexLoadedListener.onBeforeDfsPackIndexLoaded(this);
    }
}

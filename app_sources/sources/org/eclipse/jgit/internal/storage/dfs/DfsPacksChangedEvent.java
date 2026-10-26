package org.eclipse.jgit.internal.storage.dfs;

import org.eclipse.jgit.events.RepositoryEvent;

/* INFO: loaded from: classes5.dex */
public class DfsPacksChangedEvent extends RepositoryEvent<DfsPacksChangedListener> {
    @Override // org.eclipse.jgit.events.RepositoryEvent
    public Class<DfsPacksChangedListener> getListenerType() {
        return DfsPacksChangedListener.class;
    }

    @Override // org.eclipse.jgit.events.RepositoryEvent
    public void dispatch(DfsPacksChangedListener dfsPacksChangedListener) {
        dfsPacksChangedListener.onPacksChanged(this);
    }
}

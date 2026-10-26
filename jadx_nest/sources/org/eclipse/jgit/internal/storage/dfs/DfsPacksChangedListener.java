package org.eclipse.jgit.internal.storage.dfs;

import org.eclipse.jgit.events.RepositoryListener;

/* INFO: loaded from: classes5.dex */
public interface DfsPacksChangedListener extends RepositoryListener {
    void onPacksChanged(DfsPacksChangedEvent dfsPacksChangedEvent);
}

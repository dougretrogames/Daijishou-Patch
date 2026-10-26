package org.eclipse.jgit.events;

import org.apache.commons.collections4.CollectionUtils;

/* INFO: loaded from: classes5.dex */
public class ListenerHandle {
    final RepositoryListener listener;
    private final ListenerList parent;
    final Class<? extends RepositoryListener> type;

    ListenerHandle(ListenerList listenerList, Class<? extends RepositoryListener> cls, RepositoryListener repositoryListener) {
        this.parent = listenerList;
        this.type = cls;
        this.listener = repositoryListener;
    }

    public void remove() {
        this.parent.remove(this);
    }

    public String toString() {
        return this.type.getSimpleName() + CollectionUtils.DEFAULT_TOSTRING_PREFIX + String.valueOf(this.listener) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }
}

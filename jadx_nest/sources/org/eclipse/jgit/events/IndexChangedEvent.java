package org.eclipse.jgit.events;

/* INFO: loaded from: classes5.dex */
public class IndexChangedEvent extends RepositoryEvent<IndexChangedListener> {
    private boolean internal;

    public IndexChangedEvent(boolean z) {
        this.internal = z;
    }

    public boolean isInternal() {
        return this.internal;
    }

    @Override // org.eclipse.jgit.events.RepositoryEvent
    public Class<IndexChangedListener> getListenerType() {
        return IndexChangedListener.class;
    }

    @Override // org.eclipse.jgit.events.RepositoryEvent
    public void dispatch(IndexChangedListener indexChangedListener) {
        indexChangedListener.onIndexChanged(this);
    }
}

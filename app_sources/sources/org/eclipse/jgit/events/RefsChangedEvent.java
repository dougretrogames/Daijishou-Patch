package org.eclipse.jgit.events;

/* INFO: loaded from: classes5.dex */
public class RefsChangedEvent extends RepositoryEvent<RefsChangedListener> {
    @Override // org.eclipse.jgit.events.RepositoryEvent
    public Class<RefsChangedListener> getListenerType() {
        return RefsChangedListener.class;
    }

    @Override // org.eclipse.jgit.events.RepositoryEvent
    public void dispatch(RefsChangedListener refsChangedListener) {
        refsChangedListener.onRefsChanged(this);
    }
}

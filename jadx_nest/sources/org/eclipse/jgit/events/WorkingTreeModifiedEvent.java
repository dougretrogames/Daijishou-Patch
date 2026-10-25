package org.eclipse.jgit.events;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class WorkingTreeModifiedEvent extends RepositoryEvent<WorkingTreeModifiedListener> {
    private Collection<String> deleted;
    private Collection<String> modified;

    public WorkingTreeModifiedEvent(Collection<String> collection, Collection<String> collection2) {
        this.modified = collection;
        this.deleted = collection2;
    }

    public boolean isEmpty() {
        Collection<String> collection = this.modified;
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        Collection<String> collection2 = this.deleted;
        return collection2 == null || collection2.isEmpty();
    }

    public Collection<String> getModified() {
        Collection<String> collection = this.modified;
        if (collection != null) {
            return collection;
        }
        List listEmptyList = Collections.emptyList();
        this.modified = listEmptyList;
        return listEmptyList;
    }

    public Collection<String> getDeleted() {
        Collection<String> collection = this.deleted;
        if (collection != null) {
            return collection;
        }
        List listEmptyList = Collections.emptyList();
        this.deleted = listEmptyList;
        return listEmptyList;
    }

    @Override // org.eclipse.jgit.events.RepositoryEvent
    public Class<WorkingTreeModifiedListener> getListenerType() {
        return WorkingTreeModifiedListener.class;
    }

    @Override // org.eclipse.jgit.events.RepositoryEvent
    public void dispatch(WorkingTreeModifiedListener workingTreeModifiedListener) {
        workingTreeModifiedListener.onWorkingTreeModified(this);
    }
}

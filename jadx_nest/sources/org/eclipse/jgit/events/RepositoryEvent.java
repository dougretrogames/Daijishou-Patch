package org.eclipse.jgit.events;

import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.events.RepositoryListener;
import org.eclipse.jgit.lib.Repository;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RepositoryEvent<T extends RepositoryListener> {
    private Repository repository;

    public abstract void dispatch(T t);

    public abstract Class<T> getListenerType();

    public void setRepository(Repository repository) {
        if (this.repository == null) {
            this.repository = repository;
        }
    }

    public Repository getRepository() {
        return this.repository;
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        Repository repository = this.repository;
        if (repository == null) {
            return simpleName;
        }
        return simpleName + CollectionUtils.DEFAULT_TOSTRING_PREFIX + String.valueOf(repository) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }
}

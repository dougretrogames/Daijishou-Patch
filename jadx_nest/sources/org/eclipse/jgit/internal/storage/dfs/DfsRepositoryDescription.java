package org.eclipse.jgit.internal.storage.dfs;

import org.apache.commons.collections4.CollectionUtils;

/* JADX INFO: loaded from: classes5.dex */
public class DfsRepositoryDescription {
    private final String repositoryName;

    public DfsRepositoryDescription() {
        this(null);
    }

    public DfsRepositoryDescription(String str) {
        this.repositoryName = str;
    }

    public String getRepositoryName() {
        return this.repositoryName;
    }

    public int hashCode() {
        if (getRepositoryName() != null) {
            return getRepositoryName().hashCode();
        }
        return System.identityHashCode(this);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DfsRepositoryDescription) {
            String repositoryName = getRepositoryName();
            String repositoryName2 = ((DfsRepositoryDescription) obj).getRepositoryName();
            if (repositoryName != null) {
                return repositoryName.equals(repositoryName2);
            }
            if (this == obj) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "DfsRepositoryDescription[" + getRepositoryName() + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }
}

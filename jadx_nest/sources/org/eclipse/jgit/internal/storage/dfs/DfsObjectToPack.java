package org.eclipse.jgit.internal.storage.dfs;

import org.eclipse.jgit.internal.storage.pack.ObjectToPack;
import org.eclipse.jgit.internal.storage.pack.StoredObjectRepresentation;
import org.eclipse.jgit.lib.AnyObjectId;

/* INFO: loaded from: classes5.dex */
class DfsObjectToPack extends ObjectToPack {
    private static final int FLAG_FOUND = 1;
    long length;
    long offset;
    DfsPackFile pack;

    DfsObjectToPack(AnyObjectId anyObjectId, int i) {
        super(anyObjectId, i);
    }

    final boolean isFound() {
        return isExtendedFlag(1);
    }

    final void setFound() {
        setExtendedFlag(1);
    }

    @Override // org.eclipse.jgit.internal.storage.pack.ObjectToPack
    protected void clearReuseAsIs() {
        super.clearReuseAsIs();
        this.pack = null;
    }

    @Override // org.eclipse.jgit.internal.storage.pack.ObjectToPack
    public void select(StoredObjectRepresentation storedObjectRepresentation) {
        DfsObjectRepresentation dfsObjectRepresentation = (DfsObjectRepresentation) storedObjectRepresentation;
        this.pack = dfsObjectRepresentation.pack;
        this.offset = dfsObjectRepresentation.offset;
        this.length = dfsObjectRepresentation.length;
    }
}

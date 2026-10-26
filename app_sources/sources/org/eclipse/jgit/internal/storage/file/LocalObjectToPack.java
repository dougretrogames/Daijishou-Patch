package org.eclipse.jgit.internal.storage.file;

import org.eclipse.jgit.internal.storage.pack.ObjectToPack;
import org.eclipse.jgit.internal.storage.pack.StoredObjectRepresentation;
import org.eclipse.jgit.lib.AnyObjectId;

/* INFO: loaded from: classes5.dex */
class LocalObjectToPack extends ObjectToPack {
    long length;
    long offset;
    Pack pack;

    LocalObjectToPack(AnyObjectId anyObjectId, int i) {
        super(anyObjectId, i);
    }

    @Override // org.eclipse.jgit.internal.storage.pack.ObjectToPack
    protected void clearReuseAsIs() {
        super.clearReuseAsIs();
        this.pack = null;
    }

    @Override // org.eclipse.jgit.internal.storage.pack.ObjectToPack
    public void select(StoredObjectRepresentation storedObjectRepresentation) {
        LocalObjectRepresentation localObjectRepresentation = (LocalObjectRepresentation) storedObjectRepresentation;
        this.pack = localObjectRepresentation.pack;
        this.offset = localObjectRepresentation.offset;
        this.length = localObjectRepresentation.length;
    }
}

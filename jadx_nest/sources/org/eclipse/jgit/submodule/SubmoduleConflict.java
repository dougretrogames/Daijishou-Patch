package org.eclipse.jgit.submodule;

import org.eclipse.jgit.diff.Sequence;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: loaded from: classes5.dex */
public class SubmoduleConflict extends Sequence {
    private final ObjectId objectId;

    @Override // org.eclipse.jgit.diff.Sequence
    public int size() {
        return 1;
    }

    public SubmoduleConflict(ObjectId objectId) {
        this.objectId = objectId;
    }

    public ObjectId getObjectId() {
        return this.objectId;
    }
}

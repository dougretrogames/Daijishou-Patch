package org.eclipse.jgit.notes;

import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
public class Note extends ObjectId {
    private ObjectId data;

    public Note(AnyObjectId anyObjectId, ObjectId objectId) {
        super(anyObjectId);
        this.data = objectId;
    }

    public ObjectId getData() {
        return this.data;
    }

    void setData(ObjectId objectId) {
        this.data = objectId;
    }

    @Override // org.eclipse.jgit.lib.AnyObjectId
    public String toString() {
        return "Note[" + name() + " -> " + this.data.name() + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }
}

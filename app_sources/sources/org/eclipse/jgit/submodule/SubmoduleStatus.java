package org.eclipse.jgit.submodule;

import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
public class SubmoduleStatus {
    private final ObjectId headId;
    private final ObjectId indexId;
    private final String path;
    private final SubmoduleStatusType type;

    public SubmoduleStatus(SubmoduleStatusType submoduleStatusType, String str, ObjectId objectId) {
        this(submoduleStatusType, str, objectId, null);
    }

    public SubmoduleStatus(SubmoduleStatusType submoduleStatusType, String str, ObjectId objectId, ObjectId objectId2) {
        this.type = submoduleStatusType;
        this.path = str;
        this.indexId = objectId;
        this.headId = objectId2;
    }

    public SubmoduleStatusType getType() {
        return this.type;
    }

    public String getPath() {
        return this.path;
    }

    public ObjectId getIndexId() {
        return this.indexId;
    }

    public ObjectId getHeadId() {
        return this.headId;
    }
}

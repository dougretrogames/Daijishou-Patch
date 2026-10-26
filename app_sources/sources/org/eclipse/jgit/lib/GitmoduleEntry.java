package org.eclipse.jgit.lib;

/* INFO: loaded from: classes5.dex */
public final class GitmoduleEntry {
    private final AnyObjectId blobId;
    private final AnyObjectId treeId;

    public GitmoduleEntry(AnyObjectId anyObjectId, AnyObjectId anyObjectId2) {
        this.treeId = anyObjectId.copy();
        this.blobId = anyObjectId2.copy();
    }

    public AnyObjectId getBlobId() {
        return this.blobId;
    }

    public AnyObjectId getTreeId() {
        return this.treeId;
    }
}

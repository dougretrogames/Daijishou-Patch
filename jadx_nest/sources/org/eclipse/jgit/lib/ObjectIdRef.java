package org.eclipse.jgit.lib;

import org.eclipse.jgit.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ObjectIdRef implements Ref {
    private final String name;
    private final ObjectId objectId;
    private final Ref.Storage storage;
    private final long updateIndex;

    @Override // org.eclipse.jgit.lib.Ref
    public Ref getLeaf() {
        return this;
    }

    @Override // org.eclipse.jgit.lib.Ref
    public Ref getTarget() {
        return this;
    }

    @Override // org.eclipse.jgit.lib.Ref
    public boolean isSymbolic() {
        return false;
    }

    public static class Unpeeled extends ObjectIdRef {
        @Override // org.eclipse.jgit.lib.Ref
        @Nullable
        public ObjectId getPeeledObjectId() {
            return null;
        }

        @Override // org.eclipse.jgit.lib.Ref
        public boolean isPeeled() {
            return false;
        }

        public Unpeeled(Ref.Storage storage, String str, @Nullable ObjectId objectId) {
            super(storage, str, objectId, -1L);
        }

        public Unpeeled(Ref.Storage storage, String str, @Nullable ObjectId objectId, long j) {
            super(storage, str, objectId, j);
        }
    }

    public static class PeeledTag extends ObjectIdRef {
        private final ObjectId peeledObjectId;

        @Override // org.eclipse.jgit.lib.Ref
        public boolean isPeeled() {
            return true;
        }

        public PeeledTag(Ref.Storage storage, String str, @Nullable ObjectId objectId, ObjectId objectId2) {
            super(storage, str, objectId, -1L);
            this.peeledObjectId = objectId2;
        }

        public PeeledTag(Ref.Storage storage, String str, @Nullable ObjectId objectId, ObjectId objectId2, long j) {
            super(storage, str, objectId, j);
            this.peeledObjectId = objectId2;
        }

        @Override // org.eclipse.jgit.lib.Ref
        public ObjectId getPeeledObjectId() {
            return this.peeledObjectId;
        }
    }

    public static class PeeledNonTag extends ObjectIdRef {
        @Override // org.eclipse.jgit.lib.Ref
        @Nullable
        public ObjectId getPeeledObjectId() {
            return null;
        }

        @Override // org.eclipse.jgit.lib.Ref
        public boolean isPeeled() {
            return true;
        }

        public PeeledNonTag(Ref.Storage storage, String str, @Nullable ObjectId objectId) {
            super(storage, str, objectId, -1L);
        }

        public PeeledNonTag(Ref.Storage storage, String str, @Nullable ObjectId objectId, long j) {
            super(storage, str, objectId, j);
        }
    }

    protected ObjectIdRef(Ref.Storage storage, String str, @Nullable ObjectId objectId, long j) {
        this.name = str;
        this.storage = storage;
        this.objectId = objectId;
        this.updateIndex = j;
    }

    @Override // org.eclipse.jgit.lib.Ref
    public String getName() {
        return this.name;
    }

    @Override // org.eclipse.jgit.lib.Ref
    @Nullable
    public ObjectId getObjectId() {
        return this.objectId;
    }

    @Override // org.eclipse.jgit.lib.Ref
    public Ref.Storage getStorage() {
        return this.storage;
    }

    @Override // org.eclipse.jgit.lib.Ref
    public long getUpdateIndex() {
        long j = this.updateIndex;
        if (j != -1) {
            return j;
        }
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "Ref[" + getName() + '=' + ObjectId.toString(getObjectId()) + '(' + this.updateIndex + ")]";
    }
}

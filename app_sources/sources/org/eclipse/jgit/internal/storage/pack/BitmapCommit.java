package org.eclipse.jgit.internal.storage.pack;

import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
public final class BitmapCommit extends ObjectId {
    private final boolean addToIndex;
    private final int flags;
    private final boolean reuseWalker;

    BitmapCommit(AnyObjectId anyObjectId, boolean z, int i) {
        super(anyObjectId);
        this.reuseWalker = z;
        this.flags = i;
        this.addToIndex = false;
    }

    BitmapCommit(AnyObjectId anyObjectId, boolean z, int i, boolean z2) {
        super(anyObjectId);
        this.reuseWalker = z;
        this.flags = i;
        this.addToIndex = z2;
    }

    boolean isReuseWalker() {
        return this.reuseWalker;
    }

    int getFlags() {
        return this.flags;
    }

    public boolean isAddToIndex() {
        return this.addToIndex;
    }

    public static Builder newBuilder(AnyObjectId anyObjectId) {
        return new Builder(null).setId(anyObjectId);
    }

    public static Builder copyFrom(BitmapCommit bitmapCommit) {
        return new Builder(null).setId(bitmapCommit).setReuseWalker(bitmapCommit.isReuseWalker()).setFlags(bitmapCommit.getFlags()).setAddToIndex(bitmapCommit.isAddToIndex());
    }

    public static class Builder {
        private boolean addToIndex;
        private int flags;
        private AnyObjectId objectId;
        private boolean reuseWalker;

        /* synthetic */ Builder(BitmapCommitIA bitmapCommitIA) {
            this();
        }

        private Builder() {
        }

        public Builder setId(AnyObjectId anyObjectId) {
            this.objectId = anyObjectId;
            return this;
        }

        public Builder setReuseWalker(boolean z) {
            this.reuseWalker = z;
            return this;
        }

        public Builder setFlags(int i) {
            this.flags = i;
            return this;
        }

        public Builder setAddToIndex(boolean z) {
            this.addToIndex = z;
            return this;
        }

        public BitmapCommit build() {
            return new BitmapCommit(this.objectId, this.reuseWalker, this.flags, this.addToIndex);
        }
    }
}

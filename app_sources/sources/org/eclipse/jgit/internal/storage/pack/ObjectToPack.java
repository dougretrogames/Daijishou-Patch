package org.eclipse.jgit.internal.storage.pack;

import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.transport.PackedObjectInfo;

/* INFO: loaded from: classes5.dex */
public class ObjectToPack extends PackedObjectInfo {
    private static final int ATTEMPT_DELTA_MASK = 3;
    private static final int DELTA_ATTEMPTED = 2;
    private static final int DELTA_SHIFT = 12;
    private static final int DO_NOT_DELTA = 4;
    private static final int EDGE = 8;
    private static final int EXT_MASK = 15;
    private static final int EXT_SHIFT = 8;
    private static final int NON_DELTA_MASK = 4095;
    private static final int NON_EXT_MASK = -3841;
    private static final int REUSE_AS_IS = 1;
    private static final int TYPE_SHIFT = 5;
    private DeltaCache.Ref cachedDelta;
    private ObjectId deltaBase;
    private int flags;
    private int pathHash;

    public void select(StoredObjectRepresentation storedObjectRepresentation) {
    }

    public ObjectToPack(AnyObjectId anyObjectId, int i) {
        super(anyObjectId);
        this.flags = i << 5;
    }

    public final ObjectId getDeltaBaseId() {
        return this.deltaBase;
    }

    public final ObjectToPack getDeltaBase() {
        ObjectId objectId = this.deltaBase;
        if (objectId instanceof ObjectToPack) {
            return (ObjectToPack) objectId;
        }
        return null;
    }

    final void setDeltaBase(ObjectId objectId) {
        this.deltaBase = objectId;
    }

    final void setCachedDelta(DeltaCache.Ref ref) {
        this.cachedDelta = ref;
    }

    final DeltaCache.Ref popCachedDelta() {
        DeltaCache.Ref ref = this.cachedDelta;
        if (ref != null) {
            this.cachedDelta = null;
        }
        return ref;
    }

    final void clearDeltaBase() {
        this.deltaBase = null;
        DeltaCache.Ref ref = this.cachedDelta;
        if (ref != null) {
            ref.clear();
            this.cachedDelta.enqueue();
            this.cachedDelta = null;
        }
    }

    public final boolean isDeltaRepresentation() {
        return this.deltaBase != null;
    }

    public final boolean isWritten() {
        return 1 < getOffset();
    }

    @Override // org.eclipse.jgit.transport.PackedObjectInfo
    public final int getType() {
        return (this.flags >> 5) & 7;
    }

    final int getDeltaDepth() {
        return this.flags >>> 12;
    }

    final void setDeltaDepth(int i) {
        this.flags = (i << 12) | (this.flags & NON_DELTA_MASK);
    }

    final int getChainLength() {
        return getDeltaDepth();
    }

    final void setChainLength(int i) {
        setDeltaDepth(i);
    }

    final void clearChainLength() {
        this.flags &= NON_DELTA_MASK;
    }

    final boolean wantWrite() {
        return getOffset() == 1;
    }

    final void markWantWrite() {
        setOffset(1L);
    }

    public final boolean isReuseAsIs() {
        return (this.flags & 1) != 0;
    }

    final void setReuseAsIs() {
        this.flags |= 1;
    }

    protected void clearReuseAsIs() {
        this.flags &= -2;
    }

    final boolean isDoNotDelta() {
        return (this.flags & 4) != 0;
    }

    final void setDoNotDelta() {
        this.flags |= 4;
    }

    final boolean isEdge() {
        return (this.flags & 8) != 0;
    }

    final void setEdge() {
        this.flags |= 8;
    }

    final boolean doNotAttemptDelta() {
        return (this.flags & 3) == 3;
    }

    final void setDeltaAttempted(boolean z) {
        if (z) {
            this.flags |= 2;
        } else {
            this.flags &= -3;
        }
    }

    protected final int getExtendedFlags() {
        return (this.flags >>> 8) & 15;
    }

    protected final boolean isExtendedFlag(int i) {
        return ((i << 8) & this.flags) != 0;
    }

    protected final void setExtendedFlag(int i) {
        this.flags = ((i & 15) << 8) | this.flags;
    }

    protected final void clearExtendedFlag(int i) {
        this.flags = (~((i & 15) << 8)) & this.flags;
    }

    protected final void setExtendedFlags(int i) {
        this.flags = ((i & 15) << 8) | (this.flags & NON_EXT_MASK);
    }

    final int getFormat() {
        if (isReuseAsIs()) {
            return isDeltaRepresentation() ? 0 : 1;
        }
        return 2;
    }

    final int getWeight() {
        return getCRC();
    }

    final void setWeight(int i) {
        setCRC(i);
    }

    final int getPathHash() {
        return this.pathHash;
    }

    final void setPathHash(int i) {
        this.pathHash = i;
    }

    final int getCachedSize() {
        return this.pathHash;
    }

    final void setCachedSize(int i) {
        this.pathHash = i;
    }

    @Override // org.eclipse.jgit.lib.AnyObjectId
    public String toString() {
        StringBuilder sb = new StringBuilder("ObjectToPack[");
        sb.append(Constants.typeString(getType()));
        sb.append(" ");
        sb.append(name());
        if (wantWrite()) {
            sb.append(" wantWrite");
        }
        if (isReuseAsIs()) {
            sb.append(" reuseAsIs");
        }
        if (isDoNotDelta()) {
            sb.append(" doNotDelta");
        }
        if (isEdge()) {
            sb.append(" edge");
        }
        if (getDeltaDepth() > 0) {
            sb.append(" depth=").append(getDeltaDepth());
        }
        if (isDeltaRepresentation()) {
            if (getDeltaBase() != null) {
                sb.append(" base=inpack:").append(getDeltaBase().name());
            } else {
                sb.append(" base=edge:").append(getDeltaBaseId().name());
            }
        }
        if (isWritten()) {
            sb.append(" offset=").append(getOffset());
        }
        sb.append(CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
        return sb.toString();
    }
}

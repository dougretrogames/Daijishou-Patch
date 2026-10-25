package org.eclipse.jgit.transport;

import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectIdOwnerMap;

/* JADX INFO: loaded from: classes5.dex */
public class PackedObjectInfo extends ObjectIdOwnerMap.Entry {
    private int crc;
    private long fullSize;
    private long offset;
    private long sizeBeforeInflating;
    private int type;

    PackedObjectInfo(long j, int i, AnyObjectId anyObjectId) {
        super(anyObjectId);
        this.type = -1;
        this.offset = j;
        this.crc = i;
    }

    public PackedObjectInfo(AnyObjectId anyObjectId) {
        super(anyObjectId);
        this.type = -1;
    }

    public long getOffset() {
        return this.offset;
    }

    public void setOffset(long j) {
        this.offset = j;
    }

    public int getCRC() {
        return this.crc;
    }

    public void setCRC(int i) {
        this.crc = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    void setSize(long j) {
        this.sizeBeforeInflating = j;
    }

    long getSize() {
        return this.sizeBeforeInflating;
    }

    public void setFullSize(long j) {
        this.fullSize = j;
    }

    public long getFullSize() {
        return this.fullSize;
    }
}

package org.eclipse.jgit.internal.storage.commitgraph;

import org.eclipse.jgit.util.NB;

/* INFO: loaded from: classes5.dex */
class GraphChangedPathFilterData {
    private static final int BDAT_HEADER_BYTES = 12;
    private static final int BIDX_BYTES_PER_ENTRY = 4;
    private final byte[] bloomFilterData;
    private final byte[] bloomFilterIndex;

    GraphChangedPathFilterData(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if ((bArr == null) != (bArr2 == null)) {
            bArr = null;
            bArr2 = null;
        }
        if (bArr2 == null || (NB.decodeUInt32(bArr2, 4) == 7 && NB.decodeUInt32(bArr2, 8) == 10)) {
            bArr3 = bArr;
        } else {
            bArr2 = null;
        }
        this.bloomFilterIndex = bArr3;
        this.bloomFilterData = bArr2;
    }

    ChangedPathFilter getChangedPathFilter(int i) {
        byte[] bArr = this.bloomFilterIndex;
        if (bArr == null) {
            return null;
        }
        int iDecodeInt32 = i == 0 ? 0 : NB.decodeInt32(bArr, (i * 4) - 4);
        return ChangedPathFilter.fromFile(this.bloomFilterData, iDecodeInt32 + 12, NB.decodeInt32(this.bloomFilterIndex, i * 4) - iDecodeInt32);
    }
}

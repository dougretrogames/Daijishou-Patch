package org.eclipse.jgit.internal.storage.commitgraph;

import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.util.NB;

/* INFO: loaded from: classes5.dex */
class GraphObjectIndex {
    private static final int FANOUT = 256;
    private final long commitCnt;
    private final int[] fanoutTable;
    private final int hashLength;
    private final byte[] oidLookup;

    GraphObjectIndex(int i, byte[] bArr, byte[] bArr2) throws CommitGraphFormatException {
        this.hashLength = i;
        this.oidLookup = bArr2;
        int[] iArr = new int[256];
        for (int i2 = 0; i2 < 256; i2++) {
            long jDecodeUInt32 = NB.decodeUInt32(bArr, i2 * 4);
            if (jDecodeUInt32 > 2147483647L) {
                throw new CommitGraphFormatException(JGitText.get().commitGraphFileIsTooLargeForJgit);
            }
            iArr[i2] = (int) jDecodeUInt32;
        }
        this.fanoutTable = iArr;
        this.commitCnt = iArr[255];
    }

    int findGraphPosition(AnyObjectId anyObjectId) {
        int firstByte = anyObjectId.getFirstByte();
        int[] iArr = this.fanoutTable;
        int i = iArr[firstByte];
        int i2 = firstByte > 0 ? iArr[firstByte - 1] : 0;
        while (i2 < i) {
            int i3 = (i2 + i) >>> 1;
            int iCompareTo = anyObjectId.compareTo(this.oidLookup, objIdOffset(i3));
            if (iCompareTo < 0) {
                i = i3;
            } else {
                if (iCompareTo == 0) {
                    return i3;
                }
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    ObjectId getObjectId(int i) {
        if (i < 0 || i >= this.commitCnt) {
            return null;
        }
        return ObjectId.fromRaw(this.oidLookup, objIdOffset(i));
    }

    long getCommitCnt() {
        return this.commitCnt;
    }

    private int objIdOffset(int i) {
        return this.hashLength * i;
    }
}

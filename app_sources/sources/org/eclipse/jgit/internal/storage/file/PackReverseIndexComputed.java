package org.eclipse.jgit.internal.storage.file;

import java.text.MessageFormat;
import java.util.Iterator;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.PackMismatchException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
final class PackReverseIndexComputed implements PackReverseIndex {
    private final long bucketSize;
    private final PackIndex index;
    private final int[] indexPosInOffsetOrder;
    private final int[] nextBucketStart;

    @Override // org.eclipse.jgit.internal.storage.file.PackReverseIndex
    public void verifyPackChecksum(String str) throws PackMismatchException {
    }

    PackReverseIndexComputed(PackIndex packIndex) {
        this.index = packIndex;
        long objectCount = packIndex.getObjectCount();
        if (objectCount + 1 > 2147483647L) {
            throw new IllegalArgumentException(JGitText.get().hugeIndexesAreNotSupportedByJgitYet);
        }
        int i = (int) objectCount;
        if (i == 0) {
            this.bucketSize = Long.MAX_VALUE;
            this.nextBucketStart = new int[1];
            this.indexPosInOffsetOrder = new int[0];
            return;
        }
        long[] jArr = new long[i];
        Iterator<PackIndex.MutableEntry> it = packIndex.iterator();
        long j = 0;
        int i2 = 0;
        while (it.hasNext()) {
            long offset = it.next().getOffset();
            int i3 = i2 + 1;
            jArr[i2] = offset;
            if (offset > j) {
                j = offset;
            }
            i2 = i3;
        }
        this.bucketSize = (j / ((long) i)) + 1;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i + 1];
        int i4 = 0;
        while (i4 < i) {
            int i5 = (int) (jArr[i4] / this.bucketSize);
            i4++;
            int i6 = iArr[i5];
            iArr[i5] = i4;
            iArr2[i4] = i6;
        }
        this.indexPosInOffsetOrder = new int[i];
        this.nextBucketStart = iArr;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i) {
            int i9 = iArr[i7];
            int i10 = i8;
            while (i9 > 0) {
                int i11 = i9 - 1;
                long j2 = jArr[i11];
                int i12 = i10 + 1;
                while (i8 < i10) {
                    int[] iArr3 = this.indexPosInOffsetOrder;
                    int i13 = iArr3[i10 - 1];
                    if (j2 > jArr[i13]) {
                        break;
                    }
                    iArr3[i10] = i13;
                    i10--;
                }
                this.indexPosInOffsetOrder[i10] = i11;
                i9 = iArr2[i9];
                i10 = i12;
            }
            this.nextBucketStart[i7] = i10;
            i7++;
            i8 = i10;
        }
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackReverseIndex
    public ObjectId findObject(long j) {
        int iBinarySearch = binarySearch(j);
        if (iBinarySearch < 0) {
            return null;
        }
        return this.index.getObjectId(this.indexPosInOffsetOrder[iBinarySearch]);
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackReverseIndex
    public long findNextOffset(long j, long j2) throws CorruptObjectException {
        int iBinarySearch = binarySearch(j);
        if (iBinarySearch < 0) {
            throw new CorruptObjectException(MessageFormat.format(JGitText.get().cantFindObjectInReversePackIndexForTheSpecifiedOffset, Long.valueOf(j)));
        }
        int i = iBinarySearch + 1;
        int[] iArr = this.indexPosInOffsetOrder;
        return i == iArr.length ? j2 : this.index.getOffset(iArr[i]);
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackReverseIndex
    public int findPosition(long j) {
        return binarySearch(j);
    }

    private int binarySearch(long j) {
        int i = (int) (j / this.bucketSize);
        int i2 = i == 0 ? 0 : this.nextBucketStart[i - 1];
        int i3 = this.nextBucketStart[i];
        while (i2 < i3) {
            int i4 = (i2 + i3) >>> 1;
            long offset = this.index.getOffset(this.indexPosInOffsetOrder[i4]);
            if (j < offset) {
                i3 = i4;
            } else {
                if (j == offset) {
                    return i4;
                }
                i2 = i4 + 1;
            }
        }
        return -1;
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackReverseIndex
    public ObjectId findObjectByPosition(int i) {
        return this.index.getObjectId(this.indexPosInOffsetOrder[i]);
    }
}

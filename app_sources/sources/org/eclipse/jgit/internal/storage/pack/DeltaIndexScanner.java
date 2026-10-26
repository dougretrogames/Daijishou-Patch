package org.eclipse.jgit.internal.storage.pack;

/* INFO: loaded from: classes5.dex */
class DeltaIndexScanner {
    final long[] entries;
    private int entryCnt;
    final int[] next;
    final int[] table;
    final int tableMask;

    DeltaIndexScanner(byte[] bArr, int i) {
        int i2 = i - (i % 16);
        int i3 = i2 / 16;
        if (i3 < 1) {
            this.table = new int[0];
            this.tableMask = 0;
            this.entries = new long[0];
            this.next = new int[0];
            return;
        }
        int[] iArr = new int[tableSize(i3)];
        this.table = iArr;
        this.tableMask = iArr.length - 1;
        long[] jArr = new long[i3 + 1];
        this.entries = jArr;
        this.next = new int[jArr.length];
        scan(bArr, i2);
    }

    private void scan(byte[] bArr, int i) {
        int i2 = i - 16;
        int i3 = 0;
        while (true) {
            int iHashBlock = DeltaIndex.hashBlock(bArr, i2);
            int i4 = this.tableMask & iHashBlock;
            int[] iArr = this.table;
            int i5 = iArr[i4];
            if (i5 != 0 && i3 == iHashBlock) {
                this.entries[i5] = (((long) iHashBlock) << 32) | ((long) i2);
            } else {
                int i6 = this.entryCnt + 1;
                this.entryCnt = i6;
                this.entries[i6] = (((long) iHashBlock) << 32) | ((long) i2);
                this.next[i6] = i5;
                iArr[i4] = i6;
            }
            i2 -= 16;
            if (i2 < 0) {
                return;
            } else {
                i3 = iHashBlock;
            }
        }
    }

    private static int tableSize(int i) {
        int iNumberOfLeadingZeros = 1 << (31 - Integer.numberOfLeadingZeros(i));
        return iNumberOfLeadingZeros < i ? iNumberOfLeadingZeros << 1 : iNumberOfLeadingZeros;
    }
}

package org.eclipse.jgit.internal.storage.file;

import com.googlecode.javaewah.EWAHCompressedBitmap;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
final class BitSet {
    private long[] words;

    private static final int block(int i) {
        return i >> 6;
    }

    private static final long mask(int i) {
        return 1 << i;
    }

    BitSet(int i) {
        this.words = new long[block(i) + 1];
    }

    final void clear() {
        Arrays.fill(this.words, 0L);
    }

    final void set(int i) {
        int iBlock = block(i);
        if (iBlock >= this.words.length) {
            long[] jArr = new long[block(i) * 2];
            long[] jArr2 = this.words;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            this.words = jArr;
        }
        long[] jArr3 = this.words;
        jArr3[iBlock] = jArr3[iBlock] | mask(i);
    }

    final void clear(int i) {
        int iBlock = block(i);
        long[] jArr = this.words;
        if (iBlock < jArr.length) {
            jArr[iBlock] = jArr[iBlock] & (~mask(i));
        }
    }

    final boolean get(int i) {
        int iBlock = block(i);
        long[] jArr = this.words;
        return iBlock < jArr.length && (jArr[iBlock] & mask(i)) != 0;
    }

    final EWAHCompressedBitmap toEWAHCompressedBitmap() {
        EWAHCompressedBitmap eWAHCompressedBitmap = new EWAHCompressedBitmap(this.words.length);
        int i = 0;
        long j = 0;
        for (long j2 : this.words) {
            if (j2 == 0) {
                i++;
            } else {
                if (j != 0) {
                    eWAHCompressedBitmap.addWord(j);
                }
                if (i > 0) {
                    eWAHCompressedBitmap.addStreamOfEmptyWords(false, i);
                    i = 0;
                }
                j = j2;
            }
        }
        int iNumberOfLeadingZeros = 64 - Long.numberOfLeadingZeros(j);
        if (iNumberOfLeadingZeros > 0) {
            eWAHCompressedBitmap.addWord(j, iNumberOfLeadingZeros);
        }
        return eWAHCompressedBitmap;
    }
}

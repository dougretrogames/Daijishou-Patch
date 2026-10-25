package com.googlecode.javaewah.symmetric;

import com.googlecode.javaewah.BitmapStorage;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ThresholdFuncBitmap extends UpdateableBitmapFunction {
    private static final int[] zeroes64 = new int[64];
    private final int min;
    private final int[] bufCounters = new int[64];
    private long[] buffers = new long[16];
    private int bufferUsed = 0;

    public ThresholdFuncBitmap(int i) {
        this.min = i;
    }

    @Override // com.googlecode.javaewah.symmetric.UpdateableBitmapFunction
    public void dispatch(BitmapStorage bitmapStorage, int i, int i2) {
        int i3 = i2 - i;
        if (this.hammingWeight >= this.min) {
            bitmapStorage.addStreamOfEmptyWords(true, i3);
            return;
        }
        int i4 = this.litWeight + this.hammingWeight;
        int i5 = this.min;
        if (i4 < i5) {
            bitmapStorage.addStreamOfEmptyWords(false, i3);
            return;
        }
        int i6 = i5 - this.hammingWeight;
        if (i6 == 1) {
            orLiterals(bitmapStorage, i, i3);
            return;
        }
        int numberOfLiterals = getNumberOfLiterals();
        this.bufferUsed = numberOfLiterals;
        if (numberOfLiterals == i6) {
            andLiterals(bitmapStorage, i, i3);
        } else {
            generalLiterals(i6, bitmapStorage, i, i3);
        }
    }

    private long threshold2buf(int i, long[] jArr, int i2) {
        long j;
        int[] iArr = this.bufCounters;
        System.arraycopy(zeroes64, 0, iArr, 0, 64);
        int i3 = 0;
        while (true) {
            j = 0;
            if (i3 >= i2) {
                break;
            }
            long j2 = jArr[i3];
            while (j2 != 0) {
                long j3 = (-j2) & j2;
                int iBitCount = Long.bitCount(j3 - 1);
                iArr[iBitCount] = iArr[iBitCount] + 1;
                j2 ^= j3;
            }
            i3++;
        }
        for (int i4 = 0; i4 < 64; i4++) {
            if (iArr[i4] >= i) {
                j |= 1 << i4;
            }
        }
        return j;
    }

    private static long threshold3(int i, long[] jArr, int i2) {
        if (jArr.length == 0) {
            return 0L;
        }
        long[] jArr2 = new long[i];
        jArr2[0] = jArr[0];
        for (int i3 = 1; i3 < i2; i3++) {
            long j = jArr[i3];
            for (int iMin = Math.min(i - 1, i3); iMin >= 1; iMin--) {
                jArr2[iMin] = jArr2[iMin] | (jArr2[iMin - 1] & j);
            }
            jArr2[0] = j | jArr2[0];
        }
        return jArr2[i - 1];
    }

    private long threshold4(int i, long[] jArr, int i2) {
        if (i >= 128) {
            return threshold2buf(i, jArr, i2);
        }
        int iBitCount = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            iBitCount += Long.bitCount(jArr[i3]);
        }
        if (iBitCount * 2 >= i2 * i) {
            return threshold3(i, jArr, i2);
        }
        return threshold2buf(i, jArr, i2);
    }

    private void orLiterals(BitmapStorage bitmapStorage, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            long literalWordAt = 0;
            for (EWAHPointer eWAHPointer : getLiterals()) {
                literalWordAt |= eWAHPointer.iterator.getLiteralWordAt((i3 + i) - eWAHPointer.beginOfRun());
            }
            bitmapStorage.addWord(literalWordAt);
        }
    }

    private void andLiterals(BitmapStorage bitmapStorage, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            long literalWordAt = -1;
            for (EWAHPointer eWAHPointer : getLiterals()) {
                literalWordAt &= eWAHPointer.iterator.getLiteralWordAt((i3 + i) - eWAHPointer.beginOfRun());
            }
            bitmapStorage.addWord(literalWordAt);
        }
    }

    private void generalLiterals(int i, BitmapStorage bitmapStorage, int i2, int i3) {
        int i4 = this.bufferUsed;
        long[] jArr = this.buffers;
        if (i4 > jArr.length) {
            this.buffers = Arrays.copyOf(jArr, i4 * 2);
        }
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 0;
            for (EWAHPointer eWAHPointer : getLiterals()) {
                this.buffers[i6] = eWAHPointer.iterator.getLiteralWordAt((i5 + i2) - eWAHPointer.beginOfRun());
                i6++;
            }
            bitmapStorage.addWord(threshold4(i, this.buffers, this.bufferUsed));
        }
    }
}

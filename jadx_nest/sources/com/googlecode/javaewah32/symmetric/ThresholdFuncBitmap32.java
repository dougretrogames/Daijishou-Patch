package com.googlecode.javaewah32.symmetric;

import com.googlecode.javaewah32.BitmapStorage32;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ThresholdFuncBitmap32 extends UpdateableBitmapFunction32 {
    private static final int[] zeroes64 = new int[64];
    private final int min;
    private final int[] bufcounters = new int[64];
    private int[] buffers = new int[16];
    private int bufferUsed = 0;

    public ThresholdFuncBitmap32(int i) {
        this.min = i;
    }

    @Override // com.googlecode.javaewah32.symmetric.UpdateableBitmapFunction32
    public void dispatch(BitmapStorage32 bitmapStorage32, int i, int i2) {
        int i3 = i2 - i;
        if (this.hammingWeight >= this.min) {
            bitmapStorage32.addStreamOfEmptyWords(true, i3);
            return;
        }
        int i4 = this.litWeight + this.hammingWeight;
        int i5 = this.min;
        if (i4 < i5) {
            bitmapStorage32.addStreamOfEmptyWords(false, i3);
            return;
        }
        int i6 = i5 - this.hammingWeight;
        if (i6 == 1) {
            orLiterals(bitmapStorage32, i, i3);
            return;
        }
        int numberOfLiterals = getNumberOfLiterals();
        this.bufferUsed = numberOfLiterals;
        if (numberOfLiterals == i6) {
            andLiterals(bitmapStorage32, i, i3);
        } else {
            generalLiterals(i6, bitmapStorage32, i, i3);
        }
    }

    private int threshold2buf(int i, int[] iArr, int i2) {
        int[] iArr2 = this.bufcounters;
        System.arraycopy(zeroes64, 0, iArr2, 0, 64);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = iArr[i3];
            while (i4 != 0) {
                int i5 = (-i4) & i4;
                int iBitCount = Integer.bitCount(i5 - 1);
                iArr2[iBitCount] = iArr2[iBitCount] + 1;
                i4 ^= i5;
            }
        }
        int i6 = 0;
        for (int i7 = 0; i7 < 64; i7++) {
            if (iArr2[i7] >= i) {
                i6 = (int) (((long) i6) | (1 << i7));
            }
        }
        return i6;
    }

    private static int threshold3(int i, int[] iArr, int i2) {
        if (iArr.length == 0) {
            return 0;
        }
        int[] iArr2 = new int[i];
        iArr2[0] = iArr[0];
        for (int i3 = 1; i3 < i2; i3++) {
            int i4 = iArr[i3];
            for (int iMin = Math.min(i - 1, i3); iMin >= 1; iMin--) {
                iArr2[iMin] = iArr2[iMin] | (iArr2[iMin - 1] & i4);
            }
            iArr2[0] = i4 | iArr2[0];
        }
        return iArr2[i - 1];
    }

    private int threshold4(int i, int[] iArr, int i2) {
        if (i >= 128) {
            return threshold2buf(i, iArr, i2);
        }
        int iBitCount = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            iBitCount += Integer.bitCount(iArr[i3]);
        }
        if (iBitCount * 2 >= i2 * i) {
            return threshold3(i, iArr, i2);
        }
        return threshold2buf(i, iArr, i2);
    }

    private void orLiterals(BitmapStorage32 bitmapStorage32, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int literalWordAt = 0;
            for (EWAHPointer32 eWAHPointer32 : getLiterals()) {
                literalWordAt |= eWAHPointer32.iterator.getLiteralWordAt((i3 + i) - eWAHPointer32.beginOfRun());
            }
            bitmapStorage32.addWord(literalWordAt);
        }
    }

    private void andLiterals(BitmapStorage32 bitmapStorage32, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int literalWordAt = -1;
            for (EWAHPointer32 eWAHPointer32 : getLiterals()) {
                literalWordAt &= eWAHPointer32.iterator.getLiteralWordAt((i3 + i) - eWAHPointer32.beginOfRun());
            }
            bitmapStorage32.addWord(literalWordAt);
        }
    }

    private void generalLiterals(int i, BitmapStorage32 bitmapStorage32, int i2, int i3) {
        int i4 = this.bufferUsed;
        int[] iArr = this.buffers;
        if (i4 > iArr.length) {
            this.buffers = Arrays.copyOf(iArr, i4 * 2);
        }
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 0;
            for (EWAHPointer32 eWAHPointer32 : getLiterals()) {
                this.buffers[i6] = eWAHPointer32.iterator.getLiteralWordAt((i5 + i2) - eWAHPointer32.beginOfRun());
                i6++;
            }
            bitmapStorage32.addWord(threshold4(i, this.buffers, this.bufferUsed));
        }
    }
}

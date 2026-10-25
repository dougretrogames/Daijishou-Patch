package com.googlecode.javaewah32;

import com.googlecode.javaewah.IntIterator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class IteratorUtil32 {
    private IteratorUtil32() {
    }

    public static IntIterator toSetBitsIntIterator(IteratingRLW32 iteratingRLW32) {
        return new IntIteratorOverIteratingRLW32(iteratingRLW32);
    }

    /* JADX INFO: renamed from: com.googlecode.javaewah32.IteratorUtil32$1, reason: invalid class name */
    class AnonymousClass1 implements Iterator<Integer> {
        private final IntIterator under;
        final /* synthetic */ IteratingRLW32 val$i;

        @Override // java.util.Iterator
        public void remove() {
        }

        AnonymousClass1(IteratingRLW32 iteratingRLW32) {
            this.val$i = iteratingRLW32;
            this.under = IteratorUtil32.toSetBitsIntIterator(iteratingRLW32);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.under.hasNext();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Integer next() {
            return Integer.valueOf(this.under.next());
        }
    }

    public static Iterator<Integer> toSetBitsIterator(IteratingRLW32 iteratingRLW32) {
        return new AnonymousClass1(iteratingRLW32);
    }

    public static void materialize(IteratingRLW32 iteratingRLW32, BitmapStorage32 bitmapStorage32) {
        do {
            if (iteratingRLW32.getRunningLength() > 0) {
                bitmapStorage32.addStreamOfEmptyWords(iteratingRLW32.getRunningBit(), iteratingRLW32.getRunningLength());
            }
            int numberOfLiteralWords = iteratingRLW32.getNumberOfLiteralWords();
            for (int i = 0; i < numberOfLiteralWords; i++) {
                bitmapStorage32.addWord(iteratingRLW32.getLiteralWordAt(i));
            }
        } while (iteratingRLW32.next());
    }

    public static int cardinality(IteratingRLW32 iteratingRLW32) {
        int iBitCount = 0;
        do {
            if (iteratingRLW32.getRunningBit()) {
                iBitCount += iteratingRLW32.getRunningLength() * 32;
            }
            int numberOfLiteralWords = iteratingRLW32.getNumberOfLiteralWords();
            for (int i = 0; i < numberOfLiteralWords; i++) {
                iBitCount += Integer.bitCount(iteratingRLW32.getLiteralWordAt(i));
            }
        } while (iteratingRLW32.next());
        return iBitCount;
    }

    public static IteratingRLW32[] toIterators(EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        int length = eWAHCompressedBitmap32Arr.length;
        IteratingRLW32[] iteratingRLW32Arr = new IteratingRLW32[length];
        for (int i = 0; i < length; i++) {
            iteratingRLW32Arr[i] = new IteratingBufferedRunningLengthWord32(eWAHCompressedBitmap32Arr[i]);
        }
        return iteratingRLW32Arr;
    }

    public static long materialize(IteratingRLW32 iteratingRLW32, BitmapStorage32 bitmapStorage32, int i) {
        int i2 = i;
        do {
            if (iteratingRLW32.getRunningLength() > 0) {
                int runningLength = iteratingRLW32.getRunningLength();
                if (runningLength > i2) {
                    runningLength = i2;
                }
                bitmapStorage32.addStreamOfEmptyWords(iteratingRLW32.getRunningBit(), runningLength);
                i2 -= runningLength;
            }
            long numberOfLiteralWords = iteratingRLW32.getNumberOfLiteralWords();
            for (int i3 = 0; i3 < numberOfLiteralWords; i3++) {
                bitmapStorage32.addWord(iteratingRLW32.getLiteralWordAt(i3));
            }
            if (i2 <= 0) {
                break;
            }
        } while (iteratingRLW32.next());
        return i - i2;
    }

    public static EWAHCompressedBitmap32 materialize(IteratingRLW32 iteratingRLW32) {
        EWAHCompressedBitmap32 eWAHCompressedBitmap32 = new EWAHCompressedBitmap32();
        materialize(iteratingRLW32, eWAHCompressedBitmap32);
        return eWAHCompressedBitmap32;
    }
}

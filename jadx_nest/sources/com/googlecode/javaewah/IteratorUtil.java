package com.googlecode.javaewah;

import java.util.Iterator;

/* INFO: loaded from: classes4.dex */
public final class IteratorUtil {
    private IteratorUtil() {
    }

    public static IntIterator toSetBitsIntIterator(IteratingRLW iteratingRLW) {
        return new IntIteratorOverIteratingRLW(iteratingRLW);
    }

    /* INFO: renamed from: com.googlecode.javaewah.IteratorUtil$1, reason: invalid class name */
    class AnonymousClass1 implements Iterator<Integer> {
        private final IntIterator under;
        final /* synthetic */ IteratingRLW val$i;

        @Override // java.util.Iterator
        public void remove() {
        }

        AnonymousClass1(IteratingRLW iteratingRLW) {
            this.val$i = iteratingRLW;
            this.under = IteratorUtil.toSetBitsIntIterator(iteratingRLW);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.under.hasNext();
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Integer next() {
            return Integer.valueOf(this.under.next());
        }
    }

    public static Iterator<Integer> toSetBitsIterator(IteratingRLW iteratingRLW) {
        return new AnonymousClass1(iteratingRLW);
    }

    public static void materialize(IteratingRLW iteratingRLW, BitmapStorage bitmapStorage) {
        do {
            if (iteratingRLW.getRunningLength() > 0) {
                bitmapStorage.addStreamOfEmptyWords(iteratingRLW.getRunningBit(), iteratingRLW.getRunningLength());
            }
            int numberOfLiteralWords = iteratingRLW.getNumberOfLiteralWords();
            for (int i = 0; i < numberOfLiteralWords; i++) {
                bitmapStorage.addWord(iteratingRLW.getLiteralWordAt(i));
            }
        } while (iteratingRLW.next());
    }

    public static int cardinality(IteratingRLW iteratingRLW) {
        int iBitCount = 0;
        do {
            if (iteratingRLW.getRunningBit()) {
                iBitCount += (int) (iteratingRLW.getRunningLength() * 64);
            }
            int numberOfLiteralWords = iteratingRLW.getNumberOfLiteralWords();
            for (int i = 0; i < numberOfLiteralWords; i++) {
                iBitCount += Long.bitCount(iteratingRLW.getLiteralWordAt(i));
            }
        } while (iteratingRLW.next());
        return iBitCount;
    }

    public static IteratingRLW[] toIterators(EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        int length = eWAHCompressedBitmapArr.length;
        IteratingRLW[] iteratingRLWArr = new IteratingRLW[length];
        for (int i = 0; i < length; i++) {
            iteratingRLWArr[i] = new IteratingBufferedRunningLengthWord(eWAHCompressedBitmapArr[i]);
        }
        return iteratingRLWArr;
    }

    public static long materialize(IteratingRLW iteratingRLW, BitmapStorage bitmapStorage, long j) {
        long j2 = j;
        do {
            if (iteratingRLW.getRunningLength() > 0) {
                long runningLength = iteratingRLW.getRunningLength();
                if (runningLength > j2) {
                    runningLength = j2;
                }
                bitmapStorage.addStreamOfEmptyWords(iteratingRLW.getRunningBit(), runningLength);
                j2 -= runningLength;
            }
            long numberOfLiteralWords = iteratingRLW.getNumberOfLiteralWords();
            for (int i = 0; i < numberOfLiteralWords; i++) {
                bitmapStorage.addWord(iteratingRLW.getLiteralWordAt(i));
            }
            if (j2 <= 0) {
                break;
            }
        } while (iteratingRLW.next());
        return j - j2;
    }

    public static EWAHCompressedBitmap materialize(IteratingRLW iteratingRLW) {
        EWAHCompressedBitmap eWAHCompressedBitmap = new EWAHCompressedBitmap();
        materialize(iteratingRLW, eWAHCompressedBitmap);
        return eWAHCompressedBitmap;
    }
}

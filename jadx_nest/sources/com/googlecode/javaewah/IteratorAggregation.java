package com.googlecode.javaewah;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes4.dex */
public final class IteratorAggregation {
    public static final int DEFAULT_MAX_BUF_SIZE = 65536;

    private IteratorAggregation() {
    }

    /* JADX INFO: renamed from: com.googlecode.javaewah.IteratorAggregation$1, reason: invalid class name */
    class AnonymousClass1 implements IteratingRLW {
        final /* synthetic */ IteratingRLW val$x;

        AnonymousClass1(IteratingRLW iteratingRLW) {
            this.val$x = iteratingRLW;
        }

        @Override // com.googlecode.javaewah.IteratingRLW
        public boolean next() {
            return this.val$x.next();
        }

        @Override // com.googlecode.javaewah.IteratingRLW
        public long getLiteralWordAt(int i) {
            return ~this.val$x.getLiteralWordAt(i);
        }

        @Override // com.googlecode.javaewah.IteratingRLW
        public int getNumberOfLiteralWords() {
            return this.val$x.getNumberOfLiteralWords();
        }

        @Override // com.googlecode.javaewah.IteratingRLW
        public boolean getRunningBit() {
            return !this.val$x.getRunningBit();
        }

        @Override // com.googlecode.javaewah.IteratingRLW
        public long size() {
            return this.val$x.size();
        }

        @Override // com.googlecode.javaewah.IteratingRLW
        public long getRunningLength() {
            return this.val$x.getRunningLength();
        }

        @Override // com.googlecode.javaewah.IteratingRLW
        public void discardFirstWords(long j) {
            this.val$x.discardFirstWords(j);
        }

        @Override // com.googlecode.javaewah.IteratingRLW
        public void discardRunningWords() {
            this.val$x.discardRunningWords();
        }

        @Override // com.googlecode.javaewah.IteratingRLW
        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public IteratingRLW m3463clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        @Override // com.googlecode.javaewah.IteratingRLW
        public void discardLiteralWords(long j) {
            this.val$x.discardLiteralWords(j);
        }
    }

    public static IteratingRLW not(IteratingRLW iteratingRLW) {
        return new AnonymousClass1(iteratingRLW);
    }

    public static IteratingRLW bufferedand(IteratingRLW... iteratingRLWArr) {
        return bufferedand(65536, iteratingRLWArr);
    }

    public static IteratingRLW bufferedand(int i, IteratingRLW... iteratingRLWArr) {
        if (iteratingRLWArr.length == 0) {
            throw new IllegalArgumentException("Need at least one iterator");
        }
        if (iteratingRLWArr.length == 1) {
            return iteratingRLWArr[0];
        }
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, iteratingRLWArr);
        return new BufferedIterator(new BufferedAndIterator(linkedList, i));
    }

    public static IteratingRLW bufferedor(IteratingRLW... iteratingRLWArr) {
        return bufferedor(65536, iteratingRLWArr);
    }

    public static IteratingRLW bufferedor(int i, IteratingRLW... iteratingRLWArr) {
        if (iteratingRLWArr.length == 0) {
            throw new IllegalArgumentException("Need at least one iterator");
        }
        if (iteratingRLWArr.length == 1) {
            return iteratingRLWArr[0];
        }
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, iteratingRLWArr);
        return new BufferedIterator(new BufferedORIterator(linkedList, i));
    }

    public static IteratingRLW bufferedxor(IteratingRLW... iteratingRLWArr) {
        return bufferedxor(65536, iteratingRLWArr);
    }

    public static IteratingRLW bufferedxor(int i, IteratingRLW... iteratingRLWArr) {
        if (iteratingRLWArr.length == 0) {
            throw new IllegalArgumentException("Need at least one iterator");
        }
        if (iteratingRLWArr.length == 1) {
            return iteratingRLWArr[0];
        }
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, iteratingRLWArr);
        return new BufferedIterator(new BufferedXORIterator(linkedList, i));
    }

    protected static void dischargeAsEmpty(BitmapStorage bitmapStorage, IteratingRLW iteratingRLW) {
        while (iteratingRLW.size() > 0) {
            bitmapStorage.addStreamOfEmptyWords(false, iteratingRLW.size());
            iteratingRLW.next();
        }
    }

    protected static long discharge(BitmapStorage bitmapStorage, IteratingRLW iteratingRLW, long j) {
        long j2 = 0;
        while (iteratingRLW.size() > 0 && j2 < j) {
            long runningLength = iteratingRLW.getRunningLength();
            if (runningLength > 0) {
                if (runningLength + j2 > j) {
                    runningLength = j - j2;
                }
                bitmapStorage.addStreamOfEmptyWords(iteratingRLW.getRunningBit(), runningLength);
                j2 += runningLength;
            }
            long numberOfLiteralWords = iteratingRLW.getNumberOfLiteralWords();
            if (numberOfLiteralWords + j2 > j) {
                numberOfLiteralWords = j - j2;
            }
            for (int i = 0; i < numberOfLiteralWords; i++) {
                bitmapStorage.addWord(iteratingRLW.getLiteralWordAt(i));
            }
            j2 += numberOfLiteralWords;
            iteratingRLW.discardFirstWords(numberOfLiteralWords + runningLength);
        }
        return j2;
    }

    protected static long dischargeNegated(BitmapStorage bitmapStorage, IteratingRLW iteratingRLW, long j) {
        long j2 = 0;
        while (iteratingRLW.size() > 0 && j2 < j) {
            long runningLength = iteratingRLW.getRunningLength();
            if (runningLength > 0) {
                if (runningLength + j2 > j) {
                    runningLength = j - j2;
                }
                bitmapStorage.addStreamOfEmptyWords(!iteratingRLW.getRunningBit(), runningLength);
                j2 += runningLength;
            }
            long numberOfLiteralWords = iteratingRLW.getNumberOfLiteralWords();
            if (numberOfLiteralWords + j2 > j) {
                numberOfLiteralWords = j - j2;
            }
            for (int i = 0; i < numberOfLiteralWords; i++) {
                bitmapStorage.addWord(~iteratingRLW.getLiteralWordAt(i));
            }
            j2 += numberOfLiteralWords;
            iteratingRLW.discardFirstWords(numberOfLiteralWords + runningLength);
        }
        return j2;
    }

    static void andToContainer(BitmapStorage bitmapStorage, int i, IteratingRLW iteratingRLW, IteratingRLW iteratingRLW2) {
        int i2;
        while (iteratingRLW.size() > 0 && iteratingRLW2.size() > 0) {
            int i3 = i - 1;
            if (i <= 0) {
                return;
            }
            while (true) {
                if (iteratingRLW.getRunningLength() <= 0 && iteratingRLW2.getRunningLength() <= 0) {
                    break;
                }
                boolean z = iteratingRLW.getRunningLength() < iteratingRLW2.getRunningLength();
                IteratingRLW iteratingRLW3 = z ? iteratingRLW : iteratingRLW2;
                IteratingRLW iteratingRLW4 = z ? iteratingRLW2 : iteratingRLW;
                if (!iteratingRLW4.getRunningBit()) {
                    bitmapStorage.addStreamOfEmptyWords(false, iteratingRLW4.getRunningLength());
                    iteratingRLW3.discardFirstWords(iteratingRLW4.getRunningLength());
                    iteratingRLW4.discardFirstWords(iteratingRLW4.getRunningLength());
                } else {
                    bitmapStorage.addStreamOfEmptyWords(false, iteratingRLW4.getRunningLength() - discharge(bitmapStorage, iteratingRLW3, iteratingRLW4.getRunningLength()));
                    iteratingRLW4.discardFirstWords(iteratingRLW4.getRunningLength());
                }
            }
            int iMin = Math.min(iteratingRLW.getNumberOfLiteralWords(), iteratingRLW2.getNumberOfLiteralWords());
            if (iMin > 0) {
                i3 -= iMin;
                for (i2 = 0; i2 < iMin; i2++) {
                    bitmapStorage.addWord(iteratingRLW.getLiteralWordAt(i2) & iteratingRLW2.getLiteralWordAt(i2));
                }
                long j = iMin;
                iteratingRLW.discardFirstWords(j);
                iteratingRLW2.discardFirstWords(j);
            }
            i = i3;
        }
    }

    static void andToContainer(BitmapStorage bitmapStorage, IteratingRLW iteratingRLW, IteratingRLW iteratingRLW2) {
        int i;
        while (iteratingRLW.size() > 0 && iteratingRLW2.size() > 0) {
            while (true) {
                if (iteratingRLW.getRunningLength() <= 0 && iteratingRLW2.getRunningLength() <= 0) {
                    break;
                }
                boolean z = iteratingRLW.getRunningLength() < iteratingRLW2.getRunningLength();
                IteratingRLW iteratingRLW3 = z ? iteratingRLW : iteratingRLW2;
                IteratingRLW iteratingRLW4 = z ? iteratingRLW2 : iteratingRLW;
                if (!iteratingRLW4.getRunningBit()) {
                    bitmapStorage.addStreamOfEmptyWords(false, iteratingRLW4.getRunningLength());
                    iteratingRLW3.discardFirstWords(iteratingRLW4.getRunningLength());
                    iteratingRLW4.discardFirstWords(iteratingRLW4.getRunningLength());
                } else {
                    bitmapStorage.addStreamOfEmptyWords(false, iteratingRLW4.getRunningLength() - discharge(bitmapStorage, iteratingRLW3, iteratingRLW4.getRunningLength()));
                    iteratingRLW4.discardFirstWords(iteratingRLW4.getRunningLength());
                }
            }
            int iMin = Math.min(iteratingRLW.getNumberOfLiteralWords(), iteratingRLW2.getNumberOfLiteralWords());
            if (iMin > 0) {
                for (i = 0; i < iMin; i++) {
                    bitmapStorage.addWord(iteratingRLW.getLiteralWordAt(i) & iteratingRLW2.getLiteralWordAt(i));
                }
                long j = iMin;
                iteratingRLW.discardFirstWords(j);
                iteratingRLW2.discardFirstWords(j);
            }
        }
    }

    public static void xorToContainer(BitmapStorage bitmapStorage, int i, IteratingRLW iteratingRLW, IteratingRLW iteratingRLW2) {
        int i2;
        while (iteratingRLW.size() > 0 && iteratingRLW2.size() > 0) {
            int i3 = i - 1;
            if (i <= 0) {
                return;
            }
            while (true) {
                if (iteratingRLW.getRunningLength() <= 0 && iteratingRLW2.getRunningLength() <= 0) {
                    break;
                }
                boolean z = iteratingRLW.getRunningLength() < iteratingRLW2.getRunningLength();
                IteratingRLW iteratingRLW3 = z ? iteratingRLW : iteratingRLW2;
                IteratingRLW iteratingRLW4 = z ? iteratingRLW2 : iteratingRLW;
                if (!iteratingRLW4.getRunningBit()) {
                    bitmapStorage.addStreamOfEmptyWords(false, iteratingRLW4.getRunningLength() - discharge(bitmapStorage, iteratingRLW3, iteratingRLW4.getRunningLength()));
                    iteratingRLW4.discardFirstWords(iteratingRLW4.getRunningLength());
                } else {
                    bitmapStorage.addStreamOfEmptyWords(true, iteratingRLW4.getRunningLength() - dischargeNegated(bitmapStorage, iteratingRLW3, iteratingRLW4.getRunningLength()));
                    iteratingRLW4.discardFirstWords(iteratingRLW4.getRunningLength());
                }
            }
            int iMin = Math.min(iteratingRLW.getNumberOfLiteralWords(), iteratingRLW2.getNumberOfLiteralWords());
            if (iMin > 0) {
                i3 -= iMin;
                for (i2 = 0; i2 < iMin; i2++) {
                    bitmapStorage.addWord(iteratingRLW.getLiteralWordAt(i2) ^ iteratingRLW2.getLiteralWordAt(i2));
                }
                long j = iMin;
                iteratingRLW.discardFirstWords(j);
                iteratingRLW2.discardFirstWords(j);
            }
            i = i3;
        }
    }

    protected static int inplaceor(long[] jArr, IteratingRLW iteratingRLW) {
        int i = 0;
        int i2 = 0;
        do {
            long size = iteratingRLW.size();
            if (size <= 0) {
                return i2;
            }
            if (((long) i2) + size < jArr.length) {
                int runningLength = (int) iteratingRLW.getRunningLength();
                if (iteratingRLW.getRunningBit()) {
                    Arrays.fill(jArr, i2, i2 + runningLength, -1L);
                }
                i2 += runningLength;
                int numberOfLiteralWords = iteratingRLW.getNumberOfLiteralWords();
                int i3 = 0;
                while (i3 < numberOfLiteralWords) {
                    jArr[i2] = jArr[i2] | iteratingRLW.getLiteralWordAt(i3);
                    i3++;
                    i2++;
                }
            } else {
                int length = jArr.length - i2;
                int runningLength2 = ((int) iteratingRLW.getRunningLength()) + i2;
                if (runningLength2 > jArr.length) {
                    if (iteratingRLW.getRunningBit()) {
                        Arrays.fill(jArr, i2, jArr.length, -1L);
                    }
                    iteratingRLW.discardFirstWords(length);
                    return jArr.length;
                }
                if (iteratingRLW.getRunningBit()) {
                    Arrays.fill(jArr, i2, runningLength2, -1L);
                }
                while (runningLength2 < jArr.length) {
                    jArr[runningLength2] = jArr[runningLength2] | iteratingRLW.getLiteralWordAt(i);
                    i++;
                    runningLength2++;
                }
                iteratingRLW.discardFirstWords(length);
                return runningLength2;
            }
        } while (iteratingRLW.next());
        return i2;
    }

    protected static int inplacexor(long[] jArr, IteratingRLW iteratingRLW) {
        int i = 0;
        int i2 = 0;
        do {
            long size = iteratingRLW.size();
            if (size <= 0) {
                return i2;
            }
            if (((long) i2) + size < jArr.length) {
                int runningLength = (int) iteratingRLW.getRunningLength();
                if (iteratingRLW.getRunningBit()) {
                    for (int i3 = i2; i3 < i2 + runningLength; i3++) {
                        jArr[i3] = ~jArr[i3];
                    }
                }
                i2 += runningLength;
                int numberOfLiteralWords = iteratingRLW.getNumberOfLiteralWords();
                int i4 = 0;
                while (i4 < numberOfLiteralWords) {
                    jArr[i2] = jArr[i2] ^ iteratingRLW.getLiteralWordAt(i4);
                    i4++;
                    i2++;
                }
            } else {
                int length = jArr.length - i2;
                int runningLength2 = ((int) iteratingRLW.getRunningLength()) + i2;
                if (runningLength2 > jArr.length) {
                    if (iteratingRLW.getRunningBit()) {
                        while (i2 < jArr.length) {
                            jArr[i2] = ~jArr[i2];
                            i2++;
                        }
                    }
                    iteratingRLW.discardFirstWords(length);
                    return jArr.length;
                }
                if (iteratingRLW.getRunningBit()) {
                    while (i2 < runningLength2) {
                        jArr[i2] = ~jArr[i2];
                        i2++;
                    }
                }
                while (runningLength2 < jArr.length) {
                    jArr[runningLength2] = jArr[runningLength2] ^ iteratingRLW.getLiteralWordAt(i);
                    i++;
                    runningLength2++;
                }
                iteratingRLW.discardFirstWords(length);
                return runningLength2;
            }
        } while (iteratingRLW.next());
        return i2;
    }

    protected static int inplaceand(long[] jArr, IteratingRLW iteratingRLW) {
        int i = 0;
        int i2 = 0;
        do {
            long size = iteratingRLW.size();
            if (size <= 0) {
                return i2;
            }
            if (((long) i2) + size < jArr.length) {
                int runningLength = (int) iteratingRLW.getRunningLength();
                if (!iteratingRLW.getRunningBit()) {
                    for (int i3 = i2; i3 < i2 + runningLength; i3++) {
                        jArr[i3] = 0;
                    }
                }
                i2 += runningLength;
                int numberOfLiteralWords = iteratingRLW.getNumberOfLiteralWords();
                int i4 = 0;
                while (i4 < numberOfLiteralWords) {
                    jArr[i2] = jArr[i2] & iteratingRLW.getLiteralWordAt(i4);
                    i4++;
                    i2++;
                }
            } else {
                int length = jArr.length - i2;
                int runningLength2 = ((int) iteratingRLW.getRunningLength()) + i2;
                if (runningLength2 > jArr.length) {
                    if (!iteratingRLW.getRunningBit()) {
                        while (i2 < jArr.length) {
                            jArr[i2] = 0;
                            i2++;
                        }
                    }
                    iteratingRLW.discardFirstWords(length);
                    return jArr.length;
                }
                if (!iteratingRLW.getRunningBit()) {
                    while (i2 < runningLength2) {
                        jArr[i2] = 0;
                        i2++;
                    }
                }
                while (runningLength2 < jArr.length) {
                    jArr[runningLength2] = jArr[runningLength2] & iteratingRLW.getLiteralWordAt(i);
                    i++;
                    runningLength2++;
                }
                iteratingRLW.discardFirstWords(length);
                return runningLength2;
            }
        } while (iteratingRLW.next());
        return i2;
    }
}

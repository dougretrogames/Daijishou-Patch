package com.googlecode.javaewah32;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/* INFO: loaded from: classes4.dex */
public final class IteratorAggregation32 {
    public static final int DEFAULT_MAX_BUF_SIZE = 65536;

    private IteratorAggregation32() {
    }

    /* INFO: renamed from: com.googlecode.javaewah32.IteratorAggregation32$1, reason: invalid class name */
    class AnonymousClass1 implements IteratingRLW32 {
        final /* synthetic */ IteratingRLW32 val$x;

        AnonymousClass1(IteratingRLW32 iteratingRLW32) {
            this.val$x = iteratingRLW32;
        }

        @Override // com.googlecode.javaewah32.IteratingRLW32
        public boolean next() {
            return this.val$x.next();
        }

        @Override // com.googlecode.javaewah32.IteratingRLW32
        public int getLiteralWordAt(int i) {
            return ~this.val$x.getLiteralWordAt(i);
        }

        @Override // com.googlecode.javaewah32.IteratingRLW32
        public int getNumberOfLiteralWords() {
            return this.val$x.getNumberOfLiteralWords();
        }

        @Override // com.googlecode.javaewah32.IteratingRLW32
        public boolean getRunningBit() {
            return !this.val$x.getRunningBit();
        }

        @Override // com.googlecode.javaewah32.IteratingRLW32
        public int size() {
            return this.val$x.size();
        }

        @Override // com.googlecode.javaewah32.IteratingRLW32
        public int getRunningLength() {
            return this.val$x.getRunningLength();
        }

        @Override // com.googlecode.javaewah32.IteratingRLW32
        public void discardFirstWords(int i) {
            this.val$x.discardFirstWords(i);
        }

        @Override // com.googlecode.javaewah32.IteratingRLW32
        public void discardRunningWords() {
            this.val$x.discardRunningWords();
        }

        @Override // com.googlecode.javaewah32.IteratingRLW32
        /* INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public IteratingRLW32 m3477clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        @Override // com.googlecode.javaewah32.IteratingRLW32
        public void discardLiteralWords(int i) {
            this.val$x.discardLiteralWords(i);
        }
    }

    public static IteratingRLW32 not(IteratingRLW32 iteratingRLW32) {
        return new AnonymousClass1(iteratingRLW32);
    }

    public static IteratingRLW32 bufferedand(IteratingRLW32... iteratingRLW32Arr) {
        return bufferedand(65536, iteratingRLW32Arr);
    }

    public static IteratingRLW32 bufferedand(int i, IteratingRLW32... iteratingRLW32Arr) {
        if (iteratingRLW32Arr.length == 0) {
            throw new IllegalArgumentException("Need at least one iterator");
        }
        if (iteratingRLW32Arr.length == 1) {
            return iteratingRLW32Arr[0];
        }
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, iteratingRLW32Arr);
        return new BufferedIterator32(new AndIt(linkedList, i));
    }

    public static IteratingRLW32 bufferedor(IteratingRLW32... iteratingRLW32Arr) {
        return bufferedor(65536, iteratingRLW32Arr);
    }

    public static IteratingRLW32 bufferedor(int i, IteratingRLW32... iteratingRLW32Arr) {
        if (iteratingRLW32Arr.length == 0) {
            throw new IllegalArgumentException("Need at least one iterator");
        }
        if (iteratingRLW32Arr.length == 1) {
            return iteratingRLW32Arr[0];
        }
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, iteratingRLW32Arr);
        return new BufferedIterator32(new ORIt(linkedList, i));
    }

    public static IteratingRLW32 bufferedxor(IteratingRLW32... iteratingRLW32Arr) {
        return bufferedxor(65536, iteratingRLW32Arr);
    }

    public static IteratingRLW32 bufferedxor(int i, IteratingRLW32... iteratingRLW32Arr) {
        if (iteratingRLW32Arr.length == 0) {
            throw new IllegalArgumentException("Need at least one iterator");
        }
        if (iteratingRLW32Arr.length == 1) {
            return iteratingRLW32Arr[0];
        }
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, iteratingRLW32Arr);
        return new BufferedIterator32(new XORIt(linkedList, i));
    }

    protected static void dischargeAsEmpty(BitmapStorage32 bitmapStorage32, IteratingRLW32 iteratingRLW32) {
        while (iteratingRLW32.size() > 0) {
            bitmapStorage32.addStreamOfEmptyWords(false, iteratingRLW32.size());
            iteratingRLW32.next();
        }
    }

    protected static int discharge(BitmapStorage32 bitmapStorage32, IteratingRLW32 iteratingRLW32, int i) {
        int i2 = 0;
        while (iteratingRLW32.size() > 0 && i2 < i) {
            int runningLength = iteratingRLW32.getRunningLength();
            if (runningLength > 0) {
                if (runningLength + i2 > i) {
                    runningLength = i - i2;
                }
                bitmapStorage32.addStreamOfEmptyWords(iteratingRLW32.getRunningBit(), runningLength);
                i2 += runningLength;
            }
            int numberOfLiteralWords = iteratingRLW32.getNumberOfLiteralWords();
            if (numberOfLiteralWords + i2 > i) {
                numberOfLiteralWords = i - i2;
            }
            for (int i3 = 0; i3 < numberOfLiteralWords; i3++) {
                bitmapStorage32.addWord(iteratingRLW32.getLiteralWordAt(i3));
            }
            i2 += numberOfLiteralWords;
            iteratingRLW32.discardFirstWords(numberOfLiteralWords + runningLength);
        }
        return i2;
    }

    protected static int dischargeNegated(BitmapStorage32 bitmapStorage32, IteratingRLW32 iteratingRLW32, int i) {
        int i2 = 0;
        while (iteratingRLW32.size() > 0 && i2 < i) {
            int runningLength = iteratingRLW32.getRunningLength();
            if (runningLength > 0) {
                if (runningLength + i2 > i) {
                    runningLength = i - i2;
                }
                bitmapStorage32.addStreamOfEmptyWords(iteratingRLW32.getRunningBit(), runningLength);
                i2 += runningLength;
            }
            int numberOfLiteralWords = iteratingRLW32.getNumberOfLiteralWords();
            if (numberOfLiteralWords + i2 > i) {
                numberOfLiteralWords = i - i2;
            }
            for (int i3 = 0; i3 < numberOfLiteralWords; i3++) {
                bitmapStorage32.addWord(iteratingRLW32.getLiteralWordAt(i3));
            }
            i2 += numberOfLiteralWords;
            iteratingRLW32.discardFirstWords(numberOfLiteralWords + runningLength);
        }
        return i2;
    }

    static void andToContainer(BitmapStorage32 bitmapStorage32, int i, IteratingRLW32 iteratingRLW32, IteratingRLW32 iteratingRLW33) {
        int i2;
        while (iteratingRLW32.size() > 0 && iteratingRLW33.size() > 0) {
            int i3 = i - 1;
            if (i <= 0) {
                return;
            }
            while (true) {
                if (iteratingRLW32.getRunningLength() <= 0 && iteratingRLW33.getRunningLength() <= 0) {
                    break;
                }
                boolean z = iteratingRLW32.getRunningLength() < iteratingRLW33.getRunningLength();
                IteratingRLW32 iteratingRLW34 = z ? iteratingRLW32 : iteratingRLW33;
                IteratingRLW32 iteratingRLW35 = z ? iteratingRLW33 : iteratingRLW32;
                if (!iteratingRLW35.getRunningBit()) {
                    bitmapStorage32.addStreamOfEmptyWords(false, iteratingRLW35.getRunningLength());
                    iteratingRLW34.discardFirstWords(iteratingRLW35.getRunningLength());
                    iteratingRLW35.discardFirstWords(iteratingRLW35.getRunningLength());
                } else {
                    bitmapStorage32.addStreamOfEmptyWords(false, iteratingRLW35.getRunningLength() - discharge(bitmapStorage32, iteratingRLW34, iteratingRLW35.getRunningLength()));
                    iteratingRLW35.discardFirstWords(iteratingRLW35.getRunningLength());
                }
            }
            int iMin = Math.min(iteratingRLW32.getNumberOfLiteralWords(), iteratingRLW33.getNumberOfLiteralWords());
            if (iMin > 0) {
                i3 -= iMin;
                for (i2 = 0; i2 < iMin; i2++) {
                    bitmapStorage32.addWord(iteratingRLW32.getLiteralWordAt(i2) & iteratingRLW33.getLiteralWordAt(i2));
                }
                iteratingRLW32.discardFirstWords(iMin);
                iteratingRLW33.discardFirstWords(iMin);
            }
            i = i3;
        }
    }

    static void andToContainer(BitmapStorage32 bitmapStorage32, IteratingRLW32 iteratingRLW32, IteratingRLW32 iteratingRLW33) {
        int i;
        while (iteratingRLW32.size() > 0 && iteratingRLW33.size() > 0) {
            while (true) {
                if (iteratingRLW32.getRunningLength() <= 0 && iteratingRLW33.getRunningLength() <= 0) {
                    break;
                }
                boolean z = iteratingRLW32.getRunningLength() < iteratingRLW33.getRunningLength();
                IteratingRLW32 iteratingRLW34 = z ? iteratingRLW32 : iteratingRLW33;
                IteratingRLW32 iteratingRLW35 = z ? iteratingRLW33 : iteratingRLW32;
                if (!iteratingRLW35.getRunningBit()) {
                    bitmapStorage32.addStreamOfEmptyWords(false, iteratingRLW35.getRunningLength());
                    iteratingRLW34.discardFirstWords(iteratingRLW35.getRunningLength());
                    iteratingRLW35.discardFirstWords(iteratingRLW35.getRunningLength());
                } else {
                    bitmapStorage32.addStreamOfEmptyWords(false, iteratingRLW35.getRunningLength() - discharge(bitmapStorage32, iteratingRLW34, iteratingRLW35.getRunningLength()));
                    iteratingRLW35.discardFirstWords(iteratingRLW35.getRunningLength());
                }
            }
            int iMin = Math.min(iteratingRLW32.getNumberOfLiteralWords(), iteratingRLW33.getNumberOfLiteralWords());
            if (iMin > 0) {
                for (i = 0; i < iMin; i++) {
                    bitmapStorage32.addWord(iteratingRLW32.getLiteralWordAt(i) & iteratingRLW33.getLiteralWordAt(i));
                }
                iteratingRLW32.discardFirstWords(iMin);
                iteratingRLW33.discardFirstWords(iMin);
            }
        }
    }

    public static void xorToContainer(BitmapStorage32 bitmapStorage32, int i, IteratingRLW32 iteratingRLW32, IteratingRLW32 iteratingRLW33) {
        int i2;
        while (iteratingRLW32.size() > 0 && iteratingRLW33.size() > 0) {
            int i3 = i - 1;
            if (i <= 0) {
                return;
            }
            while (true) {
                if (iteratingRLW32.getRunningLength() <= 0 && iteratingRLW33.getRunningLength() <= 0) {
                    break;
                }
                boolean z = iteratingRLW32.getRunningLength() < iteratingRLW33.getRunningLength();
                IteratingRLW32 iteratingRLW34 = z ? iteratingRLW32 : iteratingRLW33;
                IteratingRLW32 iteratingRLW35 = z ? iteratingRLW33 : iteratingRLW32;
                if (!iteratingRLW35.getRunningBit()) {
                    bitmapStorage32.addStreamOfEmptyWords(false, iteratingRLW35.getRunningLength() - discharge(bitmapStorage32, iteratingRLW34, iteratingRLW35.getRunningLength()));
                    iteratingRLW35.discardFirstWords(iteratingRLW35.getRunningLength());
                } else {
                    bitmapStorage32.addStreamOfEmptyWords(true, iteratingRLW35.getRunningLength() - dischargeNegated(bitmapStorage32, iteratingRLW34, iteratingRLW35.getRunningLength()));
                    iteratingRLW35.discardFirstWords(iteratingRLW35.getRunningLength());
                }
            }
            int iMin = Math.min(iteratingRLW32.getNumberOfLiteralWords(), iteratingRLW33.getNumberOfLiteralWords());
            if (iMin > 0) {
                i3 -= iMin;
                for (i2 = 0; i2 < iMin; i2++) {
                    bitmapStorage32.addWord(iteratingRLW32.getLiteralWordAt(i2) ^ iteratingRLW33.getLiteralWordAt(i2));
                }
                iteratingRLW32.discardFirstWords(iMin);
                iteratingRLW33.discardFirstWords(iMin);
            }
            i = i3;
        }
    }

    protected static int inplaceor(int[] iArr, IteratingRLW32 iteratingRLW32) {
        int i = 0;
        int i2 = 0;
        do {
            int size = iteratingRLW32.size();
            if (size <= 0) {
                return i2;
            }
            if (size + i2 < iArr.length) {
                int runningLength = iteratingRLW32.getRunningLength();
                if (iteratingRLW32.getRunningBit()) {
                    Arrays.fill(iArr, i2, i2 + runningLength, -1);
                }
                i2 += runningLength;
                int numberOfLiteralWords = iteratingRLW32.getNumberOfLiteralWords();
                int i3 = 0;
                while (i3 < numberOfLiteralWords) {
                    iArr[i2] = iArr[i2] | iteratingRLW32.getLiteralWordAt(i3);
                    i3++;
                    i2++;
                }
            } else {
                int length = iArr.length - i2;
                int runningLength2 = iteratingRLW32.getRunningLength() + i2;
                if (runningLength2 > iArr.length) {
                    if (iteratingRLW32.getRunningBit()) {
                        Arrays.fill(iArr, i2, iArr.length, -1);
                    }
                    iteratingRLW32.discardFirstWords(length);
                    return iArr.length;
                }
                if (iteratingRLW32.getRunningBit()) {
                    Arrays.fill(iArr, i2, runningLength2, -1);
                }
                while (runningLength2 < iArr.length) {
                    iArr[runningLength2] = iArr[runningLength2] | iteratingRLW32.getLiteralWordAt(i);
                    i++;
                    runningLength2++;
                }
                iteratingRLW32.discardFirstWords(length);
                return runningLength2;
            }
        } while (iteratingRLW32.next());
        return i2;
    }

    protected static int inplacexor(int[] iArr, IteratingRLW32 iteratingRLW32) {
        int i = 0;
        int i2 = 0;
        do {
            int size = iteratingRLW32.size();
            if (size <= 0) {
                return i2;
            }
            if (size + i2 < iArr.length) {
                int runningLength = iteratingRLW32.getRunningLength();
                if (iteratingRLW32.getRunningBit()) {
                    for (int i3 = i2; i3 < i2 + runningLength; i3++) {
                        iArr[i3] = ~iArr[i3];
                    }
                }
                i2 += runningLength;
                int numberOfLiteralWords = iteratingRLW32.getNumberOfLiteralWords();
                int i4 = 0;
                while (i4 < numberOfLiteralWords) {
                    iArr[i2] = iArr[i2] ^ iteratingRLW32.getLiteralWordAt(i4);
                    i4++;
                    i2++;
                }
            } else {
                int length = iArr.length - i2;
                int runningLength2 = iteratingRLW32.getRunningLength() + i2;
                if (runningLength2 > iArr.length) {
                    if (iteratingRLW32.getRunningBit()) {
                        while (i2 < iArr.length) {
                            iArr[i2] = ~iArr[i2];
                            i2++;
                        }
                    }
                    iteratingRLW32.discardFirstWords(length);
                    return iArr.length;
                }
                if (iteratingRLW32.getRunningBit()) {
                    while (i2 < runningLength2) {
                        iArr[i2] = ~iArr[i2];
                        i2++;
                    }
                }
                while (runningLength2 < iArr.length) {
                    iArr[runningLength2] = iArr[runningLength2] ^ iteratingRLW32.getLiteralWordAt(i);
                    i++;
                    runningLength2++;
                }
                iteratingRLW32.discardFirstWords(length);
                return runningLength2;
            }
        } while (iteratingRLW32.next());
        return i2;
    }

    protected static int inplaceand(int[] iArr, IteratingRLW32 iteratingRLW32) {
        int i = 0;
        int i2 = 0;
        do {
            int size = iteratingRLW32.size();
            if (size <= 0) {
                return i2;
            }
            if (size + i2 < iArr.length) {
                int runningLength = iteratingRLW32.getRunningLength();
                if (!iteratingRLW32.getRunningBit()) {
                    for (int i3 = i2; i3 < i2 + runningLength; i3++) {
                        iArr[i3] = 0;
                    }
                }
                i2 += runningLength;
                int numberOfLiteralWords = iteratingRLW32.getNumberOfLiteralWords();
                int i4 = 0;
                while (i4 < numberOfLiteralWords) {
                    iArr[i2] = iArr[i2] & iteratingRLW32.getLiteralWordAt(i4);
                    i4++;
                    i2++;
                }
            } else {
                int length = iArr.length - i2;
                int runningLength2 = iteratingRLW32.getRunningLength() + i2;
                if (runningLength2 > iArr.length) {
                    if (!iteratingRLW32.getRunningBit()) {
                        while (i2 < iArr.length) {
                            iArr[i2] = 0;
                            i2++;
                        }
                    }
                    iteratingRLW32.discardFirstWords(length);
                    return iArr.length;
                }
                if (!iteratingRLW32.getRunningBit()) {
                    while (i2 < runningLength2) {
                        iArr[i2] = 0;
                        i2++;
                    }
                }
                while (runningLength2 < iArr.length) {
                    iArr[runningLength2] = iArr[runningLength2] & iteratingRLW32.getLiteralWordAt(i);
                    i++;
                    runningLength2++;
                }
                iteratingRLW32.discardFirstWords(length);
                return runningLength2;
            }
        } while (iteratingRLW32.next());
        return i2;
    }
}

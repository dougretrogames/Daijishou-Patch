package com.googlecode.javaewah;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/* INFO: loaded from: classes4.dex */
public final class FastAggregation {
    private FastAggregation() {
    }

    public static EWAHCompressedBitmap bufferedand(int i, EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        EWAHCompressedBitmap eWAHCompressedBitmap = new EWAHCompressedBitmap();
        bufferedandWithContainer(eWAHCompressedBitmap, i, eWAHCompressedBitmapArr);
        return eWAHCompressedBitmap;
    }

    public static void bufferedandWithContainer(BitmapStorage bitmapStorage, int i, EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        LinkedList linkedList = new LinkedList();
        for (EWAHCompressedBitmap eWAHCompressedBitmap : eWAHCompressedBitmapArr) {
            linkedList.add(new IteratingBufferedRunningLengthWord(eWAHCompressedBitmap));
        }
        long[] jArr = new long[i * eWAHCompressedBitmapArr.length];
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            if (((IteratingRLW) it.next()).size() == 0) {
                linkedList.clear();
                break;
            }
        }
        while (!linkedList.isEmpty()) {
            Arrays.fill(jArr, -1L);
            Iterator it2 = linkedList.iterator();
            long j = 2147483647L;
            while (it2.hasNext()) {
                long jInplaceand = IteratorAggregation.inplaceand(jArr, (IteratingRLW) it2.next());
                if (jInplaceand < j) {
                    j = jInplaceand;
                }
            }
            for (int i2 = 0; i2 < j; i2++) {
                bitmapStorage.addWord(jArr[i2]);
            }
            Iterator it3 = linkedList.iterator();
            while (it3.hasNext()) {
                if (((IteratingRLW) it3.next()).size() == 0) {
                    linkedList.clear();
                    break;
                }
            }
        }
    }

    public static EWAHCompressedBitmap bufferedor(int i, EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        EWAHCompressedBitmap eWAHCompressedBitmap = new EWAHCompressedBitmap();
        bufferedorWithContainer(eWAHCompressedBitmap, i, eWAHCompressedBitmapArr);
        return eWAHCompressedBitmap;
    }

    /* INFO: renamed from: com.googlecode.javaewah.FastAggregation$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<EWAHCompressedBitmap> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHCompressedBitmap eWAHCompressedBitmap, EWAHCompressedBitmap eWAHCompressedBitmap2) {
            return eWAHCompressedBitmap2.sizeInBits() - eWAHCompressedBitmap.sizeInBits();
        }
    }

    public static void bufferedorWithContainer(BitmapStorage bitmapStorage, int i, EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        EWAHCompressedBitmap[] eWAHCompressedBitmapArr2 = (EWAHCompressedBitmap[]) eWAHCompressedBitmapArr.clone();
        Arrays.sort(eWAHCompressedBitmapArr2, new AnonymousClass1());
        ArrayList arrayList = new ArrayList();
        int iSizeInBits = 0;
        for (EWAHCompressedBitmap eWAHCompressedBitmap : eWAHCompressedBitmapArr2) {
            if (eWAHCompressedBitmap.sizeInBits() > iSizeInBits) {
                iSizeInBits = eWAHCompressedBitmap.sizeInBits();
            }
            arrayList.add(new IteratingBufferedRunningLengthWord(eWAHCompressedBitmap));
        }
        long[] jArr = new long[i];
        int size = arrayList.size();
        while (size > 0) {
            long j = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (((IteratingBufferedRunningLengthWord) arrayList.get(i2)).size() > 0) {
                    long jInplaceor = IteratorAggregation.inplaceor(jArr, (IteratingRLW) arrayList.get(i2));
                    if (jInplaceor > j) {
                        j = jInplaceor;
                    }
                } else {
                    size = i2;
                }
            }
            for (int i3 = 0; i3 < j; i3++) {
                bitmapStorage.addWord(jArr[i3]);
            }
            Arrays.fill(jArr, 0L);
        }
        bitmapStorage.setSizeInBitsWithinLastWord(iSizeInBits);
    }

    public static EWAHCompressedBitmap bufferedxor(int i, EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        EWAHCompressedBitmap eWAHCompressedBitmap = new EWAHCompressedBitmap();
        bufferedxorWithContainer(eWAHCompressedBitmap, i, eWAHCompressedBitmapArr);
        return eWAHCompressedBitmap;
    }

    /* INFO: renamed from: com.googlecode.javaewah.FastAggregation$2, reason: invalid class name */
    class AnonymousClass2 implements Comparator<EWAHCompressedBitmap> {
        AnonymousClass2() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHCompressedBitmap eWAHCompressedBitmap, EWAHCompressedBitmap eWAHCompressedBitmap2) {
            return eWAHCompressedBitmap2.sizeInBits() - eWAHCompressedBitmap.sizeInBits();
        }
    }

    public static void bufferedxorWithContainer(BitmapStorage bitmapStorage, int i, EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        EWAHCompressedBitmap[] eWAHCompressedBitmapArr2 = (EWAHCompressedBitmap[]) eWAHCompressedBitmapArr.clone();
        Arrays.sort(eWAHCompressedBitmapArr2, new AnonymousClass2());
        ArrayList arrayList = new ArrayList();
        int iSizeInBits = 0;
        for (EWAHCompressedBitmap eWAHCompressedBitmap : eWAHCompressedBitmapArr2) {
            if (eWAHCompressedBitmap.sizeInBits() > iSizeInBits) {
                iSizeInBits = eWAHCompressedBitmap.sizeInBits();
            }
            arrayList.add(new IteratingBufferedRunningLengthWord(eWAHCompressedBitmap));
        }
        long[] jArr = new long[i];
        int size = arrayList.size();
        while (size > 0) {
            long j = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (((IteratingBufferedRunningLengthWord) arrayList.get(i2)).size() > 0) {
                    long jInplacexor = IteratorAggregation.inplacexor(jArr, (IteratingRLW) arrayList.get(i2));
                    if (jInplacexor > j) {
                        j = jInplacexor;
                    }
                } else {
                    size = i2;
                }
            }
            for (int i3 = 0; i3 < j; i3++) {
                bitmapStorage.addWord(jArr[i3]);
            }
            Arrays.fill(jArr, 0L);
        }
        bitmapStorage.setSizeInBitsWithinLastWord(iSizeInBits);
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.googlecode.javaewah.FastAggregation$3, reason: invalid class name */
    class AnonymousClass3<T> implements Comparator<T> {
        AnonymousClass3() {
        }

        /* WARN: Incorrect types in method signature: (TT;TT;)I */
        @Override // java.util.Comparator
        public int compare(LogicalElement logicalElement, LogicalElement logicalElement2) {
            return logicalElement.sizeInBytes() - logicalElement2.sizeInBytes();
        }
    }

    public static <T extends LogicalElement> T or(T... tArr) {
        PriorityQueue priorityQueue = new PriorityQueue(tArr.length, new AnonymousClass3());
        Collections.addAll(priorityQueue, tArr);
        while (priorityQueue.size() > 1) {
            priorityQueue.add((LogicalElement) ((LogicalElement) priorityQueue.poll()).or((LogicalElement) priorityQueue.poll()));
        }
        return (T) priorityQueue.poll();
    }

    public static void orToContainer(BitmapStorage bitmapStorage, EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        if (eWAHCompressedBitmapArr.length < 2) {
            throw new IllegalArgumentException("We need at least two bitmaps");
        }
        PriorityQueue priorityQueue = new PriorityQueue(eWAHCompressedBitmapArr.length, new AnonymousClass4());
        Collections.addAll(priorityQueue, eWAHCompressedBitmapArr);
        while (priorityQueue.size() > 2) {
            priorityQueue.add(((EWAHCompressedBitmap) priorityQueue.poll()).or((EWAHCompressedBitmap) priorityQueue.poll()));
        }
        ((EWAHCompressedBitmap) priorityQueue.poll()).orToContainer((EWAHCompressedBitmap) priorityQueue.poll(), bitmapStorage);
    }

    /* INFO: renamed from: com.googlecode.javaewah.FastAggregation$4, reason: invalid class name */
    class AnonymousClass4 implements Comparator<EWAHCompressedBitmap> {
        AnonymousClass4() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHCompressedBitmap eWAHCompressedBitmap, EWAHCompressedBitmap eWAHCompressedBitmap2) {
            return eWAHCompressedBitmap.sizeInBytes() - eWAHCompressedBitmap2.sizeInBytes();
        }
    }

    /* INFO: renamed from: com.googlecode.javaewah.FastAggregation$5, reason: invalid class name */
    class AnonymousClass5 implements Comparator<EWAHCompressedBitmap> {
        AnonymousClass5() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHCompressedBitmap eWAHCompressedBitmap, EWAHCompressedBitmap eWAHCompressedBitmap2) {
            return eWAHCompressedBitmap.sizeInBytes() - eWAHCompressedBitmap2.sizeInBytes();
        }
    }

    public static EWAHCompressedBitmap or(EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        PriorityQueue priorityQueue = new PriorityQueue(eWAHCompressedBitmapArr.length, new AnonymousClass5());
        Collections.addAll(priorityQueue, eWAHCompressedBitmapArr);
        if (priorityQueue.isEmpty()) {
            return new EWAHCompressedBitmap();
        }
        while (priorityQueue.size() > 1) {
            priorityQueue.add(((EWAHCompressedBitmap) priorityQueue.poll()).or((EWAHCompressedBitmap) priorityQueue.poll()));
        }
        return (EWAHCompressedBitmap) priorityQueue.poll();
    }

    /* INFO: renamed from: com.googlecode.javaewah.FastAggregation$6, reason: invalid class name */
    class AnonymousClass6 implements Comparator<EWAHCompressedBitmap> {
        AnonymousClass6() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHCompressedBitmap eWAHCompressedBitmap, EWAHCompressedBitmap eWAHCompressedBitmap2) {
            return eWAHCompressedBitmap.sizeInBytes() - eWAHCompressedBitmap2.sizeInBytes();
        }
    }

    public static EWAHCompressedBitmap xor(EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        PriorityQueue priorityQueue = new PriorityQueue(eWAHCompressedBitmapArr.length, new AnonymousClass6());
        Collections.addAll(priorityQueue, eWAHCompressedBitmapArr);
        if (priorityQueue.isEmpty()) {
            return new EWAHCompressedBitmap();
        }
        while (priorityQueue.size() > 1) {
            priorityQueue.add(((EWAHCompressedBitmap) priorityQueue.poll()).xor((EWAHCompressedBitmap) priorityQueue.poll()));
        }
        return (EWAHCompressedBitmap) priorityQueue.poll();
    }

    /* INFO: renamed from: com.googlecode.javaewah.FastAggregation$7, reason: invalid class name */
    class AnonymousClass7 implements Comparator<EWAHCompressedBitmap> {
        AnonymousClass7() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHCompressedBitmap eWAHCompressedBitmap, EWAHCompressedBitmap eWAHCompressedBitmap2) {
            return eWAHCompressedBitmap.sizeInBytes() - eWAHCompressedBitmap2.sizeInBytes();
        }
    }

    public static EWAHCompressedBitmap or(Iterator<EWAHCompressedBitmap> it) {
        PriorityQueue priorityQueue = new PriorityQueue(32, new AnonymousClass7());
        while (it.hasNext()) {
            priorityQueue.add(it.next());
        }
        if (priorityQueue.isEmpty()) {
            return new EWAHCompressedBitmap();
        }
        while (priorityQueue.size() > 1) {
            priorityQueue.add(((EWAHCompressedBitmap) priorityQueue.poll()).or((EWAHCompressedBitmap) priorityQueue.poll()));
        }
        return (EWAHCompressedBitmap) priorityQueue.poll();
    }

    /* INFO: renamed from: com.googlecode.javaewah.FastAggregation$8, reason: invalid class name */
    class AnonymousClass8 implements Comparator<EWAHCompressedBitmap> {
        AnonymousClass8() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHCompressedBitmap eWAHCompressedBitmap, EWAHCompressedBitmap eWAHCompressedBitmap2) {
            return eWAHCompressedBitmap.sizeInBytes() - eWAHCompressedBitmap2.sizeInBytes();
        }
    }

    public static EWAHCompressedBitmap xor(Iterator<EWAHCompressedBitmap> it) {
        PriorityQueue priorityQueue = new PriorityQueue(32, new AnonymousClass8());
        while (it.hasNext()) {
            priorityQueue.add(it.next());
        }
        if (priorityQueue.isEmpty()) {
            return new EWAHCompressedBitmap();
        }
        while (priorityQueue.size() > 1) {
            priorityQueue.add(((EWAHCompressedBitmap) priorityQueue.poll()).xor((EWAHCompressedBitmap) priorityQueue.poll()));
        }
        return (EWAHCompressedBitmap) priorityQueue.poll();
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.googlecode.javaewah.FastAggregation$9, reason: invalid class name */
    class AnonymousClass9<T> implements Comparator<T> {
        AnonymousClass9() {
        }

        /* WARN: Incorrect types in method signature: (TT;TT;)I */
        @Override // java.util.Comparator
        public int compare(LogicalElement logicalElement, LogicalElement logicalElement2) {
            return logicalElement.sizeInBytes() - logicalElement2.sizeInBytes();
        }
    }

    public static <T extends LogicalElement> T xor(T... tArr) {
        PriorityQueue priorityQueue = new PriorityQueue(tArr.length, new AnonymousClass9());
        Collections.addAll(priorityQueue, tArr);
        while (priorityQueue.size() > 1) {
            priorityQueue.add((LogicalElement) ((LogicalElement) priorityQueue.poll()).xor((LogicalElement) priorityQueue.poll()));
        }
        return (T) priorityQueue.poll();
    }

    public static void xorToContainer(BitmapStorage bitmapStorage, EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        if (eWAHCompressedBitmapArr.length < 2) {
            throw new IllegalArgumentException("We need at least two bitmaps");
        }
        PriorityQueue priorityQueue = new PriorityQueue(eWAHCompressedBitmapArr.length, new AnonymousClass10());
        Collections.addAll(priorityQueue, eWAHCompressedBitmapArr);
        while (priorityQueue.size() > 2) {
            priorityQueue.add(((EWAHCompressedBitmap) priorityQueue.poll()).xor((EWAHCompressedBitmap) priorityQueue.poll()));
        }
        ((EWAHCompressedBitmap) priorityQueue.poll()).xorToContainer((EWAHCompressedBitmap) priorityQueue.poll(), bitmapStorage);
    }

    /* INFO: renamed from: com.googlecode.javaewah.FastAggregation$10, reason: invalid class name */
    class AnonymousClass10 implements Comparator<EWAHCompressedBitmap> {
        AnonymousClass10() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHCompressedBitmap eWAHCompressedBitmap, EWAHCompressedBitmap eWAHCompressedBitmap2) {
            return eWAHCompressedBitmap.sizeInBytes() - eWAHCompressedBitmap2.sizeInBytes();
        }
    }
}

package com.googlecode.javaewah32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/* INFO: loaded from: classes4.dex */
public final class FastAggregation32 {
    private FastAggregation32() {
    }

    public static EWAHCompressedBitmap32 bufferedand(int i, EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        EWAHCompressedBitmap32 eWAHCompressedBitmap32 = new EWAHCompressedBitmap32();
        bufferedandWithContainer(eWAHCompressedBitmap32, i, eWAHCompressedBitmap32Arr);
        return eWAHCompressedBitmap32;
    }

    public static void bufferedandWithContainer(BitmapStorage32 bitmapStorage32, int i, EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        LinkedList linkedList = new LinkedList();
        for (EWAHCompressedBitmap32 eWAHCompressedBitmap32 : eWAHCompressedBitmap32Arr) {
            linkedList.add(new IteratingBufferedRunningLengthWord32(eWAHCompressedBitmap32));
        }
        int[] iArr = new int[i * eWAHCompressedBitmap32Arr.length];
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            if (((IteratingRLW32) it.next()).size() == 0) {
                linkedList.clear();
                break;
            }
        }
        while (!linkedList.isEmpty()) {
            Arrays.fill(iArr, -1);
            Iterator it2 = linkedList.iterator();
            int i2 = Integer.MAX_VALUE;
            while (it2.hasNext()) {
                int iInplaceand = IteratorAggregation32.inplaceand(iArr, (IteratingRLW32) it2.next());
                if (iInplaceand < i2) {
                    i2 = iInplaceand;
                }
            }
            for (int i3 = 0; i3 < i2; i3++) {
                bitmapStorage32.addWord(iArr[i3]);
            }
            Iterator it3 = linkedList.iterator();
            while (it3.hasNext()) {
                if (((IteratingRLW32) it3.next()).size() == 0) {
                    linkedList.clear();
                    break;
                }
            }
        }
    }

    public static EWAHCompressedBitmap32 bufferedor(int i, EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        EWAHCompressedBitmap32 eWAHCompressedBitmap32 = new EWAHCompressedBitmap32();
        bufferedorWithContainer(eWAHCompressedBitmap32, i, eWAHCompressedBitmap32Arr);
        return eWAHCompressedBitmap32;
    }

    /* INFO: renamed from: com.googlecode.javaewah32.FastAggregation32$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<EWAHCompressedBitmap32> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHCompressedBitmap32 eWAHCompressedBitmap32, EWAHCompressedBitmap32 eWAHCompressedBitmap33) {
            return eWAHCompressedBitmap33.sizeInBits() - eWAHCompressedBitmap32.sizeInBits();
        }
    }

    public static void bufferedorWithContainer(BitmapStorage32 bitmapStorage32, int i, EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        EWAHCompressedBitmap32[] eWAHCompressedBitmap32Arr2 = (EWAHCompressedBitmap32[]) eWAHCompressedBitmap32Arr.clone();
        Arrays.sort(eWAHCompressedBitmap32Arr2, new AnonymousClass1());
        ArrayList arrayList = new ArrayList();
        int iSizeInBits = 0;
        for (EWAHCompressedBitmap32 eWAHCompressedBitmap32 : eWAHCompressedBitmap32Arr2) {
            if (eWAHCompressedBitmap32.sizeInBits() > iSizeInBits) {
                iSizeInBits = eWAHCompressedBitmap32.sizeInBits();
            }
            arrayList.add(new IteratingBufferedRunningLengthWord32(eWAHCompressedBitmap32));
        }
        int[] iArr = new int[i];
        int size = arrayList.size();
        while (size > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (((IteratingBufferedRunningLengthWord32) arrayList.get(i3)).size() > 0) {
                    int iInplaceor = IteratorAggregation32.inplaceor(iArr, (IteratingRLW32) arrayList.get(i3));
                    if (iInplaceor > i2) {
                        i2 = iInplaceor;
                    }
                } else {
                    size = i3;
                }
            }
            for (int i4 = 0; i4 < i2; i4++) {
                bitmapStorage32.addWord(iArr[i4]);
            }
            Arrays.fill(iArr, 0);
        }
        bitmapStorage32.setSizeInBitsWithinLastWord(iSizeInBits);
    }

    public static EWAHCompressedBitmap32 bufferedxor(int i, EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        EWAHCompressedBitmap32 eWAHCompressedBitmap32 = new EWAHCompressedBitmap32();
        bufferedxorWithContainer(eWAHCompressedBitmap32, i, eWAHCompressedBitmap32Arr);
        return eWAHCompressedBitmap32;
    }

    /* INFO: renamed from: com.googlecode.javaewah32.FastAggregation32$2, reason: invalid class name */
    class AnonymousClass2 implements Comparator<EWAHCompressedBitmap32> {
        AnonymousClass2() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHCompressedBitmap32 eWAHCompressedBitmap32, EWAHCompressedBitmap32 eWAHCompressedBitmap33) {
            return eWAHCompressedBitmap33.sizeInBits() - eWAHCompressedBitmap32.sizeInBits();
        }
    }

    public static void bufferedxorWithContainer(BitmapStorage32 bitmapStorage32, int i, EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        EWAHCompressedBitmap32[] eWAHCompressedBitmap32Arr2 = (EWAHCompressedBitmap32[]) eWAHCompressedBitmap32Arr.clone();
        Arrays.sort(eWAHCompressedBitmap32Arr2, new AnonymousClass2());
        ArrayList arrayList = new ArrayList();
        int iSizeInBits = 0;
        for (EWAHCompressedBitmap32 eWAHCompressedBitmap32 : eWAHCompressedBitmap32Arr2) {
            if (eWAHCompressedBitmap32.sizeInBits() > iSizeInBits) {
                iSizeInBits = eWAHCompressedBitmap32.sizeInBits();
            }
            arrayList.add(new IteratingBufferedRunningLengthWord32(eWAHCompressedBitmap32));
        }
        int[] iArr = new int[i];
        int size = arrayList.size();
        while (size > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (((IteratingBufferedRunningLengthWord32) arrayList.get(i3)).size() > 0) {
                    int iInplacexor = IteratorAggregation32.inplacexor(iArr, (IteratingRLW32) arrayList.get(i3));
                    if (iInplacexor > i2) {
                        i2 = iInplacexor;
                    }
                } else {
                    size = i3;
                }
            }
            for (int i4 = 0; i4 < i2; i4++) {
                bitmapStorage32.addWord(iArr[i4]);
            }
            Arrays.fill(iArr, 0);
        }
        bitmapStorage32.setSizeInBitsWithinLastWord(iSizeInBits);
    }

    public static void orToContainer(BitmapStorage32 bitmapStorage32, EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        if (eWAHCompressedBitmap32Arr.length < 2) {
            throw new IllegalArgumentException("We need at least two bitmaps");
        }
        PriorityQueue priorityQueue = new PriorityQueue(eWAHCompressedBitmap32Arr.length, new AnonymousClass3());
        Collections.addAll(priorityQueue, eWAHCompressedBitmap32Arr);
        while (priorityQueue.size() > 2) {
            priorityQueue.add(((EWAHCompressedBitmap32) priorityQueue.poll()).or((EWAHCompressedBitmap32) priorityQueue.poll()));
        }
        ((EWAHCompressedBitmap32) priorityQueue.poll()).orToContainer((EWAHCompressedBitmap32) priorityQueue.poll(), bitmapStorage32);
    }

    /* INFO: renamed from: com.googlecode.javaewah32.FastAggregation32$3, reason: invalid class name */
    class AnonymousClass3 implements Comparator<EWAHCompressedBitmap32> {
        AnonymousClass3() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHCompressedBitmap32 eWAHCompressedBitmap32, EWAHCompressedBitmap32 eWAHCompressedBitmap33) {
            return eWAHCompressedBitmap32.sizeInBytes() - eWAHCompressedBitmap33.sizeInBytes();
        }
    }

    /* INFO: renamed from: com.googlecode.javaewah32.FastAggregation32$4, reason: invalid class name */
    class AnonymousClass4 implements Comparator<EWAHCompressedBitmap32> {
        AnonymousClass4() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHCompressedBitmap32 eWAHCompressedBitmap32, EWAHCompressedBitmap32 eWAHCompressedBitmap33) {
            return eWAHCompressedBitmap32.sizeInBytes() - eWAHCompressedBitmap33.sizeInBytes();
        }
    }

    public static EWAHCompressedBitmap32 or(EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        PriorityQueue priorityQueue = new PriorityQueue(eWAHCompressedBitmap32Arr.length, new AnonymousClass4());
        Collections.addAll(priorityQueue, eWAHCompressedBitmap32Arr);
        if (priorityQueue.isEmpty()) {
            return new EWAHCompressedBitmap32();
        }
        while (priorityQueue.size() > 1) {
            priorityQueue.add(((EWAHCompressedBitmap32) priorityQueue.poll()).or((EWAHCompressedBitmap32) priorityQueue.poll()));
        }
        return (EWAHCompressedBitmap32) priorityQueue.poll();
    }

    /* INFO: renamed from: com.googlecode.javaewah32.FastAggregation32$5, reason: invalid class name */
    class AnonymousClass5 implements Comparator<EWAHCompressedBitmap32> {
        AnonymousClass5() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHCompressedBitmap32 eWAHCompressedBitmap32, EWAHCompressedBitmap32 eWAHCompressedBitmap33) {
            return eWAHCompressedBitmap32.sizeInBytes() - eWAHCompressedBitmap33.sizeInBytes();
        }
    }

    public static EWAHCompressedBitmap32 xor(EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        PriorityQueue priorityQueue = new PriorityQueue(eWAHCompressedBitmap32Arr.length, new AnonymousClass5());
        Collections.addAll(priorityQueue, eWAHCompressedBitmap32Arr);
        if (priorityQueue.isEmpty()) {
            return new EWAHCompressedBitmap32();
        }
        while (priorityQueue.size() > 1) {
            priorityQueue.add(((EWAHCompressedBitmap32) priorityQueue.poll()).xor((EWAHCompressedBitmap32) priorityQueue.poll()));
        }
        return (EWAHCompressedBitmap32) priorityQueue.poll();
    }

    /* INFO: renamed from: com.googlecode.javaewah32.FastAggregation32$6, reason: invalid class name */
    class AnonymousClass6 implements Comparator<EWAHCompressedBitmap32> {
        AnonymousClass6() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHCompressedBitmap32 eWAHCompressedBitmap32, EWAHCompressedBitmap32 eWAHCompressedBitmap33) {
            return eWAHCompressedBitmap32.sizeInBytes() - eWAHCompressedBitmap33.sizeInBytes();
        }
    }

    public static EWAHCompressedBitmap32 or(Iterator<EWAHCompressedBitmap32> it) {
        PriorityQueue priorityQueue = new PriorityQueue(32, new AnonymousClass6());
        while (it.hasNext()) {
            priorityQueue.add(it.next());
        }
        if (priorityQueue.isEmpty()) {
            return new EWAHCompressedBitmap32();
        }
        while (priorityQueue.size() > 1) {
            priorityQueue.add(((EWAHCompressedBitmap32) priorityQueue.poll()).or((EWAHCompressedBitmap32) priorityQueue.poll()));
        }
        return (EWAHCompressedBitmap32) priorityQueue.poll();
    }

    /* INFO: renamed from: com.googlecode.javaewah32.FastAggregation32$7, reason: invalid class name */
    class AnonymousClass7 implements Comparator<EWAHCompressedBitmap32> {
        AnonymousClass7() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHCompressedBitmap32 eWAHCompressedBitmap32, EWAHCompressedBitmap32 eWAHCompressedBitmap33) {
            return eWAHCompressedBitmap32.sizeInBytes() - eWAHCompressedBitmap33.sizeInBytes();
        }
    }

    public static EWAHCompressedBitmap32 xor(Iterator<EWAHCompressedBitmap32> it) {
        PriorityQueue priorityQueue = new PriorityQueue(32, new AnonymousClass7());
        while (it.hasNext()) {
            priorityQueue.add(it.next());
        }
        if (priorityQueue.isEmpty()) {
            return new EWAHCompressedBitmap32();
        }
        while (priorityQueue.size() > 1) {
            priorityQueue.add(((EWAHCompressedBitmap32) priorityQueue.poll()).xor((EWAHCompressedBitmap32) priorityQueue.poll()));
        }
        return (EWAHCompressedBitmap32) priorityQueue.poll();
    }

    public static void xorToContainer(BitmapStorage32 bitmapStorage32, EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        if (eWAHCompressedBitmap32Arr.length < 2) {
            throw new IllegalArgumentException("We need at least two bitmaps");
        }
        PriorityQueue priorityQueue = new PriorityQueue(eWAHCompressedBitmap32Arr.length, new AnonymousClass8());
        Collections.addAll(priorityQueue, eWAHCompressedBitmap32Arr);
        while (priorityQueue.size() > 2) {
            priorityQueue.add(((EWAHCompressedBitmap32) priorityQueue.poll()).xor((EWAHCompressedBitmap32) priorityQueue.poll()));
        }
        ((EWAHCompressedBitmap32) priorityQueue.poll()).xorToContainer((EWAHCompressedBitmap32) priorityQueue.poll(), bitmapStorage32);
    }

    /* INFO: renamed from: com.googlecode.javaewah32.FastAggregation32$8, reason: invalid class name */
    class AnonymousClass8 implements Comparator<EWAHCompressedBitmap32> {
        AnonymousClass8() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHCompressedBitmap32 eWAHCompressedBitmap32, EWAHCompressedBitmap32 eWAHCompressedBitmap33) {
            return eWAHCompressedBitmap32.sizeInBytes() - eWAHCompressedBitmap33.sizeInBytes();
        }
    }
}

package org.apache.commons.collections4.bloomfilter;

/* INFO: loaded from: classes5.dex */
public class BitMaps {
    private static final int DIVIDE_BY_64 = 6;

    public static long getLongBit(int i) {
        return 1 << i;
    }

    public static int getLongIndex(int i) {
        return i >> 6;
    }

    public static int numberOfBitMaps(int i) {
        return ((i - 1) >> 6) + 1;
    }

    public static boolean contains(long[] jArr, int i) {
        return (getLongBit(i) & jArr[getLongIndex(i)]) != 0;
    }

    public static int mod(long j, int i) {
        long j2 = i;
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (j3 >= j2) {
            j3 -= j2;
        }
        return (int) j3;
    }

    static long[] newBitMap(int i) {
        return new long[numberOfBitMaps(i)];
    }

    static long[] newBitMap(Shape shape) {
        return newBitMap(shape.getNumberOfBits());
    }

    static int numberOfBitMaps(Shape shape) {
        return numberOfBitMaps(shape.getNumberOfBits());
    }

    public static void set(long[] jArr, int i) {
        int longIndex = getLongIndex(i);
        jArr[longIndex] = jArr[longIndex] | getLongBit(i);
    }

    private BitMaps() {
    }
}

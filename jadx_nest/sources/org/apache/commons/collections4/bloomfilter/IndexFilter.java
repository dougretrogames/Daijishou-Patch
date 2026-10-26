package org.apache.commons.collections4.bloomfilter;

import java.util.function.IntPredicate;

/* INFO: loaded from: classes5.dex */
public final class IndexFilter {
    private final IntPredicate consumer;
    private final int size;
    private final IntPredicate tracker;

    static class ArrayTracker implements IntPredicate {
        private int populated;
        private final int[] seen;

        ArrayTracker(Shape shape) {
            this.seen = new int[shape.getNumberOfHashFunctions()];
        }

        @Override // java.util.function.IntPredicate
        public boolean test(int i) {
            if (i < 0) {
                throw new IndexOutOfBoundsException("number may not be less than zero. " + i);
            }
            int i2 = 0;
            while (true) {
                int i3 = this.populated;
                if (i2 < i3) {
                    if (this.seen[i2] == i) {
                        return false;
                    }
                    i2++;
                } else {
                    int[] iArr = this.seen;
                    this.populated = i3 + 1;
                    iArr[i3] = i;
                    return true;
                }
            }
        }
    }

    static class BitMapTracker implements IntPredicate {
        private final long[] bits;

        BitMapTracker(Shape shape) {
            this.bits = BitMaps.newBitMap(shape);
        }

        @Override // java.util.function.IntPredicate
        public boolean test(int i) {
            boolean z = !BitMaps.contains(this.bits, i);
            BitMaps.set(this.bits, i);
            return z;
        }
    }

    public static IntPredicate create(Shape shape, IntPredicate intPredicate) {
        return new IndexFilter$$ExternalSyntheticLambda0(new IndexFilter(shape, intPredicate));
    }

    private IndexFilter(Shape shape, IntPredicate intPredicate) {
        this.size = shape.getNumberOfBits();
        this.consumer = intPredicate;
        if (BitMaps.numberOfBitMaps(shape) * 8 < ((long) shape.getNumberOfHashFunctions()) * 4) {
            this.tracker = new BitMapTracker(shape);
        } else {
            this.tracker = new ArrayTracker(shape);
        }
    }

    public boolean test(int i) {
        if (i >= this.size) {
            throw new IndexOutOfBoundsException(String.format("number too large %d >= %d", Integer.valueOf(i), Integer.valueOf(this.size)));
        }
        if (this.tracker.test(i)) {
            return this.consumer.test(i);
        }
        return true;
    }
}

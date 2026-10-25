package org.apache.commons.collections4.bloomfilter;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.LongPredicate;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface BitMapExtractor {
    boolean processBitMaps(LongPredicate longPredicate);

    /* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.BitMapExtractor$1, reason: invalid class name */
    class AnonymousClass1 implements BitMapExtractor {
        final /* synthetic */ long[] val$bitMaps;

        AnonymousClass1(long[] jArr) {
            this.val$bitMaps = jArr;
        }

        @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
        public long[] asBitMapArray() {
            long[] jArr = this.val$bitMaps;
            return Arrays.copyOf(jArr, jArr.length);
        }

        @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
        public boolean processBitMapPairs(BitMapExtractor bitMapExtractor, LongBiPredicate longBiPredicate) {
            CountingLongPredicate countingLongPredicate = new CountingLongPredicate(this.val$bitMaps, longBiPredicate);
            return bitMapExtractor.processBitMaps(countingLongPredicate) && countingLongPredicate.processRemaining();
        }

        @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
        public boolean processBitMaps(LongPredicate longPredicate) {
            for (long j : this.val$bitMaps) {
                if (!longPredicate.test(j)) {
                    return false;
                }
            }
            return true;
        }
    }

    static BitMapExtractor fromBitMapArray(long... jArr) {
        return new AnonymousClass1(jArr);
    }

    static BitMapExtractor fromIndexExtractor(IndexExtractor indexExtractor, int i) {
        Objects.requireNonNull(indexExtractor, "extractor");
        long[] jArrNewBitMap = BitMaps.newBitMap(i);
        indexExtractor.processIndices(new BitMapExtractor$$ExternalSyntheticLambda1(jArrNewBitMap));
        return fromBitMapArray(jArrNewBitMap);
    }

    static /* synthetic */ boolean lambda$fromIndexExtractor$0(long[] jArr, int i) {
        BitMaps.set(jArr, i);
        return true;
    }

    /* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.BitMapExtractor$1Bits, reason: invalid class name */
    final class C1Bits {
        private long[] data = new long[16];
        private int size;

        C1Bits() {
        }

        boolean add(long j) {
            int i = this.size;
            long[] jArr = this.data;
            if (i == jArr.length) {
                this.data = Arrays.copyOf(jArr, i * 2);
            }
            long[] jArr2 = this.data;
            int i2 = this.size;
            this.size = i2 + 1;
            jArr2[i2] = j;
            return true;
        }

        long[] toArray() {
            int i = this.size;
            long[] jArr = this.data;
            return i == jArr.length ? jArr : Arrays.copyOf(jArr, i);
        }
    }

    default long[] asBitMapArray() {
        C1Bits c1Bits = new C1Bits();
        Objects.requireNonNull(c1Bits);
        processBitMaps(new BitMapExtractor$$ExternalSyntheticLambda0(c1Bits));
        return c1Bits.toArray();
    }

    default boolean processBitMapPairs(BitMapExtractor bitMapExtractor, LongBiPredicate longBiPredicate) {
        CountingLongPredicate countingLongPredicate = new CountingLongPredicate(asBitMapArray(), longBiPredicate);
        return bitMapExtractor.processBitMaps(countingLongPredicate) && countingLongPredicate.processRemaining();
    }
}

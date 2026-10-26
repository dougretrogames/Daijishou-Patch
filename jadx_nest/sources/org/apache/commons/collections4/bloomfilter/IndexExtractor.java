package org.apache.commons.collections4.bloomfilter;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;

/* INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface IndexExtractor {
    boolean processIndices(IntPredicate intPredicate);

    static IndexExtractor fromBitMapExtractor(BitMapExtractor bitMapExtractor) {
        Objects.requireNonNull(bitMapExtractor, "bitMapExtractor");
        return new IndexExtractor$$ExternalSyntheticLambda3(bitMapExtractor);
    }

    /* INFO: renamed from: org.apache.commons.collections4.bloomfilter.IndexExtractor$1, reason: invalid class name */
    class AnonymousClass1 implements LongPredicate {
        final /* synthetic */ IntPredicate val$consumer;
        int wordIdx;

        AnonymousClass1(IntPredicate intPredicate) {
            this.val$consumer = intPredicate;
        }

        @Override // java.util.function.LongPredicate
        public boolean test(long j) {
            int i = this.wordIdx;
            while (j != 0) {
                if ((j & 1) == 1 && !this.val$consumer.test(i)) {
                    return false;
                }
                j >>>= 1;
                i++;
            }
            this.wordIdx += 64;
            return true;
        }
    }

    static /* synthetic */ boolean lambda$fromBitMapExtractor$0(BitMapExtractor bitMapExtractor, IntPredicate intPredicate) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(intPredicate);
        Objects.requireNonNull(anonymousClass1);
        return bitMapExtractor.processBitMaps(new IndexExtractor$$ExternalSyntheticLambda0(anonymousClass1));
    }

    /* INFO: renamed from: org.apache.commons.collections4.bloomfilter.IndexExtractor$2, reason: invalid class name */
    class AnonymousClass2 implements IndexExtractor {
        final /* synthetic */ int[] val$values;

        AnonymousClass2(int[] iArr) {
            this.val$values = iArr;
        }

        @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor
        public int[] asIndexArray() {
            return (int[]) this.val$values.clone();
        }

        @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor, org.apache.commons.collections4.bloomfilter.CellExtractor
        public boolean processIndices(IntPredicate intPredicate) {
            for (int i : this.val$values) {
                if (!intPredicate.test(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    static IndexExtractor fromIndexArray(int... iArr) {
        return new AnonymousClass2(iArr);
    }

    /* INFO: renamed from: org.apache.commons.collections4.bloomfilter.IndexExtractor$1Indices, reason: invalid class name */
    final class C1Indices {
        private int[] data = new int[32];
        private int size;

        C1Indices() {
        }

        boolean add(int i) {
            int[] iArrEnsureCapacityForAdd = IndexUtils.ensureCapacityForAdd(this.data, this.size);
            this.data = iArrEnsureCapacityForAdd;
            int i2 = this.size;
            this.size = i2 + 1;
            iArrEnsureCapacityForAdd[i2] = i;
            return true;
        }

        int[] toArray() {
            int i = this.size;
            int[] iArr = this.data;
            return i == iArr.length ? iArr : Arrays.copyOf(iArr, i);
        }
    }

    default int[] asIndexArray() {
        C1Indices c1Indices = new C1Indices();
        Objects.requireNonNull(c1Indices);
        processIndices(new IndexExtractor$$ExternalSyntheticLambda2(c1Indices));
        return c1Indices.toArray();
    }

    default IndexExtractor uniqueIndices() {
        BitSet bitSet = new BitSet();
        processIndices(new IndexExtractor$$ExternalSyntheticLambda1(bitSet));
        return new AnonymousClass3(this, bitSet);
    }

    static /* synthetic */ boolean lambda$uniqueIndices$1(BitSet bitSet, int i) {
        bitSet.set(i);
        return true;
    }

    /* INFO: renamed from: org.apache.commons.collections4.bloomfilter.IndexExtractor$3, reason: invalid class name */
    class AnonymousClass3 implements IndexExtractor {
        final /* synthetic */ IndexExtractor this$0;
        final /* synthetic */ BitSet val$bitSet;

        @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor
        public IndexExtractor uniqueIndices() {
            return this;
        }

        AnonymousClass3(IndexExtractor indexExtractor, BitSet bitSet) {
            this.val$bitSet = bitSet;
            this.this$0 = indexExtractor;
        }

        @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor, org.apache.commons.collections4.bloomfilter.CellExtractor
        public boolean processIndices(IntPredicate intPredicate) {
            int iNextSetBit = this.val$bitSet.nextSetBit(0);
            while (iNextSetBit >= 0) {
                if (!intPredicate.test(iNextSetBit)) {
                    return false;
                }
                iNextSetBit = this.val$bitSet.nextSetBit(iNextSetBit + 1);
            }
            return true;
        }
    }
}

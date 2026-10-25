package org.apache.commons.collections4.bloomfilter;

import java.util.Objects;
import java.util.function.IntPredicate;

/* JADX INFO: loaded from: classes5.dex */
public class EnhancedDoubleHasher implements Hasher {
    private final long increment;
    private final long initial;

    private static long toLong(byte[] bArr, int i, int i2) {
        int iMin = Math.min(i2, 8) + i;
        long j = 0;
        int i3 = 64;
        while (i < iMin) {
            i3 -= 8;
            j |= ((long) (bArr[i] & 255)) << i3;
            i++;
        }
        return j;
    }

    public EnhancedDoubleHasher(byte[] bArr) {
        if (bArr.length == 0) {
            throw new IllegalArgumentException("buffer length must be greater than 0");
        }
        int length = bArr.length / 2;
        this.initial = toLong(bArr, 0, length);
        this.increment = toLong(bArr, length, bArr.length - length);
    }

    public EnhancedDoubleHasher(long j, long j2) {
        this.initial = j;
        this.increment = j2;
    }

    long getIncrement() {
        return this.increment;
    }

    long getInitial() {
        return this.initial;
    }

    @Override // org.apache.commons.collections4.bloomfilter.Hasher
    public IndexExtractor indices(Shape shape) {
        Objects.requireNonNull(shape, "shape");
        return new AnonymousClass1(this, shape);
    }

    /* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.EnhancedDoubleHasher$1, reason: invalid class name */
    class AnonymousClass1 implements IndexExtractor {
        final /* synthetic */ EnhancedDoubleHasher this$0;
        final /* synthetic */ Shape val$shape;

        AnonymousClass1(EnhancedDoubleHasher enhancedDoubleHasher, Shape shape) {
            this.val$shape = shape;
            this.this$0 = enhancedDoubleHasher;
        }

        @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor
        public int[] asIndexArray() {
            int[] iArr = new int[this.val$shape.getNumberOfHashFunctions()];
            processIndices(new EnhancedDoubleHasher$1$$ExternalSyntheticLambda0(iArr, new int[1]));
            return iArr;
        }

        static /* synthetic */ boolean lambda$asIndexArray$0(int[] iArr, int[] iArr2, int i) {
            int i2 = iArr2[0];
            iArr2[0] = i2 + 1;
            iArr[i2] = i;
            return true;
        }

        @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor, org.apache.commons.collections4.bloomfilter.CellExtractor
        public boolean processIndices(IntPredicate intPredicate) {
            Objects.requireNonNull(intPredicate, "consumer");
            int numberOfBits = this.val$shape.getNumberOfBits();
            int iMod = BitMaps.mod(this.this$0.initial, numberOfBits);
            if (!intPredicate.test(iMod)) {
                return false;
            }
            int iMod2 = BitMaps.mod(this.this$0.increment, numberOfBits);
            int numberOfHashFunctions = this.val$shape.getNumberOfHashFunctions();
            if (numberOfHashFunctions >= numberOfBits) {
                int i = 1;
                for (int i2 = 1; i2 < numberOfHashFunctions; i2++) {
                    iMod -= iMod2;
                    if (iMod < 0) {
                        iMod += numberOfBits;
                    }
                    if (!intPredicate.test(iMod)) {
                        return false;
                    }
                    iMod2 -= i;
                    if (iMod2 < 0) {
                        iMod2 += numberOfBits;
                    }
                    i++;
                    if (i == numberOfBits) {
                        i = 0;
                    }
                }
            } else {
                for (int i3 = 1; i3 < numberOfHashFunctions; i3++) {
                    iMod -= iMod2;
                    if (iMod < 0) {
                        iMod += numberOfBits;
                    }
                    if (!intPredicate.test(iMod)) {
                        return false;
                    }
                    iMod2 -= i3;
                    if (iMod2 < 0) {
                        iMod2 += numberOfBits;
                    }
                }
            }
            return true;
        }
    }
}

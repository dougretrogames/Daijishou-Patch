package org.apache.commons.collections4.bloomfilter;

import java.util.function.LongBinaryOperator;

/* INFO: loaded from: classes5.dex */
public final class SetOperations {
    static /* synthetic */ long lambda$andCardinality$0(long j, long j2) {
        return j & j2;
    }

    static /* synthetic */ long lambda$orCardinality$4(long j, long j2) {
        return j | j2;
    }

    static /* synthetic */ long lambda$xorCardinality$5(long j, long j2) {
        return j ^ j2;
    }

    public static int andCardinality(BitMapExtractor bitMapExtractor, BitMapExtractor bitMapExtractor2) {
        return cardinality(bitMapExtractor, bitMapExtractor2, new SetOperations$$ExternalSyntheticLambda5());
    }

    public static int cardinality(BitMapExtractor bitMapExtractor) {
        int[] iArr = new int[1];
        bitMapExtractor.processBitMaps(new SetOperations$$ExternalSyntheticLambda2(iArr));
        return iArr[0];
    }

    static /* synthetic */ boolean lambda$cardinality$1(int[] iArr, long j) {
        iArr[0] = iArr[0] + Long.bitCount(j);
        return true;
    }

    private static int cardinality(BitMapExtractor bitMapExtractor, BitMapExtractor bitMapExtractor2, LongBinaryOperator longBinaryOperator) {
        int[] iArr = new int[1];
        bitMapExtractor.processBitMapPairs(bitMapExtractor2, new SetOperations$$ExternalSyntheticLambda1(iArr, longBinaryOperator));
        return iArr[0];
    }

    static /* synthetic */ boolean lambda$cardinality$2(int[] iArr, LongBinaryOperator longBinaryOperator, long j, long j2) {
        iArr[0] = iArr[0] + Long.bitCount(longBinaryOperator.applyAsLong(j, j2));
        return true;
    }

    public static double cosineDistance(BitMapExtractor bitMapExtractor, BitMapExtractor bitMapExtractor2) {
        return 1.0d - cosineSimilarity(bitMapExtractor, bitMapExtractor2);
    }

    public static double cosineSimilarity(BitMapExtractor bitMapExtractor, BitMapExtractor bitMapExtractor2) {
        int iAndCardinality = andCardinality(bitMapExtractor, bitMapExtractor2);
        if (iAndCardinality == 0) {
            return 0.0d;
        }
        return ((double) iAndCardinality) / Math.sqrt(cardinality(bitMapExtractor) * cardinality(bitMapExtractor2));
    }

    public static double cosineSimilarity(BloomFilter<?> bloomFilter, BloomFilter<?> bloomFilter2) {
        int iAndCardinality = andCardinality(bloomFilter, bloomFilter2);
        if (iAndCardinality == 0) {
            return 0.0d;
        }
        return ((double) iAndCardinality) / Math.sqrt(bloomFilter.cardinality() * bloomFilter2.cardinality());
    }

    public static int hammingDistance(BitMapExtractor bitMapExtractor, BitMapExtractor bitMapExtractor2) {
        return xorCardinality(bitMapExtractor, bitMapExtractor2);
    }

    public static double jaccardDistance(BitMapExtractor bitMapExtractor, BitMapExtractor bitMapExtractor2) {
        return 1.0d - jaccardSimilarity(bitMapExtractor, bitMapExtractor2);
    }

    public static double jaccardSimilarity(BitMapExtractor bitMapExtractor, BitMapExtractor bitMapExtractor2) {
        int[] iArr = new int[2];
        bitMapExtractor.processBitMapPairs(bitMapExtractor2, new SetOperations$$ExternalSyntheticLambda3(iArr));
        int i = iArr[0];
        if (i == 0) {
            return 0.0d;
        }
        return ((double) i) / ((double) iArr[1]);
    }

    static /* synthetic */ boolean lambda$jaccardSimilarity$3(int[] iArr, long j, long j2) {
        iArr[0] = iArr[0] + Long.bitCount(j & j2);
        iArr[1] = iArr[1] + Long.bitCount(j | j2);
        return true;
    }

    public static int orCardinality(BitMapExtractor bitMapExtractor, BitMapExtractor bitMapExtractor2) {
        return cardinality(bitMapExtractor, bitMapExtractor2, new SetOperations$$ExternalSyntheticLambda4());
    }

    public static int xorCardinality(BitMapExtractor bitMapExtractor, BitMapExtractor bitMapExtractor2) {
        return cardinality(bitMapExtractor, bitMapExtractor2, new SetOperations$$ExternalSyntheticLambda0());
    }

    private SetOperations() {
    }
}

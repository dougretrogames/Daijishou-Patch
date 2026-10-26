package org.apache.commons.collections4.bloomfilter;

import java.util.Objects;
import org.apache.commons.collections4.bloomfilter.BloomFilter;

/* INFO: loaded from: classes5.dex */
public interface BloomFilter<T extends BloomFilter<T>> extends IndexExtractor, BitMapExtractor {
    public static final int SPARSE = 1;

    static /* synthetic */ boolean lambda$contains$0(long j, long j2) {
        return (j & j2) == j2;
    }

    static /* synthetic */ boolean lambda$isEmpty$1(long j) {
        return j == 0;
    }

    int cardinality();

    int characteristics();

    void clear();

    boolean contains(IndexExtractor indexExtractor);

    T copy();

    Shape getShape();

    boolean merge(BitMapExtractor bitMapExtractor);

    boolean merge(IndexExtractor indexExtractor);

    @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor
    default IndexExtractor uniqueIndices() {
        return this;
    }

    default boolean contains(BitMapExtractor bitMapExtractor) {
        return processBitMapPairs(bitMapExtractor, new BloomFilter$$ExternalSyntheticLambda1());
    }

    default boolean contains(BloomFilter<?> bloomFilter) {
        Objects.requireNonNull(bloomFilter, "other");
        return (characteristics() & 1) != 0 ? contains((IndexExtractor) bloomFilter) : contains((BitMapExtractor) bloomFilter);
    }

    default boolean contains(Hasher hasher) {
        Objects.requireNonNull(hasher, "Hasher");
        return contains(hasher.indices(getShape()));
    }

    default int estimateIntersection(BloomFilter<?> bloomFilter) {
        long jRound;
        Objects.requireNonNull(bloomFilter, "other");
        double dEstimateN = getShape().estimateN(cardinality());
        double dEstimateN2 = getShape().estimateN(bloomFilter.cardinality());
        if (Double.isInfinite(dEstimateN) && Double.isInfinite(dEstimateN2)) {
            return Integer.MAX_VALUE;
        }
        if (Double.isInfinite(dEstimateN)) {
            jRound = Math.round(dEstimateN2);
        } else if (Double.isInfinite(dEstimateN2)) {
            jRound = Math.round(dEstimateN);
        } else {
            BloomFilter bloomFilterCopy = copy();
            bloomFilterCopy.merge(bloomFilter);
            double dEstimateN3 = getShape().estimateN(bloomFilterCopy.cardinality());
            if (Double.isInfinite(dEstimateN3)) {
                throw new IllegalArgumentException("The estimated N for the union of the filters is infinite");
            }
            jRound = Math.round((dEstimateN + dEstimateN2) - dEstimateN3);
            if (jRound < 0) {
                jRound = 0;
            }
        }
        if (jRound > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jRound;
    }

    default int estimateN() {
        double dEstimateN = getShape().estimateN(cardinality());
        if (Double.isInfinite(dEstimateN)) {
            return Integer.MAX_VALUE;
        }
        if (Double.isNaN(dEstimateN)) {
            throw new IllegalArgumentException("Cardinality too large: " + cardinality());
        }
        long jRound = Math.round(dEstimateN);
        if (jRound > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jRound;
    }

    default int estimateUnion(BloomFilter<?> bloomFilter) {
        Objects.requireNonNull(bloomFilter, "other");
        BloomFilter bloomFilterCopy = copy();
        bloomFilterCopy.merge(bloomFilter);
        return bloomFilterCopy.estimateN();
    }

    default boolean isEmpty() {
        return processBitMaps(new BloomFilter$$ExternalSyntheticLambda0());
    }

    default boolean isFull() {
        return cardinality() == getShape().getNumberOfBits();
    }

    default boolean merge(BloomFilter<?> bloomFilter) {
        return (characteristics() & 1) != 0 ? merge((IndexExtractor) bloomFilter) : merge((BitMapExtractor) bloomFilter);
    }

    default boolean merge(Hasher hasher) {
        Objects.requireNonNull(hasher, "hasher");
        return merge(hasher.indices(getShape()));
    }
}

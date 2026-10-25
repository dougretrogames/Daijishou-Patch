package org.apache.commons.collections4.bloomfilter;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public interface CountingBloomFilter extends BloomFilter<CountingBloomFilter>, CellExtractor {
    boolean add(CellExtractor cellExtractor);

    int getMaxCell();

    int getMaxInsert(CellExtractor cellExtractor);

    boolean isValid();

    boolean subtract(CellExtractor cellExtractor);

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter, org.apache.commons.collections4.bloomfilter.IndexExtractor
    default IndexExtractor uniqueIndices() {
        return this;
    }

    default int getMaxInsert(BitMapExtractor bitMapExtractor) {
        if (!contains(bitMapExtractor)) {
            return 0;
        }
        int[] iArr = {Integer.MAX_VALUE};
        processCells(new CountingBloomFilter$$ExternalSyntheticLambda0(bitMapExtractor.asBitMapArray(), iArr));
        return iArr[0];
    }

    static /* synthetic */ boolean lambda$getMaxInsert$0(long[] jArr, int[] iArr, int i, int i2) {
        if ((jArr[BitMaps.getLongIndex(i)] & BitMaps.getLongBit(i)) == 0) {
            return true;
        }
        int i3 = iArr[0];
        if (i3 <= i2) {
            i2 = i3;
        }
        iArr[0] = i2;
        return true;
    }

    default int getMaxInsert(BloomFilter<?> bloomFilter) {
        return getMaxInsert((BitMapExtractor) bloomFilter);
    }

    default int getMaxInsert(Hasher hasher) {
        return getMaxInsert(hasher.indices(getShape()));
    }

    default int getMaxInsert(IndexExtractor indexExtractor) {
        return getMaxInsert(CellExtractor.from(indexExtractor.uniqueIndices()));
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    default boolean merge(BitMapExtractor bitMapExtractor) {
        return merge(IndexExtractor.fromBitMapExtractor(bitMapExtractor));
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    default boolean merge(BloomFilter<?> bloomFilter) {
        Objects.requireNonNull(bloomFilter, "other");
        return merge((IndexExtractor) bloomFilter);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    default boolean merge(Hasher hasher) {
        Objects.requireNonNull(hasher, "hasher");
        return merge(hasher.indices(getShape()));
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    default boolean merge(IndexExtractor indexExtractor) {
        Objects.requireNonNull(indexExtractor, "indexExtractor");
        try {
            return add(CellExtractor.from(indexExtractor.uniqueIndices()));
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format("Filter only accepts values in the [0,%d) range", Integer.valueOf(getShape().getNumberOfBits())), e);
        }
    }

    default boolean remove(BitMapExtractor bitMapExtractor) {
        return remove(IndexExtractor.fromBitMapExtractor(bitMapExtractor));
    }

    default boolean remove(BloomFilter<?> bloomFilter) {
        return remove((IndexExtractor) bloomFilter);
    }

    default boolean remove(Hasher hasher) {
        Objects.requireNonNull(hasher, "hasher");
        return remove(hasher.indices(getShape()));
    }

    default boolean remove(IndexExtractor indexExtractor) {
        Objects.requireNonNull(indexExtractor, "indexExtractor");
        try {
            return subtract(CellExtractor.from(indexExtractor.uniqueIndices()));
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalArgumentException(String.format("Filter only accepts values in the [0,%d) range", Integer.valueOf(getShape().getNumberOfBits())));
        }
    }
}

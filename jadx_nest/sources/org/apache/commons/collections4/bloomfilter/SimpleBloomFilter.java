package org.apache.commons.collections4.bloomfilter;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;

/* INFO: loaded from: classes5.dex */
public final class SimpleBloomFilter implements BloomFilter<SimpleBloomFilter> {
    private final long[] bitMap;
    private int cardinality;
    private final Shape shape;

    static /* synthetic */ boolean lambda$isEmpty$1(long j) {
        return j == 0;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int characteristics() {
        return 0;
    }

    public SimpleBloomFilter(Shape shape) {
        Objects.requireNonNull(shape, "shape");
        this.shape = shape;
        this.bitMap = BitMaps.newBitMap(shape);
        this.cardinality = 0;
    }

    private SimpleBloomFilter(SimpleBloomFilter simpleBloomFilter) {
        this.shape = simpleBloomFilter.shape;
        this.bitMap = (long[]) simpleBloomFilter.bitMap.clone();
        this.cardinality = simpleBloomFilter.cardinality;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
    public long[] asBitMapArray() {
        long[] jArr = this.bitMap;
        return Arrays.copyOf(jArr, jArr.length);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int cardinality() {
        int i = this.cardinality;
        if (i >= 0) {
            return i;
        }
        int iCardinality = SetOperations.cardinality(this);
        this.cardinality = iCardinality;
        return iCardinality;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public void clear() {
        Arrays.fill(this.bitMap, 0L);
        this.cardinality = 0;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean contains(IndexExtractor indexExtractor) {
        return indexExtractor.processIndices(new SimpleBloomFilter$$ExternalSyntheticLambda0(this));
    }

    /* INFO: renamed from: lambda$contains$0$org-apache-commons-collections4-bloomfilter-SimpleBloomFilter, reason: not valid java name */
    /* synthetic */ boolean m5535x76995088(int i) {
        return BitMaps.contains(this.bitMap, i);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public SimpleBloomFilter copy() {
        return new SimpleBloomFilter(this);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public Shape getShape() {
        return this.shape;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean isEmpty() {
        return this.cardinality == 0 || processBitMaps(new SimpleBloomFilter$$ExternalSyntheticLambda1());
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(BitMapExtractor bitMapExtractor) {
        Objects.requireNonNull(bitMapExtractor, "bitMapExtractor");
        try {
            int[] iArr = new int[1];
            bitMapExtractor.processBitMaps(new SimpleBloomFilter$$ExternalSyntheticLambda2(this, iArr));
            iArr[0] = iArr[0] - 1;
            int longIndex = BitMaps.getLongIndex(this.shape.getNumberOfBits());
            if (longIndex == iArr[0] && (this.bitMap[longIndex] >> this.shape.getNumberOfBits()) != 0) {
                throw new IllegalArgumentException(String.format("BitMapExtractor set a bit higher than the limit for the shape: %s", Integer.valueOf(this.shape.getNumberOfBits())));
            }
            this.cardinality = -1;
            return true;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format("BitMapExtractor should send at most %s maps", Integer.valueOf(this.bitMap.length)), e);
        }
    }

    /* INFO: renamed from: lambda$merge$2$org-apache-commons-collections4-bloomfilter-SimpleBloomFilter, reason: not valid java name */
    /* synthetic */ boolean m5536x2a80fc9(int[] iArr, long j) {
        long[] jArr = this.bitMap;
        int i = iArr[0];
        iArr[0] = i + 1;
        jArr[i] = jArr[i] | j;
        return true;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(BloomFilter<?> bloomFilter) {
        Objects.requireNonNull(bloomFilter, "other");
        if ((bloomFilter.characteristics() & 1) != 0) {
            merge((IndexExtractor) bloomFilter);
        } else {
            merge((BitMapExtractor) bloomFilter);
        }
        return true;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(Hasher hasher) {
        Objects.requireNonNull(hasher, "hasher");
        return merge(hasher.indices(this.shape));
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(IndexExtractor indexExtractor) {
        Objects.requireNonNull(indexExtractor, "indexExtractor");
        indexExtractor.processIndices(new SimpleBloomFilter$$ExternalSyntheticLambda3(this));
        this.cardinality = -1;
        return true;
    }

    /* INFO: renamed from: lambda$merge$3$org-apache-commons-collections4-bloomfilter-SimpleBloomFilter, reason: not valid java name */
    /* synthetic */ boolean m5537xf637940a(int i) {
        if (i < 0 || i >= this.shape.getNumberOfBits()) {
            throw new IllegalArgumentException(String.format("IndexExtractor should only send values in the range[0,%s)", Integer.valueOf(this.shape.getNumberOfBits())));
        }
        BitMaps.set(this.bitMap, i);
        return true;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
    public boolean processBitMapPairs(BitMapExtractor bitMapExtractor, LongBiPredicate longBiPredicate) {
        CountingLongPredicate countingLongPredicate = new CountingLongPredicate(this.bitMap, longBiPredicate);
        return bitMapExtractor.processBitMaps(countingLongPredicate) && countingLongPredicate.processRemaining();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
    public boolean processBitMaps(LongPredicate longPredicate) {
        Objects.requireNonNull(longPredicate, "consumer");
        for (long j : this.bitMap) {
            if (!longPredicate.test(j)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor, org.apache.commons.collections4.bloomfilter.CellExtractor
    public boolean processIndices(IntPredicate intPredicate) {
        Objects.requireNonNull(intPredicate, "consumer");
        return IndexExtractor.fromBitMapExtractor(this).processIndices(intPredicate);
    }
}

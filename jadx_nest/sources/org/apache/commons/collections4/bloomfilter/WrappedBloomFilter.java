package org.apache.commons.collections4.bloomfilter;

import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import org.apache.commons.collections4.bloomfilter.BloomFilter;
import org.apache.commons.collections4.bloomfilter.WrappedBloomFilter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class WrappedBloomFilter<T extends WrappedBloomFilter<T, W>, W extends BloomFilter<W>> implements BloomFilter<T> {
    private final W wrapped;

    public WrappedBloomFilter(W w) {
        this.wrapped = w;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
    public long[] asBitMapArray() {
        return this.wrapped.asBitMapArray();
    }

    @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor
    public int[] asIndexArray() {
        return this.wrapped.asIndexArray();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int cardinality() {
        return this.wrapped.cardinality();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int characteristics() {
        return this.wrapped.characteristics();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public void clear() {
        this.wrapped.clear();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean contains(BitMapExtractor bitMapExtractor) {
        return this.wrapped.contains(bitMapExtractor);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean contains(BloomFilter<?> bloomFilter) {
        return this.wrapped.contains(bloomFilter);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean contains(Hasher hasher) {
        return this.wrapped.contains(hasher);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean contains(IndexExtractor indexExtractor) {
        return this.wrapped.contains(indexExtractor);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int estimateIntersection(BloomFilter<?> bloomFilter) {
        return this.wrapped.estimateIntersection(bloomFilter);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int estimateN() {
        return this.wrapped.estimateN();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int estimateUnion(BloomFilter<?> bloomFilter) {
        return this.wrapped.estimateUnion(bloomFilter);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public Shape getShape() {
        return this.wrapped.getShape();
    }

    protected W getWrapped() {
        return this.wrapped;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean isFull() {
        return this.wrapped.isFull();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(BitMapExtractor bitMapExtractor) {
        return this.wrapped.merge(bitMapExtractor);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(BloomFilter<?> bloomFilter) {
        return this.wrapped.merge(bloomFilter);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(Hasher hasher) {
        return this.wrapped.merge(hasher);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(IndexExtractor indexExtractor) {
        return this.wrapped.merge(indexExtractor);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
    public boolean processBitMapPairs(BitMapExtractor bitMapExtractor, LongBiPredicate longBiPredicate) {
        return this.wrapped.processBitMapPairs(bitMapExtractor, longBiPredicate);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
    public boolean processBitMaps(LongPredicate longPredicate) {
        return this.wrapped.processBitMaps(longPredicate);
    }

    @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor, org.apache.commons.collections4.bloomfilter.CellExtractor
    public boolean processIndices(IntPredicate intPredicate) {
        return this.wrapped.processIndices(intPredicate);
    }
}

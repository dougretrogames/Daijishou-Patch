package org.apache.commons.collections4.bloomfilter;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import org.apache.commons.collections4.bloomfilter.BloomFilter;

/* INFO: loaded from: classes5.dex */
public class LayeredBloomFilter<T extends BloomFilter<T>> implements BloomFilter<LayeredBloomFilter<T>>, BloomFilterExtractor {
    private final LayerManager<T> layerManager;
    private final Shape shape;

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int characteristics() {
        return 0;
    }

    private class Finder implements Predicate<BloomFilter> {
        BloomFilter<?> bf;
        int bfIdx;
        int[] result;
        int resultIdx;

        Finder(BloomFilter<?> bloomFilter) {
            this.result = new int[LayeredBloomFilter.this.layerManager.getDepth()];
            this.bf = bloomFilter;
        }

        int[] getResult() {
            return Arrays.copyOf(this.result, this.resultIdx);
        }

        @Override // java.util.function.Predicate
        public boolean test(BloomFilter bloomFilter) {
            if (bloomFilter.contains(this.bf)) {
                int[] iArr = this.result;
                int i = this.resultIdx;
                this.resultIdx = i + 1;
                iArr[i] = this.bfIdx;
            }
            this.bfIdx++;
            return true;
        }
    }

    public LayeredBloomFilter(Shape shape, LayerManager<T> layerManager) {
        this.shape = shape;
        this.layerManager = layerManager;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int cardinality() {
        return SetOperations.cardinality(this);
    }

    public void cleanup() {
        this.layerManager.cleanup();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public final void clear() {
        this.layerManager.clear();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean contains(BitMapExtractor bitMapExtractor) {
        return contains((BloomFilter) createFilter(bitMapExtractor));
    }

    static /* synthetic */ boolean lambda$contains$0(BloomFilter bloomFilter, BloomFilter bloomFilter2) {
        return !bloomFilter2.contains((BloomFilter<?>) bloomFilter);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean contains(BloomFilter bloomFilter) {
        if (bloomFilter instanceof BloomFilterExtractor) {
            return contains((BloomFilterExtractor) bloomFilter);
        }
        return !processBloomFilters(new LayeredBloomFilter$$ExternalSyntheticLambda4(bloomFilter));
    }

    public boolean contains(BloomFilterExtractor bloomFilterExtractor) {
        return bloomFilterExtractor.processBloomFilters(new LayeredBloomFilter$$ExternalSyntheticLambda0(this, new boolean[]{true}));
    }

    /* INFO: renamed from: lambda$contains$1$org-apache-commons-collections4-bloomfilter-LayeredBloomFilter, reason: not valid java name */
    /* synthetic */ boolean m5534x5565950b(boolean[] zArr, BloomFilter bloomFilter) {
        boolean zContains = contains(bloomFilter) & zArr[0];
        zArr[0] = zContains;
        return zContains;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean contains(Hasher hasher) {
        return contains((BloomFilter) createFilter(hasher));
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean contains(IndexExtractor indexExtractor) {
        return contains((BloomFilter) createFilter(indexExtractor));
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public LayeredBloomFilter<T> copy() {
        return new LayeredBloomFilter<>(this.shape, this.layerManager.copy());
    }

    private SimpleBloomFilter createFilter(BitMapExtractor bitMapExtractor) {
        SimpleBloomFilter simpleBloomFilter = new SimpleBloomFilter(this.shape);
        simpleBloomFilter.merge(bitMapExtractor);
        return simpleBloomFilter;
    }

    private SimpleBloomFilter createFilter(Hasher hasher) {
        SimpleBloomFilter simpleBloomFilter = new SimpleBloomFilter(this.shape);
        simpleBloomFilter.merge(hasher);
        return simpleBloomFilter;
    }

    private SimpleBloomFilter createFilter(IndexExtractor indexExtractor) {
        SimpleBloomFilter simpleBloomFilter = new SimpleBloomFilter(this.shape);
        simpleBloomFilter.merge(indexExtractor);
        return simpleBloomFilter;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int estimateN() {
        return flatten().estimateN();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int estimateUnion(BloomFilter bloomFilter) {
        Objects.requireNonNull(bloomFilter, "other");
        SimpleBloomFilter simpleBloomFilterFlatten = flatten();
        simpleBloomFilterFlatten.merge((BloomFilter<?>) bloomFilter);
        return simpleBloomFilterFlatten.estimateN();
    }

    public int[] find(BitMapExtractor bitMapExtractor) {
        SimpleBloomFilter simpleBloomFilter = new SimpleBloomFilter(this.shape);
        simpleBloomFilter.merge(bitMapExtractor);
        return find((BloomFilter) simpleBloomFilter);
    }

    public int[] find(BloomFilter bloomFilter) {
        Finder finder = new Finder(bloomFilter);
        processBloomFilters(finder);
        return finder.getResult();
    }

    public int[] find(Hasher hasher) {
        SimpleBloomFilter simpleBloomFilter = new SimpleBloomFilter(this.shape);
        simpleBloomFilter.merge(hasher);
        return find((BloomFilter) simpleBloomFilter);
    }

    public int[] find(IndexExtractor indexExtractor) {
        SimpleBloomFilter simpleBloomFilter = new SimpleBloomFilter(this.shape);
        simpleBloomFilter.merge(indexExtractor);
        return find((BloomFilter) simpleBloomFilter);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilterExtractor
    public SimpleBloomFilter flatten() {
        SimpleBloomFilter simpleBloomFilter = new SimpleBloomFilter(this.shape);
        Objects.requireNonNull(simpleBloomFilter);
        processBloomFilters(new LayeredBloomFilter$$ExternalSyntheticLambda1(simpleBloomFilter));
        return simpleBloomFilter;
    }

    public T get(int i) {
        return (T) this.layerManager.get(i);
    }

    public final int getDepth() {
        return this.layerManager.getDepth();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public final Shape getShape() {
        return this.shape;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean isEmpty() {
        return processBloomFilters(new LayeredBloomFilter$$ExternalSyntheticLambda2());
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(BitMapExtractor bitMapExtractor) {
        return this.layerManager.getTarget().merge(bitMapExtractor);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(BloomFilter bloomFilter) {
        return this.layerManager.getTarget().merge((BloomFilter<?>) bloomFilter);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(IndexExtractor indexExtractor) {
        return this.layerManager.getTarget().merge(indexExtractor);
    }

    public void next() {
        this.layerManager.next();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
    public boolean processBitMaps(LongPredicate longPredicate) {
        return flatten().processBitMaps(longPredicate);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilterExtractor
    public final boolean processBloomFilters(Predicate<BloomFilter> predicate) {
        return this.layerManager.processBloomFilters(predicate);
    }

    @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor, org.apache.commons.collections4.bloomfilter.CellExtractor
    public boolean processIndices(IntPredicate intPredicate) {
        return processBloomFilters(new LayeredBloomFilter$$ExternalSyntheticLambda3(intPredicate));
    }
}

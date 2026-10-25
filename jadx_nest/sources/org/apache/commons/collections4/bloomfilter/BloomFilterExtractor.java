package org.apache.commons.collections4.bloomfilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface BloomFilterExtractor {
    boolean processBloomFilters(Predicate<BloomFilter> predicate);

    /* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.BloomFilterExtractor$1, reason: invalid class name */
    class AnonymousClass1 implements BloomFilterExtractor {
        final /* synthetic */ BloomFilter[] val$filters;

        AnonymousClass1(BloomFilter[] bloomFilterArr) {
            this.val$filters = bloomFilterArr;
        }

        @Override // org.apache.commons.collections4.bloomfilter.BloomFilterExtractor
        public BloomFilter[] asBloomFilterArray() {
            return (BloomFilter[]) this.val$filters.clone();
        }

        @Override // org.apache.commons.collections4.bloomfilter.BloomFilterExtractor
        public boolean processBloomFilterPair(BloomFilterExtractor bloomFilterExtractor, BiPredicate<BloomFilter, BloomFilter> biPredicate) {
            CountingPredicate countingPredicate = new CountingPredicate(this.val$filters, biPredicate);
            return bloomFilterExtractor.processBloomFilters(countingPredicate) && countingPredicate.processRemaining();
        }

        @Override // org.apache.commons.collections4.bloomfilter.BloomFilterExtractor
        public boolean processBloomFilters(Predicate<BloomFilter> predicate) {
            return Arrays.stream(this.val$filters).allMatch(predicate);
        }
    }

    static <T extends BloomFilter<T>> BloomFilterExtractor fromBloomFilterArray(BloomFilter<?>... bloomFilterArr) {
        Objects.requireNonNull(bloomFilterArr, "filters");
        return new AnonymousClass1(bloomFilterArr);
    }

    default BloomFilter[] asBloomFilterArray() {
        ArrayList arrayList = new ArrayList();
        processBloomFilters(new BloomFilterExtractor$$ExternalSyntheticLambda1(arrayList));
        return (BloomFilter[]) arrayList.toArray(new BloomFilter[0]);
    }

    default BloomFilter flatten() {
        AtomicReference atomicReference = new AtomicReference();
        processBloomFilters(new BloomFilterExtractor$$ExternalSyntheticLambda0(atomicReference));
        return (BloomFilter) Objects.requireNonNull((BloomFilter) atomicReference.get(), "No filters.");
    }

    static /* synthetic */ boolean lambda$flatten$1(AtomicReference atomicReference, BloomFilter bloomFilter) {
        if (atomicReference.get() == null) {
            atomicReference.set(new SimpleBloomFilter(bloomFilter.getShape()));
        }
        return ((BloomFilter) atomicReference.get()).merge((BloomFilter<?>) bloomFilter);
    }

    default boolean processBloomFilterPair(BloomFilterExtractor bloomFilterExtractor, BiPredicate<BloomFilter, BloomFilter> biPredicate) {
        CountingPredicate countingPredicate = new CountingPredicate(asBloomFilterArray(), biPredicate);
        return bloomFilterExtractor.processBloomFilters(countingPredicate) && countingPredicate.processRemaining();
    }
}

package org.apache.commons.collections4.bloomfilter;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.apache.commons.collections4.bloomfilter.BloomFilter;

/* INFO: loaded from: classes5.dex */
public class LayerManager<T extends BloomFilter<T>> implements BloomFilterExtractor {
    private final Predicate<LayerManager<T>> extendCheck;
    private final Consumer<Deque<T>> filterCleanup;
    private final Supplier<T> filterSupplier;
    private final LinkedList<T> filters;

    /* synthetic */ LayerManager(Supplier supplier, Predicate predicate, Consumer consumer, boolean z, AnonymousClass1 anonymousClass1) {
        this(supplier, predicate, consumer, z);
    }

    public static class Builder<T extends BloomFilter<T>> implements Supplier<LayerManager<T>> {
        private Consumer<Deque<T>> cleanup;
        private Predicate<LayerManager<T>> extendCheck;
        private Supplier<T> supplier;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            this.extendCheck = ExtendCheck.neverAdvance();
            this.cleanup = Cleanup.noCleanup();
        }

        @Override // java.util.function.Supplier
        public LayerManager<T> get() {
            return new LayerManager<>(this.supplier, this.extendCheck, this.cleanup, true, null);
        }

        public Builder<T> setCleanup(Consumer<Deque<T>> consumer) {
            this.cleanup = consumer;
            return this;
        }

        public Builder<T> setExtendCheck(Predicate<LayerManager<T>> predicate) {
            this.extendCheck = predicate;
            return this;
        }

        public Builder<T> setSupplier(Supplier<T> supplier) {
            this.supplier = supplier;
            return this;
        }
    }

    public static final class Cleanup {
        static /* synthetic */ void lambda$noCleanup$0(Deque deque) {
        }

        public static <T extends BloomFilter<T>> Consumer<Deque<T>> noCleanup() {
            return new LayerManager$Cleanup$$ExternalSyntheticLambda1();
        }

        public static <T extends BloomFilter<T>> Consumer<Deque<T>> onMaxSize(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("'maxSize' must be greater than 0");
            }
            return new LayerManager$Cleanup$$ExternalSyntheticLambda3(i);
        }

        static /* synthetic */ void lambda$onMaxSize$1(int i, Deque deque) {
            while (deque.size() > i) {
                deque.removeFirst();
            }
        }

        public static <T extends BloomFilter<T>> Consumer<Deque<T>> removeEmptyTarget() {
            return new LayerManager$Cleanup$$ExternalSyntheticLambda2();
        }

        static /* synthetic */ void lambda$removeEmptyTarget$2(Deque deque) {
            if (deque.isEmpty() || !((BloomFilter) deque.getLast()).isEmpty()) {
                return;
            }
            deque.removeLast();
        }

        public static <T extends BloomFilter<T>> Consumer<Deque<T>> removeIf(Predicate<? super T> predicate) {
            return new LayerManager$Cleanup$$ExternalSyntheticLambda0(predicate);
        }

        private Cleanup() {
        }
    }

    public static final class ExtendCheck {
        static /* synthetic */ boolean lambda$neverAdvance$2(LayerManager layerManager) {
            return false;
        }

        /* INFO: renamed from: org.apache.commons.collections4.bloomfilter.LayerManager$ExtendCheck$1, reason: invalid class name */
        class AnonymousClass1 implements Predicate<LayerManager<T>> {
            int count;
            final /* synthetic */ int val$breakAt;

            AnonymousClass1(int i) {
                this.val$breakAt = i;
            }

            @Override // java.util.function.Predicate
            public boolean test(LayerManager<T> layerManager) {
                int i = this.count + 1;
                this.count = i;
                if (i != this.val$breakAt) {
                    return false;
                }
                this.count = 0;
                return true;
            }
        }

        public static <T extends BloomFilter<T>> Predicate<LayerManager<T>> advanceOnCount(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("'breakAt' must be greater than 0");
            }
            return new AnonymousClass1(i);
        }

        public static <T extends BloomFilter<T>> Predicate<LayerManager<T>> advanceOnPopulated() {
            return new LayerManager$ExtendCheck$$ExternalSyntheticLambda2();
        }

        static /* synthetic */ boolean lambda$advanceOnPopulated$0(LayerManager layerManager) {
            return !layerManager.last().isEmpty();
        }

        public static <T extends BloomFilter<T>> Predicate<LayerManager<T>> advanceOnSaturation(double d) {
            if (d <= 0.0d) {
                throw new IllegalArgumentException("'maxN' must be greater than 0");
            }
            return new LayerManager$ExtendCheck$$ExternalSyntheticLambda0(d);
        }

        static /* synthetic */ boolean lambda$advanceOnSaturation$1(double d, LayerManager layerManager) {
            BloomFilter bloomFilterLast = layerManager.last();
            return d <= bloomFilterLast.getShape().estimateN(bloomFilterLast.cardinality());
        }

        public static <T extends BloomFilter<T>> Predicate<LayerManager<T>> neverAdvance() {
            return new LayerManager$ExtendCheck$$ExternalSyntheticLambda1();
        }

        private ExtendCheck() {
        }
    }

    public static <T extends BloomFilter<T>> Builder<T> builder() {
        return new Builder<>(null);
    }

    private LayerManager(Supplier<T> supplier, Predicate<LayerManager<T>> predicate, Consumer<Deque<T>> consumer, boolean z) {
        this.filters = new LinkedList<>();
        this.filterSupplier = (Supplier) Objects.requireNonNull(supplier, "filterSupplier");
        this.extendCheck = (Predicate) Objects.requireNonNull(predicate, "extendCheck");
        this.filterCleanup = (Consumer) Objects.requireNonNull(consumer, "filterCleanup");
        if (z) {
            addFilter();
        }
    }

    private void addFilter() {
        this.filters.add((T) ((BloomFilter) Objects.requireNonNull(this.filterSupplier.get(), "filterSupplier.get() returned null.")));
    }

    void cleanup() {
        this.filterCleanup.accept(this.filters);
        if (this.filters.isEmpty()) {
            addFilter();
        }
    }

    public final void clear() {
        this.filters.clear();
        addFilter();
    }

    public LayerManager<T> copy() {
        LayerManager<T> layerManager = new LayerManager<>(this.filterSupplier, this.extendCheck, this.filterCleanup, false);
        Iterator<T> it = this.filters.iterator();
        while (it.hasNext()) {
            layerManager.filters.add((T) it.next().copy());
        }
        return layerManager;
    }

    public final T first() {
        return this.filters.getFirst();
    }

    public final T get(int i) {
        if (i < 0 || i >= this.filters.size()) {
            throw new NoSuchElementException(String.format("Depth must be in the range [0,%s)", Integer.valueOf(this.filters.size())));
        }
        return this.filters.get(i);
    }

    public final int getDepth() {
        return this.filters.size();
    }

    public final T getTarget() {
        if (this.extendCheck.test(this)) {
            next();
        }
        return (T) last();
    }

    public final T last() {
        return this.filters.getLast();
    }

    void next() {
        this.filterCleanup.accept(this.filters);
        addFilter();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilterExtractor
    public boolean processBloomFilters(Predicate<BloomFilter> predicate) {
        return this.filters.stream().allMatch(predicate);
    }
}

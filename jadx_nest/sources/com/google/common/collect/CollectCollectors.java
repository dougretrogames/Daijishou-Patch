package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class CollectCollectors {
    private static final Collector<Object, ?, ImmutableList<Object>> TO_IMMUTABLE_LIST = Collector.of(new CollectCollectors$$ExternalSyntheticLambda8(), new CollectCollectors$$ExternalSyntheticLambda12(), new CollectCollectors$$ExternalSyntheticLambda13(), new CollectCollectors$$ExternalSyntheticLambda14(), new Collector.Characteristics[0]);
    private static final Collector<Object, ?, ImmutableSet<Object>> TO_IMMUTABLE_SET = Collector.of(new CollectCollectors$$ExternalSyntheticLambda15(), new CollectCollectors$$ExternalSyntheticLambda16(), new CollectCollectors$$ExternalSyntheticLambda17(), new CollectCollectors$$ExternalSyntheticLambda18(), new Collector.Characteristics[0]);
    private static final Collector<Range<Comparable<?>>, ?, ImmutableRangeSet<Comparable<?>>> TO_IMMUTABLE_RANGE_SET = Collector.of(new CollectCollectors$$ExternalSyntheticLambda19(), new CollectCollectors$$ExternalSyntheticLambda20(), new CollectCollectors$$ExternalSyntheticLambda9(), new CollectCollectors$$ExternalSyntheticLambda10(), new Collector.Characteristics[0]);

    public static /* synthetic */ LinkedHashMap $r8$lambda$9jZrLfmN7qos7GZMvkzgNgs9WjU() {
        return new LinkedHashMap();
    }

    static <E> Collector<E, ?, ImmutableList<E>> toImmutableList() {
        return (Collector<E, ?, ImmutableList<E>>) TO_IMMUTABLE_LIST;
    }

    static <E> Collector<E, ?, ImmutableSet<E>> toImmutableSet() {
        return (Collector<E, ?, ImmutableSet<E>>) TO_IMMUTABLE_SET;
    }

    static <E> Collector<E, ?, ImmutableSortedSet<E>> toImmutableSortedSet(Comparator<? super E> comparator) {
        Preconditions.checkNotNull(comparator);
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda49(comparator), new CollectCollectors$$ExternalSyntheticLambda50(), new CollectCollectors$$ExternalSyntheticLambda51(), new CollectCollectors$$ExternalSyntheticLambda52(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ ImmutableSortedSet.Builder lambda$toImmutableSortedSet$0(Comparator comparator) {
        return new ImmutableSortedSet.Builder(comparator);
    }

    static <E extends Enum<E>> Collector<E, ?, ImmutableSet<E>> toImmutableEnumSet() {
        return (Collector<E, ?, ImmutableSet<E>>) EnumSetAccumulator.TO_IMMUTABLE_ENUM_SET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E extends Enum<E>> Collector<E, EnumSetAccumulator<E>, ImmutableSet<E>> toImmutableEnumSetGeneric() {
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda4(), new CollectCollectors$$ExternalSyntheticLambda5(), new CollectCollectors$$ExternalSyntheticLambda6(), new CollectCollectors$$ExternalSyntheticLambda7(), Collector.Characteristics.UNORDERED);
    }

    static /* synthetic */ EnumSetAccumulator lambda$toImmutableEnumSetGeneric$1() {
        return new EnumSetAccumulator(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class EnumSetAccumulator<E extends Enum<E>> {
        static final Collector<Enum<?>, ?, ImmutableSet<? extends Enum<?>>> TO_IMMUTABLE_ENUM_SET = CollectCollectors.toImmutableEnumSetGeneric();

        @CheckForNull
        private EnumSet<E> set;

        private EnumSetAccumulator() {
        }

        /* synthetic */ EnumSetAccumulator(AnonymousClass1 anonymousClass1) {
            this();
        }

        void add(E e) {
            EnumSet<E> enumSet = this.set;
            if (enumSet == null) {
                this.set = EnumSet.of((Enum) e);
            } else {
                enumSet.add(e);
            }
        }

        EnumSetAccumulator<E> combine(EnumSetAccumulator<E> other) {
            EnumSet<E> enumSet = this.set;
            if (enumSet == null) {
                return other;
            }
            EnumSet<E> enumSet2 = other.set;
            if (enumSet2 == null) {
                return this;
            }
            enumSet.addAll(enumSet2);
            return this;
        }

        ImmutableSet<E> toImmutableSet() {
            EnumSet<E> enumSet = this.set;
            if (enumSet == null) {
                return ImmutableSet.of();
            }
            ImmutableSet<E> immutableSetAsImmutable = ImmutableEnumSet.asImmutable(enumSet);
            this.set = null;
            return immutableSetAsImmutable;
        }
    }

    static <E extends Comparable<? super E>> Collector<Range<E>, ?, ImmutableRangeSet<E>> toImmutableRangeSet() {
        return (Collector<Range<E>, ?, ImmutableRangeSet<E>>) TO_IMMUTABLE_RANGE_SET;
    }

    static <T, E> Collector<T, ?, ImmutableMultiset<E>> toImmutableMultiset(Function<? super T, ? extends E> elementFunction, ToIntFunction<? super T> countFunction) {
        Preconditions.checkNotNull(elementFunction);
        Preconditions.checkNotNull(countFunction);
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda28(), new CollectCollectors$$ExternalSyntheticLambda29(elementFunction, countFunction), new CollectCollectors$$ExternalSyntheticLambda30(), new CollectCollectors$$ExternalSyntheticLambda31(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ Multiset lambda$toImmutableMultiset$3(Multiset multiset, Multiset multiset2) {
        multiset.addAll(multiset2);
        return multiset;
    }

    static <T, E, M extends Multiset<E>> Collector<T, ?, M> toMultiset(Function<? super T, E> elementFunction, ToIntFunction<? super T> countFunction, Supplier<M> multisetSupplier) {
        Preconditions.checkNotNull(elementFunction);
        Preconditions.checkNotNull(countFunction);
        Preconditions.checkNotNull(multisetSupplier);
        return Collector.of(multisetSupplier, new CollectCollectors$$ExternalSyntheticLambda65(elementFunction, countFunction), new CollectCollectors$$ExternalSyntheticLambda67(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ Multiset lambda$toMultiset$6(Multiset multiset, Multiset multiset2) {
        multiset.addAll(multiset2);
        return multiset;
    }

    static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction) {
        Preconditions.checkNotNull(keyFunction);
        Preconditions.checkNotNull(valueFunction);
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda45(), new CollectCollectors$$ExternalSyntheticLambda46(keyFunction, valueFunction), new CollectCollectors$$ExternalSyntheticLambda47(), new CollectCollectors$$ExternalSyntheticLambda48(), new Collector.Characteristics[0]);
    }

    static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction, BinaryOperator<V> mergeFunction) {
        Preconditions.checkNotNull(keyFunction);
        Preconditions.checkNotNull(valueFunction);
        Preconditions.checkNotNull(mergeFunction);
        return Collectors.collectingAndThen(Collectors.toMap(keyFunction, valueFunction, mergeFunction, new CollectCollectors$$ExternalSyntheticLambda62()), new CollectCollectors$$ExternalSyntheticLambda63());
    }

    static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(Comparator<? super K> comparator, Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(keyFunction);
        Preconditions.checkNotNull(valueFunction);
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda55(comparator), new CollectCollectors$$ExternalSyntheticLambda66(keyFunction, valueFunction), new CollectCollectors$$ExternalSyntheticLambda72(), new CollectCollectors$$ExternalSyntheticLambda73(), Collector.Characteristics.UNORDERED);
    }

    static /* synthetic */ ImmutableSortedMap.Builder lambda$toImmutableSortedMap$8(Comparator comparator) {
        return new ImmutableSortedMap.Builder(comparator);
    }

    static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(Comparator<? super K> comparator, Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction, BinaryOperator<V> mergeFunction) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(keyFunction);
        Preconditions.checkNotNull(valueFunction);
        Preconditions.checkNotNull(mergeFunction);
        return Collectors.collectingAndThen(Collectors.toMap(keyFunction, valueFunction, mergeFunction, new CollectCollectors$$ExternalSyntheticLambda37(comparator)), new CollectCollectors$$ExternalSyntheticLambda38());
    }

    static /* synthetic */ TreeMap lambda$toImmutableSortedMap$10(Comparator comparator) {
        return new TreeMap(comparator);
    }

    static <T, K, V> Collector<T, ?, ImmutableBiMap<K, V>> toImmutableBiMap(Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction) {
        Preconditions.checkNotNull(keyFunction);
        Preconditions.checkNotNull(valueFunction);
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda74(), new CollectCollectors$$ExternalSyntheticLambda1(keyFunction, valueFunction), new CollectCollectors$$ExternalSyntheticLambda2(), new CollectCollectors$$ExternalSyntheticLambda3(), new Collector.Characteristics[0]);
    }

    static <T, K extends Enum<K>, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableEnumMap(Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction) {
        Preconditions.checkNotNull(keyFunction);
        Preconditions.checkNotNull(valueFunction);
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda40(), new CollectCollectors$$ExternalSyntheticLambda41(keyFunction, valueFunction), new CollectCollectors$$ExternalSyntheticLambda42(), new CollectCollectors$$ExternalSyntheticLambda43(), Collector.Characteristics.UNORDERED);
    }

    static /* synthetic */ EnumMapAccumulator lambda$toImmutableEnumMap$13() {
        return new EnumMapAccumulator(new CollectCollectors$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ Object lambda$toImmutableEnumMap$12(Object obj, Object obj2) {
        throw new IllegalArgumentException("Multiple values for key: " + obj + ", " + obj2);
    }

    static <T, K extends Enum<K>, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableEnumMap(Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction, BinaryOperator<V> mergeFunction) {
        Preconditions.checkNotNull(keyFunction);
        Preconditions.checkNotNull(valueFunction);
        Preconditions.checkNotNull(mergeFunction);
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda68(mergeFunction), new CollectCollectors$$ExternalSyntheticLambda69(keyFunction, valueFunction), new CollectCollectors$$ExternalSyntheticLambda42(), new CollectCollectors$$ExternalSyntheticLambda43(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ EnumMapAccumulator lambda$toImmutableEnumMap$15(BinaryOperator binaryOperator) {
        return new EnumMapAccumulator(binaryOperator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class EnumMapAccumulator<K extends Enum<K>, V> {

        @CheckForNull
        private EnumMap<K, V> map = null;
        private final BinaryOperator<V> mergeFunction;

        EnumMapAccumulator(BinaryOperator<V> mergeFunction) {
            this.mergeFunction = mergeFunction;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void put(K key, V value) {
            EnumMap<K, V> enumMap = this.map;
            if (enumMap == null) {
                this.map = new EnumMap<>(Collections.singletonMap(key, value));
            } else {
                enumMap.merge(key, value, this.mergeFunction);
            }
        }

        EnumMapAccumulator<K, V> combine(EnumMapAccumulator<K, V> other) {
            if (this.map == null) {
                return other;
            }
            EnumMap<K, V> enumMap = other.map;
            if (enumMap == null) {
                return this;
            }
            enumMap.forEach(new CollectCollectors$EnumMapAccumulator$$ExternalSyntheticLambda0(this));
            return this;
        }

        ImmutableMap<K, V> toImmutableMap() {
            EnumMap<K, V> enumMap = this.map;
            return enumMap == null ? ImmutableMap.of() : ImmutableEnumMap.asImmutable(enumMap);
        }
    }

    static <T, K extends Comparable<? super K>, V> Collector<T, ?, ImmutableRangeMap<K, V>> toImmutableRangeMap(Function<? super T, Range<K>> keyFunction, Function<? super T, ? extends V> valueFunction) {
        Preconditions.checkNotNull(keyFunction);
        Preconditions.checkNotNull(valueFunction);
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda11(), new CollectCollectors$$ExternalSyntheticLambda22(keyFunction, valueFunction), new CollectCollectors$$ExternalSyntheticLambda33(), new CollectCollectors$$ExternalSyntheticLambda44(), new Collector.Characteristics[0]);
    }

    static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> toImmutableListMultimap(Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction) {
        Preconditions.checkNotNull(keyFunction, "keyFunction");
        Preconditions.checkNotNull(valueFunction, "valueFunction");
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda53(), new CollectCollectors$$ExternalSyntheticLambda54(keyFunction, valueFunction), new CollectCollectors$$ExternalSyntheticLambda56(), new CollectCollectors$$ExternalSyntheticLambda57(), new Collector.Characteristics[0]);
    }

    static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> flatteningToImmutableListMultimap(Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends Stream<? extends V>> valuesFunction) {
        Preconditions.checkNotNull(keyFunction);
        Preconditions.checkNotNull(valuesFunction);
        CollectCollectors$$ExternalSyntheticLambda24 collectCollectors$$ExternalSyntheticLambda24 = new CollectCollectors$$ExternalSyntheticLambda24(keyFunction);
        CollectCollectors$$ExternalSyntheticLambda25 collectCollectors$$ExternalSyntheticLambda25 = new CollectCollectors$$ExternalSyntheticLambda25(valuesFunction);
        MultimapBuilder.ListMultimapBuilder<Object, Object> listMultimapBuilderArrayListValues = MultimapBuilder.linkedHashKeys().arrayListValues();
        Objects.requireNonNull(listMultimapBuilderArrayListValues);
        return Collectors.collectingAndThen(flatteningToMultimap(collectCollectors$$ExternalSyntheticLambda24, collectCollectors$$ExternalSyntheticLambda25, new CollectCollectors$$ExternalSyntheticLambda26(listMultimapBuilderArrayListValues)), new CollectCollectors$$ExternalSyntheticLambda27());
    }

    static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> toImmutableSetMultimap(Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction) {
        Preconditions.checkNotNull(keyFunction, "keyFunction");
        Preconditions.checkNotNull(valueFunction, "valueFunction");
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda58(), new CollectCollectors$$ExternalSyntheticLambda59(keyFunction, valueFunction), new CollectCollectors$$ExternalSyntheticLambda60(), new CollectCollectors$$ExternalSyntheticLambda61(), new Collector.Characteristics[0]);
    }

    static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> flatteningToImmutableSetMultimap(Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends Stream<? extends V>> valuesFunction) {
        Preconditions.checkNotNull(keyFunction);
        Preconditions.checkNotNull(valuesFunction);
        CollectCollectors$$ExternalSyntheticLambda32 collectCollectors$$ExternalSyntheticLambda32 = new CollectCollectors$$ExternalSyntheticLambda32(keyFunction);
        CollectCollectors$$ExternalSyntheticLambda34 collectCollectors$$ExternalSyntheticLambda34 = new CollectCollectors$$ExternalSyntheticLambda34(valuesFunction);
        MultimapBuilder.SetMultimapBuilder<Object, Object> setMultimapBuilderLinkedHashSetValues = MultimapBuilder.linkedHashKeys().linkedHashSetValues();
        Objects.requireNonNull(setMultimapBuilderLinkedHashSetValues);
        return Collectors.collectingAndThen(flatteningToMultimap(collectCollectors$$ExternalSyntheticLambda32, collectCollectors$$ExternalSyntheticLambda34, new CollectCollectors$$ExternalSyntheticLambda35(setMultimapBuilderLinkedHashSetValues)), new CollectCollectors$$ExternalSyntheticLambda36());
    }

    static <T, K, V, M extends Multimap<K, V>> Collector<T, ?, M> toMultimap(Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction, Supplier<M> multimapSupplier) {
        Preconditions.checkNotNull(keyFunction);
        Preconditions.checkNotNull(valueFunction);
        Preconditions.checkNotNull(multimapSupplier);
        return Collector.of(multimapSupplier, new CollectCollectors$$ExternalSyntheticLambda70(keyFunction, valueFunction), new CollectCollectors$$ExternalSyntheticLambda71(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ Multimap lambda$toMultimap$25(Multimap multimap, Multimap multimap2) {
        multimap.putAll(multimap2);
        return multimap;
    }

    static <T, K, V, M extends Multimap<K, V>> Collector<T, ?, M> flatteningToMultimap(Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends Stream<? extends V>> valueFunction, Supplier<M> multimapSupplier) {
        Preconditions.checkNotNull(keyFunction);
        Preconditions.checkNotNull(valueFunction);
        Preconditions.checkNotNull(multimapSupplier);
        return Collector.of(multimapSupplier, new CollectCollectors$$ExternalSyntheticLambda21(keyFunction, valueFunction), new CollectCollectors$$ExternalSyntheticLambda23(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ void lambda$flatteningToMultimap$26(Function function, Function function2, Multimap multimap, Object obj) {
        Collection collection = multimap.get(function.apply(obj));
        Stream stream = (Stream) function2.apply(obj);
        Objects.requireNonNull(collection);
        stream.forEachOrdered(new CollectCollectors$$ExternalSyntheticLambda64(collection));
    }

    static /* synthetic */ Multimap lambda$flatteningToMultimap$27(Multimap multimap, Multimap multimap2) {
        multimap.putAll(multimap2);
        return multimap;
    }

    private CollectCollectors() {
    }
}

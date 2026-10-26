package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class MultimapBuilder<K0, V0> {
    private static final int DEFAULT_EXPECTED_KEYS = 8;

    public abstract <K extends K0, V extends V0> Multimap<K, V> build();

    /* synthetic */ MultimapBuilder(AnonymousClass1 anonymousClass1) {
        this();
    }

    private MultimapBuilder() {
    }

    public static MultimapBuilderWithKeys<Object> hashKeys() {
        return hashKeys(8);
    }

    /* INFO: renamed from: com.google.common.collect.MultimapBuilder$1, reason: invalid class name */
    class AnonymousClass1 extends MultimapBuilderWithKeys<Object> {
        final /* synthetic */ int val$expectedKeys;

        AnonymousClass1(final int val$expectedKeys) {
            this.val$expectedKeys = val$expectedKeys;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        <K, V> Map<K, Collection<V>> createMap() {
            return Platform.newHashMapWithExpectedSize(this.val$expectedKeys);
        }
    }

    public static MultimapBuilderWithKeys<Object> hashKeys(int expectedKeys) {
        CollectPreconditions.checkNonnegative(expectedKeys, "expectedKeys");
        return new AnonymousClass1(expectedKeys);
    }

    public static MultimapBuilderWithKeys<Object> linkedHashKeys() {
        return linkedHashKeys(8);
    }

    /* INFO: renamed from: com.google.common.collect.MultimapBuilder$2, reason: invalid class name */
    class AnonymousClass2 extends MultimapBuilderWithKeys<Object> {
        final /* synthetic */ int val$expectedKeys;

        AnonymousClass2(final int val$expectedKeys) {
            this.val$expectedKeys = val$expectedKeys;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        <K, V> Map<K, Collection<V>> createMap() {
            return Platform.newLinkedHashMapWithExpectedSize(this.val$expectedKeys);
        }
    }

    public static MultimapBuilderWithKeys<Object> linkedHashKeys(int expectedKeys) {
        CollectPreconditions.checkNonnegative(expectedKeys, "expectedKeys");
        return new AnonymousClass2(expectedKeys);
    }

    public static MultimapBuilderWithKeys<Comparable> treeKeys() {
        return treeKeys(Ordering.natural());
    }

    /* INFO: renamed from: com.google.common.collect.MultimapBuilder$3, reason: invalid class name */
    class AnonymousClass3 extends MultimapBuilderWithKeys<K0> {
        final /* synthetic */ Comparator val$comparator;

        AnonymousClass3(final Comparator val$comparator) {
            this.val$comparator = val$comparator;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        <K extends K0, V> Map<K, Collection<V>> createMap() {
            return new TreeMap(this.val$comparator);
        }
    }

    public static <K0> MultimapBuilderWithKeys<K0> treeKeys(Comparator<K0> comparator) {
        Preconditions.checkNotNull(comparator);
        return new AnonymousClass3(comparator);
    }

    /* INFO: renamed from: com.google.common.collect.MultimapBuilder$4, reason: invalid class name */
    class AnonymousClass4 extends MultimapBuilderWithKeys<K0> {
        final /* synthetic */ Class val$keyClass;

        AnonymousClass4(final Class val$keyClass) {
            this.val$keyClass = val$keyClass;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        <K extends K0, V> Map<K, Collection<V>> createMap() {
            return new EnumMap(this.val$keyClass);
        }
    }

    public static <K0 extends Enum<K0>> MultimapBuilderWithKeys<K0> enumKeys(Class<K0> keyClass) {
        Preconditions.checkNotNull(keyClass);
        return new AnonymousClass4(keyClass);
    }

    private static final class ArrayListSupplier<V> implements Supplier<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        ArrayListSupplier(int expectedValuesPerKey) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(expectedValuesPerKey, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    private enum LinkedListSupplier implements Supplier<List<?>> {
        INSTANCE;

        public static <V> Supplier<List<V>> instance() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Supplier
        public List<?> get() {
            return new LinkedList();
        }
    }

    private static final class HashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        HashSetSupplier(int expectedValuesPerKey) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(expectedValuesPerKey, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        public Set<V> get() {
            return Platform.newHashSetWithExpectedSize(this.expectedValuesPerKey);
        }
    }

    private static final class LinkedHashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        LinkedHashSetSupplier(int expectedValuesPerKey) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(expectedValuesPerKey, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        public Set<V> get() {
            return Platform.newLinkedHashSetWithExpectedSize(this.expectedValuesPerKey);
        }
    }

    private static final class TreeSetSupplier<V> implements Supplier<SortedSet<V>>, Serializable {
        private final Comparator<? super V> comparator;

        TreeSetSupplier(Comparator<? super V> comparator) {
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        }

        @Override // com.google.common.base.Supplier
        public SortedSet<V> get() {
            return new TreeSet(this.comparator);
        }
    }

    private static final class EnumSetSupplier<V extends Enum<V>> implements Supplier<Set<V>>, Serializable {
        private final Class<V> clazz;

        EnumSetSupplier(Class<V> clazz) {
            this.clazz = (Class) Preconditions.checkNotNull(clazz);
        }

        @Override // com.google.common.base.Supplier
        public Set<V> get() {
            return EnumSet.noneOf(this.clazz);
        }
    }

    public static abstract class MultimapBuilderWithKeys<K0> {
        private static final int DEFAULT_EXPECTED_VALUES_PER_KEY = 2;

        abstract <K extends K0, V> Map<K, Collection<V>> createMap();

        MultimapBuilderWithKeys() {
        }

        public ListMultimapBuilder<K0, Object> arrayListValues() {
            return arrayListValues(2);
        }

        /* INFO: renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$1, reason: invalid class name */
        class AnonymousClass1 extends ListMultimapBuilder<K0, Object> {
            final /* synthetic */ int val$expectedValuesPerKey;

            AnonymousClass1(final int val$expectedValuesPerKey) {
                this.val$expectedValuesPerKey = val$expectedValuesPerKey;
            }

            @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
            public <K extends K0, V> ListMultimap<K, V> build() {
                return Multimaps.newListMultimap(MultimapBuilderWithKeys.this.createMap(), new ArrayListSupplier(this.val$expectedValuesPerKey));
            }
        }

        public ListMultimapBuilder<K0, Object> arrayListValues(int expectedValuesPerKey) {
            CollectPreconditions.checkNonnegative(expectedValuesPerKey, "expectedValuesPerKey");
            return new AnonymousClass1(expectedValuesPerKey);
        }

        /* INFO: renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$2, reason: invalid class name */
        class AnonymousClass2 extends ListMultimapBuilder<K0, Object> {
            AnonymousClass2() {
            }

            @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
            public <K extends K0, V> ListMultimap<K, V> build() {
                return Multimaps.newListMultimap(MultimapBuilderWithKeys.this.createMap(), LinkedListSupplier.instance());
            }
        }

        public ListMultimapBuilder<K0, Object> linkedListValues() {
            return new AnonymousClass2();
        }

        public SetMultimapBuilder<K0, Object> hashSetValues() {
            return hashSetValues(2);
        }

        /* INFO: renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$3, reason: invalid class name */
        class AnonymousClass3 extends SetMultimapBuilder<K0, Object> {
            final /* synthetic */ int val$expectedValuesPerKey;

            AnonymousClass3(final int val$expectedValuesPerKey) {
                this.val$expectedValuesPerKey = val$expectedValuesPerKey;
            }

            @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            public <K extends K0, V> SetMultimap<K, V> build() {
                return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.createMap(), new HashSetSupplier(this.val$expectedValuesPerKey));
            }
        }

        public SetMultimapBuilder<K0, Object> hashSetValues(int expectedValuesPerKey) {
            CollectPreconditions.checkNonnegative(expectedValuesPerKey, "expectedValuesPerKey");
            return new AnonymousClass3(expectedValuesPerKey);
        }

        public SetMultimapBuilder<K0, Object> linkedHashSetValues() {
            return linkedHashSetValues(2);
        }

        /* INFO: renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$4, reason: invalid class name */
        class AnonymousClass4 extends SetMultimapBuilder<K0, Object> {
            final /* synthetic */ int val$expectedValuesPerKey;

            AnonymousClass4(final int val$expectedValuesPerKey) {
                this.val$expectedValuesPerKey = val$expectedValuesPerKey;
            }

            @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            public <K extends K0, V> SetMultimap<K, V> build() {
                return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.createMap(), new LinkedHashSetSupplier(this.val$expectedValuesPerKey));
            }
        }

        public SetMultimapBuilder<K0, Object> linkedHashSetValues(int expectedValuesPerKey) {
            CollectPreconditions.checkNonnegative(expectedValuesPerKey, "expectedValuesPerKey");
            return new AnonymousClass4(expectedValuesPerKey);
        }

        public SortedSetMultimapBuilder<K0, Comparable> treeSetValues() {
            return treeSetValues(Ordering.natural());
        }

        /* INFO: renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$5, reason: invalid class name */
        class AnonymousClass5 extends SortedSetMultimapBuilder<K0, V0> {
            final /* synthetic */ Comparator val$comparator;

            AnonymousClass5(final Comparator val$comparator) {
                this.val$comparator = val$comparator;
            }

            @Override // com.google.common.collect.MultimapBuilder.SortedSetMultimapBuilder, com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            public <K extends K0, V extends V0> SortedSetMultimap<K, V> build() {
                return Multimaps.newSortedSetMultimap(MultimapBuilderWithKeys.this.createMap(), new TreeSetSupplier(this.val$comparator));
            }
        }

        public <V0> SortedSetMultimapBuilder<K0, V0> treeSetValues(Comparator<V0> comparator) {
            Preconditions.checkNotNull(comparator, "comparator");
            return new AnonymousClass5(comparator);
        }

        /* INFO: renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$6, reason: invalid class name */
        class AnonymousClass6 extends SetMultimapBuilder<K0, V0> {
            final /* synthetic */ Class val$valueClass;

            AnonymousClass6(final Class val$valueClass) {
                this.val$valueClass = val$valueClass;
            }

            @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            public <K extends K0, V extends V0> SetMultimap<K, V> build() {
                return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.createMap(), new EnumSetSupplier(this.val$valueClass));
            }
        }

        public <V0 extends Enum<V0>> SetMultimapBuilder<K0, V0> enumSetValues(Class<V0> valueClass) {
            Preconditions.checkNotNull(valueClass, "valueClass");
            return new AnonymousClass6(valueClass);
        }
    }

    public <K extends K0, V extends V0> Multimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
        Multimap<K, V> multimapBuild = build();
        multimapBuild.putAll(multimap);
        return multimapBuild;
    }

    public static abstract class ListMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        @Override // com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> ListMultimap<K, V> build();

        ListMultimapBuilder() {
            super(null);
        }

        @Override // com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> ListMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (ListMultimap) super.build((Multimap) multimap);
        }
    }

    public static abstract class SetMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        @Override // com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> SetMultimap<K, V> build();

        SetMultimapBuilder() {
            super(null);
        }

        @Override // com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> SetMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (SetMultimap) super.build((Multimap) multimap);
        }
    }

    public static abstract class SortedSetMultimapBuilder<K0, V0> extends SetMultimapBuilder<K0, V0> {
        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> SortedSetMultimap<K, V> build();

        SortedSetMultimapBuilder() {
        }

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> SortedSetMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (SortedSetMultimap) super.build((Multimap) multimap);
        }
    }
}

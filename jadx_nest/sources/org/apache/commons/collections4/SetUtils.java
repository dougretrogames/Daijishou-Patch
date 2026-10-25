package org.apache.commons.collections4;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.collections4.set.ListOrderedSet;
import org.apache.commons.collections4.set.PredicatedNavigableSet;
import org.apache.commons.collections4.set.PredicatedSet;
import org.apache.commons.collections4.set.PredicatedSortedSet;
import org.apache.commons.collections4.set.TransformedNavigableSet;
import org.apache.commons.collections4.set.TransformedSet;
import org.apache.commons.collections4.set.TransformedSortedSet;
import org.apache.commons.collections4.set.UnmodifiableNavigableSet;
import org.apache.commons.collections4.set.UnmodifiableSet;
import org.apache.commons.collections4.set.UnmodifiableSortedSet;

/* JADX INFO: loaded from: classes5.dex */
public class SetUtils {
    public static final SortedSet EMPTY_SORTED_SET = UnmodifiableSortedSet.unmodifiableSortedSet(new TreeSet());

    public static abstract class SetView<E> extends AbstractSet<E> {
        protected abstract Iterator<E> createIterator();

        public <S extends Set<E>> void copyInto(S s) {
            CollectionUtils.addAll(s, this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return IteratorUtils.unmodifiableIterator(createIterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IteratorUtils.size(iterator());
        }

        public Set<E> toSet() {
            HashSet hashSet = new HashSet(size());
            copyInto(hashSet);
            return hashSet;
        }
    }

    public static <E> SetView<E> difference(Set<? extends E> set, Set<? extends E> set2) {
        Objects.requireNonNull(set, "setA");
        Objects.requireNonNull(set2, "setB");
        return new AnonymousClass1(set, set2, new SetUtils$$ExternalSyntheticLambda0(set2));
    }

    static /* synthetic */ boolean lambda$difference$0(Set set, Object obj) {
        return !set.contains(obj);
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: org.apache.commons.collections4.SetUtils$1, reason: invalid class name */
    class AnonymousClass1<E> extends SetView<E> {
        final /* synthetic */ Predicate val$notContainedInB;
        final /* synthetic */ Set val$setA;
        final /* synthetic */ Set val$setB;

        AnonymousClass1(Set set, Set set2, Predicate predicate) {
            this.val$setA = set;
            this.val$setB = set2;
            this.val$notContainedInB = predicate;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.val$setA.contains(obj) && !this.val$setB.contains(obj);
        }

        @Override // org.apache.commons.collections4.SetUtils.SetView
        public Iterator<E> createIterator() {
            return IteratorUtils.filteredIterator(this.val$setA.iterator(), this.val$notContainedInB);
        }
    }

    public static <E> SetView<E> disjunction(Set<? extends E> set, Set<? extends E> set2) {
        Objects.requireNonNull(set, "setA");
        Objects.requireNonNull(set2, "setB");
        return new AnonymousClass2(set, set2, difference(set, set2), difference(set2, set));
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: org.apache.commons.collections4.SetUtils$2, reason: invalid class name */
    class AnonymousClass2<E> extends SetView<E> {
        final /* synthetic */ SetView val$aMinusB;
        final /* synthetic */ SetView val$bMinusA;
        final /* synthetic */ Set val$setA;
        final /* synthetic */ Set val$setB;

        AnonymousClass2(Set set, Set set2, SetView setView, SetView setView2) {
            this.val$setA = set;
            this.val$setB = set2;
            this.val$aMinusB = setView;
            this.val$bMinusA = setView2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.val$setB.contains(obj) ^ this.val$setA.contains(obj);
        }

        @Override // org.apache.commons.collections4.SetUtils.SetView
        public Iterator<E> createIterator() {
            return IteratorUtils.chainedIterator(this.val$aMinusB.iterator(), this.val$bMinusA.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.val$aMinusB.isEmpty() && this.val$bMinusA.isEmpty();
        }

        @Override // org.apache.commons.collections4.SetUtils.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.val$aMinusB.size() + this.val$bMinusA.size();
        }
    }

    public static <T> Set<T> emptyIfNull(Set<T> set) {
        return set == null ? Collections.emptySet() : set;
    }

    public static <E> Set<E> emptySet() {
        return Collections.emptySet();
    }

    public static <E> SortedSet<E> emptySortedSet() {
        return EMPTY_SORTED_SET;
    }

    public static <T> int hashCodeForSet(Collection<T> collection) {
        int iHashCode = 0;
        if (collection == null) {
            return 0;
        }
        for (T t : collection) {
            if (t != null) {
                iHashCode += t.hashCode();
            }
        }
        return iHashCode;
    }

    public static <E> HashSet<E> hashSet(E... eArr) {
        if (eArr == null) {
            return null;
        }
        return new HashSet<>(Arrays.asList(eArr));
    }

    public static <E> SetView<E> intersection(Set<? extends E> set, Set<? extends E> set2) {
        Objects.requireNonNull(set, "setA");
        Objects.requireNonNull(set2, "setB");
        return new AnonymousClass3(set, set2);
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: org.apache.commons.collections4.SetUtils$3, reason: invalid class name */
    class AnonymousClass3<E> extends SetView<E> {
        final /* synthetic */ Set val$setA;
        final /* synthetic */ Set val$setB;

        AnonymousClass3(Set set, Set set2) {
            this.val$setA = set;
            this.val$setB = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.val$setA.contains(obj) && this.val$setB.contains(obj);
        }

        @Override // org.apache.commons.collections4.SetUtils.SetView
        public Iterator<E> createIterator() {
            Iterator<E> it = this.val$setA.iterator();
            Set set = this.val$setB;
            Objects.requireNonNull(set);
            return IteratorUtils.filteredIterator(it, new SetUtils$3$$ExternalSyntheticLambda0(set));
        }
    }

    public static boolean isEqualSet(Collection<?> collection, Collection<?> collection2) {
        if (collection == collection2) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        return collection.containsAll(collection2);
    }

    public static <E> Set<E> newIdentityHashSet() {
        return Collections.newSetFromMap(new IdentityHashMap());
    }

    public static <E> Set<E> orderedSet(Set<E> set) {
        return ListOrderedSet.listOrderedSet(set);
    }

    public static <E> SortedSet<E> predicatedNavigableSet(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
        return PredicatedNavigableSet.predicatedNavigableSet(navigableSet, predicate);
    }

    public static <E> Set<E> predicatedSet(Set<E> set, Predicate<? super E> predicate) {
        return PredicatedSet.predicatedSet(set, predicate);
    }

    public static <E> SortedSet<E> predicatedSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        return PredicatedSortedSet.predicatedSortedSet(sortedSet, predicate);
    }

    public static <E> Set<E> synchronizedSet(Set<E> set) {
        return Collections.synchronizedSet(set);
    }

    public static <E> SortedSet<E> synchronizedSortedSet(SortedSet<E> sortedSet) {
        return Collections.synchronizedSortedSet(sortedSet);
    }

    public static <E> SortedSet<E> transformedNavigableSet(NavigableSet<E> navigableSet, Transformer<? super E, ? extends E> transformer) {
        return TransformedNavigableSet.transformingNavigableSet(navigableSet, transformer);
    }

    public static <E> Set<E> transformedSet(Set<E> set, Transformer<? super E, ? extends E> transformer) {
        return TransformedSet.transformingSet(set, transformer);
    }

    public static <E> SortedSet<E> transformedSortedSet(SortedSet<E> sortedSet, Transformer<? super E, ? extends E> transformer) {
        return TransformedSortedSet.transformingSortedSet(sortedSet, transformer);
    }

    public static <E> SetView<E> union(Set<? extends E> set, Set<? extends E> set2) {
        Objects.requireNonNull(set, "setA");
        Objects.requireNonNull(set2, "setB");
        return new AnonymousClass4(set, set2, difference(set2, set));
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: org.apache.commons.collections4.SetUtils$4, reason: invalid class name */
    class AnonymousClass4<E> extends SetView<E> {
        final /* synthetic */ SetView val$bMinusA;
        final /* synthetic */ Set val$setA;
        final /* synthetic */ Set val$setB;

        AnonymousClass4(Set set, Set set2, SetView setView) {
            this.val$setA = set;
            this.val$setB = set2;
            this.val$bMinusA = setView;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.val$setA.contains(obj) || this.val$setB.contains(obj);
        }

        @Override // org.apache.commons.collections4.SetUtils.SetView
        public Iterator<E> createIterator() {
            return IteratorUtils.chainedIterator(this.val$setA.iterator(), this.val$bMinusA.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.val$setA.isEmpty() && this.val$setB.isEmpty();
        }

        @Override // org.apache.commons.collections4.SetUtils.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.val$setA.size() + this.val$bMinusA.size();
        }
    }

    public static <E> SortedSet<E> unmodifiableNavigableSet(NavigableSet<E> navigableSet) {
        return UnmodifiableNavigableSet.unmodifiableNavigableSet(navigableSet);
    }

    public static <E> Set<E> unmodifiableSet(E... eArr) {
        if (eArr == null) {
            return null;
        }
        return UnmodifiableSet.unmodifiableSet(hashSet(eArr));
    }

    public static <E> Set<E> unmodifiableSet(Set<? extends E> set) {
        return UnmodifiableSet.unmodifiableSet(set);
    }

    public static <E> SortedSet<E> unmodifiableSortedSet(SortedSet<E> sortedSet) {
        return UnmodifiableSortedSet.unmodifiableSortedSet(sortedSet);
    }

    private SetUtils() {
    }
}

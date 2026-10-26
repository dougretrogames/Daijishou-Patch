package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.ReverseListIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;

/* INFO: loaded from: classes5.dex */
public class IterableUtils {
    static final FluentIterable EMPTY_ITERABLE = new AnonymousClass1();

    private static final class UnmodifiableIterable<E> extends FluentIterable<E> {
        private final Iterable<E> iterable;

        UnmodifiableIterable(Iterable<E> iterable) {
            this.iterable = iterable;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return IteratorUtils.unmodifiableIterator(this.iterable.iterator());
        }
    }

    /* INFO: renamed from: org.apache.commons.collections4.IterableUtils$1, reason: invalid class name */
    class AnonymousClass1 extends FluentIterable<Object> {
        AnonymousClass1() {
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<Object> iterator() {
            return IteratorUtils.emptyIterator();
        }
    }

    public static <E> Iterable<E> boundedIterable(Iterable<E> iterable, long j) {
        Objects.requireNonNull(iterable, "iterable");
        if (j < 0) {
            throw new IllegalArgumentException("MaxSize parameter must not be negative.");
        }
        return new AnonymousClass2(iterable, j);
    }

    /* INFO: Add missing generic type declarations: [E] */
    /* INFO: renamed from: org.apache.commons.collections4.IterableUtils$2, reason: invalid class name */
    class AnonymousClass2<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$iterable;
        final /* synthetic */ long val$maxSize;

        AnonymousClass2(Iterable iterable, long j) {
            this.val$iterable = iterable;
            this.val$maxSize = j;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return IteratorUtils.boundedIterator(this.val$iterable.iterator(), this.val$maxSize);
        }
    }

    /* INFO: Add missing generic type declarations: [E] */
    /* INFO: renamed from: org.apache.commons.collections4.IterableUtils$3, reason: invalid class name */
    class AnonymousClass3<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable[] val$iterables;

        AnonymousClass3(Iterable[] iterableArr) {
            this.val$iterables = iterableArr;
        }

        /* INFO: renamed from: org.apache.commons.collections4.IterableUtils$3$1, reason: invalid class name */
        class AnonymousClass1 extends LazyIteratorChain<E> {
            AnonymousClass1() {
            }

            @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
            protected Iterator<? extends E> nextIterator(int i) {
                if (i > AnonymousClass3.this.val$iterables.length) {
                    return null;
                }
                return AnonymousClass3.this.val$iterables[i - 1].iterator();
            }
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return new AnonymousClass1();
        }
    }

    public static <E> Iterable<E> chainedIterable(Iterable<? extends E>... iterableArr) {
        checkNotNull(iterableArr);
        return new AnonymousClass3(iterableArr);
    }

    public static <E> Iterable<E> chainedIterable(Iterable<? extends E> iterable, Iterable<? extends E> iterable2) {
        return chainedIterable(iterable, iterable2);
    }

    public static <E> Iterable<E> chainedIterable(Iterable<? extends E> iterable, Iterable<? extends E> iterable2, Iterable<? extends E> iterable3) {
        return chainedIterable(iterable, iterable2, iterable3);
    }

    public static <E> Iterable<E> chainedIterable(Iterable<? extends E> iterable, Iterable<? extends E> iterable2, Iterable<? extends E> iterable3, Iterable<? extends E> iterable4) {
        return chainedIterable(iterable, iterable2, iterable3, iterable4);
    }

    static void checkNotNull(Iterable<?>... iterableArr) {
        Objects.requireNonNull(iterableArr, "iterables");
        for (Iterable<?> iterable : iterableArr) {
            Objects.requireNonNull(iterable, "iterable");
        }
    }

    /* INFO: Add missing generic type declarations: [E] */
    /* INFO: renamed from: org.apache.commons.collections4.IterableUtils$4, reason: invalid class name */
    class AnonymousClass4<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$a;
        final /* synthetic */ Iterable val$b;
        final /* synthetic */ Comparator val$comparator;

        AnonymousClass4(Comparator comparator, Iterable iterable, Iterable iterable2) {
            this.val$comparator = comparator;
            this.val$a = iterable;
            this.val$b = iterable2;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return IteratorUtils.collatedIterator(this.val$comparator, this.val$a.iterator(), this.val$b.iterator());
        }
    }

    public static <E> Iterable<E> collatedIterable(Comparator<? super E> comparator, Iterable<? extends E> iterable, Iterable<? extends E> iterable2) {
        checkNotNull(iterable, iterable2);
        return new AnonymousClass4(comparator, iterable, iterable2);
    }

    /* INFO: Add missing generic type declarations: [E] */
    /* INFO: renamed from: org.apache.commons.collections4.IterableUtils$5, reason: invalid class name */
    class AnonymousClass5<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$a;
        final /* synthetic */ Iterable val$b;

        AnonymousClass5(Iterable iterable, Iterable iterable2) {
            this.val$a = iterable;
            this.val$b = iterable2;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return IteratorUtils.collatedIterator(null, this.val$a.iterator(), this.val$b.iterator());
        }
    }

    public static <E> Iterable<E> collatedIterable(Iterable<? extends E> iterable, Iterable<? extends E> iterable2) {
        checkNotNull(iterable, iterable2);
        return new AnonymousClass5(iterable, iterable2);
    }

    public static <E> boolean contains(Iterable<? extends E> iterable, E e, Equator<? super E> equator) {
        Objects.requireNonNull(equator, "equator");
        return matchesAny(iterable, EqualPredicate.equalPredicate(e, equator));
    }

    public static <E> boolean contains(Iterable<E> iterable, Object obj) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        return IteratorUtils.contains(emptyIteratorIfNull(iterable), obj);
    }

    public static <E> long countMatches(Iterable<E> iterable, Predicate<? super E> predicate) {
        Objects.requireNonNull(predicate, "predicate");
        return size(filteredIterable(emptyIfNull(iterable), predicate));
    }

    public static <E> List<E> duplicateList(Iterable<E> iterable) {
        return new ArrayList(duplicateSequencedSet(iterable));
    }

    public static <E> Set<E> duplicateSequencedSet(Iterable<E> iterable) {
        return (Set) duplicateSet(iterable, new LinkedHashSet());
    }

    public static <E> Set<E> duplicateSet(Iterable<E> iterable) {
        return (Set) duplicateSet(iterable, new HashSet());
    }

    static <C extends Collection<E>, E> C duplicateSet(Iterable<E> iterable, C c) {
        HashSet hashSet = new HashSet();
        for (E e : iterable) {
            (hashSet.contains(e) ? c : hashSet).add(e);
        }
        return c;
    }

    public static <E> Iterable<E> emptyIfNull(Iterable<E> iterable) {
        return iterable == null ? emptyIterable() : iterable;
    }

    public static <E> Iterable<E> emptyIterable() {
        return EMPTY_ITERABLE;
    }

    /* INFO: Access modifiers changed from: private */
    public static <E> Iterator<E> emptyIteratorIfNull(Iterable<E> iterable) {
        return iterable != null ? iterable.iterator() : IteratorUtils.emptyIterator();
    }

    public static <E> Iterable<E> filteredIterable(Iterable<E> iterable, Predicate<? super E> predicate) {
        Objects.requireNonNull(iterable, "iterable");
        Objects.requireNonNull(predicate, "predicate");
        return new AnonymousClass6(iterable, predicate);
    }

    /* INFO: Add missing generic type declarations: [E] */
    /* INFO: renamed from: org.apache.commons.collections4.IterableUtils$6, reason: invalid class name */
    class AnonymousClass6<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$iterable;
        final /* synthetic */ Predicate val$predicate;

        AnonymousClass6(Iterable iterable, Predicate predicate) {
            this.val$iterable = iterable;
            this.val$predicate = predicate;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return IteratorUtils.filteredIterator(IterableUtils.emptyIteratorIfNull(this.val$iterable), this.val$predicate);
        }
    }

    public static <E> E find(Iterable<E> iterable, Predicate<? super E> predicate) {
        return (E) IteratorUtils.find(emptyIteratorIfNull(iterable), predicate);
    }

    public static <T> T first(Iterable<T> iterable) {
        return (T) get(iterable, 0);
    }

    public static <E> void forEach(Iterable<E> iterable, Closure<? super E> closure) {
        IteratorUtils.forEach(emptyIteratorIfNull(iterable), closure);
    }

    public static <E> E forEachButLast(Iterable<E> iterable, Closure<? super E> closure) {
        return (E) IteratorUtils.forEachButLast(emptyIteratorIfNull(iterable), closure);
    }

    public static <E, T extends E> int frequency(Iterable<E> iterable, T t) {
        if (iterable instanceof Set) {
            return ((Set) iterable).contains(t) ? 1 : 0;
        }
        if (iterable instanceof Bag) {
            return ((Bag) iterable).getCount(t);
        }
        return size(filteredIterable(emptyIfNull(iterable), EqualPredicate.equalPredicate(t)));
    }

    public static <T> T get(Iterable<T> iterable, int i) {
        CollectionUtils.checkIndexBounds(i);
        if (iterable instanceof List) {
            return (T) ((List) iterable).get(i);
        }
        return (T) IteratorUtils.get(emptyIteratorIfNull(iterable), i);
    }

    public static <E> int indexOf(Iterable<E> iterable, Predicate<? super E> predicate) {
        return IteratorUtils.indexOf(emptyIteratorIfNull(iterable), predicate);
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return IteratorUtils.isEmpty(emptyIteratorIfNull(iterable));
    }

    /* INFO: Add missing generic type declarations: [E] */
    /* INFO: renamed from: org.apache.commons.collections4.IterableUtils$7, reason: invalid class name */
    class AnonymousClass7<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$iterable;

        AnonymousClass7(Iterable iterable) {
            this.val$iterable = iterable;
        }

        /* INFO: renamed from: org.apache.commons.collections4.IterableUtils$7$1, reason: invalid class name */
        class AnonymousClass1 extends LazyIteratorChain<E> {
            AnonymousClass1() {
            }

            @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
            protected Iterator<? extends E> nextIterator(int i) {
                if (IterableUtils.isEmpty(AnonymousClass7.this.val$iterable)) {
                    return null;
                }
                return AnonymousClass7.this.val$iterable.iterator();
            }
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return new AnonymousClass1();
        }
    }

    public static <E> Iterable<E> loopingIterable(Iterable<E> iterable) {
        Objects.requireNonNull(iterable, "iterable");
        return new AnonymousClass7(iterable);
    }

    public static <E> boolean matchesAll(Iterable<E> iterable, Predicate<? super E> predicate) {
        return IteratorUtils.matchesAll(emptyIteratorIfNull(iterable), predicate);
    }

    public static <E> boolean matchesAny(Iterable<E> iterable, Predicate<? super E> predicate) {
        return IteratorUtils.matchesAny(emptyIteratorIfNull(iterable), predicate);
    }

    public static <O, R extends Collection<O>> List<R> partition(Iterable<? extends O> iterable, Factory<R> factory, Predicate<? super O>... predicateArr) {
        if (iterable == null) {
            return partition(emptyIterable(), factory, predicateArr);
        }
        Objects.requireNonNull(predicateArr, "predicates");
        for (Predicate<? super O> predicate : predicateArr) {
            Objects.requireNonNull(predicate, "predicate");
        }
        if (predicateArr.length < 1) {
            R r = factory.get();
            CollectionUtils.addAll(r, iterable);
            return Collections.singletonList(r);
        }
        int length = predicateArr.length;
        int i = length + 1;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(factory.get());
        }
        for (O o : iterable) {
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    if (predicateArr[i3].test(o)) {
                        ((Collection) arrayList.get(i3)).add(o);
                        break;
                    }
                    i3++;
                } else {
                    ((Collection) arrayList.get(length)).add(o);
                    break;
                }
            }
        }
        return arrayList;
    }

    public static <O> List<List<O>> partition(Iterable<? extends O> iterable, Predicate<? super O> predicate) {
        Objects.requireNonNull(predicate, "predicate");
        return partition(iterable, FactoryUtils.instantiateFactory(ArrayList.class), predicate);
    }

    public static <O> List<List<O>> partition(Iterable<? extends O> iterable, Predicate<? super O>... predicateArr) {
        return partition(iterable, FactoryUtils.instantiateFactory(ArrayList.class), predicateArr);
    }

    /* INFO: Add missing generic type declarations: [E] */
    /* INFO: renamed from: org.apache.commons.collections4.IterableUtils$8, reason: invalid class name */
    class AnonymousClass8<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$iterable;

        AnonymousClass8(Iterable iterable) {
            this.val$iterable = iterable;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            List list;
            Iterable iterable = this.val$iterable;
            if (iterable instanceof List) {
                list = (List) iterable;
            } else {
                list = IteratorUtils.toList(iterable.iterator());
            }
            return new ReverseListIterator(list);
        }
    }

    public static <E> Iterable<E> reversedIterable(Iterable<E> iterable) {
        Objects.requireNonNull(iterable, "iterable");
        return new AnonymousClass8(iterable);
    }

    public static int size(Iterable<?> iterable) {
        if (iterable == null) {
            return 0;
        }
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return IteratorUtils.size(emptyIteratorIfNull(iterable));
    }

    public static <E> Iterable<E> skippingIterable(Iterable<E> iterable, long j) {
        Objects.requireNonNull(iterable, "iterable");
        if (j < 0) {
            throw new IllegalArgumentException("ElementsToSkip parameter must not be negative.");
        }
        return new AnonymousClass9(iterable, j);
    }

    /* INFO: Add missing generic type declarations: [E] */
    /* INFO: renamed from: org.apache.commons.collections4.IterableUtils$9, reason: invalid class name */
    class AnonymousClass9<E> extends FluentIterable<E> {
        final /* synthetic */ long val$elementsToSkip;
        final /* synthetic */ Iterable val$iterable;

        AnonymousClass9(Iterable iterable, long j) {
            this.val$iterable = iterable;
            this.val$elementsToSkip = j;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return IteratorUtils.skippingIterator(this.val$iterable.iterator(), this.val$elementsToSkip);
        }
    }

    public static <E> List<E> toList(Iterable<E> iterable) {
        return IteratorUtils.toList(emptyIteratorIfNull(iterable));
    }

    public static <E> String toString(Iterable<E> iterable) {
        return IteratorUtils.toString(emptyIteratorIfNull(iterable));
    }

    public static <E> String toString(Iterable<E> iterable, Transformer<? super E, String> transformer) {
        Objects.requireNonNull(transformer, "transformer");
        return IteratorUtils.toString(emptyIteratorIfNull(iterable), transformer);
    }

    public static <E> String toString(Iterable<E> iterable, Transformer<? super E, String> transformer, String str, String str2, String str3) {
        return IteratorUtils.toString(emptyIteratorIfNull(iterable), transformer, str, str2, str3);
    }

    public static <I, O> Iterable<O> transformedIterable(Iterable<I> iterable, Transformer<? super I, ? extends O> transformer) {
        Objects.requireNonNull(iterable, "iterable");
        Objects.requireNonNull(transformer, "transformer");
        return new AnonymousClass10(iterable, transformer);
    }

    /* INFO: Add missing generic type declarations: [O] */
    /* INFO: renamed from: org.apache.commons.collections4.IterableUtils$10, reason: invalid class name */
    class AnonymousClass10<O> extends FluentIterable<O> {
        final /* synthetic */ Iterable val$iterable;
        final /* synthetic */ Transformer val$transformer;

        AnonymousClass10(Iterable iterable, Transformer transformer) {
            this.val$iterable = iterable;
            this.val$transformer = transformer;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<O> iterator() {
            return IteratorUtils.transformedIterator(this.val$iterable.iterator(), this.val$transformer);
        }
    }

    /* INFO: Add missing generic type declarations: [E] */
    /* INFO: renamed from: org.apache.commons.collections4.IterableUtils$11, reason: invalid class name */
    class AnonymousClass11<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$iterable;

        AnonymousClass11(Iterable iterable) {
            this.val$iterable = iterable;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return new UniqueFilterIterator(this.val$iterable.iterator());
        }
    }

    public static <E> Iterable<E> uniqueIterable(Iterable<E> iterable) {
        Objects.requireNonNull(iterable, "iterable");
        return new AnonymousClass11(iterable);
    }

    public static <E> Iterable<E> unmodifiableIterable(Iterable<E> iterable) {
        Objects.requireNonNull(iterable, "iterable");
        return iterable instanceof UnmodifiableIterable ? iterable : new UnmodifiableIterable(iterable);
    }

    public static <E> Iterable<E> zippingIterable(Iterable<? extends E> iterable, Iterable<? extends E> iterable2) {
        Objects.requireNonNull(iterable, "iterable");
        Objects.requireNonNull(iterable2, "iterable");
        return new AnonymousClass12(iterable, iterable2);
    }

    /* INFO: Add missing generic type declarations: [E] */
    /* INFO: renamed from: org.apache.commons.collections4.IterableUtils$12, reason: invalid class name */
    class AnonymousClass12<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$a;
        final /* synthetic */ Iterable val$b;

        AnonymousClass12(Iterable iterable, Iterable iterable2) {
            this.val$a = iterable;
            this.val$b = iterable2;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return IteratorUtils.zippingIterator(this.val$a.iterator(), this.val$b.iterator());
        }
    }

    public static <E> Iterable<E> zippingIterable(Iterable<? extends E> iterable, Iterable<? extends E>... iterableArr) {
        Objects.requireNonNull(iterable, "iterable");
        checkNotNull(iterableArr);
        return new AnonymousClass13(iterableArr, iterable);
    }

    /* INFO: Add missing generic type declarations: [E] */
    /* INFO: renamed from: org.apache.commons.collections4.IterableUtils$13, reason: invalid class name */
    class AnonymousClass13<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$first;
        final /* synthetic */ Iterable[] val$others;

        AnonymousClass13(Iterable[] iterableArr, Iterable iterable) {
            this.val$others = iterableArr;
            this.val$first = iterable;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            Iterator[] itArr = new Iterator[this.val$others.length + 1];
            int i = 0;
            itArr[0] = this.val$first.iterator();
            while (true) {
                Iterable[] iterableArr = this.val$others;
                if (i < iterableArr.length) {
                    int i2 = i + 1;
                    itArr[i2] = iterableArr[i].iterator();
                    i = i2;
                } else {
                    return IteratorUtils.zippingIterator(itArr);
                }
            }
        }
    }

    @Deprecated
    public IterableUtils() {
    }
}

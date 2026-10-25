package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Iterables {
    private Iterables() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Iterable<T> unmodifiableIterable(final Iterable<? extends T> iterable) {
        Preconditions.checkNotNull(iterable);
        return ((iterable instanceof UnmodifiableIterable) || (iterable instanceof ImmutableCollection)) ? iterable : new UnmodifiableIterable(iterable, null);
    }

    @Deprecated
    public static <E> Iterable<E> unmodifiableIterable(ImmutableCollection<E> iterable) {
        return (Iterable) Preconditions.checkNotNull(iterable);
    }

    private static final class UnmodifiableIterable<T> extends FluentIterable<T> {
        private final Iterable<? extends T> iterable;

        /* synthetic */ UnmodifiableIterable(Iterable iterable, AnonymousClass1 anonymousClass1) {
            this(iterable);
        }

        private UnmodifiableIterable(Iterable<? extends T> iterable) {
            this.iterable = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.unmodifiableIterator(this.iterable.iterator());
        }

        @Override // com.google.common.collect.FluentIterable
        public String toString() {
            return this.iterable.toString();
        }
    }

    public static int size(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return Iterators.size(iterable.iterator());
    }

    public static boolean contains(Iterable<? extends Object> iterable, @CheckForNull Object element) {
        if (iterable instanceof Collection) {
            return Collections2.safeContains((Collection) iterable, element);
        }
        return Iterators.contains(iterable.iterator(), element);
    }

    public static boolean removeAll(Iterable<?> removeFrom, Collection<?> elementsToRemove) {
        if (removeFrom instanceof Collection) {
            return ((Collection) removeFrom).removeAll((Collection) Preconditions.checkNotNull(elementsToRemove));
        }
        return Iterators.removeAll(removeFrom.iterator(), elementsToRemove);
    }

    public static boolean retainAll(Iterable<?> removeFrom, Collection<?> elementsToRetain) {
        if (removeFrom instanceof Collection) {
            return ((Collection) removeFrom).retainAll((Collection) Preconditions.checkNotNull(elementsToRetain));
        }
        return Iterators.retainAll(removeFrom.iterator(), elementsToRetain);
    }

    public static <T> boolean removeIf(Iterable<T> removeFrom, Predicate<? super T> predicate) {
        if ((removeFrom instanceof RandomAccess) && (removeFrom instanceof List)) {
            return removeIfFromRandomAccessList((List) removeFrom, (Predicate) Preconditions.checkNotNull(predicate));
        }
        return Iterators.removeIf(removeFrom.iterator(), predicate);
    }

    private static <T> boolean removeIfFromRandomAccessList(List<T> list, Predicate<? super T> predicate) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            T t = list.get(i);
            if (!predicate.apply(t)) {
                if (i > i2) {
                    try {
                        list.set(i2, t);
                    } catch (IllegalArgumentException unused) {
                        slowRemoveIfForRemainingElements(list, predicate, i2, i);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        slowRemoveIfForRemainingElements(list, predicate, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        return i != i2;
    }

    private static <T> void slowRemoveIfForRemainingElements(List<T> list, Predicate<? super T> predicate, int to, int from) {
        for (int size = list.size() - 1; size > from; size--) {
            if (predicate.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i = from - 1; i >= to; i--) {
            list.remove(i);
        }
    }

    @CheckForNull
    static <T> T removeFirstMatching(Iterable<T> removeFrom, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        Iterator<T> it = removeFrom.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public static boolean elementsEqual(Iterable<?> iterable1, Iterable<?> iterable2) {
        if ((iterable1 instanceof Collection) && (iterable2 instanceof Collection) && ((Collection) iterable1).size() != ((Collection) iterable2).size()) {
            return false;
        }
        return Iterators.elementsEqual(iterable1.iterator(), iterable2.iterator());
    }

    public static String toString(Iterable<?> iterable) {
        return Iterators.toString(iterable.iterator());
    }

    @ParametricNullness
    public static <T> T getOnlyElement(Iterable<T> iterable) {
        return (T) Iterators.getOnlyElement(iterable.iterator());
    }

    @ParametricNullness
    public static <T> T getOnlyElement(Iterable<? extends T> iterable, @ParametricNullness T t) {
        return (T) Iterators.getOnlyElement(iterable.iterator(), t);
    }

    public static <T> T[] toArray(Iterable<? extends T> iterable, Class<T> cls) {
        return (T[]) toArray(iterable, ObjectArrays.newArray(cls, 0));
    }

    static <T> T[] toArray(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) castOrCopyToCollection(iterable).toArray(tArr);
    }

    static Object[] toArray(Iterable<?> iterable) {
        return castOrCopyToCollection(iterable).toArray();
    }

    private static <E> Collection<E> castOrCopyToCollection(Iterable<E> iterable) {
        if (iterable instanceof Collection) {
            return (Collection) iterable;
        }
        return Lists.newArrayList(iterable.iterator());
    }

    public static <T> boolean addAll(Collection<T> addTo, Iterable<? extends T> elementsToAdd) {
        if (elementsToAdd instanceof Collection) {
            return addTo.addAll((Collection) elementsToAdd);
        }
        return Iterators.addAll(addTo, ((Iterable) Preconditions.checkNotNull(elementsToAdd)).iterator());
    }

    public static int frequency(Iterable<?> iterable, @CheckForNull Object obj) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).count(obj);
        }
        if (iterable instanceof Set) {
            return ((Set) iterable).contains(obj) ? 1 : 0;
        }
        return Iterators.frequency(iterable.iterator(), obj);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.collect.Iterables$1, reason: invalid class name */
    class AnonymousClass1<T> extends FluentIterable<T> {
        final /* synthetic */ Iterable val$iterable;

        AnonymousClass1(final Iterable val$iterable) {
            this.val$iterable = val$iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.cycle(this.val$iterable);
        }

        @Override // com.google.common.collect.FluentIterable
        public String toString() {
            return this.val$iterable.toString() + " (cycled)";
        }
    }

    public static <T> Iterable<T> cycle(final Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new AnonymousClass1(iterable);
    }

    @SafeVarargs
    public static <T> Iterable<T> cycle(T... elements) {
        return cycle(Lists.newArrayList(elements));
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> a, Iterable<? extends T> b) {
        return FluentIterable.concat(a, b);
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> a, Iterable<? extends T> b, Iterable<? extends T> c) {
        return FluentIterable.concat(a, b, c);
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> a, Iterable<? extends T> b, Iterable<? extends T> c, Iterable<? extends T> d) {
        return FluentIterable.concat(a, b, c, d);
    }

    @SafeVarargs
    public static <T> Iterable<T> concat(Iterable<? extends T>... inputs) {
        return FluentIterable.concat(inputs);
    }

    public static <T> Iterable<T> concat(Iterable<? extends Iterable<? extends T>> inputs) {
        return FluentIterable.concat(inputs);
    }

    public static <T> Iterable<List<T>> partition(final Iterable<T> iterable, final int size) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(size > 0);
        return new AnonymousClass2(iterable, size);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.collect.Iterables$2, reason: invalid class name */
    class AnonymousClass2<T> extends FluentIterable<List<T>> {
        final /* synthetic */ Iterable val$iterable;
        final /* synthetic */ int val$size;

        AnonymousClass2(final Iterable val$iterable, final int val$size) {
            this.val$iterable = val$iterable;
            this.val$size = val$size;
        }

        @Override // java.lang.Iterable
        public Iterator<List<T>> iterator() {
            return Iterators.partition(this.val$iterable.iterator(), this.val$size);
        }
    }

    public static <T> Iterable<List<T>> paddedPartition(final Iterable<T> iterable, final int size) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(size > 0);
        return new AnonymousClass3(iterable, size);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.collect.Iterables$3, reason: invalid class name */
    class AnonymousClass3<T> extends FluentIterable<List<T>> {
        final /* synthetic */ Iterable val$iterable;
        final /* synthetic */ int val$size;

        AnonymousClass3(final Iterable val$iterable, final int val$size) {
            this.val$iterable = val$iterable;
            this.val$size = val$size;
        }

        @Override // java.lang.Iterable
        public Iterator<List<T>> iterator() {
            return Iterators.paddedPartition(this.val$iterable.iterator(), this.val$size);
        }
    }

    public static <T> Iterable<T> filter(final Iterable<T> unfiltered, final Predicate<? super T> retainIfTrue) {
        Preconditions.checkNotNull(unfiltered);
        Preconditions.checkNotNull(retainIfTrue);
        return new AnonymousClass4(unfiltered, retainIfTrue);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.collect.Iterables$4, reason: invalid class name */
    class AnonymousClass4<T> extends FluentIterable<T> {
        final /* synthetic */ Predicate val$retainIfTrue;
        final /* synthetic */ Iterable val$unfiltered;

        AnonymousClass4(final Iterable val$unfiltered, final Predicate val$retainIfTrue) {
            this.val$unfiltered = val$unfiltered;
            this.val$retainIfTrue = val$retainIfTrue;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.filter(this.val$unfiltered.iterator(), this.val$retainIfTrue);
        }
    }

    public static <T> Iterable<T> filter(final Iterable<?> unfiltered, final Class<T> desiredType) {
        Preconditions.checkNotNull(unfiltered);
        Preconditions.checkNotNull(desiredType);
        return filter(unfiltered, Predicates.instanceOf(desiredType));
    }

    public static <T> boolean any(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.any(iterable.iterator(), predicate);
    }

    public static <T> boolean all(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.all(iterable.iterator(), predicate);
    }

    @ParametricNullness
    public static <T> T find(Iterable<T> iterable, Predicate<? super T> predicate) {
        return (T) Iterators.find(iterable.iterator(), predicate);
    }

    @CheckForNull
    public static <T> T find(Iterable<? extends T> iterable, Predicate<? super T> predicate, @CheckForNull T t) {
        return (T) Iterators.find(iterable.iterator(), predicate, t);
    }

    public static <T> Optional<T> tryFind(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.tryFind(iterable.iterator(), predicate);
    }

    public static <T> int indexOf(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.indexOf(iterable.iterator(), predicate);
    }

    public static <F, T> Iterable<T> transform(final Iterable<F> fromIterable, final Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(fromIterable);
        Preconditions.checkNotNull(function);
        return new AnonymousClass5(fromIterable, function);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.collect.Iterables$5, reason: invalid class name */
    class AnonymousClass5<T> extends FluentIterable<T> {
        final /* synthetic */ Iterable val$fromIterable;
        final /* synthetic */ Function val$function;

        AnonymousClass5(final Iterable val$fromIterable, final Function val$function) {
            this.val$fromIterable = val$fromIterable;
            this.val$function = val$function;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.transform(this.val$fromIterable.iterator(), this.val$function);
        }
    }

    @ParametricNullness
    public static <T> T get(Iterable<T> iterable, int i) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof List) {
            return (T) ((List) iterable).get(i);
        }
        return (T) Iterators.get(iterable.iterator(), i);
    }

    @ParametricNullness
    public static <T> T get(Iterable<? extends T> iterable, int i, @ParametricNullness T t) {
        Preconditions.checkNotNull(iterable);
        Iterators.checkNonnegative(i);
        if (iterable instanceof List) {
            List listCast = Lists.cast(iterable);
            return i < listCast.size() ? (T) listCast.get(i) : t;
        }
        Iterator<? extends T> it = iterable.iterator();
        Iterators.advance(it, i);
        return (T) Iterators.getNext(it, t);
    }

    @ParametricNullness
    public static <T> T getFirst(Iterable<? extends T> iterable, @ParametricNullness T t) {
        return (T) Iterators.getNext(iterable.iterator(), t);
    }

    @ParametricNullness
    public static <T> T getLast(Iterable<T> iterable) {
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                throw new NoSuchElementException();
            }
            return (T) getLastInNonemptyList(list);
        }
        return (T) Iterators.getLast(iterable.iterator());
    }

    @ParametricNullness
    public static <T> T getLast(Iterable<? extends T> iterable, @ParametricNullness T t) {
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return t;
            }
            if (iterable instanceof List) {
                return (T) getLastInNonemptyList(Lists.cast(iterable));
            }
        }
        return (T) Iterators.getLast(iterable.iterator(), t);
    }

    @ParametricNullness
    private static <T> T getLastInNonemptyList(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> Iterable<T> skip(final Iterable<T> iterable, final int numberToSkip) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(numberToSkip >= 0, "number to skip cannot be negative");
        return new AnonymousClass6(iterable, numberToSkip);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.collect.Iterables$6, reason: invalid class name */
    class AnonymousClass6<T> extends FluentIterable<T> {
        final /* synthetic */ Iterable val$iterable;
        final /* synthetic */ int val$numberToSkip;

        AnonymousClass6(final Iterable val$iterable, final int val$numberToSkip) {
            this.val$iterable = val$iterable;
            this.val$numberToSkip = val$numberToSkip;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.val$iterable;
            if (iterable instanceof List) {
                List list = (List) iterable;
                return list.subList(Math.min(list.size(), this.val$numberToSkip), list.size()).iterator();
            }
            Iterator<T> it = iterable.iterator();
            Iterators.advance(it, this.val$numberToSkip);
            return new AnonymousClass1(this, it);
        }

        /* JADX INFO: renamed from: com.google.common.collect.Iterables$6$1, reason: invalid class name */
        class AnonymousClass1 implements Iterator<T> {
            boolean atStart = true;
            final /* synthetic */ Iterator val$iterator;

            AnonymousClass1(final AnonymousClass6 this$0, final Iterator val$iterator) {
                this.val$iterator = val$iterator;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.val$iterator.hasNext();
            }

            @Override // java.util.Iterator
            @ParametricNullness
            public T next() {
                T t = (T) this.val$iterator.next();
                this.atStart = false;
                return t;
            }

            @Override // java.util.Iterator
            public void remove() {
                CollectPreconditions.checkRemove(!this.atStart);
                this.val$iterator.remove();
            }
        }
    }

    public static <T> Iterable<T> limit(final Iterable<T> iterable, final int limitSize) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(limitSize >= 0, "limit is negative");
        return new AnonymousClass7(iterable, limitSize);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.collect.Iterables$7, reason: invalid class name */
    class AnonymousClass7<T> extends FluentIterable<T> {
        final /* synthetic */ Iterable val$iterable;
        final /* synthetic */ int val$limitSize;

        AnonymousClass7(final Iterable val$iterable, final int val$limitSize) {
            this.val$iterable = val$iterable;
            this.val$limitSize = val$limitSize;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.limit(this.val$iterable.iterator(), this.val$limitSize);
        }
    }

    public static <T> Iterable<T> consumingIterable(final Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new AnonymousClass8(iterable);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.collect.Iterables$8, reason: invalid class name */
    class AnonymousClass8<T> extends FluentIterable<T> {
        final /* synthetic */ Iterable val$iterable;

        AnonymousClass8(final Iterable val$iterable) {
            this.val$iterable = val$iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.val$iterable;
            if (iterable instanceof Queue) {
                return new ConsumingQueueIterator((Queue) this.val$iterable);
            }
            return Iterators.consumingIterator(iterable.iterator());
        }

        @Override // com.google.common.collect.FluentIterable
        public String toString() {
            return "Iterables.consumingIterable(...)";
        }
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    public static <T> Iterable<T> mergeSorted(final Iterable<? extends Iterable<? extends T>> iterables, final Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterables, "iterables");
        Preconditions.checkNotNull(comparator, "comparator");
        return new UnmodifiableIterable(new AnonymousClass9(iterables, comparator), null);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.collect.Iterables$9, reason: invalid class name */
    class AnonymousClass9<T> extends FluentIterable<T> {
        final /* synthetic */ Comparator val$comparator;
        final /* synthetic */ Iterable val$iterables;

        AnonymousClass9(final Iterable val$iterables, final Comparator val$comparator) {
            this.val$iterables = val$iterables;
            this.val$comparator = val$comparator;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.mergeSorted(Iterables.transform(this.val$iterables, new FluentIterable$2$$ExternalSyntheticLambda0()), this.val$comparator);
        }
    }
}

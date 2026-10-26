package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.primitives.Ints;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.collections4.CollectionUtils;

/* INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Iterators {
    private Iterators() {
    }

    static <T> UnmodifiableIterator<T> emptyIterator() {
        return emptyListIterator();
    }

    static <T> UnmodifiableListIterator<T> emptyListIterator() {
        return (UnmodifiableListIterator<T>) ArrayItr.EMPTY;
    }

    private enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(false);
        }
    }

    static <T> Iterator<T> emptyModifiableIterator() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> UnmodifiableIterator<T> unmodifiableIterator(Iterator<? extends T> iterator) {
        Preconditions.checkNotNull(iterator);
        if (iterator instanceof UnmodifiableIterator) {
            return (UnmodifiableIterator) iterator;
        }
        return new AnonymousClass1(iterator);
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.google.common.collect.Iterators$1, reason: invalid class name */
    class AnonymousClass1<T> extends UnmodifiableIterator<T> {
        final /* synthetic */ Iterator val$iterator;

        AnonymousClass1(final Iterator val$iterator) {
            this.val$iterator = val$iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.val$iterator.hasNext();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            return (T) this.val$iterator.next();
        }
    }

    @Deprecated
    public static <T> UnmodifiableIterator<T> unmodifiableIterator(UnmodifiableIterator<T> iterator) {
        return (UnmodifiableIterator) Preconditions.checkNotNull(iterator);
    }

    public static int size(Iterator<?> iterator) {
        long j = 0;
        while (iterator.hasNext()) {
            iterator.next();
            j++;
        }
        return Ints.saturatedCast(j);
    }

    public static boolean contains(Iterator<?> iterator, @CheckForNull Object element) {
        if (element == null) {
            while (iterator.hasNext()) {
                if (iterator.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (iterator.hasNext()) {
            if (element.equals(iterator.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean removeAll(Iterator<?> removeFrom, Collection<?> elementsToRemove) {
        Preconditions.checkNotNull(elementsToRemove);
        boolean z = false;
        while (removeFrom.hasNext()) {
            if (elementsToRemove.contains(removeFrom.next())) {
                removeFrom.remove();
                z = true;
            }
        }
        return z;
    }

    public static <T> boolean removeIf(Iterator<T> removeFrom, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        boolean z = false;
        while (removeFrom.hasNext()) {
            if (predicate.apply(removeFrom.next())) {
                removeFrom.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean retainAll(Iterator<?> removeFrom, Collection<?> elementsToRetain) {
        Preconditions.checkNotNull(elementsToRetain);
        boolean z = false;
        while (removeFrom.hasNext()) {
            if (!elementsToRetain.contains(removeFrom.next())) {
                removeFrom.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean elementsEqual(Iterator<?> iterator1, Iterator<?> iterator2) {
        while (iterator1.hasNext()) {
            if (!iterator2.hasNext() || !Objects.equal(iterator1.next(), iterator2.next())) {
                return false;
            }
        }
        return !iterator2.hasNext();
    }

    public static String toString(Iterator<?> iterator) {
        StringBuilder sb = new StringBuilder(CollectionUtils.DEFAULT_TOSTRING_PREFIX);
        boolean z = true;
        while (iterator.hasNext()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(iterator.next());
            z = false;
        }
        return sb.append(AbstractJsonLexerKt.END_LIST).toString();
    }

    @ParametricNullness
    public static <T> T getOnlyElement(Iterator<T> iterator) {
        T next = iterator.next();
        if (!iterator.hasNext()) {
            return next;
        }
        StringBuilder sbAppend = new StringBuilder("expected one element but was: <").append(next);
        for (int i = 0; i < 4 && iterator.hasNext(); i++) {
            sbAppend.append(", ").append(iterator.next());
        }
        if (iterator.hasNext()) {
            sbAppend.append(", ...");
        }
        sbAppend.append(Typography.greater);
        throw new IllegalArgumentException(sbAppend.toString());
    }

    @ParametricNullness
    public static <T> T getOnlyElement(Iterator<? extends T> it, @ParametricNullness T t) {
        return it.hasNext() ? (T) getOnlyElement(it) : t;
    }

    public static <T> T[] toArray(Iterator<? extends T> it, Class<T> cls) {
        return (T[]) Iterables.toArray(Lists.newArrayList(it), cls);
    }

    public static <T> boolean addAll(Collection<T> addTo, Iterator<? extends T> iterator) {
        Preconditions.checkNotNull(addTo);
        Preconditions.checkNotNull(iterator);
        boolean zAdd = false;
        while (iterator.hasNext()) {
            zAdd |= addTo.add(iterator.next());
        }
        return zAdd;
    }

    public static int frequency(Iterator<?> iterator, @CheckForNull Object element) {
        int i = 0;
        while (contains(iterator, element)) {
            i++;
        }
        return i;
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.google.common.collect.Iterators$2, reason: invalid class name */
    class AnonymousClass2<T> implements Iterator<T> {
        Iterator<T> iterator = Iterators.emptyModifiableIterator();
        final /* synthetic */ Iterable val$iterable;

        AnonymousClass2(final Iterable val$iterable) {
            this.val$iterable = val$iterable;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext() || this.val$iterable.iterator().hasNext();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            if (!this.iterator.hasNext()) {
                Iterator<T> it = this.val$iterable.iterator();
                this.iterator = it;
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
            }
            return this.iterator.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }
    }

    public static <T> Iterator<T> cycle(Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new AnonymousClass2(iterable);
    }

    @SafeVarargs
    public static <T> Iterator<T> cycle(T... elements) {
        return cycle(Lists.newArrayList(elements));
    }

    /* INFO: Add missing generic type declarations: [I] */
    /* INFO: renamed from: com.google.common.collect.Iterators$3, reason: invalid class name */
    class AnonymousClass3<I> extends UnmodifiableIterator<I> {
        int index = 0;
        final /* synthetic */ Iterator[] val$elements;

        AnonymousClass3(final Iterator[] val$elements) {
            this.val$elements = val$elements;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.val$elements.length;
        }

        /* WARN: Incorrect return type in method signature: ()TI; */
        @Override // java.util.Iterator
        public Iterator next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Iterator it = (Iterator) java.util.Objects.requireNonNull(this.val$elements[this.index]);
            Iterator[] itArr = this.val$elements;
            int i = this.index;
            itArr[i] = null;
            this.index = i + 1;
            return it;
        }
    }

    private static <I extends Iterator<?>> Iterator<I> consumingForArray(I... elements) {
        return new AnonymousClass3(elements);
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> a, Iterator<? extends T> b) {
        Preconditions.checkNotNull(a);
        Preconditions.checkNotNull(b);
        return concat(consumingForArray(a, b));
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> a, Iterator<? extends T> b, Iterator<? extends T> c) {
        Preconditions.checkNotNull(a);
        Preconditions.checkNotNull(b);
        Preconditions.checkNotNull(c);
        return concat(consumingForArray(a, b, c));
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> a, Iterator<? extends T> b, Iterator<? extends T> c, Iterator<? extends T> d) {
        Preconditions.checkNotNull(a);
        Preconditions.checkNotNull(b);
        Preconditions.checkNotNull(c);
        Preconditions.checkNotNull(d);
        return concat(consumingForArray(a, b, c, d));
    }

    @SafeVarargs
    public static <T> Iterator<T> concat(Iterator<? extends T>... inputs) {
        return concatNoDefensiveCopy((Iterator[]) Arrays.copyOf(inputs, inputs.length));
    }

    public static <T> Iterator<T> concat(Iterator<? extends Iterator<? extends T>> inputs) {
        return new ConcatenatedIterator(inputs);
    }

    static <T> Iterator<T> concatNoDefensiveCopy(Iterator<? extends T>... inputs) {
        for (Iterator it : (Iterator[]) Preconditions.checkNotNull(inputs)) {
            Preconditions.checkNotNull(it);
        }
        return concat(consumingForArray(inputs));
    }

    public static <T> UnmodifiableIterator<List<T>> partition(Iterator<T> iterator, int size) {
        return partitionImpl(iterator, size, false);
    }

    public static <T> UnmodifiableIterator<List<T>> paddedPartition(Iterator<T> iterator, int size) {
        return partitionImpl(iterator, size, true);
    }

    private static <T> UnmodifiableIterator<List<T>> partitionImpl(Iterator<T> iterator, int size, boolean pad) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkArgument(size > 0);
        return new AnonymousClass4(iterator, size, pad);
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.google.common.collect.Iterators$4, reason: invalid class name */
    class AnonymousClass4<T> extends UnmodifiableIterator<List<T>> {
        final /* synthetic */ Iterator val$iterator;
        final /* synthetic */ boolean val$pad;
        final /* synthetic */ int val$size;

        AnonymousClass4(final Iterator val$iterator, final int val$size, final boolean val$pad) {
            this.val$iterator = val$iterator;
            this.val$size = val$size;
            this.val$pad = val$pad;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.val$iterator.hasNext();
        }

        @Override // java.util.Iterator
        public List<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object[] objArr = new Object[this.val$size];
            int i = 0;
            while (i < this.val$size && this.val$iterator.hasNext()) {
                objArr[i] = this.val$iterator.next();
                i++;
            }
            for (int i2 = i; i2 < this.val$size; i2++) {
                objArr[i2] = null;
            }
            List<T> listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(objArr));
            return (this.val$pad || i == this.val$size) ? listUnmodifiableList : listUnmodifiableList.subList(0, i);
        }
    }

    public static <T> UnmodifiableIterator<T> filter(Iterator<T> unfiltered, Predicate<? super T> retainIfTrue) {
        Preconditions.checkNotNull(unfiltered);
        Preconditions.checkNotNull(retainIfTrue);
        return new AnonymousClass5(unfiltered, retainIfTrue);
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.google.common.collect.Iterators$5, reason: invalid class name */
    class AnonymousClass5<T> extends AbstractIterator<T> {
        final /* synthetic */ Predicate val$retainIfTrue;
        final /* synthetic */ Iterator val$unfiltered;

        AnonymousClass5(final Iterator val$unfiltered, final Predicate val$retainIfTrue) {
            this.val$unfiltered = val$unfiltered;
            this.val$retainIfTrue = val$retainIfTrue;
        }

        /* WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class decompiler.core.dex.instructions.args.ArgType$UnknownArg
        	at decompiler.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at decompiler.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at decompiler.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        protected T computeNext() {
            while (this.val$unfiltered.hasNext()) {
                T t = (T) this.val$unfiltered.next();
                if (this.val$retainIfTrue.apply(t)) {
                    return t;
                }
            }
            return endOfData();
        }
    }

    public static <T> UnmodifiableIterator<T> filter(Iterator<?> unfiltered, Class<T> desiredType) {
        return filter(unfiltered, Predicates.instanceOf(desiredType));
    }

    public static <T> boolean any(Iterator<T> iterator, Predicate<? super T> predicate) {
        return indexOf(iterator, predicate) != -1;
    }

    public static <T> boolean all(Iterator<T> iterator, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        while (iterator.hasNext()) {
            if (!predicate.apply(iterator.next())) {
                return false;
            }
        }
        return true;
    }

    @ParametricNullness
    public static <T> T find(Iterator<T> iterator, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkNotNull(predicate);
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    /* WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    @CheckForNull
    public static <T> T find(Iterator<? extends T> it, Predicate<? super T> predicate, @CheckForNull T t) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        return t;
    }

    public static <T> Optional<T> tryFind(Iterator<T> iterator, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkNotNull(predicate);
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (predicate.apply(next)) {
                return Optional.of(next);
            }
        }
        return Optional.absent();
    }

    public static <T> int indexOf(Iterator<T> iterator, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate, "predicate");
        int i = 0;
        while (iterator.hasNext()) {
            if (predicate.apply(iterator.next())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* INFO: Add missing generic type declarations: [T, F] */
    /* INFO: renamed from: com.google.common.collect.Iterators$6, reason: invalid class name */
    class AnonymousClass6<F, T> extends TransformedIterator<F, T> {
        final /* synthetic */ Function val$function;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(Iterator backingIterator, final Function val$function) {
            super(backingIterator);
            this.val$function = val$function;
        }

        @Override // com.google.common.collect.TransformedIterator
        @ParametricNullness
        T transform(@ParametricNullness F f) {
            return (T) this.val$function.apply(f);
        }
    }

    public static <F, T> Iterator<T> transform(Iterator<F> fromIterator, Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(function);
        return new AnonymousClass6(fromIterator, function);
    }

    @ParametricNullness
    public static <T> T get(Iterator<T> iterator, int position) {
        checkNonnegative(position);
        int iAdvance = advance(iterator, position);
        if (!iterator.hasNext()) {
            throw new IndexOutOfBoundsException("position (" + position + ") must be less than the number of elements that remained (" + iAdvance + ")");
        }
        return iterator.next();
    }

    @ParametricNullness
    public static <T> T get(Iterator<? extends T> it, int i, @ParametricNullness T t) {
        checkNonnegative(i);
        advance(it, i);
        return (T) getNext(it, t);
    }

    static void checkNonnegative(int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("position (" + position + ") must not be negative");
        }
    }

    @ParametricNullness
    public static <T> T getNext(Iterator<? extends T> iterator, @ParametricNullness T defaultValue) {
        return iterator.hasNext() ? iterator.next() : defaultValue;
    }

    @ParametricNullness
    public static <T> T getLast(Iterator<T> iterator) {
        T next;
        do {
            next = iterator.next();
        } while (iterator.hasNext());
        return next;
    }

    @ParametricNullness
    public static <T> T getLast(Iterator<? extends T> it, @ParametricNullness T t) {
        return it.hasNext() ? (T) getLast(it) : t;
    }

    public static int advance(Iterator<?> iterator, int numberToAdvance) {
        Preconditions.checkNotNull(iterator);
        int i = 0;
        Preconditions.checkArgument(numberToAdvance >= 0, "numberToAdvance must be nonnegative");
        while (i < numberToAdvance && iterator.hasNext()) {
            iterator.next();
            i++;
        }
        return i;
    }

    public static <T> Iterator<T> limit(Iterator<T> iterator, int limitSize) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkArgument(limitSize >= 0, "limit is negative");
        return new AnonymousClass7(limitSize, iterator);
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.google.common.collect.Iterators$7, reason: invalid class name */
    class AnonymousClass7<T> implements Iterator<T> {
        private int count;
        final /* synthetic */ Iterator val$iterator;
        final /* synthetic */ int val$limitSize;

        AnonymousClass7(final int val$limitSize, final Iterator val$iterator) {
            this.val$limitSize = val$limitSize;
            this.val$iterator = val$iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.count < this.val$limitSize && this.val$iterator.hasNext();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.count++;
            return (T) this.val$iterator.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.val$iterator.remove();
        }
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.google.common.collect.Iterators$8, reason: invalid class name */
    class AnonymousClass8<T> extends UnmodifiableIterator<T> {
        final /* synthetic */ Iterator val$iterator;

        AnonymousClass8(final Iterator val$iterator) {
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
            this.val$iterator.remove();
            return t;
        }

        public String toString() {
            return "Iterators.consumingIterator(...)";
        }
    }

    public static <T> Iterator<T> consumingIterator(Iterator<T> iterator) {
        Preconditions.checkNotNull(iterator);
        return new AnonymousClass8(iterator);
    }

    @CheckForNull
    static <T> T pollNext(Iterator<T> iterator) {
        if (!iterator.hasNext()) {
            return null;
        }
        T next = iterator.next();
        iterator.remove();
        return next;
    }

    static void clear(Iterator<?> iterator) {
        Preconditions.checkNotNull(iterator);
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    @SafeVarargs
    public static <T> UnmodifiableIterator<T> forArray(T... array) {
        return forArrayWithPosition(array, 0);
    }

    static <T> UnmodifiableListIterator<T> forArrayWithPosition(T[] array, int position) {
        if (array.length == 0) {
            Preconditions.checkPositionIndex(position, array.length);
            return emptyListIterator();
        }
        return new ArrayItr(array, position);
    }

    private static final class ArrayItr<T> extends AbstractIndexedListIterator<T> {
        static final UnmodifiableListIterator<Object> EMPTY = new ArrayItr(new Object[0], 0);
        private final T[] array;

        ArrayItr(T[] array, int position) {
            super(array.length, position);
            this.array = array;
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        @ParametricNullness
        protected T get(int index) {
            return this.array[index];
        }
    }

    public static <T> UnmodifiableIterator<T> singletonIterator(@ParametricNullness T value) {
        return new SingletonIterator(value);
    }

    private static final class SingletonIterator<T> extends UnmodifiableIterator<T> {
        private static final Object SENTINEL = new Object();
        private Object valueOrSentinel;

        SingletonIterator(T value) {
            this.valueOrSentinel = value;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.valueOrSentinel != SENTINEL;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            T t = (T) this.valueOrSentinel;
            Object obj = SENTINEL;
            if (t == obj) {
                throw new NoSuchElementException();
            }
            this.valueOrSentinel = obj;
            return t;
        }
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.google.common.collect.Iterators$9, reason: invalid class name */
    class AnonymousClass9<T> extends UnmodifiableIterator<T> {
        final /* synthetic */ Enumeration val$enumeration;

        AnonymousClass9(final Enumeration val$enumeration) {
            this.val$enumeration = val$enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.val$enumeration.hasMoreElements();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            return (T) this.val$enumeration.nextElement();
        }
    }

    public static <T> UnmodifiableIterator<T> forEnumeration(Enumeration<T> enumeration) {
        Preconditions.checkNotNull(enumeration);
        return new AnonymousClass9(enumeration);
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.google.common.collect.Iterators$10, reason: invalid class name */
    class AnonymousClass10<T> implements Enumeration<T> {
        final /* synthetic */ Iterator val$iterator;

        AnonymousClass10(final Iterator val$iterator) {
            this.val$iterator = val$iterator;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.val$iterator.hasNext();
        }

        @Override // java.util.Enumeration
        @ParametricNullness
        public T nextElement() {
            return (T) this.val$iterator.next();
        }
    }

    public static <T> Enumeration<T> asEnumeration(Iterator<T> iterator) {
        Preconditions.checkNotNull(iterator);
        return new AnonymousClass10(iterator);
    }

    private static class PeekingImpl<E> implements PeekingIterator<E> {
        private boolean hasPeeked;
        private final Iterator<? extends E> iterator;

        @CheckForNull
        private E peekedElement;

        public PeekingImpl(Iterator<? extends E> iterator) {
            this.iterator = (Iterator) Preconditions.checkNotNull(iterator);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasPeeked || this.iterator.hasNext();
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        @ParametricNullness
        public E next() {
            if (!this.hasPeeked) {
                return this.iterator.next();
            }
            E e = (E) NullnessCasts.uncheckedCastNullableTToT(this.peekedElement);
            this.hasPeeked = false;
            this.peekedElement = null;
            return e;
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public void remove() {
            Preconditions.checkState(!this.hasPeeked, "Can't remove after you've peeked at next");
            this.iterator.remove();
        }

        @Override // com.google.common.collect.PeekingIterator
        @ParametricNullness
        public E peek() {
            if (!this.hasPeeked) {
                this.peekedElement = this.iterator.next();
                this.hasPeeked = true;
            }
            return (E) NullnessCasts.uncheckedCastNullableTToT(this.peekedElement);
        }
    }

    public static <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> iterator) {
        if (iterator instanceof PeekingImpl) {
            return (PeekingImpl) iterator;
        }
        return new PeekingImpl(iterator);
    }

    @Deprecated
    public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> iterator) {
        return (PeekingIterator) Preconditions.checkNotNull(iterator);
    }

    public static <T> UnmodifiableIterator<T> mergeSorted(Iterable<? extends Iterator<? extends T>> iterators, Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterators, "iterators");
        Preconditions.checkNotNull(comparator, "comparator");
        return new MergingIterator(iterators, comparator);
    }

    /* INFO: Access modifiers changed from: private */
    static class MergingIterator<T> extends UnmodifiableIterator<T> {
        final Queue<PeekingIterator<T>> queue;

        public MergingIterator(Iterable<? extends Iterator<? extends T>> iterators, Comparator<? super T> itemComparator) {
            this.queue = new PriorityQueue(2, new Iterators$MergingIterator$$ExternalSyntheticLambda0(itemComparator));
            for (Iterator<? extends T> it : iterators) {
                if (it.hasNext()) {
                    this.queue.add(Iterators.peekingIterator(it));
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            PeekingIterator<T> peekingIteratorRemove = this.queue.remove();
            T next = peekingIteratorRemove.next();
            if (peekingIteratorRemove.hasNext()) {
                this.queue.add(peekingIteratorRemove);
            }
            return next;
        }
    }

    private static class ConcatenatedIterator<T> implements Iterator<T> {
        private Iterator<? extends T> iterator = Iterators.emptyIterator();

        @CheckForNull
        private Deque<Iterator<? extends Iterator<? extends T>>> metaIterators;

        @CheckForNull
        private Iterator<? extends T> toRemove;

        @CheckForNull
        private Iterator<? extends Iterator<? extends T>> topMetaIterator;

        ConcatenatedIterator(Iterator<? extends Iterator<? extends T>> metaIterator) {
            this.topMetaIterator = (Iterator) Preconditions.checkNotNull(metaIterator);
        }

        @CheckForNull
        private Iterator<? extends Iterator<? extends T>> getTopMetaIterator() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.topMetaIterator;
                if (it == null || !it.hasNext()) {
                    Deque<Iterator<? extends Iterator<? extends T>>> deque = this.metaIterators;
                    if (deque == null || deque.isEmpty()) {
                        return null;
                    }
                    this.topMetaIterator = this.metaIterators.removeFirst();
                } else {
                    return this.topMetaIterator;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!((Iterator) Preconditions.checkNotNull(this.iterator)).hasNext()) {
                Iterator<? extends Iterator<? extends T>> topMetaIterator = getTopMetaIterator();
                this.topMetaIterator = topMetaIterator;
                if (topMetaIterator == null) {
                    return false;
                }
                Iterator<? extends T> next = topMetaIterator.next();
                this.iterator = next;
                if (next instanceof ConcatenatedIterator) {
                    ConcatenatedIterator concatenatedIterator = (ConcatenatedIterator) next;
                    this.iterator = concatenatedIterator.iterator;
                    if (this.metaIterators == null) {
                        this.metaIterators = new ArrayDeque();
                    }
                    this.metaIterators.addFirst(this.topMetaIterator);
                    if (concatenatedIterator.metaIterators != null) {
                        while (!concatenatedIterator.metaIterators.isEmpty()) {
                            this.metaIterators.addFirst(concatenatedIterator.metaIterators.removeLast());
                        }
                    }
                    this.topMetaIterator = concatenatedIterator.topMetaIterator;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            if (hasNext()) {
                Iterator<? extends T> it = this.iterator;
                this.toRemove = it;
                return it.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Iterator<? extends T> it = this.toRemove;
            if (it == null) {
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
            it.remove();
            this.toRemove = null;
        }
    }
}

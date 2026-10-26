package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import javax.annotation.CheckForNull;

/* INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Multisets {
    private Multisets() {
    }

    static <T, E, M extends Multiset<E>> Collector<T, ?, M> toMultiset(Function<? super T, E> elementFunction, ToIntFunction<? super T> countFunction, Supplier<M> multisetSupplier) {
        return CollectCollectors.toMultiset(elementFunction, countFunction, multisetSupplier);
    }

    /* WARN: Multi-variable type inference failed */
    public static <E> Multiset<E> unmodifiableMultiset(Multiset<? extends E> multiset) {
        return ((multiset instanceof UnmodifiableMultiset) || (multiset instanceof ImmutableMultiset)) ? multiset : new UnmodifiableMultiset((Multiset) Preconditions.checkNotNull(multiset));
    }

    @Deprecated
    public static <E> Multiset<E> unmodifiableMultiset(ImmutableMultiset<E> multiset) {
        return (Multiset) Preconditions.checkNotNull(multiset);
    }

    static class UnmodifiableMultiset<E> extends ForwardingMultiset<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Multiset<? extends E> delegate;

        @CheckForNull
        @LazyInit
        transient Set<E> elementSet;

        @CheckForNull
        @LazyInit
        transient Set<Multiset.Entry<E>> entrySet;

        UnmodifiableMultiset(Multiset<? extends E> delegate) {
            this.delegate = delegate;
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Multiset<E> delegate() {
            return this.delegate;
        }

        Set<E> createElementSet() {
            return Collections.unmodifiableSet(this.delegate.elementSet());
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public Set<E> elementSet() {
            Set<E> set = this.elementSet;
            if (set != null) {
                return set;
            }
            Set<E> setCreateElementSet = createElementSet();
            this.elementSet = setCreateElementSet;
            return setCreateElementSet;
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<E>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set<Multiset.Entry<E>> setUnmodifiableSet = Collections.unmodifiableSet(this.delegate.entrySet());
            this.entrySet = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Iterators.unmodifiableIterator(this.delegate.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(@ParametricNullness E element) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int add(@ParametricNullness E element, int occurrences) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> elementsToAdd) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object element) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int remove(@CheckForNull Object element, int occurrences) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> elementsToRemove) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> elementsToRetain) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int setCount(@ParametricNullness E element, int count) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public boolean setCount(@ParametricNullness E element, int oldCount, int newCount) {
            throw new UnsupportedOperationException();
        }
    }

    public static <E> SortedMultiset<E> unmodifiableSortedMultiset(SortedMultiset<E> sortedMultiset) {
        return new UnmodifiableSortedMultiset((SortedMultiset) Preconditions.checkNotNull(sortedMultiset));
    }

    public static <E> Multiset.Entry<E> immutableEntry(@ParametricNullness E e, int n) {
        return new ImmutableEntry(e, n);
    }

    static class ImmutableEntry<E> extends AbstractEntry<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;

        @ParametricNullness
        private final E element;

        @CheckForNull
        public ImmutableEntry<E> nextInBucket() {
            return null;
        }

        ImmutableEntry(@ParametricNullness E element, int count) {
            this.element = element;
            this.count = count;
            CollectPreconditions.checkNonnegative(count, "count");
        }

        @Override // com.google.common.collect.Multiset.Entry
        @ParametricNullness
        public final E getElement() {
            return this.element;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final int getCount() {
            return this.count;
        }
    }

    public static <E> Multiset<E> filter(Multiset<E> unfiltered, Predicate<? super E> predicate) {
        if (unfiltered instanceof FilteredMultiset) {
            FilteredMultiset filteredMultiset = (FilteredMultiset) unfiltered;
            return new FilteredMultiset(filteredMultiset.unfiltered, Predicates.and(filteredMultiset.predicate, predicate));
        }
        return new FilteredMultiset(unfiltered, predicate);
    }

    private static final class FilteredMultiset<E> extends ViewMultiset<E> {
        final Predicate<? super E> predicate;
        final Multiset<E> unfiltered;

        FilteredMultiset(Multiset<E> unfiltered, Predicate<? super E> predicate) {
            super(null);
            this.unfiltered = (Multiset) Preconditions.checkNotNull(unfiltered);
            this.predicate = (Predicate) Preconditions.checkNotNull(predicate);
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public UnmodifiableIterator<E> iterator() {
            return Iterators.filter(this.unfiltered.iterator(), this.predicate);
        }

        @Override // com.google.common.collect.AbstractMultiset
        Set<E> createElementSet() {
            return Sets.filter(this.unfiltered.elementSet(), this.predicate);
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        Set<Multiset.Entry<E>> createEntrySet() {
            return Sets.filter(this.unfiltered.entrySet(), new AnonymousClass1());
        }

        /* INFO: renamed from: com.google.common.collect.Multisets$FilteredMultiset$1, reason: invalid class name */
        class AnonymousClass1 implements Predicate<Multiset.Entry<E>> {
            AnonymousClass1() {
            }

            @Override // com.google.common.base.Predicate
            public boolean apply(Multiset.Entry<E> entry) {
                return FilteredMultiset.this.predicate.apply(entry.getElement());
            }
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator<Multiset.Entry<E>> entryIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.Multiset
        public int count(@CheckForNull Object element) {
            int iCount = this.unfiltered.count(element);
            if (iCount <= 0 || !this.predicate.apply(element)) {
                return 0;
            }
            return iCount;
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int add(@ParametricNullness E element, int occurrences) {
            Preconditions.checkArgument(this.predicate.apply(element), "Element %s does not match predicate %s", element, this.predicate);
            return this.unfiltered.add(element, occurrences);
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int remove(@CheckForNull Object element, int occurrences) {
            CollectPreconditions.checkNonnegative(occurrences, "occurrences");
            if (occurrences == 0) {
                return count(element);
            }
            if (contains(element)) {
                return this.unfiltered.remove(element, occurrences);
            }
            return 0;
        }
    }

    static int inferDistinctElements(Iterable<?> elements) {
        if (elements instanceof Multiset) {
            return ((Multiset) elements).elementSet().size();
        }
        return 11;
    }

    public static <E> Multiset<E> union(final Multiset<? extends E> multiset1, final Multiset<? extends E> multiset2) {
        Preconditions.checkNotNull(multiset1);
        Preconditions.checkNotNull(multiset2);
        return new AnonymousClass1(multiset1, multiset2);
    }

    /* INFO: Add missing generic type declarations: [E] */
    /* INFO: renamed from: com.google.common.collect.Multisets$1, reason: invalid class name */
    class AnonymousClass1<E> extends ViewMultiset<E> {
        final /* synthetic */ Multiset val$multiset1;
        final /* synthetic */ Multiset val$multiset2;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(final Multiset val$multiset1, final Multiset val$multiset2) {
            super(null);
            this.val$multiset1 = val$multiset1;
            this.val$multiset2 = val$multiset2;
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(@CheckForNull Object element) {
            return this.val$multiset1.contains(element) || this.val$multiset2.contains(element);
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.val$multiset1.isEmpty() && this.val$multiset2.isEmpty();
        }

        @Override // com.google.common.collect.Multiset
        public int count(@CheckForNull Object element) {
            return Math.max(this.val$multiset1.count(element), this.val$multiset2.count(element));
        }

        @Override // com.google.common.collect.AbstractMultiset
        Set<E> createElementSet() {
            return Sets.union(this.val$multiset1.elementSet(), this.val$multiset2.elementSet());
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator<Multiset.Entry<E>> entryIterator() {
            return new C00411(this.val$multiset1.entrySet().iterator(), this.val$multiset2.entrySet().iterator());
        }

        /* INFO: renamed from: com.google.common.collect.Multisets$1$1, reason: invalid class name and collision with other inner class name */
        class C00411 extends AbstractIterator<Multiset.Entry<E>> {
            final /* synthetic */ Iterator val$iterator1;
            final /* synthetic */ Iterator val$iterator2;

            C00411(final Iterator val$iterator1, final Iterator val$iterator2) {
                this.val$iterator1 = val$iterator1;
                this.val$iterator2 = val$iterator2;
            }

            /* INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public Multiset.Entry<E> computeNext() {
                if (this.val$iterator1.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.val$iterator1.next();
                    Object element = entry.getElement();
                    return Multisets.immutableEntry(element, Math.max(entry.getCount(), AnonymousClass1.this.val$multiset2.count(element)));
                }
                while (this.val$iterator2.hasNext()) {
                    Multiset.Entry entry2 = (Multiset.Entry) this.val$iterator2.next();
                    Object element2 = entry2.getElement();
                    if (!AnonymousClass1.this.val$multiset1.contains(element2)) {
                        return Multisets.immutableEntry(element2, entry2.getCount());
                    }
                }
                return endOfData();
            }
        }
    }

    public static <E> Multiset<E> intersection(final Multiset<E> multiset1, final Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset1);
        Preconditions.checkNotNull(multiset2);
        return new AnonymousClass2(multiset1, multiset2);
    }

    /* INFO: Add missing generic type declarations: [E] */
    /* INFO: renamed from: com.google.common.collect.Multisets$2, reason: invalid class name */
    class AnonymousClass2<E> extends ViewMultiset<E> {
        final /* synthetic */ Multiset val$multiset1;
        final /* synthetic */ Multiset val$multiset2;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(final Multiset val$multiset1, final Multiset val$multiset2) {
            super(null);
            this.val$multiset1 = val$multiset1;
            this.val$multiset2 = val$multiset2;
        }

        @Override // com.google.common.collect.Multiset
        public int count(@CheckForNull Object element) {
            int iCount = this.val$multiset1.count(element);
            if (iCount == 0) {
                return 0;
            }
            return Math.min(iCount, this.val$multiset2.count(element));
        }

        @Override // com.google.common.collect.AbstractMultiset
        Set<E> createElementSet() {
            return Sets.intersection(this.val$multiset1.elementSet(), this.val$multiset2.elementSet());
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator<Multiset.Entry<E>> entryIterator() {
            return new AnonymousClass1(this.val$multiset1.entrySet().iterator());
        }

        /* INFO: renamed from: com.google.common.collect.Multisets$2$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractIterator<Multiset.Entry<E>> {
            final /* synthetic */ Iterator val$iterator1;

            AnonymousClass1(final Iterator val$iterator1) {
                this.val$iterator1 = val$iterator1;
            }

            /* INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public Multiset.Entry<E> computeNext() {
                while (this.val$iterator1.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.val$iterator1.next();
                    Object element = entry.getElement();
                    int iMin = Math.min(entry.getCount(), AnonymousClass2.this.val$multiset2.count(element));
                    if (iMin > 0) {
                        return Multisets.immutableEntry(element, iMin);
                    }
                }
                return endOfData();
            }
        }
    }

    public static <E> Multiset<E> sum(final Multiset<? extends E> multiset1, final Multiset<? extends E> multiset2) {
        Preconditions.checkNotNull(multiset1);
        Preconditions.checkNotNull(multiset2);
        return new AnonymousClass3(multiset1, multiset2);
    }

    /* INFO: Add missing generic type declarations: [E] */
    /* INFO: renamed from: com.google.common.collect.Multisets$3, reason: invalid class name */
    class AnonymousClass3<E> extends ViewMultiset<E> {
        final /* synthetic */ Multiset val$multiset1;
        final /* synthetic */ Multiset val$multiset2;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(final Multiset val$multiset1, final Multiset val$multiset2) {
            super(null);
            this.val$multiset1 = val$multiset1;
            this.val$multiset2 = val$multiset2;
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(@CheckForNull Object element) {
            return this.val$multiset1.contains(element) || this.val$multiset2.contains(element);
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.val$multiset1.isEmpty() && this.val$multiset2.isEmpty();
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return IntMath.saturatedAdd(this.val$multiset1.size(), this.val$multiset2.size());
        }

        @Override // com.google.common.collect.Multiset
        public int count(@CheckForNull Object element) {
            return this.val$multiset1.count(element) + this.val$multiset2.count(element);
        }

        @Override // com.google.common.collect.AbstractMultiset
        Set<E> createElementSet() {
            return Sets.union(this.val$multiset1.elementSet(), this.val$multiset2.elementSet());
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator<Multiset.Entry<E>> entryIterator() {
            return new AnonymousClass1(this.val$multiset1.entrySet().iterator(), this.val$multiset2.entrySet().iterator());
        }

        /* INFO: renamed from: com.google.common.collect.Multisets$3$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractIterator<Multiset.Entry<E>> {
            final /* synthetic */ Iterator val$iterator1;
            final /* synthetic */ Iterator val$iterator2;

            AnonymousClass1(final Iterator val$iterator1, final Iterator val$iterator2) {
                this.val$iterator1 = val$iterator1;
                this.val$iterator2 = val$iterator2;
            }

            /* INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public Multiset.Entry<E> computeNext() {
                if (this.val$iterator1.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.val$iterator1.next();
                    Object element = entry.getElement();
                    return Multisets.immutableEntry(element, entry.getCount() + AnonymousClass3.this.val$multiset2.count(element));
                }
                while (this.val$iterator2.hasNext()) {
                    Multiset.Entry entry2 = (Multiset.Entry) this.val$iterator2.next();
                    Object element2 = entry2.getElement();
                    if (!AnonymousClass3.this.val$multiset1.contains(element2)) {
                        return Multisets.immutableEntry(element2, entry2.getCount());
                    }
                }
                return endOfData();
            }
        }
    }

    public static <E> Multiset<E> difference(final Multiset<E> multiset1, final Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset1);
        Preconditions.checkNotNull(multiset2);
        return new AnonymousClass4(multiset1, multiset2);
    }

    /* INFO: Add missing generic type declarations: [E] */
    /* INFO: renamed from: com.google.common.collect.Multisets$4, reason: invalid class name */
    class AnonymousClass4<E> extends ViewMultiset<E> {
        final /* synthetic */ Multiset val$multiset1;
        final /* synthetic */ Multiset val$multiset2;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(final Multiset val$multiset1, final Multiset val$multiset2) {
            super(null);
            this.val$multiset1 = val$multiset1;
            this.val$multiset2 = val$multiset2;
        }

        @Override // com.google.common.collect.Multiset
        public int count(@CheckForNull Object element) {
            int iCount = this.val$multiset1.count(element);
            if (iCount == 0) {
                return 0;
            }
            return Math.max(0, iCount - this.val$multiset2.count(element));
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException();
        }

        /* INFO: renamed from: com.google.common.collect.Multisets$4$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractIterator<E> {
            final /* synthetic */ Iterator val$iterator1;

            AnonymousClass1(final Iterator val$iterator1) {
                this.val$iterator1 = val$iterator1;
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
            protected E computeNext() {
                while (this.val$iterator1.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.val$iterator1.next();
                    E e = (E) entry.getElement();
                    if (entry.getCount() > AnonymousClass4.this.val$multiset2.count(e)) {
                        return e;
                    }
                }
                return endOfData();
            }
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator<E> elementIterator() {
            return new AnonymousClass1(this.val$multiset1.entrySet().iterator());
        }

        /* INFO: renamed from: com.google.common.collect.Multisets$4$2, reason: invalid class name */
        class AnonymousClass2 extends AbstractIterator<Multiset.Entry<E>> {
            final /* synthetic */ Iterator val$iterator1;

            AnonymousClass2(final Iterator val$iterator1) {
                this.val$iterator1 = val$iterator1;
            }

            /* INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public Multiset.Entry<E> computeNext() {
                while (this.val$iterator1.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.val$iterator1.next();
                    Object element = entry.getElement();
                    int count = entry.getCount() - AnonymousClass4.this.val$multiset2.count(element);
                    if (count > 0) {
                        return Multisets.immutableEntry(element, count);
                    }
                }
                return endOfData();
            }
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator<Multiset.Entry<E>> entryIterator() {
            return new AnonymousClass2(this.val$multiset1.entrySet().iterator());
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, com.google.common.collect.AbstractMultiset
        int distinctElements() {
            return Iterators.size(entryIterator());
        }
    }

    public static boolean containsOccurrences(Multiset<?> superMultiset, Multiset<?> subMultiset) {
        Preconditions.checkNotNull(superMultiset);
        Preconditions.checkNotNull(subMultiset);
        for (Multiset.Entry<?> entry : subMultiset.entrySet()) {
            if (superMultiset.count(entry.getElement()) < entry.getCount()) {
                return false;
            }
        }
        return true;
    }

    public static boolean retainOccurrences(Multiset<?> multisetToModify, Multiset<?> multisetToRetain) {
        return retainOccurrencesImpl(multisetToModify, multisetToRetain);
    }

    private static <E> boolean retainOccurrencesImpl(Multiset<E> multisetToModify, Multiset<?> occurrencesToRetain) {
        Preconditions.checkNotNull(multisetToModify);
        Preconditions.checkNotNull(occurrencesToRetain);
        Iterator<Multiset.Entry<E>> it = multisetToModify.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Multiset.Entry<E> next = it.next();
            int iCount = occurrencesToRetain.count(next.getElement());
            if (iCount == 0) {
                it.remove();
            } else if (iCount < next.getCount()) {
                multisetToModify.setCount(next.getElement(), iCount);
            }
            z = true;
        }
        return z;
    }

    public static boolean removeOccurrences(Multiset<?> multisetToModify, Iterable<?> occurrencesToRemove) {
        if (occurrencesToRemove instanceof Multiset) {
            return removeOccurrences(multisetToModify, (Multiset<?>) occurrencesToRemove);
        }
        Preconditions.checkNotNull(multisetToModify);
        Preconditions.checkNotNull(occurrencesToRemove);
        Iterator<?> it = occurrencesToRemove.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= multisetToModify.remove(it.next());
        }
        return zRemove;
    }

    public static boolean removeOccurrences(Multiset<?> multisetToModify, Multiset<?> occurrencesToRemove) {
        Preconditions.checkNotNull(multisetToModify);
        Preconditions.checkNotNull(occurrencesToRemove);
        Iterator<Multiset.Entry<?>> it = multisetToModify.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Multiset.Entry<?> next = it.next();
            int iCount = occurrencesToRemove.count(next.getElement());
            if (iCount >= next.getCount()) {
                it.remove();
            } else if (iCount > 0) {
                multisetToModify.remove(next.getElement(), iCount);
            }
            z = true;
        }
        return z;
    }

    static abstract class AbstractEntry<E> implements Multiset.Entry<E> {
        AbstractEntry() {
        }

        @Override // com.google.common.collect.Multiset.Entry
        public boolean equals(@CheckForNull Object object) {
            if (object instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) object;
                if (getCount() == entry.getCount() && Objects.equal(getElement(), entry.getElement())) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int hashCode() {
            E element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        @Override // com.google.common.collect.Multiset.Entry
        public String toString() {
            String strValueOf = String.valueOf(getElement());
            int count = getCount();
            return count == 1 ? strValueOf : strValueOf + " x " + count;
        }
    }

    static boolean equalsImpl(Multiset<?> multiset, @CheckForNull Object object) {
        if (object == multiset) {
            return true;
        }
        if (object instanceof Multiset) {
            Multiset multiset2 = (Multiset) object;
            if (multiset.size() == multiset2.size() && multiset.entrySet().size() == multiset2.entrySet().size()) {
                for (Multiset.Entry entry : multiset2.entrySet()) {
                    if (multiset.count(entry.getElement()) != entry.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    static <E> boolean addAllImpl(Multiset<E> self, Collection<? extends E> elements) {
        Preconditions.checkNotNull(self);
        Preconditions.checkNotNull(elements);
        if (elements instanceof Multiset) {
            return addAllImpl((Multiset) self, cast(elements));
        }
        if (elements.isEmpty()) {
            return false;
        }
        return Iterators.addAll(self, elements.iterator());
    }

    private static <E> boolean addAllImpl(Multiset<E> self, Multiset<? extends E> elements) {
        if (elements instanceof AbstractMapBasedMultiset) {
            return addAllImpl((Multiset) self, (AbstractMapBasedMultiset) elements);
        }
        if (elements.isEmpty()) {
            return false;
        }
        for (Multiset.Entry<? extends E> entry : elements.entrySet()) {
            self.add(entry.getElement(), entry.getCount());
        }
        return true;
    }

    private static <E> boolean addAllImpl(Multiset<E> self, AbstractMapBasedMultiset<? extends E> elements) {
        if (elements.isEmpty()) {
            return false;
        }
        elements.addTo(self);
        return true;
    }

    static boolean removeAllImpl(Multiset<?> self, Collection<?> elementsToRemove) {
        if (elementsToRemove instanceof Multiset) {
            elementsToRemove = ((Multiset) elementsToRemove).elementSet();
        }
        return self.elementSet().removeAll(elementsToRemove);
    }

    static boolean retainAllImpl(Multiset<?> self, Collection<?> elementsToRetain) {
        Preconditions.checkNotNull(elementsToRetain);
        if (elementsToRetain instanceof Multiset) {
            elementsToRetain = ((Multiset) elementsToRetain).elementSet();
        }
        return self.elementSet().retainAll(elementsToRetain);
    }

    static <E> int setCountImpl(Multiset<E> self, @ParametricNullness E element, int count) {
        CollectPreconditions.checkNonnegative(count, "count");
        int iCount = self.count(element);
        int i = count - iCount;
        if (i > 0) {
            self.add(element, i);
            return iCount;
        }
        if (i < 0) {
            self.remove(element, -i);
        }
        return iCount;
    }

    static <E> boolean setCountImpl(Multiset<E> self, @ParametricNullness E element, int oldCount, int newCount) {
        CollectPreconditions.checkNonnegative(oldCount, "oldCount");
        CollectPreconditions.checkNonnegative(newCount, "newCount");
        if (self.count(element) != oldCount) {
            return false;
        }
        self.setCount(element, newCount);
        return true;
    }

    /* INFO: Add missing generic type declarations: [E] */
    /* INFO: renamed from: com.google.common.collect.Multisets$5, reason: invalid class name */
    class AnonymousClass5<E> extends TransformedIterator<Multiset.Entry<E>, E> {
        AnonymousClass5(Iterator backingIterator) {
            super(backingIterator);
        }

        /* INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.TransformedIterator
        @ParametricNullness
        public E transform(Multiset.Entry<E> entry) {
            return entry.getElement();
        }
    }

    static <E> Iterator<E> elementIterator(Iterator<Multiset.Entry<E>> entryIterator) {
        return new AnonymousClass5(entryIterator);
    }

    static abstract class ElementSet<E> extends Sets.ImprovedAbstractSet<E> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public abstract Iterator<E> iterator();

        abstract Multiset<E> multiset();

        ElementSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            multiset().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object o) {
            return multiset().contains(o);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> c) {
            return multiset().containsAll(c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return multiset().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object o) {
            return multiset().remove(o, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return multiset().entrySet().size();
        }
    }

    static abstract class EntrySet<E> extends Sets.ImprovedAbstractSet<Multiset.Entry<E>> {
        abstract Multiset<E> multiset();

        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object o) {
            if (o instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) o;
                if (entry.getCount() > 0 && multiset().count(entry.getElement()) == entry.getCount()) {
                    return true;
                }
            }
            return false;
        }

        /* WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                Object element = entry.getElement();
                int count = entry.getCount();
                if (count != 0) {
                    return multiset().setCount(element, count, 0);
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            multiset().clear();
        }
    }

    static <E> Iterator<E> iteratorImpl(Multiset<E> multiset) {
        return new MultisetIteratorImpl(multiset, multiset.entrySet().iterator());
    }

    static final class MultisetIteratorImpl<E> implements Iterator<E> {
        private boolean canRemove;

        @CheckForNull
        private Multiset.Entry<E> currentEntry;
        private final Iterator<Multiset.Entry<E>> entryIterator;
        private int laterCount;
        private final Multiset<E> multiset;
        private int totalCount;

        MultisetIteratorImpl(Multiset<E> multiset, Iterator<Multiset.Entry<E>> entryIterator) {
            this.multiset = multiset;
            this.entryIterator = entryIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.laterCount > 0 || this.entryIterator.hasNext();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.laterCount == 0) {
                Multiset.Entry<E> next = this.entryIterator.next();
                this.currentEntry = next;
                int count = next.getCount();
                this.laterCount = count;
                this.totalCount = count;
            }
            this.laterCount--;
            this.canRemove = true;
            return (E) ((Multiset.Entry) java.util.Objects.requireNonNull(this.currentEntry)).getElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            if (this.totalCount == 1) {
                this.entryIterator.remove();
            } else {
                this.multiset.remove(((Multiset.Entry) java.util.Objects.requireNonNull(this.currentEntry)).getElement());
            }
            this.totalCount--;
            this.canRemove = false;
        }
    }

    static int linearTimeSizeImpl(Multiset<?> multiset) {
        Iterator<Multiset.Entry<?>> it = multiset.entrySet().iterator();
        long count = 0;
        while (it.hasNext()) {
            count += (long) it.next().getCount();
        }
        return Ints.saturatedCast(count);
    }

    static <T> Multiset<T> cast(Iterable<T> iterable) {
        return (Multiset) iterable;
    }

    public static <E> ImmutableMultiset<E> copyHighestCountFirst(Multiset<E> multiset) {
        Multiset.Entry[] entryArr = (Multiset.Entry[]) multiset.entrySet().toArray(new Multiset.Entry[0]);
        Arrays.sort(entryArr, DecreasingCount.INSTANCE);
        return ImmutableMultiset.copyFromEntries(Arrays.asList(entryArr));
    }

    private static final class DecreasingCount implements Comparator<Multiset.Entry<?>> {
        static final Comparator<Multiset.Entry<?>> INSTANCE = new DecreasingCount();

        private DecreasingCount() {
        }

        @Override // java.util.Comparator
        public int compare(Multiset.Entry<?> entry1, Multiset.Entry<?> entry2) {
            return entry2.getCount() - entry1.getCount();
        }
    }

    private static abstract class ViewMultiset<E> extends AbstractMultiset<E> {
        private ViewMultiset() {
        }

        /* synthetic */ ViewMultiset(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return Multisets.linearTimeSizeImpl(this);
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            elementSet().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public Iterator<E> iterator() {
            return Multisets.iteratorImpl(this);
        }

        @Override // com.google.common.collect.AbstractMultiset
        int distinctElements() {
            return elementSet().size();
        }
    }
}

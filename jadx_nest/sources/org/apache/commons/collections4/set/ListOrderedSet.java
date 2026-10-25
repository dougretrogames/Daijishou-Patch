package org.apache.commons.collections4.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.list.UnmodifiableList;

/* JADX INFO: loaded from: classes5.dex */
public class ListOrderedSet<E> extends AbstractSerializableSetDecorator<E> {
    private static final long serialVersionUID = -228664372470420141L;
    private final List<E> setOrder;

    static class OrderedSetIterator<E> extends AbstractIteratorDecorator<E> implements OrderedIterator<E> {
        private E last;
        private final Collection<E> set;

        /* synthetic */ OrderedSetIterator(ListIterator listIterator, Collection collection, AnonymousClass1 anonymousClass1) {
            this(listIterator, collection);
        }

        private OrderedSetIterator(ListIterator<E> listIterator, Collection<E> collection) {
            super(listIterator);
            this.set = collection;
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return ((ListIterator) getIterator()).hasPrevious();
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public E next() {
            E next = getIterator().next();
            this.last = next;
            return next;
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public E previous() {
            E e = (E) ((ListIterator) getIterator()).previous();
            this.last = e;
            return e;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            this.set.remove(this.last);
            getIterator().remove();
            this.last = null;
        }
    }

    public static <E> ListOrderedSet<E> listOrderedSet(List<E> list) {
        Objects.requireNonNull(list, "list");
        CollectionUtils.filter(list, UniquePredicate.uniquePredicate());
        return new ListOrderedSet<>(new HashSet(list), list);
    }

    public static <E> ListOrderedSet<E> listOrderedSet(Set<E> set) {
        return new ListOrderedSet<>(set);
    }

    public static <E> ListOrderedSet<E> listOrderedSet(Set<E> set, List<E> list) {
        Objects.requireNonNull(set, "set");
        Objects.requireNonNull(list, "list");
        if (!set.isEmpty() || !list.isEmpty()) {
            throw new IllegalArgumentException("Set and List must be empty");
        }
        return new ListOrderedSet<>(set, list);
    }

    public ListOrderedSet() {
        super(new HashSet());
        this.setOrder = new ArrayList();
    }

    protected ListOrderedSet(Set<E> set) {
        super(set);
        this.setOrder = new ArrayList(set);
    }

    protected ListOrderedSet(Set<E> set, List<E> list) {
        super(set);
        this.setOrder = (List) Objects.requireNonNull(list, "list");
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E e) {
        if (!decorated().add(e)) {
            return false;
        }
        this.setOrder.add(e);
        return true;
    }

    public void add(int i, E e) {
        if (contains(e)) {
            return;
        }
        decorated().add(e);
        this.setOrder.add(i, e);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (E e : collection) {
            if (!contains(e)) {
                decorated().add(e);
                arrayList.add(e);
                z = true;
            }
        }
        if (z) {
            this.setOrder.addAll(i, arrayList);
        }
        return z;
    }

    public List<E> asList() {
        return UnmodifiableList.unmodifiableList(this.setOrder);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        decorated().clear();
        this.setOrder.clear();
    }

    public E get(int i) {
        return this.setOrder.get(i);
    }

    public int indexOf(Object obj) {
        return this.setOrder.indexOf(obj);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public OrderedIterator<E> iterator() {
        return new OrderedSetIterator(this.setOrder.listIterator(), decorated(), null);
    }

    public E remove(int i) {
        E eRemove = this.setOrder.remove(i);
        remove(eRemove);
        return eRemove;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean remove(Object obj) {
        boolean zRemove = decorated().remove(obj);
        if (zRemove) {
            this.setOrder.remove(obj);
        }
        return zRemove;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean removeIf(Predicate<? super E> predicate) {
        Objects.isNull(predicate);
        if (predicate == null) {
            return false;
        }
        boolean zRemoveIf = decorated().removeIf(predicate);
        if (zRemoveIf) {
            this.setOrder.removeIf(predicate);
        }
        return zRemoveIf;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> collection) {
        boolean zRetainAll = decorated().retainAll(collection);
        if (!zRetainAll) {
            return false;
        }
        if (decorated().isEmpty()) {
            this.setOrder.clear();
            return zRetainAll;
        }
        this.setOrder.removeIf(new ListOrderedSet$$ExternalSyntheticLambda0(this));
        return zRetainAll;
    }

    /* JADX INFO: renamed from: lambda$retainAll$0$org-apache-commons-collections4-set-ListOrderedSet, reason: not valid java name */
    /* synthetic */ boolean m5549x583e3d8a(Object obj) {
        return !decorated().contains(obj);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public Object[] toArray() {
        return this.setOrder.toArray();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.setOrder.toArray(tArr);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public String toString() {
        return this.setOrder.toString();
    }
}

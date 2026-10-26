package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.list.UnmodifiableList;

/* INFO: loaded from: classes5.dex */
public class CollatingIterator<E> implements Iterator<E> {
    private Comparator<? super E> comparator;
    private final List<Iterator<? extends E>> iterators;
    private int lastReturned;
    private BitSet valueSet;
    private List<E> values;

    public CollatingIterator() {
        this((Comparator) null, 2);
    }

    public CollatingIterator(Comparator<? super E> comparator) {
        this(comparator, 2);
    }

    public CollatingIterator(Comparator<? super E> comparator, Collection<Iterator<? extends E>> collection) {
        this(comparator, collection.size());
        Iterator<Iterator<? extends E>> it = collection.iterator();
        while (it.hasNext()) {
            addIterator(it.next());
        }
    }

    public CollatingIterator(Comparator<? super E> comparator, int i) {
        this.lastReturned = -1;
        this.iterators = new ArrayList(i);
        setComparator(comparator);
    }

    public CollatingIterator(Comparator<? super E> comparator, Iterator<? extends E> it, Iterator<? extends E> it2) {
        this(comparator, 2);
        addIterator(it);
        addIterator(it2);
    }

    public CollatingIterator(Comparator<? super E> comparator, Iterator<? extends E>[] itArr) {
        this(comparator, itArr.length);
        for (Iterator<? extends E> it : itArr) {
            addIterator(it);
        }
    }

    public void addIterator(Iterator<? extends E> it) {
        checkNotStarted();
        Objects.requireNonNull(it, "iterator");
        this.iterators.add(it);
    }

    private boolean anyHasNext(List<Iterator<? extends E>> list) {
        Iterator<Iterator<? extends E>> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().hasNext()) {
                return true;
            }
        }
        return false;
    }

    private boolean anyValueSet(BitSet bitSet) {
        for (int i = 0; i < bitSet.size(); i++) {
            if (bitSet.get(i)) {
                return true;
            }
        }
        return false;
    }

    private void checkNotStarted() throws IllegalStateException {
        if (this.values != null) {
            throw new IllegalStateException("Can't do that after next or hasNext has been called.");
        }
    }

    private void clear(int i) {
        this.values.set(i, null);
        this.valueSet.clear(i);
    }

    public Comparator<? super E> getComparator() {
        return this.comparator;
    }

    public int getIteratorIndex() {
        int i = this.lastReturned;
        if (i != -1) {
            return i;
        }
        throw new IllegalStateException("No value has been returned yet");
    }

    public List<Iterator<? extends E>> getIterators() {
        return UnmodifiableList.unmodifiableList(this.iterators);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        start();
        return anyValueSet(this.valueSet) || anyHasNext(this.iterators);
    }

    private int least() {
        Object obj = null;
        int i = -1;
        for (int i2 = 0; i2 < this.values.size(); i2++) {
            if (!this.valueSet.get(i2)) {
                set(i2);
            }
            if (this.valueSet.get(i2)) {
                if (i == -1) {
                    obj = this.values.get(i2);
                    i = i2;
                } else {
                    E e = this.values.get(i2);
                    Objects.requireNonNull(this.comparator, "You must invoke setComparator() to set a comparator first.");
                    if (this.comparator.compare(e, obj) < 0) {
                        i = i2;
                        obj = e;
                    }
                }
            }
        }
        return i;
    }

    @Override // java.util.Iterator
    public E next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int iLeast = least();
        if (iLeast == -1) {
            throw new NoSuchElementException();
        }
        E e = this.values.get(iLeast);
        clear(iLeast);
        this.lastReturned = iLeast;
        return e;
    }

    @Override // java.util.Iterator
    public void remove() {
        int i = this.lastReturned;
        if (i == -1) {
            throw new IllegalStateException("No value can be removed at present");
        }
        this.iterators.get(i).remove();
    }

    private boolean set(int i) {
        Iterator<? extends E> it = this.iterators.get(i);
        if (it.hasNext()) {
            this.values.set(i, it.next());
            this.valueSet.set(i);
            return true;
        }
        this.values.set(i, null);
        this.valueSet.clear(i);
        return false;
    }

    public void setComparator(Comparator<? super E> comparator) {
        checkNotStarted();
        this.comparator = comparator;
    }

    public void setIterator(int i, Iterator<? extends E> it) {
        checkNotStarted();
        Objects.requireNonNull(it, "iterator");
        this.iterators.set(i, it);
    }

    private void start() {
        if (this.values == null) {
            this.values = new ArrayList(this.iterators.size());
            this.valueSet = new BitSet(this.iterators.size());
            for (int i = 0; i < this.iterators.size(); i++) {
                this.values.add(null);
                this.valueSet.clear(i);
            }
        }
    }
}

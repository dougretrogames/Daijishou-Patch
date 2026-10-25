package org.apache.commons.collections4.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections4.SortedBag;

/* JADX INFO: loaded from: classes5.dex */
public class TreeBag<E> extends AbstractMapBag<E> implements SortedBag<E>, Serializable {
    private static final long serialVersionUID = -7740146511091606676L;

    public TreeBag() {
        super(new TreeMap());
    }

    public TreeBag(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    public TreeBag(Comparator<? super E> comparator) {
        super(new TreeMap(comparator));
    }

    public TreeBag(Iterable<? extends E> iterable) {
        super(new TreeMap(), iterable);
    }

    @Override // org.apache.commons.collections4.bag.AbstractMapBag, org.apache.commons.collections4.Bag, java.util.Collection
    public boolean add(E e) {
        if (comparator() == null && !(e instanceof Comparable)) {
            Objects.requireNonNull(e, "object");
            throw new IllegalArgumentException("Objects of type " + e.getClass() + " cannot be added to a naturally ordered TreeBag as it does not implement Comparable");
        }
        return super.add(e);
    }

    @Override // org.apache.commons.collections4.SortedBag
    public Comparator<? super E> comparator() {
        return getMap().comparator();
    }

    @Override // org.apache.commons.collections4.SortedBag
    public E first() {
        return getMap().firstKey();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.bag.AbstractMapBag
    public SortedMap<E, AbstractMapBag.MutableInteger> getMap() {
        return (SortedMap) super.getMap();
    }

    @Override // org.apache.commons.collections4.SortedBag
    public E last() {
        return getMap().lastKey();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        super.doReadObject(new TreeMap((Comparator) objectInputStream.readObject()), objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(comparator());
        super.doWriteObject(objectOutputStream);
    }
}

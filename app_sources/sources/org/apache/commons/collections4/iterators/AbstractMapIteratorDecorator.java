package org.apache.commons.collections4.iterators;

import java.util.Objects;
import org.apache.commons.collections4.MapIterator;

/* INFO: loaded from: classes5.dex */
public class AbstractMapIteratorDecorator<K, V> implements MapIterator<K, V> {
    private final MapIterator<K, V> iterator;

    public AbstractMapIteratorDecorator(MapIterator<K, V> mapIterator) {
        this.iterator = (MapIterator) Objects.requireNonNull(mapIterator, "iterator");
    }

    @Override // org.apache.commons.collections4.MapIterator
    public K getKey() {
        return this.iterator.getKey();
    }

    protected MapIterator<K, V> getMapIterator() {
        return this.iterator;
    }

    @Override // org.apache.commons.collections4.MapIterator
    public V getValue() {
        return this.iterator.getValue();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public K next() {
        return this.iterator.next();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }

    @Override // org.apache.commons.collections4.MapIterator
    public V setValue(V v) {
        return this.iterator.setValue(v);
    }
}

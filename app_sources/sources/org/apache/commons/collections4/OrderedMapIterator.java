package org.apache.commons.collections4;

/* INFO: loaded from: classes5.dex */
public interface OrderedMapIterator<K, V> extends MapIterator<K, V>, OrderedIterator<K> {
    @Override // org.apache.commons.collections4.OrderedIterator
    boolean hasPrevious();

    @Override // org.apache.commons.collections4.OrderedIterator
    K previous();
}

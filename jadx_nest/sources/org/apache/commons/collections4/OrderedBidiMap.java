package org.apache.commons.collections4;

/* INFO: loaded from: classes5.dex */
public interface OrderedBidiMap<K, V> extends BidiMap<K, V>, OrderedMap<K, V> {
    @Override // org.apache.commons.collections4.BidiMap
    OrderedBidiMap<V, K> inverseBidiMap();
}

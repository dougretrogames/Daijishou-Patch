package org.apache.commons.collections4.keyvalue;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractMapEntry<K, V> extends AbstractKeyValue<K, V> implements Map.Entry<K, V> {
    protected AbstractMapEntry(K k, V v) {
        super(k, v);
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return Objects.equals(getKey(), entry.getKey()) && Objects.equals(getValue(), entry.getValue());
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
    }

    @Override // org.apache.commons.collections4.keyvalue.AbstractKeyValue, java.util.Map.Entry
    public V setValue(V v) {
        return (V) super.setValue(v);
    }
}

package org.apache.commons.collections4.keyvalue;

import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.KeyValue;

/* INFO: loaded from: classes5.dex */
public class DefaultKeyValue<K, V> extends AbstractKeyValue<K, V> {
    public DefaultKeyValue() {
        super(null, null);
    }

    public DefaultKeyValue(K k, V v) {
        super(k, v);
    }

    public DefaultKeyValue(KeyValue<? extends K, ? extends V> keyValue) {
        super(keyValue.getKey(), keyValue.getValue());
    }

    public DefaultKeyValue(Map.Entry<? extends K, ? extends V> entry) {
        super(entry.getKey(), entry.getValue());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DefaultKeyValue)) {
            return false;
        }
        DefaultKeyValue defaultKeyValue = (DefaultKeyValue) obj;
        return Objects.equals(getKey(), defaultKeyValue.getKey()) && Objects.equals(getValue(), defaultKeyValue.getValue());
    }

    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
    }

    @Override // org.apache.commons.collections4.keyvalue.AbstractKeyValue
    public K setKey(K k) {
        if (k == this) {
            throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a key.");
        }
        return (K) super.setKey(k);
    }

    @Override // org.apache.commons.collections4.keyvalue.AbstractKeyValue, java.util.Map.Entry
    public V setValue(V v) {
        if (v == this) {
            throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a value.");
        }
        return (V) super.setValue(v);
    }

    public Map.Entry<K, V> toMapEntry() {
        return new DefaultMapEntry(this);
    }
}

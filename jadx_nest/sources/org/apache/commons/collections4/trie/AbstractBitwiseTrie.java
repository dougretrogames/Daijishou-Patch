package org.apache.commons.collections4.trie;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Trie;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractBitwiseTrie<K, V> extends AbstractMap<K, V> implements Trie<K, V>, Serializable {
    private static final long serialVersionUID = 5826987063535505652L;
    private final KeyAnalyzer<? super K> keyAnalyzer;

    /* JADX WARN: Multi-variable type inference failed */
    final K castKey(Object obj) {
        return obj;
    }

    static abstract class BasicEntry<K, V> implements Map.Entry<K, V>, Serializable {
        private static final long serialVersionUID = -944364551314110330L;
        protected K key;
        protected V value;

        BasicEntry(K k) {
            this.key = k;
        }

        BasicEntry(K k, V v) {
            this.key = k;
            this.value = v;
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
            return AbstractBitwiseTrie.compare(this.key, entry.getKey()) && AbstractBitwiseTrie.compare(this.value, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
        }

        public V setKeyValue(K k, V v) {
            this.key = k;
            return setValue(v);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }

    static boolean compare(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    protected AbstractBitwiseTrie(KeyAnalyzer<? super K> keyAnalyzer) {
        this.keyAnalyzer = (KeyAnalyzer) Objects.requireNonNull(keyAnalyzer, "keyAnalyzer");
    }

    final int bitIndex(K k, K k2) {
        return this.keyAnalyzer.bitIndex(k, 0, lengthInBits(k), k2, 0, lengthInBits(k2));
    }

    final int bitsPerElement() {
        return this.keyAnalyzer.bitsPerElement();
    }

    final boolean compareKeys(K k, K k2) {
        if (k == null) {
            return k2 == null;
        }
        return k2 != null && this.keyAnalyzer.compare(k, k2) == 0;
    }

    protected KeyAnalyzer<? super K> getKeyAnalyzer() {
        return this.keyAnalyzer;
    }

    final boolean isBitSet(K k, int i, int i2) {
        if (k == null) {
            return false;
        }
        return this.keyAnalyzer.isBitSet(k, i, i2);
    }

    final int lengthInBits(K k) {
        if (k == null) {
            return 0;
        }
        return this.keyAnalyzer.lengthInBits(k);
    }

    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder sb = new StringBuilder("Trie[");
        sb.append(size()).append("]={\n");
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            sb.append("  ").append(it.next()).append("\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}

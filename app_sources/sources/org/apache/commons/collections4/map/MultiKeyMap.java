package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.MultiKey;

/* INFO: loaded from: classes5.dex */
public class MultiKeyMap<K, V> extends AbstractMapDecorator<MultiKey<? extends K>, V> implements Serializable, Cloneable {
    private static final long serialVersionUID = -1788199231038721040L;

    public static <K, V> MultiKeyMap<K, V> multiKeyMap(AbstractHashedMap<MultiKey<? extends K>, V> abstractHashedMap) {
        Objects.requireNonNull(abstractHashedMap, "map");
        if (abstractHashedMap.isEmpty()) {
            return new MultiKeyMap<>(abstractHashedMap);
        }
        throw new IllegalArgumentException("Map must be empty");
    }

    public MultiKeyMap() {
        this(new HashedMap());
    }

    protected MultiKeyMap(AbstractHashedMap<MultiKey<? extends K>, V> abstractHashedMap) {
        super(abstractHashedMap);
        this.map = abstractHashedMap;
    }

    protected void checkKey(MultiKey<?> multiKey) {
        Objects.requireNonNull(multiKey, "key");
    }

    public MultiKeyMap<K, V> clone() {
        try {
            return (MultiKeyMap) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public boolean containsKey(Object obj, Object obj2) {
        int iHash = hash(obj, obj2);
        for (AbstractHashedMap.HashEntry<K, V> hashEntryDecoratedHashEntry = decoratedHashEntry(iHash); hashEntryDecoratedHashEntry != null; hashEntryDecoratedHashEntry = hashEntryDecoratedHashEntry.next) {
            if (hashEntryDecoratedHashEntry.hashCode == iHash && isEqualKey(hashEntryDecoratedHashEntry, obj, obj2)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3) {
        int iHash = hash(obj, obj2, obj3);
        for (AbstractHashedMap.HashEntry<K, V> hashEntryDecoratedHashEntry = decoratedHashEntry(iHash); hashEntryDecoratedHashEntry != null; hashEntryDecoratedHashEntry = hashEntryDecoratedHashEntry.next) {
            if (hashEntryDecoratedHashEntry.hashCode == iHash && isEqualKey(hashEntryDecoratedHashEntry, obj, obj2, obj3)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3, Object obj4) {
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        int iHash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap.HashEntry<K, V> hashEntryDecoratedHashEntry = decoratedHashEntry(iHash);
        while (hashEntryDecoratedHashEntry != null) {
            if (hashEntryDecoratedHashEntry.hashCode == iHash) {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
                if (isEqualKey(hashEntryDecoratedHashEntry, obj5, obj6, obj7, obj8)) {
                    return true;
                }
            } else {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
            }
            hashEntryDecoratedHashEntry = hashEntryDecoratedHashEntry.next;
            obj = obj5;
            obj2 = obj6;
            obj3 = obj7;
            obj4 = obj8;
        }
        return false;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object obj6;
        int iHash = hash(obj, obj2, obj3, obj4, obj5);
        AbstractHashedMap.HashEntry<K, V> hashEntryDecoratedHashEntry = decoratedHashEntry(iHash);
        while (hashEntryDecoratedHashEntry != null) {
            if (hashEntryDecoratedHashEntry.hashCode == iHash) {
                obj6 = obj;
                if (isEqualKey(hashEntryDecoratedHashEntry, obj6, obj2, obj3, obj4, obj5)) {
                    return true;
                }
            } else {
                obj6 = obj;
            }
            hashEntryDecoratedHashEntry = hashEntryDecoratedHashEntry.next;
            obj = obj6;
        }
        return false;
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public AbstractHashedMap<MultiKey<? extends K>, V> decorated() {
        return (AbstractHashedMap) super.decorated();
    }

    AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> decoratedHashEntry(int i) {
        return decorated().data[decoratedHashIndex(i)];
    }

    int decoratedHashIndex(int i) {
        return decorated().hashIndex(i, decorated().data.length);
    }

    public V get(Object obj, Object obj2) {
        int iHash = hash(obj, obj2);
        for (AbstractHashedMap.HashEntry<K, V> hashEntryDecoratedHashEntry = decoratedHashEntry(iHash); hashEntryDecoratedHashEntry != null; hashEntryDecoratedHashEntry = hashEntryDecoratedHashEntry.next) {
            if (hashEntryDecoratedHashEntry.hashCode == iHash && isEqualKey(hashEntryDecoratedHashEntry, obj, obj2)) {
                return hashEntryDecoratedHashEntry.getValue();
            }
        }
        return null;
    }

    public V get(Object obj, Object obj2, Object obj3) {
        int iHash = hash(obj, obj2, obj3);
        for (AbstractHashedMap.HashEntry<K, V> hashEntryDecoratedHashEntry = decoratedHashEntry(iHash); hashEntryDecoratedHashEntry != null; hashEntryDecoratedHashEntry = hashEntryDecoratedHashEntry.next) {
            if (hashEntryDecoratedHashEntry.hashCode == iHash && isEqualKey(hashEntryDecoratedHashEntry, obj, obj2, obj3)) {
                return hashEntryDecoratedHashEntry.getValue();
            }
        }
        return null;
    }

    public V get(Object obj, Object obj2, Object obj3, Object obj4) {
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        int iHash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap.HashEntry<K, V> hashEntryDecoratedHashEntry = decoratedHashEntry(iHash);
        while (hashEntryDecoratedHashEntry != null) {
            if (hashEntryDecoratedHashEntry.hashCode == iHash) {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
                if (isEqualKey(hashEntryDecoratedHashEntry, obj5, obj6, obj7, obj8)) {
                    return hashEntryDecoratedHashEntry.getValue();
                }
            } else {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
            }
            hashEntryDecoratedHashEntry = hashEntryDecoratedHashEntry.next;
            obj = obj5;
            obj2 = obj6;
            obj3 = obj7;
            obj4 = obj8;
        }
        return null;
    }

    public V get(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object obj6;
        int iHash = hash(obj, obj2, obj3, obj4, obj5);
        AbstractHashedMap.HashEntry<K, V> hashEntryDecoratedHashEntry = decoratedHashEntry(iHash);
        while (hashEntryDecoratedHashEntry != null) {
            if (hashEntryDecoratedHashEntry.hashCode == iHash) {
                obj6 = obj;
                if (isEqualKey(hashEntryDecoratedHashEntry, obj6, obj2, obj3, obj4, obj5)) {
                    return hashEntryDecoratedHashEntry.getValue();
                }
            } else {
                obj6 = obj;
            }
            hashEntryDecoratedHashEntry = hashEntryDecoratedHashEntry.next;
            obj = obj6;
        }
        return null;
    }

    protected int hash(Object obj, Object obj2) {
        int iHashCode = obj != null ? obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = i ^ (i >>> 14);
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    protected int hash(Object obj, Object obj2, Object obj3) {
        int iHashCode = obj != null ? obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            iHashCode ^= obj3.hashCode();
        }
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = i ^ (i >>> 14);
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    protected int hash(Object obj, Object obj2, Object obj3, Object obj4) {
        int iHashCode = obj != null ? obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            iHashCode ^= obj3.hashCode();
        }
        if (obj4 != null) {
            iHashCode ^= obj4.hashCode();
        }
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = i ^ (i >>> 14);
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    protected int hash(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int iHashCode = obj != null ? obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            iHashCode ^= obj3.hashCode();
        }
        if (obj4 != null) {
            iHashCode ^= obj4.hashCode();
        }
        if (obj5 != null) {
            iHashCode ^= obj5.hashCode();
        }
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = i ^ (i >>> 14);
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    protected boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry, Object obj, Object obj2) {
        MultiKey<? extends K> key = hashEntry.getKey();
        return key.size() == 2 && Objects.equals(obj, key.getKey(0)) && Objects.equals(obj2, key.getKey(1));
    }

    protected boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry, Object obj, Object obj2, Object obj3) {
        MultiKey<? extends K> key = hashEntry.getKey();
        return key.size() == 3 && Objects.equals(obj, key.getKey(0)) && Objects.equals(obj2, key.getKey(1)) && Objects.equals(obj3, key.getKey(2));
    }

    protected boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry, Object obj, Object obj2, Object obj3, Object obj4) {
        MultiKey<? extends K> key = hashEntry.getKey();
        return key.size() == 4 && Objects.equals(obj, key.getKey(0)) && Objects.equals(obj2, key.getKey(1)) && Objects.equals(obj3, key.getKey(2)) && Objects.equals(obj4, key.getKey(3));
    }

    protected boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        MultiKey<? extends K> key = hashEntry.getKey();
        return key.size() == 5 && Objects.equals(obj, key.getKey(0)) && Objects.equals(obj2, key.getKey(1)) && Objects.equals(obj3, key.getKey(2)) && Objects.equals(obj4, key.getKey(3)) && Objects.equals(obj5, key.getKey(4));
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public MapIterator<MultiKey<? extends K>, V> mapIterator() {
        return decorated().mapIterator();
    }

    public V put(K k, K k2, K k3, K k4, K k5, V v) {
        AbstractHashedMap.HashEntry<K, V> hashEntry;
        K k6;
        int iHash = hash(k, k2, k3, k4, k5);
        int iDecoratedHashIndex = decoratedHashIndex(iHash);
        AbstractHashedMap.HashEntry<K, V> hashEntry2 = decorated().data[iDecoratedHashIndex];
        while (hashEntry2 != null) {
            if (hashEntry2.hashCode == iHash) {
                K k7 = k;
                boolean zIsEqualKey = isEqualKey(hashEntry2, k7, k2, k3, k4, k5);
                hashEntry = hashEntry2;
                k6 = k7;
                if (zIsEqualKey) {
                    V value = hashEntry.getValue();
                    decorated().updateEntry(hashEntry, v);
                    return value;
                }
            } else {
                hashEntry = hashEntry2;
                k6 = k;
            }
            AbstractHashedMap.HashEntry<K, V> hashEntry3 = hashEntry.next;
            K k8 = k6;
            hashEntry2 = hashEntry3;
            k = k8;
        }
        decorated().addMapping(iDecoratedHashIndex, iHash, new MultiKey<>(k, k2, k3, k4, k5), v);
        return null;
    }

    public V put(K k, K k2, K k3, K k4, V v) {
        K k5;
        K k6;
        K k7;
        K k8;
        int iHash = hash(k, k2, k3, k4);
        int iDecoratedHashIndex = decoratedHashIndex(iHash);
        AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iDecoratedHashIndex];
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                k5 = k;
                k6 = k2;
                k7 = k3;
                k8 = k4;
                if (isEqualKey(hashEntry, k5, k6, k7, k8)) {
                    V value = hashEntry.getValue();
                    decorated().updateEntry(hashEntry, v);
                    return value;
                }
            } else {
                k5 = k;
                k6 = k2;
                k7 = k3;
                k8 = k4;
            }
            hashEntry = hashEntry.next;
            k = k5;
            k2 = k6;
            k3 = k7;
            k4 = k8;
        }
        decorated().addMapping(iDecoratedHashIndex, iHash, new MultiKey<>(k, k2, k3, k4), v);
        return null;
    }

    public V put(K k, K k2, K k3, V v) {
        int iHash = hash(k, k2, k3);
        int iDecoratedHashIndex = decoratedHashIndex(iHash);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iDecoratedHashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, k, k2, k3)) {
                V value = hashEntry.getValue();
                decorated().updateEntry(hashEntry, v);
                return value;
            }
        }
        decorated().addMapping(iDecoratedHashIndex, iHash, new MultiKey<>(k, k2, k3), v);
        return null;
    }

    public V put(K k, K k2, V v) {
        int iHash = hash(k, k2);
        int iDecoratedHashIndex = decoratedHashIndex(iHash);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iDecoratedHashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, k, k2)) {
                V value = hashEntry.getValue();
                decorated().updateEntry(hashEntry, v);
                return value;
            }
        }
        decorated().addMapping(iDecoratedHashIndex, iHash, new MultiKey<>(k, k2), v);
        return null;
    }

    /* WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public V put(MultiKey<? extends K> multiKey, V v) {
        checkKey(multiKey);
        return (V) super.put(multiKey, v);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends MultiKey<? extends K>, ? extends V> map) {
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            checkKey((MultiKey) it.next());
        }
        super.putAll(map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    public boolean removeAll(Object obj) {
        MapIterator<MultiKey<? extends K>, V> mapIterator = mapIterator();
        boolean z = false;
        while (mapIterator.hasNext()) {
            MultiKey<? extends K> next = mapIterator.next();
            if (next.size() >= 1 && Objects.equals(obj, next.getKey(0))) {
                mapIterator.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean removeAll(Object obj, Object obj2) {
        MapIterator<MultiKey<? extends K>, V> mapIterator = mapIterator();
        boolean z = false;
        while (mapIterator.hasNext()) {
            MultiKey<? extends K> next = mapIterator.next();
            if (next.size() >= 2 && Objects.equals(obj, next.getKey(0)) && Objects.equals(obj2, next.getKey(1))) {
                mapIterator.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean removeAll(Object obj, Object obj2, Object obj3) {
        MapIterator<MultiKey<? extends K>, V> mapIterator = mapIterator();
        boolean z = false;
        while (mapIterator.hasNext()) {
            MultiKey<? extends K> next = mapIterator.next();
            if (next.size() >= 3 && Objects.equals(obj, next.getKey(0)) && Objects.equals(obj2, next.getKey(1)) && Objects.equals(obj3, next.getKey(2))) {
                mapIterator.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean removeAll(Object obj, Object obj2, Object obj3, Object obj4) {
        MapIterator<MultiKey<? extends K>, V> mapIterator = mapIterator();
        boolean z = false;
        while (mapIterator.hasNext()) {
            MultiKey<? extends K> next = mapIterator.next();
            if (next.size() >= 4 && Objects.equals(obj, next.getKey(0)) && Objects.equals(obj2, next.getKey(1)) && Objects.equals(obj3, next.getKey(2)) && Objects.equals(obj4, next.getKey(3))) {
                mapIterator.remove();
                z = true;
            }
        }
        return z;
    }

    public V removeMultiKey(Object obj, Object obj2) {
        int iHash = hash(obj, obj2);
        int iDecoratedHashIndex = decoratedHashIndex(iHash);
        AbstractHashedMap.HashEntry<K, V> hashEntry = null;
        for (AbstractHashedMap.HashEntry<K, V> hashEntry2 = decorated().data[iDecoratedHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == iHash && isEqualKey(hashEntry2, obj, obj2)) {
                V value = hashEntry2.getValue();
                decorated().removeMapping(hashEntry2, iDecoratedHashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    public V removeMultiKey(Object obj, Object obj2, Object obj3) {
        int iHash = hash(obj, obj2, obj3);
        int iDecoratedHashIndex = decoratedHashIndex(iHash);
        AbstractHashedMap.HashEntry<K, V> hashEntry = null;
        for (AbstractHashedMap.HashEntry<K, V> hashEntry2 = decorated().data[iDecoratedHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == iHash && isEqualKey(hashEntry2, obj, obj2, obj3)) {
                V value = hashEntry2.getValue();
                decorated().removeMapping(hashEntry2, iDecoratedHashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    public V removeMultiKey(Object obj, Object obj2, Object obj3, Object obj4) {
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        int iHash = hash(obj, obj2, obj3, obj4);
        int iDecoratedHashIndex = decoratedHashIndex(iHash);
        AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iDecoratedHashIndex];
        AbstractHashedMap.HashEntry<K, V> hashEntry2 = null;
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
                if (isEqualKey(hashEntry, obj5, obj6, obj7, obj8)) {
                    V value = hashEntry.getValue();
                    decorated().removeMapping(hashEntry, iDecoratedHashIndex, hashEntry2);
                    return value;
                }
            } else {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
            }
            hashEntry2 = hashEntry;
            obj2 = obj6;
            obj3 = obj7;
            obj4 = obj8;
            hashEntry = hashEntry.next;
            obj = obj5;
        }
        return null;
    }

    public V removeMultiKey(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int iHash = hash(obj, obj2, obj3, obj4, obj5);
        int iDecoratedHashIndex = decoratedHashIndex(iHash);
        AbstractHashedMap.HashEntry<K, V> hashEntry = null;
        for (AbstractHashedMap.HashEntry<K, V> hashEntry2 = decorated().data[iDecoratedHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == iHash && isEqualKey(hashEntry2, obj, obj2, obj3, obj4, obj5)) {
                V value = hashEntry2.getValue();
                decorated().removeMapping(hashEntry2, iDecoratedHashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }
}

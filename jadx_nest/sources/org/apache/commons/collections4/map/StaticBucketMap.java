package org.apache.commons.collections4.map;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.KeyValue;

/* JADX INFO: loaded from: classes5.dex */
public final class StaticBucketMap<K, V> extends AbstractIterableMap<K, V> {
    private static final int DEFAULT_BUCKETS = 255;
    private final Node<K, V>[] buckets;
    private final Lock[] locks;

    class BaseIterator {
        private int bucket;
        private final ArrayList<Map.Entry<K, V>> current = new ArrayList<>();
        private Map.Entry<K, V> last;

        BaseIterator() {
        }

        public boolean hasNext() {
            if (!this.current.isEmpty()) {
                return true;
            }
            while (this.bucket < StaticBucketMap.this.buckets.length) {
                synchronized (StaticBucketMap.this.locks[this.bucket]) {
                    for (Node<K, V> node = StaticBucketMap.this.buckets[this.bucket]; node != null; node = node.next) {
                        this.current.add(node);
                    }
                    this.bucket++;
                    if (!this.current.isEmpty()) {
                        return true;
                    }
                }
            }
            return false;
        }

        protected Map.Entry<K, V> nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            ArrayList<Map.Entry<K, V>> arrayList = this.current;
            Map.Entry<K, V> entryRemove = arrayList.remove(arrayList.size() - 1);
            this.last = entryRemove;
            return entryRemove;
        }

        public void remove() {
            Map.Entry<K, V> entry = this.last;
            if (entry == null) {
                throw new IllegalStateException();
            }
            StaticBucketMap.this.remove(entry.getKey());
            this.last = null;
        }
    }

    private final class EntryIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<Map.Entry<K, V>> {
        private EntryIterator() {
            super();
        }

        /* synthetic */ EntryIterator(StaticBucketMap staticBucketMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    private final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        /* synthetic */ EntrySet(StaticBucketMap staticBucketMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            int hash = StaticBucketMap.this.getHash(entry.getKey());
            synchronized (StaticBucketMap.this.locks[hash]) {
                for (Node<K, V> node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                    if (node.equals(entry)) {
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(StaticBucketMap.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int hash = StaticBucketMap.this.getHash(entry.getKey());
            synchronized (StaticBucketMap.this.locks[hash]) {
                for (Node<K, V> node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                    if (node.equals(entry)) {
                        StaticBucketMap.this.remove(node.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    private final class KeyIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<K> {
        private KeyIterator() {
            super();
        }

        /* synthetic */ KeyIterator(StaticBucketMap staticBucketMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    private final class KeySet extends AbstractSet<K> {
        private KeySet() {
        }

        /* synthetic */ KeySet(StaticBucketMap staticBucketMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return StaticBucketMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator(StaticBucketMap.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int hash = StaticBucketMap.this.getHash(obj);
            synchronized (StaticBucketMap.this.locks[hash]) {
                for (Node<K, V> node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                    K key = node.getKey();
                    if (Objects.equals(key, obj)) {
                        StaticBucketMap.this.remove(key);
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    private static final class Lock {
        public int size;

        private Lock() {
        }

        /* synthetic */ Lock(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static final class Node<K, V> implements Map.Entry<K, V>, KeyValue<K, V> {
        protected K key;
        protected Node<K, V> next;
        protected V value;

        private Node() {
        }

        /* synthetic */ Node(AnonymousClass1 anonymousClass1) {
            this();
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
            return Objects.equals(this.key, entry.getKey()) && Objects.equals(this.value, entry.getValue());
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.key;
            int iHashCode = k == null ? 0 : k.hashCode();
            V v = this.value;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }
    }

    private final class ValueIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<V> {
        private ValueIterator() {
            super();
        }

        /* synthetic */ ValueIterator(StaticBucketMap staticBucketMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    private final class Values extends AbstractCollection<V> {
        private Values() {
        }

        /* synthetic */ Values(StaticBucketMap staticBucketMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator(StaticBucketMap.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    public StaticBucketMap() {
        this(255);
    }

    public StaticBucketMap(int i) {
        int iMax = Math.max(17, i);
        iMax = iMax % 2 == 0 ? iMax - 1 : iMax;
        this.buckets = new Node[iMax];
        this.locks = new Lock[iMax];
        for (int i2 = 0; i2 < iMax; i2++) {
            this.locks[i2] = new Lock(null);
        }
    }

    public void atomic(Runnable runnable) {
        atomic((Runnable) Objects.requireNonNull(runnable, "runnable"), 0);
    }

    private void atomic(Runnable runnable, int i) {
        if (i >= this.buckets.length) {
            runnable.run();
            return;
        }
        synchronized (this.locks[i]) {
            atomic(runnable, i + 1);
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        for (int i = 0; i < this.buckets.length; i++) {
            Lock lock = this.locks[i];
            synchronized (lock) {
                this.buckets[i] = null;
                lock.size = 0;
            }
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            for (Node<K, V> node = this.buckets[hash]; node != null; node = node.next) {
                if (Objects.equals(node.key, obj)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        for (int i = 0; i < this.buckets.length; i++) {
            synchronized (this.locks[i]) {
                for (Node<K, V> node = this.buckets[i]; node != null; node = node.next) {
                    if (Objects.equals(node.value, obj)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet(this, null);
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            for (Node<K, V> node = this.buckets[hash]; node != null; node = node.next) {
                if (Objects.equals(node.key, obj)) {
                    return node.value;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getHash(Object obj) {
        if (obj == null) {
            return 0;
        }
        int iHashCode = obj.hashCode();
        int i = iHashCode + (~(iHashCode << 15));
        int i2 = i ^ (i >>> 10);
        int i3 = i2 + (i2 << 3);
        int i4 = i3 ^ (i3 >>> 6);
        int i5 = i4 + (~(i4 << 11));
        int length = (i5 ^ (i5 >>> 16)) % this.buckets.length;
        return length < 0 ? length * (-1) : length;
    }

    @Override // java.util.Map
    public int hashCode() {
        int iHashCode = 0;
        for (int i = 0; i < this.buckets.length; i++) {
            synchronized (this.locks[i]) {
                for (Node<K, V> node = this.buckets[i]; node != null; node = node.next) {
                    iHashCode += node.hashCode();
                }
            }
        }
        return iHashCode;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        return new KeySet(this, null);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        int hash = getHash(k);
        synchronized (this.locks[hash]) {
            Node<K, V> node = this.buckets[hash];
            if (node == null) {
                Node<K, V> node2 = new Node<>(null);
                node2.key = k;
                node2.value = v;
                this.buckets[hash] = node2;
                this.locks[hash].size++;
                return null;
            }
            Node<K, V> node3 = node;
            while (node != null) {
                if (!Objects.equals(node.key, k)) {
                    node3 = node;
                    node = node.next;
                } else {
                    V v2 = node.value;
                    node.value = v;
                    return v2;
                }
            }
            Node<K, V> node4 = new Node<>(null);
            node4.key = k;
            node4.value = v;
            node3.next = node4;
            this.locks[hash].size++;
            return null;
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            Node<K, V> node = null;
            for (Node<K, V> node2 = this.buckets[hash]; node2 != null; node2 = node2.next) {
                if (Objects.equals(node2.key, obj)) {
                    if (node == null) {
                        this.buckets[hash] = node2.next;
                    } else {
                        node.next = node2.next;
                    }
                    this.locks[hash].size--;
                    return node2.value;
                }
                node = node2;
            }
            return null;
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        int i = 0;
        for (int i2 = 0; i2 < this.buckets.length; i2++) {
            synchronized (this.locks[i2]) {
                i += this.locks[i2].size;
            }
        }
        return i;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        return new Values(this, null);
    }
}

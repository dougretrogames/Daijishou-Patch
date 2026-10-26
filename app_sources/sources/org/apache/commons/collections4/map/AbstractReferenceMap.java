package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.DefaultMapEntry;

/* INFO: loaded from: classes5.dex */
public abstract class AbstractReferenceMap<K, V> extends AbstractHashedMap<K, V> {
    private ReferenceStrength keyType;
    private boolean purgeValues;
    private transient ReferenceQueue<Object> queue;
    private ReferenceStrength valueType;

    /* WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected /* bridge */ /* synthetic */ AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry hashEntry, int i, Object obj, Object obj2) {
        return createEntry((AbstractHashedMap.HashEntry<Object, Object>) hashEntry, i, obj, obj2);
    }

    static class ReferenceBaseIterator<K, V> {
        ReferenceEntry<K, V> current;
        K currentKey;
        V currentValue;
        int expectedModCount;
        int index;
        ReferenceEntry<K, V> next;
        K nextKey;
        V nextValue;
        final AbstractReferenceMap<K, V> parent;

        ReferenceBaseIterator(AbstractReferenceMap<K, V> abstractReferenceMap) {
            this.parent = abstractReferenceMap;
            this.index = !abstractReferenceMap.isEmpty() ? abstractReferenceMap.data.length : 0;
            this.expectedModCount = abstractReferenceMap.modCount;
        }

        private void checkMod() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        protected ReferenceEntry<K, V> currentEntry() {
            checkMod();
            return this.current;
        }

        public boolean hasNext() {
            checkMod();
            while (nextNull()) {
                ReferenceEntry<K, V> referenceEntry = this.next;
                int i = this.index;
                while (referenceEntry == null && i > 0) {
                    i--;
                    referenceEntry = (ReferenceEntry) this.parent.data[i];
                }
                this.next = referenceEntry;
                this.index = i;
                if (referenceEntry == null) {
                    return false;
                }
                this.nextKey = referenceEntry.getKey();
                this.nextValue = referenceEntry.getValue();
                if (nextNull()) {
                    this.next = this.next.next();
                }
            }
            return true;
        }

        protected ReferenceEntry<K, V> nextEntry() {
            checkMod();
            if (nextNull() && !hasNext()) {
                throw new NoSuchElementException();
            }
            ReferenceEntry<K, V> referenceEntry = this.next;
            this.current = referenceEntry;
            this.next = referenceEntry.next();
            this.currentKey = this.nextKey;
            this.currentValue = this.nextValue;
            this.nextKey = null;
            this.nextValue = null;
            return this.current;
        }

        private boolean nextNull() {
            return this.nextKey == null || this.nextValue == null;
        }

        public void remove() {
            checkMod();
            if (this.current == null) {
                throw new IllegalStateException();
            }
            this.parent.remove(this.currentKey);
            this.current = null;
            this.currentKey = null;
            this.currentValue = null;
            this.expectedModCount = this.parent.modCount;
        }
    }

    protected static class ReferenceEntry<K, V> extends AbstractHashedMap.HashEntry<K, V> {
        private final AbstractReferenceMap<K, V> parent;

        protected void onPurge() {
        }

        public ReferenceEntry(AbstractReferenceMap<K, V> abstractReferenceMap, AbstractHashedMap.HashEntry<K, V> hashEntry, int i, K k, V v) {
            super(hashEntry, i, null, null);
            this.parent = abstractReferenceMap;
            this.key = toReference(((AbstractReferenceMap) abstractReferenceMap).keyType, k, i);
            this.value = toReference(((AbstractReferenceMap) abstractReferenceMap).valueType, v, i);
        }

        @Override // org.apache.commons.collections4.map.AbstractHashedMap.HashEntry, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return key != null && value != null && this.parent.isEqualKey(key, this.key) && this.parent.isEqualValue(value, getValue());
        }

        @Override // org.apache.commons.collections4.map.AbstractHashedMap.HashEntry, java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public K getKey() {
            return ((AbstractReferenceMap) this.parent).keyType == ReferenceStrength.HARD ? (K) this.key : (K) ((Reference) this.key).get();
        }

        @Override // org.apache.commons.collections4.map.AbstractHashedMap.HashEntry, java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public V getValue() {
            return ((AbstractReferenceMap) this.parent).valueType == ReferenceStrength.HARD ? (V) this.value : (V) ((Reference) this.value).get();
        }

        @Override // org.apache.commons.collections4.map.AbstractHashedMap.HashEntry, java.util.Map.Entry
        public int hashCode() {
            return this.parent.hashEntry(getKey(), getValue());
        }

        protected ReferenceEntry<K, V> next() {
            return (ReferenceEntry) this.next;
        }

        protected void nullValue() {
            this.value = null;
        }

        protected boolean purge(Reference<?> reference) {
            boolean z = (((AbstractReferenceMap) this.parent).keyType != ReferenceStrength.HARD && this.key == reference) || (((AbstractReferenceMap) this.parent).valueType != ReferenceStrength.HARD && this.value == reference);
            if (z) {
                if (((AbstractReferenceMap) this.parent).keyType != ReferenceStrength.HARD) {
                    ((Reference) this.key).clear();
                }
                if (((AbstractReferenceMap) this.parent).valueType == ReferenceStrength.HARD) {
                    if (((AbstractReferenceMap) this.parent).purgeValues) {
                        nullValue();
                    }
                } else {
                    ((Reference) this.value).clear();
                    return z;
                }
            }
            return z;
        }

        @Override // org.apache.commons.collections4.map.AbstractHashedMap.HashEntry, java.util.Map.Entry
        public V setValue(V v) {
            V value = getValue();
            if (((AbstractReferenceMap) this.parent).valueType != ReferenceStrength.HARD) {
                ((Reference) this.value).clear();
            }
            this.value = toReference(((AbstractReferenceMap) this.parent).valueType, v, this.hashCode);
            return value;
        }

        protected <T> Object toReference(ReferenceStrength referenceStrength, T t, int i) {
            int iOrdinal = referenceStrength.ordinal();
            if (iOrdinal == 0) {
                return t;
            }
            if (iOrdinal == 1) {
                return new SoftRef(i, t, ((AbstractReferenceMap) this.parent).queue);
            }
            if (iOrdinal == 2) {
                return new WeakRef(i, t, ((AbstractReferenceMap) this.parent).queue);
            }
            throw new Error();
        }
    }

    static class ReferenceEntrySet<K, V> extends AbstractHashedMap.EntrySet<K, V> {
        protected ReferenceEntrySet(AbstractHashedMap<K, V> abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return toArray(new Object[size()]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList(size());
            Iterator<Map.Entry<K, V>> it = iterator();
            while (it.hasNext()) {
                arrayList.add(new DefaultMapEntry(it.next()));
            }
            return (T[]) arrayList.toArray(tArr);
        }
    }

    static class ReferenceEntrySetIterator<K, V> extends ReferenceBaseIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        ReferenceEntrySetIterator(AbstractReferenceMap<K, V> abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    static class ReferenceKeySet<K> extends AbstractHashedMap.KeySet<K> {
        protected ReferenceKeySet(AbstractHashedMap<K, ?> abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return toArray(new Object[size()]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList(size());
            Objects.requireNonNull(arrayList);
            forEach(new AbstractReferenceMap$ReferenceKeySet$$ExternalSyntheticLambda0(arrayList));
            return (T[]) arrayList.toArray(tArr);
        }
    }

    static class ReferenceKeySetIterator<K> extends ReferenceBaseIterator<K, Object> implements Iterator<K> {
        ReferenceKeySetIterator(AbstractReferenceMap<K, ?> abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    static class ReferenceMapIterator<K, V> extends ReferenceBaseIterator<K, V> implements MapIterator<K, V> {
        protected ReferenceMapIterator(AbstractReferenceMap<K, V> abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            ReferenceEntry<K, V> referenceEntryCurrentEntry = currentEntry();
            if (referenceEntryCurrentEntry == null) {
                throw new IllegalStateException("getKey() can only be called after next() and before remove()");
            }
            return referenceEntryCurrentEntry.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            ReferenceEntry<K, V> referenceEntryCurrentEntry = currentEntry();
            if (referenceEntryCurrentEntry == null) {
                throw new IllegalStateException("getValue() can only be called after next() and before remove()");
            }
            return referenceEntryCurrentEntry.getValue();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v) {
            ReferenceEntry<K, V> referenceEntryCurrentEntry = currentEntry();
            if (referenceEntryCurrentEntry == null) {
                throw new IllegalStateException("setValue() can only be called after next() and before remove()");
            }
            return referenceEntryCurrentEntry.setValue(v);
        }
    }

    public enum ReferenceStrength {
        HARD(0),
        SOFT(1),
        WEAK(2);

        public final int value;

        public static ReferenceStrength resolve(int i) {
            if (i == 0) {
                return HARD;
            }
            if (i == 1) {
                return SOFT;
            }
            if (i == 2) {
                return WEAK;
            }
            throw new IllegalArgumentException();
        }

        ReferenceStrength(int i) {
            this.value = i;
        }
    }

    static class ReferenceValues<V> extends AbstractHashedMap.Values<V> {
        protected ReferenceValues(AbstractHashedMap<?, V> abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return toArray(new Object[size()]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList(size());
            Objects.requireNonNull(arrayList);
            forEach(new AbstractReferenceMap$ReferenceKeySet$$ExternalSyntheticLambda0(arrayList));
            return (T[]) arrayList.toArray(tArr);
        }
    }

    static class ReferenceValuesIterator<V> extends ReferenceBaseIterator<Object, V> implements Iterator<V> {
        ReferenceValuesIterator(AbstractReferenceMap<?, V> abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    static class SoftRef<T> extends SoftReference<T> {
        private final int hash;

        SoftRef(int i, T t, ReferenceQueue<? super T> referenceQueue) {
            super(t, referenceQueue);
            this.hash = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.hash == ((SoftRef) obj).hash;
        }

        public int hashCode() {
            return this.hash;
        }
    }

    static class WeakRef<T> extends WeakReference<T> {
        private final int hash;

        WeakRef(int i, T t, ReferenceQueue<? super T> referenceQueue) {
            super(t, referenceQueue);
            this.hash = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.hash == ((WeakRef) obj).hash;
        }

        public int hashCode() {
            return this.hash;
        }
    }

    protected AbstractReferenceMap() {
    }

    protected AbstractReferenceMap(ReferenceStrength referenceStrength, ReferenceStrength referenceStrength2, int i, float f, boolean z) {
        super(i, f);
        this.keyType = referenceStrength;
        this.valueType = referenceStrength2;
        this.purgeValues = z;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        super.clear();
        while (this.queue.poll() != null) {
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        purgeBeforeRead();
        AbstractHashedMap.HashEntry<K, V> entry = getEntry(obj);
        return (entry == null || entry.getValue() == null) ? false : true;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        purgeBeforeRead();
        if (obj == null) {
            return false;
        }
        return super.containsValue(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected ReferenceEntry<K, V> createEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i, K k, V v) {
        return new ReferenceEntry<>(this, hashEntry, i, k, v);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        return new ReferenceEntrySetIterator(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected Iterator<K> createKeySetIterator() {
        return new ReferenceKeySetIterator(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected Iterator<V> createValuesIterator() {
        return new ReferenceValuesIterator(this);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.keyType = ReferenceStrength.resolve(objectInputStream.readInt());
        this.valueType = ReferenceStrength.resolve(objectInputStream.readInt());
        this.purgeValues = objectInputStream.readBoolean();
        this.loadFactor = objectInputStream.readFloat();
        int i = objectInputStream.readInt();
        init();
        this.data = new AbstractHashedMap.HashEntry[i];
        this.threshold = calculateThreshold(this.data.length, this.loadFactor);
        while (true) {
            Object object = objectInputStream.readObject();
            if (object == null) {
                return;
            } else {
                put(object, objectInputStream.readObject());
            }
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.keyType.value);
        objectOutputStream.writeInt(this.valueType.value);
        objectOutputStream.writeBoolean(this.purgeValues);
        objectOutputStream.writeFloat(this.loadFactor);
        objectOutputStream.writeInt(this.data.length);
        MapIterator<K, V> mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            objectOutputStream.writeObject(mapIterator.next());
            objectOutputStream.writeObject(mapIterator.getValue());
        }
        objectOutputStream.writeObject(null);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new ReferenceEntrySet(this);
        }
        return this.entrySet;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        purgeBeforeRead();
        AbstractHashedMap.HashEntry<K, V> entry = getEntry(obj);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected AbstractHashedMap.HashEntry<K, V> getEntry(Object obj) {
        if (obj == null) {
            return null;
        }
        return super.getEntry(obj);
    }

    protected int hashEntry(Object obj, Object obj2) {
        return (obj == null ? 0 : obj.hashCode()) ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected void init() {
        this.queue = new ReferenceQueue<>();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        purgeBeforeRead();
        return super.isEmpty();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected boolean isEqualKey(Object obj, Object obj2) {
        if (this.keyType != ReferenceStrength.HARD) {
            obj2 = ((Reference) obj2).get();
        }
        return Objects.equals(obj, obj2);
    }

    protected boolean isKeyType(ReferenceStrength referenceStrength) {
        return this.keyType == referenceStrength;
    }

    protected boolean isValueType(ReferenceStrength referenceStrength) {
        return this.valueType == referenceStrength;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = new ReferenceKeySet(this);
        }
        return this.keySet;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, org.apache.commons.collections4.IterableGet
    public MapIterator<K, V> mapIterator() {
        return new ReferenceMapIterator(this);
    }

    protected void purge() {
        Reference<? extends Object> referencePoll = this.queue.poll();
        while (referencePoll != null) {
            purge(referencePoll);
            referencePoll = this.queue.poll();
        }
    }

    protected void purge(Reference<?> reference) {
        int iHashIndex = hashIndex(reference.hashCode(), this.data.length);
        AbstractHashedMap.HashEntry<K, V> hashEntry = null;
        for (AbstractHashedMap.HashEntry<K, V> hashEntry2 = this.data[iHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            ReferenceEntry referenceEntry = (ReferenceEntry) hashEntry2;
            if (referenceEntry.purge(reference)) {
                if (hashEntry == null) {
                    this.data[iHashIndex] = hashEntry2.next;
                } else {
                    hashEntry.next = hashEntry2.next;
                }
                this.size--;
                referenceEntry.onPurge();
                return;
            }
            hashEntry = hashEntry2;
        }
    }

    protected void purgeBeforeRead() {
        purge();
    }

    protected void purgeBeforeWrite() {
        purge();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key");
        Objects.requireNonNull(v, "value");
        purgeBeforeWrite();
        return (V) super.put(k, v);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        purgeBeforeWrite();
        return (V) super.remove(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        purgeBeforeRead();
        return super.size();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        if (this.values == null) {
            this.values = new ReferenceValues(this);
        }
        return this.values;
    }
}

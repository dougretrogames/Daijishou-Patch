package org.apache.commons.collections4.multimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.apache.commons.collections4.keyvalue.UnmodifiableMapEntry;
import org.apache.commons.collections4.multiset.AbstractMultiSet;
import org.apache.commons.collections4.multiset.UnmodifiableMultiSet;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractMultiValuedMap<K, V> implements MultiValuedMap<K, V> {
    private transient AbstractMultiValuedMap<K, V>.AsMap asMapView;
    private transient AbstractMultiValuedMap<K, V>.EntryValues entryValuesView;
    private transient MultiSet<K> keysMultiSetView;
    private transient Map<K, Collection<V>> map;
    private transient Collection<V> valuesView;

    protected abstract Collection<V> createCollection();

    private final class AsMap extends AbstractMap<K, Collection<V>> {
        final transient Map<K, Collection<V>> map;

        final class AsMapEntrySet extends AbstractSet<Map.Entry<K, Collection<V>>> {
            AsMapEntrySet() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AsMap.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return AsMap.this.map.entrySet().contains(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                AsMap asMap = AsMap.this;
                return asMap.new AsMapEntrySetIterator(asMap.map.entrySet().iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                AbstractMultiValuedMap.this.remove(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AsMap.this.size();
            }
        }

        final class AsMapEntrySetIterator extends AbstractIteratorDecorator<Map.Entry<K, Collection<V>>> {
            AsMapEntrySetIterator(Iterator<Map.Entry<K, Collection<V>>> it) {
                super(it);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
            public Map.Entry<K, Collection<V>> next() {
                Object key = ((Map.Entry) super.next()).getKey();
                return new UnmodifiableMapEntry(key, AbstractMultiValuedMap.this.wrappedCollection(key));
            }
        }

        AsMap(Map<K, Collection<V>> map) {
            this.map = map;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            AbstractMultiValuedMap.this.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            return new AsMapEntrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.map.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> get(Object obj) {
            if (this.map.get(obj) == null) {
                return null;
            }
            return AbstractMultiValuedMap.this.wrappedCollection(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return AbstractMultiValuedMap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> remove(Object obj) {
            Collection<V> collectionRemove = this.map.remove(obj);
            if (collectionRemove == null) {
                return null;
            }
            Collection<V> collectionCreateCollection = AbstractMultiValuedMap.this.createCollection();
            collectionCreateCollection.addAll(collectionRemove);
            collectionRemove.clear();
            return collectionCreateCollection;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.map.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.map.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class EntryValues extends AbstractCollection<Map.Entry<K, V>> {
        private EntryValues() {
        }

        /* synthetic */ EntryValues(AbstractMultiValuedMap abstractMultiValuedMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX INFO: renamed from: org.apache.commons.collections4.multimap.AbstractMultiValuedMap$EntryValues$1, reason: invalid class name */
        class AnonymousClass1 extends LazyIteratorChain<Map.Entry<K, V>> {
            final Iterator<K> keyIterator;
            final Collection<K> keysCol;

            AnonymousClass1() {
                ArrayList arrayList = new ArrayList(AbstractMultiValuedMap.this.getMap().keySet());
                this.keysCol = arrayList;
                this.keyIterator = arrayList.iterator();
            }

            @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
            protected Iterator<? extends Map.Entry<K, V>> nextIterator(int i) {
                if (!this.keyIterator.hasNext()) {
                    return null;
                }
                K next = this.keyIterator.next();
                return new TransformIterator(new ValuesIterator(next), new AbstractMultiValuedMap$EntryValues$1$$ExternalSyntheticLambda0(this, next));
            }

            /* JADX INFO: renamed from: lambda$nextIterator$0$org-apache-commons-collections4-multimap-AbstractMultiValuedMap$EntryValues$1, reason: not valid java name */
            /* synthetic */ Map.Entry m5544x8ddfe9cc(Object obj, Object obj2) {
                return new MultiValuedMapEntry(obj, obj2);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new AnonymousClass1();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractMultiValuedMap.this.size();
        }
    }

    private final class KeysMultiSet extends AbstractMultiSet<K> {
        private KeysMultiSet() {
        }

        /* synthetic */ KeysMultiSet(AbstractMultiValuedMap abstractMultiValuedMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        private final class MapEntryTransformer implements Transformer<Map.Entry<K, Collection<V>>, MultiSet.Entry<K>> {
            private MapEntryTransformer() {
            }

            /* synthetic */ MapEntryTransformer(KeysMultiSet keysMultiSet, AnonymousClass1 anonymousClass1) {
                this();
            }

            /* JADX INFO: renamed from: org.apache.commons.collections4.multimap.AbstractMultiValuedMap$KeysMultiSet$MapEntryTransformer$1, reason: invalid class name */
            class AnonymousClass1 extends AbstractMultiSet.AbstractEntry<K> {
                final /* synthetic */ MapEntryTransformer this$2;
                final /* synthetic */ Map.Entry val$mapEntry;

                AnonymousClass1(MapEntryTransformer mapEntryTransformer, Map.Entry entry) {
                    this.val$mapEntry = entry;
                    this.this$2 = mapEntryTransformer;
                }

                @Override // org.apache.commons.collections4.MultiSet.Entry
                public int getCount() {
                    return ((Collection) this.val$mapEntry.getValue()).size();
                }

                @Override // org.apache.commons.collections4.MultiSet.Entry
                public K getElement() {
                    return (K) this.val$mapEntry.getKey();
                }
            }

            @Override // org.apache.commons.collections4.Transformer
            public MultiSet.Entry<K> transform(Map.Entry<K, Collection<V>> entry) {
                return new AnonymousClass1(this, entry);
            }
        }

        @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractMultiValuedMap.this.getMap().containsKey(obj);
        }

        @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
        protected Iterator<MultiSet.Entry<K>> createEntrySetIterator() {
            return IteratorUtils.transformedIterator(AbstractMultiValuedMap.this.map.entrySet().iterator(), new MapEntryTransformer(this, null));
        }

        @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, org.apache.commons.collections4.MultiSet
        public int getCount(Object obj) {
            Collection<V> collection = AbstractMultiValuedMap.this.getMap().get(obj);
            if (collection != null) {
                return collection.size();
            }
            return 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return AbstractMultiValuedMap.this.getMap().isEmpty();
        }

        @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection, org.apache.commons.collections4.MultiSet
        public int size() {
            return AbstractMultiValuedMap.this.size();
        }

        @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
        protected int uniqueElements() {
            return AbstractMultiValuedMap.this.getMap().size();
        }
    }

    private final class MultiValuedMapEntry extends AbstractMapEntry<K, V> {
        MultiValuedMapEntry(K k, V v) {
            super(k, v);
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractMapEntry, org.apache.commons.collections4.keyvalue.AbstractKeyValue, java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException();
        }
    }

    private final class MultiValuedMapIterator implements MapIterator<K, V> {
        private Map.Entry<K, V> current;
        private final Iterator<Map.Entry<K, V>> it;

        MultiValuedMapIterator() {
            this.it = AbstractMultiValuedMap.this.entries().iterator();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            Map.Entry<K, V> entry = this.current;
            if (entry == null) {
                throw new IllegalStateException();
            }
            return entry.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            Map.Entry<K, V> entry = this.current;
            if (entry == null) {
                throw new IllegalStateException();
            }
            return entry.getValue();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.it.hasNext();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            Map.Entry<K, V> next = this.it.next();
            this.current = next;
            return next.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            this.it.remove();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v) {
            Map.Entry<K, V> entry = this.current;
            if (entry == null) {
                throw new IllegalStateException();
            }
            return entry.setValue(v);
        }
    }

    private final class Values extends AbstractCollection<V> {
        private Values() {
        }

        /* synthetic */ Values(AbstractMultiValuedMap abstractMultiValuedMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractMultiValuedMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            IteratorChain iteratorChain = new IteratorChain();
            Iterator<K> it = AbstractMultiValuedMap.this.keySet().iterator();
            while (it.hasNext()) {
                iteratorChain.addIterator(new ValuesIterator(it.next()));
            }
            return iteratorChain;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractMultiValuedMap.this.size();
        }
    }

    private final class ValuesIterator implements Iterator<V> {
        private final Iterator<V> iterator;
        private final Object key;
        private final Collection<V> values;

        ValuesIterator(Object obj) {
            this.key = obj;
            Collection<V> collection = AbstractMultiValuedMap.this.getMap().get(obj);
            this.values = collection;
            this.iterator = collection.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.iterator.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
            if (this.values.isEmpty()) {
                AbstractMultiValuedMap.this.remove(this.key);
            }
        }
    }

    class WrappedCollection implements Collection<V> {
        protected final K key;

        WrappedCollection(K k) {
            this.key = k;
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            Collection<V> mapping = getMapping();
            if (mapping == null) {
                mapping = AbstractMultiValuedMap.this.createCollection();
                AbstractMultiValuedMap.this.map.put(this.key, mapping);
            }
            return mapping.add(v);
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            Collection<V> mapping = getMapping();
            if (mapping == null) {
                mapping = AbstractMultiValuedMap.this.createCollection();
                AbstractMultiValuedMap.this.map.put(this.key, mapping);
            }
            return mapping.addAll(collection);
        }

        @Override // java.util.Collection
        public void clear() {
            Collection<V> mapping = getMapping();
            if (mapping != null) {
                mapping.clear();
                AbstractMultiValuedMap.this.remove(this.key);
            }
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            Collection<V> mapping = getMapping();
            return mapping != null && mapping.contains(obj);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Collection<V> mapping = getMapping();
            return mapping != null && mapping.containsAll(collection);
        }

        protected Collection<V> getMapping() {
            return AbstractMultiValuedMap.this.getMap().get(this.key);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            Collection<V> mapping = getMapping();
            return mapping == null || mapping.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            if (getMapping() == null) {
                return IteratorUtils.EMPTY_ITERATOR;
            }
            return new ValuesIterator(this.key);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            Collection<V> mapping = getMapping();
            if (mapping == null) {
                return false;
            }
            boolean zRemove = mapping.remove(obj);
            if (mapping.isEmpty()) {
                AbstractMultiValuedMap.this.remove(this.key);
            }
            return zRemove;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Collection<V> mapping = getMapping();
            if (mapping == null) {
                return false;
            }
            boolean zRemoveAll = mapping.removeAll(collection);
            if (mapping.isEmpty()) {
                AbstractMultiValuedMap.this.remove(this.key);
            }
            return zRemoveAll;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Collection<V> mapping = getMapping();
            if (mapping == null) {
                return false;
            }
            boolean zRetainAll = mapping.retainAll(collection);
            if (mapping.isEmpty()) {
                AbstractMultiValuedMap.this.remove(this.key);
            }
            return zRetainAll;
        }

        @Override // java.util.Collection
        public int size() {
            Collection<V> mapping = getMapping();
            if (mapping == null) {
                return 0;
            }
            return mapping.size();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            Collection<V> mapping = getMapping();
            if (mapping == null) {
                return CollectionUtils.EMPTY_COLLECTION.toArray();
            }
            return mapping.toArray();
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            Collection<V> mapping = getMapping();
            if (mapping == null) {
                return (T[]) CollectionUtils.EMPTY_COLLECTION.toArray(tArr);
            }
            return (T[]) mapping.toArray(tArr);
        }

        public String toString() {
            Collection<V> mapping = getMapping();
            if (mapping == null) {
                return CollectionUtils.EMPTY_COLLECTION.toString();
            }
            return mapping.toString();
        }
    }

    protected AbstractMultiValuedMap() {
    }

    protected AbstractMultiValuedMap(Map<K, ? extends Collection<V>> map) {
        this.map = (Map) Objects.requireNonNull(map, "map");
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Map<K, Collection<V>> asMap() {
        AbstractMultiValuedMap<K, V>.AsMap asMap = this.asMapView;
        if (asMap != null) {
            return asMap;
        }
        AbstractMultiValuedMap<K, V>.AsMap asMap2 = new AsMap(this.map);
        this.asMapView = asMap2;
        return asMap2;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public void clear() {
        getMap().clear();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean containsKey(Object obj) {
        return getMap().containsKey(obj);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean containsMapping(Object obj, Object obj2) {
        Collection<V> collection = getMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int i = objectInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            Collection collection = get(objectInputStream.readObject());
            int i3 = objectInputStream.readInt();
            for (int i4 = 0; i4 < i3; i4++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    protected void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.map.size());
        for (Map.Entry<K, Collection<V>> entry : this.map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<Map.Entry<K, V>> entries() {
        AbstractMultiValuedMap<K, V>.EntryValues entryValues = this.entryValuesView;
        if (entryValues != null) {
            return entryValues;
        }
        AbstractMultiValuedMap<K, V>.EntryValues entryValues2 = new EntryValues(this, null);
        this.entryValuesView = entryValues2;
        return entryValues2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MultiValuedMap) {
            return asMap().equals(((MultiValuedMap) obj).asMap());
        }
        return false;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<V> get(K k) {
        return wrappedCollection(k);
    }

    protected Map<K, ? extends Collection<V>> getMap() {
        return this.map;
    }

    public int hashCode() {
        return getMap().hashCode();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean isEmpty() {
        return getMap().isEmpty();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public MultiSet<K> keys() {
        if (this.keysMultiSetView == null) {
            this.keysMultiSetView = UnmodifiableMultiSet.unmodifiableMultiSet(new KeysMultiSet(this, null));
        }
        return this.keysMultiSetView;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Set<K> keySet() {
        return getMap().keySet();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public MapIterator<K, V> mapIterator() {
        if (isEmpty()) {
            return EmptyMapIterator.emptyMapIterator();
        }
        return new MultiValuedMapIterator();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean put(K k, V v) {
        Collection<V> collection = getMap().get(k);
        if (collection == null) {
            Collection<V> collectionCreateCollection = createCollection();
            if (!collectionCreateCollection.add(v)) {
                return false;
            }
            this.map.put(k, collectionCreateCollection);
            return true;
        }
        return collection.add(v);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        Objects.requireNonNull(iterable, "values");
        if (iterable instanceof Collection) {
            Collection<? extends V> collection = (Collection) iterable;
            return !collection.isEmpty() && get(k).addAll(collection);
        }
        Iterator<? extends V> it = iterable.iterator();
        return it.hasNext() && CollectionUtils.addAll(get(k), it);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(Map<? extends K, ? extends V> map) {
        Objects.requireNonNull(map, "map");
        boolean zPut = false;
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            zPut |= put(entry.getKey(), entry.getValue());
        }
        return zPut;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(MultiValuedMap<? extends K, ? extends V> multiValuedMap) {
        Objects.requireNonNull(multiValuedMap, "map");
        boolean zPut = false;
        for (Map.Entry<? extends K, ? extends V> entry : multiValuedMap.entries()) {
            zPut |= put(entry.getKey(), entry.getValue());
        }
        return zPut;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<V> remove(Object obj) {
        return CollectionUtils.emptyIfNull(getMap().remove(obj));
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean removeMapping(Object obj, Object obj2) {
        Collection<V> collection = getMap().get(obj);
        if (collection == null) {
            return false;
        }
        boolean zRemove = collection.remove(obj2);
        if (collection.isEmpty()) {
            getMap().remove(obj);
        }
        return zRemove;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void setMap(Map<K, ? extends Collection<V>> map) {
        this.map = map;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public int size() {
        Iterator<? extends Collection<V>> it = getMap().values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    public String toString() {
        return getMap().toString();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Values values = new Values(this, null);
        this.valuesView = values;
        return values;
    }

    Collection<V> wrappedCollection(K k) {
        return new WrappedCollection(k);
    }
}

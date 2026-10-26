package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;

/* INFO: loaded from: classes5.dex */
@Deprecated
public class MultiValueMap<K, V> extends AbstractMapDecorator<K, Object> implements MultiMap<K, V>, Serializable {
    private static final long serialVersionUID = -2214159910087182007L;
    private final Factory<? extends Collection<V>> collectionFactory;
    private transient Collection<V> valuesView;

    private static final class ReflectionFactory<T extends Collection<?>> implements Factory<T>, Serializable {
        private static final long serialVersionUID = 2986114157496788874L;
        private final Class<T> clazz;

        ReflectionFactory(Class<T> cls) {
            this.clazz = cls;
        }

        @Override // org.apache.commons.collections4.Factory
        public T create() {
            try {
                return this.clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                throw new FunctorException("Cannot instantiate class: " + this.clazz, e);
            }
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            Class<T> cls = this.clazz;
            if (cls != null && !Collection.class.isAssignableFrom(cls)) {
                throw new UnsupportedOperationException();
            }
        }
    }

    private final class Values extends AbstractCollection<V> {
        private Values() {
        }

        /* synthetic */ Values(MultiValueMap multiValueMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MultiValueMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            IteratorChain iteratorChain = new IteratorChain();
            Iterator<K> it = MultiValueMap.this.keySet().iterator();
            while (it.hasNext()) {
                iteratorChain.addIterator(new ValuesIterator(it.next()));
            }
            return iteratorChain;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MultiValueMap.this.totalSize();
        }
    }

    private final class ValuesIterator implements Iterator<V> {
        private final Iterator<V> iterator;
        private final Object key;
        private final Collection<V> values;

        ValuesIterator(Object obj) {
            this.key = obj;
            Collection<V> collection = MultiValueMap.this.getCollection(obj);
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
                MultiValueMap.this.remove(this.key);
            }
        }
    }

    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, ? super C> map, Class<C> cls) {
        return new MultiValueMap<>(map, new ReflectionFactory(cls));
    }

    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, ? super C> map, Factory<C> factory) {
        return new MultiValueMap<>(map, factory);
    }

    public static <K, V> MultiValueMap<K, V> multiValueMap(Map<K, ? super Collection<V>> map) {
        return multiValueMap(map, ArrayList.class);
    }

    public MultiValueMap() {
        this(new HashMap(), new ReflectionFactory(ArrayList.class));
    }

    /* WARN: Multi-variable type inference failed */
    protected <C extends Collection<V>> MultiValueMap(Map<K, ? super C> map, Factory<C> factory) {
        super(map);
        if (factory == 0) {
            throw new IllegalArgumentException("The factory must not be null");
        }
        this.collectionFactory = factory;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        decorated().clear();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        Set<Map.Entry<K, V>> setEntrySet = decorated().entrySet();
        if (setEntrySet == null) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (((Collection) it.next().getValue()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object obj, Object obj2) {
        Collection<V> collection = getCollection(obj);
        if (collection == null) {
            return false;
        }
        return collection.contains(obj2);
    }

    protected Collection<V> createCollection(int i) {
        return this.collectionFactory.get();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, Object>> entrySet() {
        return super.entrySet();
    }

    public Collection<V> getCollection(Object obj) {
        return (Collection) decorated().get(obj);
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new AnonymousClass1(this, new ArrayList(keySet()).iterator());
    }

    /* INFO: renamed from: org.apache.commons.collections4.map.MultiValueMap$1, reason: invalid class name */
    class AnonymousClass1 extends LazyIteratorChain<Map.Entry<K, V>> {
        final /* synthetic */ MultiValueMap this$0;
        final /* synthetic */ Iterator val$keyIterator;

        AnonymousClass1(MultiValueMap multiValueMap, Iterator it) {
            this.val$keyIterator = it;
            this.this$0 = multiValueMap;
        }

        @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
        protected Iterator<? extends Map.Entry<K, V>> nextIterator(int i) {
            if (!this.val$keyIterator.hasNext()) {
                return null;
            }
            Object next = this.val$keyIterator.next();
            return new TransformIterator(new ValuesIterator(next), new MultiValueMap$1$$ExternalSyntheticLambda0(this, next));
        }

        /* INFO: renamed from: org.apache.commons.collections4.map.MultiValueMap$1$1, reason: invalid class name and collision with other inner class name */
        class C00911 implements Map.Entry<K, V> {
            final /* synthetic */ AnonymousClass1 this$1;
            final /* synthetic */ Object val$input;
            final /* synthetic */ Object val$key;

            C00911(AnonymousClass1 anonymousClass1, Object obj, Object obj2) {
                this.val$key = obj;
                this.val$input = obj2;
                this.this$1 = anonymousClass1;
            }

            @Override // java.util.Map.Entry
            public K getKey() {
                return (K) this.val$key;
            }

            @Override // java.util.Map.Entry
            public V getValue() {
                return (V) this.val$input;
            }

            @Override // java.util.Map.Entry
            public V setValue(V v) {
                throw new UnsupportedOperationException();
            }
        }

        /* INFO: renamed from: lambda$nextIterator$0$org-apache-commons-collections4-map-MultiValueMap$1, reason: not valid java name */
        /* synthetic */ Map.Entry m5542xb3e34b93(Object obj, Object obj2) {
            return new C00911(this, obj, obj2);
        }
    }

    public Iterator<V> iterator(Object obj) {
        if (!containsKey(obj)) {
            return EmptyIterator.emptyIterator();
        }
        return new ValuesIterator(obj);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public Object put(K k, Object obj) {
        boolean zAdd;
        Collection<V> collection = getCollection(k);
        if (collection == null) {
            zAdd = true;
            Collection<V> collectionCreateCollection = createCollection(1);
            collectionCreateCollection.add(obj);
            if (collectionCreateCollection.isEmpty()) {
                zAdd = false;
            } else {
                decorated().put(k, collectionCreateCollection);
            }
        } else {
            zAdd = collection.add(obj);
        }
        if (zAdd) {
            return obj;
        }
        return null;
    }

    /* WARN: Multi-variable type inference failed */
    public boolean putAll(K k, Collection<V> collection) {
        if (collection == 0 || collection.isEmpty()) {
            return false;
        }
        Collection<V> collection2 = getCollection(k);
        if (collection2 == null) {
            Collection<V> collectionCreateCollection = createCollection(collection.size());
            collectionCreateCollection.addAll(collection);
            if (collectionCreateCollection.isEmpty()) {
                return false;
            }
            decorated().put(k, collectionCreateCollection);
            return true;
        }
        return collection2.addAll(collection);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ?> map) {
        if (map instanceof MultiMap) {
            for (Map.Entry<K, Object> entry : ((MultiMap) map).entrySet()) {
                putAll(entry.getKey(), (Collection) entry.getValue());
            }
            return;
        }
        for (Map.Entry<? extends K, ?> entry2 : map.entrySet()) {
            put(entry2.getKey(), entry2.getValue());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    @Override // org.apache.commons.collections4.MultiMap
    public boolean removeMapping(Object obj, Object obj2) {
        Collection<V> collection = getCollection(obj);
        if (collection == null || !collection.remove(obj2)) {
            return false;
        }
        if (!collection.isEmpty()) {
            return true;
        }
        remove(obj);
        return true;
    }

    public int size(Object obj) {
        Collection<V> collection = getCollection(obj);
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public int totalSize() {
        Iterator<V> it = decorated().values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += CollectionUtils.size(it.next());
        }
        return size;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Collection<Object> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Values values = new Values(this, null);
        this.valuesView = values;
        return values;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }
}

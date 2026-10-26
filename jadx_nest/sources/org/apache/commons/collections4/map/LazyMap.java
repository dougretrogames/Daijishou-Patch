package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.FactoryTransformer;

/* INFO: loaded from: classes5.dex */
public class LazyMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 7990956402564206740L;
    protected final Transformer<? super K, ? extends V> factory;

    public static <K, V> LazyMap<K, V> lazyMap(Map<K, V> map, Factory<? extends V> factory) {
        return new LazyMap<>(map, factory);
    }

    public static <V, K> LazyMap<K, V> lazyMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        return new LazyMap<>(map, transformer);
    }

    protected LazyMap(Map<K, V> map, Factory<? extends V> factory) {
        super(map);
        this.factory = FactoryTransformer.factoryTransformer((Factory) Objects.requireNonNull(factory, "factory"));
    }

    protected LazyMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        super(map);
        this.factory = (Transformer) Objects.requireNonNull(transformer, "factory");
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        if (!this.map.containsKey(obj)) {
            V vApply = this.factory.apply(obj);
            this.map.put(obj, vApply);
            return vApply;
        }
        return this.map.get(obj);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }
}

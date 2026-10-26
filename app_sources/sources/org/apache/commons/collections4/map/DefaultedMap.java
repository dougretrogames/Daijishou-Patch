package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.apache.commons.collections4.functors.FactoryTransformer;

/* INFO: loaded from: classes5.dex */
public class DefaultedMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 19698628745827L;
    private final Transformer<? super K, ? extends V> value;

    public static <K, V> DefaultedMap<K, V> defaultedMap(Map<K, V> map, Factory<? extends V> factory) {
        return new DefaultedMap<>(map, FactoryTransformer.factoryTransformer((Factory) Objects.requireNonNull(factory, "Factory must not be null")));
    }

    public static <K, V> Map<K, V> defaultedMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        return new DefaultedMap(map, (Transformer) Objects.requireNonNull(transformer, "Transformer must not be null"));
    }

    public static <K, V> DefaultedMap<K, V> defaultedMap(Map<K, V> map, V v) {
        return new DefaultedMap<>(map, ConstantTransformer.constantTransformer(v));
    }

    protected DefaultedMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        super(map);
        this.value = (Transformer) Objects.requireNonNull(transformer, "defaultValueTransformer");
    }

    public DefaultedMap(Transformer<? super K, ? extends V> transformer) {
        this(new HashMap(), transformer);
    }

    public DefaultedMap(V v) {
        this(ConstantTransformer.constantTransformer(v));
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        V v = this.map.get(obj);
        return (v != null || this.map.containsKey(obj)) ? v : this.value.apply(obj);
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

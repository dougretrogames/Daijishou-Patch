package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes5.dex */
public class TransformedMap<K, V> extends AbstractInputCheckedMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 7023152376788900464L;
    protected final Transformer<? super K, ? extends K> keyTransformer;
    protected final Transformer<? super V, ? extends V> valueTransformer;

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator, org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public static <K, V> TransformedMap<K, V> transformedMap(Map<K, V> map, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        TransformedMap<K, V> transformedMap = new TransformedMap<>(map, transformer, transformer2);
        if (!map.isEmpty()) {
            Map<K, V> mapTransformMap = transformedMap.transformMap(map);
            transformedMap.clear();
            transformedMap.decorated().putAll(mapTransformMap);
        }
        return transformedMap;
    }

    public static <K, V> TransformedMap<K, V> transformingMap(Map<K, V> map, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return new TransformedMap<>(map, transformer, transformer2);
    }

    protected TransformedMap(Map<K, V> map, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        super(map);
        this.keyTransformer = transformer;
        this.valueTransformer = transformer2;
    }

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator
    protected V checkSetValue(V v) {
        return this.valueTransformer.apply(v);
    }

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator
    protected boolean isSetValueChecking() {
        return this.valueTransformer != null;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        return decorated().put(transformKey(k), transformValue(v));
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        decorated().putAll(transformMap(map));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    protected K transformKey(K k) {
        Transformer<? super K, ? extends K> transformer = this.keyTransformer;
        return transformer == null ? k : transformer.apply(k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected Map<K, V> transformMap(Map<? extends K, ? extends V> map) {
        if (map.isEmpty()) {
            return map;
        }
        LinkedMap linkedMap = new LinkedMap(map.size());
        for (Map.Entry entry : map.entrySet()) {
            linkedMap.put(transformKey(entry.getKey()), transformValue(entry.getValue()));
        }
        return linkedMap;
    }

    protected V transformValue(V v) {
        Transformer<? super V, ? extends V> transformer = this.valueTransformer;
        return transformer == null ? v : transformer.apply(v);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }
}

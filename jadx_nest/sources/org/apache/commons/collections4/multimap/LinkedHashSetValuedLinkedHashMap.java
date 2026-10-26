package org.apache.commons.collections4.multimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import org.apache.commons.collections4.MultiValuedMap;

/* INFO: loaded from: classes5.dex */
public class LinkedHashSetValuedLinkedHashMap<K, V> extends AbstractSetValuedMap<K, V> implements Serializable {
    private static final int DEFAULT_INITIAL_MAP_CAPACITY = 16;
    private static final int DEFAULT_INITIAL_SET_CAPACITY = 3;
    private static final long serialVersionUID = 20241020;
    private final int initialSetCapacity;

    public LinkedHashSetValuedLinkedHashMap() {
        this(16, 3);
    }

    public LinkedHashSetValuedLinkedHashMap(int i) {
        this(16, i);
    }

    public LinkedHashSetValuedLinkedHashMap(int i, int i2) {
        super(new LinkedHashMap(i));
        this.initialSetCapacity = i2;
    }

    public LinkedHashSetValuedLinkedHashMap(Map<? extends K, ? extends V> map) {
        this(map.size(), 3);
        super.putAll(map);
    }

    public LinkedHashSetValuedLinkedHashMap(MultiValuedMap<? extends K, ? extends V> multiValuedMap) {
        this(multiValuedMap.size(), 3);
        super.putAll(multiValuedMap);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.multimap.AbstractSetValuedMap, org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public LinkedHashSet<V> createCollection() {
        return new LinkedHashSet<>(this.initialSetCapacity);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        setMap(new LinkedHashMap());
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }
}

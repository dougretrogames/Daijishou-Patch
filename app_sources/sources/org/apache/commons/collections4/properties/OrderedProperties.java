package org.apache.commons.collections4.properties;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* INFO: loaded from: classes5.dex */
public class OrderedProperties extends Properties {
    private static final long serialVersionUID = 1;
    private final LinkedHashSet<Object> orderedKeys = new LinkedHashSet<>();

    public static /* synthetic */ LinkedHashSet $r8$lambda$8t7les3oNGAWx5tdDX7k2wROC5E() {
        return new LinkedHashSet();
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized void clear() {
        this.orderedKeys.clear();
        super.clear();
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized Object compute(Object obj, BiFunction<? super Object, ? super Object, ? extends Object> biFunction) {
        Object objCompute;
        objCompute = super.compute(obj, biFunction);
        if (objCompute != null) {
            this.orderedKeys.add(obj);
        }
        return objCompute;
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized Object computeIfAbsent(Object obj, Function<? super Object, ? extends Object> function) {
        Object objComputeIfAbsent;
        objComputeIfAbsent = super.computeIfAbsent(obj, function);
        if (objComputeIfAbsent != null) {
            this.orderedKeys.add(obj);
        }
        return objComputeIfAbsent;
    }

    @Override // java.util.Hashtable, java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        return (Set) this.orderedKeys.stream().map(new OrderedProperties$$ExternalSyntheticLambda0(this)).collect(Collectors.toCollection(new OrderedProperties$$ExternalSyntheticLambda1()));
    }

    /* INFO: renamed from: lambda$entrySet$0$org-apache-commons-collections4-properties-OrderedProperties, reason: not valid java name */
    /* synthetic */ AbstractMap.SimpleEntry m5545x72a44a24(Object obj) {
        return new AbstractMap.SimpleEntry(obj, get(obj));
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized void forEach(BiConsumer<? super Object, ? super Object> biConsumer) {
        Objects.requireNonNull(biConsumer);
        this.orderedKeys.forEach(new OrderedProperties$$ExternalSyntheticLambda2(this, biConsumer));
    }

    /* INFO: renamed from: lambda$forEach$1$org-apache-commons-collections4-properties-OrderedProperties, reason: not valid java name */
    /* synthetic */ void m5546x46362603(BiConsumer biConsumer, Object obj) {
        biConsumer.accept(obj, get(obj));
    }

    @Override // java.util.Hashtable, java.util.Dictionary
    public synchronized Enumeration<Object> keys() {
        return Collections.enumeration(this.orderedKeys);
    }

    @Override // java.util.Hashtable, java.util.Map
    public Set<Object> keySet() {
        return this.orderedKeys;
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized Object merge(Object obj, Object obj2, BiFunction<? super Object, ? super Object, ? extends Object> biFunction) {
        this.orderedKeys.add(obj);
        return super.merge(obj, obj2, biFunction);
    }

    @Override // java.util.Properties
    public Enumeration<?> propertyNames() {
        return Collections.enumeration(this.orderedKeys);
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Object put(Object obj, Object obj2) {
        Object objPut;
        objPut = super.put(obj, obj2);
        if (objPut == null) {
            this.orderedKeys.add(obj);
        }
        return objPut;
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized void putAll(Map<? extends Object, ? extends Object> map) {
        this.orderedKeys.addAll(map.keySet());
        super.putAll(map);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized Object putIfAbsent(Object obj, Object obj2) {
        Object objPutIfAbsent;
        objPutIfAbsent = super.putIfAbsent(obj, obj2);
        if (objPutIfAbsent == null) {
            this.orderedKeys.add(obj);
        }
        return objPutIfAbsent;
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Object remove(Object obj) {
        Object objRemove;
        objRemove = super.remove(obj);
        if (objRemove != null) {
            this.orderedKeys.remove(obj);
        }
        return objRemove;
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized boolean remove(Object obj, Object obj2) {
        boolean zRemove;
        zRemove = super.remove(obj, obj2);
        if (zRemove) {
            this.orderedKeys.remove(obj);
        }
        return zRemove;
    }

    @Override // java.util.Hashtable
    public synchronized String toString() {
        int size = size() - 1;
        if (size == -1) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<Object, Object>> it = entrySet().iterator();
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        int i = 0;
        while (true) {
            Map.Entry<Object, Object> next = it.next();
            Object key = next.getKey();
            Object value = next.getValue();
            sb.append(key == this ? "(this Map)" : key.toString());
            sb.append('=');
            sb.append(value == this ? "(this Map)" : value.toString());
            if (i == size) {
                return sb.append(AbstractJsonLexerKt.END_OBJ).toString();
            }
            sb.append(", ");
            i++;
        }
    }
}

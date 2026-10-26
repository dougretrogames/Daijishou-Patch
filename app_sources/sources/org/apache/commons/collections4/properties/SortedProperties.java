package org.apache.commons.collections4.properties;

import java.util.AbstractMap;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.collections4.iterators.IteratorEnumeration;

/* INFO: loaded from: classes5.dex */
public class SortedProperties extends Properties {
    private static final long serialVersionUID = 1;

    public static /* synthetic */ LinkedHashSet $r8$lambda$8t7les3oNGAWx5tdDX7k2wROC5E() {
        return new LinkedHashSet();
    }

    @Override // java.util.Hashtable, java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        return (Set) sortedKeys().map(new SortedProperties$$ExternalSyntheticLambda1(this)).collect(Collectors.toCollection(new SortedProperties$$ExternalSyntheticLambda2()));
    }

    /* INFO: renamed from: lambda$entrySet$0$org-apache-commons-collections4-properties-SortedProperties, reason: not valid java name */
    /* synthetic */ AbstractMap.SimpleEntry m5548x9fec02ac(String str) {
        return new AbstractMap.SimpleEntry(str, getProperty(str));
    }

    @Override // java.util.Hashtable, java.util.Dictionary
    public synchronized Enumeration<Object> keys() {
        return new IteratorEnumeration(((List) sortedKeys().collect(Collectors.toList())).iterator());
    }

    private Stream<String> sortedKeys() {
        return keySet().stream().map(new SortedProperties$$ExternalSyntheticLambda0()).sorted();
    }
}

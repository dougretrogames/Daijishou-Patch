package org.eclipse.jgit.util;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class LRUMap<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 4329609127403759486L;
    private final int limit;

    public LRUMap(int i, int i2) {
        super(i, 0.75f, true);
        this.limit = i2;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.limit;
    }
}

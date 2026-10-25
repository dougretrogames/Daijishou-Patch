package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
class MapIteratorCache<K, V> {
    private final Map<K, V> backingMap;

    @CheckForNull
    private volatile transient Map.Entry<K, V> cacheEntry;

    MapIteratorCache(Map<K, V> backingMap) {
        this.backingMap = (Map) Preconditions.checkNotNull(backingMap);
    }

    @CheckForNull
    final V put(K key, V value) {
        Preconditions.checkNotNull(key);
        Preconditions.checkNotNull(value);
        clearCache();
        return this.backingMap.put(key, value);
    }

    @CheckForNull
    final V remove(Object key) {
        Preconditions.checkNotNull(key);
        clearCache();
        return this.backingMap.remove(key);
    }

    final void clear() {
        clearCache();
        this.backingMap.clear();
    }

    @CheckForNull
    V get(Object key) {
        Preconditions.checkNotNull(key);
        V ifCached = getIfCached(key);
        return ifCached == null ? getWithoutCaching(key) : ifCached;
    }

    @CheckForNull
    final V getWithoutCaching(Object key) {
        Preconditions.checkNotNull(key);
        return this.backingMap.get(key);
    }

    final boolean containsKey(@CheckForNull Object key) {
        return getIfCached(key) != null || this.backingMap.containsKey(key);
    }

    /* JADX INFO: renamed from: com.google.common.graph.MapIteratorCache$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<K> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<K> iterator() {
            return new C00501(MapIteratorCache.this.backingMap.entrySet().iterator());
        }

        /* JADX INFO: renamed from: com.google.common.graph.MapIteratorCache$1$1, reason: invalid class name and collision with other inner class name */
        class C00501 extends UnmodifiableIterator<K> {
            final /* synthetic */ Iterator val$entryIterator;

            C00501(final Iterator val$entryIterator) {
                this.val$entryIterator = val$entryIterator;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.val$entryIterator.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry entry = (Map.Entry) this.val$entryIterator.next();
                MapIteratorCache.this.cacheEntry = entry;
                return (K) entry.getKey();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapIteratorCache.this.backingMap.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object key) {
            return MapIteratorCache.this.containsKey(key);
        }
    }

    final Set<K> unmodifiableKeySet() {
        return new AnonymousClass1();
    }

    @CheckForNull
    V getIfCached(@CheckForNull Object key) {
        Map.Entry<K, V> entry = this.cacheEntry;
        if (entry == null || entry.getKey() != key) {
            return null;
        }
        return entry.getValue();
    }

    void clearCache() {
        this.cacheEntry = null;
    }
}

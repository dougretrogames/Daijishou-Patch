package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* INFO: loaded from: classes4.dex */
@ElementTypesAreNonnullByDefault
public final class MutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
    private final Map<TypeToken<? extends B>, B> backingMap = Maps.newHashMap();

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CheckForNull
    public <T extends B> T getInstance(Class<T> cls) {
        return (T) trustedGet(TypeToken.of((Class) cls));
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CheckForNull
    public <T extends B> T getInstance(TypeToken<T> typeToken) {
        return (T) trustedGet(typeToken.rejectTypeVariables());
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CheckForNull
    public <T extends B> T putInstance(Class<T> cls, @ParametricNullness T t) {
        return (T) trustedPut(TypeToken.of((Class) cls), t);
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CheckForNull
    public <T extends B> T putInstance(TypeToken<T> typeToken, @ParametricNullness T t) {
        return (T) trustedPut(typeToken.rejectTypeVariables(), t);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CheckForNull
    @Deprecated
    public B put(TypeToken<? extends B> key, @ParametricNullness B value) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @Deprecated
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<TypeToken<? extends B>, B>> entrySet() {
        return UnmodifiableEntry.transformEntries(super.entrySet());
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<TypeToken<? extends B>, B> delegate() {
        return this.backingMap;
    }

    @CheckForNull
    private <T extends B> T trustedPut(TypeToken<T> typeToken, @ParametricNullness T t) {
        return this.backingMap.put(typeToken, t);
    }

    @CheckForNull
    private <T extends B> T trustedGet(TypeToken<T> typeToken) {
        return this.backingMap.get(typeToken);
    }

    /* INFO: Access modifiers changed from: private */
    static final class UnmodifiableEntry<K, V> extends ForwardingMapEntry<K, V> {
        private final Map.Entry<K, V> delegate;

        /* INFO: renamed from: $r8$lambda$PXRRP_NYxQ7IKAyO13H8YX2p-q0, reason: not valid java name */
        public static /* synthetic */ UnmodifiableEntry m3363$r8$lambda$PXRRP_NYxQ7IKAyO13H8YX2pq0(Map.Entry entry) {
            return new UnmodifiableEntry(entry);
        }

        /* INFO: renamed from: com.google.common.reflect.MutableTypeToInstanceMap$UnmodifiableEntry$1, reason: invalid class name */
        class AnonymousClass1 extends ForwardingSet<Map.Entry<K, V>> {
            final /* synthetic */ Set val$entries;

            AnonymousClass1(final Set val$entries) {
                this.val$entries = val$entries;
            }

            /* INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            public Set<Map.Entry<K, V>> delegate() {
                return this.val$entries;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return UnmodifiableEntry.transformEntries(super.iterator());
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                return standardToArray();
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                return (T[]) standardToArray(tArr);
            }
        }

        static <K, V> Set<Map.Entry<K, V>> transformEntries(Set<Map.Entry<K, V>> entries) {
            return new AnonymousClass1(entries);
        }

        /* INFO: Access modifiers changed from: private */
        public static <K, V> Iterator<Map.Entry<K, V>> transformEntries(Iterator<Map.Entry<K, V>> entries) {
            return Iterators.transform(entries, new MutableTypeToInstanceMap$UnmodifiableEntry$$ExternalSyntheticLambda0());
        }

        private UnmodifiableEntry(Map.Entry<K, V> delegate) {
            this.delegate = (Map.Entry) Preconditions.checkNotNull(delegate);
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        public Map.Entry<K, V> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V setValue(@ParametricNullness V value) {
            throw new UnsupportedOperationException();
        }
    }
}

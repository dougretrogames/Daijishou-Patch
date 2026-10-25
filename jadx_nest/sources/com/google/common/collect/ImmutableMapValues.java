package com.google.common.collect;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
    private final ImmutableMap<K, V> map;

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return true;
    }

    ImmutableMapValues(ImmutableMap<K, V> map) {
        this.map = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.map.size();
    }

    /* JADX INFO: renamed from: com.google.common.collect.ImmutableMapValues$1, reason: invalid class name */
    class AnonymousClass1 extends UnmodifiableIterator<V> {
        final UnmodifiableIterator<Map.Entry<K, V>> entryItr;

        AnonymousClass1() {
            this.entryItr = ImmutableMapValues.this.map.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.entryItr.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.entryItr.next().getValue();
        }
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<V> iterator() {
        return new AnonymousClass1();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object object) {
        return object != null && Iterators.contains(iterator(), object);
    }

    /* JADX INFO: renamed from: com.google.common.collect.ImmutableMapValues$2, reason: invalid class name */
    class AnonymousClass2 extends ImmutableList<V> {
        final /* synthetic */ ImmutableList val$entryList;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        AnonymousClass2(final ImmutableMapValues this$0, final ImmutableList val$entryList) {
            this.val$entryList = val$entryList;
        }

        @Override // java.util.List
        public V get(int i) {
            return (V) ((Map.Entry) this.val$entryList.get(i)).getValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.val$entryList.size();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<V> asList() {
        return new AnonymousClass2(this, this.map.entrySet().asList());
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this.map);
    }

    private static class SerializedForm<V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<?, V> map;

        SerializedForm(ImmutableMap<?, V> map) {
            this.map = map;
        }

        Object readResolve() {
            return this.map.values();
        }
    }
}

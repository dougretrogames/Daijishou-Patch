package net.jodah.expiringmap;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import net.jodah.expiringmap.internal.Assert;
import net.jodah.expiringmap.internal.NamedThreadFactory;

/* INFO: loaded from: classes5.dex */
public class ExpiringMap<K, V> implements ConcurrentMap<K, V> {
    static volatile ScheduledExecutorService EXPIRER;
    static volatile ThreadPoolExecutor LISTENER_SERVICE;
    static ThreadFactory THREAD_FACTORY;
    List<ExpirationListener<K, V>> asyncExpirationListeners;
    private final EntryMap<K, V> entries;
    private final EntryLoader<? super K, ? extends V> entryLoader;
    List<ExpirationListener<K, V>> expirationListeners;
    private AtomicLong expirationNanos;
    private final AtomicReference<ExpirationPolicy> expirationPolicy;
    private final ExpiringEntryLoader<? super K, ? extends V> expiringEntryLoader;
    private int maxSize;
    private final Lock readLock;
    private final ReadWriteLock readWriteLock;
    private final boolean variableExpiration;
    private final Lock writeLock;

    private interface EntryMap<K, V> extends Map<K, ExpiringEntry<K, V>> {
        ExpiringEntry<K, V> first();

        void reorder(ExpiringEntry<K, V> expiringEntry);

        Iterator<ExpiringEntry<K, V>> valuesIterator();
    }

    /* synthetic */ ExpiringMap(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static void setThreadFactory(ThreadFactory threadFactory) {
        THREAD_FACTORY = (ThreadFactory) Assert.notNull(threadFactory, "threadFactory");
    }

    private ExpiringMap(Builder<K, V> builder) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readWriteLock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        if (EXPIRER == null) {
            synchronized (ExpiringMap.class) {
                if (EXPIRER == null) {
                    ThreadFactory threadFactory = THREAD_FACTORY;
                    EXPIRER = Executors.newSingleThreadScheduledExecutor(threadFactory == null ? new NamedThreadFactory("ExpiringMap-Expirer") : threadFactory);
                }
            }
        }
        if (LISTENER_SERVICE == null && ((Builder) builder).asyncExpirationListeners != null) {
            initListenerService();
        }
        boolean z = ((Builder) builder).variableExpiration;
        this.variableExpiration = z;
        this.entries = z ? new EntryTreeHashMap<>(null) : new EntryLinkedHashMap<>(null);
        if (((Builder) builder).expirationListeners != null) {
            this.expirationListeners = new CopyOnWriteArrayList(((Builder) builder).expirationListeners);
        }
        if (((Builder) builder).asyncExpirationListeners != null) {
            this.asyncExpirationListeners = new CopyOnWriteArrayList(((Builder) builder).asyncExpirationListeners);
        }
        this.expirationPolicy = new AtomicReference<>(((Builder) builder).expirationPolicy);
        this.expirationNanos = new AtomicLong(TimeUnit.NANOSECONDS.convert(((Builder) builder).duration, ((Builder) builder).timeUnit));
        this.maxSize = ((Builder) builder).maxSize;
        this.entryLoader = ((Builder) builder).entryLoader;
        this.expiringEntryLoader = ((Builder) builder).expiringEntryLoader;
    }

    public static final class Builder<K, V> {
        private List<ExpirationListener<K, V>> asyncExpirationListeners;
        private long duration;
        private EntryLoader<K, V> entryLoader;
        private List<ExpirationListener<K, V>> expirationListeners;
        private ExpirationPolicy expirationPolicy;
        private ExpiringEntryLoader<K, V> expiringEntryLoader;
        private int maxSize;
        private TimeUnit timeUnit;
        private boolean variableExpiration;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            this.expirationPolicy = ExpirationPolicy.CREATED;
            this.timeUnit = TimeUnit.SECONDS;
            this.duration = 60L;
            this.maxSize = Integer.MAX_VALUE;
        }

        public <K1 extends K, V1 extends V> ExpiringMap<K1, V1> build() {
            return new ExpiringMap<>(this, null);
        }

        public Builder<K, V> expiration(long j, TimeUnit timeUnit) {
            this.duration = j;
            this.timeUnit = (TimeUnit) Assert.notNull(timeUnit, "timeUnit");
            return this;
        }

        public Builder<K, V> maxSize(int i) {
            Assert.operation(i > 0, "maxSize");
            this.maxSize = i;
            return this;
        }

        /* WARN: Multi-variable type inference failed */
        public <K1 extends K, V1 extends V> Builder<K1, V1> entryLoader(EntryLoader<? super K1, ? super V1> entryLoader) {
            assertNoLoaderSet();
            this.entryLoader = (EntryLoader) Assert.notNull(entryLoader, "loader");
            return this;
        }

        /* WARN: Multi-variable type inference failed */
        public <K1 extends K, V1 extends V> Builder<K1, V1> expiringEntryLoader(ExpiringEntryLoader<? super K1, ? super V1> expiringEntryLoader) {
            assertNoLoaderSet();
            this.expiringEntryLoader = (ExpiringEntryLoader) Assert.notNull(expiringEntryLoader, "loader");
            variableExpiration();
            return this;
        }

        /* WARN: Multi-variable type inference failed */
        public <K1 extends K, V1 extends V> Builder<K1, V1> expirationListener(ExpirationListener<? super K1, ? super V1> expirationListener) {
            Assert.notNull(expirationListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            if (this.expirationListeners == null) {
                this.expirationListeners = new ArrayList();
            }
            this.expirationListeners.add(expirationListener);
            return this;
        }

        /* WARN: Multi-variable type inference failed */
        public <K1 extends K, V1 extends V> Builder<K1, V1> expirationListeners(List<ExpirationListener<? super K1, ? super V1>> list) {
            Assert.notNull(list, "listeners");
            if (this.expirationListeners == null) {
                this.expirationListeners = new ArrayList(list.size());
            }
            Iterator<ExpirationListener<? super K1, ? super V1>> it = list.iterator();
            while (it.hasNext()) {
                this.expirationListeners.add(it.next());
            }
            return this;
        }

        /* WARN: Multi-variable type inference failed */
        public <K1 extends K, V1 extends V> Builder<K1, V1> asyncExpirationListener(ExpirationListener<? super K1, ? super V1> expirationListener) {
            Assert.notNull(expirationListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            if (this.asyncExpirationListeners == null) {
                this.asyncExpirationListeners = new ArrayList();
            }
            this.asyncExpirationListeners.add(expirationListener);
            return this;
        }

        /* WARN: Multi-variable type inference failed */
        public <K1 extends K, V1 extends V> Builder<K1, V1> asyncExpirationListeners(List<ExpirationListener<? super K1, ? super V1>> list) {
            Assert.notNull(list, "listeners");
            if (this.asyncExpirationListeners == null) {
                this.asyncExpirationListeners = new ArrayList(list.size());
            }
            Iterator<ExpirationListener<? super K1, ? super V1>> it = list.iterator();
            while (it.hasNext()) {
                this.asyncExpirationListeners.add(it.next());
            }
            return this;
        }

        public Builder<K, V> expirationPolicy(ExpirationPolicy expirationPolicy) {
            this.expirationPolicy = (ExpirationPolicy) Assert.notNull(expirationPolicy, "expirationPolicy");
            return this;
        }

        public Builder<K, V> variableExpiration() {
            this.variableExpiration = true;
            return this;
        }

        private void assertNoLoaderSet() {
            Assert.state(this.entryLoader == null && this.expiringEntryLoader == null, "Either entryLoader or expiringEntryLoader may be set, not both", new Object[0]);
        }
    }

    private static class EntryLinkedHashMap<K, V> extends LinkedHashMap<K, ExpiringEntry<K, V>> implements EntryMap<K, V> {
        private static final long serialVersionUID = 1;

        private EntryLinkedHashMap() {
        }

        /* synthetic */ EntryLinkedHashMap(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            Iterator<V> it = values().iterator();
            while (it.hasNext()) {
                V v = ((ExpiringEntry) it.next()).value;
                if (v == obj) {
                    return true;
                }
                if (obj != null && obj.equals(v)) {
                    return true;
                }
            }
            return false;
        }

        @Override // net.jodah.expiringmap.ExpiringMap.EntryMap
        public ExpiringEntry<K, V> first() {
            if (isEmpty()) {
                return null;
            }
            return (ExpiringEntry) values().iterator().next();
        }

        @Override // net.jodah.expiringmap.ExpiringMap.EntryMap
        public void reorder(ExpiringEntry<K, V> expiringEntry) {
            remove(expiringEntry.key);
            expiringEntry.resetExpiration();
            put(expiringEntry.key, expiringEntry);
        }

        @Override // net.jodah.expiringmap.ExpiringMap.EntryMap
        public Iterator<ExpiringEntry<K, V>> valuesIterator() {
            return values().iterator();
        }

        abstract class AbstractHashIterator {
            private final Iterator<Map.Entry<K, ExpiringEntry<K, V>>> iterator;
            private ExpiringEntry<K, V> next;

            AbstractHashIterator() {
                this.iterator = Arrays.asList(EntryLinkedHashMap.this.entrySet().toArray(new Map.Entry[0])).iterator();
            }

            public boolean hasNext() {
                return this.iterator.hasNext();
            }

            public ExpiringEntry<K, V> getNext() {
                ExpiringEntry<K, V> value = this.iterator.next().getValue();
                this.next = value;
                return value;
            }

            public void remove() {
                this.iterator.remove();
            }
        }

        final class KeyIterator extends EntryLinkedHashMap<K, V>.AbstractHashIterator implements Iterator<K> {
            KeyIterator() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return getNext().key;
            }
        }

        final class ValueIterator extends EntryLinkedHashMap<K, V>.AbstractHashIterator implements Iterator<V> {
            ValueIterator() {
                super();
            }

            @Override // java.util.Iterator
            public V next() {
                return getNext().value;
            }
        }

        public final class EntryIterator extends EntryLinkedHashMap<K, V>.AbstractHashIterator implements Iterator<Map.Entry<K, V>> {
            public EntryIterator() {
                super();
            }

            @Override // net.jodah.expiringmap.ExpiringMap.EntryLinkedHashMap.AbstractHashIterator
            public /* bridge */ /* synthetic */ ExpiringEntry getNext() {
                return super.getNext();
            }

            @Override // net.jodah.expiringmap.ExpiringMap.EntryLinkedHashMap.AbstractHashIterator, java.util.Iterator
            public /* bridge */ /* synthetic */ boolean hasNext() {
                return super.hasNext();
            }

            @Override // net.jodah.expiringmap.ExpiringMap.EntryLinkedHashMap.AbstractHashIterator, java.util.Iterator
            public /* bridge */ /* synthetic */ void remove() {
                super.remove();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return ExpiringMap.mapEntryFor(getNext());
            }
        }
    }

    private static class EntryTreeHashMap<K, V> extends HashMap<K, ExpiringEntry<K, V>> implements EntryMap<K, V> {
        private static final long serialVersionUID = 1;
        SortedSet<ExpiringEntry<K, V>> sortedSet;

        private EntryTreeHashMap() {
            this.sortedSet = new ConcurrentSkipListSet();
        }

        /* synthetic */ EntryTreeHashMap(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            super.clear();
            this.sortedSet.clear();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            Iterator<V> it = values().iterator();
            while (it.hasNext()) {
                V v = ((ExpiringEntry) it.next()).value;
                if (v == obj) {
                    return true;
                }
                if (obj != null && obj.equals(v)) {
                    return true;
                }
            }
            return false;
        }

        @Override // net.jodah.expiringmap.ExpiringMap.EntryMap
        public ExpiringEntry<K, V> first() {
            if (this.sortedSet.isEmpty()) {
                return null;
            }
            return this.sortedSet.first();
        }

        /* WARN: Multi-variable type inference failed */
        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public ExpiringEntry<K, V> put(K k, ExpiringEntry<K, V> expiringEntry) {
            this.sortedSet.add(expiringEntry);
            return (ExpiringEntry) super.put(k, expiringEntry);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public ExpiringEntry<K, V> remove(Object obj) {
            ExpiringEntry<K, V> expiringEntry = (ExpiringEntry) super.remove(obj);
            if (expiringEntry != null) {
                this.sortedSet.remove(expiringEntry);
            }
            return expiringEntry;
        }

        @Override // net.jodah.expiringmap.ExpiringMap.EntryMap
        public void reorder(ExpiringEntry<K, V> expiringEntry) {
            this.sortedSet.remove(expiringEntry);
            expiringEntry.resetExpiration();
            this.sortedSet.add(expiringEntry);
        }

        @Override // net.jodah.expiringmap.ExpiringMap.EntryMap
        public Iterator<ExpiringEntry<K, V>> valuesIterator() {
            return new ExpiringEntryIterator();
        }

        abstract class AbstractHashIterator {
            private final Iterator<ExpiringEntry<K, V>> iterator;
            protected ExpiringEntry<K, V> next;

            AbstractHashIterator() {
                this.iterator = EntryTreeHashMap.this.sortedSet.iterator();
            }

            public boolean hasNext() {
                return this.iterator.hasNext();
            }

            public ExpiringEntry<K, V> getNext() {
                ExpiringEntry<K, V> next = this.iterator.next();
                this.next = next;
                return next;
            }

            public void remove() {
                EntryTreeHashMap.super.remove((Object) this.next.key);
                this.iterator.remove();
            }
        }

        final class ExpiringEntryIterator extends EntryTreeHashMap<K, V>.AbstractHashIterator implements Iterator<ExpiringEntry<K, V>> {
            ExpiringEntryIterator() {
                super();
            }

            @Override // java.util.Iterator
            public final ExpiringEntry<K, V> next() {
                return getNext();
            }
        }

        final class KeyIterator extends EntryTreeHashMap<K, V>.AbstractHashIterator implements Iterator<K> {
            KeyIterator() {
                super();
            }

            @Override // java.util.Iterator
            public final K next() {
                return getNext().key;
            }
        }

        final class ValueIterator extends EntryTreeHashMap<K, V>.AbstractHashIterator implements Iterator<V> {
            ValueIterator() {
                super();
            }

            @Override // java.util.Iterator
            public final V next() {
                return getNext().value;
            }
        }

        final class EntryIterator extends EntryTreeHashMap<K, V>.AbstractHashIterator implements Iterator<Map.Entry<K, V>> {
            EntryIterator() {
                super();
            }

            @Override // java.util.Iterator
            public final Map.Entry<K, V> next() {
                return ExpiringMap.mapEntryFor(getNext());
            }
        }
    }

    static class ExpiringEntry<K, V> implements Comparable<ExpiringEntry<K, V>> {
        volatile Future<?> entryFuture;
        final AtomicLong expectedExpiration = new AtomicLong();
        final AtomicLong expirationNanos;
        final AtomicReference<ExpirationPolicy> expirationPolicy;
        final K key;
        volatile boolean scheduled;
        V value;

        ExpiringEntry(K k, V v, AtomicReference<ExpirationPolicy> atomicReference, AtomicLong atomicLong) {
            this.key = k;
            this.value = v;
            this.expirationPolicy = atomicReference;
            this.expirationNanos = atomicLong;
            resetExpiration();
        }

        @Override // java.lang.Comparable
        public int compareTo(ExpiringEntry<K, V> expiringEntry) {
            if (this.key.equals(expiringEntry.key)) {
                return 0;
            }
            return this.expectedExpiration.get() < expiringEntry.expectedExpiration.get() ? -1 : 1;
        }

        public int hashCode() {
            K k = this.key;
            int iHashCode = ((k == null ? 0 : k.hashCode()) + 31) * 31;
            V v = this.value;
            return iHashCode + (v != null ? v.hashCode() : 0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ExpiringEntry expiringEntry = (ExpiringEntry) obj;
            if (!this.key.equals(expiringEntry.key)) {
                return false;
            }
            V v = this.value;
            if (v == null) {
                if (expiringEntry.value != null) {
                    return false;
                }
            } else if (!v.equals(expiringEntry.value)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return this.value.toString();
        }

        synchronized boolean cancel() {
            boolean z;
            z = this.scheduled;
            if (this.entryFuture != null) {
                this.entryFuture.cancel(false);
            }
            this.entryFuture = null;
            this.scheduled = false;
            return z;
        }

        synchronized V getValue() {
            return this.value;
        }

        void resetExpiration() {
            this.expectedExpiration.set(this.expirationNanos.get() + System.nanoTime());
        }

        synchronized void schedule(Future<?> future) {
            this.entryFuture = future;
            this.scheduled = true;
        }

        synchronized void setValue(V v) {
            this.value = v;
        }
    }

    public static Builder<Object, Object> builder() {
        return new Builder<>(null);
    }

    public static <K, V> ExpiringMap<K, V> create() {
        return new ExpiringMap<>(builder());
    }

    public synchronized void addExpirationListener(ExpirationListener<K, V> expirationListener) {
        Assert.notNull(expirationListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.expirationListeners == null) {
            this.expirationListeners = new CopyOnWriteArrayList();
        }
        this.expirationListeners.add(expirationListener);
    }

    public synchronized void addAsyncExpirationListener(ExpirationListener<K, V> expirationListener) {
        Assert.notNull(expirationListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.asyncExpirationListeners == null) {
            this.asyncExpirationListeners = new CopyOnWriteArrayList();
        }
        this.asyncExpirationListeners.add(expirationListener);
        if (LISTENER_SERVICE == null) {
            initListenerService();
        }
    }

    @Override // java.util.Map
    public void clear() {
        this.writeLock.lock();
        try {
            Iterator<V> it = this.entries.values().iterator();
            while (it.hasNext()) {
                ((ExpiringEntry) it.next()).cancel();
            }
            this.entries.clear();
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        this.readLock.lock();
        try {
            return this.entries.containsKey(obj);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        this.readLock.lock();
        try {
            return this.entries.containsValue(obj);
        } finally {
            this.readLock.unlock();
        }
    }

    /* INFO: renamed from: net.jodah.expiringmap.ExpiringMap$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<K, V>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ExpiringMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                return ExpiringMap.this.containsKey(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            if (ExpiringMap.this.entries instanceof EntryLinkedHashMap) {
                EntryLinkedHashMap entryLinkedHashMap = (EntryLinkedHashMap) ExpiringMap.this.entries;
                entryLinkedHashMap.getClass();
                return new EntryLinkedHashMap.EntryIterator();
            }
            EntryTreeHashMap entryTreeHashMap = (EntryTreeHashMap) ExpiringMap.this.entries;
            entryTreeHashMap.getClass();
            return new EntryTreeHashMap.EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return (obj instanceof Map.Entry) && ExpiringMap.this.remove(((Map.Entry) obj).getKey()) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ExpiringMap.this.size();
        }
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        this.readLock.lock();
        try {
            return this.entries.equals(obj);
        } finally {
            this.readLock.unlock();
        }
    }

    /* WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object obj) {
        ExpiringEntry<K, V> entry = getEntry(obj);
        if (entry == null) {
            return load(obj);
        }
        if (ExpirationPolicy.ACCESSED.equals(entry.expirationPolicy.get())) {
            resetEntry(entry, false);
        }
        return entry.getValue();
    }

    private V load(K k) throws Throwable {
        ExpiringMap expiringMap;
        Throwable th;
        ExpiringMap expiringMap2;
        V value;
        Lock lock;
        if (this.entryLoader == null && this.expiringEntryLoader == null) {
            return null;
        }
        this.writeLock.lock();
        try {
            ExpiringEntry<K, V> entry = getEntry(k);
            try {
                if (entry == null) {
                    EntryLoader<? super K, ? extends V> entryLoader = this.entryLoader;
                    if (entryLoader != null) {
                        V vLoad = entryLoader.load(k);
                        put(k, vLoad);
                        this.writeLock.unlock();
                        return vLoad;
                    }
                    ExpiringValue<? extends V> expiringValueLoad = this.expiringEntryLoader.load(k);
                    if (expiringValueLoad == null) {
                        put(k, null);
                        this.writeLock.unlock();
                        return null;
                    }
                    expiringMap = this;
                    try {
                        expiringMap.put(k, expiringValueLoad.getValue(), expiringValueLoad.getExpirationPolicy() == null ? this.expirationPolicy.get() : expiringValueLoad.getExpirationPolicy(), expiringValueLoad.getTimeUnit() == null ? this.expirationNanos.get() : expiringValueLoad.getDuration(), expiringValueLoad.getTimeUnit() == null ? TimeUnit.NANOSECONDS : expiringValueLoad.getTimeUnit());
                        value = expiringValueLoad.getValue();
                        lock = expiringMap.writeLock;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    th = th;
                    expiringMap2 = expiringMap;
                    expiringMap2.writeLock.unlock();
                    throw th;
                }
                value = entry.getValue();
                lock = this.writeLock;
                lock.unlock();
                return value;
            } catch (Throwable th3) {
                th = th3;
                expiringMap2 = this;
            }
        } catch (Throwable th4) {
            th = th4;
            expiringMap = this;
        }
    }

    public long getExpiration() {
        return TimeUnit.NANOSECONDS.toMillis(this.expirationNanos.get());
    }

    public long getExpiration(K k) {
        Assert.notNull(k, "key");
        ExpiringEntry<K, V> entry = getEntry(k);
        Assert.element(entry, k);
        return TimeUnit.NANOSECONDS.toMillis(entry.expirationNanos.get());
    }

    public ExpirationPolicy getExpirationPolicy(K k) {
        Assert.notNull(k, "key");
        ExpiringEntry<K, V> entry = getEntry(k);
        Assert.element(entry, k);
        return entry.expirationPolicy.get();
    }

    public long getExpectedExpiration(K k) {
        Assert.notNull(k, "key");
        ExpiringEntry<K, V> entry = getEntry(k);
        Assert.element(entry, k);
        return TimeUnit.NANOSECONDS.toMillis(entry.expectedExpiration.get() - System.nanoTime());
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    @Override // java.util.Map
    public int hashCode() {
        this.readLock.lock();
        try {
            return this.entries.hashCode();
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        this.readLock.lock();
        try {
            return this.entries.isEmpty();
        } finally {
            this.readLock.unlock();
        }
    }

    /* INFO: renamed from: net.jodah.expiringmap.ExpiringMap$2, reason: invalid class name */
    class AnonymousClass2 extends AbstractSet<K> {
        AnonymousClass2() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ExpiringMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ExpiringMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            Iterator<K> keyIterator;
            ExpiringMap.this.readLock.lock();
            try {
                if (ExpiringMap.this.entries instanceof EntryLinkedHashMap) {
                    EntryLinkedHashMap entryLinkedHashMap = (EntryLinkedHashMap) ExpiringMap.this.entries;
                    entryLinkedHashMap.getClass();
                    keyIterator = new EntryLinkedHashMap.KeyIterator();
                } else {
                    EntryTreeHashMap entryTreeHashMap = (EntryTreeHashMap) ExpiringMap.this.entries;
                    entryTreeHashMap.getClass();
                    keyIterator = new EntryTreeHashMap.KeyIterator();
                }
                return keyIterator;
            } finally {
                ExpiringMap.this.readLock.unlock();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return ExpiringMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ExpiringMap.this.size();
        }
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return new AnonymousClass2();
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        Assert.notNull(k, "key");
        return putInternal(k, v, this.expirationPolicy.get(), this.expirationNanos.get());
    }

    public V put(K k, V v, ExpirationPolicy expirationPolicy) {
        return put(k, v, expirationPolicy, this.expirationNanos.get(), TimeUnit.NANOSECONDS);
    }

    public V put(K k, V v, long j, TimeUnit timeUnit) {
        return put(k, v, this.expirationPolicy.get(), j, timeUnit);
    }

    public V put(K k, V v, ExpirationPolicy expirationPolicy, long j, TimeUnit timeUnit) {
        Assert.notNull(k, "key");
        Assert.notNull(expirationPolicy, "expirationPolicy");
        Assert.notNull(timeUnit, "timeUnit");
        Assert.operation(this.variableExpiration, "Variable expiration is not enabled");
        return putInternal(k, v, expirationPolicy, TimeUnit.NANOSECONDS.convert(j, timeUnit));
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) throws Throwable {
        ExpiringMap expiringMap;
        Assert.notNull(map, "map");
        long j = this.expirationNanos.get();
        ExpirationPolicy expirationPolicy = this.expirationPolicy.get();
        this.writeLock.lock();
        try {
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                expiringMap = this;
                try {
                    expiringMap.putInternal(entry.getKey(), entry.getValue(), expirationPolicy, j);
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    expiringMap.writeLock.unlock();
                    throw th2;
                }
            }
            this.writeLock.unlock();
        } catch (Throwable th3) {
            th = th3;
            expiringMap = this;
        }
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public V putIfAbsent(K k, V v) throws Throwable {
        ExpiringMap<K, V> expiringMap;
        V vPutInternal;
        Assert.notNull(k, "key");
        this.writeLock.lock();
        try {
            try {
                if (!this.entries.containsKey(k)) {
                    expiringMap = this;
                    vPutInternal = expiringMap.putInternal(k, v, this.expirationPolicy.get(), this.expirationNanos.get());
                } else {
                    expiringMap = this;
                    vPutInternal = (V) ((ExpiringEntry) expiringMap.entries.get(k)).getValue();
                }
                expiringMap.writeLock.unlock();
                return vPutInternal;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                expiringMap.writeLock.unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            expiringMap = this;
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        Assert.notNull(obj, "key");
        this.writeLock.lock();
        try {
            ExpiringEntry expiringEntry = (ExpiringEntry) this.entries.remove(obj);
            if (expiringEntry != null) {
                if (expiringEntry.cancel()) {
                    scheduleEntry(this.entries.first());
                }
                return (V) expiringEntry.getValue();
            }
            return null;
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public boolean remove(Object obj, Object obj2) {
        Assert.notNull(obj, "key");
        this.writeLock.lock();
        try {
            ExpiringEntry expiringEntry = (ExpiringEntry) this.entries.get(obj);
            if (expiringEntry == null || !expiringEntry.getValue().equals(obj2)) {
                return false;
            }
            this.entries.remove(obj);
            if (expiringEntry.cancel()) {
                scheduleEntry(this.entries.first());
            }
            return true;
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public V replace(K k, V v) throws Throwable {
        ExpiringMap<K, V> expiringMap;
        Assert.notNull(k, "key");
        this.writeLock.lock();
        try {
            if (!this.entries.containsKey(k)) {
                this.writeLock.unlock();
                return null;
            }
            expiringMap = this;
            try {
                V vPutInternal = expiringMap.putInternal(k, v, this.expirationPolicy.get(), this.expirationNanos.get());
                expiringMap.writeLock.unlock();
                return vPutInternal;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            expiringMap = this;
        }
        Throwable th3 = th;
        expiringMap.writeLock.unlock();
        throw th3;
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public boolean replace(K k, V v, V v2) throws Throwable {
        ExpiringMap<K, V> expiringMap;
        Assert.notNull(k, "key");
        this.writeLock.lock();
        try {
            ExpiringEntry expiringEntry = (ExpiringEntry) this.entries.get(k);
            if (expiringEntry == null || !expiringEntry.getValue().equals(v)) {
                this.writeLock.unlock();
                return false;
            }
            expiringMap = this;
            try {
                expiringMap.putInternal(k, v2, this.expirationPolicy.get(), this.expirationNanos.get());
                expiringMap.writeLock.unlock();
                return true;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            expiringMap = this;
        }
        Throwable th3 = th;
        expiringMap.writeLock.unlock();
        throw th3;
    }

    public void removeExpirationListener(ExpirationListener<K, V> expirationListener) {
        Assert.notNull(expirationListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        for (int i = 0; i < this.expirationListeners.size(); i++) {
            if (this.expirationListeners.get(i).equals(expirationListener)) {
                this.expirationListeners.remove(i);
                return;
            }
        }
    }

    public void removeAsyncExpirationListener(ExpirationListener<K, V> expirationListener) {
        Assert.notNull(expirationListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        for (int i = 0; i < this.asyncExpirationListeners.size(); i++) {
            if (this.asyncExpirationListeners.get(i).equals(expirationListener)) {
                this.asyncExpirationListeners.remove(i);
                return;
            }
        }
    }

    public void resetExpiration(K k) {
        Assert.notNull(k, "key");
        ExpiringEntry<K, V> entry = getEntry(k);
        if (entry != null) {
            resetEntry(entry, false);
        }
    }

    public void setExpiration(K k, long j, TimeUnit timeUnit) {
        Assert.notNull(k, "key");
        Assert.notNull(timeUnit, "timeUnit");
        Assert.operation(this.variableExpiration, "Variable expiration is not enabled");
        this.writeLock.lock();
        try {
            ExpiringEntry<K, V> expiringEntry = (ExpiringEntry) this.entries.get(k);
            if (expiringEntry != null) {
                expiringEntry.expirationNanos.set(TimeUnit.NANOSECONDS.convert(j, timeUnit));
                resetEntry(expiringEntry, true);
            }
        } finally {
            this.writeLock.unlock();
        }
    }

    public void setExpiration(long j, TimeUnit timeUnit) {
        Assert.notNull(timeUnit, "timeUnit");
        Assert.operation(this.variableExpiration, "Variable expiration is not enabled");
        this.expirationNanos.set(TimeUnit.NANOSECONDS.convert(j, timeUnit));
    }

    public void setExpirationPolicy(ExpirationPolicy expirationPolicy) {
        Assert.notNull(expirationPolicy, "expirationPolicy");
        this.expirationPolicy.set(expirationPolicy);
    }

    public void setExpirationPolicy(K k, ExpirationPolicy expirationPolicy) {
        Assert.notNull(k, "key");
        Assert.notNull(expirationPolicy, "expirationPolicy");
        Assert.operation(this.variableExpiration, "Variable expiration is not enabled");
        ExpiringEntry<K, V> entry = getEntry(k);
        if (entry != null) {
            entry.expirationPolicy.set(expirationPolicy);
        }
    }

    public void setMaxSize(int i) {
        Assert.operation(i > 0, "maxSize");
        this.maxSize = i;
    }

    @Override // java.util.Map
    public int size() {
        this.readLock.lock();
        try {
            return this.entries.size();
        } finally {
            this.readLock.unlock();
        }
    }

    public String toString() {
        this.readLock.lock();
        try {
            return this.entries.toString();
        } finally {
            this.readLock.unlock();
        }
    }

    /* INFO: renamed from: net.jodah.expiringmap.ExpiringMap$3, reason: invalid class name */
    class AnonymousClass3 extends AbstractCollection<V> {
        AnonymousClass3() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ExpiringMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ExpiringMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            Iterator<V> valueIterator;
            ExpiringMap.this.readLock.lock();
            try {
                if (ExpiringMap.this.entries instanceof EntryLinkedHashMap) {
                    EntryLinkedHashMap entryLinkedHashMap = (EntryLinkedHashMap) ExpiringMap.this.entries;
                    entryLinkedHashMap.getClass();
                    valueIterator = new EntryLinkedHashMap.ValueIterator();
                } else {
                    EntryTreeHashMap entryTreeHashMap = (EntryTreeHashMap) ExpiringMap.this.entries;
                    entryTreeHashMap.getClass();
                    valueIterator = new EntryTreeHashMap.ValueIterator();
                }
                return valueIterator;
            } finally {
                ExpiringMap.this.readLock.unlock();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return ExpiringMap.this.size();
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return new AnonymousClass3();
    }

    void notifyListeners(ExpiringEntry<K, V> expiringEntry) {
        List<ExpirationListener<K, V>> list = this.asyncExpirationListeners;
        if (list != null) {
            Iterator<ExpirationListener<K, V>> it = list.iterator();
            while (it.hasNext()) {
                LISTENER_SERVICE.execute(new AnonymousClass4(it.next(), expiringEntry));
            }
        }
        List<ExpirationListener<K, V>> list2 = this.expirationListeners;
        if (list2 != null) {
            Iterator<ExpirationListener<K, V>> it2 = list2.iterator();
            while (it2.hasNext()) {
                try {
                    it2.next().expired(expiringEntry.key, expiringEntry.getValue());
                } catch (Exception unused) {
                }
            }
        }
    }

    /* INFO: renamed from: net.jodah.expiringmap.ExpiringMap$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ ExpiringEntry val$entry;
        final /* synthetic */ ExpirationListener val$listener;

        AnonymousClass4(ExpirationListener expirationListener, ExpiringEntry expiringEntry) {
            this.val$listener = expirationListener;
            this.val$entry = expiringEntry;
        }

        /* WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            try {
                this.val$listener.expired(this.val$entry.key, this.val$entry.getValue());
            } catch (Exception unused) {
            }
        }
    }

    ExpiringEntry<K, V> getEntry(Object obj) {
        this.readLock.lock();
        try {
            return (ExpiringEntry) this.entries.get(obj);
        } finally {
            this.readLock.unlock();
        }
    }

    V putInternal(K k, V v, ExpirationPolicy expirationPolicy, long j) {
        V value;
        this.writeLock.lock();
        try {
            ExpiringEntry<K, V> expiringEntry = (ExpiringEntry) this.entries.get(k);
            if (expiringEntry == null) {
                ExpiringEntry<K, V> expiringEntry2 = new ExpiringEntry<>(k, v, this.variableExpiration ? new AtomicReference<>(expirationPolicy) : this.expirationPolicy, this.variableExpiration ? new AtomicLong(j) : this.expirationNanos);
                if (this.entries.size() >= this.maxSize) {
                    ExpiringEntry<K, V> expiringEntryFirst = this.entries.first();
                    this.entries.remove(expiringEntryFirst.key);
                    notifyListeners(expiringEntryFirst);
                }
                this.entries.put(k, expiringEntry2);
                if (this.entries.size() == 1 || this.entries.first().equals(expiringEntry2)) {
                    scheduleEntry(expiringEntry2);
                }
                value = null;
            } else {
                value = expiringEntry.getValue();
                if (!ExpirationPolicy.ACCESSED.equals(expirationPolicy) && ((value == null && v == null) || (value != null && value.equals(v)))) {
                    return v;
                }
                expiringEntry.setValue(v);
                resetEntry(expiringEntry, false);
            }
            return value;
        } finally {
            this.writeLock.unlock();
        }
    }

    void resetEntry(ExpiringEntry<K, V> expiringEntry, boolean z) {
        this.writeLock.lock();
        try {
            boolean zCancel = expiringEntry.cancel();
            this.entries.reorder(expiringEntry);
            if (zCancel || z) {
                scheduleEntry(this.entries.first());
            }
        } finally {
            this.writeLock.unlock();
        }
    }

    void scheduleEntry(ExpiringEntry<K, V> expiringEntry) {
        if (expiringEntry == null || expiringEntry.scheduled) {
            return;
        }
        synchronized (expiringEntry) {
            if (expiringEntry.scheduled) {
                return;
            }
            expiringEntry.schedule(EXPIRER.schedule(new AnonymousClass5(new WeakReference(expiringEntry)), expiringEntry.expectedExpiration.get() - System.nanoTime(), TimeUnit.NANOSECONDS));
        }
    }

    /* INFO: renamed from: net.jodah.expiringmap.ExpiringMap$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ WeakReference val$entryReference;

        AnonymousClass5(WeakReference weakReference) {
            this.val$entryReference = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            ExpiringEntry<K, V> expiringEntry = (ExpiringEntry) this.val$entryReference.get();
            ExpiringMap.this.writeLock.lock();
            if (expiringEntry != null) {
                try {
                    if (expiringEntry.scheduled) {
                        ExpiringMap.this.entries.remove(expiringEntry.key);
                        ExpiringMap.this.notifyListeners(expiringEntry);
                    }
                } finally {
                    ExpiringMap.this.writeLock.unlock();
                }
            }
            try {
                Iterator<ExpiringEntry<K, V>> itValuesIterator = ExpiringMap.this.entries.valuesIterator();
                boolean z = true;
                while (itValuesIterator.hasNext() && z) {
                    ExpiringEntry<K, V> next = itValuesIterator.next();
                    if (next.expectedExpiration.get() <= System.nanoTime()) {
                        itValuesIterator.remove();
                        ExpiringMap.this.notifyListeners(next);
                    } else {
                        ExpiringMap.this.scheduleEntry(next);
                        z = false;
                    }
                }
            } catch (NoSuchElementException unused) {
            }
        }
    }

    /* INFO: renamed from: net.jodah.expiringmap.ExpiringMap$6, reason: invalid class name */
    class AnonymousClass6 implements Map.Entry<K, V> {
        final /* synthetic */ ExpiringEntry val$entry;

        AnonymousClass6(ExpiringEntry expiringEntry) {
            this.val$entry = expiringEntry;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.val$entry.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.val$entry.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException();
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static <K, V> Map.Entry<K, V> mapEntryFor(ExpiringEntry<K, V> expiringEntry) {
        return new AnonymousClass6(expiringEntry);
    }

    private void initListenerService() {
        synchronized (ExpiringMap.class) {
            if (LISTENER_SERVICE == null) {
                ThreadFactory namedThreadFactory = THREAD_FACTORY;
                if (namedThreadFactory == null) {
                    namedThreadFactory = new NamedThreadFactory("ExpiringMap-Listener-%s");
                }
                LISTENER_SERVICE = (ThreadPoolExecutor) Executors.newCachedThreadPool(namedThreadFactory);
            }
        }
    }
}

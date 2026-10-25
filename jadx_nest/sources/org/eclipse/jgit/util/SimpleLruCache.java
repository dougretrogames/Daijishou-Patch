package org.eclipse.jgit.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class SimpleLruCache<K, V> {
    private volatile int maximumSize;
    private int purgeSize;
    private Lock lock = new ReentrantLock();
    private Map<K, Entry<K, V>> map = new ConcurrentHashMap();
    private volatile long time = 0;

    private static int purgeSize(int i, float f) {
        return (int) ((1.0f - f) * i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class Entry<K, V> {
        private final K key;
        private volatile long lastAccessed;
        private long lastAccessedSorting;
        private final V value;

        Entry(K k, V v, long j) {
            this.key = k;
            this.value = v;
            this.lastAccessed = j;
        }

        void copyAccessTime() {
            this.lastAccessedSorting = this.lastAccessed;
        }

        public String toString() {
            return "Entry [lastAccessed=" + this.lastAccessed + ", key=" + String.valueOf(this.key) + ", value=" + String.valueOf(this.value) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
        }
    }

    private static void checkPurgeFactor(float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidPurgeFactor, Float.valueOf(f)));
        }
    }

    public SimpleLruCache(int i, float f) {
        checkPurgeFactor(f);
        this.maximumSize = i;
        this.purgeSize = purgeSize(i, f);
    }

    public V get(Object obj) {
        Entry<K, V> entry = this.map.get(obj);
        if (entry == null) {
            return null;
        }
        ((Entry) entry).lastAccessed = tick();
        return (V) ((Entry) entry).value;
    }

    public V put(K k, V v) {
        this.map.put(k, new Entry<>(k, v, tick()));
        if (this.map.size() > this.maximumSize) {
            purge();
        }
        return v;
    }

    private long tick() {
        long j = this.time + 1;
        this.time = j;
        return j;
    }

    public int size() {
        return this.map.size();
    }

    public void configure(int i, float f) {
        this.lock.lock();
        try {
            checkPurgeFactor(f);
            this.maximumSize = i;
            this.purgeSize = purgeSize(i, f);
            if (this.map.size() >= this.maximumSize) {
                purge();
            }
        } finally {
            this.lock.unlock();
        }
    }

    private void purge() {
        if (this.lock.tryLock()) {
            try {
                ArrayList arrayList = new ArrayList(this.map.values());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Entry) it.next()).copyAccessTime();
                }
                Collections.sort(arrayList, Comparator.comparingLong(new SimpleLruCache$$ExternalSyntheticLambda0()));
                for (int i = this.purgeSize; i < arrayList.size(); i++) {
                    this.map.remove(((Entry) arrayList.get(i)).key);
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    static /* synthetic */ long lambda$0(Entry entry) {
        return -entry.lastAccessedSorting;
    }
}

package org.eclipse.jgit.internal.storage.file;

import java.lang.ref.SoftReference;
import org.eclipse.jgit.storage.file.WindowCacheConfig;

/* INFO: loaded from: classes5.dex */
class DeltaBaseCache {
    private static final int CACHE_SZ = 1024;
    static final SoftReference<Entry> DEAD = new SoftReference<>(null);
    private static volatile int defaultMaxByteCount;
    private Slot lruHead;
    private Slot lruTail;
    private int openByteCount;
    private final int maxByteCount = defaultMaxByteCount;
    private final Slot[] cache = new Slot[1024];

    private static int hash(long j) {
        return (((int) j) << 22) >>> 22;
    }

    static {
        reconfigure(new WindowCacheConfig());
    }

    static void reconfigure(WindowCacheConfig windowCacheConfig) {
        defaultMaxByteCount = windowCacheConfig.getDeltaBaseCacheLimit();
    }

    DeltaBaseCache() {
    }

    Entry get(Pack pack, long j) {
        Entry entry;
        Slot slot = this.cache[hash(j)];
        if (slot == null || slot.provider != pack || slot.position != j || (entry = slot.data.get()) == null) {
            return null;
        }
        moveToHead(slot);
        return entry;
    }

    void store(Pack pack, long j, byte[] bArr, int i) {
        if (bArr.length > this.maxByteCount) {
            return;
        }
        Slot slot = this.cache[hash(j)];
        if (slot == null) {
            slot = new Slot(null);
            this.cache[hash(j)] = slot;
        } else {
            clearEntry(slot);
        }
        this.openByteCount += bArr.length;
        releaseMemory();
        slot.provider = pack;
        slot.position = j;
        slot.sz = bArr.length;
        slot.data = new SoftReference<>(new Entry(bArr, i));
        moveToHead(slot);
    }

    private void releaseMemory() {
        Slot slot;
        while (this.openByteCount > this.maxByteCount && (slot = this.lruTail) != null) {
            Slot slot2 = slot.lruPrev;
            clearEntry(slot);
            slot.lruPrev = null;
            slot.lruNext = null;
            if (slot2 == null) {
                this.lruHead = null;
            } else {
                slot2.lruNext = null;
            }
            this.lruTail = slot2;
        }
    }

    private void moveToHead(Slot slot) {
        unlink(slot);
        slot.lruPrev = null;
        slot.lruNext = this.lruHead;
        Slot slot2 = this.lruHead;
        if (slot2 != null) {
            slot2.lruPrev = slot;
        } else {
            this.lruTail = slot;
        }
        this.lruHead = slot;
    }

    private void unlink(Slot slot) {
        Slot slot2 = slot.lruPrev;
        Slot slot3 = slot.lruNext;
        if (slot2 != null) {
            slot2.lruNext = slot3;
        }
        if (slot3 != null) {
            slot3.lruPrev = slot2;
        }
    }

    private void clearEntry(Slot slot) {
        this.openByteCount -= slot.sz;
        slot.provider = null;
        slot.data = DEAD;
        slot.sz = 0;
    }

    static class Entry {
        final byte[] data;
        final int type;

        Entry(byte[] bArr, int i) {
            this.data = bArr;
            this.type = i;
        }
    }

    private static class Slot {
        SoftReference<Entry> data;
        Slot lruNext;
        Slot lruPrev;
        long position;
        Pack provider;
        int sz;

        /* synthetic */ Slot(DeltaBaseCacheIA deltaBaseCacheIA) {
            this();
        }

        private Slot() {
            this.data = DeltaBaseCache.DEAD;
        }
    }
}

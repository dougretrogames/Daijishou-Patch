package org.eclipse.jgit.internal.storage.dfs;

/* INFO: loaded from: classes5.dex */
final class DeltaBaseCache {
    private static final int MASK_BITS = 22;
    private static final int TABLE_BITS = 10;
    private int curByteCount;
    private Entry lruHead;
    private Entry lruTail;
    private int maxByteCount;
    private final Entry[] table;

    private static int hash(long j) {
        return (((int) j) << 22) >>> 22;
    }

    DeltaBaseCache(DfsReader dfsReader) {
        this(dfsReader.getOptions().getDeltaBaseCacheLimit());
    }

    DeltaBaseCache(int i) {
        this.maxByteCount = i;
        this.table = new Entry[1024];
    }

    Entry get(DfsStreamKey dfsStreamKey, long j) {
        for (Entry entry = this.table[hash(j)]; entry != null; entry = entry.tableNext) {
            if (entry.offset == j && dfsStreamKey.equals(entry.pack)) {
                moveToHead(entry);
                return entry;
            }
        }
        return null;
    }

    void put(DfsStreamKey dfsStreamKey, long j, int i, byte[] bArr) {
        if (bArr.length > this.maxByteCount) {
            return;
        }
        this.curByteCount += bArr.length;
        releaseMemory();
        int iHash = hash(j);
        Entry entry = new Entry(dfsStreamKey, j, i, bArr);
        entry.tableNext = this.table[iHash];
        this.table[iHash] = entry;
        lruPushHead(entry);
    }

    private void releaseMemory() {
        Entry entry;
        while (true) {
            int i = this.curByteCount;
            if (i <= this.maxByteCount || (entry = this.lruTail) == null) {
                return;
            }
            this.curByteCount = i - entry.data.length;
            lruRemove(entry);
            removeFromTable(entry);
        }
    }

    private void removeFromTable(Entry entry) {
        int iHash = hash(entry.offset);
        Entry[] entryArr = this.table;
        Entry entry2 = entryArr[iHash];
        if (entry2 == entry) {
            entryArr[iHash] = entry.tableNext;
            return;
        }
        while (entry2 != null) {
            if (entry2.tableNext != entry) {
                entry2 = entry2.tableNext;
            } else {
                entry2.tableNext = entry.tableNext;
                return;
            }
        }
        throw new IllegalStateException(String.format("entry for %s:%d not in table", entry.pack, Long.valueOf(entry.offset)));
    }

    private void moveToHead(Entry entry) {
        if (entry != this.lruHead) {
            lruRemove(entry);
            lruPushHead(entry);
        }
    }

    private void lruRemove(Entry entry) {
        Entry entry2 = entry.lruPrev;
        Entry entry3 = entry.lruNext;
        if (entry2 != null) {
            entry2.lruNext = entry3;
        } else {
            this.lruHead = entry3;
        }
        if (entry3 != null) {
            entry3.lruPrev = entry2;
        } else {
            this.lruTail = entry2;
        }
    }

    private void lruPushHead(Entry entry) {
        Entry entry2 = this.lruHead;
        entry.lruNext = entry2;
        if (entry2 != null) {
            entry2.lruPrev = entry;
        } else {
            this.lruTail = entry;
        }
        entry.lruPrev = null;
        this.lruHead = entry;
    }

    int getMemoryUsed() {
        return this.curByteCount;
    }

    int getMemoryUsedByLruChainForTest() {
        int length = 0;
        for (Entry entry = this.lruHead; entry != null; entry = entry.lruNext) {
            length += entry.data.length;
        }
        return length;
    }

    int getMemoryUsedByTableForTest() {
        int length = 0;
        for (Entry entry : this.table) {
            for (; entry != null; entry = entry.tableNext) {
                length += entry.data.length;
            }
        }
        return length;
    }

    static class Entry {
        final byte[] data;
        Entry lruNext;
        Entry lruPrev;
        final long offset;
        final DfsStreamKey pack;
        Entry tableNext;
        final int type;

        Entry(DfsStreamKey dfsStreamKey, long j, int i, byte[] bArr) {
            this.pack = dfsStreamKey;
            this.offset = j;
            this.type = i;
            this.data = bArr;
        }
    }
}

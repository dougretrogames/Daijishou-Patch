package org.eclipse.jgit.internal.storage.dfs;

import com.google.common.util.concurrent.Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.stream.LongStream;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.lib.CommitConfig$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
final class ClockBlockCacheTable implements DfsBlockCacheTable {
    private final int blockSize;
    private DfsBlockCache.Ref clockHand;
    private final ReentrantLock clockLock;
    private final DfsBlockCacheStats dfsBlockCacheStats;
    private final Hash hash;
    private final DfsBlockCacheConfig.IndexEventConsumer indexEventConsumer;
    private final Map<EvictKey, Long> indexEvictionMap = new ConcurrentHashMap();
    private final ReentrantLock[] loadLocks;
    private final long maxBytes;
    private final String name;
    private final Consumer<Long> refLockWaitTime;
    private final ReentrantLock[][] refLocks;
    private final AtomicReferenceArray<HashEntry> table;
    private final int tableSize;

    ClockBlockCacheTable(DfsBlockCacheConfig dfsBlockCacheConfig) {
        int iTableSize = tableSize(dfsBlockCacheConfig);
        this.tableSize = iTableSize;
        if (iTableSize < 1) {
            throw new IllegalArgumentException(JGitText.get().tSizeMustBeGreaterOrEqual1);
        }
        int concurrencyLevel = dfsBlockCacheConfig.getConcurrencyLevel();
        this.maxBytes = dfsBlockCacheConfig.getBlockLimit();
        int blockSize = dfsBlockCacheConfig.getBlockSize();
        this.blockSize = blockSize;
        this.hash = new Hash(Integer.numberOfTrailingZeros(blockSize));
        this.table = new AtomicReferenceArray<>(iTableSize);
        this.loadLocks = new ReentrantLock[concurrencyLevel];
        int i = 0;
        while (true) {
            ReentrantLock[] reentrantLockArr = this.loadLocks;
            if (i >= reentrantLockArr.length) {
                break;
            }
            reentrantLockArr[i] = new ReentrantLock(true);
            i++;
        }
        this.refLocks = (ReentrantLock[][]) Array.newInstance((Class<?>) ReentrantLock.class, PackExt.valuesCustom().length, concurrencyLevel);
        for (int i2 = 0; i2 < PackExt.valuesCustom().length; i2++) {
            for (int i3 = 0; i3 < concurrencyLevel; i3++) {
                this.refLocks[i2][i3] = new ReentrantLock(true);
            }
        }
        this.clockLock = new ReentrantLock(true);
        DfsBlockCache.Ref ref = new DfsBlockCache.Ref(DfsStreamKey.of(new DfsRepositoryDescription(""), "", null), -1L, 0L, null);
        this.clockHand = ref;
        ref.next = ref;
        String name = dfsBlockCacheConfig.getName();
        this.name = name;
        this.dfsBlockCacheStats = new DfsBlockCacheStats(name);
        this.refLockWaitTime = dfsBlockCacheConfig.getRefLockWaitTimeConsumer();
        this.indexEventConsumer = dfsBlockCacheConfig.getIndexEventConsumer();
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public List<DfsBlockCacheTable.BlockCacheStats> getBlockCacheStats() {
        return CommitConfig$$ExternalSyntheticBackport0.m(new Object[]{this.dfsBlockCacheStats});
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public String getName() {
        return this.name;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public boolean hasBlock0(DfsStreamKey dfsStreamKey) {
        DfsBlock dfsBlock = (DfsBlock) scan(this.table.get(slot(dfsStreamKey, 0L)), dfsStreamKey, 0L);
        return dfsBlock != null && dfsBlock.contains(dfsStreamKey, 0L);
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public DfsBlock getOrLoad(BlockBasedFile blockBasedFile, long j, DfsReader dfsReader, DfsBlockCache.ReadableChannelSupplier readableChannelSupplier) throws IOException {
        DfsBlock dfsBlock;
        long jAlignToBlock = blockBasedFile.alignToBlock(j);
        DfsStreamKey dfsStreamKey = blockBasedFile.key;
        int iSlot = slot(dfsStreamKey, jAlignToBlock);
        HashEntry hashEntry = this.table.get(iSlot);
        DfsBlock dfsBlock2 = (DfsBlock) scan(hashEntry, dfsStreamKey, jAlignToBlock);
        if (dfsBlock2 != null && dfsBlock2.contains(dfsStreamKey, j)) {
            dfsReader.stats.blockCacheHit++;
            this.dfsBlockCacheStats.incrementHit(dfsStreamKey);
            return dfsBlock2;
        }
        reserveSpace(this.blockSize, dfsStreamKey);
        ReentrantLock reentrantLockLockFor = lockFor(dfsStreamKey, jAlignToBlock);
        reentrantLockLockFor.lock();
        try {
            HashEntry hashEntry2 = this.table.get(iSlot);
            if (hashEntry2 != hashEntry && (dfsBlock = (DfsBlock) scan(hashEntry2, dfsStreamKey, jAlignToBlock)) != null) {
                dfsReader.stats.blockCacheHit++;
                this.dfsBlockCacheStats.incrementHit(dfsStreamKey);
                creditSpace(this.blockSize, dfsStreamKey);
                reentrantLockLockFor.unlock();
                return dfsBlock;
            }
            this.dfsBlockCacheStats.incrementMiss(dfsStreamKey);
            try {
                DfsBlock oneBlock = blockBasedFile.readOneBlock(jAlignToBlock, dfsReader, readableChannelSupplier.get());
                if (jAlignToBlock != oneBlock.start) {
                    jAlignToBlock = oneBlock.start;
                    iSlot = slot(dfsStreamKey, jAlignToBlock);
                    hashEntry2 = this.table.get(iSlot);
                }
                long j2 = jAlignToBlock;
                HashEntry hashEntry3 = hashEntry2;
                int i = iSlot;
                DfsBlockCache.Ref ref = new DfsBlockCache.Ref(dfsStreamKey, j2, oneBlock.size(), oneBlock);
                ref.markHotter();
                while (!Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this.table, i, hashEntry3, new HashEntry(HashEntry.clean(hashEntry3), ref))) {
                    hashEntry3 = this.table.get(i);
                }
                addToClock(ref, this.blockSize - oneBlock.size());
                reentrantLockLockFor.unlock();
                return oneBlock.contains(blockBasedFile.key, j) ? oneBlock : getOrLoad(blockBasedFile, j, dfsReader, readableChannelSupplier);
            } catch (Throwable th) {
                creditSpace(this.blockSize, dfsStreamKey);
                throw th;
            }
        } catch (Throwable th2) {
            reentrantLockLockFor.unlock();
            throw th2;
        }
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public <T> DfsBlockCache.Ref<T> getOrLoadRef(DfsStreamKey dfsStreamKey, long j, DfsBlockCache.RefLoader<T> refLoader) throws IOException {
        DfsBlockCache.Ref<T> refScanRef;
        long jNanoTime = System.nanoTime();
        int iSlot = slot(dfsStreamKey, j);
        HashEntry hashEntry = this.table.get(iSlot);
        DfsBlockCache.Ref<T> refScanRef2 = scanRef(hashEntry, dfsStreamKey, j);
        if (refScanRef2 != null) {
            this.dfsBlockCacheStats.incrementHit(dfsStreamKey);
            reportIndexRequested(refScanRef2, true, jNanoTime);
            return refScanRef2;
        }
        ReentrantLock reentrantLockLockForRef = lockForRef(dfsStreamKey);
        long jCurrentTimeMillis = System.currentTimeMillis();
        reentrantLockLockForRef.lock();
        try {
            HashEntry hashEntry2 = this.table.get(iSlot);
            if (hashEntry2 != hashEntry && (refScanRef = scanRef(hashEntry2, dfsStreamKey, j)) != null) {
                this.dfsBlockCacheStats.incrementHit(dfsStreamKey);
                reportIndexRequested(refScanRef, true, jNanoTime);
                reentrantLockLockForRef.unlock();
                return refScanRef;
            }
            Consumer<Long> consumer = this.refLockWaitTime;
            if (consumer != null) {
                consumer.accept(Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            }
            this.dfsBlockCacheStats.incrementMiss(dfsStreamKey);
            DfsBlockCache.Ref<T> refLoad = refLoader.load();
            refLoad.markHotter();
            reserveSpace(refLoad.size, dfsStreamKey);
            while (!Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this.table, iSlot, hashEntry2, new HashEntry(HashEntry.clean(hashEntry2), refLoad))) {
                hashEntry2 = this.table.get(iSlot);
            }
            addToClock(refLoad, 0L);
            reentrantLockLockForRef.unlock();
            reportIndexRequested(refLoad, false, jNanoTime);
            return refLoad;
        } catch (Throwable th) {
            reentrantLockLockForRef.unlock();
            throw th;
        }
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public void put(DfsBlock dfsBlock) {
        put(dfsBlock.stream, dfsBlock.start, dfsBlock.size(), dfsBlock);
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public <T> DfsBlockCache.Ref<T> put(DfsStreamKey dfsStreamKey, long j, long j2, T t) {
        DfsBlockCache.Ref<T> refScanRef;
        int iSlot = slot(dfsStreamKey, j);
        HashEntry hashEntry = this.table.get(iSlot);
        DfsBlockCache.Ref<T> refScanRef2 = scanRef(hashEntry, dfsStreamKey, j);
        if (refScanRef2 != null) {
            return refScanRef2;
        }
        reserveSpace(j2, dfsStreamKey);
        ReentrantLock reentrantLockLockFor = lockFor(dfsStreamKey, j);
        reentrantLockLockFor.lock();
        try {
            HashEntry hashEntry2 = this.table.get(iSlot);
            if (hashEntry2 != hashEntry && (refScanRef = scanRef(hashEntry2, dfsStreamKey, j)) != null) {
                creditSpace(j2, dfsStreamKey);
                return refScanRef;
            }
            DfsBlockCache.Ref<T> ref = new DfsBlockCache.Ref<>(dfsStreamKey, j, j2, t);
            ref.markHotter();
            while (!Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this.table, iSlot, hashEntry2, new HashEntry(HashEntry.clean(hashEntry2), ref))) {
                hashEntry2 = this.table.get(iSlot);
            }
            addToClock(ref, 0L);
            return ref;
        } finally {
            reentrantLockLockFor.unlock();
        }
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public <T> DfsBlockCache.Ref<T> putRef(DfsStreamKey dfsStreamKey, long j, T t) {
        return put(dfsStreamKey, 0L, j, t);
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public boolean contains(DfsStreamKey dfsStreamKey, long j) {
        return scan(this.table.get(slot(dfsStreamKey, j)), dfsStreamKey, j) != null;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public <T> T get(DfsStreamKey dfsStreamKey, long j) {
        T t = (T) scan(this.table.get(slot(dfsStreamKey, j)), dfsStreamKey, j);
        if (t == null) {
            this.dfsBlockCacheStats.incrementMiss(dfsStreamKey);
            return t;
        }
        this.dfsBlockCacheStats.incrementHit(dfsStreamKey);
        return t;
    }

    private int slot(DfsStreamKey dfsStreamKey, long j) {
        return (this.hash.hash(dfsStreamKey.hash, j) >>> 1) % this.tableSize;
    }

    private void reserveSpace(long j, DfsStreamKey dfsStreamKey) {
        this.clockLock.lock();
        try {
            long jSum = LongStream.of(this.dfsBlockCacheStats.getCurrentSize()).sum() + j;
            if (this.maxBytes < jSum) {
                DfsBlockCache.Ref<?> ref = this.clockHand;
                DfsBlockCache.Ref<?> ref2 = ref.next;
                do {
                    if (ref2.isHot()) {
                        ref2.markColder();
                        DfsBlockCache.Ref<?> ref3 = ref2;
                        ref2 = ref2.next;
                        ref = ref3;
                    } else {
                        if (ref == ref2) {
                            break;
                        }
                        DfsBlockCache.Ref<?> ref4 = ref2.next;
                        ref.next = ref4;
                        ref2.next = null;
                        ref2.value = null;
                        jSum -= ref2.size;
                        this.dfsBlockCacheStats.addToLiveBytes(ref2.key, -ref2.size);
                        this.dfsBlockCacheStats.incrementEvict(ref2.key);
                        reportIndexEvicted(ref2);
                        ref2 = ref4;
                    }
                } while (this.maxBytes < jSum);
                this.clockHand = ref;
            }
            this.dfsBlockCacheStats.addToLiveBytes(dfsStreamKey, j);
        } finally {
            this.clockLock.unlock();
        }
    }

    private void creditSpace(long j, DfsStreamKey dfsStreamKey) {
        this.clockLock.lock();
        try {
            this.dfsBlockCacheStats.addToLiveBytes(dfsStreamKey, -j);
        } finally {
            this.clockLock.unlock();
        }
    }

    private void addToClock(DfsBlockCache.Ref ref, long j) {
        this.clockLock.lock();
        if (j != 0) {
            try {
                this.dfsBlockCacheStats.addToLiveBytes(ref.key, -j);
            } finally {
                this.clockLock.unlock();
            }
        }
        DfsBlockCache.Ref ref2 = this.clockHand;
        ref.next = ref2.next;
        ref2.next = ref;
        this.clockHand = ref;
    }

    private <T> T scan(HashEntry hashEntry, DfsStreamKey dfsStreamKey, long j) {
        DfsBlockCache.Ref<T> refScanRef = scanRef(hashEntry, dfsStreamKey, j);
        if (refScanRef != null) {
            return refScanRef.get();
        }
        return null;
    }

    private <T> DfsBlockCache.Ref<T> scanRef(HashEntry hashEntry, DfsStreamKey dfsStreamKey, long j) {
        while (hashEntry != null) {
            DfsBlockCache.Ref<T> ref = hashEntry.ref;
            if (ref.position != j || !ref.key.equals(dfsStreamKey)) {
                hashEntry = hashEntry.next;
            } else {
                if (ref.get() != null) {
                    return ref;
                }
                return null;
            }
        }
        return null;
    }

    private ReentrantLock lockFor(DfsStreamKey dfsStreamKey, long j) {
        return this.loadLocks[(this.hash.hash(dfsStreamKey.hash, j) >>> 1) % this.loadLocks.length];
    }

    private ReentrantLock lockForRef(DfsStreamKey dfsStreamKey) {
        return this.refLocks[dfsStreamKey.packExtPos][(dfsStreamKey.hash >>> 1) % this.refLocks[dfsStreamKey.packExtPos].length];
    }

    private void reportIndexRequested(DfsBlockCache.Ref<?> ref, boolean z, long j) {
        if (this.indexEventConsumer == null || !isIndexExtPos(ref.key.packExtPos)) {
            return;
        }
        Long l = this.indexEvictionMap.get(createEvictKey(ref));
        long jNanoTime = System.nanoTime();
        this.indexEventConsumer.acceptRequestedEvent(ref.key.packExtPos, z, (jNanoTime - j) / 1000, ref.size, Duration.ofNanos(l == null ? 0L : jNanoTime - l.longValue()));
    }

    private void reportIndexEvicted(DfsBlockCache.Ref<?> ref) {
        DfsBlockCacheConfig.IndexEventConsumer indexEventConsumer = this.indexEventConsumer;
        if (indexEventConsumer != null && indexEventConsumer.shouldReportEvictedEvent() && isIndexExtPos(ref.key.packExtPos)) {
            EvictKey evictKeyCreateEvictKey = createEvictKey(ref);
            Long l = this.indexEvictionMap.get(evictKeyCreateEvictKey);
            long jNanoTime = System.nanoTime();
            long jLongValue = l == null ? 0L : jNanoTime - l.longValue();
            this.indexEvictionMap.put(evictKeyCreateEvictKey, Long.valueOf(jNanoTime));
            this.indexEventConsumer.acceptEvictedEvent(ref.key.packExtPos, ref.size, ref.getTotalHitCount(), Duration.ofNanos(jLongValue));
        }
    }

    private static final class HashEntry {
        final HashEntry next;
        final DfsBlockCache.Ref ref;

        HashEntry(HashEntry hashEntry, DfsBlockCache.Ref ref) {
            this.next = hashEntry;
            this.ref = ref;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static HashEntry clean(HashEntry hashEntry) {
            while (hashEntry != null && hashEntry.ref.next == null) {
                hashEntry = hashEntry.next;
            }
            if (hashEntry == null) {
                return null;
            }
            HashEntry hashEntryClean = clean(hashEntry.next);
            return hashEntryClean == hashEntry.next ? hashEntry : new HashEntry(hashEntryClean, hashEntry.ref);
        }
    }

    private EvictKey createEvictKey(DfsBlockCache.Ref<?> ref) {
        return new EvictKey(this.hash, ref);
    }

    private static boolean isIndexExtPos(int i) {
        return i == PackExt.INDEX.getPosition() || i == PackExt.REVERSE_INDEX.getPosition() || i == PackExt.BITMAP_INDEX.getPosition();
    }

    private static int tableSize(DfsBlockCacheConfig dfsBlockCacheConfig) {
        int blockSize = dfsBlockCacheConfig.getBlockSize();
        long blockLimit = dfsBlockCacheConfig.getBlockLimit();
        if (blockSize <= 0) {
            throw new IllegalArgumentException(JGitText.get().invalidWindowSize);
        }
        long j = blockSize;
        if (blockLimit < j) {
            throw new IllegalArgumentException(JGitText.get().windowSizeMustBeLesserThanLimit);
        }
        return (int) Math.min(((blockLimit / j) * 5) / 2, 2147483647L);
    }

    private static final class Hash {
        private final int blockSizeShift;

        Hash(int i) {
            this.blockSizeShift = i;
        }

        int hash(int i, long j) {
            return i + ((int) (j >>> this.blockSizeShift));
        }
    }

    private static final class EvictKey {
        private final Hash hash;
        private final int keyHash;
        private final int packExtPos;
        private final long position;

        EvictKey(Hash hash, DfsBlockCache.Ref<?> ref) {
            this.hash = hash;
            this.keyHash = ref.key.hash;
            this.packExtPos = ref.key.packExtPos;
            this.position = ref.position;
        }

        public boolean equals(Object obj) {
            if (obj instanceof EvictKey) {
                EvictKey evictKey = (EvictKey) obj;
                if (this.keyHash == evictKey.keyHash && this.packExtPos == evictKey.packExtPos && this.position == evictKey.position) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.hash.hash(this.keyHash, this.position);
        }
    }
}

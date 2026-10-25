package org.eclipse.jgit.internal.storage.file;

import com.google.common.util.concurrent.Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.storage.file.WindowCacheConfig;
import org.eclipse.jgit.storage.file.WindowCacheStats;
import org.eclipse.jgit.util.Monitoring;

/* JADX INFO: loaded from: classes5.dex */
public class WindowCache {
    private static volatile WindowCache cache;
    private static final Random rng = new Random();
    private static volatile int streamFileThreshold;
    private final AtomicLong clock;
    private final int evictBatch;
    private final ReentrantLock evictLock;
    private final Lock[] locks;
    private final long maxBytes;
    private final int maxFiles;
    private final StatsRecorderImpl mbean;
    private final boolean mmap;
    private final AtomicBoolean publishMBean = new AtomicBoolean();
    private final CleanupQueue queue;
    private final StatsRecorder statsRecorder;
    private final AtomicReferenceArray<Entry> table;
    private final int tableSize;
    private final boolean useStrongIndexRefs;
    private final boolean useStrongRefs;
    private final int windowSize;
    private final int windowSizeShift;

    private interface CleanupQueue {
        boolean enqueue(PageRef<ByteWindow> pageRef);

        void gc();
    }

    private interface PageRef<T> {
        T get();

        long getLastAccess();

        Pack getPack();

        long getPosition();

        int getSize();

        boolean isStrongRef();

        boolean kill();

        void setLastAccess(long j);
    }

    interface StatsRecorder {
        WindowCacheStats getStats();

        void recordEvictions(int i);

        void recordHits(int i);

        void recordLoadFailure(long j);

        void recordLoadSuccess(long j);

        void recordMisses(int i);

        void recordOpenBytes(Pack pack, int i);

        void recordOpenFiles(int i);
    }

    static class StatsRecorderImpl implements StatsRecorder, WindowCacheStats {
        private final LongAdder hitCount = new LongAdder();
        private final LongAdder missCount = new LongAdder();
        private final LongAdder loadSuccessCount = new LongAdder();
        private final LongAdder loadFailureCount = new LongAdder();
        private final LongAdder totalLoadTime = new LongAdder();
        private final LongAdder evictionCount = new LongAdder();
        private final LongAdder openFileCount = new LongAdder();
        private final LongAdder openByteCount = new LongAdder();
        private final Map<String, LongAdder> openByteCountPerRepository = new ConcurrentHashMap();

        static /* synthetic */ Long lambda$4(Long l, Long l2) {
            return l2;
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.StatsRecorder
        public WindowCacheStats getStats() {
            return this;
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.StatsRecorder
        public void recordHits(int i) {
            this.hitCount.add(i);
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.StatsRecorder
        public void recordMisses(int i) {
            this.missCount.add(i);
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.StatsRecorder
        public void recordLoadSuccess(long j) {
            this.loadSuccessCount.increment();
            this.totalLoadTime.add(j);
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.StatsRecorder
        public void recordLoadFailure(long j) {
            this.loadFailureCount.increment();
            this.totalLoadTime.add(j);
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.StatsRecorder
        public void recordEvictions(int i) {
            this.evictionCount.add(i);
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.StatsRecorder
        public void recordOpenFiles(int i) {
            this.openFileCount.add(i);
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.StatsRecorder
        public void recordOpenBytes(Pack pack, int i) {
            long j = i;
            this.openByteCount.add(j);
            String strRepositoryId = repositoryId(pack);
            this.openByteCountPerRepository.computeIfAbsent(strRepositoryId, new WindowCache$StatsRecorderImpl$$ExternalSyntheticLambda3()).add(j);
            if (i < 0) {
                this.openByteCountPerRepository.computeIfPresent(strRepositoryId, new WindowCache$StatsRecorderImpl$$ExternalSyntheticLambda4());
            }
        }

        static /* synthetic */ LongAdder lambda$0(String str) {
            return new LongAdder();
        }

        static /* synthetic */ LongAdder lambda$1(String str, LongAdder longAdder) {
            if (longAdder.longValue() == 0) {
                return null;
            }
            return longAdder;
        }

        private static String repositoryId(Pack pack) {
            return pack.getPackFile().getParentFile().getParentFile().getParent();
        }

        @Override // org.eclipse.jgit.storage.file.WindowCacheStats
        public long getHitCount() {
            return this.hitCount.sum();
        }

        @Override // org.eclipse.jgit.storage.file.WindowCacheStats
        public long getMissCount() {
            return this.missCount.sum();
        }

        @Override // org.eclipse.jgit.storage.file.WindowCacheStats
        public long getLoadSuccessCount() {
            return this.loadSuccessCount.sum();
        }

        @Override // org.eclipse.jgit.storage.file.WindowCacheStats
        public long getLoadFailureCount() {
            return this.loadFailureCount.sum();
        }

        @Override // org.eclipse.jgit.storage.file.WindowCacheStats
        public long getEvictionCount() {
            return this.evictionCount.sum();
        }

        @Override // org.eclipse.jgit.storage.file.WindowCacheStats
        public long getTotalLoadTime() {
            return this.totalLoadTime.sum();
        }

        @Override // org.eclipse.jgit.storage.file.WindowCacheStats
        public long getOpenFileCount() {
            return this.openFileCount.sum();
        }

        @Override // org.eclipse.jgit.storage.file.WindowCacheStats
        public long getOpenByteCount() {
            return this.openByteCount.sum();
        }

        @Override // org.eclipse.jgit.storage.file.WindowCacheStats
        public void resetCounters() {
            this.hitCount.reset();
            this.missCount.reset();
            this.loadSuccessCount.reset();
            this.loadFailureCount.reset();
            this.totalLoadTime.reset();
            this.evictionCount.reset();
        }

        @Override // org.eclipse.jgit.storage.file.WindowCacheStats
        public Map<String, Long> getOpenByteCountPerRepository() {
            return Collections.unmodifiableMap((Map) this.openByteCountPerRepository.entrySet().stream().collect(Collectors.toMap(new WindowCache$StatsRecorderImpl$$ExternalSyntheticLambda0(), new WindowCache$StatsRecorderImpl$$ExternalSyntheticLambda1(), new WindowCache$StatsRecorderImpl$$ExternalSyntheticLambda2())));
        }
    }

    private static final int bits(int i) {
        if (i < 4096) {
            throw new IllegalArgumentException(JGitText.get().invalidWindowSize);
        }
        if (Integer.bitCount(i) != 1) {
            throw new IllegalArgumentException(JGitText.get().windowSizeMustBePowerOf2);
        }
        return Integer.numberOfTrailingZeros(i);
    }

    static {
        reconfigure(new WindowCacheConfig());
    }

    @Deprecated
    public static void reconfigure(WindowCacheConfig windowCacheConfig) {
        WindowCache windowCache = new WindowCache(windowCacheConfig);
        WindowCache windowCache2 = cache;
        if (windowCache2 != null) {
            windowCache2.removeAll();
        }
        cache = windowCache;
        streamFileThreshold = windowCacheConfig.getStreamFileThreshold();
        DeltaBaseCache.reconfigure(windowCacheConfig);
    }

    static int getStreamFileThreshold() {
        return streamFileThreshold;
    }

    public static WindowCache getInstance() {
        return cache.publishMBeanIfNeeded();
    }

    static final ByteWindow get(Pack pack, long j) throws IOException {
        WindowCache windowCache = cache;
        ByteWindow orLoad = windowCache.getOrLoad(pack, windowCache.toStart(j));
        if (windowCache != cache.publishMBeanIfNeeded()) {
            windowCache.removeAll();
        }
        return orLoad;
    }

    static final void purge(Pack pack) {
        cache.removeAll(pack);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0048 A[PHI: r3
  0x0048: PHI (r3v8 int) = (r3v5 int), (r3v6 int) binds: [B:9:0x0046, B:12:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    private WindowCache(WindowCacheConfig windowCacheConfig) {
        CleanupQueue softCleanupQueue;
        int iTableSize = tableSize(windowCacheConfig);
        this.tableSize = iTableSize;
        int iLockCount = lockCount(windowCacheConfig);
        if (iTableSize < 1) {
            throw new IllegalArgumentException(JGitText.get().tSizeMustBeGreaterOrEqual1);
        }
        if (iLockCount < 1) {
            throw new IllegalArgumentException(JGitText.get().lockCountMustBeGreaterOrEqual1);
        }
        this.clock = new AtomicLong(1L);
        this.table = new AtomicReferenceArray<>(iTableSize);
        this.locks = new Lock[iLockCount];
        int i = 0;
        while (true) {
            Lock[] lockArr = this.locks;
            if (i >= lockArr.length) {
                break;
            }
            lockArr[i] = new Lock(null);
            i++;
        }
        this.evictLock = new ReentrantLock();
        int i2 = this.tableSize;
        int i3 = (int) (((double) i2) * 0.1d);
        int i4 = 64;
        if (64 >= i3) {
            i4 = 4;
            i3 = i3 < 4 ? i4 : i3;
        }
        this.evictBatch = i2 >= i3 ? i3 : i2;
        int packedGitOpenFiles = windowCacheConfig.getPackedGitOpenFiles();
        this.maxFiles = packedGitOpenFiles;
        long packedGitLimit = windowCacheConfig.getPackedGitLimit();
        this.maxBytes = packedGitLimit;
        this.mmap = windowCacheConfig.isPackedGitMMAP();
        int iBits = bits(windowCacheConfig.getPackedGitWindowSize());
        this.windowSizeShift = iBits;
        int i5 = 1 << iBits;
        this.windowSize = i5;
        boolean zIsPackedGitUseStrongRefs = windowCacheConfig.isPackedGitUseStrongRefs();
        this.useStrongRefs = zIsPackedGitUseStrongRefs;
        this.useStrongIndexRefs = windowCacheConfig.isPackedIndexGitUseStrongRefs();
        if (zIsPackedGitUseStrongRefs) {
            softCleanupQueue = new StrongCleanupQueue(this);
        } else {
            softCleanupQueue = new SoftCleanupQueue(this);
        }
        this.queue = softCleanupQueue;
        StatsRecorderImpl statsRecorderImpl = new StatsRecorderImpl();
        this.mbean = statsRecorderImpl;
        this.statsRecorder = statsRecorderImpl;
        this.publishMBean.set(windowCacheConfig.getExposeStatsViaJmx());
        if (packedGitOpenFiles < 1) {
            throw new IllegalArgumentException(JGitText.get().openFilesMustBeAtLeast1);
        }
        if (packedGitLimit < i5) {
            throw new IllegalArgumentException(JGitText.get().windowSizeMustBeLesserThanLimit);
        }
    }

    private WindowCache publishMBeanIfNeeded() {
        if (this.publishMBean.getAndSet(false)) {
            Monitoring.registerMBean(this.mbean, "block_cache");
        }
        return this;
    }

    public WindowCacheStats getStats() {
        return this.statsRecorder.getStats();
    }

    public void resetStats() {
        this.mbean.resetCounters();
    }

    private int hash(int i, long j) {
        return i + ((int) (j >>> this.windowSizeShift));
    }

    private ByteWindow load(Pack pack, long j) throws IOException {
        long jNanoTime = System.nanoTime();
        if (pack.beginWindowCache()) {
            this.statsRecorder.recordOpenFiles(1);
        }
        try {
            try {
                if (this.mmap) {
                    ByteWindow byteWindowMmap = pack.mmap(j, this.windowSize);
                    this.statsRecorder.recordMisses(1);
                    return byteWindowMmap;
                }
                ByteArrayWindow byteArrayWindow = pack.read(j, this.windowSize);
                this.statsRecorder.recordLoadSuccess(System.nanoTime() - jNanoTime);
                this.statsRecorder.recordMisses(1);
                return byteArrayWindow;
            } catch (Throwable th) {
                this.statsRecorder.recordMisses(1);
                throw th;
            }
        } catch (IOException | Error | RuntimeException e) {
            close(pack);
            this.statsRecorder.recordLoadFailure(System.nanoTime() - jNanoTime);
            throw e;
        }
    }

    private PageRef<ByteWindow> createRef(Pack pack, long j, ByteWindow byteWindow) {
        PageRef<ByteWindow> softRef;
        if (this.useStrongRefs) {
            softRef = new StrongRef(pack, j, byteWindow, this.queue);
        } else {
            softRef = new SoftRef(pack, j, byteWindow, (SoftCleanupQueue) this.queue);
        }
        this.statsRecorder.recordOpenBytes(softRef.getPack(), softRef.getSize());
        return softRef;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clear(PageRef<ByteWindow> pageRef) {
        this.statsRecorder.recordOpenBytes(pageRef.getPack(), -pageRef.getSize());
        this.statsRecorder.recordEvictions(1);
        close(pageRef.getPack());
    }

    private void close(Pack pack) {
        if (pack.endWindowCache()) {
            this.statsRecorder.recordOpenFiles(-1);
        }
    }

    private boolean isFull() {
        return ((long) this.maxFiles) < this.mbean.getOpenFileCount() || this.maxBytes < this.mbean.getOpenByteCount();
    }

    private long toStart(long j) {
        int i = this.windowSizeShift;
        return (j >>> i) << i;
    }

    private static int tableSize(WindowCacheConfig windowCacheConfig) {
        int packedGitWindowSize = windowCacheConfig.getPackedGitWindowSize();
        long packedGitLimit = windowCacheConfig.getPackedGitLimit();
        if (packedGitWindowSize <= 0) {
            throw new IllegalArgumentException(JGitText.get().invalidWindowSize);
        }
        long j = packedGitWindowSize;
        if (packedGitLimit < j) {
            throw new IllegalArgumentException(JGitText.get().windowSizeMustBeLesserThanLimit);
        }
        return (int) Math.min(((packedGitLimit / j) * 5) / 2, 2000000000L);
    }

    private static int lockCount(WindowCacheConfig windowCacheConfig) {
        return Math.max(windowCacheConfig.getPackedGitOpenFiles(), 32);
    }

    private ByteWindow getOrLoad(Pack pack, long j) throws IOException {
        ByteWindow byteWindowScan;
        int iSlot = slot(pack, j);
        Entry entry = this.table.get(iSlot);
        ByteWindow byteWindowScan2 = scan(entry, pack, j);
        if (byteWindowScan2 != null) {
            this.statsRecorder.recordHits(1);
            return byteWindowScan2;
        }
        synchronized (lock(pack, j)) {
            Entry entry2 = this.table.get(iSlot);
            if (entry2 != entry && (byteWindowScan = scan(entry2, pack, j)) != null) {
                this.statsRecorder.recordHits(1);
                return byteWindowScan;
            }
            ByteWindow byteWindowLoad = load(pack, j);
            PageRef<ByteWindow> pageRefCreateRef = createRef(pack, j, byteWindowLoad);
            hit(pageRefCreateRef);
            while (!Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this.table, iSlot, entry2, new Entry(clean(entry2), pageRefCreateRef))) {
                entry2 = this.table.get(iSlot);
            }
            if (!this.evictLock.tryLock()) {
                return byteWindowLoad;
            }
            try {
                gc();
                evict();
                return byteWindowLoad;
            } finally {
                this.evictLock.unlock();
            }
        }
    }

    private ByteWindow scan(Entry entry, Pack pack, long j) {
        while (entry != null) {
            PageRef<ByteWindow> pageRef = entry.ref;
            if (pageRef.getPack() != pack || pageRef.getPosition() != j) {
                entry = entry.next;
            } else {
                ByteWindow byteWindow = pageRef.get();
                if (byteWindow != null) {
                    hit(pageRef);
                    return byteWindow;
                }
                entry.kill();
                return null;
            }
        }
        return null;
    }

    private void hit(PageRef pageRef) {
        long j = this.clock.get();
        this.clock.compareAndSet(j, 1 + j);
        pageRef.setLastAccess(j);
    }

    private void evict() {
        while (isFull()) {
            int iNextInt = rng.nextInt(this.tableSize);
            int i = this.evictBatch - 1;
            Entry entry = null;
            int i2 = 0;
            while (i >= 0) {
                if (this.tableSize <= iNextInt) {
                    iNextInt = 0;
                }
                for (Entry entry2 = this.table.get(iNextInt); entry2 != null; entry2 = entry2.next) {
                    if (!entry2.dead && (entry == null || entry2.ref.getLastAccess() < entry.ref.getLastAccess())) {
                        i2 = iNextInt;
                        entry = entry2;
                    }
                }
                i--;
                iNextInt++;
            }
            if (entry != null) {
                entry.kill();
                gc();
                Entry entry3 = this.table.get(i2);
                Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this.table, i2, entry3, clean(entry3));
            }
        }
    }

    private void removeAll() {
        Entry entry;
        for (int i = 0; i < this.tableSize; i++) {
            do {
                entry = this.table.get(i);
                for (Entry entry2 = entry; entry2 != null; entry2 = entry2.next) {
                    entry2.kill();
                }
            } while (!Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this.table, i, entry, null));
        }
        gc();
    }

    private void removeAll(Pack pack) {
        for (int i = 0; i < this.tableSize; i++) {
            Entry entry = this.table.get(i);
            boolean z = false;
            for (Entry entry2 = entry; entry2 != null; entry2 = entry2.next) {
                if (entry2.ref.getPack() == pack) {
                    entry2.kill();
                } else {
                    if (entry2.dead) {
                    }
                }
                z = true;
            }
            if (z) {
                Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this.table, i, entry, clean(entry));
            }
        }
        gc();
    }

    private void gc() {
        this.queue.gc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int slot(Pack pack, long j) {
        return (hash(pack.hash, j) >>> 1) % this.tableSize;
    }

    private Lock lock(Pack pack, long j) {
        return this.locks[(hash(pack.hash, j) >>> 1) % this.locks.length];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Entry clean(Entry entry) {
        while (entry != null && entry.dead) {
            entry.ref.kill();
            entry = entry.next;
        }
        if (entry == null) {
            return null;
        }
        Entry entryClean = clean(entry.next);
        return entryClean == entry.next ? entry : new Entry(entryClean, entry.ref);
    }

    boolean isPackedIndexGitUseStrongRefs() {
        return this.useStrongIndexRefs;
    }

    private static class Entry {
        volatile boolean dead;
        final Entry next;
        final PageRef<ByteWindow> ref;

        Entry(Entry entry, PageRef<ByteWindow> pageRef) {
            this.next = entry;
            this.ref = pageRef;
        }

        final void kill() {
            this.dead = true;
            this.ref.kill();
        }
    }

    private static class SoftRef extends SoftReference<ByteWindow> implements PageRef<ByteWindow> {
        private long lastAccess;
        private final Pack pack;
        private final long position;
        private final int size;

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.PageRef
        public boolean isStrongRef() {
            return false;
        }

        protected SoftRef(Pack pack, long j, ByteWindow byteWindow, SoftCleanupQueue softCleanupQueue) {
            super(byteWindow, softCleanupQueue);
            this.pack = pack;
            this.position = j;
            this.size = byteWindow.size();
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.PageRef
        public Pack getPack() {
            return this.pack;
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.PageRef
        public long getPosition() {
            return this.position;
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.PageRef
        public int getSize() {
            return this.size;
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.PageRef
        public long getLastAccess() {
            return this.lastAccess;
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.PageRef
        public void setLastAccess(long j) {
            this.lastAccess = j;
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.PageRef
        public boolean kill() {
            return enqueue();
        }
    }

    private static class StrongRef implements PageRef<ByteWindow> {
        private long lastAccess;
        private final Pack pack;
        private final long position;
        private CleanupQueue queue;
        private ByteWindow referent;
        private final int size;

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.PageRef
        public boolean isStrongRef() {
            return true;
        }

        protected StrongRef(Pack pack, long j, ByteWindow byteWindow, CleanupQueue cleanupQueue) {
            this.pack = pack;
            this.position = j;
            this.referent = byteWindow;
            this.size = byteWindow.size();
            this.queue = cleanupQueue;
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.PageRef
        public Pack getPack() {
            return this.pack;
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.PageRef
        public long getPosition() {
            return this.position;
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.PageRef
        public int getSize() {
            return this.size;
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.PageRef
        public long getLastAccess() {
            return this.lastAccess;
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.PageRef
        public void setLastAccess(long j) {
            this.lastAccess = j;
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.PageRef
        public ByteWindow get() {
            return this.referent;
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.PageRef
        public boolean kill() {
            if (this.referent == null) {
                return false;
            }
            this.referent = null;
            return this.queue.enqueue(this);
        }
    }

    private static class SoftCleanupQueue extends ReferenceQueue<ByteWindow> implements CleanupQueue {
        private final WindowCache wc;

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.CleanupQueue
        public boolean enqueue(PageRef<ByteWindow> pageRef) {
            return false;
        }

        SoftCleanupQueue(WindowCache windowCache) {
            this.wc = windowCache;
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.CleanupQueue
        public void gc() {
            while (true) {
                SoftRef softRef = (SoftRef) poll();
                if (softRef == null) {
                    return;
                }
                this.wc.clear(softRef);
                int iSlot = this.wc.slot(softRef.getPack(), softRef.getPosition());
                Entry entry = (Entry) this.wc.table.get(iSlot);
                for (Entry entry2 = entry; entry2 != null; entry2 = entry2.next) {
                    if (entry2.ref == softRef) {
                        entry2.dead = true;
                        Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this.wc.table, iSlot, entry, WindowCache.clean(entry));
                        break;
                    }
                }
            }
        }
    }

    private static class StrongCleanupQueue implements CleanupQueue {
        private final ConcurrentLinkedQueue<PageRef<ByteWindow>> queue = new ConcurrentLinkedQueue<>();
        private final WindowCache wc;

        StrongCleanupQueue(WindowCache windowCache) {
            this.wc = windowCache;
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.CleanupQueue
        public boolean enqueue(PageRef<ByteWindow> pageRef) {
            if (this.queue.contains(pageRef)) {
                return false;
            }
            return this.queue.add(pageRef);
        }

        @Override // org.eclipse.jgit.internal.storage.file.WindowCache.CleanupQueue
        public void gc() {
            while (true) {
                PageRef<ByteWindow> pageRefPoll = this.queue.poll();
                if (pageRefPoll == null) {
                    return;
                }
                this.wc.clear(pageRefPoll);
                int iSlot = this.wc.slot(pageRefPoll.getPack(), pageRefPoll.getPosition());
                Entry entry = (Entry) this.wc.table.get(iSlot);
                for (Entry entry2 = entry; entry2 != null; entry2 = entry2.next) {
                    if (entry2.ref == pageRefPoll) {
                        entry2.dead = true;
                        Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this.wc.table, iSlot, entry, WindowCache.clean(entry));
                        break;
                    }
                }
            }
        }
    }

    private static final class Lock {
        /* synthetic */ Lock(WindowCacheIA windowCacheIA) {
            this();
        }

        private Lock() {
        }
    }
}

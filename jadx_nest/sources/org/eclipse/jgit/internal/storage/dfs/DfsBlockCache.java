package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.LongStream;
import org.eclipse.jgit.internal.storage.pack.PackExt;

/* JADX INFO: loaded from: classes5.dex */
public final class DfsBlockCache {
    private static volatile DfsBlockCache cache;
    private final int blockSize;
    private final int[] cacheHotLimits = new int[PackExt.valuesCustom().length];
    private final DfsBlockCacheTable dfsBlockCacheTable;
    private final long maxBytes;
    private final long maxStreamThroughCache;

    @FunctionalInterface
    interface ReadableChannelSupplier {
        ReadableChannel get() throws IOException;
    }

    @FunctionalInterface
    interface RefLoader<T> {
        Ref<T> load() throws IOException;
    }

    static {
        reconfigure(new DfsBlockCacheConfig());
    }

    public static void reconfigure(DfsBlockCacheConfig dfsBlockCacheConfig) {
        cache = new DfsBlockCache(dfsBlockCacheConfig);
    }

    public static DfsBlockCache getInstance() {
        return cache;
    }

    private DfsBlockCache(DfsBlockCacheConfig dfsBlockCacheConfig) {
        long blockLimit = dfsBlockCacheConfig.getBlockLimit();
        this.maxBytes = blockLimit;
        this.blockSize = dfsBlockCacheConfig.getBlockSize();
        this.maxStreamThroughCache = (long) (blockLimit * dfsBlockCacheConfig.getStreamRatio());
        if (!dfsBlockCacheConfig.getPackExtCacheConfigurations().isEmpty()) {
            this.dfsBlockCacheTable = PackExtBlockCacheTable.fromBlockCacheConfigs(dfsBlockCacheConfig);
        } else {
            this.dfsBlockCacheTable = new ClockBlockCacheTable(dfsBlockCacheConfig);
        }
        for (int i = 0; i < PackExt.valuesCustom().length; i++) {
            Integer num = dfsBlockCacheConfig.getCacheHotMap().get(PackExt.valuesCustom()[i]);
            if (num != null && num.intValue() > 0) {
                this.cacheHotLimits[i] = num.intValue();
            } else {
                this.cacheHotLimits[i] = 1;
            }
        }
    }

    boolean shouldCopyThroughCache(long j) {
        return j <= this.maxStreamThroughCache;
    }

    public long[] getCurrentSize() {
        return getAggregatedBlockCacheStats().getCurrentSize();
    }

    public long getFillPercentage() {
        return (LongStream.of(getCurrentSize()).sum() * 100) / this.maxBytes;
    }

    public long[] getHitCount() {
        return getAggregatedBlockCacheStats().getHitCount();
    }

    public long[] getMissCount() {
        return getAggregatedBlockCacheStats().getMissCount();
    }

    public long[] getTotalRequestCount() {
        return getAggregatedBlockCacheStats().getTotalRequestCount();
    }

    public long[] getHitRatio() {
        return getAggregatedBlockCacheStats().getHitRatio();
    }

    public long[] getEvictions() {
        return getAggregatedBlockCacheStats().getEvictions();
    }

    public List<DfsBlockCacheTable.BlockCacheStats> getAllBlockCacheStats() {
        return this.dfsBlockCacheTable.getBlockCacheStats();
    }

    public boolean hasBlock0(DfsStreamKey dfsStreamKey) {
        return this.dfsBlockCacheTable.hasBlock0(dfsStreamKey);
    }

    int getBlockSize() {
        return this.blockSize;
    }

    DfsBlock getOrLoad(BlockBasedFile blockBasedFile, long j, DfsReader dfsReader, ReadableChannelSupplier readableChannelSupplier) throws IOException {
        return this.dfsBlockCacheTable.getOrLoad(blockBasedFile, j, dfsReader, readableChannelSupplier);
    }

    void put(DfsBlock dfsBlock) {
        this.dfsBlockCacheTable.put(dfsBlock);
    }

    <T> Ref<T> getOrLoadRef(DfsStreamKey dfsStreamKey, long j, RefLoader<T> refLoader) throws IOException {
        return this.dfsBlockCacheTable.getOrLoadRef(dfsStreamKey, j, refLoader);
    }

    <T> Ref<T> putRef(DfsStreamKey dfsStreamKey, long j, T t) {
        return this.dfsBlockCacheTable.putRef(dfsStreamKey, j, t);
    }

    <T> Ref<T> put(DfsStreamKey dfsStreamKey, long j, long j2, T t) {
        return this.dfsBlockCacheTable.put(dfsStreamKey, j, j2, t);
    }

    boolean contains(DfsStreamKey dfsStreamKey, long j) {
        return this.dfsBlockCacheTable.contains(dfsStreamKey, j);
    }

    <T> T get(DfsStreamKey dfsStreamKey, long j) {
        return (T) this.dfsBlockCacheTable.get(dfsStreamKey, j);
    }

    private DfsBlockCacheTable.BlockCacheStats getAggregatedBlockCacheStats() {
        return AggregatedBlockCacheStats.fromStatsList(this.dfsBlockCacheTable.getBlockCacheStats());
    }

    static final class Ref<T> {
        private volatile int hotCount;
        final DfsStreamKey key;
        Ref next;
        final long position;
        final long size;
        private final AtomicInteger totalHitCount = new AtomicInteger();
        volatile T value;

        Ref(DfsStreamKey dfsStreamKey, long j, long j2, T t) {
            this.key = dfsStreamKey;
            this.position = j;
            this.size = j2;
            this.value = t;
        }

        T get() {
            T t = this.value;
            if (t != null) {
                markHotter();
            }
            return t;
        }

        boolean has() {
            return this.value != null;
        }

        void markHotter() {
            this.hotCount = Math.min(DfsBlockCache.getInstance().cacheHotLimits[this.key.packExtPos], this.hotCount + 1);
            this.totalHitCount.incrementAndGet();
        }

        void markColder() {
            this.hotCount = Math.max(0, this.hotCount - 1);
        }

        boolean isHot() {
            return this.hotCount > 0;
        }

        int getTotalHitCount() {
            return this.totalHitCount.get();
        }
    }
}

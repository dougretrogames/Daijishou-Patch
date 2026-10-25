package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface DfsBlockCacheTable {

    public interface BlockCacheStats {
        long[] getCurrentSize();

        long[] getEvictions();

        long[] getHitCount();

        long[] getHitRatio();

        long[] getMissCount();

        String getName();

        long[] getTotalRequestCount();
    }

    boolean contains(DfsStreamKey dfsStreamKey, long j);

    <T> T get(DfsStreamKey dfsStreamKey, long j);

    List<BlockCacheStats> getBlockCacheStats();

    String getName();

    DfsBlock getOrLoad(BlockBasedFile blockBasedFile, long j, DfsReader dfsReader, DfsBlockCache.ReadableChannelSupplier readableChannelSupplier) throws IOException;

    <T> DfsBlockCache.Ref<T> getOrLoadRef(DfsStreamKey dfsStreamKey, long j, DfsBlockCache.RefLoader<T> refLoader) throws IOException;

    boolean hasBlock0(DfsStreamKey dfsStreamKey);

    <T> DfsBlockCache.Ref<T> put(DfsStreamKey dfsStreamKey, long j, long j2, T t);

    void put(DfsBlock dfsBlock);

    <T> DfsBlockCache.Ref<T> putRef(DfsStreamKey dfsStreamKey, long j, T t);
}

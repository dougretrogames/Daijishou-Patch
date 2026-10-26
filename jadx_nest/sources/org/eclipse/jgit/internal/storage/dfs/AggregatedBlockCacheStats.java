package org.eclipse.jgit.internal.storage.dfs;

import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.internal.storage.pack.PackExt;

/* INFO: loaded from: classes5.dex */
class AggregatedBlockCacheStats implements DfsBlockCacheTable.BlockCacheStats {
    private final List<DfsBlockCacheTable.BlockCacheStats> blockCacheStats;

    static DfsBlockCacheTable.BlockCacheStats fromStatsList(List<DfsBlockCacheTable.BlockCacheStats> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        return new AggregatedBlockCacheStats(list);
    }

    private AggregatedBlockCacheStats(List<DfsBlockCacheTable.BlockCacheStats> list) {
        this.blockCacheStats = list;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable.BlockCacheStats
    public String getName() {
        return AggregatedBlockCacheStats.class.getName();
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable.BlockCacheStats
    public long[] getCurrentSize() {
        long[] jArrEmptyPackStats = emptyPackStats();
        Iterator<DfsBlockCacheTable.BlockCacheStats> it = this.blockCacheStats.iterator();
        while (it.hasNext()) {
            jArrEmptyPackStats = add(jArrEmptyPackStats, it.next().getCurrentSize());
        }
        return jArrEmptyPackStats;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable.BlockCacheStats
    public long[] getHitCount() {
        long[] jArrEmptyPackStats = emptyPackStats();
        Iterator<DfsBlockCacheTable.BlockCacheStats> it = this.blockCacheStats.iterator();
        while (it.hasNext()) {
            jArrEmptyPackStats = add(jArrEmptyPackStats, it.next().getHitCount());
        }
        return jArrEmptyPackStats;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable.BlockCacheStats
    public long[] getMissCount() {
        long[] jArrEmptyPackStats = emptyPackStats();
        Iterator<DfsBlockCacheTable.BlockCacheStats> it = this.blockCacheStats.iterator();
        while (it.hasNext()) {
            jArrEmptyPackStats = add(jArrEmptyPackStats, it.next().getMissCount());
        }
        return jArrEmptyPackStats;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable.BlockCacheStats
    public long[] getTotalRequestCount() {
        long[] jArrEmptyPackStats = emptyPackStats();
        Iterator<DfsBlockCacheTable.BlockCacheStats> it = this.blockCacheStats.iterator();
        while (it.hasNext()) {
            jArrEmptyPackStats = add(jArrEmptyPackStats, it.next().getTotalRequestCount());
        }
        return jArrEmptyPackStats;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable.BlockCacheStats
    public long[] getHitRatio() {
        long[] hitCount = getHitCount();
        long[] missCount = getMissCount();
        int iMax = Math.max(hitCount.length, missCount.length);
        long[] jArr = new long[iMax];
        for (int i = 0; i < iMax; i++) {
            if (i >= hitCount.length) {
                jArr[i] = 0;
            } else if (i >= missCount.length) {
                jArr[i] = 100;
            } else {
                long j = hitCount[i];
                long j2 = missCount[i] + j;
                jArr[i] = j2 != 0 ? (j * 100) / j2 : 0L;
            }
        }
        return jArr;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable.BlockCacheStats
    public long[] getEvictions() {
        long[] jArrEmptyPackStats = emptyPackStats();
        Iterator<DfsBlockCacheTable.BlockCacheStats> it = this.blockCacheStats.iterator();
        while (it.hasNext()) {
            jArrEmptyPackStats = add(jArrEmptyPackStats, it.next().getEvictions());
        }
        return jArrEmptyPackStats;
    }

    private static long[] emptyPackStats() {
        return new long[PackExt.valuesCustom().length];
    }

    private static long[] add(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[Integer.max(jArr.length, jArr2.length)];
        int i = 0;
        while (i < Integer.min(jArr.length, jArr2.length)) {
            jArr3[i] = jArr[i] + jArr2[i];
            i++;
        }
        for (int i2 = i; i2 < jArr.length; i2++) {
            jArr3[i2] = jArr[i];
        }
        for (int i3 = i; i3 < jArr2.length; i3++) {
            jArr3[i3] = jArr2[i];
        }
        return jArr3;
    }
}

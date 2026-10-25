package org.eclipse.jgit.internal.storage.dfs;

import androidx.compose.runtime.CompositionImpl$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jgit.internal.storage.pack.PackExt;

/* JADX INFO: loaded from: classes5.dex */
class DfsBlockCacheStats implements DfsBlockCacheTable.BlockCacheStats {
    private final AtomicReference<AtomicLong[]> liveBytes;
    private final String name;
    private final AtomicReference<AtomicLong[]> statEvict;
    private final AtomicReference<AtomicLong[]> statHit;
    private final AtomicReference<AtomicLong[]> statMiss;

    DfsBlockCacheStats() {
        this("");
    }

    DfsBlockCacheStats(String str) {
        this.name = str;
        this.statHit = new AtomicReference<>(newCounters());
        this.statMiss = new AtomicReference<>(newCounters());
        this.statEvict = new AtomicReference<>(newCounters());
        this.liveBytes = new AtomicReference<>(newCounters());
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable.BlockCacheStats
    public String getName() {
        return this.name;
    }

    void incrementHit(DfsStreamKey dfsStreamKey) {
        getStat(this.statHit, dfsStreamKey).incrementAndGet();
    }

    void incrementMiss(DfsStreamKey dfsStreamKey) {
        getStat(this.statMiss, dfsStreamKey).incrementAndGet();
    }

    void incrementEvict(DfsStreamKey dfsStreamKey) {
        getStat(this.statEvict, dfsStreamKey).incrementAndGet();
    }

    void addToLiveBytes(DfsStreamKey dfsStreamKey, long j) {
        getStat(this.liveBytes, dfsStreamKey).addAndGet(j);
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable.BlockCacheStats
    public long[] getCurrentSize() {
        return getStatVals(this.liveBytes);
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable.BlockCacheStats
    public long[] getHitCount() {
        return getStatVals(this.statHit);
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable.BlockCacheStats
    public long[] getMissCount() {
        return getStatVals(this.statMiss);
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable.BlockCacheStats
    public long[] getTotalRequestCount() {
        AtomicLong[] atomicLongArr = this.statHit.get();
        AtomicLong[] atomicLongArr2 = this.statMiss.get();
        long[] jArr = new long[Math.max(atomicLongArr.length, atomicLongArr2.length)];
        for (int i = 0; i < atomicLongArr.length; i++) {
            jArr[i] = jArr[i] + atomicLongArr[i].get();
        }
        for (int i2 = 0; i2 < atomicLongArr2.length; i2++) {
            jArr[i2] = jArr[i2] + atomicLongArr2[i2].get();
        }
        return jArr;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable.BlockCacheStats
    public long[] getHitRatio() {
        AtomicLong[] atomicLongArr = this.statHit.get();
        AtomicLong[] atomicLongArr2 = this.statMiss.get();
        int iMax = Math.max(atomicLongArr.length, atomicLongArr2.length);
        long[] jArr = new long[iMax];
        for (int i = 0; i < iMax; i++) {
            if (i >= atomicLongArr.length) {
                jArr[i] = 0;
            } else if (i >= atomicLongArr2.length) {
                jArr[i] = 100;
            } else {
                long j = atomicLongArr[i].get();
                long j2 = atomicLongArr2[i].get() + j;
                jArr[i] = j2 != 0 ? (j * 100) / j2 : 0L;
            }
        }
        return jArr;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable.BlockCacheStats
    public long[] getEvictions() {
        return getStatVals(this.statEvict);
    }

    private static AtomicLong[] newCounters() {
        int length = PackExt.valuesCustom().length;
        AtomicLong[] atomicLongArr = new AtomicLong[length];
        for (int i = 0; i < length; i++) {
            atomicLongArr[i] = new AtomicLong();
        }
        return atomicLongArr;
    }

    private static long[] getStatVals(AtomicReference<AtomicLong[]> atomicReference) {
        AtomicLong[] atomicLongArr = atomicReference.get();
        long[] jArr = new long[atomicLongArr.length];
        for (int i = 0; i < atomicLongArr.length; i++) {
            jArr[i] = atomicLongArr[i].get();
        }
        return jArr;
    }

    private static AtomicLong getStat(AtomicReference<AtomicLong[]> atomicReference, DfsStreamKey dfsStreamKey) {
        AtomicLong[] atomicLongArr;
        AtomicLong[] atomicLongArr2;
        int i = dfsStreamKey.packExtPos;
        do {
            atomicLongArr = atomicReference.get();
            if (i < atomicLongArr.length) {
                return atomicLongArr[i];
            }
            int iMax = Math.max(i + 1, PackExt.valuesCustom().length);
            atomicLongArr2 = new AtomicLong[iMax];
            System.arraycopy(atomicLongArr, 0, atomicLongArr2, 0, atomicLongArr.length);
            for (int length = atomicLongArr.length; length < iMax; length++) {
                atomicLongArr2[length] = new AtomicLong();
            }
        } while (!CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, atomicLongArr, atomicLongArr2));
        return atomicLongArr2[i];
    }
}

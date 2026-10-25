package org.eclipse.jgit.internal.storage.dfs;

import java.util.Arrays;
import java.util.Comparator;
import org.eclipse.jgit.internal.storage.commitgraph.CommitGraphWriter;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.internal.storage.reftable.ReftableWriter;
import org.eclipse.jgit.lib.BranchConfig;
import org.eclipse.jgit.storage.pack.PackStatistics;

/* JADX INFO: loaded from: classes5.dex */
public class DfsPackDescription {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$internal$storage$dfs$DfsObjDatabase$PackSource;
    private int[] blockSizeMap;
    private CommitGraphWriter.Stats commitGraphStats;
    private long deltaCount;
    private long estimatedPackSize;
    private int extensions;
    private int indexVersion;
    private long lastModified;
    private long maxUpdateIndex;
    private long minUpdateIndex;
    private long objectCount;
    private final String packName;
    private DfsObjDatabase.PackSource packSource;
    private PackStatistics packStats;
    private ReftableWriter.Stats refStats;
    private final DfsRepositoryDescription repoDesc;
    private long[] sizeMap;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$internal$storage$dfs$DfsObjDatabase$PackSource() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$internal$storage$dfs$DfsObjDatabase$PackSource;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[DfsObjDatabase.PackSource.valuesCustom().length];
        try {
            iArr2[DfsObjDatabase.PackSource.COMPACT.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[DfsObjDatabase.PackSource.GC.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[DfsObjDatabase.PackSource.GC_REST.ordinal()] = 5;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[DfsObjDatabase.PackSource.INSERT.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[DfsObjDatabase.PackSource.RECEIVE.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[DfsObjDatabase.PackSource.UNREACHABLE_GARBAGE.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$internal$storage$dfs$DfsObjDatabase$PackSource = iArr2;
        return iArr2;
    }

    public static Comparator<DfsPackDescription> objectLookupComparator() {
        return objectLookupComparator(DfsObjDatabase.PackSource.DEFAULT_COMPARATOR);
    }

    public static Comparator<DfsPackDescription> objectLookupComparator(Comparator<DfsObjDatabase.PackSource> comparator) {
        return Comparator.comparing(new DfsPackDescription$$ExternalSyntheticLambda1(), comparator).thenComparing(new DfsPackDescription$$ExternalSyntheticLambda2());
    }

    static /* synthetic */ int lambda$1(DfsPackDescription dfsPackDescription, DfsPackDescription dfsPackDescription2) {
        int iSignum;
        DfsObjDatabase.PackSource packSource = dfsPackDescription.getPackSource();
        if (packSource == dfsPackDescription2.getPackSource() && isGC(packSource) && (iSignum = Long.signum(dfsPackDescription.getFileSize(PackExt.PACK) - dfsPackDescription2.getFileSize(PackExt.PACK))) != 0) {
            return iSignum;
        }
        int iSignum2 = Long.signum(dfsPackDescription2.getLastModified() - dfsPackDescription.getLastModified());
        return iSignum2 != 0 ? iSignum2 : Long.signum(dfsPackDescription.getObjectCount() - dfsPackDescription2.getObjectCount());
    }

    static Comparator<DfsPackDescription> reftableComparator() {
        return new DfsPackDescription$$ExternalSyntheticLambda3();
    }

    static /* synthetic */ int lambda$2(DfsPackDescription dfsPackDescription, DfsPackDescription dfsPackDescription2) {
        int iCompare = DfsObjDatabase.PackSource.DEFAULT_COMPARATOR.reversed().compare(dfsPackDescription.getPackSource(), dfsPackDescription2.getPackSource());
        if (iCompare != 0) {
            return iCompare;
        }
        int iSignum = Long.signum(dfsPackDescription.getMaxUpdateIndex() - dfsPackDescription2.getMaxUpdateIndex());
        return iSignum != 0 ? iSignum : Long.signum(dfsPackDescription.getLastModified() - dfsPackDescription2.getLastModified());
    }

    static Comparator<DfsPackDescription> reuseComparator() {
        return new DfsPackDescription$$ExternalSyntheticLambda0();
    }

    static /* synthetic */ int lambda$3(DfsPackDescription dfsPackDescription, DfsPackDescription dfsPackDescription2) {
        DfsObjDatabase.PackSource packSource = dfsPackDescription.getPackSource();
        if (packSource == dfsPackDescription2.getPackSource() && isGC(packSource)) {
            return Long.signum(dfsPackDescription2.getFileSize(PackExt.PACK) - dfsPackDescription.getFileSize(PackExt.PACK));
        }
        return 0;
    }

    public DfsPackDescription(DfsRepositoryDescription dfsRepositoryDescription, String str, DfsObjDatabase.PackSource packSource) {
        this.repoDesc = dfsRepositoryDescription;
        int iLastIndexOf = str.lastIndexOf(46);
        this.packName = iLastIndexOf >= 0 ? str.substring(0, iLastIndexOf) : str;
        this.packSource = packSource;
        int length = PackExt.valuesCustom().length;
        this.sizeMap = new long[length];
        this.blockSizeMap = new int[length];
    }

    public DfsRepositoryDescription getRepositoryDescription() {
        return this.repoDesc;
    }

    public void addFileExt(PackExt packExt) {
        this.extensions = packExt.getBit() | this.extensions;
    }

    public boolean hasFileExt(PackExt packExt) {
        return (packExt.getBit() & this.extensions) != 0;
    }

    public String getFileName(PackExt packExt) {
        return this.packName + BranchConfig.LOCAL_REPOSITORY + packExt.getExtension();
    }

    public DfsStreamKey getStreamKey(PackExt packExt) {
        return DfsStreamKey.of(getRepositoryDescription(), getFileName(packExt), packExt);
    }

    public DfsObjDatabase.PackSource getPackSource() {
        return this.packSource;
    }

    public DfsPackDescription setPackSource(DfsObjDatabase.PackSource packSource) {
        this.packSource = packSource;
        return this;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public DfsPackDescription setLastModified(long j) {
        this.lastModified = j;
        return this;
    }

    public long getMinUpdateIndex() {
        return this.minUpdateIndex;
    }

    public DfsPackDescription setMinUpdateIndex(long j) {
        this.minUpdateIndex = j;
        return this;
    }

    public long getMaxUpdateIndex() {
        return this.maxUpdateIndex;
    }

    public DfsPackDescription setMaxUpdateIndex(long j) {
        this.maxUpdateIndex = j;
        return this;
    }

    public DfsPackDescription setFileSize(PackExt packExt, long j) {
        int position = packExt.getPosition();
        long[] jArr = this.sizeMap;
        if (position >= jArr.length) {
            this.sizeMap = Arrays.copyOf(jArr, position + 1);
        }
        this.sizeMap[position] = Math.max(0L, j);
        return this;
    }

    public long getFileSize(PackExt packExt) {
        int position = packExt.getPosition();
        long[] jArr = this.sizeMap;
        if (position < jArr.length) {
            return jArr[position];
        }
        return 0L;
    }

    public int getBlockSize(PackExt packExt) {
        int position = packExt.getPosition();
        int[] iArr = this.blockSizeMap;
        if (position < iArr.length) {
            return iArr[position];
        }
        return 0;
    }

    public DfsPackDescription setBlockSize(PackExt packExt, int i) {
        int position = packExt.getPosition();
        int[] iArr = this.blockSizeMap;
        if (position >= iArr.length) {
            this.blockSizeMap = Arrays.copyOf(iArr, position + 1);
        }
        this.blockSizeMap[position] = Math.max(0, i);
        return this;
    }

    public DfsPackDescription setEstimatedPackSize(long j) {
        this.estimatedPackSize = Math.max(0L, j);
        return this;
    }

    public long getEstimatedPackSize() {
        return this.estimatedPackSize;
    }

    public long getObjectCount() {
        return this.objectCount;
    }

    public DfsPackDescription setObjectCount(long j) {
        this.objectCount = Math.max(0L, j);
        return this;
    }

    public long getDeltaCount() {
        return this.deltaCount;
    }

    public DfsPackDescription setDeltaCount(long j) {
        this.deltaCount = Math.max(0L, j);
        return this;
    }

    public PackStatistics getPackStats() {
        return this.packStats;
    }

    DfsPackDescription setPackStats(PackStatistics packStatistics) {
        this.packStats = packStatistics;
        setFileSize(PackExt.PACK, packStatistics.getTotalBytes());
        setObjectCount(packStatistics.getTotalObjects());
        setDeltaCount(packStatistics.getTotalDeltas());
        return this;
    }

    public ReftableWriter.Stats getReftableStats() {
        return this.refStats;
    }

    void setReftableStats(ReftableWriter.Stats stats) {
        this.refStats = stats;
        setMinUpdateIndex(stats.minUpdateIndex());
        setMaxUpdateIndex(stats.maxUpdateIndex());
        setFileSize(PackExt.REFTABLE, stats.totalBytes());
        setBlockSize(PackExt.REFTABLE, stats.refBlockSize());
    }

    public CommitGraphWriter.Stats getCommitGraphStats() {
        return this.commitGraphStats;
    }

    void setCommitGraphStats(CommitGraphWriter.Stats stats) {
        this.commitGraphStats = stats;
    }

    public DfsPackDescription clearPackStats() {
        this.packStats = null;
        this.refStats = null;
        return this;
    }

    public int getIndexVersion() {
        return this.indexVersion;
    }

    public DfsPackDescription setIndexVersion(int i) {
        this.indexVersion = i;
        return this;
    }

    public int hashCode() {
        return this.packName.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof DfsPackDescription) {
            DfsPackDescription dfsPackDescription = (DfsPackDescription) obj;
            if (this.packName.equals(dfsPackDescription.packName) && getRepositoryDescription().equals(dfsPackDescription.getRepositoryDescription())) {
                return true;
            }
        }
        return false;
    }

    static boolean isGC(DfsObjDatabase.PackSource packSource) {
        int i = $SWITCH_TABLE$org$eclipse$jgit$internal$storage$dfs$DfsObjDatabase$PackSource()[packSource.ordinal()];
        return i == 4 || i == 5;
    }

    public String toString() {
        return getFileName(PackExt.PACK);
    }
}

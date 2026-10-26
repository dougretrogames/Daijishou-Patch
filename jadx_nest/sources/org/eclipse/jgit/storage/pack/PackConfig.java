package org.eclipse.jgit.storage.pack;

import java.time.Duration;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Repository;

/* INFO: loaded from: classes5.dex */
public class PackConfig {
    public static final int DEFAULT_BIG_FILE_THRESHOLD = 52428800;
    public static final int DEFAULT_BITMAP_CONTIGUOUS_COMMIT_COUNT = 100;
    public static final int DEFAULT_BITMAP_DISTANT_COMMIT_SPAN = 5000;
    public static final int DEFAULT_BITMAP_EXCESSIVE_BRANCH_COUNT = 100;
    public static final int DEFAULT_BITMAP_EXCESSIVE_BRANCH_TIP_COUNT = Integer.MAX_VALUE;
    public static final int DEFAULT_BITMAP_INACTIVE_BRANCH_AGE_IN_DAYS = 90;
    public static final int DEFAULT_BITMAP_RECENT_COMMIT_COUNT = 20000;
    public static final int DEFAULT_BITMAP_RECENT_COMMIT_SPAN = 100;
    public static final boolean DEFAULT_BUILD_BITMAPS = true;
    public static final boolean DEFAULT_DELTA_BASE_AS_OFFSET = false;
    public static final int DEFAULT_DELTA_CACHE_LIMIT = 100;
    public static final long DEFAULT_DELTA_CACHE_SIZE = 52428800;
    public static final boolean DEFAULT_DELTA_COMPRESS = true;
    public static final int DEFAULT_DELTA_SEARCH_WINDOW_SIZE = 10;
    public static final int DEFAULT_INDEX_VERSION = 2;
    public static final int DEFAULT_MAX_DELTA_DEPTH = 50;
    public static final long DEFAULT_MINSIZE_PREVENT_RACY_PACK = 104857600;
    public static final int DEFAULT_MIN_BYTES_FOR_OBJ_SIZE_INDEX = -1;
    public static final boolean DEFAULT_PACK_KEPT_OBJECTS = false;
    public static final boolean DEFAULT_PRESERVE_OLD_PACKS = false;
    public static final boolean DEFAULT_PRUNE_PRESERVED = false;
    public static final boolean DEFAULT_REUSE_DELTAS = true;
    public static final boolean DEFAULT_REUSE_OBJECTS = true;
    public static final boolean DEFAULT_WAIT_PREVENT_RACY_PACK = false;
    public static final boolean DEFAULT_WRITE_REVERSE_INDEX = false;
    private static final int MB = 1048576;
    private int bigFileThreshold;
    private int bitmapContiguousCommitCount;
    private int bitmapDistantCommitSpan;
    private int bitmapExcessiveBranchCount;
    private int bitmapExcessiveBranchTipCount;
    private String[] bitmapExcludedRefsPrefixes;
    private int bitmapInactiveBranchAgeInDays;
    private int bitmapRecentCommitCount;
    private int bitmapRecentCommitSpan;
    private boolean buildBitmaps;
    private int compressionLevel;
    private boolean cutDeltaChains;
    private boolean deltaBaseAsOffset;
    private int deltaCacheLimit;
    private long deltaCacheSize;
    private boolean deltaCompress;
    private long deltaSearchMemoryLimit;
    private int deltaSearchWindowSize;
    private Executor executor;
    private int indexVersion;
    private int maxDeltaDepth;
    private int minBytesForObjSizeIndex;
    private long minSizePreventRacyPack;
    private boolean packKeptObjects;
    private boolean preserveOldPacks;
    private boolean prunePreserved;
    private boolean reuseDeltas;
    private boolean reuseObjects;
    private Duration searchForReuseTimeout;
    private boolean singlePack;
    private int threads;
    private boolean waitPreventRacyPack;
    private boolean writeReverseIndex;
    public static final String[] DEFAULT_BITMAP_EXCLUDED_REFS_PREFIXES = new String[0];
    public static final Duration DEFAULT_SEARCH_FOR_REUSE_TIMEOUT = Duration.ofSeconds(2147483647L);

    public PackConfig() {
        this.compressionLevel = -1;
        this.reuseDeltas = true;
        this.reuseObjects = true;
        this.preserveOldPacks = false;
        this.prunePreserved = false;
        this.deltaBaseAsOffset = false;
        this.deltaCompress = true;
        this.maxDeltaDepth = 50;
        this.deltaSearchWindowSize = 10;
        this.deltaCacheSize = DEFAULT_DELTA_CACHE_SIZE;
        this.deltaCacheLimit = 100;
        this.bigFileThreshold = DEFAULT_BIG_FILE_THRESHOLD;
        this.waitPreventRacyPack = false;
        this.minSizePreventRacyPack = DEFAULT_MINSIZE_PREVENT_RACY_PACK;
        this.indexVersion = 2;
        this.writeReverseIndex = false;
        this.buildBitmaps = true;
        this.packKeptObjects = false;
        this.bitmapContiguousCommitCount = 100;
        this.bitmapRecentCommitCount = 20000;
        this.bitmapRecentCommitSpan = 100;
        this.bitmapDistantCommitSpan = DEFAULT_BITMAP_DISTANT_COMMIT_SPAN;
        this.bitmapExcessiveBranchCount = 100;
        this.bitmapExcessiveBranchTipCount = Integer.MAX_VALUE;
        this.bitmapInactiveBranchAgeInDays = 90;
        this.bitmapExcludedRefsPrefixes = DEFAULT_BITMAP_EXCLUDED_REFS_PREFIXES;
        this.searchForReuseTimeout = DEFAULT_SEARCH_FOR_REUSE_TIMEOUT;
        this.minBytesForObjSizeIndex = -1;
    }

    public PackConfig(Repository repository) {
        this.compressionLevel = -1;
        this.reuseDeltas = true;
        this.reuseObjects = true;
        this.preserveOldPacks = false;
        this.prunePreserved = false;
        this.deltaBaseAsOffset = false;
        this.deltaCompress = true;
        this.maxDeltaDepth = 50;
        this.deltaSearchWindowSize = 10;
        this.deltaCacheSize = DEFAULT_DELTA_CACHE_SIZE;
        this.deltaCacheLimit = 100;
        this.bigFileThreshold = DEFAULT_BIG_FILE_THRESHOLD;
        this.waitPreventRacyPack = false;
        this.minSizePreventRacyPack = DEFAULT_MINSIZE_PREVENT_RACY_PACK;
        this.indexVersion = 2;
        this.writeReverseIndex = false;
        this.buildBitmaps = true;
        this.packKeptObjects = false;
        this.bitmapContiguousCommitCount = 100;
        this.bitmapRecentCommitCount = 20000;
        this.bitmapRecentCommitSpan = 100;
        this.bitmapDistantCommitSpan = DEFAULT_BITMAP_DISTANT_COMMIT_SPAN;
        this.bitmapExcessiveBranchCount = 100;
        this.bitmapExcessiveBranchTipCount = Integer.MAX_VALUE;
        this.bitmapInactiveBranchAgeInDays = 90;
        this.bitmapExcludedRefsPrefixes = DEFAULT_BITMAP_EXCLUDED_REFS_PREFIXES;
        this.searchForReuseTimeout = DEFAULT_SEARCH_FOR_REUSE_TIMEOUT;
        this.minBytesForObjSizeIndex = -1;
        fromConfig(repository.getConfig());
    }

    public PackConfig(Config config) {
        this.compressionLevel = -1;
        this.reuseDeltas = true;
        this.reuseObjects = true;
        this.preserveOldPacks = false;
        this.prunePreserved = false;
        this.deltaBaseAsOffset = false;
        this.deltaCompress = true;
        this.maxDeltaDepth = 50;
        this.deltaSearchWindowSize = 10;
        this.deltaCacheSize = DEFAULT_DELTA_CACHE_SIZE;
        this.deltaCacheLimit = 100;
        this.bigFileThreshold = DEFAULT_BIG_FILE_THRESHOLD;
        this.waitPreventRacyPack = false;
        this.minSizePreventRacyPack = DEFAULT_MINSIZE_PREVENT_RACY_PACK;
        this.indexVersion = 2;
        this.writeReverseIndex = false;
        this.buildBitmaps = true;
        this.packKeptObjects = false;
        this.bitmapContiguousCommitCount = 100;
        this.bitmapRecentCommitCount = 20000;
        this.bitmapRecentCommitSpan = 100;
        this.bitmapDistantCommitSpan = DEFAULT_BITMAP_DISTANT_COMMIT_SPAN;
        this.bitmapExcessiveBranchCount = 100;
        this.bitmapExcessiveBranchTipCount = Integer.MAX_VALUE;
        this.bitmapInactiveBranchAgeInDays = 90;
        this.bitmapExcludedRefsPrefixes = DEFAULT_BITMAP_EXCLUDED_REFS_PREFIXES;
        this.searchForReuseTimeout = DEFAULT_SEARCH_FOR_REUSE_TIMEOUT;
        this.minBytesForObjSizeIndex = -1;
        fromConfig(config);
    }

    public PackConfig(PackConfig packConfig) {
        this.compressionLevel = -1;
        this.reuseDeltas = true;
        this.reuseObjects = true;
        this.preserveOldPacks = false;
        this.prunePreserved = false;
        this.deltaBaseAsOffset = false;
        this.deltaCompress = true;
        this.maxDeltaDepth = 50;
        this.deltaSearchWindowSize = 10;
        this.deltaCacheSize = DEFAULT_DELTA_CACHE_SIZE;
        this.deltaCacheLimit = 100;
        this.bigFileThreshold = DEFAULT_BIG_FILE_THRESHOLD;
        this.waitPreventRacyPack = false;
        this.minSizePreventRacyPack = DEFAULT_MINSIZE_PREVENT_RACY_PACK;
        this.indexVersion = 2;
        this.writeReverseIndex = false;
        this.buildBitmaps = true;
        this.packKeptObjects = false;
        this.bitmapContiguousCommitCount = 100;
        this.bitmapRecentCommitCount = 20000;
        this.bitmapRecentCommitSpan = 100;
        this.bitmapDistantCommitSpan = DEFAULT_BITMAP_DISTANT_COMMIT_SPAN;
        this.bitmapExcessiveBranchCount = 100;
        this.bitmapExcessiveBranchTipCount = Integer.MAX_VALUE;
        this.bitmapInactiveBranchAgeInDays = 90;
        this.bitmapExcludedRefsPrefixes = DEFAULT_BITMAP_EXCLUDED_REFS_PREFIXES;
        this.searchForReuseTimeout = DEFAULT_SEARCH_FOR_REUSE_TIMEOUT;
        this.minBytesForObjSizeIndex = -1;
        this.compressionLevel = packConfig.compressionLevel;
        this.reuseDeltas = packConfig.reuseDeltas;
        this.reuseObjects = packConfig.reuseObjects;
        this.preserveOldPacks = packConfig.preserveOldPacks;
        this.prunePreserved = packConfig.prunePreserved;
        this.deltaBaseAsOffset = packConfig.deltaBaseAsOffset;
        this.deltaCompress = packConfig.deltaCompress;
        this.maxDeltaDepth = packConfig.maxDeltaDepth;
        this.deltaSearchWindowSize = packConfig.deltaSearchWindowSize;
        this.deltaSearchMemoryLimit = packConfig.deltaSearchMemoryLimit;
        this.deltaCacheSize = packConfig.deltaCacheSize;
        this.deltaCacheLimit = packConfig.deltaCacheLimit;
        this.bigFileThreshold = packConfig.bigFileThreshold;
        this.waitPreventRacyPack = packConfig.waitPreventRacyPack;
        this.minSizePreventRacyPack = packConfig.minSizePreventRacyPack;
        this.threads = packConfig.threads;
        this.executor = packConfig.executor;
        this.indexVersion = packConfig.indexVersion;
        this.writeReverseIndex = packConfig.writeReverseIndex;
        this.buildBitmaps = packConfig.buildBitmaps;
        this.packKeptObjects = packConfig.packKeptObjects;
        this.bitmapContiguousCommitCount = packConfig.bitmapContiguousCommitCount;
        this.bitmapRecentCommitCount = packConfig.bitmapRecentCommitCount;
        this.bitmapRecentCommitSpan = packConfig.bitmapRecentCommitSpan;
        this.bitmapDistantCommitSpan = packConfig.bitmapDistantCommitSpan;
        this.bitmapExcessiveBranchCount = packConfig.bitmapExcessiveBranchCount;
        this.bitmapInactiveBranchAgeInDays = packConfig.bitmapInactiveBranchAgeInDays;
        this.cutDeltaChains = packConfig.cutDeltaChains;
        this.singlePack = packConfig.singlePack;
        this.searchForReuseTimeout = packConfig.searchForReuseTimeout;
        this.minBytesForObjSizeIndex = packConfig.minBytesForObjSizeIndex;
    }

    public boolean isReuseDeltas() {
        return this.reuseDeltas;
    }

    public void setReuseDeltas(boolean z) {
        this.reuseDeltas = z;
    }

    public boolean isReuseObjects() {
        return this.reuseObjects;
    }

    public void setReuseObjects(boolean z) {
        this.reuseObjects = z;
    }

    public boolean isPreserveOldPacks() {
        return this.preserveOldPacks;
    }

    public void setPreserveOldPacks(boolean z) {
        this.preserveOldPacks = z;
    }

    public boolean isPrunePreserved() {
        return this.prunePreserved;
    }

    public void setPrunePreserved(boolean z) {
        this.prunePreserved = z;
    }

    public boolean isDeltaBaseAsOffset() {
        return this.deltaBaseAsOffset;
    }

    public void setDeltaBaseAsOffset(boolean z) {
        this.deltaBaseAsOffset = z;
    }

    public boolean isDeltaCompress() {
        return this.deltaCompress;
    }

    public void setDeltaCompress(boolean z) {
        this.deltaCompress = z;
    }

    public int getMaxDeltaDepth() {
        return this.maxDeltaDepth;
    }

    public void setMaxDeltaDepth(int i) {
        this.maxDeltaDepth = i;
    }

    public boolean getCutDeltaChains() {
        return this.cutDeltaChains;
    }

    public void setCutDeltaChains(boolean z) {
        this.cutDeltaChains = z;
    }

    public boolean getSinglePack() {
        return this.singlePack;
    }

    public void setSinglePack(boolean z) {
        this.singlePack = z;
    }

    public int getDeltaSearchWindowSize() {
        return this.deltaSearchWindowSize;
    }

    public void setDeltaSearchWindowSize(int i) {
        if (i <= 2) {
            setDeltaCompress(false);
        } else {
            this.deltaSearchWindowSize = i;
        }
    }

    public long getDeltaSearchMemoryLimit() {
        return this.deltaSearchMemoryLimit;
    }

    public void setDeltaSearchMemoryLimit(long j) {
        this.deltaSearchMemoryLimit = j;
    }

    public long getDeltaCacheSize() {
        return this.deltaCacheSize;
    }

    public void setDeltaCacheSize(long j) {
        this.deltaCacheSize = j;
    }

    public int getDeltaCacheLimit() {
        return this.deltaCacheLimit;
    }

    public void setDeltaCacheLimit(int i) {
        this.deltaCacheLimit = i;
    }

    public int getBigFileThreshold() {
        return this.bigFileThreshold;
    }

    public void setBigFileThreshold(int i) {
        this.bigFileThreshold = i;
    }

    public boolean isWaitPreventRacyPack() {
        return this.waitPreventRacyPack;
    }

    public boolean doWaitPreventRacyPack(long j) {
        return isWaitPreventRacyPack() && j > getMinSizePreventRacyPack();
    }

    public void setWaitPreventRacyPack(boolean z) {
        this.waitPreventRacyPack = z;
    }

    public long getMinSizePreventRacyPack() {
        return this.minSizePreventRacyPack;
    }

    public void setMinSizePreventRacyPack(long j) {
        this.minSizePreventRacyPack = j;
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public void setCompressionLevel(int i) {
        this.compressionLevel = i;
    }

    public int getThreads() {
        return this.threads;
    }

    public void setThreads(int i) {
        this.threads = i;
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public int getIndexVersion() {
        return this.indexVersion;
    }

    public void setIndexVersion(int i) {
        this.indexVersion = i;
    }

    public boolean isWriteReverseIndex() {
        return this.writeReverseIndex;
    }

    public void setWriteReverseIndex(boolean z) {
        this.writeReverseIndex = z;
    }

    public boolean isBuildBitmaps() {
        return this.buildBitmaps;
    }

    public void setBuildBitmaps(boolean z) {
        this.buildBitmaps = z;
    }

    public void setPackKeptObjects(boolean z) {
        this.packKeptObjects = z;
    }

    public boolean isPackKeptObjects() {
        return this.packKeptObjects;
    }

    public int getBitmapContiguousCommitCount() {
        return this.bitmapContiguousCommitCount;
    }

    public void setBitmapContiguousCommitCount(int i) {
        this.bitmapContiguousCommitCount = i;
    }

    public int getBitmapRecentCommitCount() {
        return this.bitmapRecentCommitCount;
    }

    public void setBitmapRecentCommitCount(int i) {
        this.bitmapRecentCommitCount = i;
    }

    public int getBitmapRecentCommitSpan() {
        return this.bitmapRecentCommitSpan;
    }

    public void setBitmapRecentCommitSpan(int i) {
        this.bitmapRecentCommitSpan = i;
    }

    public int getBitmapDistantCommitSpan() {
        return this.bitmapDistantCommitSpan;
    }

    public void setBitmapDistantCommitSpan(int i) {
        this.bitmapDistantCommitSpan = i;
    }

    public int getBitmapExcessiveBranchCount() {
        return this.bitmapExcessiveBranchCount;
    }

    public void setBitmapExcessiveBranchCount(int i) {
        this.bitmapExcessiveBranchCount = i;
    }

    public int getBitmapExcessiveBranchTipCount() {
        return this.bitmapExcessiveBranchTipCount;
    }

    public void setBitmapExcessiveBranchTipCount(int i) {
        this.bitmapExcessiveBranchTipCount = i;
    }

    public int getBitmapInactiveBranchAgeInDays() {
        return this.bitmapInactiveBranchAgeInDays;
    }

    public Duration getSearchForReuseTimeout() {
        return this.searchForReuseTimeout;
    }

    public void setBitmapInactiveBranchAgeInDays(int i) {
        this.bitmapInactiveBranchAgeInDays = i;
    }

    public String[] getBitmapExcludedRefsPrefixes() {
        return this.bitmapExcludedRefsPrefixes;
    }

    public void setBitmapExcludedRefsPrefixes(String[] strArr) {
        this.bitmapExcludedRefsPrefixes = strArr;
    }

    public void setSearchForReuseTimeout(Duration duration) {
        this.searchForReuseTimeout = duration;
    }

    public int getMinBytesForObjSizeIndex() {
        return this.minBytesForObjSizeIndex;
    }

    public void setMinBytesForObjSizeIndex(int i) {
        this.minBytesForObjSizeIndex = i;
    }

    public boolean isWriteObjSizeIndex() {
        return this.minBytesForObjSizeIndex >= 0;
    }

    public void fromConfig(Config config) {
        setMaxDeltaDepth(config.getInt(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_DEPTH, getMaxDeltaDepth()));
        setDeltaSearchWindowSize(config.getInt(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_WINDOW, getDeltaSearchWindowSize()));
        setDeltaSearchMemoryLimit(config.getLong(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_WINDOW_MEMORY, getDeltaSearchMemoryLimit()));
        setDeltaCacheSize(config.getLong(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_DELTA_CACHE_SIZE, getDeltaCacheSize()));
        setDeltaCacheLimit(config.getInt(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_DELTA_CACHE_LIMIT, getDeltaCacheLimit()));
        setCompressionLevel(config.getInt(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_COMPRESSION, config.getInt(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_KEY_COMPRESSION, getCompressionLevel())));
        setIndexVersion(config.getInt(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_INDEXVERSION, getIndexVersion()));
        setBigFileThreshold(config.getInt(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_KEY_BIGFILE_THRESHOLD, getBigFileThreshold()));
        setThreads(config.getInt(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_THREADS, getThreads()));
        setReuseDeltas(config.getBoolean(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_REUSE_DELTAS, isReuseDeltas()));
        setReuseObjects(config.getBoolean(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_REUSE_OBJECTS, isReuseObjects()));
        setDeltaCompress(config.getBoolean(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_DELTA_COMPRESSION, isDeltaCompress()));
        setCutDeltaChains(config.getBoolean(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_CUT_DELTACHAINS, getCutDeltaChains()));
        setSinglePack(config.getBoolean(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_SINGLE_PACK, getSinglePack()));
        setWriteReverseIndex(config.getBoolean(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_WRITE_REVERSE_INDEX, isWriteReverseIndex()));
        boolean z = config.getBoolean(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_BUILD_BITMAPS, isBuildBitmaps());
        setBuildBitmaps(z);
        setPackKeptObjects(config.getBoolean(ConfigConstants.CONFIG_REPACK_SECTION, ConfigConstants.CONFIG_KEY_PACK_KEPT_OBJECTS, z || isPackKeptObjects()));
        setBitmapContiguousCommitCount(config.getInt(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_BITMAP_CONTIGUOUS_COMMIT_COUNT, getBitmapContiguousCommitCount()));
        setBitmapRecentCommitCount(config.getInt(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_BITMAP_RECENT_COMMIT_COUNT, getBitmapRecentCommitCount()));
        setBitmapRecentCommitSpan(config.getInt(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_BITMAP_RECENT_COMMIT_COUNT, getBitmapRecentCommitSpan()));
        setBitmapDistantCommitSpan(config.getInt(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_BITMAP_DISTANT_COMMIT_SPAN, getBitmapDistantCommitSpan()));
        setBitmapExcessiveBranchCount(config.getInt(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_BITMAP_EXCESSIVE_BRANCH_COUNT, getBitmapExcessiveBranchCount()));
        setBitmapExcessiveBranchTipCount(config.getInt(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_BITMAP_EXCESSIVE_BRANCH_TIP_COUNT, getBitmapExcessiveBranchTipCount()));
        setBitmapInactiveBranchAgeInDays(config.getInt(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_BITMAP_INACTIVE_BRANCH_AGE_INDAYS, getBitmapInactiveBranchAgeInDays()));
        String[] stringList = config.getStringList(ConfigConstants.CONFIG_PACK_SECTION, null, ConfigConstants.CONFIG_KEY_BITMAP_EXCLUDED_REFS_PREFIXES);
        if (stringList.length > 0) {
            setBitmapExcludedRefsPrefixes(stringList);
        }
        setSearchForReuseTimeout(Duration.ofSeconds(config.getTimeUnit(ConfigConstants.CONFIG_PACK_SECTION, null, ConfigConstants.CONFIG_KEY_SEARCH_FOR_REUSE_TIMEOUT, getSearchForReuseTimeout().getSeconds(), TimeUnit.SECONDS)));
        setWaitPreventRacyPack(config.getBoolean(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_WAIT_PREVENT_RACYPACK, isWaitPreventRacyPack()));
        setMinSizePreventRacyPack(config.getLong(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_MIN_SIZE_PREVENT_RACYPACK, getMinSizePreventRacyPack()));
        setMinBytesForObjSizeIndex(config.getInt(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_MIN_BYTES_OBJ_SIZE_INDEX, -1));
        setPreserveOldPacks(config.getBoolean(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_PRESERVE_OLD_PACKS, false));
        setPrunePreserved(config.getBoolean(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_PRUNE_PRESERVED, false));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("maxDeltaDepth=");
        sb.append(getMaxDeltaDepth());
        sb.append(", deltaSearchWindowSize=").append(getDeltaSearchWindowSize());
        sb.append(", deltaSearchMemoryLimit=").append(getDeltaSearchMemoryLimit());
        sb.append(", deltaCacheSize=").append(getDeltaCacheSize());
        sb.append(", deltaCacheLimit=").append(getDeltaCacheLimit());
        sb.append(", compressionLevel=").append(getCompressionLevel());
        sb.append(", indexVersion=").append(getIndexVersion());
        sb.append(", bigFileThreshold=").append(getBigFileThreshold());
        sb.append(", threads=").append(getThreads());
        sb.append(", reuseDeltas=").append(isReuseDeltas());
        sb.append(", reuseObjects=").append(isReuseObjects());
        sb.append(", deltaCompress=").append(isDeltaCompress());
        sb.append(", writeReverseIndex=").append(isWriteReverseIndex());
        sb.append(", buildBitmaps=").append(isBuildBitmaps());
        sb.append(", bitmapContiguousCommitCount=").append(getBitmapContiguousCommitCount());
        sb.append(", bitmapRecentCommitCount=").append(getBitmapRecentCommitCount());
        sb.append(", bitmapRecentCommitSpan=").append(getBitmapRecentCommitSpan());
        sb.append(", bitmapDistantCommitSpan=").append(getBitmapDistantCommitSpan());
        sb.append(", bitmapExcessiveBranchCount=").append(getBitmapExcessiveBranchCount());
        sb.append(", bitmapInactiveBranchAge=").append(getBitmapInactiveBranchAgeInDays());
        sb.append(", searchForReuseTimeout").append(getSearchForReuseTimeout());
        sb.append(", singlePack=").append(getSinglePack());
        sb.append(", minBytesForObjSizeIndex=").append(getMinBytesForObjSizeIndex());
        return sb.toString();
    }
}

package org.eclipse.jgit.storage.file;

import com.google.api.client.googleapis.media.MediaHttpUploader;
import org.eclipse.jgit.internal.storage.file.WindowCache;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.storage.pack.PackConfig;

/* JADX INFO: loaded from: classes5.dex */
public class WindowCacheConfig {
    public static final int KB = 1024;
    public static final int MB = 1048576;
    private int packedGitOpenFiles = 128;
    private long packedGitLimit = 10485760;
    private boolean useStrongRefs = false;
    private boolean useStrongIndexRefs = true;
    private int packedGitWindowSize = 8192;
    private boolean packedGitMMAP = false;
    private int deltaBaseCacheLimit = MediaHttpUploader.DEFAULT_CHUNK_SIZE;
    private int streamFileThreshold = PackConfig.DEFAULT_BIG_FILE_THRESHOLD;
    private boolean exposeStats = true;

    public int getPackedGitOpenFiles() {
        return this.packedGitOpenFiles;
    }

    public void setPackedGitOpenFiles(int i) {
        this.packedGitOpenFiles = i;
    }

    public long getPackedGitLimit() {
        return this.packedGitLimit;
    }

    public void setPackedGitLimit(long j) {
        this.packedGitLimit = j;
    }

    public boolean isPackedGitUseStrongRefs() {
        return this.useStrongRefs;
    }

    public void setPackedGitUseStrongRefs(boolean z) {
        this.useStrongRefs = z;
    }

    public boolean isPackedIndexGitUseStrongRefs() {
        return this.useStrongIndexRefs;
    }

    public void setPackedIndexGitUseStrongRefs(boolean z) {
        this.useStrongIndexRefs = z;
    }

    public int getPackedGitWindowSize() {
        return this.packedGitWindowSize;
    }

    public void setPackedGitWindowSize(int i) {
        this.packedGitWindowSize = i;
    }

    public boolean isPackedGitMMAP() {
        return this.packedGitMMAP;
    }

    public void setPackedGitMMAP(boolean z) {
        this.packedGitMMAP = z;
    }

    public int getDeltaBaseCacheLimit() {
        return this.deltaBaseCacheLimit;
    }

    public void setDeltaBaseCacheLimit(int i) {
        this.deltaBaseCacheLimit = i;
    }

    public int getStreamFileThreshold() {
        return this.streamFileThreshold;
    }

    public void setStreamFileThreshold(int i) {
        this.streamFileThreshold = i;
    }

    public boolean getExposeStatsViaJmx() {
        return this.exposeStats;
    }

    public void setExposeStatsViaJmx(boolean z) {
        this.exposeStats = z;
    }

    public WindowCacheConfig fromConfig(Config config) {
        setPackedGitUseStrongRefs(config.getBoolean(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_KEY_PACKED_GIT_USE_STRONGREFS, isPackedGitUseStrongRefs()));
        setPackedIndexGitUseStrongRefs(config.getBoolean(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_KEY_PACKED_INDEX_GIT_USE_STRONGREFS, isPackedIndexGitUseStrongRefs()));
        setPackedGitOpenFiles(config.getInt(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_PACKED_GIT_OPENFILES, getPackedGitOpenFiles()));
        setPackedGitLimit(config.getLong(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_PACKED_GIT_LIMIT, getPackedGitLimit()));
        setPackedGitWindowSize(config.getInt(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_PACKED_GIT_WINDOWSIZE, getPackedGitWindowSize()));
        setPackedGitMMAP(config.getBoolean(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_PACKED_GIT_MMAP, isPackedGitMMAP()));
        setDeltaBaseCacheLimit(config.getInt(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_DELTA_BASE_CACHE_LIMIT, getDeltaBaseCacheLimit()));
        setStreamFileThreshold((int) Math.min(Math.min(config.getLong(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_STREAM_FILE_THRESHOLD, getStreamFileThreshold()), Runtime.getRuntime().maxMemory() / 4), 2147483647L));
        return this;
    }

    public void install() {
        WindowCache.reconfigure(this);
    }
}

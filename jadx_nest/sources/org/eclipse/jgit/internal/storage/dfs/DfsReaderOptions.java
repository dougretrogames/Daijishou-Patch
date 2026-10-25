package org.eclipse.jgit.internal.storage.dfs;

import com.google.api.client.googleapis.media.MediaHttpUploader;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.storage.pack.PackConfig;

/* JADX INFO: loaded from: classes5.dex */
public class DfsReaderOptions {
    public static final int KiB = 1024;
    public static final int MiB = 1048576;
    private int deltaBaseCacheLimit;
    private boolean loadRevIndexInParallel;
    private int streamFileThreshold;
    private int streamPackBufferSize;
    private boolean useObjectSizeIndex;

    public DfsReaderOptions() {
        setDeltaBaseCacheLimit(MediaHttpUploader.DEFAULT_CHUNK_SIZE);
        setStreamFileThreshold(PackConfig.DEFAULT_BIG_FILE_THRESHOLD);
    }

    public int getDeltaBaseCacheLimit() {
        return this.deltaBaseCacheLimit;
    }

    public DfsReaderOptions setDeltaBaseCacheLimit(int i) {
        this.deltaBaseCacheLimit = Math.max(0, i);
        return this;
    }

    public int getStreamFileThreshold() {
        return this.streamFileThreshold;
    }

    public DfsReaderOptions setStreamFileThreshold(int i) {
        this.streamFileThreshold = Math.max(0, i);
        return this;
    }

    public int getStreamPackBufferSize() {
        return this.streamPackBufferSize;
    }

    public DfsReaderOptions setStreamPackBufferSize(int i) {
        this.streamPackBufferSize = Math.max(0, i);
        return this;
    }

    public boolean shouldLoadRevIndexInParallel() {
        return this.loadRevIndexInParallel;
    }

    public DfsReaderOptions setLoadRevIndexInParallel(boolean z) {
        this.loadRevIndexInParallel = z;
        return this;
    }

    public boolean shouldUseObjectSizeIndex() {
        return this.useObjectSizeIndex;
    }

    public DfsReaderOptions setUseObjectSizeIndex(boolean z) {
        this.useObjectSizeIndex = z;
        return this;
    }

    public DfsReaderOptions fromConfig(Config config) {
        setDeltaBaseCacheLimit(config.getInt(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_DFS_SECTION, ConfigConstants.CONFIG_KEY_DELTA_BASE_CACHE_LIMIT, getDeltaBaseCacheLimit()));
        setStreamFileThreshold((int) Math.min(Math.min(config.getLong(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_DFS_SECTION, ConfigConstants.CONFIG_KEY_STREAM_FILE_THRESHOLD, getStreamFileThreshold()), Runtime.getRuntime().maxMemory() / 4), 2147483647L));
        setStreamPackBufferSize(config.getInt(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_DFS_SECTION, ConfigConstants.CONFIG_KEY_STREAM_BUFFER, getStreamPackBufferSize()));
        setUseObjectSizeIndex(config.getBoolean(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_DFS_SECTION, ConfigConstants.CONFIG_KEY_USE_OBJECT_SIZE_INDEX, false));
        setLoadRevIndexInParallel(config.getBoolean(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_DFS_SECTION, ConfigConstants.CONFIG_KEY_LOAD_REV_INDEX_IN_PARALLEL, false));
        return this;
    }
}

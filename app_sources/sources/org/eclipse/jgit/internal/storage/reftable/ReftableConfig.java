package org.eclipse.jgit.internal.storage.reftable;

import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Repository;

/* INFO: loaded from: classes5.dex */
public class ReftableConfig {
    private boolean alignBlocks;
    private boolean indexObjects;
    private int logBlockSize;
    private int maxIndexLevels;
    private int refBlockSize;
    private int restartInterval;

    public ReftableConfig() {
        this.refBlockSize = 4096;
        this.alignBlocks = true;
        this.indexObjects = true;
    }

    public ReftableConfig(Repository repository) {
        this.refBlockSize = 4096;
        this.alignBlocks = true;
        this.indexObjects = true;
        fromConfig(repository.getConfig());
    }

    public ReftableConfig(Config config) {
        this.refBlockSize = 4096;
        this.alignBlocks = true;
        this.indexObjects = true;
        fromConfig(config);
    }

    public ReftableConfig(ReftableConfig reftableConfig) {
        this.refBlockSize = 4096;
        this.alignBlocks = true;
        this.indexObjects = true;
        this.refBlockSize = reftableConfig.refBlockSize;
        this.logBlockSize = reftableConfig.logBlockSize;
        this.restartInterval = reftableConfig.restartInterval;
        this.maxIndexLevels = reftableConfig.maxIndexLevels;
        this.alignBlocks = reftableConfig.alignBlocks;
        this.indexObjects = reftableConfig.indexObjects;
    }

    public int getRefBlockSize() {
        return this.refBlockSize;
    }

    public void setRefBlockSize(int i) {
        if (i > 16777215) {
            throw new IllegalArgumentException();
        }
        this.refBlockSize = Math.max(0, i);
    }

    public int getLogBlockSize() {
        return this.logBlockSize;
    }

    public void setLogBlockSize(int i) {
        if (i > 16777215) {
            throw new IllegalArgumentException();
        }
        this.logBlockSize = Math.max(0, i);
    }

    public int getRestartInterval() {
        return this.restartInterval;
    }

    public void setRestartInterval(int i) {
        this.restartInterval = Math.max(0, i);
    }

    public int getMaxIndexLevels() {
        return this.maxIndexLevels;
    }

    public void setMaxIndexLevels(int i) {
        this.maxIndexLevels = Math.max(0, i);
    }

    public boolean isAlignBlocks() {
        return this.alignBlocks;
    }

    public void setAlignBlocks(boolean z) {
        this.alignBlocks = z;
    }

    public boolean isIndexObjects() {
        return this.indexObjects;
    }

    public void setIndexObjects(boolean z) {
        this.indexObjects = z;
    }

    public void fromConfig(Config config) {
        this.refBlockSize = config.getInt("reftable", ConfigConstants.CONFIG_KEY_BLOCK_SIZE, this.refBlockSize);
        this.logBlockSize = config.getInt("reftable", "logBlockSize", this.logBlockSize);
        this.restartInterval = config.getInt("reftable", "restartInterval", this.restartInterval);
        this.maxIndexLevels = config.getInt("reftable", "indexLevels", this.maxIndexLevels);
        this.alignBlocks = config.getBoolean("reftable", "alignBlocks", this.alignBlocks);
        this.indexObjects = config.getBoolean("reftable", "indexObjects", this.indexObjects);
    }
}

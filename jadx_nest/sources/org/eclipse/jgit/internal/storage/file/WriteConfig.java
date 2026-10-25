package org.eclipse.jgit.internal.storage.file;

import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.CoreConfig;

/* JADX INFO: loaded from: classes5.dex */
class WriteConfig {
    static final Config.SectionParser<WriteConfig> KEY = new WriteConfig$$ExternalSyntheticLambda0();
    private final int compression;
    private final boolean fsyncObjectFiles;
    private final boolean fsyncRefFiles;

    /* JADX INFO: renamed from: $r8$lambda$Jvi1kV91dCICiT-MjJBZL5tdF5c, reason: not valid java name */
    public static /* synthetic */ WriteConfig m5736$r8$lambda$Jvi1kV91dCICiTMjJBZL5tdF5c(Config config) {
        return new WriteConfig(config);
    }

    private WriteConfig(Config config) {
        this.compression = ((CoreConfig) config.get(CoreConfig.KEY)).getCompression();
        this.fsyncObjectFiles = config.getBoolean(ConfigConstants.CONFIG_CORE_SECTION, "fsyncobjectfiles", false);
        this.fsyncRefFiles = config.getBoolean(ConfigConstants.CONFIG_CORE_SECTION, "fsyncreffiles", false);
    }

    int getCompression() {
        return this.compression;
    }

    boolean getFSyncObjectFiles() {
        return this.fsyncObjectFiles;
    }

    boolean getFSyncRefFiles() {
        return this.fsyncRefFiles;
    }
}

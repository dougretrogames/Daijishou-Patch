package org.eclipse.jgit.merge;

import java.io.IOException;
import org.eclipse.jgit.api.MergeCommand;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Repository;

/* INFO: loaded from: classes5.dex */
public class MergeConfig {
    private final boolean commit;
    private final MergeCommand.FastForwardMode fastForwardMode;
    private final boolean squash;

    /* synthetic */ MergeConfig(String str, Config config, MergeConfigIA mergeConfigIA) {
        this(str, config);
    }

    public static MergeConfig getConfigForCurrentBranch(Repository repository) {
        try {
            String branch = repository.getBranch();
            if (branch != null) {
                return (MergeConfig) repository.getConfig().get(getParser(branch));
            }
        } catch (IOException unused) {
        }
        return new MergeConfig();
    }

    public static final Config.SectionParser<MergeConfig> getParser(String str) {
        return new MergeConfigSectionParser(str);
    }

    private MergeConfig(String str, Config config) {
        String[] mergeOptions = getMergeOptions(str, config);
        this.fastForwardMode = getFastForwardMode(config, mergeOptions);
        this.squash = isMergeConfigOptionSet("--squash", mergeOptions);
        this.commit = !isMergeConfigOptionSet("--no-commit", mergeOptions);
    }

    private MergeConfig() {
        this.fastForwardMode = MergeCommand.FastForwardMode.FF;
        this.squash = false;
        this.commit = true;
    }

    public MergeCommand.FastForwardMode getFastForwardMode() {
        return this.fastForwardMode;
    }

    public boolean isSquash() {
        return this.squash;
    }

    public boolean isCommit() {
        return this.commit;
    }

    private static MergeCommand.FastForwardMode getFastForwardMode(Config config, String[] strArr) {
        for (String str : strArr) {
            for (MergeCommand.FastForwardMode fastForwardMode : MergeCommand.FastForwardMode.valuesCustom()) {
                if (fastForwardMode.matchConfigValue(str)) {
                    return fastForwardMode;
                }
            }
        }
        return MergeCommand.FastForwardMode.valueOf((MergeCommand.FastForwardMode.Merge) config.getEnum("merge", null, ConfigConstants.CONFIG_KEY_FF, MergeCommand.FastForwardMode.Merge.TRUE));
    }

    private static boolean isMergeConfigOptionSet(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static String[] getMergeOptions(String str, Config config) {
        String string = config.getString(ConfigConstants.CONFIG_BRANCH_SECTION, str, ConfigConstants.CONFIG_KEY_MERGEOPTIONS);
        if (string != null) {
            return string.split("\\s");
        }
        return new String[0];
    }

    private static class MergeConfigSectionParser implements Config.SectionParser<MergeConfig> {
        private final String branch;

        public MergeConfigSectionParser(String str) {
            this.branch = str;
        }

        @Override // org.eclipse.jgit.lib.Config.SectionParser
        public MergeConfig parse(Config config) {
            return new MergeConfig(this.branch, config, null);
        }

        public boolean equals(Object obj) {
            if (obj instanceof MergeConfigSectionParser) {
                return this.branch.equals(((MergeConfigSectionParser) obj).branch);
            }
            return false;
        }

        public int hashCode() {
            return this.branch.hashCode();
        }
    }
}

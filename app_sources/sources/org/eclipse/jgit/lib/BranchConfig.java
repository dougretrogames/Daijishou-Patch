package org.eclipse.jgit.lib;

import java.net.URISyntaxException;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.RemoteConfig;

/* INFO: loaded from: classes5.dex */
public class BranchConfig {
    public static final String LOCAL_REPOSITORY = ".";
    private final String branchName;
    private final Config config;

    /* WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* WARN: Unknown enum class pattern. Please report as an issue! */
    public static class BranchRebaseMode implements Config.ConfigEnum {
        private static final /* synthetic */ BranchRebaseMode[] ENUM$VALUES;
        public static final BranchRebaseMode INTERACTIVE;
        public static final BranchRebaseMode MERGES;
        public static final BranchRebaseMode NONE;
        public static final BranchRebaseMode REBASE;
        private final String configValue;

        /* synthetic */ BranchRebaseMode(String str, int i, String str2, BranchConfigIA branchConfigIA) {
            this(str, i, str2);
        }

        public static BranchRebaseMode valueOf(String str) {
            return (BranchRebaseMode) Enum.valueOf(BranchRebaseMode.class, str);
        }

        public static BranchRebaseMode[] values() {
            BranchRebaseMode[] branchRebaseModeArr = ENUM$VALUES;
            int length = branchRebaseModeArr.length;
            BranchRebaseMode[] branchRebaseModeArr2 = new BranchRebaseMode[length];
            System.arraycopy(branchRebaseModeArr, 0, branchRebaseModeArr2, 0, length);
            return branchRebaseModeArr2;
        }

        static {
            BranchRebaseMode branchRebaseMode = new BranchRebaseMode("REBASE", 0, "true");
            REBASE = branchRebaseMode;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1("MERGES", 1, "merges");
            MERGES = anonymousClass1;
            BranchRebaseMode branchRebaseMode2 = new BranchRebaseMode("INTERACTIVE", 2, "interactive");
            INTERACTIVE = branchRebaseMode2;
            BranchRebaseMode branchRebaseMode3 = new BranchRebaseMode("NONE", 3, "false");
            NONE = branchRebaseMode3;
            ENUM$VALUES = new BranchRebaseMode[]{branchRebaseMode, anonymousClass1, branchRebaseMode2, branchRebaseMode3};
        }

        /* INFO: renamed from: org.eclipse.jgit.lib.BranchConfig$BranchRebaseMode$1, reason: invalid class name */
        final enum AnonymousClass1 extends BranchRebaseMode {
            AnonymousClass1(String str, int i, String str2) {
                super(str, i, str2, null);
            }

            @Override // org.eclipse.jgit.lib.BranchConfig.BranchRebaseMode, org.eclipse.jgit.lib.Config.ConfigEnum
            public boolean matchConfigValue(String str) {
                return super.matchConfigValue(str) || "preserve".equals(str);
            }
        }

        private BranchRebaseMode(String str, int i, String str2) {
            super(str, i);
            this.configValue = str2;
        }

        @Override // org.eclipse.jgit.lib.Config.ConfigEnum
        public String toConfigValue() {
            return this.configValue;
        }

        @Override // org.eclipse.jgit.lib.Config.ConfigEnum
        public boolean matchConfigValue(String str) {
            return this.configValue.equals(str);
        }
    }

    public BranchConfig(Config config, String str) {
        this.config = config;
        this.branchName = str;
    }

    public String getTrackingBranch() {
        String remoteOrDefault = getRemoteOrDefault();
        String merge = getMerge();
        if (remoteOrDefault == null || merge == null) {
            return null;
        }
        return isRemoteLocal() ? merge : findRemoteTrackingBranch(remoteOrDefault, merge);
    }

    public String getRemoteTrackingBranch() {
        String remoteOrDefault = getRemoteOrDefault();
        String merge = getMerge();
        if (remoteOrDefault == null || merge == null) {
            return null;
        }
        return findRemoteTrackingBranch(remoteOrDefault, merge);
    }

    public boolean isRemoteLocal() {
        return LOCAL_REPOSITORY.equals(getRemote());
    }

    public String getRemote() {
        return this.config.getString(ConfigConstants.CONFIG_BRANCH_SECTION, this.branchName, "remote");
    }

    public String getPushRemote() {
        return this.config.getString(ConfigConstants.CONFIG_BRANCH_SECTION, this.branchName, ConfigConstants.CONFIG_KEY_PUSH_REMOTE);
    }

    public String getMerge() {
        return this.config.getString(ConfigConstants.CONFIG_BRANCH_SECTION, this.branchName, "merge");
    }

    public boolean isRebase() {
        return getRebaseMode() != BranchRebaseMode.NONE;
    }

    public BranchRebaseMode getRebaseMode() {
        return (BranchRebaseMode) this.config.getEnum(BranchRebaseMode.values(), ConfigConstants.CONFIG_BRANCH_SECTION, this.branchName, "rebase", BranchRebaseMode.NONE);
    }

    private String findRemoteTrackingBranch(String str, String str2) {
        try {
            for (RefSpec refSpec : new RemoteConfig(this.config, str).getFetchRefSpecs()) {
                if (refSpec.matchSource(str2)) {
                    return refSpec.expandFromSource(str2).getDestination();
                }
            }
            return null;
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    private String getRemoteOrDefault() {
        String remote = getRemote();
        return remote == null ? "origin" : remote;
    }
}

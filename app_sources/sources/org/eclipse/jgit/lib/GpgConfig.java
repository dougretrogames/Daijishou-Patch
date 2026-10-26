package org.eclipse.jgit.lib;

/* INFO: loaded from: classes5.dex */
public class GpgConfig {
    private final boolean forceAnnotated;
    private final GpgFormat keyFormat;
    private final String program;
    private final boolean signAllTags;
    private final boolean signCommits;
    private final String signingKey;
    private final String sshAllowedSignersFile;
    private final String sshDefaultKeyCommand;
    private final String sshRevocationFile;

    public enum GpgFormat implements Config.ConfigEnum {
        OPENPGP("openpgp"),
        X509("x509"),
        SSH("ssh");

        private final String configValue;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static GpgFormat[] valuesCustom() {
            GpgFormat[] gpgFormatArrValuesCustom = values();
            int length = gpgFormatArrValuesCustom.length;
            GpgFormat[] gpgFormatArr = new GpgFormat[length];
            System.arraycopy(gpgFormatArrValuesCustom, 0, gpgFormatArr, 0, length);
            return gpgFormatArr;
        }

        GpgFormat(String str) {
            this.configValue = str;
        }

        @Override // org.eclipse.jgit.lib.Config.ConfigEnum
        public boolean matchConfigValue(String str) {
            return this.configValue.equals(str);
        }

        @Override // org.eclipse.jgit.lib.Config.ConfigEnum
        public String toConfigValue() {
            return this.configValue;
        }
    }

    public GpgConfig(Config config) {
        GpgFormat gpgFormat = (GpgFormat) config.getEnum(GpgFormat.valuesCustom(), ConfigConstants.CONFIG_GPG_SECTION, null, ConfigConstants.CONFIG_KEY_FORMAT, GpgFormat.OPENPGP);
        this.keyFormat = gpgFormat;
        this.signingKey = config.getString(ConfigConstants.CONFIG_USER_SECTION, null, ConfigConstants.CONFIG_KEY_SIGNINGKEY);
        String string = config.getString(ConfigConstants.CONFIG_GPG_SECTION, gpgFormat.toConfigValue(), ConfigConstants.CONFIG_KEY_PROGRAM);
        if (string == null && GpgFormat.OPENPGP.equals(gpgFormat)) {
            string = config.getString(ConfigConstants.CONFIG_GPG_SECTION, null, ConfigConstants.CONFIG_KEY_PROGRAM);
        }
        this.program = string;
        this.signCommits = config.getBoolean("commit", ConfigConstants.CONFIG_KEY_GPGSIGN, false);
        this.signAllTags = config.getBoolean("tag", ConfigConstants.CONFIG_KEY_GPGSIGN, false);
        this.forceAnnotated = config.getBoolean("tag", ConfigConstants.CONFIG_KEY_FORCE_SIGN_ANNOTATED, false);
        this.sshDefaultKeyCommand = config.getString(ConfigConstants.CONFIG_GPG_SECTION, "ssh", ConfigConstants.CONFIG_KEY_SSH_DEFAULT_KEY_COMMAND);
        this.sshAllowedSignersFile = config.getString(ConfigConstants.CONFIG_GPG_SECTION, "ssh", ConfigConstants.CONFIG_KEY_SSH_ALLOWED_SIGNERS_FILE);
        this.sshRevocationFile = config.getString(ConfigConstants.CONFIG_GPG_SECTION, "ssh", ConfigConstants.CONFIG_KEY_SSH_REVOCATION_FILE);
    }

    public GpgFormat getKeyFormat() {
        return this.keyFormat;
    }

    public String getProgram() {
        return this.program;
    }

    public String getSigningKey() {
        return this.signingKey;
    }

    public boolean isSignCommits() {
        return this.signCommits;
    }

    public boolean isSignAllTags() {
        return this.signAllTags;
    }

    public boolean isSignAnnotated() {
        return this.forceAnnotated;
    }

    public String getSshDefaultKeyCommand() {
        return this.sshDefaultKeyCommand;
    }

    public String getSshAllowedSignersFile() {
        return this.sshAllowedSignersFile;
    }

    public String getSshRevocationFile() {
        return this.sshRevocationFile;
    }
}

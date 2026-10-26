package org.eclipse.jgit.transport;

import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: loaded from: classes5.dex */
public class SignedPushConfig {
    public static final Config.SectionParser<SignedPushConfig> KEY = new SignedPushConfig$$ExternalSyntheticLambda0();
    private String certNonceSeed;
    private int certNonceSlopLimit;
    private NonceGenerator nonceGenerator;

    public SignedPushConfig() {
    }

    SignedPushConfig(Config config) {
        setCertNonceSeed(config.getString(ConfigConstants.CONFIG_RECEIVE_SECTION, null, "certnonceseed"));
        this.certNonceSlopLimit = config.getInt(ConfigConstants.CONFIG_RECEIVE_SECTION, "certnonceslop", 0);
    }

    public void setCertNonceSeed(String str) {
        this.certNonceSeed = str;
    }

    public String getCertNonceSeed() {
        return this.certNonceSeed;
    }

    public void setCertNonceSlopLimit(int i) {
        this.certNonceSlopLimit = i;
    }

    public int getCertNonceSlopLimit() {
        return this.certNonceSlopLimit;
    }

    public void setNonceGenerator(NonceGenerator nonceGenerator) {
        this.nonceGenerator = nonceGenerator;
    }

    public NonceGenerator getNonceGenerator() {
        NonceGenerator nonceGenerator = this.nonceGenerator;
        if (nonceGenerator != null) {
            return nonceGenerator;
        }
        if (this.certNonceSeed != null) {
            return new HMACSHA1NonceGenerator(this.certNonceSeed);
        }
        return null;
    }
}

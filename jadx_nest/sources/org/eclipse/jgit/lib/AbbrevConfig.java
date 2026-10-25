package org.eclipse.jgit.lib;

import java.text.MessageFormat;
import org.eclipse.jgit.api.errors.InvalidConfigurationException;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public final class AbbrevConfig {
    public static final int MIN_ABBREV = 4;
    public static final AbbrevConfig NO = new AbbrevConfig(40);
    private static final String VALUE_AUTO = "auto";
    private static final String VALUE_NO = "no";
    private int abbrev;

    public static int capAbbrev(int i) {
        return Math.min(Math.max(4, i), 40);
    }

    public static AbbrevConfig parseFromConfig(Repository repository) throws InvalidConfigurationException {
        StoredConfig config = repository.getConfig();
        String string = config.getString(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_ABBREV);
        if (string == null || string.equalsIgnoreCase("auto")) {
            return auto(repository);
        }
        if (string.equalsIgnoreCase("no")) {
            return NO;
        }
        try {
            int intInRange = config.getIntInRange(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_KEY_ABBREV, 4, 40, Integer.MIN_VALUE);
            if (intInRange == Integer.MIN_VALUE) {
                intInRange = 7;
            }
            return new AbbrevConfig(intInRange);
        } catch (IllegalArgumentException e) {
            throw new InvalidConfigurationException(MessageFormat.format(JGitText.get().invalidCoreAbbrev, string), e);
        }
    }

    private static AbbrevConfig auto(Repository repository) {
        long approximateObjectCount = repository.getObjectDatabase().getApproximateObjectCount();
        if (approximateObjectCount == -1) {
            return new AbbrevConfig(7);
        }
        return new AbbrevConfig(Math.max((65 - Long.numberOfLeadingZeros(approximateObjectCount)) / 2, 7));
    }

    private AbbrevConfig(int i) {
        this.abbrev = capAbbrev(i);
    }

    public int get() {
        return this.abbrev;
    }

    public String toString() {
        return Integer.toString(this.abbrev);
    }
}

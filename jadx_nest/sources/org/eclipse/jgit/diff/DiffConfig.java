package org.eclipse.jgit.diff;

import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.util.StringUtils;

/* JADX INFO: loaded from: classes5.dex */
public class DiffConfig {
    public static final Config.SectionParser<DiffConfig> KEY = new DiffConfig$$ExternalSyntheticLambda0();
    private final boolean noPrefix;
    private final RenameDetectionType renameDetectionType;
    private final int renameLimit;

    public enum RenameDetectionType {
        FALSE,
        TRUE,
        COPY;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static RenameDetectionType[] valuesCustom() {
            RenameDetectionType[] renameDetectionTypeArrValuesCustom = values();
            int length = renameDetectionTypeArrValuesCustom.length;
            RenameDetectionType[] renameDetectionTypeArr = new RenameDetectionType[length];
            System.arraycopy(renameDetectionTypeArrValuesCustom, 0, renameDetectionTypeArr, 0, length);
            return renameDetectionTypeArr;
        }
    }

    public static /* synthetic */ DiffConfig $r8$lambda$byYyUPVrARGijPOxoGSfBgs5RHc(Config config) {
        return new DiffConfig(config);
    }

    private DiffConfig(Config config) {
        this.noPrefix = config.getBoolean("diff", ConfigConstants.CONFIG_KEY_NOPREFIX, false);
        this.renameDetectionType = parseRenameDetectionType(config.getString("diff", null, ConfigConstants.CONFIG_KEY_RENAMES));
        this.renameLimit = config.getInt("diff", ConfigConstants.CONFIG_KEY_RENAMELIMIT, 400);
    }

    public boolean isNoPrefix() {
        return this.noPrefix;
    }

    public boolean isRenameDetectionEnabled() {
        return this.renameDetectionType != RenameDetectionType.FALSE;
    }

    public RenameDetectionType getRenameDetectionType() {
        return this.renameDetectionType;
    }

    public int getRenameLimit() {
        return this.renameLimit;
    }

    private static RenameDetectionType parseRenameDetectionType(String str) {
        if (str == null) {
            return RenameDetectionType.FALSE;
        }
        if (StringUtils.equalsIgnoreCase(ConfigConstants.CONFIG_RENAMELIMIT_COPY, str) || StringUtils.equalsIgnoreCase(ConfigConstants.CONFIG_RENAMELIMIT_COPIES, str)) {
            return RenameDetectionType.COPY;
        }
        Boolean booleanOrNull = StringUtils.toBooleanOrNull(str);
        if (booleanOrNull == null) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().enumValueNotSupported2, "diff", ConfigConstants.CONFIG_KEY_RENAMES, str));
        }
        if (booleanOrNull.booleanValue()) {
            return RenameDetectionType.TRUE;
        }
        return RenameDetectionType.FALSE;
    }
}

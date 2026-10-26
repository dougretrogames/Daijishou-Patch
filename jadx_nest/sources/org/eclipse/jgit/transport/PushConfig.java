package org.eclipse.jgit.transport;

import java.util.Locale;
import org.apache.commons.codec.language.Soundex;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.util.StringUtils;

/* INFO: loaded from: classes5.dex */
public class PushConfig {
    private final PushDefault pushDefault;
    private final PushRecurseSubmodulesMode recurseSubmodules;

    public enum PushRecurseSubmodulesMode implements Config.ConfigEnum {
        CHECK("check"),
        ON_DEMAND("on-demand"),
        NO("false");

        private final String configValue;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PushRecurseSubmodulesMode[] valuesCustom() {
            PushRecurseSubmodulesMode[] pushRecurseSubmodulesModeArrValuesCustom = values();
            int length = pushRecurseSubmodulesModeArrValuesCustom.length;
            PushRecurseSubmodulesMode[] pushRecurseSubmodulesModeArr = new PushRecurseSubmodulesMode[length];
            System.arraycopy(pushRecurseSubmodulesModeArrValuesCustom, 0, pushRecurseSubmodulesModeArr, 0, length);
            return pushRecurseSubmodulesModeArr;
        }

        PushRecurseSubmodulesMode(String str) {
            this.configValue = str;
        }

        @Override // org.eclipse.jgit.lib.Config.ConfigEnum
        public String toConfigValue() {
            return this.configValue;
        }

        @Override // org.eclipse.jgit.lib.Config.ConfigEnum
        public boolean matchConfigValue(String str) {
            if (StringUtils.isEmptyOrNull(str)) {
                return false;
            }
            String strReplace = str.replace(Soundex.SILENT_MARKER, '_');
            return name().equalsIgnoreCase(strReplace) || this.configValue.equalsIgnoreCase(strReplace);
        }
    }

    public enum PushDefault implements Config.ConfigEnum {
        NOTHING,
        CURRENT,
        UPSTREAM("tracking"),
        SIMPLE,
        MATCHING;

        private final String alias;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PushDefault[] valuesCustom() {
            PushDefault[] pushDefaultArrValuesCustom = values();
            int length = pushDefaultArrValuesCustom.length;
            PushDefault[] pushDefaultArr = new PushDefault[length];
            System.arraycopy(pushDefaultArrValuesCustom, 0, pushDefaultArr, 0, length);
            return pushDefaultArr;
        }

        PushDefault() {
            this.alias = null;
        }

        PushDefault(String str) {
            this.alias = str;
        }

        @Override // org.eclipse.jgit.lib.Config.ConfigEnum
        public String toConfigValue() {
            return name().toLowerCase(Locale.ROOT);
        }

        @Override // org.eclipse.jgit.lib.Config.ConfigEnum
        public boolean matchConfigValue(String str) {
            if (toConfigValue().equalsIgnoreCase(str)) {
                return true;
            }
            String str2 = this.alias;
            return str2 != null && str2.equalsIgnoreCase(str);
        }
    }

    public PushConfig(Config config) {
        this.recurseSubmodules = (PushRecurseSubmodulesMode) config.getEnum(ConfigConstants.CONFIG_PUSH_SECTION, null, ConfigConstants.CONFIG_KEY_RECURSE_SUBMODULES, PushRecurseSubmodulesMode.NO);
        this.pushDefault = (PushDefault) config.getEnum(ConfigConstants.CONFIG_PUSH_SECTION, null, "default", PushDefault.SIMPLE);
    }

    public PushRecurseSubmodulesMode getRecurseSubmodules() {
        return this.recurseSubmodules;
    }

    public PushDefault getPushDefault() {
        return this.pushDefault;
    }
}

package org.eclipse.jgit.lib;

import org.apache.commons.codec.language.Soundex;
import org.eclipse.jgit.util.StringUtils;

/* INFO: loaded from: classes5.dex */
public class SubmoduleConfig {

    public enum FetchRecurseSubmodulesMode implements Config.ConfigEnum {
        YES("true"),
        ON_DEMAND("on-demand"),
        NO("false");

        private final String configValue;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static FetchRecurseSubmodulesMode[] valuesCustom() {
            FetchRecurseSubmodulesMode[] fetchRecurseSubmodulesModeArrValuesCustom = values();
            int length = fetchRecurseSubmodulesModeArrValuesCustom.length;
            FetchRecurseSubmodulesMode[] fetchRecurseSubmodulesModeArr = new FetchRecurseSubmodulesMode[length];
            System.arraycopy(fetchRecurseSubmodulesModeArrValuesCustom, 0, fetchRecurseSubmodulesModeArr, 0, length);
            return fetchRecurseSubmodulesModeArr;
        }

        FetchRecurseSubmodulesMode(String str) {
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
}

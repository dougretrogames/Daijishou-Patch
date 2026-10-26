package org.eclipse.jgit.lib;

import org.eclipse.jgit.util.StringUtils;

/* INFO: loaded from: classes5.dex */
class ConfigLine {
    String includedFrom;
    String name;
    String prefix;
    String section;
    String subsection;
    String suffix;
    String value;

    ConfigLine() {
    }

    ConfigLine forValue(String str) {
        ConfigLine configLine = new ConfigLine();
        configLine.prefix = this.prefix;
        configLine.section = this.section;
        configLine.subsection = this.subsection;
        configLine.name = this.name;
        configLine.value = str;
        configLine.suffix = this.suffix;
        configLine.includedFrom = this.includedFrom;
        return configLine;
    }

    boolean match(String str, String str2, String str3) {
        return eqIgnoreCase(this.section, str) && eqSameCase(this.subsection, str2) && eqIgnoreCase(this.name, str3);
    }

    boolean match(String str, String str2) {
        return eqIgnoreCase(this.section, str) && eqSameCase(this.subsection, str2);
    }

    private static boolean eqIgnoreCase(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return StringUtils.equalsIgnoreCase(str, str2);
    }

    private static boolean eqSameCase(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public String toString() {
        if (this.section == null) {
            return "<empty>";
        }
        StringBuilder sb = new StringBuilder(this.section);
        if (this.subsection != null) {
            sb.append(BranchConfig.LOCAL_REPOSITORY).append(this.subsection);
        }
        if (this.name != null) {
            sb.append(BranchConfig.LOCAL_REPOSITORY).append(this.name);
        }
        if (this.value != null) {
            sb.append("=").append(this.value);
        }
        return sb.toString();
    }
}

package org.eclipse.jgit.transport;

import androidx.core.os.EnvironmentCompat;
import org.eclipse.jgit.util.StringUtils;

/* INFO: loaded from: classes5.dex */
public class UserAgent {
    private static volatile String userAgent = computeUserAgent();

    private static String computeUserAgent() {
        return clean("JGit/" + computeVersion());
    }

    private static String computeVersion() {
        Package r0 = UserAgent.class.getPackage();
        if (r0 != null) {
            String implementationVersion = r0.getImplementationVersion();
            return !StringUtils.isEmptyOrNull(implementationVersion) ? implementationVersion : EnvironmentCompat.MEDIA_UNKNOWN;
        }
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    static String clean(String str) {
        String strTrim = str.trim();
        StringBuilder sb = new StringBuilder(strTrim.length());
        for (int i = 0; i < strTrim.length(); i++) {
            char cCharAt = strTrim.charAt(i);
            if (cCharAt <= ' ' || cCharAt >= 127) {
                if (sb.length() <= 0 || sb.charAt(sb.length() - 1) != '.') {
                    cCharAt = '.';
                    sb.append(cCharAt);
                }
            } else {
                sb.append(cCharAt);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static String get() {
        return userAgent;
    }

    public static void set(String str) {
        userAgent = StringUtils.isEmptyOrNull(str) ? null : clean(str);
    }

    private UserAgent() {
    }
}

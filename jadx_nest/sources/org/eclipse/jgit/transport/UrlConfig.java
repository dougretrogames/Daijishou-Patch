package org.eclipse.jgit.transport;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.jgit.lib.Config;

/* INFO: loaded from: classes5.dex */
public class UrlConfig {
    private static final String KEY_INSTEADOF = "insteadof";
    private static final String KEY_PUSHINSTEADOF = "pushinsteadof";
    private static final String SECTION_URL = "url";
    private final Config config;
    private Map<String, String> insteadOf;
    private Map<String, String> pushInsteadOf;

    public UrlConfig(Config config) {
        this.config = config;
    }

    public String replace(String str) {
        if (this.insteadOf == null) {
            this.insteadOf = load(KEY_INSTEADOF);
        }
        return replace(str, this.insteadOf);
    }

    public boolean hasPushReplacements() {
        if (this.pushInsteadOf == null) {
            this.pushInsteadOf = load(KEY_PUSHINSTEADOF);
        }
        return !this.pushInsteadOf.isEmpty();
    }

    public String replacePush(String str) {
        if (this.pushInsteadOf == null) {
            this.pushInsteadOf = load(KEY_PUSHINSTEADOF);
        }
        return replace(str, this.pushInsteadOf);
    }

    private Map<String, String> load(String str) {
        HashMap map = new HashMap();
        for (String str2 : this.config.getSubsections("url")) {
            for (String str3 : this.config.getStringList("url", str2, str)) {
                map.put(str3, str2);
            }
        }
        return map;
    }

    private String replace(String str, Map<String, String> map) {
        Map.Entry<String, String> entry = null;
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            if (entry == null || entry.getKey().length() <= entry2.getKey().length()) {
                if (str.startsWith(entry2.getKey())) {
                    entry = entry2;
                }
            }
        }
        if (entry == null) {
            return str;
        }
        return entry.getValue() + str.substring(entry.getKey().length());
    }
}

package org.eclipse.jgit.internal.transport.parser;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class FirstCommand {
    private final Map<String, String> capabilities;
    private final String line;

    public static FirstCommand fromLine(String str) {
        int iIndexOf = str.indexOf(0);
        if (iIndexOf < 0) {
            return new FirstCommand(str, Collections.emptyMap());
        }
        String[] strArrSplit = str.substring(iIndexOf + 1).split(" ");
        HashMap map = new HashMap();
        for (String str2 : strArrSplit) {
            int iIndexOf2 = str2.indexOf("=");
            if (iIndexOf2 != -1) {
                map.put(str2.substring(0, iIndexOf2), str2.substring(iIndexOf2 + 1));
            } else {
                map.put(str2, null);
            }
        }
        return new FirstCommand(str.substring(0, iIndexOf), Collections.unmodifiableMap(map));
    }

    private FirstCommand(String str, Map<String, String> map) {
        this.line = str;
        this.capabilities = map;
    }

    public String getLine() {
        return this.line;
    }

    public Map<String, String> getCapabilities() {
        return this.capabilities;
    }
}

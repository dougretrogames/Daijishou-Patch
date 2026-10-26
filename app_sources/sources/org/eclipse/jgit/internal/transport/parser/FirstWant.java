package org.eclipse.jgit.internal.transport.parser;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.PackProtocolException;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class FirstWant {
    private static final String AGENT_PREFIX = "agent=";
    private static final String SESSION_ID_PREFIX = "session-id=";

    @Nullable
    private final String agent;
    private final Set<String> capabilities;

    @Nullable
    private final String clientSID;
    private final String line;

    public static FirstWant fromLine(String str) throws PackProtocolException {
        Set setEmptySet;
        String strSubstring;
        String strSubstring2 = null;
        if (str.length() > 45) {
            String strSubstring3 = str.substring(45);
            if (!strSubstring3.startsWith(" ")) {
                throw new PackProtocolException(JGitText.get().wantNoSpaceWithCapabilities);
            }
            String strSubstring4 = strSubstring3.substring(1);
            HashSet hashSet = new HashSet();
            strSubstring = null;
            for (String str2 : strSubstring4.split(" ")) {
                if (str2.startsWith(AGENT_PREFIX)) {
                    strSubstring2 = str2.substring(AGENT_PREFIX.length());
                } else if (str2.startsWith(SESSION_ID_PREFIX)) {
                    strSubstring = str2.substring(SESSION_ID_PREFIX.length());
                } else {
                    hashSet.add(str2);
                }
            }
            str = str.substring(0, 45);
            setEmptySet = Collections.unmodifiableSet(hashSet);
        } else {
            setEmptySet = Collections.emptySet();
            strSubstring = null;
        }
        return new FirstWant(str, setEmptySet, strSubstring2, strSubstring);
    }

    private FirstWant(String str, Set<String> set, @Nullable String str2, @Nullable String str3) {
        this.line = str;
        this.capabilities = set;
        this.agent = str2;
        this.clientSID = str3;
    }

    public String getLine() {
        return this.line;
    }

    public Set<String> getCapabilities() {
        return this.capabilities;
    }

    @Nullable
    public String getAgent() {
        return this.agent;
    }

    @Nullable
    public String getClientSID() {
        return this.clientSID;
    }
}

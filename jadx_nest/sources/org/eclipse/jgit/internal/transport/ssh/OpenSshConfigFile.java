package org.eclipse.jgit.internal.transport.ssh;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.errors.InvalidPatternException;
import org.eclipse.jgit.fnmatch.FileNameMatcher;
import org.eclipse.jgit.lib.CommitConfig$$ExternalSyntheticBackport0;
import org.eclipse.jgit.transport.SshConfigStore;
import org.eclipse.jgit.transport.SshConstants;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.StringUtils;
import org.eclipse.jgit.util.SystemReader;

/* JADX INFO: loaded from: classes5.dex */
public class OpenSshConfigFile implements SshConfigStore {
    private final File configFile;
    private final File home;
    private Instant lastModified;
    private final String localUserName;
    private State state = new State(null);

    protected List<String> validate(String str, List<String> list) {
        return list;
    }

    private static class State {
        List<HostEntry> entries;
        Map<String, HostEntry> hosts;

        /* synthetic */ State(OpenSshConfigFileIA openSshConfigFileIA) {
            this();
        }

        private State() {
            this.entries = new ArrayList();
            this.hosts = new HashMap();
        }

        public String toString() {
            return "State [entries=" + String.valueOf(this.entries) + ", hosts=" + String.valueOf(this.hosts) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
        }
    }

    public OpenSshConfigFile(File file, File file2, String str) {
        this.home = file;
        this.configFile = file2;
        this.localUserName = str;
    }

    @Override // org.eclipse.jgit.transport.SshConfigStore
    public HostEntry lookup(String str, int i, String str2) {
        return lookup(str, i, str2, false);
    }

    @Override // org.eclipse.jgit.transport.SshConfigStore
    public HostEntry lookupDefault(String str, int i, String str2) {
        return lookup(str, i, str2, true);
    }

    private HostEntry lookup(String str, int i, String str2, boolean z) {
        State stateRefresh = refresh();
        String cacheKey = toCacheKey(str, i, str2);
        HostEntry hostEntry = stateRefresh.hosts.get(cacheKey);
        if (hostEntry != null) {
            return hostEntry;
        }
        HostEntry hostEntry2 = new HostEntry();
        Iterator<HostEntry> it = stateRefresh.entries.iterator();
        if (it.hasNext()) {
            hostEntry2.merge(it.next());
            it.forEachRemaining(new OpenSshConfigFile$$ExternalSyntheticLambda1(str, hostEntry2));
        }
        hostEntry2.substitute(str, i, str2, this.localUserName, this.home, z);
        stateRefresh.hosts.put(cacheKey, hostEntry2);
        return hostEntry2;
    }

    static /* synthetic */ void lambda$0(String str, HostEntry hostEntry, HostEntry hostEntry2) {
        if (hostEntry2.matches(str)) {
            hostEntry.merge(hostEntry2);
        }
    }

    private String toCacheKey(String str, int i, String str2) {
        if (i > 0) {
            str = str + CollectionUtils.COLON + Integer.toString(i);
        }
        return (str2 == null || str2.isEmpty()) ? str : str2 + "@" + str;
    }

    private synchronized State refresh() {
        Instant instantLastModifiedInstant = FS.DETECTED.lastModifiedInstant(this.configFile);
        if (!instantLastModifiedInstant.equals(this.lastModified)) {
            Throwable th = null;
            State state = new State(null);
            try {
                BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(this.configFile.toPath(), StandardCharsets.UTF_8);
                try {
                    state.entries = parse(bufferedReaderNewBufferedReader);
                    if (bufferedReaderNewBufferedReader != null) {
                        bufferedReaderNewBufferedReader.close();
                    }
                    this.lastModified = instantLastModifiedInstant;
                    this.state = state;
                } catch (Throwable th2) {
                    if (bufferedReaderNewBufferedReader != null) {
                        bufferedReaderNewBufferedReader.close();
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    throw th3;
                }
                if (null == th3) {
                    throw null;
                }
                try {
                    th.addSuppressed(th3);
                    throw null;
                } catch (IOException | RuntimeException unused) {
                }
            }
        }
        return this.state;
    }

    private List<HostEntry> parse(BufferedReader bufferedReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        HostEntry hostEntry = new HostEntry();
        arrayList.add(hostEntry);
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return arrayList;
            }
            String strM = CommitConfig$$ExternalSyntheticBackport0.m(line);
            if (!strM.isEmpty()) {
                String[] strArrSplit = strM.split("[ \t]*[= \t]", 2);
                String strM2 = CommitConfig$$ExternalSyntheticBackport0.m(strArrSplit[0]);
                if (!strM2.isEmpty()) {
                    char cCharAt = strM2.charAt(0);
                    if (cCharAt == '\"') {
                        List<String> list = parseList(strM2);
                        strM2 = list.isEmpty() ? "" : list.get(0);
                    } else if (cCharAt != '#') {
                        int iIndexOf = strM2.indexOf(35);
                        if (iIndexOf >= 0) {
                            strM2 = strM2.substring(0, iIndexOf);
                        }
                    }
                    if (!strM2.isEmpty()) {
                        String strM3 = strArrSplit.length > 1 ? CommitConfig$$ExternalSyntheticBackport0.m(strArrSplit[1]) : "";
                        if (StringUtils.equalsIgnoreCase("Host", strM2)) {
                            hostEntry = new HostEntry(parseList(strM3));
                            arrayList.add(hostEntry);
                        } else if (HostEntry.isListKey(strM2)) {
                            hostEntry.setValue(strM2, validate(strM2, parseList(strM3)));
                        } else if (!strM3.isEmpty()) {
                            List<String> list2 = parseList(strM3);
                            hostEntry.setValue(strM2, validate(strM2, list2.isEmpty() ? "" : list2.get(0)));
                        }
                    }
                }
            }
        }
    }

    private static List<String> parseList(String str) {
        ArrayList arrayList = new ArrayList(4);
        int length = str.length();
        int token = 0;
        while (token < length) {
            char cCharAt = str.charAt(token);
            if (Character.isWhitespace(cCharAt)) {
                token++;
            } else {
                if (cCharAt == '#') {
                    break;
                }
                token = parseToken(str, token, length, arrayList);
            }
        }
        return arrayList;
    }

    private static int parseToken(String str, int i, int i2, List<String> list) {
        StringBuilder sb = new StringBuilder();
        char c = 0;
        boolean z = false;
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ') {
                if (cCharAt == '\"' || cCharAt == '\'') {
                    if (c == 0) {
                        if (z) {
                            sb.append(cCharAt);
                        } else {
                            c = cCharAt;
                        }
                    } else if (z || c != cCharAt) {
                        sb.append(cCharAt);
                    } else {
                        c = 0;
                    }
                } else if (cCharAt != '\\') {
                    if (z) {
                        sb.append('\\');
                    }
                    if (c == 0 && Character.isWhitespace(cCharAt)) {
                        break;
                    }
                    sb.append(cCharAt);
                } else {
                    if (z) {
                        sb.append(cCharAt);
                    }
                    z = !z;
                }
                z = false;
            } else {
                if (c != 0) {
                    if (z) {
                        sb.append('\\');
                    }
                    sb.append(cCharAt);
                } else {
                    if (!z) {
                        break;
                    }
                    sb.append(cCharAt);
                }
                z = false;
            }
            i++;
        }
        if (sb.length() > 0) {
            list.add(sb.toString());
        }
        return i;
    }

    protected String validate(String str, String str2) {
        return SshConstants.PREFERRED_AUTHENTICATIONS.equalsIgnoreCase(str) ? stripWhitespace(str2) : str2;
    }

    public static boolean patternMatch(Iterable<String> iterable, String str) {
        boolean z = false;
        for (String str2 : iterable) {
            if (str2.startsWith("!")) {
                if (patternMatches(str2.substring(1), str)) {
                    return false;
                }
            } else if (!z && patternMatches(str2, str)) {
                z = true;
            }
        }
        return z;
    }

    private static boolean patternMatches(String str, String str2) {
        if (str.indexOf(42) >= 0 || str.indexOf(63) >= 0) {
            try {
                FileNameMatcher fileNameMatcher = new FileNameMatcher(str, (Character) null);
                fileNameMatcher.append(str2);
                return fileNameMatcher.isMatch();
            } catch (InvalidPatternException unused) {
                return false;
            }
        }
        return str.equals(str2);
    }

    private static String stripWhitespace(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isWhitespace(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File toFile(String str, File file) {
        if (!str.startsWith("~/")) {
            if (!str.startsWith("~" + File.separator)) {
                File file2 = new File(str);
                return file2.isAbsolute() ? file2 : new File(file, str);
            }
        }
        return new File(file, str.substring(2));
    }

    public static int positive(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Integer.parseUnsignedInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static boolean flag(String str) {
        if (str == null) {
            return false;
        }
        return SshConstants.YES.equals(str) || "on".equals(str) || "true".equals(str);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0086  */
    /* JADX WARN: Code duplicated, block: B:54:0x0089  */
    /* JADX WARN: Code duplicated, block: B:55:0x008c  */
    public static int timeSpec(String str) {
        int i;
        int i2;
        if (str == null) {
            return -1;
        }
        try {
            int length = str.length();
            int i3 = 0;
            boolean z = false;
            int iAddExact = 0;
            while (i3 < length) {
                char cCharAt = str.charAt(i3);
                if (Character.isWhitespace(cCharAt)) {
                    i3++;
                } else {
                    if (cCharAt == '+') {
                        i3++;
                    }
                    int iAddExact2 = 0;
                    int i4 = i3;
                    while (i4 < length) {
                        int i5 = i4 + 1;
                        char cCharAt2 = str.charAt(i4);
                        if (cCharAt2 < '0' || cCharAt2 > '9') {
                            break;
                        }
                        iAddExact2 = Math.addExact(Math.multiplyExact(iAddExact2, 10), cCharAt2 - '0');
                        i4 = i5;
                    }
                    if (i3 == i4) {
                        return -1;
                    }
                    if (i4 < length) {
                        i = i4 + 1;
                        char cCharAt3 = str.charAt(i4);
                        if (cCharAt3 == 'D') {
                            i2 = 86400;
                        } else if (cCharAt3 == 'H') {
                            i2 = 3600;
                        } else if (cCharAt3 == 'M') {
                            i2 = 60;
                        } else if (cCharAt3 != 'S') {
                            if (cCharAt3 != 'W') {
                                if (cCharAt3 == 'd') {
                                    i2 = 86400;
                                } else if (cCharAt3 == 'h') {
                                    i2 = 3600;
                                } else if (cCharAt3 == 'm') {
                                    i2 = 60;
                                } else if (cCharAt3 != 's') {
                                    if (cCharAt3 != 'w') {
                                        if (!Character.isWhitespace(cCharAt3)) {
                                            return -1;
                                        }
                                    }
                                }
                            }
                            i2 = 604800;
                        }
                        iAddExact = Math.addExact(iAddExact, Math.multiplyExact(iAddExact2, i2));
                        z = true;
                        i3 = i;
                    } else {
                        i = i4;
                    }
                    i2 = 1;
                    iAddExact = Math.addExact(iAddExact, Math.multiplyExact(iAddExact2, i2));
                    z = true;
                    i3 = i;
                }
            }
            if (z) {
                return iAddExact;
            }
            return -1;
        } catch (ArithmeticException unused) {
            return -1;
        }
    }

    public String getLocalUserName() {
        return this.localUserName;
    }

    public static class HostEntry implements SshConfigStore.HostConfig {
        private static final Map<String, String> ALIASES;
        private static final Set<String> LIST_KEYS;
        private static final Set<String> MULTI_KEYS;
        private Map<String, List<String>> listOptions;
        private Map<String, List<String>> multiOptions;
        private Map<String, String> options;
        private final List<String> patterns;

        static {
            TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
            MULTI_KEYS = treeSet;
            treeSet.add(SshConstants.CERTIFICATE_FILE);
            treeSet.add(SshConstants.IDENTITY_FILE);
            treeSet.add(SshConstants.LOCAL_FORWARD);
            treeSet.add(SshConstants.REMOTE_FORWARD);
            treeSet.add(SshConstants.SEND_ENV);
            TreeSet treeSet2 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
            LIST_KEYS = treeSet2;
            treeSet2.add(SshConstants.CANONICAL_DOMAINS);
            treeSet2.add(SshConstants.GLOBAL_KNOWN_HOSTS_FILE);
            treeSet2.add(SshConstants.SEND_ENV);
            treeSet2.add(SshConstants.USER_KNOWN_HOSTS_FILE);
            treeSet2.add(SshConstants.ADD_KEYS_TO_AGENT);
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            ALIASES = treeMap;
            treeMap.put("PubkeyAcceptedKeyTypes", SshConstants.PUBKEY_ACCEPTED_ALGORITHMS);
        }

        public HostEntry() {
            this.patterns = Collections.emptyList();
        }

        public HostEntry(List<String> list) {
            this.patterns = list;
        }

        boolean matches(String str) {
            return OpenSshConfigFile.patternMatch(this.patterns, str);
        }

        private static String toKey(String str) {
            String str2 = ALIASES.get(str);
            return str2 != null ? str2 : str;
        }

        @Override // org.eclipse.jgit.transport.SshConfigStore.HostConfig
        public String getValue(String str) {
            String key = toKey(str);
            Map<String, String> map = this.options;
            String str2 = map != null ? map.get(key) : null;
            if (str2 == null) {
                Map<String, List<String>> map2 = this.listOptions;
                List<String> list = map2 != null ? map2.get(key) : null;
                if (list == null) {
                    Map<String, List<String>> map3 = this.multiOptions;
                    list = map3 != null ? map3.get(key) : null;
                }
                if (list != null && !list.isEmpty()) {
                    return list.get(0);
                }
            }
            return str2;
        }

        @Override // org.eclipse.jgit.transport.SshConfigStore.HostConfig
        public List<String> getValues(String str) {
            String key = toKey(str);
            Map<String, List<String>> map = this.listOptions;
            List<String> list = map != null ? map.get(key) : null;
            if (list == null) {
                Map<String, List<String>> map2 = this.multiOptions;
                list = map2 != null ? map2.get(key) : null;
            }
            if (list == null || list.isEmpty()) {
                return new ArrayList();
            }
            return new ArrayList(list);
        }

        public void setValue(String str, String str2) {
            String key = toKey(str);
            if (str2 == null) {
                Map<String, List<String>> map = this.multiOptions;
                if (map != null) {
                    map.remove(key);
                }
                Map<String, List<String>> map2 = this.listOptions;
                if (map2 != null) {
                    map2.remove(key);
                }
                Map<String, String> map3 = this.options;
                if (map3 != null) {
                    map3.remove(key);
                    return;
                }
                return;
            }
            if (MULTI_KEYS.contains(key)) {
                if (this.multiOptions == null) {
                    this.multiOptions = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                }
                List<String> arrayList = this.multiOptions.get(key);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(4);
                    this.multiOptions.put(key, arrayList);
                }
                arrayList.add(str2);
                return;
            }
            if (this.options == null) {
                this.options = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            }
            if (this.options.containsKey(key)) {
                return;
            }
            this.options.put(key, str2);
        }

        public void setValue(String str, List<String> list) {
            if (list.isEmpty()) {
                return;
            }
            String key = toKey(str);
            if (MULTI_KEYS.contains(key)) {
                if (this.multiOptions == null) {
                    this.multiOptions = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                }
                List<String> list2 = this.multiOptions.get(key);
                if (list2 == null) {
                    this.multiOptions.put(key, new ArrayList(list));
                    return;
                } else {
                    list2.addAll(list);
                    return;
                }
            }
            if (this.listOptions == null) {
                this.listOptions = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            }
            if (this.listOptions.containsKey(key)) {
                return;
            }
            this.listOptions.put(key, list);
        }

        public static boolean isListKey(String str) {
            return LIST_KEYS.contains(toKey(str));
        }

        void merge(HostEntry hostEntry) {
            if (hostEntry == null) {
                return;
            }
            if (hostEntry.options != null) {
                if (this.options == null) {
                    this.options = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                }
                for (Map.Entry<String, String> entry : hostEntry.options.entrySet()) {
                    if (!this.options.containsKey(entry.getKey())) {
                        this.options.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (hostEntry.listOptions != null) {
                if (this.listOptions == null) {
                    this.listOptions = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                }
                for (Map.Entry<String, List<String>> entry2 : hostEntry.listOptions.entrySet()) {
                    if (!this.listOptions.containsKey(entry2.getKey())) {
                        this.listOptions.put(entry2.getKey(), entry2.getValue());
                    }
                }
            }
            if (hostEntry.multiOptions != null) {
                if (this.multiOptions == null) {
                    this.multiOptions = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                }
                for (Map.Entry<String, List<String>> entry3 : hostEntry.multiOptions.entrySet()) {
                    List<String> list = this.multiOptions.get(entry3.getKey());
                    if (list == null) {
                        this.multiOptions.put(entry3.getKey(), new ArrayList(entry3.getValue()));
                    } else {
                        list.addAll(entry3.getValue());
                    }
                }
            }
        }

        private List<String> substitute(List<String> list, String str, Replacer replacer, boolean z) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(replacer.substitute(it.next(), str, z));
            }
            return arrayList;
        }

        private List<String> replaceTilde(List<String> list, File file) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(OpenSshConfigFile.toFile(it.next(), file).getPath());
            }
            return arrayList;
        }

        void substitute(String str, int i, String str2, String str3, File file, boolean z) {
            List<String> list;
            if (i <= 0) {
                i = OpenSshConfigFile.positive(getValue(SshConstants.PORT));
            }
            if (i <= 0) {
                i = 22;
            }
            int i2 = i;
            if (StringUtils.isEmptyOrNull(str2)) {
                str2 = getValue(SshConstants.USER);
            }
            String str4 = (str2 == null || str2.isEmpty()) ? str3 : str2;
            Replacer replacer = new Replacer(str, i2, str4, str3, file);
            Map<String, String> map = this.options;
            if (map != null) {
                String str5 = map.get(SshConstants.HOST_NAME);
                if (str5 == null || str5.isEmpty()) {
                    this.options.put(SshConstants.HOST_NAME, str);
                } else {
                    String strSubstitute = replacer.substitute(str5, "h", false);
                    this.options.put(SshConstants.HOST_NAME, strSubstitute);
                    replacer.update('h', strSubstitute);
                }
            } else if (z) {
                setValue(SshConstants.HOST_NAME, str);
            }
            Map<String, List<String>> map2 = this.multiOptions;
            if (map2 != null) {
                List<String> list2 = map2.get(SshConstants.IDENTITY_FILE);
                if (list2 != null) {
                    this.multiOptions.put(SshConstants.IDENTITY_FILE, replaceTilde(substitute(list2, Replacer.DEFAULT_TOKENS, replacer, true), file));
                }
                List<String> list3 = this.multiOptions.get(SshConstants.CERTIFICATE_FILE);
                if (list3 != null) {
                    this.multiOptions.put(SshConstants.CERTIFICATE_FILE, replaceTilde(substitute(list3, Replacer.DEFAULT_TOKENS, replacer, true), file));
                }
            }
            Map<String, List<String>> map3 = this.listOptions;
            if (map3 != null && (list = map3.get(SshConstants.USER_KNOWN_HOSTS_FILE)) != null) {
                this.listOptions.put(SshConstants.USER_KNOWN_HOSTS_FILE, replaceTilde(substitute(list, Replacer.DEFAULT_TOKENS, replacer, true), file));
            }
            Map<String, String> map4 = this.options;
            if (map4 != null) {
                String str6 = map4.get(SshConstants.IDENTITY_AGENT);
                if (str6 != null && !"none".equals(str6) && !SshConstants.ENV_SSH_AUTH_SOCKET.equals(str6)) {
                    this.options.put(SshConstants.IDENTITY_AGENT, OpenSshConfigFile.toFile(replacer.substitute(str6, Replacer.DEFAULT_TOKENS, true), file).getPath());
                }
                String str7 = this.options.get(SshConstants.CONTROL_PATH);
                if (str7 != null) {
                    this.options.put(SshConstants.CONTROL_PATH, OpenSshConfigFile.toFile(replacer.substitute(str7, Replacer.DEFAULT_TOKENS, true), file).getPath());
                }
                String str8 = this.options.get(SshConstants.LOCAL_COMMAND);
                if (str8 != null) {
                    this.options.put(SshConstants.LOCAL_COMMAND, replacer.substitute(str8, "CdhLlnprTu", false));
                }
                String str9 = this.options.get(SshConstants.REMOTE_COMMAND);
                if (str9 != null) {
                    this.options.put(SshConstants.REMOTE_COMMAND, replacer.substitute(str9, Replacer.DEFAULT_TOKENS, false));
                }
                String str10 = this.options.get(SshConstants.PROXY_COMMAND);
                if (str10 != null) {
                    this.options.put(SshConstants.PROXY_COMMAND, replacer.substitute(str10, "hnpr", false));
                }
            }
            if (z) {
                if (StringUtils.isEmptyOrNull(this.options.get(SshConstants.USER))) {
                    this.options.put(SshConstants.USER, str4);
                }
                if (OpenSshConfigFile.positive(this.options.get(SshConstants.PORT)) <= 0) {
                    this.options.put(SshConstants.PORT, Integer.toString(i2));
                }
                if (OpenSshConfigFile.positive(this.options.get(SshConstants.CONNECTION_ATTEMPTS)) <= 0) {
                    this.options.put(SshConstants.CONNECTION_ATTEMPTS, "1");
                }
            }
        }

        @Override // org.eclipse.jgit.transport.SshConfigStore.HostConfig
        public Map<String, String> getOptions() {
            Map<String, String> map = this.options;
            if (map == null) {
                return Collections.emptyMap();
            }
            return Collections.unmodifiableMap(map);
        }

        @Override // org.eclipse.jgit.transport.SshConfigStore.HostConfig
        public Map<String, List<String>> getMultiValuedOptions() {
            if (this.listOptions == null && this.multiOptions == null) {
                return Collections.emptyMap();
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Map<String, List<String>> map = this.multiOptions;
            if (map != null) {
                treeMap.putAll(map);
            }
            Map<String, List<String>> map2 = this.listOptions;
            if (map2 != null) {
                treeMap.putAll(map2);
            }
            return Collections.unmodifiableMap(treeMap);
        }

        public String toString() {
            return "HostEntry [options=" + String.valueOf(this.options) + ", multiOptions=" + String.valueOf(this.multiOptions) + ", listOptions=" + String.valueOf(this.listOptions) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
        }
    }

    private static class Replacer {
        public static final String DEFAULT_TOKENS = "CdhLlnpru";
        private final Map<Character, String> replacements;

        public Replacer(String str, int i, String str2, String str3, File file) {
            HashMap map = new HashMap();
            this.replacements = map;
            map.put('%', "%");
            map.put('d', file.getPath());
            map.put('h', str);
            String hostname = SystemReader.getInstance().getHostname();
            map.put('l', hostname);
            int iIndexOf = hostname.indexOf(46);
            map.put('L', iIndexOf > 0 ? hostname.substring(0, iIndexOf) : hostname);
            map.put('n', str);
            map.put('p', Integer.toString(i));
            map.put('r', str2 == null ? "" : str2);
            map.put(Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC), str3);
            map.put('C', substitute("%l%h%p%r", "hlpr", false));
            map.put('T', "NONE");
        }

        public void update(char c, String str) {
            this.replacements.put(Character.valueOf(c), str);
            if ("lhpr".indexOf(c) >= 0) {
                this.replacements.put('C', substitute("%l%h%p%r", "hlpr", false));
            }
        }

        public String substitute(String str, String str2, boolean z) {
            int i;
            int i2;
            int iIndexOf;
            if (str == null || str.length() <= 1 || (str.indexOf(37) < 0 && (!z || str.indexOf("${") < 0))) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            int i3 = 0;
            while (i3 < length) {
                char cCharAt = str.charAt(i3);
                if (cCharAt == '$') {
                    if (z && (i2 = i3 + 2) < length) {
                        if (str.charAt(i3 + 1) != '{' || (iIndexOf = str.indexOf(125, i2)) <= i2) {
                            cCharAt = '$';
                        } else {
                            String str3 = SystemReader.getInstance().getenv(str.substring(i2, iIndexOf));
                            if (!StringUtils.isEmptyOrNull(str3)) {
                                sb.append(str3);
                            }
                            i3 = iIndexOf + 1;
                        }
                    }
                    sb.append(cCharAt);
                    i3++;
                } else if (cCharAt == '%' && (i = i3 + 1) < length) {
                    char cCharAt2 = str.charAt(i);
                    String str4 = (cCharAt2 == '%' || str2.indexOf(cCharAt2) >= 0) ? this.replacements.get(Character.valueOf(cCharAt2)) : null;
                    if (str4 == null) {
                        sb.append('%').append(cCharAt2);
                    } else {
                        sb.append(str4);
                    }
                    i3 += 2;
                } else {
                    sb.append(cCharAt);
                    i3++;
                }
            }
            return sb.toString();
        }
    }

    public String toString() {
        return "OpenSshConfig [home=" + String.valueOf(this.home) + ", configFile=" + String.valueOf(this.configFile) + ", lastModified=" + String.valueOf(this.lastModified) + ", state=" + String.valueOf(this.state) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }
}

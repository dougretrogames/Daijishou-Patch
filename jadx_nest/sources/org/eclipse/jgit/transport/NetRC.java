package org.eclipse.jgit.transport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.jgit.util.FS;

/* JADX INFO: loaded from: classes5.dex */
public class NetRC {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$NetRC$State = null;
    static final String DEFAULT_ENTRY = "default";
    static final Pattern NETRC = Pattern.compile("(\\S+)");
    private static final TreeMap<String, State> STATE = new AnonymousClass1();
    private Map<String, NetRCEntry> hosts = new HashMap();
    private Instant lastModified;
    private File netrc;

    enum State {
        COMMAND,
        MACHINE,
        LOGIN,
        PASSWORD,
        DEFAULT,
        ACCOUNT,
        MACDEF;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] stateArrValuesCustom = values();
            int length = stateArrValuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(stateArrValuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$NetRC$State() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$transport$NetRC$State;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[State.valuesCustom().length];
        try {
            iArr2[State.ACCOUNT.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[State.COMMAND.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[State.DEFAULT.ordinal()] = 5;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[State.LOGIN.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[State.MACDEF.ordinal()] = 7;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[State.MACHINE.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[State.PASSWORD.ordinal()] = 4;
        } catch (NoSuchFieldError unused7) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$transport$NetRC$State = iArr2;
        return iArr2;
    }

    public static class NetRCEntry {
        public String account;
        public String login;
        public String macbody;
        public String macdef;
        public String machine;
        public char[] password;

        boolean complete() {
            return (this.login == null || this.password == null || this.machine == null) ? false : true;
        }
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.transport.NetRC$1, reason: invalid class name */
    class AnonymousClass1 extends TreeMap<String, State> {
        private static final long serialVersionUID = -4285910831814853334L;

        AnonymousClass1() {
            put("machine", State.MACHINE);
            put("login", State.LOGIN);
            put("password", State.PASSWORD);
            put("default", State.DEFAULT);
            put("account", State.ACCOUNT);
            put("macdef", State.MACDEF);
        }
    }

    public NetRC() {
        File defaultFile = getDefaultFile();
        this.netrc = defaultFile;
        if (defaultFile != null) {
            parse();
        }
    }

    public NetRC(File file) {
        this.netrc = file;
        parse();
    }

    private static File getDefaultFile() {
        File fileUserHome = FS.DETECTED.userHome();
        File file = new File(fileUserHome, ".netrc");
        if (file.exists()) {
            return file;
        }
        File file2 = new File(fileUserHome, "_netrc");
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public NetRCEntry getEntry(String str) {
        if (this.netrc == null) {
            return null;
        }
        if (!this.lastModified.equals(FS.DETECTED.lastModifiedInstant(this.netrc))) {
            parse();
        }
        NetRCEntry netRCEntry = this.hosts.get(str);
        return netRCEntry == null ? this.hosts.get("default") : netRCEntry;
    }

    public Collection<NetRCEntry> getEntries() {
        return this.hosts.values();
    }

    private void parse() {
        this.hosts.clear();
        this.lastModified = FS.DETECTED.lastModifiedInstant(this.netrc);
        Throwable th = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.netrc), StandardCharsets.UTF_8));
            try {
                NetRCEntry netRCEntry = new NetRCEntry();
                State state = State.COMMAND;
                Matcher matcher = NETRC.matcher("");
                while (true) {
                    String str = "";
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            if (netRCEntry.macdef != null && netRCEntry.macbody == null) {
                                if (line.length() == 0) {
                                    break;
                                } else {
                                    str = str + line + "\n";
                                }
                            } else {
                                matcher.reset(line);
                                while (matcher.find()) {
                                    String lowerCase = matcher.group().toLowerCase(Locale.ROOT);
                                    if (lowerCase.startsWith("#")) {
                                        matcher.reset("");
                                    } else {
                                        State state2 = STATE.get(lowerCase);
                                        if (state2 == null) {
                                            state2 = State.COMMAND;
                                        }
                                        switch ($SWITCH_TABLE$org$eclipse$jgit$transport$NetRC$State()[state2.ordinal()]) {
                                            case 2:
                                                if (netRCEntry.machine != null && netRCEntry.complete()) {
                                                    this.hosts.put(netRCEntry.machine, netRCEntry);
                                                    netRCEntry = new NetRCEntry();
                                                }
                                                if (matcher.find()) {
                                                    netRCEntry.machine = matcher.group();
                                                }
                                                State state3 = State.COMMAND;
                                                break;
                                            case 3:
                                                if (netRCEntry.login != null && netRCEntry.complete()) {
                                                    this.hosts.put(netRCEntry.machine, netRCEntry);
                                                    netRCEntry = new NetRCEntry();
                                                }
                                                if (matcher.find()) {
                                                    netRCEntry.login = matcher.group();
                                                }
                                                State state4 = State.COMMAND;
                                                break;
                                            case 4:
                                                if (netRCEntry.password != null && netRCEntry.complete()) {
                                                    this.hosts.put(netRCEntry.machine, netRCEntry);
                                                    netRCEntry = new NetRCEntry();
                                                }
                                                if (matcher.find()) {
                                                    netRCEntry.password = matcher.group().toCharArray();
                                                }
                                                State state5 = State.COMMAND;
                                                break;
                                            case 5:
                                                if (netRCEntry.machine != null && netRCEntry.complete()) {
                                                    this.hosts.put(netRCEntry.machine, netRCEntry);
                                                    netRCEntry = new NetRCEntry();
                                                }
                                                netRCEntry.machine = "default";
                                                State state6 = State.COMMAND;
                                                break;
                                            case 6:
                                                if (netRCEntry.account != null && netRCEntry.complete()) {
                                                    this.hosts.put(netRCEntry.machine, netRCEntry);
                                                    netRCEntry = new NetRCEntry();
                                                }
                                                if (matcher.find()) {
                                                    netRCEntry.account = matcher.group();
                                                }
                                                State state7 = State.COMMAND;
                                                break;
                                            case 7:
                                                if (netRCEntry.macdef != null && netRCEntry.complete()) {
                                                    this.hosts.put(netRCEntry.machine, netRCEntry);
                                                    netRCEntry = new NetRCEntry();
                                                }
                                                if (matcher.find()) {
                                                    netRCEntry.macdef = matcher.group();
                                                }
                                                State state8 = State.COMMAND;
                                                break;
                                        }
                                    }
                                }
                            }
                        } else {
                            if (netRCEntry.macdef != null && netRCEntry.macbody == null) {
                                netRCEntry.macbody = str;
                            }
                            if (netRCEntry.complete()) {
                                this.hosts.put(netRCEntry.machine, netRCEntry);
                            }
                            return;
                        }
                    }
                    netRCEntry.macbody = str;
                }
            } finally {
                bufferedReader.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                try {
                    th.addSuppressed(th2);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            throw null;
        }
    }
}

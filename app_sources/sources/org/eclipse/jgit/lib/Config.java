package org.eclipse.jgit.lib;

import androidx.compose.runtime.CompositionImpl$$ExternalSyntheticBackportWithForwarding0;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.events.ConfigChangedEvent;
import org.eclipse.jgit.events.ConfigChangedListener;
import org.eclipse.jgit.events.ListenerHandle;
import org.eclipse.jgit.events.ListenerList;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.RawParseUtils;
import org.eclipse.jgit.util.StringUtils;

/* INFO: loaded from: classes5.dex */
public class Config {
    private static final TypedConfigGetter DEFAULT_GETTER;
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final int MAX_DEPTH = 10;
    private static final String MISSING_ENTRY;
    private static TypedConfigGetter typedGetter;
    private final Config baseConfig;
    private final ListenerList listeners;
    private final AtomicReference<ConfigSnapshot> state;

    public interface ConfigEnum {
        boolean matchConfigValue(String str);

        String toConfigValue();
    }

    public interface SectionParser<T> {
        T parse(Config config);
    }

    protected boolean notifyUponTransientChanges() {
        return true;
    }

    protected byte[] readIncludedConfig(String str) throws ConfigInvalidException {
        return null;
    }

    static {
        DefaultTypedConfigGetter defaultTypedConfigGetter = new DefaultTypedConfigGetter();
        DEFAULT_GETTER = defaultTypedConfigGetter;
        typedGetter = defaultTypedConfigGetter;
        MISSING_ENTRY = new String();
    }

    public Config() {
        this(null);
    }

    public Config(Config config) {
        this.listeners = new ListenerList();
        this.baseConfig = config;
        this.state = new AtomicReference<>(newState());
    }

    public Config getBaseConfig() {
        return this.baseConfig;
    }

    public static boolean isMissing(String str) {
        return str == MISSING_ENTRY;
    }

    public static void setTypedConfigGetter(TypedConfigGetter typedConfigGetter) {
        if (typedConfigGetter == null) {
            typedConfigGetter = DEFAULT_GETTER;
        }
        typedGetter = typedConfigGetter;
    }

    /* WARN: Code duplicated, block: B:36:0x0085  */
    static String escapeValue(String str) {
        if (str.isEmpty()) {
            return "";
        }
        boolean z = str.charAt(0) == ' ' || str.charAt(str.length() - 1) == ' ';
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == 0) {
                throw new IllegalArgumentException(JGitText.get().configValueContainsNullByte);
            }
            if (cCharAt == ';') {
                sb.append(cCharAt);
                z = true;
            } else if (cCharAt == '\\') {
                sb.append("\\\\");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt != '#') {
                switch (cCharAt) {
                    case '\b':
                        sb.append("\\b");
                        break;
                    case '\t':
                        sb.append("\\t");
                        break;
                    case '\n':
                        sb.append("\\n");
                        break;
                    default:
                        sb.append(cCharAt);
                        break;
                }
            } else {
                sb.append(cCharAt);
                z = true;
            }
        }
        String string = sb.toString();
        return z ? "\"" + string + "\"" : string;
    }

    static String escapeSubsection(String str) {
        if (str.isEmpty()) {
            return "\"\"";
        }
        StringBuilder sbAppend = new StringBuilder(str.length() + 2).append('\"');
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == 0) {
                throw new IllegalArgumentException(JGitText.get().configSubsectionContainsNullByte);
            }
            if (cCharAt == '\n') {
                throw new IllegalArgumentException(JGitText.get().configSubsectionContainsNewline);
            }
            if (cCharAt == '\"' || cCharAt == '\\') {
                sbAppend.append('\\').append(cCharAt);
            } else {
                sbAppend.append(cCharAt);
            }
        }
        return sbAppend.append('\"').toString();
    }

    public int getInt(String str, String str2, int i) {
        return typedGetter.getInt(this, str, null, str2, i);
    }

    public int getInt(String str, String str2, String str3, int i) {
        return typedGetter.getInt(this, str, str2, str3, i);
    }

    public int getIntInRange(String str, String str2, int i, int i2, int i3) {
        return typedGetter.getIntInRange(this, str, null, str2, i, i2, i3);
    }

    public int getIntInRange(String str, String str2, String str3, int i, int i2, int i3) {
        return typedGetter.getIntInRange(this, str, str2, str3, i, i2, i3);
    }

    public long getLong(String str, String str2, long j) {
        return typedGetter.getLong(this, str, null, str2, j);
    }

    public long getLong(String str, String str2, String str3, long j) {
        return typedGetter.getLong(this, str, str2, str3, j);
    }

    public boolean getBoolean(String str, String str2, boolean z) {
        return typedGetter.getBoolean(this, str, null, str2, z);
    }

    public boolean getBoolean(String str, String str2, String str3, boolean z) {
        return typedGetter.getBoolean(this, str, str2, str3, z);
    }

    /* WARN: Multi-variable type inference failed */
    /* WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class decompiler.core.dex.instructions.args.ArgType$ArrayArg
    	at decompiler.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at decompiler.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at decompiler.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public <T extends Enum<?>> T getEnum(String str, String str2, String str3, T t) {
        return (T) typedGetter.getEnum(this, (Enum[]) allValuesOf(t), str, str2, str3, t);
    }

    private static <T> T[] allValuesOf(T t) {
        try {
            return (T[]) ((Object[]) t.getClass().getMethod("values", new Class[0]).invoke(null, new Object[0]));
        } catch (Exception e) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().enumValuesNotAvailable, t.getClass().getName()), e);
        }
    }

    public <T extends Enum<?>> T getEnum(T[] tArr, String str, String str2, String str3, T t) {
        return (T) typedGetter.getEnum(this, tArr, str, str2, str3, t);
    }

    public String getString(String str, String str2, String str3) {
        return getRawString(str, str2, str3);
    }

    public String[] getStringList(String str, String str2, String str3) {
        String[] stringList;
        Config config = this.baseConfig;
        if (config != null) {
            stringList = config.getStringList(str, str2, str3);
        } else {
            stringList = EMPTY_STRING_ARRAY;
        }
        String[] rawStringList = getRawStringList(str, str2, str3);
        if (rawStringList == null) {
            return stringList;
        }
        if (stringList.length == 0) {
            return rawStringList;
        }
        String[] strArr = new String[stringList.length + rawStringList.length];
        int length = stringList.length;
        System.arraycopy(stringList, 0, strArr, 0, length);
        System.arraycopy(rawStringList, 0, strArr, length, rawStringList.length);
        return strArr;
    }

    public long getTimeUnit(String str, String str2, String str3, long j, TimeUnit timeUnit) {
        return typedGetter.getTimeUnit(this, str, str2, str3, j, timeUnit);
    }

    public Path getPath(String str, String str2, String str3, FS fs, File file, Path path) {
        return typedGetter.getPath(this, str, str2, str3, fs, file, path);
    }

    public List<RefSpec> getRefSpecs(String str, String str2, String str3) {
        return typedGetter.getRefSpecs(this, str, str2, str3);
    }

    public Set<String> getSubsections(String str) {
        return getState().getSubsections(str);
    }

    public Set<String> getSections() {
        return getState().getSections();
    }

    public Set<String> getNames(String str) {
        return getNames(str, (String) null);
    }

    public Set<String> getNames(String str, String str2) {
        return getState().getNames(str, str2);
    }

    public Set<String> getNames(String str, boolean z) {
        return getState().getNames(str, null, z);
    }

    public Set<String> getNames(String str, String str2, boolean z) {
        return getState().getNames(str, str2, z);
    }

    public <T> T get(SectionParser<T> sectionParser) {
        ConfigSnapshot state = getState();
        T t = (T) state.cache.get(sectionParser);
        if (t != null) {
            return t;
        }
        T t2 = sectionParser.parse(this);
        state.cache.put(sectionParser, t2);
        return t2;
    }

    public void uncache(SectionParser<?> sectionParser) {
        this.state.get().cache.remove(sectionParser);
    }

    public ListenerHandle addChangeListener(ConfigChangedListener configChangedListener) {
        return this.listeners.addConfigChangedListener(configChangedListener);
    }

    protected void fireConfigChangedEvent() {
        this.listeners.dispatch(new ConfigChangedEvent());
    }

    private String getRawString(String str, String str2, String str3) {
        String[] rawStringList = getRawStringList(str, str2, str3);
        if (rawStringList != null) {
            return rawStringList[rawStringList.length - 1];
        }
        Config config = this.baseConfig;
        if (config != null) {
            return config.getRawString(str, str2, str3);
        }
        return null;
    }

    private String[] getRawStringList(String str, String str2, String str3) {
        return this.state.get().get(str, str2, str3);
    }

    private ConfigSnapshot getState() {
        ConfigSnapshot configSnapshot;
        ConfigSnapshot configSnapshot2;
        do {
            configSnapshot = this.state.get();
            ConfigSnapshot baseState = getBaseState();
            if (configSnapshot.baseState == baseState) {
                return configSnapshot;
            }
            configSnapshot2 = new ConfigSnapshot(configSnapshot.entryList, baseState);
        } while (!CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.state, configSnapshot, configSnapshot2));
        return configSnapshot2;
    }

    private ConfigSnapshot getBaseState() {
        Config config = this.baseConfig;
        if (config != null) {
            return config.getState();
        }
        return null;
    }

    public void setInt(String str, String str2, String str3, int i) {
        setLong(str, str2, str3, i);
    }

    public void setLong(String str, String str2, String str3, long j) {
        setString(str, str2, str3, StringUtils.formatWithSuffix(j));
    }

    public void setBoolean(String str, String str2, String str3, boolean z) {
        setString(str, str2, str3, z ? "true" : "false");
    }

    public <T extends Enum<?>> void setEnum(String str, String str2, String str3, T t) {
        String strReplace;
        if (t instanceof ConfigEnum) {
            strReplace = ((ConfigEnum) t).toConfigValue();
        } else {
            strReplace = t.name().toLowerCase(Locale.ROOT).replace('_', TokenParser.SP);
        }
        setString(str, str2, str3, strReplace);
    }

    public void setString(String str, String str2, String str3, String str4) {
        setStringList(str, str2, str3, Collections.singletonList(str4));
    }

    public void unset(String str, String str2, String str3) {
        setStringList(str, str2, str3, Collections.emptyList());
    }

    public void unsetSection(String str, String str2) {
        removeSection(str, str2);
    }

    public boolean removeSection(String str, String str2) {
        ConfigSnapshot configSnapshot;
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        do {
            configSnapshot = this.state.get();
            atomicBoolean.set(false);
        } while (!CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.state, configSnapshot, unsetSection(configSnapshot, str, str2, atomicBoolean)));
        return atomicBoolean.get();
    }

    private ConfigSnapshot unsetSection(ConfigSnapshot configSnapshot, String str, String str2, AtomicBoolean atomicBoolean) {
        ArrayList arrayList = new ArrayList(configSnapshot.entryList.size());
        boolean zMatch = false;
        for (ConfigLine configLine : configSnapshot.entryList) {
            if (configLine.includedFrom != null) {
                arrayList.add(configLine);
            } else if (!zMatch || configLine.section != null || configLine.subsection != null) {
                zMatch = configLine.match(str, str2);
                if (zMatch) {
                    atomicBoolean.set(true);
                } else {
                    arrayList.add(configLine);
                }
            }
        }
        return newState(arrayList);
    }

    public void setStringList(String str, String str2, String str3, List<String> list) {
        while (true) {
            ConfigSnapshot configSnapshot = this.state.get();
            String str4 = str;
            String str5 = str2;
            String str6 = str3;
            List<String> list2 = list;
            if (CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.state, configSnapshot, replaceStringList(configSnapshot, str4, str5, str6, list2))) {
                break;
            }
            str = str4;
            str2 = str5;
            str3 = str6;
            list = list2;
        }
        if (notifyUponTransientChanges()) {
            fireConfigChangedEvent();
        }
    }

    private ConfigSnapshot replaceStringList(ConfigSnapshot configSnapshot, String str, String str2, String str3, List<String> list) {
        List<ConfigLine> listCopy = copy(configSnapshot, list);
        int i = 0;
        int size = -1;
        int i2 = 0;
        while (i < listCopy.size() && i2 < list.size()) {
            ConfigLine configLine = listCopy.get(i);
            if (configLine.includedFrom == null && configLine.match(str, str2, str3)) {
                listCopy.set(i, configLine.forValue(list.get(i2)));
                size = i + 1;
                i2++;
            }
            i++;
        }
        if (i2 == list.size() && i < listCopy.size()) {
            while (i < listCopy.size()) {
                int i3 = i + 1;
                ConfigLine configLine2 = listCopy.get(i);
                if (configLine2.includedFrom == null && configLine2.match(str, str2, str3)) {
                    listCopy.remove(i);
                } else {
                    i = i3;
                }
            }
        }
        if (i2 < list.size() && i == listCopy.size()) {
            if (size < 0) {
                size = findSectionEnd(listCopy, str, str2, true);
            }
            if (size < 0) {
                ConfigLine configLine3 = new ConfigLine();
                configLine3.section = str;
                configLine3.subsection = str2;
                listCopy.add(configLine3);
                size = listCopy.size();
            }
            while (i2 < list.size()) {
                ConfigLine configLine4 = new ConfigLine();
                configLine4.section = str;
                configLine4.subsection = str2;
                configLine4.name = str3;
                configLine4.value = list.get(i2);
                listCopy.add(size, configLine4);
                size++;
                i2++;
            }
        }
        return newState(listCopy);
    }

    private static List<ConfigLine> copy(ConfigSnapshot configSnapshot, List<String> list) {
        ArrayList arrayList = new ArrayList(configSnapshot.entryList.size() + list.size() + 1);
        arrayList.addAll(configSnapshot.entryList);
        return arrayList;
    }

    private static int findSectionEnd(List<ConfigLine> list, String str, String str2, boolean z) {
        ConfigLine configLine;
        int i = 0;
        while (i < list.size()) {
            ConfigLine configLine2 = list.get(i);
            if ((configLine2.includedFrom == null || !z) && configLine2.match(str, str2, null)) {
                do {
                    i++;
                    if (i >= list.size()) {
                        break;
                    }
                    configLine = list.get(i);
                } while (configLine.match(str, str2, configLine.name));
                return i;
            }
            i++;
        }
        return -1;
    }

    public String toText() {
        StringBuilder sb = new StringBuilder();
        for (ConfigLine configLine : this.state.get().entryList) {
            if (configLine.includedFrom == null) {
                if (configLine.prefix != null) {
                    sb.append(configLine.prefix);
                }
                if (configLine.section != null && configLine.name == null) {
                    sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                    sb.append(configLine.section);
                    if (configLine.subsection != null) {
                        sb.append(TokenParser.SP);
                        String strEscapeValue = escapeValue(configLine.subsection);
                        boolean z = strEscapeValue.startsWith("\"") && strEscapeValue.endsWith("\"");
                        if (!z) {
                            sb.append('\"');
                        }
                        sb.append(strEscapeValue);
                        if (!z) {
                            sb.append('\"');
                        }
                    }
                    sb.append(AbstractJsonLexerKt.END_LIST);
                } else if (configLine.section != null && configLine.name != null) {
                    if (configLine.prefix == null || "".equals(configLine.prefix)) {
                        sb.append('\t');
                    }
                    sb.append(configLine.name);
                    if (!isMissing(configLine.value)) {
                        sb.append(" =");
                        if (configLine.value != null) {
                            sb.append(TokenParser.SP);
                            sb.append(escapeValue(configLine.value));
                        }
                    }
                    if (configLine.suffix != null) {
                        sb.append(TokenParser.SP);
                    }
                }
                if (configLine.suffix != null) {
                    sb.append(configLine.suffix);
                }
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    public void fromText(String str) throws ConfigInvalidException {
        this.state.set(newState(fromTextRecurse(str, 1, null)));
    }

    private List<ConfigLine> fromTextRecurse(String str, int i, String str2) throws ConfigInvalidException {
        if (i > 10) {
            throw new ConfigInvalidException(JGitText.get().tooManyIncludeRecursions);
        }
        ArrayList arrayList = new ArrayList();
        StringReader stringReader = new StringReader(str);
        ConfigLine configLine = new ConfigLine();
        configLine.includedFrom = str2;
        ConfigLine configLine2 = null;
        while (true) {
            int i2 = stringReader.read();
            if (-1 == i2) {
                if (configLine.section != null) {
                    arrayList.add(configLine);
                }
                return arrayList;
            }
            char c = (char) i2;
            if ('\n' == c) {
                arrayList.add(configLine);
                if (configLine.section != null) {
                    configLine2 = configLine;
                }
                configLine = new ConfigLine();
                configLine.includedFrom = str2;
            } else if (configLine.suffix != null) {
                configLine.suffix = String.valueOf(configLine.suffix) + c;
            } else if (';' == c || '#' == c) {
                configLine.suffix = String.valueOf(c);
            } else if (configLine.section == null && Character.isWhitespace(c)) {
                if (configLine.prefix == null) {
                    configLine.prefix = "";
                }
                configLine.prefix = String.valueOf(configLine.prefix) + c;
            } else if ('[' == c) {
                configLine.section = readSectionName(stringReader);
                int i3 = stringReader.read();
                if (34 == i3) {
                    configLine.subsection = readSubsectionName(stringReader);
                    i3 = stringReader.read();
                }
                if (93 != i3) {
                    throw new ConfigInvalidException(JGitText.get().badGroupHeader);
                }
                configLine.suffix = "";
            } else if (configLine2 != null) {
                configLine.section = configLine2.section;
                configLine.subsection = configLine2.subsection;
                stringReader.reset();
                configLine.name = readKeyName(stringReader);
                if (configLine.name.endsWith("\n")) {
                    configLine.name = configLine.name.substring(0, configLine.name.length() - 1);
                    configLine.value = MISSING_ENTRY;
                } else {
                    configLine.value = readValue(stringReader);
                }
                if (configLine.section.equalsIgnoreCase("include")) {
                    addIncludedConfig(arrayList, configLine, i);
                }
            } else {
                throw new ConfigInvalidException(JGitText.get().invalidLineInConfigFile);
            }
        }
    }

    private void addIncludedConfig(List<ConfigLine> list, ConfigLine configLine, int i) throws ConfigInvalidException {
        String strDecode;
        if (!configLine.name.equalsIgnoreCase("path") || configLine.value == null || configLine.value.equals(MISSING_ENTRY)) {
            throw new ConfigInvalidException(MessageFormat.format(JGitText.get().invalidLineInConfigFileWithParam, configLine));
        }
        byte[] includedConfig = readIncludedConfig(configLine.value);
        if (includedConfig == null) {
            return;
        }
        if (isUtf8(includedConfig)) {
            strDecode = RawParseUtils.decode(StandardCharsets.UTF_8, includedConfig, 3, includedConfig.length);
        } else {
            strDecode = RawParseUtils.decode(includedConfig);
        }
        try {
            list.addAll(fromTextRecurse(strDecode, i + 1, configLine.value));
        } catch (ConfigInvalidException e) {
            throw new ConfigInvalidException(MessageFormat.format(JGitText.get().cannotReadFile, configLine.value), e);
        }
    }

    private ConfigSnapshot newState() {
        return new ConfigSnapshot(Collections.emptyList(), getBaseState());
    }

    private ConfigSnapshot newState(List<ConfigLine> list) {
        return new ConfigSnapshot(Collections.unmodifiableList(list), getBaseState());
    }

    protected void clear() {
        this.state.set(newState());
    }

    protected boolean isUtf8(byte[] bArr) {
        return bArr.length >= 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65;
    }

    private static String readSectionName(StringReader stringReader) throws ConfigInvalidException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = stringReader.read();
            if (i < 0) {
                throw new ConfigInvalidException(JGitText.get().unexpectedEndOfConfigFile);
            }
            if (93 == i) {
                stringReader.reset();
            } else if (32 == i || 9 == i) {
                while (true) {
                    int i2 = stringReader.read();
                    if (i2 < 0) {
                        throw new ConfigInvalidException(JGitText.get().unexpectedEndOfConfigFile);
                    }
                    if (34 == i2) {
                        stringReader.reset();
                    } else if (32 != i2 && 9 != i2) {
                        throw new ConfigInvalidException(MessageFormat.format(JGitText.get().badSectionEntry, sb));
                    }
                }
            } else {
                char c = (char) i;
                if (Character.isLetterOrDigit(c) || 46 == i || 45 == i) {
                    sb.append(c);
                } else {
                    throw new ConfigInvalidException(MessageFormat.format(JGitText.get().badSectionEntry, sb));
                }
            }
            return sb.toString();
        }
    }

    private static String readKeyName(StringReader stringReader) throws ConfigInvalidException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = stringReader.read();
            if (i < 0) {
                throw new ConfigInvalidException(JGitText.get().unexpectedEndOfConfigFile);
            }
            if (61 != i) {
                if (32 == i || 9 == i) {
                    while (true) {
                        int i2 = stringReader.read();
                        if (i2 < 0) {
                            throw new ConfigInvalidException(JGitText.get().unexpectedEndOfConfigFile);
                        }
                        if (61 != i2) {
                            if (59 == i2 || 35 == i2 || 10 == i2) {
                                stringReader.reset();
                            } else if (32 != i2 && 9 != i2) {
                                throw new ConfigInvalidException(JGitText.get().badEntryDelimiter);
                            }
                        }
                    }
                } else {
                    char c = (char) i;
                    if (Character.isLetterOrDigit(c) || i == 45) {
                        sb.append(c);
                    } else if (10 == i) {
                        stringReader.reset();
                        sb.append(c);
                    } else {
                        throw new ConfigInvalidException(MessageFormat.format(JGitText.get().badEntryName, sb));
                    }
                }
            }
            return sb.toString();
        }
    }

    private static String readSubsectionName(StringReader stringReader) throws ConfigInvalidException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = stringReader.read();
            if (i < 0) {
                break;
            }
            if (10 == i) {
                throw new ConfigInvalidException(JGitText.get().newlineInQuotesNotAllowed);
            }
            if (92 == i) {
                int i2 = stringReader.read();
                if (i2 == -1) {
                    throw new ConfigInvalidException(JGitText.get().endOfFileInEscape);
                }
                if (i2 == 34 || i2 == 92) {
                    sb.append((char) i2);
                } else {
                    sb.append((char) i2);
                }
            } else {
                if (34 == i) {
                    break;
                }
                sb.append((char) i);
            }
        }
        return sb.toString();
    }

    /* WARN: Code duplicated, block: B:62:0x00b8  */
    /* WARN: Code duplicated, block: B:63:0x00be  */
    private static String readValue(StringReader stringReader) throws ConfigInvalidException {
        Object unicodeLiteral;
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        StringBuilder sb2 = null;
        boolean z2 = false;
        while (true) {
            int i = stringReader.read();
            if (i >= 0) {
                if (10 == i) {
                    if (z2) {
                        throw new ConfigInvalidException(JGitText.get().newlineInQuotesNotAllowed);
                    }
                    stringReader.reset();
                } else if (!z2 && (59 == i || 35 == i)) {
                    if (sb2 != null) {
                        sb2.setLength(0);
                    }
                    stringReader.reset();
                } else {
                    char c = (char) i;
                    if (!Character.isWhitespace(c)) {
                        if (sb2 != null) {
                            sb.append((CharSequence) sb2);
                            sb2.setLength(0);
                        }
                        if (92 == i) {
                            int i2 = stringReader.read();
                            if (i2 == -1) {
                                throw new ConfigInvalidException(JGitText.get().endOfFileInEscape);
                            }
                            if (i2 != 10) {
                                if (i2 == 13) {
                                    int i3 = stringReader.read();
                                    if (i3 != 10) {
                                        if (i3 >= 0) {
                                            stringReader.reset();
                                        }
                                        String str = JGitText.get().badEscape;
                                        if (Character.isAlphabetic(i2)) {
                                            unicodeLiteral = Character.valueOf((char) i2);
                                        } else {
                                            unicodeLiteral = toUnicodeLiteral(i2);
                                        }
                                        throw new ConfigInvalidException(MessageFormat.format(str, unicodeLiteral));
                                    }
                                } else if (i2 == 34) {
                                    sb.append('\"');
                                } else if (i2 == 92) {
                                    sb.append('\\');
                                } else if (i2 == 98) {
                                    sb.append('\b');
                                } else if (i2 == 110) {
                                    sb.append('\n');
                                } else if (i2 == 116) {
                                    sb.append('\t');
                                } else {
                                    String str2 = JGitText.get().badEscape;
                                    if (Character.isAlphabetic(i2)) {
                                        unicodeLiteral = Character.valueOf((char) i2);
                                    } else {
                                        unicodeLiteral = toUnicodeLiteral(i2);
                                    }
                                    throw new ConfigInvalidException(MessageFormat.format(str2, unicodeLiteral));
                                }
                            }
                        } else if (34 == i) {
                            z2 = !z2;
                        } else {
                            sb.append(c);
                        }
                        z = false;
                    } else if (!z) {
                        if (sb2 == null) {
                            sb2 = new StringBuilder();
                        }
                        sb2.append(c);
                    }
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        }
    }

    private static String toUnicodeLiteral(int i) {
        return String.format("\\u%04x", Integer.valueOf(i));
    }

    private static class StringReader {
        private final char[] buf;
        private int pos;

        StringReader(String str) {
            this.buf = str.toCharArray();
        }

        int read() {
            int i = this.pos;
            char[] cArr = this.buf;
            if (i >= cArr.length) {
                return -1;
            }
            this.pos = i + 1;
            return cArr[i];
        }

        void reset() {
            this.pos--;
        }
    }
}

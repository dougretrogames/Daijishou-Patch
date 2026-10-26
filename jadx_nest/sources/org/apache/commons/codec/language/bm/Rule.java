package org.apache.commons.codec.language.bm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.apache.commons.codec.Resources;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.WalkEncryption;

/* INFO: loaded from: classes5.dex */
public class Rule {
    public static final String ALL = "ALL";
    private static final String DOUBLE_QUOTE = "\"";
    private final RPattern lContext;
    private final String pattern;
    private final PhonemeExpr phoneme;
    private final RPattern rContext;
    public static final RPattern ALL_STRINGS_RMATCHER = new Rule$$ExternalSyntheticLambda11();
    private static final String HASH_INCLUDE = "#include";
    private static final int HASH_INCLUDE_LENGTH = HASH_INCLUDE.length();
    private static final Map<NameType, Map<RuleType, Map<String, Map<String, List<Rule>>>>> RULES = new EnumMap(NameType.class);

    public interface RPattern {
        boolean isMatch(CharSequence charSequence);
    }

    static /* synthetic */ boolean lambda$contains$2(char c, int i) {
        return i == c;
    }

    static /* synthetic */ boolean lambda$static$0(CharSequence charSequence) {
        return true;
    }

    public static final class Phoneme implements PhonemeExpr {
        public static final Comparator<Phoneme> COMPARATOR = new Rule$Phoneme$$ExternalSyntheticLambda0();
        private final Languages.LanguageSet languages;
        private final StringBuilder phonemeText;

        @Override // org.apache.commons.codec.language.bm.Rule.PhonemeExpr
        public int size() {
            return 1;
        }

        static /* synthetic */ int lambda$static$0(Phoneme phoneme, Phoneme phoneme2) {
            int length = phoneme.phonemeText.length();
            int length2 = phoneme2.phonemeText.length();
            for (int i = 0; i < length; i++) {
                if (i >= length2) {
                    return 1;
                }
                int iCharAt = phoneme.phonemeText.charAt(i) - phoneme2.phonemeText.charAt(i);
                if (iCharAt != 0) {
                    return iCharAt;
                }
            }
            return length < length2 ? -1 : 0;
        }

        public Phoneme(CharSequence charSequence, Languages.LanguageSet languageSet) {
            this.phonemeText = new StringBuilder(charSequence);
            this.languages = languageSet;
        }

        public Phoneme(Phoneme phoneme, Phoneme phoneme2) {
            this(phoneme.phonemeText, phoneme.languages);
            this.phonemeText.append((CharSequence) phoneme2.phonemeText);
        }

        public Phoneme(Phoneme phoneme, Phoneme phoneme2, Languages.LanguageSet languageSet) {
            this(phoneme.phonemeText, languageSet);
            this.phonemeText.append((CharSequence) phoneme2.phonemeText);
        }

        public Phoneme append(CharSequence charSequence) {
            this.phonemeText.append(charSequence);
            return this;
        }

        public Languages.LanguageSet getLanguages() {
            return this.languages;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.PhonemeExpr
        public Iterable<Phoneme> getPhonemes() {
            return Collections.singleton(this);
        }

        public CharSequence getPhonemeText() {
            return this.phonemeText;
        }

        @Deprecated
        public Phoneme join(Phoneme phoneme) {
            return new Phoneme(this.phonemeText.toString() + phoneme.phonemeText.toString(), this.languages.restrictTo(phoneme.languages));
        }

        public Phoneme mergeWithLanguage(Languages.LanguageSet languageSet) {
            return new Phoneme(this.phonemeText.toString(), this.languages.merge(languageSet));
        }

        public String toString() {
            return this.phonemeText.toString() + CollectionUtils.DEFAULT_TOSTRING_PREFIX + this.languages + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
        }
    }

    public interface PhonemeExpr {
        Iterable<Phoneme> getPhonemes();

        default int size() {
            return (int) Math.min(getPhonemes().spliterator().getExactSizeIfKnown(), 2147483647L);
        }
    }

    public static final class PhonemeList implements PhonemeExpr {
        private final List<Phoneme> phonemeList;

        public PhonemeList(List<Phoneme> list) {
            this.phonemeList = list;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.PhonemeExpr
        public List<Phoneme> getPhonemes() {
            return this.phonemeList;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.PhonemeExpr
        public int size() {
            return this.phonemeList.size();
        }
    }

    static {
        for (NameType nameType : NameType.values()) {
            EnumMap enumMap = new EnumMap(RuleType.class);
            for (RuleType ruleType : RuleType.values()) {
                HashMap map = new HashMap();
                Languages.getInstance(nameType).getLanguages().forEach(new Rule$$ExternalSyntheticLambda1(nameType, ruleType, map));
                if (!ruleType.equals(RuleType.RULES)) {
                    Scanner scannerCreateScanner = createScanner(nameType, ruleType, "common");
                    try {
                        map.put("common", parseRules(scannerCreateScanner, createResourceName(nameType, ruleType, "common")));
                        if (scannerCreateScanner != null) {
                            scannerCreateScanner.close();
                        }
                    } catch (Throwable th) {
                        if (scannerCreateScanner != null) {
                            try {
                                scannerCreateScanner.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
                enumMap.put(ruleType, Collections.unmodifiableMap(map));
            }
            RULES.put(nameType, Collections.unmodifiableMap(enumMap));
        }
    }

    static /* synthetic */ void lambda$static$1(NameType nameType, RuleType ruleType, Map map, String str) {
        try {
            Scanner scannerCreateScanner = createScanner(nameType, ruleType, str);
            try {
                map.put(str, parseRules(scannerCreateScanner, createResourceName(nameType, ruleType, str)));
                if (scannerCreateScanner != null) {
                    scannerCreateScanner.close();
                }
            } catch (Throwable th) {
                if (scannerCreateScanner != null) {
                    try {
                        scannerCreateScanner.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IllegalStateException e) {
            throw new IllegalStateException("Problem processing " + createResourceName(nameType, ruleType, str), e);
        }
    }

    private static boolean contains(CharSequence charSequence, char c) {
        return charSequence.chars().anyMatch(new Rule$$ExternalSyntheticLambda10(c));
    }

    private static String createResourceName(NameType nameType, RuleType ruleType, String str) {
        return String.format("/org/apache/commons/codec/language/bm/%s_%s_%s.txt", nameType.getName(), ruleType.getName(), str);
    }

    private static Scanner createScanner(NameType nameType, RuleType ruleType, String str) {
        return new Scanner(Resources.getInputStream(createResourceName(nameType, ruleType, str)), ResourceConstants.ENCODING);
    }

    private static Scanner createScanner(String str) {
        return new Scanner(Resources.getInputStream(String.format("/org/apache/commons/codec/language/bm/%s.txt", str)), ResourceConstants.ENCODING);
    }

    /* INFO: Access modifiers changed from: private */
    public static boolean endsWith(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence2.length();
        int length2 = charSequence.length();
        if (length > length2) {
            return false;
        }
        int i = length2 - 1;
        for (int i2 = length - 1; i2 >= 0; i2--) {
            if (charSequence.charAt(i) != charSequence2.charAt(i2)) {
                return false;
            }
            i--;
        }
        return true;
    }

    public static List<Rule> getInstance(NameType nameType, RuleType ruleType, Languages.LanguageSet languageSet) {
        Map<String, List<Rule>> instanceMap = getInstanceMap(nameType, ruleType, languageSet);
        ArrayList arrayList = new ArrayList();
        instanceMap.values().forEach(new Rule$$ExternalSyntheticLambda0(arrayList));
        return arrayList;
    }

    public static List<Rule> getInstance(NameType nameType, RuleType ruleType, String str) {
        return getInstance(nameType, ruleType, Languages.LanguageSet.from(new HashSet(Arrays.asList(str))));
    }

    public static Map<String, List<Rule>> getInstanceMap(NameType nameType, RuleType ruleType, Languages.LanguageSet languageSet) {
        return languageSet.isSingleton() ? getInstanceMap(nameType, ruleType, languageSet.getAny()) : getInstanceMap(nameType, ruleType, Languages.ANY);
    }

    public static Map<String, List<Rule>> getInstanceMap(NameType nameType, RuleType ruleType, String str) {
        Map<String, List<Rule>> map = RULES.get(nameType).get(ruleType).get(str);
        if (map != null) {
            return map;
        }
        throw new IllegalArgumentException(String.format("No rules found for %s, %s, %s.", nameType.getName(), ruleType.getName(), str));
    }

    private static Phoneme parsePhoneme(String str) {
        int iIndexOf = str.indexOf(CollectionUtils.DEFAULT_TOSTRING_PREFIX);
        if (iIndexOf >= 0) {
            if (!str.endsWith(CollectionUtils.DEFAULT_TOSTRING_SUFFIX)) {
                throw new IllegalArgumentException("Phoneme expression contains a '[' but does not end in ']'");
            }
            return new Phoneme(str.substring(0, iIndexOf), Languages.LanguageSet.from(new HashSet(Arrays.asList(str.substring(iIndexOf + 1, str.length() - 1).split("[+]")))));
        }
        return new Phoneme(str, Languages.ANY_LANGUAGE);
    }

    private static PhonemeExpr parsePhonemeExpr(String str) {
        if (str.startsWith("(")) {
            if (!str.endsWith(")")) {
                throw new IllegalArgumentException("Phoneme starts with '(' so must end with ')'");
            }
            ArrayList arrayList = new ArrayList();
            String strSubstring = str.substring(1, str.length() - 1);
            for (String str2 : strSubstring.split("[|]")) {
                arrayList.add(parsePhoneme(str2));
            }
            if (strSubstring.startsWith("|") || strSubstring.endsWith("|")) {
                arrayList.add(new Phoneme("", Languages.ANY_LANGUAGE));
            }
            return new PhonemeList(arrayList);
        }
        return parsePhoneme(str);
    }

    private static Map<String, List<Rule>> parseRules(Scanner scanner, String str) {
        HashMap map = new HashMap();
        int i = 0;
        boolean z = false;
        while (scanner.hasNextLine()) {
            int i2 = i + 1;
            String strNextLine = scanner.nextLine();
            if (z) {
                if (strNextLine.endsWith("*/")) {
                    z = false;
                }
            } else if (strNextLine.startsWith(RefSpec.WILDCARD_SUFFIX)) {
                z = true;
            } else {
                int iIndexOf = strNextLine.indexOf("//");
                String strTrim = (iIndexOf >= 0 ? strNextLine.substring(0, iIndexOf) : strNextLine).trim();
                if (strTrim.isEmpty()) {
                    continue;
                } else if (strTrim.startsWith(HASH_INCLUDE)) {
                    String strTrim2 = strTrim.substring(HASH_INCLUDE_LENGTH).trim();
                    if (strTrim2.contains(" ")) {
                        throw new IllegalArgumentException("Malformed import statement '" + strNextLine + "' in " + str);
                    }
                    Scanner scannerCreateScanner = createScanner(strTrim2);
                    try {
                        map.putAll(parseRules(scannerCreateScanner, str + "->" + strTrim2));
                        if (scannerCreateScanner != null) {
                            scannerCreateScanner.close();
                        }
                    } catch (Throwable th) {
                        if (scannerCreateScanner == null) {
                            throw th;
                        }
                        try {
                            scannerCreateScanner.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                } else {
                    String[] strArrSplit = strTrim.split(WalkEncryption.Vals.REGEX_WS);
                    if (strArrSplit.length != 4) {
                        throw new IllegalArgumentException("Malformed rule statement split into " + strArrSplit.length + " parts: " + strNextLine + " in " + str);
                    }
                    try {
                        String strStripQuotes = stripQuotes(strArrSplit[0]);
                        String strStripQuotes2 = stripQuotes(strArrSplit[1]);
                        String strStripQuotes3 = stripQuotes(strArrSplit[2]);
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(strStripQuotes, strStripQuotes2, strStripQuotes3, parsePhonemeExpr(stripQuotes(strArrSplit[3])), i2, str, strStripQuotes, strStripQuotes2, strStripQuotes3);
                        ((List) map.computeIfAbsent(((Rule) anonymousClass1).pattern.substring(0, 1), new Rule$$ExternalSyntheticLambda2())).add(anonymousClass1);
                    } catch (IllegalArgumentException e) {
                        throw new IllegalStateException("Problem parsing line '" + i2 + "' in " + str, e);
                    }
                }
            }
            i = i2;
        }
        return map;
    }

    /* INFO: renamed from: org.apache.commons.codec.language.bm.Rule$1, reason: invalid class name */
    class AnonymousClass1 extends Rule {
        private final String loc;
        private final int myLine;
        final /* synthetic */ int val$cLine;
        final /* synthetic */ String val$lCon;
        final /* synthetic */ String val$location;
        final /* synthetic */ String val$pat;
        final /* synthetic */ String val$rCon;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, PhonemeExpr phonemeExpr, int i, String str4, String str5, String str6, String str7) {
            super(str, str2, str3, phonemeExpr);
            this.val$cLine = i;
            this.val$location = str4;
            this.val$pat = str5;
            this.val$lCon = str6;
            this.val$rCon = str7;
            this.myLine = i;
            this.loc = str4;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Rule{line=");
            sb.append(this.myLine);
            sb.append(", loc='").append(this.loc).append("', pat='");
            sb.append(this.val$pat).append("', lcon='");
            sb.append(this.val$lCon).append("', rcon='");
            sb.append(this.val$rCon).append("'}");
            return sb.toString();
        }
    }

    static /* synthetic */ List lambda$parseRules$4(String str) {
        return new ArrayList();
    }

    private static RPattern pattern(String str) {
        boolean zStartsWith = str.startsWith("^");
        boolean zEndsWith = str.endsWith("$");
        int length = str.length();
        if (zEndsWith) {
            length--;
        }
        String strSubstring = str.substring(zStartsWith ? 1 : 0, length);
        if (strSubstring.contains(CollectionUtils.DEFAULT_TOSTRING_PREFIX)) {
            boolean zStartsWith2 = strSubstring.startsWith(CollectionUtils.DEFAULT_TOSTRING_PREFIX);
            boolean zEndsWith2 = strSubstring.endsWith(CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
            if (zStartsWith2 && zEndsWith2) {
                String strSubstring2 = strSubstring.substring(1, strSubstring.length() - 1);
                if (!strSubstring2.contains(CollectionUtils.DEFAULT_TOSTRING_PREFIX)) {
                    boolean zStartsWith3 = strSubstring2.startsWith("^");
                    if (zStartsWith3) {
                        strSubstring2 = strSubstring2.substring(1);
                    }
                    boolean z = !zStartsWith3;
                    if (zStartsWith && zEndsWith) {
                        return new Rule$$ExternalSyntheticLambda7(strSubstring2, z);
                    }
                    if (zStartsWith) {
                        return new Rule$$ExternalSyntheticLambda8(strSubstring2, z);
                    }
                    if (zEndsWith) {
                        return new Rule$$ExternalSyntheticLambda9(strSubstring2, z);
                    }
                }
            }
        } else {
            if (zStartsWith && zEndsWith) {
                if (strSubstring.isEmpty()) {
                    return new Rule$$ExternalSyntheticLambda3();
                }
                return new Rule$$ExternalSyntheticLambda4(strSubstring);
            }
            if ((zStartsWith || zEndsWith) && strSubstring.isEmpty()) {
                return ALL_STRINGS_RMATCHER;
            }
            if (zStartsWith) {
                return new Rule$$ExternalSyntheticLambda5(strSubstring);
            }
            if (zEndsWith) {
                return new Rule$$ExternalSyntheticLambda6(strSubstring);
            }
        }
        return new AnonymousClass2(str);
    }

    static /* synthetic */ boolean lambda$pattern$5(CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    static /* synthetic */ boolean lambda$pattern$9(String str, boolean z, CharSequence charSequence) {
        return charSequence.length() == 1 && contains(str, charSequence.charAt(0)) == z;
    }

    static /* synthetic */ boolean lambda$pattern$10(String str, boolean z, CharSequence charSequence) {
        return charSequence.length() > 0 && contains(str, charSequence.charAt(0)) == z;
    }

    static /* synthetic */ boolean lambda$pattern$11(String str, boolean z, CharSequence charSequence) {
        return charSequence.length() > 0 && contains(str, charSequence.charAt(charSequence.length() - 1)) == z;
    }

    /* INFO: renamed from: org.apache.commons.codec.language.bm.Rule$2, reason: invalid class name */
    class AnonymousClass2 implements RPattern {
        final Pattern pattern;
        final /* synthetic */ String val$regex;

        AnonymousClass2(String str) {
            this.val$regex = str;
            this.pattern = Pattern.compile(str);
        }

        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(CharSequence charSequence) {
            return this.pattern.matcher(charSequence).find();
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static boolean startsWith(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        for (int i = 0; i < charSequence2.length(); i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static String stripQuotes(String str) {
        if (str.startsWith(DOUBLE_QUOTE)) {
            str = str.substring(1);
        }
        return str.endsWith(DOUBLE_QUOTE) ? str.substring(0, str.length() - 1) : str;
    }

    public Rule(String str, String str2, String str3, PhonemeExpr phonemeExpr) {
        this.pattern = str;
        this.lContext = pattern(str2 + "$");
        this.rContext = pattern("^" + str3);
        this.phoneme = phonemeExpr;
    }

    public RPattern getLContext() {
        return this.lContext;
    }

    public String getPattern() {
        return this.pattern;
    }

    public PhonemeExpr getPhoneme() {
        return this.phoneme;
    }

    public RPattern getRContext() {
        return this.rContext;
    }

    public boolean patternAndContextMatches(CharSequence charSequence, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Can not match pattern at negative indexes");
        }
        int length = this.pattern.length() + i;
        if (length <= charSequence.length() && charSequence.subSequence(i, length).equals(this.pattern) && this.rContext.isMatch(charSequence.subSequence(length, charSequence.length()))) {
            return this.lContext.isMatch(charSequence.subSequence(0, i));
        }
        return false;
    }
}

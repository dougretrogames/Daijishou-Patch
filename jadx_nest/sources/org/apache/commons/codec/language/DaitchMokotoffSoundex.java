package org.apache.commons.codec.language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.Resources;
import org.apache.commons.codec.StringEncoder;
import org.eclipse.jgit.transport.WalkEncryption;

/* JADX INFO: loaded from: classes5.dex */
public class DaitchMokotoffSoundex implements StringEncoder {
    private static final String COMMENT = "//";
    private static final String DOUBLE_QUOTE = "\"";
    private static final Map<Character, Character> FOLDINGS;
    private static final int MAX_LENGTH = 6;
    private static final String MULTILINE_COMMENT_END = "*/";
    private static final String MULTILINE_COMMENT_START = "/*";
    private static final String RESOURCE_FILE = "/org/apache/commons/codec/language/dmrules.txt";
    private static final Map<Character, List<Rule>> RULES;
    private final boolean folding;

    private static final class Branch {
        private final StringBuilder builder;
        private String cachedString;
        private String lastReplacement;

        /* synthetic */ Branch(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Branch() {
            this.builder = new StringBuilder();
            this.lastReplacement = null;
            this.cachedString = null;
        }

        public Branch createBranch() {
            Branch branch = new Branch();
            branch.builder.append(toString());
            branch.lastReplacement = this.lastReplacement;
            return branch;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Branch) {
                return toString().equals(((Branch) obj).toString());
            }
            return false;
        }

        public void finish() {
            while (this.builder.length() < 6) {
                this.builder.append('0');
                this.cachedString = null;
            }
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public void processNextReplacement(String str, boolean z) {
            String str2 = this.lastReplacement;
            if ((str2 == null || !str2.endsWith(str) || z) && this.builder.length() < 6) {
                this.builder.append(str);
                if (this.builder.length() > 6) {
                    StringBuilder sb = this.builder;
                    sb.delete(6, sb.length());
                }
                this.cachedString = null;
            }
            this.lastReplacement = str;
        }

        public String toString() {
            if (this.cachedString == null) {
                this.cachedString = this.builder.toString();
            }
            return this.cachedString;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class Rule {
        private final String pattern;
        private final String[] replacementAtStart;
        private final String[] replacementBeforeVowel;
        private final String[] replacementDefault;

        private boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }

        protected Rule(String str, String str2, String str3, String str4) {
            this.pattern = str;
            this.replacementAtStart = str2.split("\\|");
            this.replacementBeforeVowel = str3.split("\\|");
            this.replacementDefault = str4.split("\\|");
        }

        public int getPatternLength() {
            return this.pattern.length();
        }

        public String[] getReplacements(String str, boolean z) {
            if (z) {
                return this.replacementAtStart;
            }
            int patternLength = getPatternLength();
            if (patternLength < str.length() && isVowel(str.charAt(patternLength))) {
                return this.replacementBeforeVowel;
            }
            return this.replacementDefault;
        }

        public boolean matches(String str) {
            return str.startsWith(this.pattern);
        }

        public String toString() {
            return String.format("%s=(%s,%s,%s)", this.pattern, Arrays.asList(this.replacementAtStart), Arrays.asList(this.replacementBeforeVowel), Arrays.asList(this.replacementDefault));
        }
    }

    static {
        HashMap map = new HashMap();
        RULES = map;
        HashMap map2 = new HashMap();
        FOLDINGS = map2;
        Scanner scanner = new Scanner(Resources.getInputStream(RESOURCE_FILE), CharEncoding.UTF_8);
        try {
            parseRules(scanner, RESOURCE_FILE, map, map2);
            scanner.close();
            map.forEach(new DaitchMokotoffSoundex$$ExternalSyntheticLambda2());
        } catch (Throwable th) {
            try {
                scanner.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    static /* synthetic */ int lambda$static$0(Rule rule, Rule rule2) {
        return rule2.getPatternLength() - rule.getPatternLength();
    }

    private static void parseRules(Scanner scanner, String str, Map<Character, List<Rule>> map, Map<Character, Character> map2) {
        int i = 0;
        boolean z = false;
        while (scanner.hasNextLine()) {
            i++;
            String strNextLine = scanner.nextLine();
            if (z) {
                if (strNextLine.endsWith(MULTILINE_COMMENT_END)) {
                    z = false;
                }
            } else if (strNextLine.startsWith("/*")) {
                z = true;
            } else {
                int iIndexOf = strNextLine.indexOf(COMMENT);
                String strTrim = (iIndexOf >= 0 ? strNextLine.substring(0, iIndexOf) : strNextLine).trim();
                if (strTrim.isEmpty()) {
                    continue;
                } else if (strTrim.contains("=")) {
                    String[] strArrSplit = strTrim.split("=");
                    if (strArrSplit.length != 2) {
                        throw new IllegalArgumentException("Malformed folding statement split into " + strArrSplit.length + " parts: " + strNextLine + " in " + str);
                    }
                    String str2 = strArrSplit[0];
                    String str3 = strArrSplit[1];
                    if (str2.length() != 1 || str3.length() != 1) {
                        throw new IllegalArgumentException("Malformed folding statement - patterns are not single characters: " + strNextLine + " in " + str);
                    }
                    map2.put(Character.valueOf(str2.charAt(0)), Character.valueOf(str3.charAt(0)));
                } else {
                    String[] strArrSplit2 = strTrim.split(WalkEncryption.Vals.REGEX_WS);
                    if (strArrSplit2.length != 4) {
                        throw new IllegalArgumentException("Malformed rule statement split into " + strArrSplit2.length + " parts: " + strNextLine + " in " + str);
                    }
                    try {
                        Rule rule = new Rule(stripQuotes(strArrSplit2[0]), stripQuotes(strArrSplit2[1]), stripQuotes(strArrSplit2[2]), stripQuotes(strArrSplit2[3]));
                        map.computeIfAbsent(Character.valueOf(rule.pattern.charAt(0)), new DaitchMokotoffSoundex$$ExternalSyntheticLambda0()).add(rule);
                    } catch (IllegalArgumentException e) {
                        throw new IllegalStateException("Problem parsing line '" + i + "' in " + str, e);
                    }
                }
            }
        }
    }

    static /* synthetic */ List lambda$parseRules$2(Character ch) {
        return new ArrayList();
    }

    private static String stripQuotes(String str) {
        if (str.startsWith(DOUBLE_QUOTE)) {
            str = str.substring(1);
        }
        return str.endsWith(DOUBLE_QUOTE) ? str.substring(0, str.length() - 1) : str;
    }

    public DaitchMokotoffSoundex() {
        this(true);
    }

    public DaitchMokotoffSoundex(boolean z) {
        this.folding = z;
    }

    private String cleanup(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                char lowerCase = Character.toLowerCase(c);
                Character ch = FOLDINGS.get(Character.valueOf(lowerCase));
                if (this.folding && ch != null) {
                    lowerCase = ch.charValue();
                }
                sb.append(lowerCase);
            }
        }
        return sb.toString();
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof String)) {
            throw new EncoderException("Parameter supplied to DaitchMokotoffSoundex encode is not of type java.lang.String");
        }
        return encode((String) obj);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        if (str == null) {
            return null;
        }
        return soundex(str, false)[0];
    }

    public String soundex(String str) {
        return String.join("|", soundex(str, true));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003b  */
    private String[] soundex(String str, boolean z) {
        String str2;
        String str3;
        boolean z2;
        if (str == null) {
            return null;
        }
        String strCleanup = cleanup(str);
        LinkedHashSet<Branch> linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Branch(null));
        int patternLength = 0;
        char c = 0;
        while (patternLength < strCleanup.length()) {
            char cCharAt = strCleanup.charAt(patternLength);
            boolean z3 = true;
            if (Character.isWhitespace(cCharAt)) {
                str2 = strCleanup;
            } else {
                String strSubstring = strCleanup.substring(patternLength);
                List<Rule> list = RULES.get(Character.valueOf(cCharAt));
                if (list == null) {
                    str2 = strCleanup;
                } else {
                    List arrayList = z ? new ArrayList() : Collections.emptyList();
                    Iterator<Rule> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            str2 = strCleanup;
                            break;
                        }
                        Rule next = it.next();
                        if (next.matches(strSubstring)) {
                            if (z) {
                                arrayList.clear();
                            }
                            String[] replacements = next.getReplacements(strSubstring, c == 0);
                            boolean z4 = replacements.length > 1 && z;
                            for (Branch branch : linkedHashSet) {
                                int length = replacements.length;
                                int i = 0;
                                while (true) {
                                    if (i >= length) {
                                        str3 = strCleanup;
                                        z2 = z3;
                                        break;
                                    }
                                    String str4 = replacements[i];
                                    Branch branchCreateBranch = z4 ? branch.createBranch() : branch;
                                    z2 = z3;
                                    str3 = strCleanup;
                                    branchCreateBranch.processNextReplacement(str4, ((c == 'm' && cCharAt == 'n') || (c == 'n' && cCharAt == 'm')) ? z2 : false);
                                    if (!z) {
                                        break;
                                    }
                                    arrayList.add(branchCreateBranch);
                                    i++;
                                    z3 = z2;
                                    strCleanup = str3;
                                }
                                z3 = z2;
                                strCleanup = str3;
                            }
                            str2 = strCleanup;
                            if (z) {
                                linkedHashSet.clear();
                                linkedHashSet.addAll(arrayList);
                            }
                            patternLength += next.getPatternLength() - 1;
                            break;
                        }
                    }
                    c = cCharAt;
                }
            }
            patternLength++;
            strCleanup = str2;
        }
        String[] strArr = new String[linkedHashSet.size()];
        int i2 = 0;
        for (Branch branch2 : linkedHashSet) {
            branch2.finish();
            strArr[i2] = branch2.toString();
            i2++;
        }
        return strArr;
    }
}

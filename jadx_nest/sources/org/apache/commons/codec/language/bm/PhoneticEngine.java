package org.apache.commons.codec.language.bm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.apache.commons.codec.language.Soundex;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.transport.WalkEncryption;

/* JADX INFO: loaded from: classes5.dex */
public class PhoneticEngine {
    private static final int DEFAULT_MAX_PHONEMES = 20;
    private static final Map<NameType, Set<String>> NAME_PREFIXES;
    private final boolean concat;
    private final Lang lang;
    private final int maxPhonemes;
    private final NameType nameType;
    private final RuleType ruleType;

    static final class PhonemeBuilder {
        private final Set<Rule.Phoneme> phonemes;

        /* synthetic */ PhonemeBuilder(Set set, AnonymousClass1 anonymousClass1) {
            this((Set<Rule.Phoneme>) set);
        }

        public static PhonemeBuilder empty(Languages.LanguageSet languageSet) {
            return new PhonemeBuilder(new Rule.Phoneme("", languageSet));
        }

        private PhonemeBuilder(Rule.Phoneme phoneme) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            this.phonemes = linkedHashSet;
            linkedHashSet.add(phoneme);
        }

        private PhonemeBuilder(Set<Rule.Phoneme> set) {
            this.phonemes = set;
        }

        public void append(CharSequence charSequence) {
            this.phonemes.forEach(new PhoneticEngine$PhonemeBuilder$$ExternalSyntheticLambda1(charSequence));
        }

        public void apply(Rule.PhonemeExpr phonemeExpr, int i) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(Math.min(this.phonemes.size() * phonemeExpr.size(), i));
            loop0: for (Rule.Phoneme phoneme : this.phonemes) {
                for (Rule.Phoneme phoneme2 : phonemeExpr.getPhonemes()) {
                    Languages.LanguageSet languageSetRestrictTo = phoneme.getLanguages().restrictTo(phoneme2.getLanguages());
                    if (!languageSetRestrictTo.isEmpty()) {
                        Rule.Phoneme phoneme3 = new Rule.Phoneme(phoneme, phoneme2, languageSetRestrictTo);
                        if (linkedHashSet.size() < i) {
                            linkedHashSet.add(phoneme3);
                            if (linkedHashSet.size() >= i) {
                                break loop0;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            this.phonemes.clear();
            this.phonemes.addAll(linkedHashSet);
        }

        public Set<Rule.Phoneme> getPhonemes() {
            return this.phonemes;
        }

        public String makeString() {
            return (String) this.phonemes.stream().map(new PhoneticEngine$PhonemeBuilder$$ExternalSyntheticLambda0()).collect(Collectors.joining("|"));
        }
    }

    private static final class RulesApplication {
        private final Map<String, List<Rule>> finalRules;
        private boolean found;
        private int i;
        private final CharSequence input;
        private final int maxPhonemes;
        private final PhonemeBuilder phonemeBuilder;

        RulesApplication(Map<String, List<Rule>> map, CharSequence charSequence, PhonemeBuilder phonemeBuilder, int i, int i2) {
            Objects.requireNonNull(map, "finalRules");
            this.finalRules = map;
            this.phonemeBuilder = phonemeBuilder;
            this.input = charSequence;
            this.i = i;
            this.maxPhonemes = i2;
        }

        public int getI() {
            return this.i;
        }

        public PhonemeBuilder getPhonemeBuilder() {
            return this.phonemeBuilder;
        }

        public RulesApplication invoke() {
            int i;
            this.found = false;
            Map<String, List<Rule>> map = this.finalRules;
            CharSequence charSequence = this.input;
            int i2 = this.i;
            List<Rule> list = map.get(charSequence.subSequence(i2, i2 + 1));
            if (list != null) {
                i = 1;
                for (Rule rule : list) {
                    int length = rule.getPattern().length();
                    if (rule.patternAndContextMatches(this.input, this.i)) {
                        this.phonemeBuilder.apply(rule.getPhoneme(), this.maxPhonemes);
                        this.found = true;
                        i = length;
                        break;
                    }
                    i = length;
                }
            } else {
                i = 1;
            }
            this.i += this.found ? i : 1;
            return this;
        }

        public boolean isFound() {
            return this.found;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(NameType.class);
        NAME_PREFIXES = enumMap;
        enumMap.put(NameType.ASHKENAZI, Collections.unmodifiableSet(new HashSet(Arrays.asList("bar", "ben", "da", "de", "van", "von"))));
        enumMap.put(NameType.SEPHARDIC, Collections.unmodifiableSet(new HashSet(Arrays.asList("al", "el", "da", "dal", "de", "del", "dela", "de la", "della", "des", "di", "do", "dos", "du", "van", "von"))));
        enumMap.put(NameType.GENERIC, Collections.unmodifiableSet(new HashSet(Arrays.asList("da", "dal", "de", "del", "dela", "de la", "della", "des", "di", "do", "dos", "du", "van", "von"))));
    }

    private static String join(List<String> list, String str) {
        return (String) list.stream().collect(Collectors.joining(str));
    }

    public PhoneticEngine(NameType nameType, RuleType ruleType, boolean z) {
        this(nameType, ruleType, z, 20);
    }

    public PhoneticEngine(NameType nameType, RuleType ruleType, boolean z, int i) {
        if (ruleType == RuleType.RULES) {
            throw new IllegalArgumentException("ruleType must not be " + RuleType.RULES);
        }
        this.nameType = nameType;
        this.ruleType = ruleType;
        this.concat = z;
        this.lang = Lang.instance(nameType);
        this.maxPhonemes = i;
    }

    private PhonemeBuilder applyFinalRules(PhonemeBuilder phonemeBuilder, Map<String, List<Rule>> map) {
        Objects.requireNonNull(map, "finalRules");
        if (map.isEmpty()) {
            return phonemeBuilder;
        }
        TreeMap treeMap = new TreeMap(Rule.Phoneme.COMPARATOR);
        phonemeBuilder.getPhonemes().forEach(new PhoneticEngine$$ExternalSyntheticLambda3(this, map, treeMap));
        return new PhonemeBuilder(treeMap.keySet(), null);
    }

    /* JADX INFO: renamed from: lambda$applyFinalRules$1$org-apache-commons-codec-language-bm-PhoneticEngine, reason: not valid java name */
    /* synthetic */ void m5525xf7464fbc(Map map, Map map2, Rule.Phoneme phoneme) {
        PhonemeBuilder phonemeBuilderEmpty = PhonemeBuilder.empty(phoneme.getLanguages());
        String string = phoneme.getPhonemeText().toString();
        int i = 0;
        PhonemeBuilder phonemeBuilder = phonemeBuilderEmpty;
        while (i < string.length()) {
            Map map3 = map;
            RulesApplication rulesApplicationInvoke = new RulesApplication(map3, string, phonemeBuilder, i, this.maxPhonemes).invoke();
            boolean zIsFound = rulesApplicationInvoke.isFound();
            phonemeBuilder = rulesApplicationInvoke.getPhonemeBuilder();
            if (!zIsFound) {
                phonemeBuilder.append(string.subSequence(i, i + 1));
            }
            i = rulesApplicationInvoke.getI();
            map = map3;
        }
        phonemeBuilder.getPhonemes().forEach(new PhoneticEngine$$ExternalSyntheticLambda2(map2));
    }

    static /* synthetic */ void lambda$applyFinalRules$0(Map map, Rule.Phoneme phoneme) {
        if (map.containsKey(phoneme)) {
            Rule.Phoneme phonemeMergeWithLanguage = ((Rule.Phoneme) map.remove(phoneme)).mergeWithLanguage(phoneme.getLanguages());
            map.put(phonemeMergeWithLanguage, phonemeMergeWithLanguage);
        } else {
            map.put(phoneme, phoneme);
        }
    }

    public String encode(String str) {
        return encode(str, this.lang.guessLanguages(str));
    }

    public String encode(String str, Languages.LanguageSet languageSet) {
        Map<String, List<Rule>> instanceMap = Rule.getInstanceMap(this.nameType, RuleType.RULES, languageSet);
        Map<String, List<Rule>> instanceMap2 = Rule.getInstanceMap(this.nameType, this.ruleType, "common");
        Map<String, List<Rule>> instanceMap3 = Rule.getInstanceMap(this.nameType, this.ruleType, languageSet);
        String strTrim = str.toLowerCase(Locale.ENGLISH).replace(Soundex.SILENT_MARKER, TokenParser.SP).trim();
        if (this.nameType == NameType.GENERIC) {
            if (strTrim.startsWith("d'")) {
                String strSubstring = strTrim.substring(2);
                return "(" + encode(strSubstring) + ")-(" + encode("d" + strSubstring) + ")";
            }
            for (String str2 : NAME_PREFIXES.get(this.nameType)) {
                if (strTrim.startsWith(str2 + " ")) {
                    String strSubstring2 = strTrim.substring(str2.length() + 1);
                    return "(" + encode(strSubstring2) + ")-(" + encode(str2 + strSubstring2) + ")";
                }
            }
        }
        List listAsList = Arrays.asList(strTrim.split(WalkEncryption.Vals.REGEX_WS));
        ArrayList arrayList = new ArrayList();
        int i = AnonymousClass1.$SwitchMap$org$apache$commons$codec$language$bm$NameType[this.nameType.ordinal()];
        if (i == 1) {
            listAsList.forEach(new PhoneticEngine$$ExternalSyntheticLambda0(arrayList));
            arrayList.removeAll(NAME_PREFIXES.get(this.nameType));
        } else if (i == 2) {
            arrayList.addAll(listAsList);
            arrayList.removeAll(NAME_PREFIXES.get(this.nameType));
        } else if (i == 3) {
            arrayList.addAll(listAsList);
        } else {
            throw new IllegalStateException("Unreachable case: " + this.nameType);
        }
        if (this.concat) {
            strTrim = join(arrayList, " ");
        } else if (arrayList.size() == 1) {
            strTrim = (String) listAsList.iterator().next();
        } else if (!arrayList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            arrayList.forEach(new PhoneticEngine$$ExternalSyntheticLambda1(this, sb));
            return sb.substring(1);
        }
        String str3 = strTrim;
        PhonemeBuilder phonemeBuilderEmpty = PhonemeBuilder.empty(languageSet);
        int i2 = 0;
        while (i2 < str3.length()) {
            RulesApplication rulesApplicationInvoke = new RulesApplication(instanceMap, str3, phonemeBuilderEmpty, i2, this.maxPhonemes).invoke();
            i2 = rulesApplicationInvoke.getI();
            phonemeBuilderEmpty = rulesApplicationInvoke.getPhonemeBuilder();
        }
        return applyFinalRules(applyFinalRules(phonemeBuilderEmpty, instanceMap2), instanceMap3).makeString();
    }

    /* JADX INFO: renamed from: org.apache.commons.codec.language.bm.PhoneticEngine$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$codec$language$bm$NameType;

        static {
            int[] iArr = new int[NameType.values().length];
            $SwitchMap$org$apache$commons$codec$language$bm$NameType = iArr;
            try {
                iArr[NameType.SEPHARDIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$codec$language$bm$NameType[NameType.ASHKENAZI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$codec$language$bm$NameType[NameType.GENERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static /* synthetic */ void lambda$encode$2(List list, String str) {
        String[] strArrSplit = str.split("'", -1);
        list.add(strArrSplit[strArrSplit.length - 1]);
    }

    /* JADX INFO: renamed from: lambda$encode$3$org-apache-commons-codec-language-bm-PhoneticEngine, reason: not valid java name */
    /* synthetic */ void m5526xb393c13f(StringBuilder sb, String str) {
        sb.append("-").append(encode(str));
    }

    public Lang getLang() {
        return this.lang;
    }

    public int getMaxPhonemes() {
        return this.maxPhonemes;
    }

    public NameType getNameType() {
        return this.nameType;
    }

    public RuleType getRuleType() {
        return this.ruleType;
    }

    public boolean isConcat() {
        return this.concat;
    }
}

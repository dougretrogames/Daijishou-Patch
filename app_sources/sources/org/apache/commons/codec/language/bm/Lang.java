package org.apache.commons.codec.language.bm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.commons.codec.Resources;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.WalkEncryption;

/* INFO: loaded from: classes5.dex */
public class Lang {
    private static final Map<NameType, Lang> LANGS = new EnumMap(NameType.class);
    private static final String LANGUAGE_RULES_RN = "/org/apache/commons/codec/language/bm/%s_lang.txt";
    private final Languages languages;
    private final List<LangRule> rules;

    /* INFO: Access modifiers changed from: private */
    static final class LangRule {
        private final boolean acceptOnMatch;
        private final Set<String> languages;
        private final Pattern pattern;

        /* synthetic */ LangRule(Pattern pattern, Set set, boolean z, AnonymousClass1 anonymousClass1) {
            this(pattern, set, z);
        }

        private LangRule(Pattern pattern, Set<String> set, boolean z) {
            this.pattern = pattern;
            this.languages = set;
            this.acceptOnMatch = z;
        }

        public boolean matches(String str) {
            return this.pattern.matcher(str).find();
        }
    }

    static {
        for (NameType nameType : NameType.values()) {
            LANGS.put(nameType, loadFromResource(String.format(LANGUAGE_RULES_RN, nameType.getName()), Languages.getInstance(nameType)));
        }
    }

    public static Lang instance(NameType nameType) {
        return LANGS.get(nameType);
    }

    public static Lang loadFromResource(String str, Languages languages) {
        ArrayList arrayList = new ArrayList();
        Scanner scanner = new Scanner(Resources.getInputStream(str), ResourceConstants.ENCODING);
        while (true) {
            boolean z = false;
            while (true) {
                try {
                    if (scanner.hasNextLine()) {
                        String strNextLine = scanner.nextLine();
                        if (z) {
                            if (strNextLine.endsWith("*/")) {
                                break;
                            }
                        } else if (strNextLine.startsWith(RefSpec.WILDCARD_SUFFIX)) {
                            z = true;
                        } else {
                            int iIndexOf = strNextLine.indexOf("//");
                            String strTrim = (iIndexOf >= 0 ? strNextLine.substring(0, iIndexOf) : strNextLine).trim();
                            if (!strTrim.isEmpty()) {
                                String[] strArrSplit = strTrim.split(WalkEncryption.Vals.REGEX_WS);
                                if (strArrSplit.length != 3) {
                                    throw new IllegalArgumentException("Malformed line '" + strNextLine + "' in language resource '" + str + "'");
                                }
                                arrayList.add(new LangRule(Pattern.compile(strArrSplit[0]), new HashSet(Arrays.asList(strArrSplit[1].split("\\+"))), strArrSplit[2].equals("true"), null));
                            }
                        }
                    } else {
                        scanner.close();
                        return new Lang(arrayList, languages);
                    }
                } catch (Throwable th) {
                    try {
                        scanner.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        }
    }

    private Lang(List<LangRule> list, Languages languages) {
        this.rules = Collections.unmodifiableList(list);
        this.languages = languages;
    }

    public String guessLanguage(String str) {
        Languages.LanguageSet languageSetGuessLanguages = guessLanguages(str);
        return languageSetGuessLanguages.isSingleton() ? languageSetGuessLanguages.getAny() : Languages.ANY;
    }

    public Languages.LanguageSet guessLanguages(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        HashSet hashSet = new HashSet(this.languages.getLanguages());
        this.rules.forEach(new Lang$$ExternalSyntheticLambda0(lowerCase, hashSet));
        Languages.LanguageSet languageSetFrom = Languages.LanguageSet.from(hashSet);
        return languageSetFrom.equals(Languages.NO_LANGUAGES) ? Languages.ANY_LANGUAGE : languageSetFrom;
    }

    static /* synthetic */ void lambda$guessLanguages$0(String str, Set set, LangRule langRule) {
        if (langRule.matches(str)) {
            if (langRule.acceptOnMatch) {
                set.retainAll(langRule.languages);
            } else {
                set.removeAll(langRule.languages);
            }
        }
    }
}

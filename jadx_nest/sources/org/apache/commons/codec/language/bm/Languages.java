package org.apache.commons.codec.language.bm;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.codec.Resources;
import org.eclipse.jgit.transport.RefSpec;

/* INFO: loaded from: classes5.dex */
public class Languages {
    public static final String ANY = "any";
    private final Set<String> languages;
    private static final Map<NameType, Languages> LANGUAGES = new EnumMap(NameType.class);
    public static final LanguageSet NO_LANGUAGES = new AnonymousClass1();
    public static final LanguageSet ANY_LANGUAGE = new AnonymousClass2();

    public static abstract class LanguageSet {
        public abstract boolean contains(String str);

        public abstract String getAny();

        public abstract boolean isEmpty();

        public abstract boolean isSingleton();

        abstract LanguageSet merge(LanguageSet languageSet);

        public abstract LanguageSet restrictTo(LanguageSet languageSet);

        public static LanguageSet from(Set<String> set) {
            return set.isEmpty() ? Languages.NO_LANGUAGES : new SomeLanguages(set, null);
        }
    }

    public static final class SomeLanguages extends LanguageSet {
        private final Set<String> languages;

        /* synthetic */ SomeLanguages(Set set, AnonymousClass1 anonymousClass1) {
            this(set);
        }

        private SomeLanguages(Set<String> set) {
            this.languages = Collections.unmodifiableSet(set);
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean contains(String str) {
            return this.languages.contains(str);
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public String getAny() {
            return this.languages.iterator().next();
        }

        public Set<String> getLanguages() {
            return this.languages;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean isEmpty() {
            return this.languages.isEmpty();
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean isSingleton() {
            return this.languages.size() == 1;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public LanguageSet merge(LanguageSet languageSet) {
            if (languageSet == Languages.NO_LANGUAGES) {
                return this;
            }
            if (languageSet == Languages.ANY_LANGUAGE) {
                return languageSet;
            }
            HashSet hashSet = new HashSet(this.languages);
            hashSet.addAll(((SomeLanguages) languageSet).languages);
            return from(hashSet);
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public LanguageSet restrictTo(LanguageSet languageSet) {
            if (languageSet == Languages.NO_LANGUAGES) {
                return languageSet;
            }
            return languageSet == Languages.ANY_LANGUAGE ? this : from((Set) this.languages.stream().filter(new Languages$SomeLanguages$$ExternalSyntheticLambda0((SomeLanguages) languageSet)).collect(Collectors.toSet()));
        }

        public String toString() {
            return "Languages(" + this.languages.toString() + ")";
        }
    }

    static {
        for (NameType nameType : NameType.values()) {
            LANGUAGES.put(nameType, getInstance(langResourceName(nameType)));
        }
    }

    /* INFO: renamed from: org.apache.commons.codec.language.bm.Languages$1, reason: invalid class name */
    class AnonymousClass1 extends LanguageSet {
        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean contains(String str) {
            return false;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean isEmpty() {
            return true;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean isSingleton() {
            return false;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public LanguageSet merge(LanguageSet languageSet) {
            return languageSet;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public LanguageSet restrictTo(LanguageSet languageSet) {
            return this;
        }

        AnonymousClass1() {
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public String getAny() {
            throw new NoSuchElementException("Can't fetch any language from the empty language set.");
        }

        public String toString() {
            return "NO_LANGUAGES";
        }
    }

    /* INFO: renamed from: org.apache.commons.codec.language.bm.Languages$2, reason: invalid class name */
    class AnonymousClass2 extends LanguageSet {
        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean contains(String str) {
            return true;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean isEmpty() {
            return false;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean isSingleton() {
            return false;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public LanguageSet merge(LanguageSet languageSet) {
            return languageSet;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public LanguageSet restrictTo(LanguageSet languageSet) {
            return languageSet;
        }

        AnonymousClass2() {
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public String getAny() {
            throw new NoSuchElementException("Can't fetch any language from the any language set.");
        }

        public String toString() {
            return "ANY_LANGUAGE";
        }
    }

    public static Languages getInstance(NameType nameType) {
        return LANGUAGES.get(nameType);
    }

    public static Languages getInstance(String str) {
        HashSet hashSet = new HashSet();
        Scanner scanner = new Scanner(Resources.getInputStream(str), ResourceConstants.ENCODING);
        while (true) {
            boolean z = false;
            while (true) {
                try {
                    if (scanner.hasNextLine()) {
                        String strTrim = scanner.nextLine().trim();
                        if (z) {
                            if (strTrim.endsWith("*/")) {
                                break;
                            }
                        } else if (strTrim.startsWith(RefSpec.WILDCARD_SUFFIX)) {
                            z = true;
                        } else if (!strTrim.isEmpty()) {
                            hashSet.add(strTrim);
                        }
                    } else {
                        Languages languages = new Languages(Collections.unmodifiableSet(hashSet));
                        scanner.close();
                        return languages;
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

    private static String langResourceName(NameType nameType) {
        return String.format("/org/apache/commons/codec/language/bm/%s_languages.txt", nameType.getName());
    }

    private Languages(Set<String> set) {
        this.languages = set;
    }

    public Set<String> getLanguages() {
        return this.languages;
    }
}

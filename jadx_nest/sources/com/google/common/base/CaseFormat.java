package com.google.common.base;

import java.io.Serializable;
import javax.annotation.CheckForNull;
import org.apache.commons.codec.language.Soundex;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class CaseFormat {
    private final CharMatcher wordBoundary;
    private final String wordSeparator;
    public static final CaseFormat LOWER_HYPHEN = new AnonymousClass1("LOWER_HYPHEN", 0, CharMatcher.is(Soundex.SILENT_MARKER), "-");
    public static final CaseFormat LOWER_UNDERSCORE = new AnonymousClass2("LOWER_UNDERSCORE", 1, CharMatcher.is('_'), "_");
    public static final CaseFormat LOWER_CAMEL = new AnonymousClass3("LOWER_CAMEL", 2, CharMatcher.inRange('A', 'Z'), "");
    public static final CaseFormat UPPER_CAMEL = new AnonymousClass4("UPPER_CAMEL", 3, CharMatcher.inRange('A', 'Z'), "");
    public static final CaseFormat UPPER_UNDERSCORE = new AnonymousClass5("UPPER_UNDERSCORE", 4, CharMatcher.is('_'), "_");
    private static final /* synthetic */ CaseFormat[] $VALUES = $values();

    abstract String normalizeWord(String word);

    private static /* synthetic */ CaseFormat[] $values() {
        return new CaseFormat[]{LOWER_HYPHEN, LOWER_UNDERSCORE, LOWER_CAMEL, UPPER_CAMEL, UPPER_UNDERSCORE};
    }

    public static CaseFormat valueOf(String name) {
        return (CaseFormat) Enum.valueOf(CaseFormat.class, name);
    }

    public static CaseFormat[] values() {
        return (CaseFormat[]) $VALUES.clone();
    }

    /* synthetic */ CaseFormat(String str, int i, CharMatcher charMatcher, String str2, AnonymousClass1 anonymousClass1) {
        this(str, i, charMatcher, str2);
    }

    /* JADX INFO: renamed from: com.google.common.base.CaseFormat$1, reason: invalid class name */
    final enum AnonymousClass1 extends CaseFormat {
        AnonymousClass1(String $enum$name, int $enum$ordinal, CharMatcher wordBoundary, String wordSeparator) {
            super($enum$name, $enum$ordinal, wordBoundary, wordSeparator, null);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String word) {
            return Ascii.toLowerCase(word);
        }

        @Override // com.google.common.base.CaseFormat
        String convert(CaseFormat format, String s) {
            if (format == LOWER_UNDERSCORE) {
                return s.replace(Soundex.SILENT_MARKER, '_');
            }
            if (format == UPPER_UNDERSCORE) {
                return Ascii.toUpperCase(s.replace(Soundex.SILENT_MARKER, '_'));
            }
            return super.convert(format, s);
        }
    }

    /* JADX INFO: renamed from: com.google.common.base.CaseFormat$2, reason: invalid class name */
    final enum AnonymousClass2 extends CaseFormat {
        AnonymousClass2(String $enum$name, int $enum$ordinal, CharMatcher wordBoundary, String wordSeparator) {
            super($enum$name, $enum$ordinal, wordBoundary, wordSeparator, null);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String word) {
            return Ascii.toLowerCase(word);
        }

        @Override // com.google.common.base.CaseFormat
        String convert(CaseFormat format, String s) {
            if (format == LOWER_HYPHEN) {
                return s.replace('_', Soundex.SILENT_MARKER);
            }
            if (format == UPPER_UNDERSCORE) {
                return Ascii.toUpperCase(s);
            }
            return super.convert(format, s);
        }
    }

    /* JADX INFO: renamed from: com.google.common.base.CaseFormat$3, reason: invalid class name */
    final enum AnonymousClass3 extends CaseFormat {
        AnonymousClass3(String $enum$name, int $enum$ordinal, CharMatcher wordBoundary, String wordSeparator) {
            super($enum$name, $enum$ordinal, wordBoundary, wordSeparator, null);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String word) {
            return CaseFormat.firstCharOnlyToUpper(word);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeFirstWord(String word) {
            return Ascii.toLowerCase(word);
        }
    }

    /* JADX INFO: renamed from: com.google.common.base.CaseFormat$4, reason: invalid class name */
    final enum AnonymousClass4 extends CaseFormat {
        AnonymousClass4(String $enum$name, int $enum$ordinal, CharMatcher wordBoundary, String wordSeparator) {
            super($enum$name, $enum$ordinal, wordBoundary, wordSeparator, null);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String word) {
            return CaseFormat.firstCharOnlyToUpper(word);
        }
    }

    /* JADX INFO: renamed from: com.google.common.base.CaseFormat$5, reason: invalid class name */
    final enum AnonymousClass5 extends CaseFormat {
        AnonymousClass5(String $enum$name, int $enum$ordinal, CharMatcher wordBoundary, String wordSeparator) {
            super($enum$name, $enum$ordinal, wordBoundary, wordSeparator, null);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String word) {
            return Ascii.toUpperCase(word);
        }

        @Override // com.google.common.base.CaseFormat
        String convert(CaseFormat format, String s) {
            if (format == LOWER_HYPHEN) {
                return Ascii.toLowerCase(s.replace('_', Soundex.SILENT_MARKER));
            }
            if (format == LOWER_UNDERSCORE) {
                return Ascii.toLowerCase(s);
            }
            return super.convert(format, s);
        }
    }

    private CaseFormat(String $enum$name, int $enum$ordinal, CharMatcher wordBoundary, String wordSeparator) {
        super($enum$name, $enum$ordinal);
        this.wordBoundary = wordBoundary;
        this.wordSeparator = wordSeparator;
    }

    public final String to(CaseFormat format, String str) {
        Preconditions.checkNotNull(format);
        Preconditions.checkNotNull(str);
        return format == this ? str : convert(format, str);
    }

    String convert(CaseFormat format, String s) {
        StringBuilder sb = null;
        int length = 0;
        int iIndexIn = -1;
        while (true) {
            iIndexIn = this.wordBoundary.indexIn(s, iIndexIn + 1);
            if (iIndexIn == -1) {
                break;
            }
            if (length == 0) {
                sb = new StringBuilder(s.length() + (format.wordSeparator.length() * 4));
                sb.append(format.normalizeFirstWord(s.substring(length, iIndexIn)));
            } else {
                ((StringBuilder) java.util.Objects.requireNonNull(sb)).append(format.normalizeWord(s.substring(length, iIndexIn)));
            }
            sb.append(format.wordSeparator);
            length = this.wordSeparator.length() + iIndexIn;
        }
        if (length == 0) {
            return format.normalizeFirstWord(s);
        }
        return ((StringBuilder) java.util.Objects.requireNonNull(sb)).append(format.normalizeWord(s.substring(length))).toString();
    }

    public Converter<String, String> converterTo(CaseFormat targetFormat) {
        return new StringConverter(this, targetFormat);
    }

    private static final class StringConverter extends Converter<String, String> implements Serializable {
        private static final long serialVersionUID = 0;
        private final CaseFormat sourceFormat;
        private final CaseFormat targetFormat;

        StringConverter(CaseFormat sourceFormat, CaseFormat targetFormat) {
            this.sourceFormat = (CaseFormat) Preconditions.checkNotNull(sourceFormat);
            this.targetFormat = (CaseFormat) Preconditions.checkNotNull(targetFormat);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public String doForward(String s) {
            return this.sourceFormat.to(this.targetFormat, s);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public String doBackward(String s) {
            return this.targetFormat.to(this.sourceFormat, s);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@CheckForNull Object object) {
            if (object instanceof StringConverter) {
                StringConverter stringConverter = (StringConverter) object;
                if (this.sourceFormat.equals(stringConverter.sourceFormat) && this.targetFormat.equals(stringConverter.targetFormat)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
        }

        public String toString() {
            return this.sourceFormat + ".converterTo(" + this.targetFormat + ")";
        }
    }

    String normalizeFirstWord(String word) {
        return normalizeWord(word);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String firstCharOnlyToUpper(String word) {
        return word.isEmpty() ? word : Ascii.toUpperCase(word.charAt(0)) + Ascii.toLowerCase(word.substring(1));
    }
}

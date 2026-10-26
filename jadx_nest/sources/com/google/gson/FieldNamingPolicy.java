package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.message.TokenParser;

/* WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* WARN: Unknown enum class pattern. Please report as an issue! */
/* INFO: loaded from: classes4.dex */
public abstract class FieldNamingPolicy implements FieldNamingStrategy {
    private static final /* synthetic */ FieldNamingPolicy[] $VALUES;
    public static final FieldNamingPolicy IDENTITY;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DASHES;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DOTS;
    public static final FieldNamingPolicy LOWER_CASE_WITH_UNDERSCORES;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE_WITH_SPACES;
    public static final FieldNamingPolicy UPPER_CASE_WITH_UNDERSCORES;

    private FieldNamingPolicy(String str, int i) {
        super(str, i);
    }

    /* synthetic */ FieldNamingPolicy(String str, int i, AnonymousClass1 anonymousClass1) {
        this(str, i);
    }

    public static FieldNamingPolicy valueOf(String str) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, str);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) $VALUES.clone();
    }

    /* INFO: renamed from: com.google.gson.FieldNamingPolicy$1, reason: invalid class name */
    final enum AnonymousClass1 extends FieldNamingPolicy {
        AnonymousClass1(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return field.getName();
        }
    }

    static {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1("IDENTITY", 0);
        IDENTITY = anonymousClass1;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2("UPPER_CAMEL_CASE", 1);
        UPPER_CAMEL_CASE = anonymousClass2;
        AnonymousClass3 anonymousClass3 = new AnonymousClass3("UPPER_CAMEL_CASE_WITH_SPACES", 2);
        UPPER_CAMEL_CASE_WITH_SPACES = anonymousClass3;
        AnonymousClass4 anonymousClass4 = new AnonymousClass4("UPPER_CASE_WITH_UNDERSCORES", 3);
        UPPER_CASE_WITH_UNDERSCORES = anonymousClass4;
        AnonymousClass5 anonymousClass5 = new AnonymousClass5("LOWER_CASE_WITH_UNDERSCORES", 4);
        LOWER_CASE_WITH_UNDERSCORES = anonymousClass5;
        AnonymousClass6 anonymousClass6 = new AnonymousClass6("LOWER_CASE_WITH_DASHES", 5);
        LOWER_CASE_WITH_DASHES = anonymousClass6;
        AnonymousClass7 anonymousClass7 = new AnonymousClass7("LOWER_CASE_WITH_DOTS", 6);
        LOWER_CASE_WITH_DOTS = anonymousClass7;
        $VALUES = new FieldNamingPolicy[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5, anonymousClass6, anonymousClass7};
    }

    /* INFO: renamed from: com.google.gson.FieldNamingPolicy$2, reason: invalid class name */
    final enum AnonymousClass2 extends FieldNamingPolicy {
        AnonymousClass2(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return upperCaseFirstLetter(field.getName());
        }
    }

    /* INFO: renamed from: com.google.gson.FieldNamingPolicy$3, reason: invalid class name */
    final enum AnonymousClass3 extends FieldNamingPolicy {
        AnonymousClass3(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return upperCaseFirstLetter(separateCamelCase(field.getName(), TokenParser.SP));
        }
    }

    /* INFO: renamed from: com.google.gson.FieldNamingPolicy$4, reason: invalid class name */
    final enum AnonymousClass4 extends FieldNamingPolicy {
        AnonymousClass4(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return separateCamelCase(field.getName(), '_').toUpperCase(Locale.ENGLISH);
        }
    }

    /* INFO: renamed from: com.google.gson.FieldNamingPolicy$5, reason: invalid class name */
    final enum AnonymousClass5 extends FieldNamingPolicy {
        AnonymousClass5(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return separateCamelCase(field.getName(), '_').toLowerCase(Locale.ENGLISH);
        }
    }

    /* INFO: renamed from: com.google.gson.FieldNamingPolicy$6, reason: invalid class name */
    final enum AnonymousClass6 extends FieldNamingPolicy {
        AnonymousClass6(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return separateCamelCase(field.getName(), Soundex.SILENT_MARKER).toLowerCase(Locale.ENGLISH);
        }
    }

    /* INFO: renamed from: com.google.gson.FieldNamingPolicy$7, reason: invalid class name */
    final enum AnonymousClass7 extends FieldNamingPolicy {
        AnonymousClass7(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return separateCamelCase(field.getName(), FilenameUtils.EXTENSION_SEPARATOR).toLowerCase(Locale.ENGLISH);
        }
    }

    static String separateCamelCase(String str, char c) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    static String upperCaseFirstLetter(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isLetter(cCharAt)) {
                if (Character.isUpperCase(cCharAt)) {
                    break;
                }
                char upperCase = Character.toUpperCase(cCharAt);
                if (i == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i) + upperCase + str.substring(i + 1);
            }
        }
        return str;
    }
}

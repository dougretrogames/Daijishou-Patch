package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.math.BigDecimal;

/* WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* WARN: Unknown enum class pattern. Please report as an issue! */
/* INFO: loaded from: classes4.dex */
public abstract class ToNumberPolicy implements ToNumberStrategy {
    private static final /* synthetic */ ToNumberPolicy[] $VALUES;
    public static final ToNumberPolicy BIG_DECIMAL;
    public static final ToNumberPolicy DOUBLE;
    public static final ToNumberPolicy LAZILY_PARSED_NUMBER;
    public static final ToNumberPolicy LONG_OR_DOUBLE;

    private ToNumberPolicy(String str, int i) {
        super(str, i);
    }

    /* synthetic */ ToNumberPolicy(String str, int i, AnonymousClass1 anonymousClass1) {
        this(str, i);
    }

    public static ToNumberPolicy valueOf(String str) {
        return (ToNumberPolicy) Enum.valueOf(ToNumberPolicy.class, str);
    }

    public static ToNumberPolicy[] values() {
        return (ToNumberPolicy[]) $VALUES.clone();
    }

    /* INFO: renamed from: com.google.gson.ToNumberPolicy$1, reason: invalid class name */
    final enum AnonymousClass1 extends ToNumberPolicy {
        AnonymousClass1(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.ToNumberStrategy
        public Double readNumber(JsonReader jsonReader) throws IOException {
            return Double.valueOf(jsonReader.nextDouble());
        }
    }

    static {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1("DOUBLE", 0);
        DOUBLE = anonymousClass1;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2("LAZILY_PARSED_NUMBER", 1);
        LAZILY_PARSED_NUMBER = anonymousClass2;
        AnonymousClass3 anonymousClass3 = new AnonymousClass3("LONG_OR_DOUBLE", 2);
        LONG_OR_DOUBLE = anonymousClass3;
        AnonymousClass4 anonymousClass4 = new AnonymousClass4("BIG_DECIMAL", 3);
        BIG_DECIMAL = anonymousClass4;
        $VALUES = new ToNumberPolicy[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4};
    }

    /* INFO: renamed from: com.google.gson.ToNumberPolicy$2, reason: invalid class name */
    final enum AnonymousClass2 extends ToNumberPolicy {
        AnonymousClass2(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.ToNumberStrategy
        public Number readNumber(JsonReader jsonReader) throws IOException {
            return new LazilyParsedNumber(jsonReader.nextString());
        }
    }

    /* INFO: renamed from: com.google.gson.ToNumberPolicy$3, reason: invalid class name */
    final enum AnonymousClass3 extends ToNumberPolicy {
        AnonymousClass3(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.ToNumberStrategy
        public Number readNumber(JsonReader jsonReader) throws JsonParseException, IOException {
            String strNextString = jsonReader.nextString();
            try {
                try {
                    return Long.valueOf(Long.parseLong(strNextString));
                } catch (NumberFormatException e) {
                    throw new JsonParseException("Cannot parse " + strNextString + "; at path " + jsonReader.getPreviousPath(), e);
                }
            } catch (NumberFormatException unused) {
                Double dValueOf = Double.valueOf(strNextString);
                if ((dValueOf.isInfinite() || dValueOf.isNaN()) && !jsonReader.isLenient()) {
                    throw new MalformedJsonException("JSON forbids NaN and infinities: " + dValueOf + "; at path " + jsonReader.getPreviousPath());
                }
                return dValueOf;
            }
        }
    }

    /* INFO: renamed from: com.google.gson.ToNumberPolicy$4, reason: invalid class name */
    final enum AnonymousClass4 extends ToNumberPolicy {
        AnonymousClass4(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.ToNumberStrategy
        public BigDecimal readNumber(JsonReader jsonReader) throws IOException {
            String strNextString = jsonReader.nextString();
            try {
                return new BigDecimal(strNextString);
            } catch (NumberFormatException e) {
                throw new JsonParseException("Cannot parse " + strNextString + "; at path " + jsonReader.getPreviousPath(), e);
            }
        }
    }
}

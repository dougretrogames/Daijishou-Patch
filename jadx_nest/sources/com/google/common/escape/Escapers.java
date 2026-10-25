package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Escapers {
    private static final Escaper NULL_ESCAPER = new AnonymousClass1();

    private Escapers() {
    }

    public static Escaper nullEscaper() {
        return NULL_ESCAPER;
    }

    /* JADX INFO: renamed from: com.google.common.escape.Escapers$1, reason: invalid class name */
    class AnonymousClass1 extends CharEscaper {
        @Override // com.google.common.escape.CharEscaper
        @CheckForNull
        protected char[] escape(char c) {
            return null;
        }

        AnonymousClass1() {
        }

        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String escape(String string) {
            return (String) Preconditions.checkNotNull(string);
        }
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static final class Builder {
        private final Map<Character, String> replacementMap;
        private char safeMax;
        private char safeMin;

        @CheckForNull
        private String unsafeReplacement;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            this.replacementMap = new HashMap();
            this.safeMin = (char) 0;
            this.safeMax = CharCompanionObject.MAX_VALUE;
            this.unsafeReplacement = null;
        }

        public Builder setSafeRange(char safeMin, char safeMax) {
            this.safeMin = safeMin;
            this.safeMax = safeMax;
            return this;
        }

        public Builder setUnsafeReplacement(String unsafeReplacement) {
            this.unsafeReplacement = unsafeReplacement;
            return this;
        }

        public Builder addEscape(char c, String replacement) {
            Preconditions.checkNotNull(replacement);
            this.replacementMap.put(Character.valueOf(c), replacement);
            return this;
        }

        /* JADX INFO: renamed from: com.google.common.escape.Escapers$Builder$1, reason: invalid class name */
        class AnonymousClass1 extends ArrayBasedCharEscaper {

            @CheckForNull
            private final char[] replacementChars;

            AnonymousClass1(Map replacementMap, char safeMin, char safeMax) {
                super((Map<Character, String>) replacementMap, safeMin, safeMax);
                this.replacementChars = Builder.this.unsafeReplacement != null ? Builder.this.unsafeReplacement.toCharArray() : null;
            }

            @Override // com.google.common.escape.ArrayBasedCharEscaper
            @CheckForNull
            protected char[] escapeUnsafe(char c) {
                return this.replacementChars;
            }
        }

        public Escaper build() {
            return new AnonymousClass1(this.replacementMap, this.safeMin, this.safeMax);
        }
    }

    static UnicodeEscaper asUnicodeEscaper(Escaper escaper) {
        Preconditions.checkNotNull(escaper);
        if (escaper instanceof UnicodeEscaper) {
            return (UnicodeEscaper) escaper;
        }
        if (escaper instanceof CharEscaper) {
            return wrap((CharEscaper) escaper);
        }
        throw new IllegalArgumentException("Cannot create a UnicodeEscaper from: " + escaper.getClass().getName());
    }

    @CheckForNull
    public static String computeReplacement(CharEscaper escaper, char c) {
        return stringOrNull(escaper.escape(c));
    }

    @CheckForNull
    public static String computeReplacement(UnicodeEscaper escaper, int cp) {
        return stringOrNull(escaper.escape(cp));
    }

    @CheckForNull
    private static String stringOrNull(@CheckForNull char[] in) {
        if (in == null) {
            return null;
        }
        return new String(in);
    }

    /* JADX INFO: renamed from: com.google.common.escape.Escapers$2, reason: invalid class name */
    class AnonymousClass2 extends UnicodeEscaper {
        final /* synthetic */ CharEscaper val$escaper;

        AnonymousClass2(final CharEscaper val$escaper) {
            this.val$escaper = val$escaper;
        }

        @Override // com.google.common.escape.UnicodeEscaper
        @CheckForNull
        protected char[] escape(int cp) {
            if (cp < 65536) {
                return this.val$escaper.escape((char) cp);
            }
            char[] cArr = new char[2];
            Character.toChars(cp, cArr, 0);
            char[] cArrEscape = this.val$escaper.escape(cArr[0]);
            char[] cArrEscape2 = this.val$escaper.escape(cArr[1]);
            if (cArrEscape == null && cArrEscape2 == null) {
                return null;
            }
            int length = cArrEscape != null ? cArrEscape.length : 1;
            char[] cArr2 = new char[(cArrEscape2 != null ? cArrEscape2.length : 1) + length];
            if (cArrEscape != null) {
                for (int i = 0; i < cArrEscape.length; i++) {
                    cArr2[i] = cArrEscape[i];
                }
            } else {
                cArr2[0] = cArr[0];
            }
            if (cArrEscape2 != null) {
                for (int i2 = 0; i2 < cArrEscape2.length; i2++) {
                    cArr2[length + i2] = cArrEscape2[i2];
                }
                return cArr2;
            }
            cArr2[length] = cArr[1];
            return cArr2;
        }
    }

    private static UnicodeEscaper wrap(CharEscaper escaper) {
        return new AnonymousClass2(escaper);
    }
}

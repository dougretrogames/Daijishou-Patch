package org.jsoup.internal;

import java.io.IOException;
import org.jsoup.SerializationException;

/* INFO: loaded from: classes5.dex */
public abstract class QuietAppendable {
    public abstract QuietAppendable append(char c);

    public abstract QuietAppendable append(CharSequence charSequence);

    public abstract QuietAppendable append(char[] cArr, int i, int i2);

    static final class BaseAppendable extends QuietAppendable {
        private final Appendable a;

        /* INFO: Access modifiers changed from: private */
        @FunctionalInterface
        interface Action {
            void append() throws IOException;
        }

        /* synthetic */ BaseAppendable(Appendable appendable, AnonymousClass1 anonymousClass1) {
            this(appendable);
        }

        private BaseAppendable(Appendable appendable) {
            this.a = appendable;
        }

        private BaseAppendable quiet(Action action) {
            try {
                action.append();
                return this;
            } catch (IOException e) {
                throw new SerializationException(e);
            }
        }

        @Override // org.jsoup.internal.QuietAppendable
        public BaseAppendable append(CharSequence charSequence) {
            return quiet(new QuietAppendable$BaseAppendable$$ExternalSyntheticLambda2(this, charSequence));
        }

        /* INFO: renamed from: lambda$append$0$org-jsoup-internal-QuietAppendable$BaseAppendable, reason: not valid java name */
        /* synthetic */ void m5867x7279193b(CharSequence charSequence) throws IOException {
            this.a.append(charSequence);
        }

        @Override // org.jsoup.internal.QuietAppendable
        public BaseAppendable append(char c) {
            return quiet(new QuietAppendable$BaseAppendable$$ExternalSyntheticLambda0(this, c));
        }

        /* INFO: renamed from: lambda$append$1$org-jsoup-internal-QuietAppendable$BaseAppendable, reason: not valid java name */
        /* synthetic */ void m5868xb60436fc(char c) throws IOException {
            this.a.append(c);
        }

        @Override // org.jsoup.internal.QuietAppendable
        public QuietAppendable append(char[] cArr, int i, int i2) {
            return quiet(new QuietAppendable$BaseAppendable$$ExternalSyntheticLambda1(this, cArr, i, i2));
        }

        /* INFO: renamed from: lambda$append$2$org-jsoup-internal-QuietAppendable$BaseAppendable, reason: not valid java name */
        /* synthetic */ void m5869xf98f54bd(char[] cArr, int i, int i2) throws IOException {
            this.a.append(new String(cArr, i, i2));
        }
    }

    static final class StringBuilderAppendable extends QuietAppendable {
        private final StringBuilder sb;

        /* synthetic */ StringBuilderAppendable(StringBuilder sb, AnonymousClass1 anonymousClass1) {
            this(sb);
        }

        private StringBuilderAppendable(StringBuilder sb) {
            this.sb = sb;
        }

        @Override // org.jsoup.internal.QuietAppendable
        public StringBuilderAppendable append(CharSequence charSequence) {
            this.sb.append(charSequence);
            return this;
        }

        @Override // org.jsoup.internal.QuietAppendable
        public StringBuilderAppendable append(char c) {
            this.sb.append(c);
            return this;
        }

        @Override // org.jsoup.internal.QuietAppendable
        public QuietAppendable append(char[] cArr, int i, int i2) {
            this.sb.append(cArr, i, i2);
            return this;
        }

        public String toString() {
            return this.sb.toString();
        }
    }

    public static QuietAppendable wrap(Appendable appendable) {
        return appendable instanceof StringBuilder ? new StringBuilderAppendable((StringBuilder) appendable, null) : new BaseAppendable(appendable, null);
    }
}

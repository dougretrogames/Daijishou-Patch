package org.apache.commons.io.output;

import java.util.Objects;
import org.apache.commons.io.function.Uncheck;

/* INFO: loaded from: classes5.dex */
final class UncheckedAppendableImpl implements UncheckedAppendable {
    private final Appendable appendable;

    UncheckedAppendableImpl(Appendable appendable) {
        this.appendable = (Appendable) Objects.requireNonNull(appendable, "appendable");
    }

    @Override // org.apache.commons.io.output.UncheckedAppendable, java.lang.Appendable
    public UncheckedAppendable append(char c) {
        Appendable appendable = this.appendable;
        Objects.requireNonNull(appendable);
        Uncheck.apply(new UncheckedAppendableImpl$$ExternalSyntheticLambda0(appendable), Character.valueOf(c));
        return this;
    }

    @Override // org.apache.commons.io.output.UncheckedAppendable, java.lang.Appendable
    public UncheckedAppendable append(CharSequence charSequence) {
        Appendable appendable = this.appendable;
        Objects.requireNonNull(appendable);
        Uncheck.apply(new UncheckedAppendableImpl$$ExternalSyntheticLambda2(appendable), charSequence);
        return this;
    }

    @Override // org.apache.commons.io.output.UncheckedAppendable, java.lang.Appendable
    public UncheckedAppendable append(CharSequence charSequence, int i, int i2) {
        Appendable appendable = this.appendable;
        Objects.requireNonNull(appendable);
        Uncheck.apply(new UncheckedAppendableImpl$$ExternalSyntheticLambda1(appendable), charSequence, Integer.valueOf(i), Integer.valueOf(i2));
        return this;
    }

    public String toString() {
        return this.appendable.toString();
    }
}

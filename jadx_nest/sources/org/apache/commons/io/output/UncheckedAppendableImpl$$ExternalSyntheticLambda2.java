package org.apache.commons.io.output;

import org.apache.commons.io.function.IOFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class UncheckedAppendableImpl$$ExternalSyntheticLambda2 implements IOFunction {
    public final /* synthetic */ Appendable f$0;

    public /* synthetic */ UncheckedAppendableImpl$$ExternalSyntheticLambda2(Appendable appendable) {
        this.f$0 = appendable;
    }

    @Override // org.apache.commons.io.function.IOFunction
    public final Object apply(Object obj) {
        return this.f$0.append((CharSequence) obj);
    }
}

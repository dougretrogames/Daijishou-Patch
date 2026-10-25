package org.apache.commons.io.output;

import org.apache.commons.io.function.IOTriFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class UncheckedAppendableImpl$$ExternalSyntheticLambda1 implements IOTriFunction {
    public final /* synthetic */ Appendable f$0;

    public /* synthetic */ UncheckedAppendableImpl$$ExternalSyntheticLambda1(Appendable appendable) {
        this.f$0 = appendable;
    }

    @Override // org.apache.commons.io.function.IOTriFunction
    public final Object apply(Object obj, Object obj2, Object obj3) {
        return this.f$0.append((CharSequence) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
    }
}

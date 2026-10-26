package org.apache.commons.io.input;

import org.apache.commons.io.function.IOTriFunction;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class UncheckedFilterReader$$ExternalSyntheticLambda1 implements IOTriFunction {
    public final /* synthetic */ UncheckedFilterReader f$0;

    public /* synthetic */ UncheckedFilterReader$$ExternalSyntheticLambda1(UncheckedFilterReader uncheckedFilterReader) {
        this.f$0 = uncheckedFilterReader;
    }

    @Override // org.apache.commons.io.function.IOTriFunction
    public final Object apply(Object obj, Object obj2, Object obj3) {
        return this.f$0.m5612lambda$read$4$orgapachecommonsioinputUncheckedFilterReader((char[]) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
    }
}

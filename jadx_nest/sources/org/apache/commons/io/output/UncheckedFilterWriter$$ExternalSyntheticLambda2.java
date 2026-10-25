package org.apache.commons.io.output;

import java.io.IOException;
import org.apache.commons.io.function.IOTriConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class UncheckedFilterWriter$$ExternalSyntheticLambda2 implements IOTriConsumer {
    public final /* synthetic */ UncheckedFilterWriter f$0;

    public /* synthetic */ UncheckedFilterWriter$$ExternalSyntheticLambda2(UncheckedFilterWriter uncheckedFilterWriter) {
        this.f$0 = uncheckedFilterWriter;
    }

    @Override // org.apache.commons.io.function.IOTriConsumer
    public final void accept(Object obj, Object obj2, Object obj3) throws IOException {
        this.f$0.m5637x30dbef06((String) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
    }
}

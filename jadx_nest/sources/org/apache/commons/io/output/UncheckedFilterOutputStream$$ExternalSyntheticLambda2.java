package org.apache.commons.io.output;

import java.io.IOException;
import org.apache.commons.io.function.IOTriConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class UncheckedFilterOutputStream$$ExternalSyntheticLambda2 implements IOTriConsumer {
    public final /* synthetic */ UncheckedFilterOutputStream f$0;

    public /* synthetic */ UncheckedFilterOutputStream$$ExternalSyntheticLambda2(UncheckedFilterOutputStream uncheckedFilterOutputStream) {
        this.f$0 = uncheckedFilterOutputStream;
    }

    @Override // org.apache.commons.io.function.IOTriConsumer
    public final void accept(Object obj, Object obj2, Object obj3) throws IOException {
        this.f$0.m5626xed14157a((byte[]) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
    }
}

package org.apache.commons.io.output;

import java.io.IOException;
import org.apache.commons.io.function.IOConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class UncheckedFilterOutputStream$$ExternalSyntheticLambda1 implements IOConsumer {
    public final /* synthetic */ UncheckedFilterOutputStream f$0;

    public /* synthetic */ UncheckedFilterOutputStream$$ExternalSyntheticLambda1(UncheckedFilterOutputStream uncheckedFilterOutputStream) {
        this.f$0 = uncheckedFilterOutputStream;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        this.f$0.m5625x6026fe5b((byte[]) obj);
    }
}

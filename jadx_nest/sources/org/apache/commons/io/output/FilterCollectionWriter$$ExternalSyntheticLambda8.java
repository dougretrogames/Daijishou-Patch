package org.apache.commons.io.output;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.io.function.IOConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilterCollectionWriter$$ExternalSyntheticLambda8 implements IOConsumer {
    public final /* synthetic */ int f$0;

    public /* synthetic */ FilterCollectionWriter$$ExternalSyntheticLambda8(int i) {
        this.f$0 = i;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        ((Writer) obj).write(this.f$0);
    }
}

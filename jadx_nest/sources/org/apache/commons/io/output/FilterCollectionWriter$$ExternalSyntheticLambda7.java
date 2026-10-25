package org.apache.commons.io.output;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.io.function.IOConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilterCollectionWriter$$ExternalSyntheticLambda7 implements IOConsumer {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ FilterCollectionWriter$$ExternalSyntheticLambda7(String str, int i, int i2) {
        this.f$0 = str;
        this.f$1 = i;
        this.f$2 = i2;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        ((Writer) obj).write(this.f$0, this.f$1, this.f$2);
    }
}

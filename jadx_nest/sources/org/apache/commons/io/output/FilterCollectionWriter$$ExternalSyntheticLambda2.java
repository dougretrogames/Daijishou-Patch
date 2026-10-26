package org.apache.commons.io.output;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.io.function.IOConsumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilterCollectionWriter$$ExternalSyntheticLambda2 implements IOConsumer {
    public final /* synthetic */ String f$0;

    public /* synthetic */ FilterCollectionWriter$$ExternalSyntheticLambda2(String str) {
        this.f$0 = str;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        ((Writer) obj).write(this.f$0);
    }
}

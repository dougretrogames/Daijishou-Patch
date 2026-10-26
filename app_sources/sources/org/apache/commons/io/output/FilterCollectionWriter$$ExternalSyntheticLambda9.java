package org.apache.commons.io.output;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.io.function.IOConsumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilterCollectionWriter$$ExternalSyntheticLambda9 implements IOConsumer {
    public final /* synthetic */ char f$0;

    public /* synthetic */ FilterCollectionWriter$$ExternalSyntheticLambda9(char c) {
        this.f$0 = c;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        ((Writer) obj).append(this.f$0);
    }
}

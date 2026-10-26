package org.apache.commons.io.output;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.io.function.IOConsumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilterCollectionWriter$$ExternalSyntheticLambda3 implements IOConsumer {
    public final /* synthetic */ CharSequence f$0;

    public /* synthetic */ FilterCollectionWriter$$ExternalSyntheticLambda3(CharSequence charSequence) {
        this.f$0 = charSequence;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        ((Writer) obj).append(this.f$0);
    }
}

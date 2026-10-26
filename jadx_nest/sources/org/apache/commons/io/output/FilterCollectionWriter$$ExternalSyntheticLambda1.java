package org.apache.commons.io.output;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.io.function.IOConsumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilterCollectionWriter$$ExternalSyntheticLambda1 implements IOConsumer {
    public final /* synthetic */ CharSequence f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ FilterCollectionWriter$$ExternalSyntheticLambda1(CharSequence charSequence, int i, int i2) {
        this.f$0 = charSequence;
        this.f$1 = i;
        this.f$2 = i2;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        ((Writer) obj).append(this.f$0, this.f$1, this.f$2);
    }
}

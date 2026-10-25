package org.apache.commons.io.input;

import java.io.IOException;
import org.apache.commons.io.function.IOConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ObservableInputStream$$ExternalSyntheticLambda0 implements IOConsumer {
    public final /* synthetic */ int f$0;

    public /* synthetic */ ObservableInputStream$$ExternalSyntheticLambda0(int i) {
        this.f$0 = i;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        ((ObservableInputStream.Observer) obj).data(this.f$0);
    }
}

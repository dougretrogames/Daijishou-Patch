package org.apache.commons.io.input;

import java.io.IOException;
import org.apache.commons.io.function.IOConsumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class ObservableInputStream$$ExternalSyntheticLambda3 implements IOConsumer {
    public final /* synthetic */ byte[] f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ ObservableInputStream$$ExternalSyntheticLambda3(byte[] bArr, int i, int i2) {
        this.f$0 = bArr;
        this.f$1 = i;
        this.f$2 = i2;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        ((ObservableInputStream.Observer) obj).data(this.f$0, this.f$1, this.f$2);
    }
}

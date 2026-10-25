package org.apache.commons.io.input;

import java.io.IOException;
import org.apache.commons.io.function.IOConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ProxyInputStream$$ExternalSyntheticLambda1 implements IOConsumer {
    public final /* synthetic */ ProxyInputStream f$0;

    public /* synthetic */ ProxyInputStream$$ExternalSyntheticLambda1(ProxyInputStream proxyInputStream) {
        this.f$0 = proxyInputStream;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        this.f$0.handleIOException((IOException) obj);
    }
}

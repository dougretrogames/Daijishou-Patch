package org.apache.commons.io.output;

import java.io.IOException;
import org.apache.commons.io.function.IOConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ProxyOutputStream$$ExternalSyntheticLambda0 implements IOConsumer {
    public final /* synthetic */ ProxyOutputStream f$0;

    public /* synthetic */ ProxyOutputStream$$ExternalSyntheticLambda0(ProxyOutputStream proxyOutputStream) {
        this.f$0 = proxyOutputStream;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        this.f$0.handleIOException((IOException) obj);
    }
}

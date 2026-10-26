package org.apache.commons.io.output;

import java.io.IOException;
import org.apache.commons.io.function.IOConsumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class ProxyWriter$$ExternalSyntheticLambda0 implements IOConsumer {
    public final /* synthetic */ ProxyWriter f$0;

    public /* synthetic */ ProxyWriter$$ExternalSyntheticLambda0(ProxyWriter proxyWriter) {
        this.f$0 = proxyWriter;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        this.f$0.handleIOException((IOException) obj);
    }
}

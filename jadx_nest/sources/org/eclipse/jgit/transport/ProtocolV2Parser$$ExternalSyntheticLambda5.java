package org.eclipse.jgit.transport;

import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class ProtocolV2Parser$$ExternalSyntheticLambda5 implements Consumer {
    public final /* synthetic */ FetchV2Request.Builder f$0;

    public /* synthetic */ ProtocolV2Parser$$ExternalSyntheticLambda5(FetchV2Request.Builder builder) {
        this.f$0 = builder;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.setClientSID((String) obj);
    }
}

package org.apache.commons.io.input;

import java.io.IOException;
import org.apache.commons.io.function.Erase;
import org.apache.commons.io.function.IOConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ProxyInputStream$$ExternalSyntheticLambda0 implements IOConsumer {
    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws Throwable {
        Erase.rethrow((IOException) obj);
    }
}

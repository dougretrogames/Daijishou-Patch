package org.apache.commons.io.function;

import java.io.IOException;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class UncheckedIOIterator$$ExternalSyntheticLambda1 implements IORunnable {
    public final /* synthetic */ IOIterator f$0;

    public /* synthetic */ UncheckedIOIterator$$ExternalSyntheticLambda1(IOIterator iOIterator) {
        this.f$0 = iOIterator;
    }

    @Override // org.apache.commons.io.function.IORunnable
    public final void run() throws IOException {
        this.f$0.remove();
    }
}

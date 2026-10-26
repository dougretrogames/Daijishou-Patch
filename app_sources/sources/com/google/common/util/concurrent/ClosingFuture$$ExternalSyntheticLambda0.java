package com.google.common.util.concurrent;

import java.io.Closeable;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class ClosingFuture$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Closeable f$0;

    public /* synthetic */ ClosingFuture$$ExternalSyntheticLambda0(Closeable closeable) {
        this.f$0 = closeable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ClosingFuture.lambda$closeQuietly$0(this.f$0);
    }
}

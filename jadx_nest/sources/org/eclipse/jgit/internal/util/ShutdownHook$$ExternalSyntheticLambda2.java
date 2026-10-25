package org.eclipse.jgit.internal.util;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ShutdownHook$$ExternalSyntheticLambda2 implements Callable {
    public final /* synthetic */ ShutdownHook f$0;

    public /* synthetic */ ShutdownHook$$ExternalSyntheticLambda2(ShutdownHook shutdownHook) {
        this.f$0 = shutdownHook;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f$0.m5769lambda$1$orgeclipsejgitinternalutilShutdownHook();
    }
}

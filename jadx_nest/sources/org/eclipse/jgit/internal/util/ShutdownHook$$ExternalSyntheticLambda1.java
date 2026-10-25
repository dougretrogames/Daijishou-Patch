package org.eclipse.jgit.internal.util;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ShutdownHook$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ShutdownHook f$0;

    public /* synthetic */ ShutdownHook$$ExternalSyntheticLambda1(ShutdownHook shutdownHook) {
        this.f$0 = shutdownHook;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.cleanup();
    }
}

package org.eclipse.jgit.internal.util;

import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ShutdownHook$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ ShutdownHook f$0;

    public /* synthetic */ ShutdownHook$$ExternalSyntheticLambda0(ShutdownHook shutdownHook) {
        this.f$0 = shutdownHook;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.notify((ShutdownHook.Listener) obj);
    }
}

package org.eclipse.jgit.internal.storage.file;

import org.eclipse.jgit.internal.util.ShutdownHook;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class GC$PidLock$$ExternalSyntheticLambda0 implements ShutdownHook.Listener {
    public final /* synthetic */ GC.PidLock f$0;

    public /* synthetic */ GC$PidLock$$ExternalSyntheticLambda0(GC.PidLock pidLock) {
        this.f$0 = pidLock;
    }

    @Override // org.eclipse.jgit.internal.util.ShutdownHook.Listener
    public final void onShutdown() {
        this.f$0.close();
    }
}

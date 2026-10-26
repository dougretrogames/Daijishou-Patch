package org.eclipse.jgit.internal.storage.file;

import org.eclipse.jgit.internal.util.ShutdownHook;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class LockFile$$ExternalSyntheticLambda0 implements ShutdownHook.Listener {
    public final /* synthetic */ LockFile f$0;

    public /* synthetic */ LockFile$$ExternalSyntheticLambda0(LockFile lockFile) {
        this.f$0 = lockFile;
    }

    @Override // org.eclipse.jgit.internal.util.ShutdownHook.Listener
    public final void onShutdown() {
        this.f$0.unlock();
    }
}

package org.eclipse.jgit.util;

import org.eclipse.jgit.internal.util.ShutdownHook;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FS$FileStoreAttributes$$ExternalSyntheticLambda5 implements ShutdownHook.Listener {
    @Override // org.eclipse.jgit.internal.util.ShutdownHook.Listener
    public final void onShutdown() {
        FS.FileStoreAttributes.shutdownSafeRunner();
    }
}

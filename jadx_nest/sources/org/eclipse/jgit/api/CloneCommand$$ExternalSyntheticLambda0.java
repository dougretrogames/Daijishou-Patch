package org.eclipse.jgit.api;

import org.eclipse.jgit.internal.util.ShutdownHook;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class CloneCommand$$ExternalSyntheticLambda0 implements ShutdownHook.Listener {
    public final /* synthetic */ CloneCommand f$0;

    public /* synthetic */ CloneCommand$$ExternalSyntheticLambda0(CloneCommand cloneCommand) {
        this.f$0 = cloneCommand;
    }

    @Override // org.eclipse.jgit.internal.util.ShutdownHook.Listener
    public final void onShutdown() {
        this.f$0.cleanup();
    }
}

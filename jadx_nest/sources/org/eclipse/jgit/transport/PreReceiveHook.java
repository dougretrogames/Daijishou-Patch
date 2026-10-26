package org.eclipse.jgit.transport;

import java.util.Collection;

/* INFO: loaded from: classes5.dex */
public interface PreReceiveHook {
    public static final PreReceiveHook NULL = new PreReceiveHook$$ExternalSyntheticLambda0();

    static /* synthetic */ void lambda$0(ReceivePack receivePack, Collection collection) {
    }

    void onPreReceive(ReceivePack receivePack, Collection<ReceiveCommand> collection);
}

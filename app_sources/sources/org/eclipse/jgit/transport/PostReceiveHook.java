package org.eclipse.jgit.transport;

import java.util.Collection;

/* INFO: loaded from: classes5.dex */
public interface PostReceiveHook {
    public static final PostReceiveHook NULL = new PostReceiveHook$$ExternalSyntheticLambda0();

    static /* synthetic */ void lambda$0(ReceivePack receivePack, Collection collection) {
    }

    void onPostReceive(ReceivePack receivePack, Collection<ReceiveCommand> collection);
}

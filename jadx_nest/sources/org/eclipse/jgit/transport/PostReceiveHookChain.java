package org.eclipse.jgit.transport;

import java.util.Collection;
import java.util.List;

/* INFO: loaded from: classes5.dex */
public class PostReceiveHookChain implements PostReceiveHook {
    private final int count;
    private final PostReceiveHook[] hooks;

    public static PostReceiveHook newChain(List<? extends PostReceiveHook> list) {
        PostReceiveHook[] postReceiveHookArr = new PostReceiveHook[list.size()];
        int i = 0;
        for (PostReceiveHook postReceiveHook : list) {
            if (postReceiveHook != PostReceiveHook.NULL) {
                postReceiveHookArr[i] = postReceiveHook;
                i++;
            }
        }
        if (i == 0) {
            return PostReceiveHook.NULL;
        }
        if (i == 1) {
            return postReceiveHookArr[0];
        }
        return new PostReceiveHookChain(postReceiveHookArr, i);
    }

    @Override // org.eclipse.jgit.transport.PostReceiveHook
    public void onPostReceive(ReceivePack receivePack, Collection<ReceiveCommand> collection) {
        for (int i = 0; i < this.count; i++) {
            this.hooks[i].onPostReceive(receivePack, collection);
        }
    }

    private PostReceiveHookChain(PostReceiveHook[] postReceiveHookArr, int i) {
        this.hooks = postReceiveHookArr;
        this.count = i;
    }
}

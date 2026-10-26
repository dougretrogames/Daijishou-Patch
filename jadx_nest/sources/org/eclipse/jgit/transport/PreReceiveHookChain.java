package org.eclipse.jgit.transport;

import java.util.Collection;
import java.util.List;

/* INFO: loaded from: classes5.dex */
public class PreReceiveHookChain implements PreReceiveHook {
    private final int count;
    private final PreReceiveHook[] hooks;

    public static PreReceiveHook newChain(List<? extends PreReceiveHook> list) {
        PreReceiveHook[] preReceiveHookArr = new PreReceiveHook[list.size()];
        int i = 0;
        for (PreReceiveHook preReceiveHook : list) {
            if (preReceiveHook != PreReceiveHook.NULL) {
                preReceiveHookArr[i] = preReceiveHook;
                i++;
            }
        }
        if (i == 0) {
            return PreReceiveHook.NULL;
        }
        if (i == 1) {
            return preReceiveHookArr[0];
        }
        return new PreReceiveHookChain(preReceiveHookArr, i);
    }

    @Override // org.eclipse.jgit.transport.PreReceiveHook
    public void onPreReceive(ReceivePack receivePack, Collection<ReceiveCommand> collection) {
        for (int i = 0; i < this.count; i++) {
            this.hooks[i].onPreReceive(receivePack, collection);
        }
    }

    private PreReceiveHookChain(PreReceiveHook[] preReceiveHookArr, int i) {
        this.hooks = preReceiveHookArr;
        this.count = i;
    }
}

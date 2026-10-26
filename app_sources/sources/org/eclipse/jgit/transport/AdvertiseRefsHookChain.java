package org.eclipse.jgit.transport;

import java.io.IOException;
import java.util.List;

/* INFO: loaded from: classes5.dex */
public class AdvertiseRefsHookChain implements AdvertiseRefsHook {
    private final int count;
    private final AdvertiseRefsHook[] hooks;

    public static AdvertiseRefsHook newChain(List<? extends AdvertiseRefsHook> list) {
        AdvertiseRefsHook[] advertiseRefsHookArr = new AdvertiseRefsHook[list.size()];
        int i = 0;
        for (AdvertiseRefsHook advertiseRefsHook : list) {
            if (advertiseRefsHook != AdvertiseRefsHook.DEFAULT) {
                advertiseRefsHookArr[i] = advertiseRefsHook;
                i++;
            }
        }
        if (i == 0) {
            return AdvertiseRefsHook.DEFAULT;
        }
        if (i == 1) {
            return advertiseRefsHookArr[0];
        }
        return new AdvertiseRefsHookChain(advertiseRefsHookArr, i);
    }

    @Override // org.eclipse.jgit.transport.AdvertiseRefsHook
    public void advertiseRefs(ReceivePack receivePack) throws IOException {
        for (int i = 0; i < this.count; i++) {
            this.hooks[i].advertiseRefs(receivePack);
        }
    }

    @Override // org.eclipse.jgit.transport.AdvertiseRefsHook
    public void advertiseRefs(UploadPack uploadPack) throws ServiceMayNotContinueException {
        for (int i = 0; i < this.count; i++) {
            this.hooks[i].advertiseRefs(uploadPack);
        }
    }

    private AdvertiseRefsHookChain(AdvertiseRefsHook[] advertiseRefsHookArr, int i) {
        this.hooks = advertiseRefsHookArr;
        this.count = i;
    }
}

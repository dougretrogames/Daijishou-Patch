package org.eclipse.jgit.transport;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
public class PreUploadHookChain implements PreUploadHook {
    private final List<PreUploadHook> hooks;

    public static PreUploadHook newChain(List<PreUploadHook> list) {
        List list2 = (List) list.stream().filter(new PreUploadHookChain$$ExternalSyntheticLambda0()).collect(Collectors.toList());
        if (list2.isEmpty()) {
            return PreUploadHook.NULL;
        }
        if (list2.size() == 1) {
            return (PreUploadHook) list2.get(0);
        }
        return new PreUploadHookChain(list2);
    }

    static /* synthetic */ boolean lambda$0(PreUploadHook preUploadHook) {
        return !preUploadHook.equals(PreUploadHook.NULL);
    }

    @Override // org.eclipse.jgit.transport.PreUploadHook
    public void onBeginNegotiateRound(UploadPack uploadPack, Collection<? extends ObjectId> collection, int i) throws ServiceMayNotContinueException {
        Iterator<PreUploadHook> it = this.hooks.iterator();
        while (it.hasNext()) {
            it.next().onBeginNegotiateRound(uploadPack, collection, i);
        }
    }

    @Override // org.eclipse.jgit.transport.PreUploadHook
    public void onEndNegotiateRound(UploadPack uploadPack, Collection<? extends ObjectId> collection, int i, int i2, boolean z) throws ServiceMayNotContinueException {
        Iterator<PreUploadHook> it = this.hooks.iterator();
        while (it.hasNext()) {
            it.next().onEndNegotiateRound(uploadPack, collection, i, i2, z);
        }
    }

    @Override // org.eclipse.jgit.transport.PreUploadHook
    public void onSendPack(UploadPack uploadPack, Collection<? extends ObjectId> collection, Collection<? extends ObjectId> collection2) throws ServiceMayNotContinueException {
        Iterator<PreUploadHook> it = this.hooks.iterator();
        while (it.hasNext()) {
            it.next().onSendPack(uploadPack, collection, collection2);
        }
    }

    private PreUploadHookChain(List<PreUploadHook> list) {
        this.hooks = Collections.unmodifiableList(list);
    }
}

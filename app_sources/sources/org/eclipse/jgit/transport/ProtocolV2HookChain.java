package org.eclipse.jgit.transport;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/* INFO: loaded from: classes5.dex */
public class ProtocolV2HookChain implements ProtocolV2Hook {
    private final List<? extends ProtocolV2Hook> hooks;

    public static ProtocolV2Hook newChain(List<? extends ProtocolV2Hook> list) {
        List list2 = (List) list.stream().filter(new ProtocolV2HookChain$$ExternalSyntheticLambda0()).collect(Collectors.toList());
        if (list2.isEmpty()) {
            return ProtocolV2Hook.DEFAULT;
        }
        if (list2.size() == 1) {
            return (ProtocolV2Hook) list2.get(0);
        }
        return new ProtocolV2HookChain(list2);
    }

    static /* synthetic */ boolean lambda$0(ProtocolV2Hook protocolV2Hook) {
        return !protocolV2Hook.equals(ProtocolV2Hook.DEFAULT);
    }

    @Override // org.eclipse.jgit.transport.ProtocolV2Hook
    public void onCapabilities(CapabilitiesV2Request capabilitiesV2Request) throws ServiceMayNotContinueException {
        Iterator<? extends ProtocolV2Hook> it = this.hooks.iterator();
        while (it.hasNext()) {
            it.next().onCapabilities(capabilitiesV2Request);
        }
    }

    @Override // org.eclipse.jgit.transport.ProtocolV2Hook
    public void onLsRefs(LsRefsV2Request lsRefsV2Request) throws ServiceMayNotContinueException {
        Iterator<? extends ProtocolV2Hook> it = this.hooks.iterator();
        while (it.hasNext()) {
            it.next().onLsRefs(lsRefsV2Request);
        }
    }

    @Override // org.eclipse.jgit.transport.ProtocolV2Hook
    public void onFetch(FetchV2Request fetchV2Request) throws ServiceMayNotContinueException {
        Iterator<? extends ProtocolV2Hook> it = this.hooks.iterator();
        while (it.hasNext()) {
            it.next().onFetch(fetchV2Request);
        }
    }

    @Override // org.eclipse.jgit.transport.ProtocolV2Hook
    public void onObjectInfo(ObjectInfoRequest objectInfoRequest) throws ServiceMayNotContinueException {
        Iterator<? extends ProtocolV2Hook> it = this.hooks.iterator();
        while (it.hasNext()) {
            it.next().onObjectInfo(objectInfoRequest);
        }
    }

    private ProtocolV2HookChain(List<? extends ProtocolV2Hook> list) {
        this.hooks = Collections.unmodifiableList(list);
    }
}

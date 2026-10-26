package org.eclipse.jgit.transport;

/* INFO: loaded from: classes5.dex */
public interface ProtocolV2Hook {
    public static final ProtocolV2Hook DEFAULT = new AnonymousClass1();

    default void onCapabilities(CapabilitiesV2Request capabilitiesV2Request) throws ServiceMayNotContinueException {
    }

    default void onFetch(FetchV2Request fetchV2Request) throws ServiceMayNotContinueException {
    }

    default void onLsRefs(LsRefsV2Request lsRefsV2Request) throws ServiceMayNotContinueException {
    }

    default void onObjectInfo(ObjectInfoRequest objectInfoRequest) throws ServiceMayNotContinueException {
    }

    /* INFO: renamed from: org.eclipse.jgit.transport.ProtocolV2Hook$1, reason: invalid class name */
    class AnonymousClass1 implements ProtocolV2Hook {
        AnonymousClass1() {
        }
    }
}

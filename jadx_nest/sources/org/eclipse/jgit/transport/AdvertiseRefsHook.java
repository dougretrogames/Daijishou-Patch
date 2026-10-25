package org.eclipse.jgit.transport;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface AdvertiseRefsHook {
    public static final AdvertiseRefsHook DEFAULT = new AnonymousClass1();

    void advertiseRefs(ReceivePack receivePack) throws IOException;

    void advertiseRefs(UploadPack uploadPack) throws ServiceMayNotContinueException;

    /* JADX INFO: renamed from: org.eclipse.jgit.transport.AdvertiseRefsHook$1, reason: invalid class name */
    class AnonymousClass1 implements AdvertiseRefsHook {
        @Override // org.eclipse.jgit.transport.AdvertiseRefsHook
        public void advertiseRefs(ReceivePack receivePack) {
        }

        @Override // org.eclipse.jgit.transport.AdvertiseRefsHook
        public void advertiseRefs(UploadPack uploadPack) {
        }

        AnonymousClass1() {
        }
    }
}

package org.eclipse.jgit.transport;

import java.util.Collection;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
public interface PreUploadHook {
    public static final PreUploadHook NULL = new AnonymousClass1();

    void onBeginNegotiateRound(UploadPack uploadPack, Collection<? extends ObjectId> collection, int i) throws ServiceMayNotContinueException;

    void onEndNegotiateRound(UploadPack uploadPack, Collection<? extends ObjectId> collection, int i, int i2, boolean z) throws ServiceMayNotContinueException;

    void onSendPack(UploadPack uploadPack, Collection<? extends ObjectId> collection, Collection<? extends ObjectId> collection2) throws ServiceMayNotContinueException;

    /* INFO: renamed from: org.eclipse.jgit.transport.PreUploadHook$1, reason: invalid class name */
    class AnonymousClass1 implements PreUploadHook {
        @Override // org.eclipse.jgit.transport.PreUploadHook
        public void onBeginNegotiateRound(UploadPack uploadPack, Collection<? extends ObjectId> collection, int i) throws ServiceMayNotContinueException {
        }

        @Override // org.eclipse.jgit.transport.PreUploadHook
        public void onEndNegotiateRound(UploadPack uploadPack, Collection<? extends ObjectId> collection, int i, int i2, boolean z) throws ServiceMayNotContinueException {
        }

        @Override // org.eclipse.jgit.transport.PreUploadHook
        public void onSendPack(UploadPack uploadPack, Collection<? extends ObjectId> collection, Collection<? extends ObjectId> collection2) throws ServiceMayNotContinueException {
        }

        AnonymousClass1() {
        }
    }
}

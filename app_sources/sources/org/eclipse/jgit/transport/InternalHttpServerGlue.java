package org.eclipse.jgit.transport;

/* INFO: loaded from: classes5.dex */
public class InternalHttpServerGlue {
    public static void setPeerUserAgent(UploadPack uploadPack, String str) {
        uploadPack.userAgent = str;
    }

    public static void setPeerUserAgent(ReceivePack receivePack, String str) {
        receivePack.userAgent = str;
    }

    private InternalHttpServerGlue() {
    }
}

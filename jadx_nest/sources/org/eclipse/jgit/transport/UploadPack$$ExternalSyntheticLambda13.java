package org.eclipse.jgit.transport;

import java.io.IOException;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class UploadPack$$ExternalSyntheticLambda13 implements UploadPack.IOConsumer {
    public final /* synthetic */ PacketLineOut f$0;

    public /* synthetic */ UploadPack$$ExternalSyntheticLambda13(PacketLineOut packetLineOut) {
        this.f$0 = packetLineOut;
    }

    @Override // org.eclipse.jgit.transport.UploadPack.IOConsumer
    public final void accept(Object obj) throws IOException {
        this.f$0.writeString(GitProtocolConstants.PACKET_SHALLOW + ((ObjectId) obj).name() + "\n");
    }
}

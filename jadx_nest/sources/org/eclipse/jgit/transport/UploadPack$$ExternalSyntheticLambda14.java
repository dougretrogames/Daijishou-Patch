package org.eclipse.jgit.transport;

import java.io.IOException;
import java.util.List;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class UploadPack$$ExternalSyntheticLambda14 implements UploadPack.IOConsumer {
    public final /* synthetic */ PacketLineOut f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ UploadPack$$ExternalSyntheticLambda14(PacketLineOut packetLineOut, List list) {
        this.f$0 = packetLineOut;
        this.f$1 = list;
    }

    @Override // org.eclipse.jgit.transport.UploadPack.IOConsumer
    public final void accept(Object obj) throws IOException {
        UploadPack.lambda$10(this.f$0, this.f$1, (ObjectId) obj);
    }
}

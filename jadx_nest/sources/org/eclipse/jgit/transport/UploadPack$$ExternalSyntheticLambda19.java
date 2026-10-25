package org.eclipse.jgit.transport;

import java.util.List;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class UploadPack$$ExternalSyntheticLambda19 implements UploadPack.IOConsumer {
    public final /* synthetic */ List f$0;

    public /* synthetic */ UploadPack$$ExternalSyntheticLambda19(List list) {
        this.f$0 = list;
    }

    @Override // org.eclipse.jgit.transport.UploadPack.IOConsumer
    public final void accept(Object obj) {
        this.f$0.add((ObjectId) obj);
    }
}

package org.eclipse.jgit.transport;

import java.util.function.Function;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.revwalk.RevWalk;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class UploadPack$$ExternalSyntheticLambda7 implements Function {
    public final /* synthetic */ RevWalk f$0;

    public /* synthetic */ UploadPack$$ExternalSyntheticLambda7(RevWalk revWalk) {
        this.f$0 = revWalk;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return UploadPack.objectIdToRevCommit(this.f$0, (ObjectId) obj);
    }
}

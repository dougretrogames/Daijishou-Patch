package org.eclipse.jgit.transport;

import java.util.function.Function;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.revwalk.ObjectWalk;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class UploadPack$$ExternalSyntheticLambda5 implements Function {
    public final /* synthetic */ ObjectWalk f$0;

    public /* synthetic */ UploadPack$$ExternalSyntheticLambda5(ObjectWalk objectWalk) {
        this.f$0 = objectWalk;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return UploadPack.objectIdToRevObject(this.f$0, (ObjectId) obj);
    }
}

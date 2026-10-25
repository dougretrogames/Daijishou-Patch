package org.eclipse.jgit.transport;

import java.util.function.Function;
import org.eclipse.jgit.lib.Ref;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class UploadPack$$ExternalSyntheticLambda4 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return UploadPack.refToObjectId((Ref) obj);
    }
}

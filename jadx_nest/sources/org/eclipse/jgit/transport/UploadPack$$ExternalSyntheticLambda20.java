package org.eclipse.jgit.transport;

import java.util.Map;
import java.util.function.Function;
import org.eclipse.jgit.lib.Ref;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class UploadPack$$ExternalSyntheticLambda20 implements Function {
    public final /* synthetic */ Map f$0;

    public /* synthetic */ UploadPack$$ExternalSyntheticLambda20(Map map) {
        this.f$0 = map;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return (Ref) this.f$0.get((String) obj);
    }
}

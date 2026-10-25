package org.eclipse.jgit.transport;

import java.util.Map;
import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class WalkFetchConnection$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ Map f$0;

    public /* synthetic */ WalkFetchConnection$$ExternalSyntheticLambda0(Map map) {
        this.f$0 = map;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.remove((String) obj);
    }
}

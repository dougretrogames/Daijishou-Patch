package org.eclipse.jgit.internal.transport.connectivity;

import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IterativeConnectivityChecker$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ Set f$0;
    public final /* synthetic */ Set f$1;
    public final /* synthetic */ Set f$2;

    public /* synthetic */ IterativeConnectivityChecker$$ExternalSyntheticLambda0(Set set, Set set2, Set set3) {
        this.f$0 = set;
        this.f$1 = set2;
        this.f$2 = set3;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        IterativeConnectivityChecker.lambda$0(this.f$0, this.f$1, this.f$2, (ObjectId) obj);
    }
}

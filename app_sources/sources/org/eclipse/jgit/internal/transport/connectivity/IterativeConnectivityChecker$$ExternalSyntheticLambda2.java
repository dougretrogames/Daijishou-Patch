package org.eclipse.jgit.internal.transport.connectivity;

import java.util.function.Function;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IterativeConnectivityChecker$$ExternalSyntheticLambda2 implements Function {
    public final /* synthetic */ RevWalk f$0;

    public /* synthetic */ IterativeConnectivityChecker$$ExternalSyntheticLambda2(RevWalk revWalk) {
        this.f$0 = revWalk;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return IterativeConnectivityChecker.lambda$2(this.f$0, (RevCommit) obj);
    }
}

package org.eclipse.jgit.attributes;

import java.util.function.Supplier;
import org.eclipse.jgit.treewalk.TreeWalk;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class AttributesHandler$$ExternalSyntheticLambda0 implements Supplier {
    public final /* synthetic */ TreeWalk f$0;

    public /* synthetic */ AttributesHandler$$ExternalSyntheticLambda0(TreeWalk treeWalk) {
        this.f$0 = treeWalk;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return AttributesHandler.lambda$0(this.f$0);
    }
}

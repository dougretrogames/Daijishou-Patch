package org.eclipse.jgit.internal.storage.dfs;

import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class PackExtBlockCacheTable$$ExternalSyntheticLambda2 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((DfsBlockCacheTable) obj).getBlockCacheStats().stream();
    }
}

package org.eclipse.jgit.internal.storage.dfs;

import java.util.Map;
import java.util.function.Predicate;
import org.eclipse.jgit.internal.storage.pack.PackExt;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class DfsBlockCacheConfig$DfsBlockCachePackExtConfig$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ Map f$0;

    public /* synthetic */ DfsBlockCacheConfig$DfsBlockCachePackExtConfig$$ExternalSyntheticLambda0(Map map) {
        this.f$0 = map;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.containsKey((PackExt) obj);
    }
}

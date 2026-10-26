package org.eclipse.jgit.internal.storage.dfs;

import java.util.Map;
import java.util.function.Function;
import org.eclipse.jgit.internal.storage.pack.PackExt;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class DfsBlockCacheConfig$DfsBlockCachePackExtConfig$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ Map f$0;

    public /* synthetic */ DfsBlockCacheConfig$DfsBlockCachePackExtConfig$$ExternalSyntheticLambda1(Map map) {
        this.f$0 = map;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return (Integer) this.f$0.get((PackExt) obj);
    }
}

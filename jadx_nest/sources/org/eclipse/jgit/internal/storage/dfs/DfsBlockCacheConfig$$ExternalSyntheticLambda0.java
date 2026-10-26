package org.eclipse.jgit.internal.storage.dfs;

import java.util.function.Predicate;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class DfsBlockCacheConfig$$ExternalSyntheticLambda0 implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return ((String) obj).startsWith(ConfigConstants.CONFIG_DFS_CACHE_PREFIX);
    }
}

package org.eclipse.jgit.internal.storage.dfs;

import java.util.concurrent.atomic.AtomicReference;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class DfsPackFile$CachedStreamPackIndexes$$ExternalSyntheticLambda0 implements DfsBlockCache.RefLoader {
    public final /* synthetic */ DfsPackFile.CachedStreamPackIndexes f$0;
    public final /* synthetic */ DfsReader f$1;
    public final /* synthetic */ AtomicReference f$2;
    public final /* synthetic */ DfsStreamKey f$3;

    public /* synthetic */ DfsPackFile$CachedStreamPackIndexes$$ExternalSyntheticLambda0(DfsPackFile.CachedStreamPackIndexes cachedStreamPackIndexes, DfsReader dfsReader, AtomicReference atomicReference, DfsStreamKey dfsStreamKey) {
        this.f$0 = cachedStreamPackIndexes;
        this.f$1 = dfsReader;
        this.f$2 = atomicReference;
        this.f$3 = dfsStreamKey;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCache.RefLoader
    public final DfsBlockCache.Ref load() {
        return this.f$0.m5675x68f10ae(this.f$1, this.f$2, this.f$3);
    }
}

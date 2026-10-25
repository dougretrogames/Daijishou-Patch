package org.eclipse.jgit.internal.storage.dfs;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class DfsReftable$CacheSource$$ExternalSyntheticLambda0 implements DfsBlockCache.ReadableChannelSupplier {
    public final /* synthetic */ DfsReftable.CacheSource f$0;

    public /* synthetic */ DfsReftable$CacheSource$$ExternalSyntheticLambda0(DfsReftable.CacheSource cacheSource) {
        this.f$0 = cacheSource;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCache.ReadableChannelSupplier
    public final ReadableChannel get() {
        return this.f$0.m5676xa4b6974c();
    }
}

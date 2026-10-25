package org.eclipse.jgit.internal.storage.dfs;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class DfsPackFile$$ExternalSyntheticLambda3 implements DfsBlockCache.RefLoader {
    public final /* synthetic */ DfsPackFile f$0;
    public final /* synthetic */ AtomicBoolean f$1;
    public final /* synthetic */ DfsReader f$2;
    public final /* synthetic */ DfsStreamKey f$3;

    public /* synthetic */ DfsPackFile$$ExternalSyntheticLambda3(DfsPackFile dfsPackFile, AtomicBoolean atomicBoolean, DfsReader dfsReader, DfsStreamKey dfsStreamKey) {
        this.f$0 = dfsPackFile;
        this.f$1 = atomicBoolean;
        this.f$2 = dfsReader;
        this.f$3 = dfsStreamKey;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCache.RefLoader
    public final DfsBlockCache.Ref load() {
        return this.f$0.m5674lambda$2$orgeclipsejgitinternalstoragedfsDfsPackFile(this.f$1, this.f$2, this.f$3);
    }
}

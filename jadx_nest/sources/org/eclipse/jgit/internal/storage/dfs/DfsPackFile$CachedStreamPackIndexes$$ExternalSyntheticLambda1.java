package org.eclipse.jgit.internal.storage.dfs;

import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jgit.internal.storage.file.PackIndex;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class DfsPackFile$CachedStreamPackIndexes$$ExternalSyntheticLambda1 implements DfsBlockCache.RefLoader {
    public final /* synthetic */ DfsReader f$0;
    public final /* synthetic */ PackIndex f$1;
    public final /* synthetic */ AtomicReference f$2;
    public final /* synthetic */ DfsStreamKey f$3;

    public /* synthetic */ DfsPackFile$CachedStreamPackIndexes$$ExternalSyntheticLambda1(DfsReader dfsReader, PackIndex packIndex, AtomicReference atomicReference, DfsStreamKey dfsStreamKey) {
        this.f$0 = dfsReader;
        this.f$1 = packIndex;
        this.f$2 = atomicReference;
        this.f$3 = dfsStreamKey;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCache.RefLoader
    public final DfsBlockCache.Ref load() {
        return DfsPackFile.CachedStreamPackIndexes.lambda$1(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}

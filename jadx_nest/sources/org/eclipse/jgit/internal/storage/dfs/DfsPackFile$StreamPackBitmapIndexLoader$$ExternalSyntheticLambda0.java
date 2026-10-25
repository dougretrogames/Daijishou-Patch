package org.eclipse.jgit.internal.storage.dfs;

import org.eclipse.jgit.internal.storage.file.PackBitmapIndex;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class DfsPackFile$StreamPackBitmapIndexLoader$$ExternalSyntheticLambda0 implements PackBitmapIndex.SupplierWithIOException {
    public final /* synthetic */ DfsPackFile f$0;
    public final /* synthetic */ DfsReader f$1;

    public /* synthetic */ DfsPackFile$StreamPackBitmapIndexLoader$$ExternalSyntheticLambda0(DfsPackFile dfsPackFile, DfsReader dfsReader) {
        this.f$0 = dfsPackFile;
        this.f$1 = dfsReader;
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex.SupplierWithIOException
    public final Object get() {
        return this.f$0.idx(this.f$1);
    }
}

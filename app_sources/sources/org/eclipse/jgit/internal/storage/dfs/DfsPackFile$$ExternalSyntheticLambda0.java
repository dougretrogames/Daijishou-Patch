package org.eclipse.jgit.internal.storage.dfs;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class DfsPackFile$$ExternalSyntheticLambda0 implements DfsBlockCache.ReadableChannelSupplier {
    public final /* synthetic */ ReadableChannel f$0;

    public /* synthetic */ DfsPackFile$$ExternalSyntheticLambda0(ReadableChannel readableChannel) {
        this.f$0 = readableChannel;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCache.ReadableChannelSupplier
    public final ReadableChannel get() {
        return DfsPackFile.lambda$3(this.f$0);
    }
}

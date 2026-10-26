package org.eclipse.jgit.internal.storage.dfs;

import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class DfsReader$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ BlockBasedFile f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ DfsBlock f$2;

    public /* synthetic */ DfsReader$$ExternalSyntheticLambda0(BlockBasedFile blockBasedFile, long j, DfsBlock dfsBlock) {
        this.f$0 = blockBasedFile;
        this.f$1 = j;
        this.f$2 = dfsBlock;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        BlockBasedFile blockBasedFile = this.f$0;
        ((DfsReader.PackLoadListener) obj).onBlockLoad(blockBasedFile.getFileName(), blockBasedFile.desc.getPackSource(), blockBasedFile.ext, this.f$1, DfsReader.PackLoadListener.DfsBlockData.of(this.f$2));
    }
}

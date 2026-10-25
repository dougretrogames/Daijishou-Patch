package org.eclipse.jgit.internal.storage.dfs;

import java.util.function.Consumer;
import org.eclipse.jgit.internal.storage.pack.PackExt;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class DfsReader$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ DfsPackDescription f$0;
    public final /* synthetic */ PackExt f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ DfsReader$$ExternalSyntheticLambda1(DfsPackDescription dfsPackDescription, PackExt packExt, Object obj) {
        this.f$0 = dfsPackDescription;
        this.f$1 = packExt;
        this.f$2 = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        DfsPackDescription dfsPackDescription = this.f$0;
        PackExt packExt = this.f$1;
        ((DfsReader.PackLoadListener) obj).onIndexLoad(dfsPackDescription.getFileName(packExt), dfsPackDescription.getPackSource(), packExt, dfsPackDescription.getFileSize(packExt), this.f$2);
    }
}

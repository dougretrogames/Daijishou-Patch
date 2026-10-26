package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import java.util.List;
import org.eclipse.jgit.internal.storage.pack.PackIndexWriter;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class DfsObjDatabase$$ExternalSyntheticLambda2 implements PackIndexWriter {
    public final /* synthetic */ DfsObjDatabase f$0;
    public final /* synthetic */ DfsPackDescription f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ DfsObjDatabase$$ExternalSyntheticLambda2(DfsObjDatabase dfsObjDatabase, DfsPackDescription dfsPackDescription, int i) {
        this.f$0 = dfsObjDatabase;
        this.f$1 = dfsPackDescription;
        this.f$2 = i;
    }

    @Override // org.eclipse.jgit.internal.storage.pack.PackIndexWriter
    public final void write(List list, byte[] bArr) throws IOException {
        this.f$0.m5668lambda$2$orgeclipsejgitinternalstoragedfsDfsObjDatabase(this.f$1, this.f$2, list, bArr);
    }
}

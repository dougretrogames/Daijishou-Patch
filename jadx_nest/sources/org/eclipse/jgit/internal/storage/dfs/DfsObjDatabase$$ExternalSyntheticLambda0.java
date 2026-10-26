package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import org.eclipse.jgit.internal.storage.file.PackBitmapIndexBuilder;
import org.eclipse.jgit.internal.storage.pack.PackBitmapIndexWriter;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class DfsObjDatabase$$ExternalSyntheticLambda0 implements PackBitmapIndexWriter {
    public final /* synthetic */ DfsObjDatabase f$0;
    public final /* synthetic */ DfsPackDescription f$1;

    public /* synthetic */ DfsObjDatabase$$ExternalSyntheticLambda0(DfsObjDatabase dfsObjDatabase, DfsPackDescription dfsPackDescription) {
        this.f$0 = dfsObjDatabase;
        this.f$1 = dfsPackDescription;
    }

    @Override // org.eclipse.jgit.internal.storage.pack.PackBitmapIndexWriter
    public final void write(PackBitmapIndexBuilder packBitmapIndexBuilder, byte[] bArr) throws IOException {
        this.f$0.m5667lambda$1$orgeclipsejgitinternalstoragedfsDfsObjDatabase(this.f$1, packBitmapIndexBuilder, bArr);
    }
}

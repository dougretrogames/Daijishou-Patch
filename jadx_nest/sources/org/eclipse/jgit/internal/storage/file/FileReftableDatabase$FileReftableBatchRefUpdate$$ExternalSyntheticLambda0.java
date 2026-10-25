package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import java.util.List;
import org.eclipse.jgit.internal.storage.reftable.ReftableWriter;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileReftableDatabase$FileReftableBatchRefUpdate$$ExternalSyntheticLambda0 implements FileReftableStack.Writer {
    public final /* synthetic */ FileReftableDatabase.FileReftableBatchRefUpdate f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ List f$2;

    public /* synthetic */ FileReftableDatabase$FileReftableBatchRefUpdate$$ExternalSyntheticLambda0(FileReftableDatabase.FileReftableBatchRefUpdate fileReftableBatchRefUpdate, List list, List list2) {
        this.f$0 = fileReftableBatchRefUpdate;
        this.f$1 = list;
        this.f$2 = list2;
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileReftableStack.Writer
    public final void call(ReftableWriter reftableWriter) throws IOException {
        this.f$0.m5689xc260f837(this.f$1, this.f$2, reftableWriter);
    }
}

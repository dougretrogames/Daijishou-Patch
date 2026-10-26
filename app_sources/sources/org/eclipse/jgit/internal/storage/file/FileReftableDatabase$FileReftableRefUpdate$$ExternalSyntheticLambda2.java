package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import org.eclipse.jgit.internal.storage.reftable.ReftableWriter;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileReftableDatabase$FileReftableRefUpdate$$ExternalSyntheticLambda2 implements FileReftableStack.Writer {
    public final /* synthetic */ FileReftableDatabase.FileReftableRefUpdate f$0;

    public /* synthetic */ FileReftableDatabase$FileReftableRefUpdate$$ExternalSyntheticLambda2(FileReftableDatabase.FileReftableRefUpdate fileReftableRefUpdate) {
        this.f$0 = fileReftableRefUpdate;
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileReftableStack.Writer
    public final void call(ReftableWriter reftableWriter) throws IOException {
        this.f$0.writeLink(reftableWriter);
    }
}

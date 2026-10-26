package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import org.eclipse.jgit.internal.storage.reftable.ReftableWriter;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileReftableDatabase$FileRefRename$$ExternalSyntheticLambda0 implements FileReftableStack.Writer {
    public final /* synthetic */ FileReftableDatabase.FileRefRename f$0;

    public /* synthetic */ FileReftableDatabase$FileRefRename$$ExternalSyntheticLambda0(FileReftableDatabase.FileRefRename fileRefRename) {
        this.f$0 = fileRefRename;
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileReftableStack.Writer
    public final void call(ReftableWriter reftableWriter) throws IOException {
        this.f$0.writeRename(reftableWriter);
    }
}

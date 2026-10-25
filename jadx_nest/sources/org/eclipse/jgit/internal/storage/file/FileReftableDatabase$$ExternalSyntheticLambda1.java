package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import org.eclipse.jgit.internal.storage.reftable.ReftableWriter;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileReftableDatabase$$ExternalSyntheticLambda1 implements FileReftableStack.Writer {
    public final /* synthetic */ FileRepository f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ FileReftableDatabase$$ExternalSyntheticLambda1(FileRepository fileRepository, boolean z) {
        this.f$0 = fileRepository;
        this.f$1 = z;
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileReftableStack.Writer
    public final void call(ReftableWriter reftableWriter) throws IOException {
        FileReftableDatabase.writeConvertTable(this.f$0, reftableWriter, this.f$1);
    }
}

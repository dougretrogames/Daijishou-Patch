package org.eclipse.jgit.internal.storage.file;

import java.util.function.Supplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileReftableDatabase$$ExternalSyntheticLambda0 implements Supplier {
    public final /* synthetic */ FileRepository f$0;

    public /* synthetic */ FileReftableDatabase$$ExternalSyntheticLambda0(FileRepository fileRepository) {
        this.f$0 = fileRepository;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f$0.getConfig();
    }
}

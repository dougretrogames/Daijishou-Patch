package org.apache.commons.io.monitor;

import java.io.File;
import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileAlterationObserver$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ FileEntry f$0;
    public final /* synthetic */ File f$1;

    public /* synthetic */ FileAlterationObserver$$ExternalSyntheticLambda1(FileEntry fileEntry, File file) {
        this.f$0 = fileEntry;
        this.f$1 = file;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        FileAlterationObserver.lambda$fireOnChange$2(this.f$0, this.f$1, (FileAlterationListener) obj);
    }
}

package org.apache.commons.io.monitor;

import java.io.File;
import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileAlterationObserver$$ExternalSyntheticLambda2 implements Function {
    public final /* synthetic */ FileAlterationObserver f$0;
    public final /* synthetic */ FileEntry f$1;

    public /* synthetic */ FileAlterationObserver$$ExternalSyntheticLambda2(FileAlterationObserver fileAlterationObserver, FileEntry fileEntry) {
        this.f$0 = fileAlterationObserver;
        this.f$1 = fileEntry;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return this.f$0.m5621xd1c1b90a(this.f$1, (File) obj);
    }
}

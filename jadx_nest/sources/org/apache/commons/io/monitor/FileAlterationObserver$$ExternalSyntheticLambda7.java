package org.apache.commons.io.monitor;

import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileAlterationObserver$$ExternalSyntheticLambda7 implements Consumer {
    public final /* synthetic */ FileAlterationObserver f$0;

    public /* synthetic */ FileAlterationObserver$$ExternalSyntheticLambda7(FileAlterationObserver fileAlterationObserver) {
        this.f$0 = fileAlterationObserver;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.m5620x47b2d5d2((FileAlterationListener) obj);
    }
}

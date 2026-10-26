package org.apache.commons.io.monitor;

import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileAlterationMonitor$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ FileAlterationMonitor f$0;

    public /* synthetic */ FileAlterationMonitor$$ExternalSyntheticLambda1(FileAlterationMonitor fileAlterationMonitor) {
        this.f$0 = fileAlterationMonitor;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.addObserver((FileAlterationObserver) obj);
    }
}

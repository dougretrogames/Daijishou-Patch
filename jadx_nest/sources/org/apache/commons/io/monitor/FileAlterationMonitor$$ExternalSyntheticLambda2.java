package org.apache.commons.io.monitor;

import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileAlterationMonitor$$ExternalSyntheticLambda2 implements Consumer {
    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        ((FileAlterationObserver) obj).checkAndNotify();
    }
}

package org.apache.commons.io;

import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda17 implements Consumer {
    public final /* synthetic */ Exception f$0;

    public /* synthetic */ FileUtils$$ExternalSyntheticLambda17(Exception exc) {
        this.f$0 = exc;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.addSuppressed((Exception) obj);
    }
}

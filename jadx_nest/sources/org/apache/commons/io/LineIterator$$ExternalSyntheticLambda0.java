package org.apache.commons.io;

import java.io.IOException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class LineIterator$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ IOException f$0;

    public /* synthetic */ LineIterator$$ExternalSyntheticLambda0(IOException iOException) {
        this.f$0 = iOException;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.addSuppressed((Exception) obj);
    }
}

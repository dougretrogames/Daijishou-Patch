package org.apache.commons.io;

import java.io.Closeable;
import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOUtils$$ExternalSyntheticLambda0 implements Consumer {
    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        IOUtils.closeQuietly((Closeable) obj);
    }
}

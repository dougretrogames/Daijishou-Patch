package org.apache.commons.io;

import java.net.URL;
import org.apache.commons.io.function.IOSupplier;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda8 implements IOSupplier {
    public final /* synthetic */ URL f$0;

    public /* synthetic */ FileUtils$$ExternalSyntheticLambda8(URL url) {
        this.f$0 = url;
    }

    @Override // org.apache.commons.io.function.IOSupplier
    public final Object get() {
        return this.f$0.openStream();
    }
}

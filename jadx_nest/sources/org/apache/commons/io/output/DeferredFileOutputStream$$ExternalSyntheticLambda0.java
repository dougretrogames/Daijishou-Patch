package org.apache.commons.io.output;

import java.util.function.Supplier;
import org.apache.commons.io.file.PathUtils;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class DeferredFileOutputStream$$ExternalSyntheticLambda0 implements Supplier {
    @Override // java.util.function.Supplier
    public final Object get() {
        return PathUtils.getTempDirectory();
    }
}

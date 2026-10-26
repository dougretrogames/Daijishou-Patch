package org.apache.commons.io.output;

import java.util.function.Supplier;
import org.apache.commons.io.file.PathUtils;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class DeferredFileOutputStream$$ExternalSyntheticLambda0 implements Supplier {
    @Override // java.util.function.Supplier
    public final Object get() {
        return PathUtils.getTempDirectory();
    }
}

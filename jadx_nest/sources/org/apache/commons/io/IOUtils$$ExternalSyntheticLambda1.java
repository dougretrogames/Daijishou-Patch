package org.apache.commons.io;

import java.io.InputStream;
import org.apache.commons.io.function.IOTriFunction;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOUtils$$ExternalSyntheticLambda1 implements IOTriFunction {
    public final /* synthetic */ InputStream f$0;

    public /* synthetic */ IOUtils$$ExternalSyntheticLambda1(InputStream inputStream) {
        this.f$0 = inputStream;
    }

    @Override // org.apache.commons.io.function.IOTriFunction
    public final Object apply(Object obj, Object obj2, Object obj3) {
        return Integer.valueOf(this.f$0.read((byte[]) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue()));
    }
}

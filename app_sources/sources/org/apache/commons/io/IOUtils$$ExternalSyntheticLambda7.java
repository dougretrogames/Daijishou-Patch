package org.apache.commons.io;

import org.apache.commons.io.function.IOFunction;
import org.apache.commons.io.output.ThresholdingOutputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOUtils$$ExternalSyntheticLambda7 implements IOFunction {
    public final /* synthetic */ UnsynchronizedByteArrayOutputStream f$0;

    public /* synthetic */ IOUtils$$ExternalSyntheticLambda7(UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream) {
        this.f$0 = unsynchronizedByteArrayOutputStream;
    }

    @Override // org.apache.commons.io.function.IOFunction
    public final Object apply(Object obj) {
        return IOUtils.lambda$toByteArray$1(this.f$0, (ThresholdingOutputStream) obj);
    }
}

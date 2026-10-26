package org.apache.commons.io.output;

import org.apache.commons.io.function.IOSupplier;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class UnsynchronizedByteArrayOutputStream$$ExternalSyntheticLambda0 implements IOSupplier {
    public final /* synthetic */ byte[] f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ UnsynchronizedByteArrayOutputStream$$ExternalSyntheticLambda0(byte[] bArr, int i, int i2) {
        this.f$0 = bArr;
        this.f$1 = i;
        this.f$2 = i2;
    }

    @Override // org.apache.commons.io.function.IOSupplier
    public final Object get() {
        byte[] bArr = this.f$0;
        return UnsynchronizedByteArrayInputStream.builder().setByteArray(bArr).setOffset(this.f$1).setLength(this.f$2).get();
    }
}

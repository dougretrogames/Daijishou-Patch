package org.apache.commons.io.output;

import java.io.InputStream;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class UnsynchronizedByteArrayOutputStream$$ExternalSyntheticLambda1 implements AbstractByteArrayOutputStream.InputStreamConstructor {
    @Override // org.apache.commons.io.output.AbstractByteArrayOutputStream.InputStreamConstructor
    public final InputStream construct(byte[] bArr, int i, int i2) {
        return UnsynchronizedByteArrayOutputStream.lambda$toInputStream$1(bArr, i, i2);
    }
}

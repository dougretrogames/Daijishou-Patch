package org.eclipse.jgit.util.io;

import java.util.concurrent.Callable;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IsolatedOutputStream$$ExternalSyntheticLambda1 implements Callable {
    public final /* synthetic */ IsolatedOutputStream f$0;
    public final /* synthetic */ byte[] f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ IsolatedOutputStream$$ExternalSyntheticLambda1(IsolatedOutputStream isolatedOutputStream, byte[] bArr, int i, int i2) {
        this.f$0 = isolatedOutputStream;
        this.f$1 = bArr;
        this.f$2 = i;
        this.f$3 = i2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f$0.m5863lambda$0$orgeclipsejgitutilioIsolatedOutputStream(this.f$1, this.f$2, this.f$3);
    }
}

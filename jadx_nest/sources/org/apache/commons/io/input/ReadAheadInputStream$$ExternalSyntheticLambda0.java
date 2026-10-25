package org.apache.commons.io.input;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ReadAheadInputStream$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ReadAheadInputStream f$0;
    public final /* synthetic */ byte[] f$1;

    public /* synthetic */ ReadAheadInputStream$$ExternalSyntheticLambda0(ReadAheadInputStream readAheadInputStream, byte[] bArr) {
        this.f$0 = readAheadInputStream;
        this.f$1 = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m5587x982106fc(this.f$1);
    }
}

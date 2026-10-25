package androidx.core.location;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f$0;
    public final /* synthetic */ Executor f$1;

    public /* synthetic */ LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda2(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.f$0 = preRGnssStatusTransport;
        this.f$1 = executor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m3168x80a5cd6f(this.f$1);
    }
}

package androidx.core.location;

import android.location.GnssStatus;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f$0;
    public final /* synthetic */ Executor f$1;
    public final /* synthetic */ GnssStatus f$2;

    public /* synthetic */ LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda1(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, GnssStatus gnssStatus) {
        this.f$0 = preRGnssStatusTransport;
        this.f$1 = executor;
        this.f$2 = gnssStatus;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m3166xdecf6cdb(this.f$1, this.f$2);
    }
}

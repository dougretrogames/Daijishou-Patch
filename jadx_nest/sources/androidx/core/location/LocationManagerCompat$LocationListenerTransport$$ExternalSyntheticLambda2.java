package androidx.core.location;

import java.util.List;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda2(LocationManagerCompat.LocationListenerTransport locationListenerTransport, List list) {
        this.f$0 = locationListenerTransport;
        this.f$1 = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m3161x2b1fc01c(this.f$1);
    }
}

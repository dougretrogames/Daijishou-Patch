package androidx.core.location;

import android.location.Location;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f$0;
    public final /* synthetic */ Location f$1;

    public /* synthetic */ LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda3(LocationManagerCompat.LocationListenerTransport locationListenerTransport, Location location) {
        this.f$0 = locationListenerTransport;
        this.f$1 = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m3160xa8d50b3d(this.f$1);
    }
}

package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import java.util.concurrent.Executor;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ LocationManagerCompat.GnssMeasurementsTransport f$0;
    public final /* synthetic */ Executor f$1;
    public final /* synthetic */ GnssMeasurementsEvent f$2;

    public /* synthetic */ LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda0(LocationManagerCompat.GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, GnssMeasurementsEvent gnssMeasurementsEvent) {
        this.f$0 = gnssMeasurementsTransport;
        this.f$1 = executor;
        this.f$2 = gnssMeasurementsEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m3153xb1484c70(this.f$1, this.f$2);
    }
}

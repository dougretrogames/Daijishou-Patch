package androidx.core.location;

import android.location.Location;
import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class LocationManagerCompat$Api30Impl$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ androidx.core.util.Consumer f$0;

    public /* synthetic */ LocationManagerCompat$Api30Impl$$ExternalSyntheticLambda0(androidx.core.util.Consumer consumer) {
        this.f$0 = consumer;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.accept((Location) obj);
    }
}

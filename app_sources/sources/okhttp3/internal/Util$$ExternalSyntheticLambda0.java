package okhttp3.internal;

import okhttp3.Call;
import okhttp3.EventListener;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class Util$$ExternalSyntheticLambda0 implements EventListener.Factory {
    public final /* synthetic */ EventListener f$0;

    public /* synthetic */ Util$$ExternalSyntheticLambda0(EventListener eventListener) {
        this.f$0 = eventListener;
    }

    @Override // okhttp3.EventListener.Factory
    public final EventListener create(Call call) {
        return Util.asFactory$lambda$8(this.f$0, call);
    }
}

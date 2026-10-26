package kotlinx.coroutines.android;

import android.view.Choreographer;
import kotlinx.coroutines.CancellableContinuation;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class HandlerDispatcherKt$$ExternalSyntheticLambda0 implements Choreographer.FrameCallback {
    public final /* synthetic */ CancellableContinuation f$0;

    public /* synthetic */ HandlerDispatcherKt$$ExternalSyntheticLambda0(CancellableContinuation cancellableContinuation) {
        this.f$0 = cancellableContinuation;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        HandlerDispatcherKt.postFrameCallback$lambda$6(this.f$0, j);
    }
}

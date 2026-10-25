package kotlinx.coroutines.android;

import kotlinx.coroutines.DisposableHandle;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class HandlerContext$$ExternalSyntheticLambda0 implements DisposableHandle {
    public final /* synthetic */ HandlerContext f$0;
    public final /* synthetic */ Runnable f$1;

    public /* synthetic */ HandlerContext$$ExternalSyntheticLambda0(HandlerContext handlerContext, Runnable runnable) {
        this.f$0 = handlerContext;
        this.f$1 = runnable;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        HandlerContext.invokeOnTimeout$lambda$2(this.f$0, this.f$1);
    }
}

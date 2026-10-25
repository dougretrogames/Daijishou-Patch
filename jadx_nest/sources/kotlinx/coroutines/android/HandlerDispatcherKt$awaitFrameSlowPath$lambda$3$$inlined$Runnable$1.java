package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: Runnable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class HandlerDispatcherKt$awaitFrameSlowPath$lambda$3$$inlined$Runnable$1 implements Runnable {
    final /* synthetic */ CancellableContinuation $cont$inlined;

    public HandlerDispatcherKt$awaitFrameSlowPath$lambda$3$$inlined$Runnable$1(CancellableContinuation cancellableContinuation) {
        this.$cont$inlined = cancellableContinuation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HandlerDispatcherKt.updateChoreographerAndPostFrameCallback(this.$cont$inlined);
    }
}

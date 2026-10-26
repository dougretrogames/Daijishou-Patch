package androidx.compose.ui.platform;

import android.view.Choreographer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;

/* INFO: compiled from: AndroidUiFrameClock.android.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "R", "frameTimeNanos", "", "doFrame"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class AndroidUiFrameClock$withFrameNanos$2$callback$1 implements Choreographer.FrameCallback {
    final /* synthetic */ CancellableContinuation<R> $co;
    final /* synthetic */ Function1<Long, R> $onFrame;
    final /* synthetic */ AndroidUiFrameClock this$0;

    /* WARN: Multi-variable type inference failed */
    AndroidUiFrameClock$withFrameNanos$2$callback$1(CancellableContinuation<? super R> cancellableContinuation, AndroidUiFrameClock androidUiFrameClock, Function1<? super Long, ? extends R> function1) {
        this.$co = cancellableContinuation;
        this.this$0 = androidUiFrameClock;
        this.$onFrame = function1;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        Object objM3752constructorimpl;
        Continuation continuation = this.$co;
        Function1<Long, R> function1 = this.$onFrame;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM3752constructorimpl = Result.m3752constructorimpl(function1.invoke(Long.valueOf(j)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM3752constructorimpl = Result.m3752constructorimpl(ResultKt.createFailure(th));
        }
        continuation.resumeWith(objM3752constructorimpl);
    }
}

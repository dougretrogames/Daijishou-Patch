package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* INFO: compiled from: WithLifecycleState.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/lifecycle/WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements LifecycleEventObserver {
    final /* synthetic */ Function0<R> $block;
    final /* synthetic */ CancellableContinuation<R> $co;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked;

    /* WARN: Multi-variable type inference failed */
    WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(Lifecycle.State state, Lifecycle lifecycle, CancellableContinuation<? super R> cancellableContinuation, Function0<? extends R> function0) {
        this.$state = state;
        this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
        this.$co = cancellableContinuation;
        this.$block = function0;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Object objM3752constructorimpl;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.INSTANCE.upTo(this.$state)) {
            this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this);
            Continuation continuation = this.$co;
            Function0<R> function0 = this.$block;
            try {
                Result.Companion companion = Result.INSTANCE;
                objM3752constructorimpl = Result.m3752constructorimpl(function0.invoke());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM3752constructorimpl = Result.m3752constructorimpl(ResultKt.createFailure(th));
            }
            continuation.resumeWith(objM3752constructorimpl);
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this);
            Continuation continuation2 = this.$co;
            Result.Companion companion3 = Result.INSTANCE;
            continuation2.resumeWith(Result.m3752constructorimpl(ResultKt.createFailure(new LifecycleDestroyedException())));
        }
    }
}

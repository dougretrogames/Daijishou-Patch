package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* INFO: compiled from: Collect.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 176)
public final class FlowKt__CollectKt$collect$3$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowKt__CollectKt.AnonymousClass3<T> this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__CollectKt$collect$3$emit$1(FlowKt__CollectKt.AnonymousClass3<T> anonymousClass3, Continuation<? super FlowKt__CollectKt$collect$3$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass3;
    }

    /* WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}

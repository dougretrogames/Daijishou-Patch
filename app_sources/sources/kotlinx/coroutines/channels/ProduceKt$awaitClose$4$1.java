package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;

/* INFO: compiled from: Produce.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ProduceKt$awaitClose$4$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CancellableContinuation<Unit> $cont;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* WARN: Multi-variable type inference failed */
    ProduceKt$awaitClose$4$1(CancellableContinuation<? super Unit> cancellableContinuation) {
        super(1);
        this.$cont = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        CancellableContinuation<Unit> cancellableContinuation = this.$cont;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m3752constructorimpl(Unit.INSTANCE));
    }
}

package com.magneticchen.daijishou.view_models;

import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DaijishouConsoleViewModel$commands$5$execute$3$2 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ Continuation<DaijishouConsoleViewModel.Companion.CommandResult> $continuation;
    final /* synthetic */ Ref.BooleanRef $selected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DaijishouConsoleViewModel$commands$5$execute$3$2(Ref.BooleanRef booleanRef, Continuation<?> continuation) {
        super(0);
        this.$selected = booleanRef;
        this.$continuation = (Continuation<DaijishouConsoleViewModel.Companion.CommandResult>) continuation;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        CancellationException cancellationException = new CancellationException("Aborted.");
        if (this.$selected.element) {
            return;
        }
        Continuation<DaijishouConsoleViewModel.Companion.CommandResult> continuation = this.$continuation;
        String message = cancellationException.getMessage();
        if (message == null) {
            message = ExceptionsKt.stackTraceToString(cancellationException);
        }
        DaijishouConsoleViewModel.Companion.CommandResult commandResult = new DaijishouConsoleViewModel.Companion.CommandResult(message, DaijishouConsoleViewModel.Companion.CommandResult.INSTANCE.getFAILED_STATUS_CODE(), cancellationException, false, 8, null);
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(com.magneticchen.daijishou.support.DaijishouValueSupport.resultConstructor(commandResult));
    }
}

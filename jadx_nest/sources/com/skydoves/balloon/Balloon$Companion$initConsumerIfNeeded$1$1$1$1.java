package com.skydoves.balloon;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: Balloon.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class Balloon$Companion$initConsumerIfNeeded$1$1$1$1 implements Function0<Unit> {
    final /* synthetic */ CancellableContinuation<Unit> $cont;
    final /* synthetic */ DeferredBalloonGroup $group;
    final /* synthetic */ OnBalloonDismissListener $previousListener;

    /* JADX WARN: Multi-variable type inference failed */
    Balloon$Companion$initConsumerIfNeeded$1$1$1$1(CancellableContinuation<? super Unit> cancellableContinuation, OnBalloonDismissListener onBalloonDismissListener, DeferredBalloonGroup deferredBalloonGroup) {
        this.$cont = cancellableContinuation;
        this.$previousListener = onBalloonDismissListener;
        this.$group = deferredBalloonGroup;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        CancellableContinuation<Unit> cancellableContinuation = this.$cont;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m3752constructorimpl(Unit.INSTANCE));
        OnBalloonDismissListener onBalloonDismissListener = this.$previousListener;
        if (onBalloonDismissListener != null) {
            onBalloonDismissListener.onBalloonDismiss();
        }
        if (this.$group.getDismissSequentially()) {
            return;
        }
        Iterator<T> it = this.$group.getBalloons().iterator();
        while (it.hasNext()) {
            ((DeferredBalloon) it.next()).getBalloon().dismiss();
        }
    }
}

package com.skydoves.balloon;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* INFO: compiled from: Balloon.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class Balloon$relayShowAtCenter$$inlined$relay$1 implements Function0<Unit> {
    final /* synthetic */ View $anchor$inlined;
    final /* synthetic */ Balloon $balloon;
    final /* synthetic */ BalloonCenterAlign $centerAlign$inlined;
    final /* synthetic */ OnBalloonDismissListener $previousListener;
    final /* synthetic */ int $xOff$inlined;
    final /* synthetic */ int $yOff$inlined;
    final /* synthetic */ Balloon this$0;

    public Balloon$relayShowAtCenter$$inlined$relay$1(OnBalloonDismissListener onBalloonDismissListener, Balloon balloon, Balloon balloon2, View view, int i, int i2, BalloonCenterAlign balloonCenterAlign) {
        this.$previousListener = onBalloonDismissListener;
        this.this$0 = balloon;
        this.$balloon = balloon2;
        this.$anchor$inlined = view;
        this.$xOff$inlined = i;
        this.$yOff$inlined = i2;
        this.$centerAlign$inlined = balloonCenterAlign;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        OnBalloonDismissListener onBalloonDismissListener = this.$previousListener;
        if (onBalloonDismissListener != null) {
            onBalloonDismissListener.onBalloonDismiss();
        }
        if (this.this$0.destroyed) {
            return;
        }
        this.$balloon.showAtCenter(this.$anchor$inlined, this.$xOff$inlined, this.$yOff$inlined, this.$centerAlign$inlined);
    }
}

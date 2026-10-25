package com.skydoves.balloon;

import android.view.View;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Balloon.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class Balloon$relayShowAlign$$inlined$relay$1 implements Function0<Unit> {
    final /* synthetic */ BalloonAlign $align$inlined;
    final /* synthetic */ View $anchor$inlined;
    final /* synthetic */ Balloon $balloon;
    final /* synthetic */ OnBalloonDismissListener $previousListener;
    final /* synthetic */ int $xOff$inlined;
    final /* synthetic */ int $yOff$inlined;
    final /* synthetic */ Balloon this$0;

    public Balloon$relayShowAlign$$inlined$relay$1(OnBalloonDismissListener onBalloonDismissListener, Balloon balloon, Balloon balloon2, BalloonAlign balloonAlign, View view, int i, int i2) {
        this.$previousListener = onBalloonDismissListener;
        this.this$0 = balloon;
        this.$balloon = balloon2;
        this.$align$inlined = balloonAlign;
        this.$anchor$inlined = view;
        this.$xOff$inlined = i;
        this.$yOff$inlined = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        OnBalloonDismissListener onBalloonDismissListener = this.$previousListener;
        if (onBalloonDismissListener != null) {
            onBalloonDismissListener.onBalloonDismiss();
        }
        if (this.this$0.destroyed) {
            return;
        }
        Balloon balloon = this.$balloon;
        int i = Balloon.WhenMappings.$EnumSwitchMapping$6[this.$align$inlined.ordinal()];
        if (i == 1) {
            balloon.showAlignTop(this.$anchor$inlined, this.$xOff$inlined, this.$yOff$inlined);
            return;
        }
        if (i == 2) {
            balloon.showAlignBottom(this.$anchor$inlined, this.$xOff$inlined, this.$yOff$inlined);
        } else if (i == 3) {
            balloon.showAlignStart(this.$anchor$inlined, this.$xOff$inlined, this.$yOff$inlined);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            balloon.showAlignEnd(this.$anchor$inlined, this.$xOff$inlined, this.$yOff$inlined);
        }
    }
}

package com.skydoves.balloon;

import android.view.View;
import kotlin.Metadata;

/* INFO: compiled from: BalloonExtension.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class BalloonExtensionKt$showAsDropDown$$inlined$balloon$1 implements Runnable {
    final /* synthetic */ Balloon $balloon$inlined;
    final /* synthetic */ View $this_showAsDropDown$inlined;
    final /* synthetic */ int $xOff$inlined;
    final /* synthetic */ int $yOff$inlined;

    public BalloonExtensionKt$showAsDropDown$$inlined$balloon$1(Balloon balloon, View view, int i, int i2) {
        this.$balloon$inlined = balloon;
        this.$this_showAsDropDown$inlined = view;
        this.$xOff$inlined = i;
        this.$yOff$inlined = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$balloon$inlined.showAsDropDown(this.$this_showAsDropDown$inlined, this.$xOff$inlined, this.$yOff$inlined);
    }
}

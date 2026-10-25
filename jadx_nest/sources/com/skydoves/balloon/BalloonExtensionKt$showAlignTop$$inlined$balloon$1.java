package com.skydoves.balloon;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: compiled from: BalloonExtension.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class BalloonExtensionKt$showAlignTop$$inlined$balloon$1 implements Runnable {
    final /* synthetic */ Balloon $balloon$inlined;
    final /* synthetic */ View $this_showAlignTop$inlined;
    final /* synthetic */ int $xOff$inlined;
    final /* synthetic */ int $yOff$inlined;

    public BalloonExtensionKt$showAlignTop$$inlined$balloon$1(Balloon balloon, View view, int i, int i2) {
        this.$balloon$inlined = balloon;
        this.$this_showAlignTop$inlined = view;
        this.$xOff$inlined = i;
        this.$yOff$inlined = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$balloon$inlined.showAlignTop(this.$this_showAlignTop$inlined, this.$xOff$inlined, this.$yOff$inlined);
    }
}

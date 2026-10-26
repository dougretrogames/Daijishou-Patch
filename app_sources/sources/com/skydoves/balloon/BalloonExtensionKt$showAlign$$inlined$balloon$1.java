package com.skydoves.balloon;

import android.view.View;
import java.util.List;
import kotlin.Metadata;

/* INFO: compiled from: BalloonExtension.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class BalloonExtensionKt$showAlign$$inlined$balloon$1 implements Runnable {
    final /* synthetic */ BalloonAlign $align$inlined;
    final /* synthetic */ Balloon $balloon$inlined;
    final /* synthetic */ List $subAnchorList$inlined;
    final /* synthetic */ View $this_showAlign$inlined;
    final /* synthetic */ int $xOff$inlined;
    final /* synthetic */ int $yOff$inlined;

    public BalloonExtensionKt$showAlign$$inlined$balloon$1(Balloon balloon, BalloonAlign balloonAlign, View view, List list, int i, int i2) {
        this.$balloon$inlined = balloon;
        this.$align$inlined = balloonAlign;
        this.$this_showAlign$inlined = view;
        this.$subAnchorList$inlined = list;
        this.$xOff$inlined = i;
        this.$yOff$inlined = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$balloon$inlined.showAlign(this.$align$inlined, this.$this_showAlign$inlined, this.$subAnchorList$inlined, this.$xOff$inlined, this.$yOff$inlined);
    }
}

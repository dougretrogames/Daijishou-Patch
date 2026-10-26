package com.skydoves.balloon;

import android.view.View;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class Balloon$$ExternalSyntheticLambda9 implements View.OnClickListener {
    public final /* synthetic */ OnBalloonOverlayClickListener f$0;
    public final /* synthetic */ Balloon f$1;

    public /* synthetic */ Balloon$$ExternalSyntheticLambda9(OnBalloonOverlayClickListener onBalloonOverlayClickListener, Balloon balloon) {
        this.f$0 = onBalloonOverlayClickListener;
        this.f$1 = balloon;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Balloon.setOnBalloonOverlayClickListener$lambda$51(this.f$0, this.f$1, view);
    }
}

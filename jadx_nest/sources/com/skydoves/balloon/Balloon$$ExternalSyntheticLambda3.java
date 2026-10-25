package com.skydoves.balloon;

import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Balloon$$ExternalSyntheticLambda3 implements View.OnClickListener {
    public final /* synthetic */ OnBalloonClickListener f$0;
    public final /* synthetic */ Balloon f$1;

    public /* synthetic */ Balloon$$ExternalSyntheticLambda3(OnBalloonClickListener onBalloonClickListener, Balloon balloon) {
        this.f$0 = onBalloonClickListener;
        this.f$1 = balloon;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Balloon.setOnBalloonClickListener$lambda$47(this.f$0, this.f$1, view);
    }
}

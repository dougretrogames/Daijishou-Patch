package com.skydoves.balloon;

import android.widget.PopupWindow;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Balloon$$ExternalSyntheticLambda5 implements PopupWindow.OnDismissListener {
    public final /* synthetic */ Balloon f$0;
    public final /* synthetic */ OnBalloonDismissListener f$1;

    public /* synthetic */ Balloon$$ExternalSyntheticLambda5(Balloon balloon, OnBalloonDismissListener onBalloonDismissListener) {
        this.f$0 = balloon;
        this.f$1 = onBalloonDismissListener;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        Balloon.setOnBalloonDismissListener$lambda$48(this.f$0, this.f$1);
    }
}

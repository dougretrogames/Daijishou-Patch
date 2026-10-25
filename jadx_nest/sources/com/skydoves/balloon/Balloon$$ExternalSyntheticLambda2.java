package com.skydoves.balloon;

import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Balloon$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ Balloon f$0;
    public final /* synthetic */ View f$1;
    public final /* synthetic */ BalloonPlacement f$2;

    public /* synthetic */ Balloon$$ExternalSyntheticLambda2(Balloon balloon, View view, BalloonPlacement balloonPlacement) {
        this.f$0 = balloon;
        this.f$1 = view;
        this.f$2 = balloonPlacement;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Balloon.show$lambda$34(this.f$0, this.f$1, this.f$2);
    }
}

package com.skydoves.balloon;

import android.view.View;
import android.widget.ImageView;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class Balloon$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Balloon f$0;
    public final /* synthetic */ View f$1;
    public final /* synthetic */ ImageView f$2;

    public /* synthetic */ Balloon$$ExternalSyntheticLambda1(Balloon balloon, View view, ImageView imageView) {
        this.f$0 = balloon;
        this.f$1 = view;
        this.f$2 = imageView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Balloon.initializeArrow$lambda$7$lambda$6(this.f$0, this.f$1, this.f$2);
    }
}

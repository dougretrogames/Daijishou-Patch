package com.skydoves.balloon;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.functions.Function2;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class Balloon$$ExternalSyntheticLambda10 implements Function2 {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ Balloon f$1;

    public /* synthetic */ Balloon$$ExternalSyntheticLambda10(View view, Balloon balloon) {
        this.f$0 = view;
        this.f$1 = balloon;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return Boolean.valueOf(Balloon.passTouchEventToAnchor$lambda$50(this.f$0, this.f$1, (View) obj, (MotionEvent) obj2));
    }
}

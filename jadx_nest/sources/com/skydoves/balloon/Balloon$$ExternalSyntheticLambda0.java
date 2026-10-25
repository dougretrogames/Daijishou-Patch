package com.skydoves.balloon;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Balloon$$ExternalSyntheticLambda0 implements View.OnTouchListener {
    public final /* synthetic */ Function2 f$0;

    public /* synthetic */ Balloon$$ExternalSyntheticLambda0(Function2 function2) {
        this.f$0 = function2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return Balloon.setOnBalloonOverlayTouchListener$lambda$49(this.f$0, view, motionEvent);
    }
}

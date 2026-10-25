package com.magneticchen.daijishou.activities;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda6 implements View.OnTouchListener {
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda6(MainActivity mainActivity) {
        this.f$0 = mainActivity;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return MainActivity.onAttachLockScreenListener$lambda$21(this.f$0, view, motionEvent);
    }
}

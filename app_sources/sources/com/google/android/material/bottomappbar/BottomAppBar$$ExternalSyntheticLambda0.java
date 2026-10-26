package com.google.android.material.bottomappbar;

import android.view.View;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class BottomAppBar$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ View f$0;

    public /* synthetic */ BottomAppBar$$ExternalSyntheticLambda0(View view) {
        this.f$0 = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.requestLayout();
    }
}

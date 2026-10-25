package com.magneticchen.daijishou.activities;

import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda8 implements View.OnClickListener {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda8(MainActivity mainActivity, int i) {
        this.f$0 = mainActivity;
        this.f$1 = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            MainActivity.setupTabLayout$lambda$26(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

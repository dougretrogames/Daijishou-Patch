package com.magneticchen.daijishou.activities;

import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda1(MainActivity mainActivity) {
        this.f$0 = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            MainActivity.startCreating$lambda$6(this.f$0, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

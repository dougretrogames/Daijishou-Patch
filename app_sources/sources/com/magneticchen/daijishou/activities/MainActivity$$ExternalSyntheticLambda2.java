package com.magneticchen.daijishou.activities;

import android.view.View;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda2(MainActivity mainActivity) {
        this.f$0 = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            MainActivity.startCreating$lambda$7(this.f$0, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

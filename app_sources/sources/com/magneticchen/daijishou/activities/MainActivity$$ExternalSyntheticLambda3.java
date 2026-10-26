package com.magneticchen.daijishou.activities;

import android.view.View;
import kotlin.Lazy;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda3 implements View.OnClickListener {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ Lazy f$1;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda3(MainActivity mainActivity, Lazy lazy) {
        this.f$0 = mainActivity;
        this.f$1 = lazy;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            MainActivity.startCreating$lambda$8(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

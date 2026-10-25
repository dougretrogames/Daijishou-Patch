package com.magneticchen.daijishou.settings_nav_fragments;

import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AboutThisAppNavFragment$$ExternalSyntheticLambda4 implements View.OnClickListener {
    public final /* synthetic */ AboutThisAppNavFragment f$0;

    public /* synthetic */ AboutThisAppNavFragment$$ExternalSyntheticLambda4(AboutThisAppNavFragment aboutThisAppNavFragment) {
        this.f$0 = aboutThisAppNavFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            AboutThisAppNavFragment.onCreateView$lambda$4(this.f$0, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

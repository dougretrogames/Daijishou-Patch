package com.magneticchen.daijishou.nav_fragments;

import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class PlatformEmptyNavFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ PlatformEmptyNavFragment f$0;

    public /* synthetic */ PlatformEmptyNavFragment$$ExternalSyntheticLambda0(PlatformEmptyNavFragment platformEmptyNavFragment) {
        this.f$0 = platformEmptyNavFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            PlatformEmptyNavFragment.onCreateView$lambda$0(this.f$0, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

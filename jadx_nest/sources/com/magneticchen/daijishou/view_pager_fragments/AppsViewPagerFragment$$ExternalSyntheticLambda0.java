package com.magneticchen.daijishou.view_pager_fragments;

import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AppsViewPagerFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ AppsViewPagerFragment f$0;

    public /* synthetic */ AppsViewPagerFragment$$ExternalSyntheticLambda0(AppsViewPagerFragment appsViewPagerFragment) {
        this.f$0 = appsViewPagerFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            AppsViewPagerFragment.onCreateView$lambda$1(this.f$0, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

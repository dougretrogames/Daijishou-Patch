package com.magneticchen.daijishou.view_pager_fragments;

import androidx.fragment.app.FragmentManager;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class WidgetsViewPagerFragment$$ExternalSyntheticLambda0 implements FragmentManager.OnBackStackChangedListener {
    public final /* synthetic */ WidgetsViewPagerFragment f$0;

    public /* synthetic */ WidgetsViewPagerFragment$$ExternalSyntheticLambda0(WidgetsViewPagerFragment widgetsViewPagerFragment) {
        this.f$0 = widgetsViewPagerFragment;
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public final void onBackStackChanged() {
        try {
            WidgetsViewPagerFragment.onResume$lambda$0(this.f$0);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

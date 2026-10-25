package com.magneticchen.daijishou.nav_fragments;

import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda11 implements View.OnClickListener {
    public final /* synthetic */ PlatformLibraryListViewNavFragment f$0;

    public /* synthetic */ PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda11(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment) {
        this.f$0 = platformLibraryListViewNavFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            PlatformLibraryListViewNavFragment.onCreateView$lambda$25(this.f$0, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

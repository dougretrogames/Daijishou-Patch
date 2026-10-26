package com.magneticchen.daijishou.nav_fragments;

import android.content.Context;
import android.view.View;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda7 implements View.OnClickListener {
    public final /* synthetic */ PlatformLibraryListViewNavFragment f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda7(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment, Context context) {
        this.f$0 = platformLibraryListViewNavFragment;
        this.f$1 = context;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            PlatformLibraryListViewNavFragment.onCreateView$lambda$18(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

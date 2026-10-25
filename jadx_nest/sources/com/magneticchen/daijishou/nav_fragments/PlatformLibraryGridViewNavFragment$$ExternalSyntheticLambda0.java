package com.magneticchen.daijishou.nav_fragments;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class PlatformLibraryGridViewNavFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ PlatformLibraryGridViewNavFragment f$0;
    public final /* synthetic */ FragmentActivity f$1;

    public /* synthetic */ PlatformLibraryGridViewNavFragment$$ExternalSyntheticLambda0(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, FragmentActivity fragmentActivity) {
        this.f$0 = platformLibraryGridViewNavFragment;
        this.f$1 = fragmentActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            PlatformLibraryGridViewNavFragment.onCreateView$lambda$2(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

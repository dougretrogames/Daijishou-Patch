package com.magneticchen.daijishou.nav_fragments;

import android.content.SharedPreferences;
import android.view.View;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class PlatformLibraryGridViewNavFragment$$ExternalSyntheticLambda3 implements View.OnClickListener {
    public final /* synthetic */ PlatformLibraryGridViewNavFragment f$0;
    public final /* synthetic */ SharedPreferences f$1;

    public /* synthetic */ PlatformLibraryGridViewNavFragment$$ExternalSyntheticLambda3(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, SharedPreferences sharedPreferences) {
        this.f$0 = platformLibraryGridViewNavFragment;
        this.f$1 = sharedPreferences;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            PlatformLibraryGridViewNavFragment.onCreateView$lambda$7(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

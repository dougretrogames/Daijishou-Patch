package com.magneticchen.daijishou.nav_fragments;

import android.content.SharedPreferences;
import android.view.View;
import com.google.android.material.chip.Chip;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class PlatformLibraryGridViewNavFragment$onCreateView$16$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ PlatformLibraryGridViewNavFragment f$0;
    public final /* synthetic */ Chip f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ SharedPreferences f$4;

    public /* synthetic */ PlatformLibraryGridViewNavFragment$onCreateView$16$$ExternalSyntheticLambda0(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, Chip chip, String str, String str2, SharedPreferences sharedPreferences) {
        this.f$0 = platformLibraryGridViewNavFragment;
        this.f$1 = chip;
        this.f$2 = str;
        this.f$3 = str2;
        this.f$4 = sharedPreferences;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            PlatformLibraryGridViewNavFragment.invoke$lambda$2$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

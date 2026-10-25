package com.magneticchen.daijishou.settings_nav_fragments;

import android.view.View;
import android.widget.ImageView;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AboutThisAppNavFragment$$ExternalSyntheticLambda0 implements View.OnScrollChangeListener {
    public final /* synthetic */ AboutThisAppNavFragment f$0;
    public final /* synthetic */ ImageView f$1;

    public /* synthetic */ AboutThisAppNavFragment$$ExternalSyntheticLambda0(AboutThisAppNavFragment aboutThisAppNavFragment, ImageView imageView) {
        this.f$0 = aboutThisAppNavFragment;
        this.f$1 = imageView;
    }

    @Override // android.view.View.OnScrollChangeListener
    public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
        try {
            AboutThisAppNavFragment.onCreateView$lambda$0(this.f$0, this.f$1, view, i, i2, i3, i4);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

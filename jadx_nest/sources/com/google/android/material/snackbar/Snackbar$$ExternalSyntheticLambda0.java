package com.google.android.material.snackbar;

import android.view.View;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class Snackbar$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ Snackbar f$0;
    public final /* synthetic */ View.OnClickListener f$1;

    public /* synthetic */ Snackbar$$ExternalSyntheticLambda0(Snackbar snackbar, View.OnClickListener onClickListener) {
        this.f$0 = snackbar;
        this.f$1 = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f$0.m3329lambda$setAction$0$comgoogleandroidmaterialsnackbarSnackbar(this.f$1, view);
    }
}

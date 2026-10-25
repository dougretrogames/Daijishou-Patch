package com.magneticchen.daijishou.abstract_fragment_classes;

import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.WindowInsetsControllerCompat;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class DaijishouDialogFragment$$ExternalSyntheticLambda1 implements View.OnApplyWindowInsetsListener {
    public final /* synthetic */ WindowInsetsControllerCompat f$0;

    public /* synthetic */ DaijishouDialogFragment$$ExternalSyntheticLambda1(WindowInsetsControllerCompat windowInsetsControllerCompat) {
        this.f$0 = windowInsetsControllerCompat;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return DaijishouDialogFragment.hideSystemBars$lambda$3(this.f$0, view, windowInsets);
    }
}

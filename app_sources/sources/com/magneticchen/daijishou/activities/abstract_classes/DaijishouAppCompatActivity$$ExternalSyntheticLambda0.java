package com.magneticchen.daijishou.activities.abstract_classes;

import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.WindowInsetsControllerCompat;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class DaijishouAppCompatActivity$$ExternalSyntheticLambda0 implements View.OnApplyWindowInsetsListener {
    public final /* synthetic */ WindowInsetsControllerCompat f$0;

    public /* synthetic */ DaijishouAppCompatActivity$$ExternalSyntheticLambda0(WindowInsetsControllerCompat windowInsetsControllerCompat) {
        this.f$0 = windowInsetsControllerCompat;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return DaijishouAppCompatActivity.hideSystemBars$lambda$1(this.f$0, view, windowInsets);
    }
}

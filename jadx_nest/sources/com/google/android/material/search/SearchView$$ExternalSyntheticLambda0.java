package com.google.android.material.search;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SearchView$$ExternalSyntheticLambda0 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ ViewGroup.MarginLayoutParams f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ SearchView$$ExternalSyntheticLambda0(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
        this.f$0 = marginLayoutParams;
        this.f$1 = i;
        this.f$2 = i2;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return SearchView.lambda$setUpDividerInsetListener$6(this.f$0, this.f$1, this.f$2, view, windowInsetsCompat);
    }
}

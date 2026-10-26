package com.magneticchen.daijishou.abstract_fragment_classes;

import android.view.View;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class DaijishouPreferenceFragmentCompat$$ExternalSyntheticLambda0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ DaijishouPreferenceFragmentCompat f$0;

    public /* synthetic */ DaijishouPreferenceFragmentCompat$$ExternalSyntheticLambda0(DaijishouPreferenceFragmentCompat daijishouPreferenceFragmentCompat) {
        this.f$0 = daijishouPreferenceFragmentCompat;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        try {
            DaijishouPreferenceFragmentCompat.onViewCreated$lambda$2(this.f$0, view, i, i2, i3, i4, i5, i6, i7, i8);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

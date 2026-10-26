package androidx.preference;

import androidx.fragment.app.FragmentManager;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class PreferenceHeaderFragmentCompat$$ExternalSyntheticLambda0 implements FragmentManager.OnBackStackChangedListener {
    public final /* synthetic */ PreferenceHeaderFragmentCompat f$0;

    public /* synthetic */ PreferenceHeaderFragmentCompat$$ExternalSyntheticLambda0(PreferenceHeaderFragmentCompat preferenceHeaderFragmentCompat) {
        this.f$0 = preferenceHeaderFragmentCompat;
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public final void onBackStackChanged() {
        PreferenceHeaderFragmentCompat.m3225onViewCreated$lambda10(this.f$0);
    }
}

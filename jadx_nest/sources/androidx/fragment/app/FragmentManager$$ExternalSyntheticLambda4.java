package androidx.fragment.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FragmentManager$$ExternalSyntheticLambda4 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ FragmentManager f$0;

    public /* synthetic */ FragmentManager$$ExternalSyntheticLambda4(FragmentManager fragmentManager) {
        this.f$0 = fragmentManager;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        return this.f$0.m3192lambda$attachController$5$androidxfragmentappFragmentManager();
    }
}

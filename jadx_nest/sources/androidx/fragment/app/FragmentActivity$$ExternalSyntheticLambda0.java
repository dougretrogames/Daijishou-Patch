package androidx.fragment.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FragmentActivity$$ExternalSyntheticLambda0 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ FragmentActivity f$0;

    public /* synthetic */ FragmentActivity$$ExternalSyntheticLambda0(FragmentActivity fragmentActivity) {
        this.f$0 = fragmentActivity;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        return this.f$0.m3187lambda$init$0$androidxfragmentappFragmentActivity();
    }
}

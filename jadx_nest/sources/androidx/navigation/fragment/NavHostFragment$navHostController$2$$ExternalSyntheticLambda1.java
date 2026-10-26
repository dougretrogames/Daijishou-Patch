package androidx.navigation.fragment;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class NavHostFragment$navHostController$2$$ExternalSyntheticLambda1 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ NavHostFragment f$0;

    public /* synthetic */ NavHostFragment$navHostController$2$$ExternalSyntheticLambda1(NavHostFragment navHostFragment) {
        this.f$0 = navHostFragment;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        return NavHostFragment$navHostController$2.invoke$lambda$5$lambda$4(this.f$0);
    }
}

package androidx.navigation.fragment;

import android.os.Bundle;
import androidx.navigation.NavHostController;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class NavHostFragment$navHostController$2$$ExternalSyntheticLambda0 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ NavHostController f$0;

    public /* synthetic */ NavHostFragment$navHostController$2$$ExternalSyntheticLambda0(NavHostController navHostController) {
        this.f$0 = navHostController;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        return NavHostFragment$navHostController$2.invoke$lambda$5$lambda$2(this.f$0);
    }
}

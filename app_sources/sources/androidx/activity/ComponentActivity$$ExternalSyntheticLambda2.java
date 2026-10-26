package androidx.activity;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda2 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ ComponentActivity f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda2(ComponentActivity componentActivity) {
        this.f$0 = componentActivity;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        return this.f$0.m1lambda$new$1$androidxactivityComponentActivity();
    }
}

package androidx.compose.ui.platform;

import android.os.Bundle;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DisposableSaveableStateRegistry_androidKt$$ExternalSyntheticLambda0 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ SaveableStateRegistry f$0;

    public /* synthetic */ DisposableSaveableStateRegistry_androidKt$$ExternalSyntheticLambda0(SaveableStateRegistry saveableStateRegistry) {
        this.f$0 = saveableStateRegistry;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        return DisposableSaveableStateRegistry_androidKt.DisposableSaveableStateRegistry$lambda$0(this.f$0);
    }
}

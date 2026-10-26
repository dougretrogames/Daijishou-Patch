package androidx.lifecycle.viewmodel.compose;

import android.os.Bundle;
import androidx.compose.runtime.saveable.Saver;
import androidx.savedstate.SavedStateRegistry;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class SavedStateHandleSaverKt$$ExternalSyntheticLambda1 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ Saver f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ SavedStateHandleSaverKt$$ExternalSyntheticLambda1(Saver saver, Object obj) {
        this.f$0 = saver;
        this.f$1 = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        return SavedStateHandleSaverKt.saveable$lambda$1(this.f$0, this.f$1);
    }
}

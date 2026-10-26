package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class WindowRecomposerFactory$Companion$$ExternalSyntheticLambda0 implements WindowRecomposerFactory {
    @Override // androidx.compose.ui.platform.WindowRecomposerFactory
    public final Recomposer createRecomposer(View view) {
        return WindowRecomposerFactory.Companion.LifecycleAware$lambda$0(view);
    }
}

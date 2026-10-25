package androidx.core.view;

import android.view.WindowInsetsController;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0 implements WindowInsetsController.OnControllableInsetsChangedListener {
    public final /* synthetic */ AtomicBoolean f$0;

    public /* synthetic */ SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0(AtomicBoolean atomicBoolean) {
        this.f$0 = atomicBoolean;
    }

    @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i) {
        this.f$0.set((i & 8) != 0);
    }
}

package androidx.core.view;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ViewConfigurationCompat$$ExternalSyntheticLambda1 implements Supplier {
    public final /* synthetic */ ViewConfiguration f$0;

    public /* synthetic */ ViewConfigurationCompat$$ExternalSyntheticLambda1(ViewConfiguration viewConfiguration) {
        this.f$0 = viewConfiguration;
    }

    @Override // androidx.core.util.Supplier
    public final Object get() {
        return Integer.valueOf(this.f$0.getScaledMinimumFlingVelocity());
    }
}

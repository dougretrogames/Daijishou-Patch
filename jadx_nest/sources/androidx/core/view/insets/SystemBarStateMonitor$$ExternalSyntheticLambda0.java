package androidx.core.view.insets;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SystemBarStateMonitor$$ExternalSyntheticLambda0 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ SystemBarStateMonitor f$0;

    public /* synthetic */ SystemBarStateMonitor$$ExternalSyntheticLambda0(SystemBarStateMonitor systemBarStateMonitor) {
        this.f$0 = systemBarStateMonitor;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.f$0.m3176lambda$new$0$androidxcoreviewinsetsSystemBarStateMonitor(view, windowInsetsCompat);
    }
}

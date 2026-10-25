package androidx.preference;

import android.view.View;
import androidx.activity.OnBackPressedCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {1, 6, 0})
public final class PreferenceHeaderFragmentCompat$onViewCreated$$inlined$doOnLayout$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ PreferenceHeaderFragmentCompat this$0;

    public PreferenceHeaderFragmentCompat$onViewCreated$$inlined$doOnLayout$1(PreferenceHeaderFragmentCompat preferenceHeaderFragmentCompat) {
        this.this$0 = preferenceHeaderFragmentCompat;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        view.removeOnLayoutChangeListener(this);
        OnBackPressedCallback onBackPressedCallback = this.this$0.onBackPressedCallback;
        Intrinsics.checkNotNull(onBackPressedCallback);
        onBackPressedCallback.setEnabled(this.this$0.getSlidingPaneLayout().isSlideable() && this.this$0.getSlidingPaneLayout().isOpen());
    }
}

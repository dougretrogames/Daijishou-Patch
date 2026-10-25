package androidx.compose.ui.platform;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0 implements android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener {
    public final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat f$0;

    public /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        this.f$0 = androidComposeViewAccessibilityDelegateCompat;
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z) {
        AndroidComposeViewAccessibilityDelegateCompat.enabledStateListener$lambda$0(this.f$0, z);
    }
}

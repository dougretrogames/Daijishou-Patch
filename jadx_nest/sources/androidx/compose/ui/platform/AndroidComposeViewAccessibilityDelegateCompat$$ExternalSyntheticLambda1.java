package androidx.compose.ui.platform;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1 implements android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener {
    public final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat f$0;

    public /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        this.f$0 = androidComposeViewAccessibilityDelegateCompat;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        AndroidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener$lambda$1(this.f$0, z);
    }
}

package androidx.navigation;

import androidx.activity.OnBackPressedCallback;
import kotlin.Metadata;

/* INFO: compiled from: NavController.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/navigation/NavController$onBackPressedCallback$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NavController$onBackPressedCallback$1 extends OnBackPressedCallback {
    final /* synthetic */ NavController this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavController$onBackPressedCallback$1(NavController navController) {
        super(false);
        this.this$0 = navController;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackPressed() {
        this.this$0.popBackStack();
    }
}

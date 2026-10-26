package com.magneticchen.daijishou.abstract_fragment_classes;

import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;

/* INFO: compiled from: DaijishouDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment$onCreateDialog$dialog$1", "Landroid/app/Dialog;", "onBackPressed", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouDialogFragment$onCreateDialog$dialog$1 extends Dialog {
    final /* synthetic */ DaijishouDialogFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DaijishouDialogFragment$onCreateDialog$dialog$1(DaijishouDialogFragment daijishouDialogFragment, FragmentActivity fragmentActivity, int i) {
        super(fragmentActivity, i);
        this.this$0 = daijishouDialogFragment;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.this$0.onBackPressed() && this.this$0.isCancelable()) {
            cancel();
        }
    }
}

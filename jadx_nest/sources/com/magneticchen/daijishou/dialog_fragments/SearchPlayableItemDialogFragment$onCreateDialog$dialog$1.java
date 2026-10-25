package com.magneticchen.daijishou.dialog_fragments;

import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchPlayableItemDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/magneticchen/daijishou/dialog_fragments/SearchPlayableItemDialogFragment$onCreateDialog$dialog$1", "Landroid/app/Dialog;", "onBackPressed", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SearchPlayableItemDialogFragment$onCreateDialog$dialog$1 extends Dialog {
    final /* synthetic */ SearchPlayableItemDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchPlayableItemDialogFragment$onCreateDialog$dialog$1(SearchPlayableItemDialogFragment searchPlayableItemDialogFragment, FragmentActivity fragmentActivity, int i) {
        super(fragmentActivity, i);
        this.this$0 = searchPlayableItemDialogFragment;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if ((!this.this$0.scrollingOnBackPressed || this.this$0.getRecyclerView().getScrollState() != 2) && this.this$0.getRecyclerView().computeVerticalScrollOffset() != 0) {
            this.this$0.scrollingOnBackPressed = true;
            this.this$0.getBackButtonLayout().requestFocus();
            this.this$0.getRecyclerView().smoothScrollToPosition(0);
        } else {
            this.this$0.getRecyclerView().scrollToPosition(0);
            super.onBackPressed();
        }
    }
}

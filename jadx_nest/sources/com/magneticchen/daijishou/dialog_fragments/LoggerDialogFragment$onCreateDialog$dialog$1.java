package com.magneticchen.daijishou.dialog_fragments;

import android.app.Dialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoggerDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/magneticchen/daijishou/dialog_fragments/LoggerDialogFragment$onCreateDialog$dialog$1", "Landroid/app/Dialog;", "onBackPressed", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LoggerDialogFragment$onCreateDialog$dialog$1 extends Dialog {
    final /* synthetic */ LoggerDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoggerDialogFragment$onCreateDialog$dialog$1(LoggerDialogFragment loggerDialogFragment, FragmentActivity fragmentActivity, int i) {
        super(fragmentActivity, i);
        this.this$0 = loggerDialogFragment;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0027  */
    /* JADX WARN: Code duplicated, block: B:20:0x0045  */
    /* JADX WARN: Code duplicated, block: B:22:0x0053  */
    /* JADX WARN: Code duplicated, block: B:25:0x0064  */
    /* JADX WARN: Code duplicated, block: B:26:0x0068  */
    /* JADX WARN: Code duplicated, block: B:9:0x001f  */
    @Override // android.app.Dialog
    public void onBackPressed() {
        DaijishouRecyclerView daijishouRecyclerView;
        ConstraintLayout constraintLayout;
        DaijishouRecyclerView daijishouRecyclerView2;
        DaijishouRecyclerView daijishouRecyclerView3 = null;
        if (!this.this$0.scrollingOnBackPressed) {
            daijishouRecyclerView = this.this$0.recyclerView;
            if (daijishouRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView = null;
            }
            if (daijishouRecyclerView.computeVerticalScrollOffset() != 0) {
                this.this$0.scrollingOnBackPressed = true;
                constraintLayout = this.this$0.backButtonLayout;
                if (constraintLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backButtonLayout");
                    constraintLayout = null;
                }
                constraintLayout.requestFocus();
                daijishouRecyclerView2 = this.this$0.recyclerView;
                if (daijishouRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    daijishouRecyclerView3 = daijishouRecyclerView2;
                }
                daijishouRecyclerView3.smoothScrollToPosition(0);
                return;
            }
        } else {
            DaijishouRecyclerView daijishouRecyclerView4 = this.this$0.recyclerView;
            if (daijishouRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView4 = null;
            }
            if (daijishouRecyclerView4.getScrollState() != 2) {
                daijishouRecyclerView = this.this$0.recyclerView;
                if (daijishouRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    daijishouRecyclerView = null;
                }
                if (daijishouRecyclerView.computeVerticalScrollOffset() != 0) {
                    this.this$0.scrollingOnBackPressed = true;
                    constraintLayout = this.this$0.backButtonLayout;
                    if (constraintLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("backButtonLayout");
                        constraintLayout = null;
                    }
                    constraintLayout.requestFocus();
                    daijishouRecyclerView2 = this.this$0.recyclerView;
                    if (daijishouRecyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    } else {
                        daijishouRecyclerView3 = daijishouRecyclerView2;
                    }
                    daijishouRecyclerView3.smoothScrollToPosition(0);
                    return;
                }
            }
        }
        DaijishouRecyclerView daijishouRecyclerView5 = this.this$0.recyclerView;
        if (daijishouRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            daijishouRecyclerView3 = daijishouRecyclerView5;
        }
        daijishouRecyclerView3.scrollToPosition(0);
        super.onBackPressed();
    }
}

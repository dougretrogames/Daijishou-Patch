package com.magneticchen.daijishou.dialog_fragments;

import android.content.Context;
import android.widget.Toast;
import com.magneticchen.daijishou.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: EditPlatformDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "succeed", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class EditPlatformDialogFragment$importXMLFileFromUriActivity$1$1$1 extends Lambda<Unit> implements Function1<Boolean, Unit> {
    final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
    final /* synthetic */ EditPlatformDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditPlatformDialogFragment$importXMLFileFromUriActivity$1$1$1(EditPlatformDialogFragment editPlatformDialogFragment, ProgressDialogFragment progressDialogFragment) {
        super(1);
        this.this$0 = editPlatformDialogFragment;
        this.$progressDialogFragment = progressDialogFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        EditPlatformDialogFragment editPlatformDialogFragment;
        int i;
        Context contextRequireContext = this.this$0.requireContext();
        if (z) {
            editPlatformDialogFragment = this.this$0;
            i = R.string.added_successfully;
        } else {
            editPlatformDialogFragment = this.this$0;
            i = R.string.not_imported;
        }
        Toast.makeText(contextRequireContext, editPlatformDialogFragment.getString(i), 0).show();
        this.$progressDialogFragment.dismiss();
    }
}

package com.magneticchen.daijishou.dialog_fragments;

import android.content.Context;
import android.widget.Toast;
import com.magneticchen.daijishou.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: EditPlatformDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class EditPlatformDialogFragment$onCreateDialog$1$1$20$1$1$confirmAction$2 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ EditPlatformDialogFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditPlatformDialogFragment$onCreateDialog$1$1$20$1$1$confirmAction$2(Context context, EditPlatformDialogFragment editPlatformDialogFragment) {
        super(0);
        this.$context = context;
        this.this$0 = editPlatformDialogFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Toast.makeText(this.$context, this.this$0.getString(R.string.canceled_period), 0).show();
    }
}

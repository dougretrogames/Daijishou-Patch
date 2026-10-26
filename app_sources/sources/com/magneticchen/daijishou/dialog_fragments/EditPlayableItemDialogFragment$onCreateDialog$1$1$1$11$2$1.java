package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: EditPlayableItemDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class EditPlayableItemDialogFragment$onCreateDialog$1$1$1$11$2$1 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ AlertDialog $dialog;
    final /* synthetic */ PlayableItemEntity $playableItemEntity;
    final /* synthetic */ EditPlayableItemDialogFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditPlayableItemDialogFragment$onCreateDialog$1$1$1$11$2$1(EditPlayableItemDialogFragment editPlayableItemDialogFragment, PlayableItemEntity playableItemEntity, AlertDialog alertDialog, Context context) {
        super(0);
        this.this$0 = editPlayableItemDialogFragment;
        this.$playableItemEntity = playableItemEntity;
        this.$dialog = alertDialog;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.getDaijishouLibrary().removePlayableItem(this.$playableItemEntity);
        this.$dialog.dismiss();
        Toast.makeText(this.$context, this.this$0.getString(R.string.deleted_successfully), 0).show();
    }
}

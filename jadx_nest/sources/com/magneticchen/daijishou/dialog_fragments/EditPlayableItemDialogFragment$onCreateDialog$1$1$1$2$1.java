package com.magneticchen.daijishou.dialog_fragments;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: EditPlayableItemDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class EditPlayableItemDialogFragment$onCreateDialog$1$1$1$2$1 extends Lambda<Unit> implements Function1<Integer, Unit> {
    final /* synthetic */ ListSelectDialogFragment $dialog;
    final /* synthetic */ EditPlayableItemDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditPlayableItemDialogFragment$onCreateDialog$1$1$1$2$1(ListSelectDialogFragment listSelectDialogFragment, EditPlayableItemDialogFragment editPlayableItemDialogFragment) {
        super(1);
        this.$dialog = listSelectDialogFragment;
        this.this$0 = editPlayableItemDialogFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        try {
                invoke(num.intValue());
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        this.$dialog.dismiss();
        if (i == 0) {
            this.this$0.setBoxArtActivity.launch("image/*");
        } else if (i == 1) {
            this.this$0.setSnapshotActivity.launch("image/*");
        } else {
            if (i != 2) {
                return;
            }
            this.this$0.setTitleActivity.launch("image/*");
        }
    }
}

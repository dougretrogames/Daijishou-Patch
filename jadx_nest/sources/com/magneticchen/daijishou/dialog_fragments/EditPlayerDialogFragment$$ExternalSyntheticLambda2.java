package com.magneticchen.daijishou.dialog_fragments;

import android.content.DialogInterface;
import com.magneticchen.daijishou.daijishou_library_db.PlayerEntity;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlayerDialogFragment$$ExternalSyntheticLambda2 implements DialogInterface.OnClickListener {
    public final /* synthetic */ EditPlayerDialogFragment f$0;
    public final /* synthetic */ PlayerEntity f$1;

    public /* synthetic */ EditPlayerDialogFragment$$ExternalSyntheticLambda2(EditPlayerDialogFragment editPlayerDialogFragment, PlayerEntity playerEntity) {
        this.f$0 = editPlayerDialogFragment;
        this.f$1 = playerEntity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            EditPlayerDialogFragment.onCreateDialog$lambda$5$lambda$2(this.f$0, this.f$1, dialogInterface, i);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

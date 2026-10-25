package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlayableItemDialogFragment$$ExternalSyntheticLambda6 implements View.OnClickListener {
    public final /* synthetic */ PlayableItemEntity f$0;
    public final /* synthetic */ EditPlayableItemDialogFragment f$1;
    public final /* synthetic */ AlertDialog f$2;
    public final /* synthetic */ Context f$3;
    public final /* synthetic */ Button f$4;

    public /* synthetic */ EditPlayableItemDialogFragment$$ExternalSyntheticLambda6(PlayableItemEntity playableItemEntity, EditPlayableItemDialogFragment editPlayableItemDialogFragment, AlertDialog alertDialog, Context context, Button button) {
        this.f$0 = playableItemEntity;
        this.f$1 = editPlayableItemDialogFragment;
        this.f$2 = alertDialog;
        this.f$3 = context;
        this.f$4 = button;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditPlayableItemDialogFragment.onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$22$lambda$21(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlatformDialogFragment$$ExternalSyntheticLambda15 implements View.OnClickListener {
    public final /* synthetic */ PlatformEntity f$0;
    public final /* synthetic */ EditPlatformDialogFragment f$1;
    public final /* synthetic */ Context f$2;
    public final /* synthetic */ AlertDialog f$3;

    public /* synthetic */ EditPlatformDialogFragment$$ExternalSyntheticLambda15(PlatformEntity platformEntity, EditPlatformDialogFragment editPlatformDialogFragment, Context context, AlertDialog alertDialog) {
        this.f$0 = platformEntity;
        this.f$1 = editPlatformDialogFragment;
        this.f$2 = context;
        this.f$3 = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$44(this.f$0, this.f$1, this.f$2, this.f$3, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

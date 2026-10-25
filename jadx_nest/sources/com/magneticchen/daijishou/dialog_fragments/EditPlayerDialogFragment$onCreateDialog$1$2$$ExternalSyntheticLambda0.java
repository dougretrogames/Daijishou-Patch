package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlayerDialogFragment$onCreateDialog$1$2$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ PlatformEntity f$0;
    public final /* synthetic */ EditPlayerDialogFragment f$1;

    public /* synthetic */ EditPlayerDialogFragment$onCreateDialog$1$2$$ExternalSyntheticLambda0(PlatformEntity platformEntity, EditPlayerDialogFragment editPlayerDialogFragment) {
        this.f$0 = platformEntity;
        this.f$1 = editPlayerDialogFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditPlayerDialogFragment$onCreateDialog$1$2.invoke$lambda$1$lambda$0(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

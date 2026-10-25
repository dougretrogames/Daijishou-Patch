package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlatformDialogFragment$$ExternalSyntheticLambda11 implements View.OnClickListener {
    public final /* synthetic */ EditPlatformDialogFragment f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ EditPlatformDialogFragment$$ExternalSyntheticLambda11(EditPlatformDialogFragment editPlatformDialogFragment, long j) {
        this.f$0 = editPlatformDialogFragment;
        this.f$1 = j;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$addPlayer$lambda$23(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import com.google.android.material.chip.ChipGroup;
import java.util.List;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlatformDialogFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ ChipGroup f$3;
    public final /* synthetic */ EditPlatformDialogFragment f$4;

    public /* synthetic */ EditPlatformDialogFragment$$ExternalSyntheticLambda0(List list, long j, String str, ChipGroup chipGroup, EditPlatformDialogFragment editPlatformDialogFragment) {
        this.f$0 = list;
        this.f$1 = j;
        this.f$2 = str;
        this.f$3 = chipGroup;
        this.f$4 = editPlatformDialogFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$addPlayer$lambda$22(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

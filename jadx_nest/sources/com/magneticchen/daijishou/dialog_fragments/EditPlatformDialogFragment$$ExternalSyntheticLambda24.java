package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import com.google.android.material.chip.ChipGroup;
import java.util.List;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlatformDialogFragment$$ExternalSyntheticLambda24 implements View.OnClickListener {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ ChipGroup f$2;

    public /* synthetic */ EditPlatformDialogFragment$$ExternalSyntheticLambda24(List list, long j, ChipGroup chipGroup) {
        this.f$0 = list;
        this.f$1 = j;
        this.f$2 = chipGroup;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$addRetroAchievementsConsoleId$lambda$18(this.f$0, this.f$1, this.f$2, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

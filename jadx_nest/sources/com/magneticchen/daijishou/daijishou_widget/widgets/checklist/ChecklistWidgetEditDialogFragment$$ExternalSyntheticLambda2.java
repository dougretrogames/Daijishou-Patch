package com.magneticchen.daijishou.daijishou_widget.widgets.checklist;

import android.content.DialogInterface;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class ChecklistWidgetEditDialogFragment$$ExternalSyntheticLambda2 implements DialogInterface.OnClickListener {
    public final /* synthetic */ ChecklistWidgetEditDialogFragment f$0;

    public /* synthetic */ ChecklistWidgetEditDialogFragment$$ExternalSyntheticLambda2(ChecklistWidgetEditDialogFragment checklistWidgetEditDialogFragment) {
        this.f$0 = checklistWidgetEditDialogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            ChecklistWidgetEditDialogFragment.onCreateDialog$lambda$1(this.f$0, dialogInterface, i);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

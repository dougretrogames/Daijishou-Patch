package com.magneticchen.daijishou.daijishou_widget.widgets.checklist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.android.material.textfield.TextInputEditText;
import com.magneticchen.daijishou.daijishou_widget.widget_db.ChecklistWidgetInstanceEntity;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class ChecklistWidgetEditDialogFragment$$ExternalSyntheticLambda3 implements DialogInterface.OnShowListener {
    public final /* synthetic */ AlertDialog f$0;
    public final /* synthetic */ ChecklistWidgetInstanceEntity f$1;
    public final /* synthetic */ TextInputEditText f$2;
    public final /* synthetic */ ChecklistWidgetEditDialogFragment f$3;

    public /* synthetic */ ChecklistWidgetEditDialogFragment$$ExternalSyntheticLambda3(AlertDialog alertDialog, ChecklistWidgetInstanceEntity checklistWidgetInstanceEntity, TextInputEditText textInputEditText, ChecklistWidgetEditDialogFragment checklistWidgetEditDialogFragment) {
        this.f$0 = alertDialog;
        this.f$1 = checklistWidgetInstanceEntity;
        this.f$2 = textInputEditText;
        this.f$3 = checklistWidgetEditDialogFragment;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            ChecklistWidgetEditDialogFragment.onCreateDialog$lambda$3(this.f$0, this.f$1, this.f$2, this.f$3, dialogInterface);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

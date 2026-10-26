package com.magneticchen.daijishou.daijishou_widget.widgets.checklist;

import android.app.AlertDialog;
import android.view.View;
import com.google.android.material.textfield.TextInputEditText;
import com.magneticchen.daijishou.daijishou_widget.widget_db.ChecklistWidgetInstanceEntity;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class ChecklistWidgetEditDialogFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ ChecklistWidgetInstanceEntity f$0;
    public final /* synthetic */ TextInputEditText f$1;
    public final /* synthetic */ ChecklistWidgetEditDialogFragment f$2;
    public final /* synthetic */ AlertDialog f$3;

    public /* synthetic */ ChecklistWidgetEditDialogFragment$$ExternalSyntheticLambda0(ChecklistWidgetInstanceEntity checklistWidgetInstanceEntity, TextInputEditText textInputEditText, ChecklistWidgetEditDialogFragment checklistWidgetEditDialogFragment, AlertDialog alertDialog) {
        this.f$0 = checklistWidgetInstanceEntity;
        this.f$1 = textInputEditText;
        this.f$2 = checklistWidgetEditDialogFragment;
        this.f$3 = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            ChecklistWidgetEditDialogFragment.onCreateDialog$lambda$3$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

package com.magneticchen.daijishou.daijishou_widget.widgets.rss;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.android.material.textfield.TextInputEditText;
import com.magneticchen.daijishou.daijishou_widget.widget_db.RSSWidgetInstanceEntity;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class RSSWidgetEditDialogFragment$$ExternalSyntheticLambda2 implements DialogInterface.OnShowListener {
    public final /* synthetic */ AlertDialog f$0;
    public final /* synthetic */ TextInputEditText f$1;
    public final /* synthetic */ RSSWidgetInstanceEntity f$2;
    public final /* synthetic */ RSSWidgetEditDialogFragment f$3;

    public /* synthetic */ RSSWidgetEditDialogFragment$$ExternalSyntheticLambda2(AlertDialog alertDialog, TextInputEditText textInputEditText, RSSWidgetInstanceEntity rSSWidgetInstanceEntity, RSSWidgetEditDialogFragment rSSWidgetEditDialogFragment) {
        this.f$0 = alertDialog;
        this.f$1 = textInputEditText;
        this.f$2 = rSSWidgetInstanceEntity;
        this.f$3 = rSSWidgetEditDialogFragment;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            RSSWidgetEditDialogFragment.onCreateDialog$lambda$3(this.f$0, this.f$1, this.f$2, this.f$3, dialogInterface);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

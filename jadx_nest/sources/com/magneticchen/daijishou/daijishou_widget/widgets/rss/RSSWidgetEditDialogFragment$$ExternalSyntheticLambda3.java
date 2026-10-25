package com.magneticchen.daijishou.daijishou_widget.widgets.rss;

import android.app.AlertDialog;
import android.view.View;
import com.google.android.material.textfield.TextInputEditText;
import com.magneticchen.daijishou.daijishou_widget.widget_db.RSSWidgetInstanceEntity;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RSSWidgetEditDialogFragment$$ExternalSyntheticLambda3 implements View.OnClickListener {
    public final /* synthetic */ TextInputEditText f$0;
    public final /* synthetic */ RSSWidgetInstanceEntity f$1;
    public final /* synthetic */ RSSWidgetEditDialogFragment f$2;
    public final /* synthetic */ AlertDialog f$3;

    public /* synthetic */ RSSWidgetEditDialogFragment$$ExternalSyntheticLambda3(TextInputEditText textInputEditText, RSSWidgetInstanceEntity rSSWidgetInstanceEntity, RSSWidgetEditDialogFragment rSSWidgetEditDialogFragment, AlertDialog alertDialog) {
        this.f$0 = textInputEditText;
        this.f$1 = rSSWidgetInstanceEntity;
        this.f$2 = rSSWidgetEditDialogFragment;
        this.f$3 = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            RSSWidgetEditDialogFragment.onCreateDialog$lambda$3$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

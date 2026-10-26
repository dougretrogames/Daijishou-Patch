package com.magneticchen.daijishou.daijishou_widget.widgets.rss;

import android.content.DialogInterface;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class RSSWidgetEditDialogFragment$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ RSSWidgetEditDialogFragment f$0;

    public /* synthetic */ RSSWidgetEditDialogFragment$$ExternalSyntheticLambda1(RSSWidgetEditDialogFragment rSSWidgetEditDialogFragment) {
        this.f$0 = rSSWidgetEditDialogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            RSSWidgetEditDialogFragment.onCreateDialog$lambda$1(this.f$0, dialogInterface, i);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

package com.magneticchen.daijishou.dialog_fragments;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import java.util.List;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class LoggerDialogFragment$$ExternalSyntheticLambda1 implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ LoggerDialogFragment f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ LoggerDialogFragment.SearchRecyclerViewAdapter f$2;

    public /* synthetic */ LoggerDialogFragment$$ExternalSyntheticLambda1(LoggerDialogFragment loggerDialogFragment, List list, LoggerDialogFragment.SearchRecyclerViewAdapter searchRecyclerViewAdapter) {
        this.f$0 = loggerDialogFragment;
        this.f$1 = list;
        this.f$2 = searchRecyclerViewAdapter;
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return LoggerDialogFragment.onCreateView$lambda$8(this.f$0, this.f$1, this.f$2, menuItem);
    }
}

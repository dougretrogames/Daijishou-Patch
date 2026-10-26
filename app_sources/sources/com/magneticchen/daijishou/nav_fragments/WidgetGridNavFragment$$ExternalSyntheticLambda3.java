package com.magneticchen.daijishou.nav_fragments;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import com.magneticchen.daijishou.daijishou_widget.WidgetsManager;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetInstance;
import com.magneticchen.daijishou.daijishou_widget.widget_recycler_view.WidgetFaceRecyclerViewAdapter;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class WidgetGridNavFragment$$ExternalSyntheticLambda3 implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ WidgetInstance f$0;
    public final /* synthetic */ WidgetGridNavFragment f$1;
    public final /* synthetic */ WidgetFaceRecyclerViewAdapter.WidgetViewHolder f$2;
    public final /* synthetic */ WidgetsManager f$3;

    public /* synthetic */ WidgetGridNavFragment$$ExternalSyntheticLambda3(WidgetInstance widgetInstance, WidgetGridNavFragment widgetGridNavFragment, WidgetFaceRecyclerViewAdapter.WidgetViewHolder widgetViewHolder, WidgetsManager widgetsManager) {
        this.f$0 = widgetInstance;
        this.f$1 = widgetGridNavFragment;
        this.f$2 = widgetViewHolder;
        this.f$3 = widgetsManager;
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return WidgetGridNavFragment.showOptionsForViewHolder$lambda$3(this.f$0, this.f$1, this.f$2, this.f$3, menuItem);
    }
}

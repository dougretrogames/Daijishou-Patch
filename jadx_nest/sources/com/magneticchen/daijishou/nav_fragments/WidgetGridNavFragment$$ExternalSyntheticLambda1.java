package com.magneticchen.daijishou.nav_fragments;

import android.content.Context;
import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class WidgetGridNavFragment$$ExternalSyntheticLambda1 implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ HashMap f$0;
    public final /* synthetic */ WidgetGridNavFragment f$1;
    public final /* synthetic */ FragmentActivity f$2;
    public final /* synthetic */ Context f$3;

    public /* synthetic */ WidgetGridNavFragment$$ExternalSyntheticLambda1(HashMap map, WidgetGridNavFragment widgetGridNavFragment, FragmentActivity fragmentActivity, Context context) {
        this.f$0 = map;
        this.f$1 = widgetGridNavFragment;
        this.f$2 = fragmentActivity;
        this.f$3 = context;
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return WidgetGridNavFragment.onCreateView$lambda$7(this.f$0, this.f$1, this.f$2, this.f$3, menuItem);
    }
}

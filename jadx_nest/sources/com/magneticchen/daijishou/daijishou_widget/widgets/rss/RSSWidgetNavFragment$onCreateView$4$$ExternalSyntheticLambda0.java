package com.magneticchen.daijishou.daijishou_widget.widgets.rss;

import android.view.View;
import com.magneticchen.daijishou.daijishou_widget.widget_db.RSSWidgetInstanceEntity;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RSSWidgetNavFragment$onCreateView$4$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ RSSWidgetNavFragment f$0;
    public final /* synthetic */ RSSWidgetInstanceEntity f$1;

    public /* synthetic */ RSSWidgetNavFragment$onCreateView$4$$ExternalSyntheticLambda0(RSSWidgetNavFragment rSSWidgetNavFragment, RSSWidgetInstanceEntity rSSWidgetInstanceEntity) {
        this.f$0 = rSSWidgetNavFragment;
        this.f$1 = rSSWidgetInstanceEntity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            RSSWidgetNavFragment.invoke$lambda$1$lambda$0(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

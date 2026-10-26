package com.magneticchen.daijishou.daijishou_widget.widget_recycler_view;

import kotlin.Metadata;

/* INFO: compiled from: WidgetFaceRecyclerViewAdapter.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/magneticchen/daijishou/daijishou_widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter$FragmentMaxLifecycleEnforcer$register$2", "Lcom/magneticchen/daijishou/daijishou_widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter$DataSetChangeObserver;", "onChanged", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetFaceRecyclerViewAdapter$FragmentMaxLifecycleEnforcer$register$2 extends WidgetFaceRecyclerViewAdapter.DataSetChangeObserver {
    final /* synthetic */ WidgetFaceRecyclerViewAdapter.FragmentMaxLifecycleEnforcer this$0;

    WidgetFaceRecyclerViewAdapter$FragmentMaxLifecycleEnforcer$register$2(WidgetFaceRecyclerViewAdapter.FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer) {
        this.this$0 = fragmentMaxLifecycleEnforcer;
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_recycler_view.WidgetFaceRecyclerViewAdapter.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        this.this$0.updateFragmentMaxLifecycle(true);
    }
}

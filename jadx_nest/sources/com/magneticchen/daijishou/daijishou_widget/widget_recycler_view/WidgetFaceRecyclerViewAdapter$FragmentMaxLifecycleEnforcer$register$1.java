package com.magneticchen.daijishou.daijishou_widget.widget_recycler_view;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WidgetFaceRecyclerViewAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/daijishou_widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter$FragmentMaxLifecycleEnforcer$register$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetFaceRecyclerViewAdapter$FragmentMaxLifecycleEnforcer$register$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ WidgetFaceRecyclerViewAdapter.FragmentMaxLifecycleEnforcer this$0;

    WidgetFaceRecyclerViewAdapter$FragmentMaxLifecycleEnforcer$register$1(WidgetFaceRecyclerViewAdapter.FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer) {
        this.this$0 = fragmentMaxLifecycleEnforcer;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == 0) {
            this.this$0.updateFragmentMaxLifecycle(false);
        }
    }
}

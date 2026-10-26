package com.magneticchen.daijishou.daijishou_widget.widget_recycler_view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class WidgetFaceRecyclerViewAdapter$FragmentMaxLifecycleEnforcer$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ WidgetFaceRecyclerViewAdapter.FragmentMaxLifecycleEnforcer f$0;

    public /* synthetic */ WidgetFaceRecyclerViewAdapter$FragmentMaxLifecycleEnforcer$$ExternalSyntheticLambda0(WidgetFaceRecyclerViewAdapter.FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer) {
        this.f$0 = fragmentMaxLifecycleEnforcer;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        try {
            WidgetFaceRecyclerViewAdapter.register$lambda$0(this.f$0, lifecycleOwner, event);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

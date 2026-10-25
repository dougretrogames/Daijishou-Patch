package com.magneticchen.daijishou.daijishou_widget.widget_recycler_view;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class WidgetFaceRecyclerViewAdapter$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ WidgetFaceRecyclerViewAdapter f$0;

    public /* synthetic */ WidgetFaceRecyclerViewAdapter$$ExternalSyntheticLambda0(WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter) {
        this.f$0 = widgetFaceRecyclerViewAdapter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            WidgetFaceRecyclerViewAdapter.scheduleGracePeriodEnd$lambda$0(this.f$0);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

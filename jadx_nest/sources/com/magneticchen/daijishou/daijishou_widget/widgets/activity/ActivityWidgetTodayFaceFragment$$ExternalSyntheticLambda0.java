package com.magneticchen.daijishou.daijishou_widget.widgets.activity;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ActivityWidgetTodayFaceFragment$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ActivityWidgetTodayFaceFragment f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ ActivityWidgetTodayFaceFragment$$ExternalSyntheticLambda0(ActivityWidgetTodayFaceFragment activityWidgetTodayFaceFragment, long j) {
        this.f$0 = activityWidgetTodayFaceFragment;
        this.f$1 = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            ActivityWidgetTodayFaceFragment.renewAndUpdateFace$lambda$0(this.f$0, this.f$1);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

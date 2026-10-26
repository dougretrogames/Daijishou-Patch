package com.magneticchen.daijishou.view_models;

import android.app.Activity;
import android.content.pm.ResolveInfo;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class AppsViewModel$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ResolveInfo f$0;
    public final /* synthetic */ Activity f$1;
    public final /* synthetic */ AppsViewModel f$2;

    public /* synthetic */ AppsViewModel$$ExternalSyntheticLambda0(ResolveInfo resolveInfo, Activity activity, AppsViewModel appsViewModel) {
        this.f$0 = resolveInfo;
        this.f$1 = activity;
        this.f$2 = appsViewModel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            AppsViewModel.launchAppByResolveInfo$lambda$7(this.f$0, this.f$1, this.f$2);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

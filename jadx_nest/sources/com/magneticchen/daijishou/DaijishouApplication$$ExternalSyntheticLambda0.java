package com.magneticchen.daijishou;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class DaijishouApplication$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ DaijishouApplication f$0;

    public /* synthetic */ DaijishouApplication$$ExternalSyntheticLambda0(DaijishouApplication daijishouApplication) {
        this.f$0 = daijishouApplication;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        try {
            DaijishouApplication.lifecycleEventObserver$lambda$2(this.f$0, lifecycleOwner, event);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

package com.magneticchen.daijishou.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda0 implements ActivityResultCallback {
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda0(MainActivity mainActivity) {
        this.f$0 = mainActivity;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        try {
            MainActivity.startForResult$lambda$0(this.f$0, (ActivityResult) obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

package com.magneticchen.daijishou.google_drive;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class GoogleDrive$$ExternalSyntheticLambda0 implements ActivityResultCallback {
    public final /* synthetic */ GoogleDrive f$0;

    public /* synthetic */ GoogleDrive$$ExternalSyntheticLambda0(GoogleDrive googleDrive) {
        this.f$0 = googleDrive;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        try {
            GoogleDrive.bindActivity$lambda$4(this.f$0, (ActivityResult) obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

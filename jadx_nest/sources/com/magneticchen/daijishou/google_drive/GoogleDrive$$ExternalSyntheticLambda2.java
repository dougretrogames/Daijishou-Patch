package com.magneticchen.daijishou.google_drive;

import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class GoogleDrive$$ExternalSyntheticLambda2 implements OnFailureListener {
    public final /* synthetic */ GoogleDrive f$0;

    public /* synthetic */ GoogleDrive$$ExternalSyntheticLambda2(GoogleDrive googleDrive) {
        this.f$0 = googleDrive;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        try {
            GoogleDrive.handleSignInIntent$lambda$37(this.f$0, exc);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

package com.magneticchen.daijishou.google_drive;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.jvm.functions.Function1;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class GoogleDrive$$ExternalSyntheticLambda1 implements OnSuccessListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ GoogleDrive$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        try {
            GoogleDrive.handleSignInIntent$lambda$36(this.f$0, obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

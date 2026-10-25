package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SynchronizationStatusDialogFragment$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ SynchronizationStatusDialogFragment f$0;
    public final /* synthetic */ FragmentActivity f$1;

    public /* synthetic */ SynchronizationStatusDialogFragment$$ExternalSyntheticLambda2(SynchronizationStatusDialogFragment synchronizationStatusDialogFragment, FragmentActivity fragmentActivity) {
        this.f$0 = synchronizationStatusDialogFragment;
        this.f$1 = fragmentActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            SynchronizationStatusDialogFragment.onCreateView$lambda$1(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

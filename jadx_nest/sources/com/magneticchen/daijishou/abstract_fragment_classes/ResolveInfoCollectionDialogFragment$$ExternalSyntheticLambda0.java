package com.magneticchen.daijishou.abstract_fragment_classes;

import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ResolveInfoCollectionDialogFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ ResolveInfoCollectionDialogFragment f$0;

    public /* synthetic */ ResolveInfoCollectionDialogFragment$$ExternalSyntheticLambda0(ResolveInfoCollectionDialogFragment resolveInfoCollectionDialogFragment) {
        this.f$0 = resolveInfoCollectionDialogFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            ResolveInfoCollectionDialogFragment.onCreateView$lambda$0(this.f$0, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

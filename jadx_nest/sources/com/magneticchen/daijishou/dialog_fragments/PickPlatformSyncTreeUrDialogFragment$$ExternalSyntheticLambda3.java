package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda3 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ PickPlatformSyncTreeUrDialogFragment f$0;

    public /* synthetic */ PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda3(PickPlatformSyncTreeUrDialogFragment pickPlatformSyncTreeUrDialogFragment) {
        this.f$0 = pickPlatformSyncTreeUrDialogFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        try {
            PickPlatformSyncTreeUrDialogFragment.onCreateDialog$lambda$11$lambda$10$lambda$2(this.f$0, adapterView, view, i, j);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

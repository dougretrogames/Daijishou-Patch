package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import com.google.android.material.textfield.TextInputEditText;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SearchPlayableItemDialogFragment$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ TextInputEditText f$0;

    public /* synthetic */ SearchPlayableItemDialogFragment$$ExternalSyntheticLambda1(TextInputEditText textInputEditText) {
        this.f$0 = textInputEditText;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            SearchPlayableItemDialogFragment.onCreateView$lambda$1(this.f$0, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

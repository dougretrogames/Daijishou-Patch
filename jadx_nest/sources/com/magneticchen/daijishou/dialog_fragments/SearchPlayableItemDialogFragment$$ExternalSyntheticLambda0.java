package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class SearchPlayableItemDialogFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ SearchPlayableItemDialogFragment f$0;

    public /* synthetic */ SearchPlayableItemDialogFragment$$ExternalSyntheticLambda0(SearchPlayableItemDialogFragment searchPlayableItemDialogFragment) {
        this.f$0 = searchPlayableItemDialogFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            SearchPlayableItemDialogFragment.onCreateView$lambda$0(this.f$0, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

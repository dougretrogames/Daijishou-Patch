package com.magneticchen.daijishou.abstract_fragment_classes;

import android.view.View;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class PlayableItemCollectionDialogFragment$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ PlayableItemCollectionDialogFragment f$0;

    public /* synthetic */ PlayableItemCollectionDialogFragment$$ExternalSyntheticLambda2(PlayableItemCollectionDialogFragment playableItemCollectionDialogFragment) {
        this.f$0 = playableItemCollectionDialogFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            PlayableItemCollectionDialogFragment.onCreateView$lambda$11(this.f$0, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

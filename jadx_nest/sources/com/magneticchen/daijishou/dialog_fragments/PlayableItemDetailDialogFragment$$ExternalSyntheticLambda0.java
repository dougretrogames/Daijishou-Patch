package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class PlayableItemDetailDialogFragment$$ExternalSyntheticLambda0 implements View.OnScrollChangeListener {
    public final /* synthetic */ PlayableItemDetailDialogFragment f$0;

    public /* synthetic */ PlayableItemDetailDialogFragment$$ExternalSyntheticLambda0(PlayableItemDetailDialogFragment playableItemDetailDialogFragment) {
        this.f$0 = playableItemDetailDialogFragment;
    }

    @Override // android.view.View.OnScrollChangeListener
    public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
        try {
            PlayableItemDetailDialogFragment.onCreateView$lambda$5(this.f$0, view, i, i2, i3, i4);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

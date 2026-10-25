package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class PlayableItemDetailDialogFragment$$ExternalSyntheticLambda15 implements View.OnClickListener {
    public final /* synthetic */ PlayableItemDetailDialogFragment f$0;

    public /* synthetic */ PlayableItemDetailDialogFragment$$ExternalSyntheticLambda15(PlayableItemDetailDialogFragment playableItemDetailDialogFragment) {
        this.f$0 = playableItemDetailDialogFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            PlayableItemDetailDialogFragment.onCreateView$lambda$23(this.f$0, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class PlayableItemDetailDialogFragment$$ExternalSyntheticLambda7 implements View.OnClickListener {
    public final /* synthetic */ PlayableItemDetailDialogFragment f$0;
    public final /* synthetic */ FragmentActivity f$1;

    public /* synthetic */ PlayableItemDetailDialogFragment$$ExternalSyntheticLambda7(PlayableItemDetailDialogFragment playableItemDetailDialogFragment, FragmentActivity fragmentActivity) {
        this.f$0 = playableItemDetailDialogFragment;
        this.f$1 = fragmentActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            PlayableItemDetailDialogFragment.onCreateView$lambda$14(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

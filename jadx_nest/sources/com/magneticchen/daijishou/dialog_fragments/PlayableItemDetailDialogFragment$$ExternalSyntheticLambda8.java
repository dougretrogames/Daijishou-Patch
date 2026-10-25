package com.magneticchen.daijishou.dialog_fragments;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class PlayableItemDetailDialogFragment$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ PlayableItemDetailDialogFragment f$0;

    public /* synthetic */ PlayableItemDetailDialogFragment$$ExternalSyntheticLambda8(PlayableItemDetailDialogFragment playableItemDetailDialogFragment) {
        this.f$0 = playableItemDetailDialogFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            PlayableItemDetailDialogFragment.onViewCreated$lambda$26(this.f$0);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda11 implements View.OnClickListener {
    public final /* synthetic */ Ref.ObjectRef f$0;
    public final /* synthetic */ RetroAchievementsGameDialogFragment f$1;

    public /* synthetic */ RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda11(Ref.ObjectRef objectRef, RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment) {
        this.f$0 = objectRef;
        this.f$1 = retroAchievementsGameDialogFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            RetroAchievementsGameDialogFragment.onCreateView$lambda$24(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

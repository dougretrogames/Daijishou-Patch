package com.google.android.material.search;

import android.animation.Animator;
import com.google.android.material.animation.AnimatableView;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SearchBarAnimationHelper$$ExternalSyntheticLambda2 implements AnimatableView.Listener {
    public final /* synthetic */ Animator f$0;

    public /* synthetic */ SearchBarAnimationHelper$$ExternalSyntheticLambda2(Animator animator) {
        this.f$0 = animator;
    }

    @Override // com.google.android.material.animation.AnimatableView.Listener
    public final void onAnimationEnd() {
        this.f$0.start();
    }
}

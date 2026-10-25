package com.magneticchen.daijishou.settings_nav_fragments;

import android.view.View;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AboutThisAppNavFragment$$ExternalSyntheticLambda3 implements View.OnClickListener {
    public final /* synthetic */ AboutThisAppNavFragment f$0;
    public final /* synthetic */ Ref.ObjectRef f$1;

    public /* synthetic */ AboutThisAppNavFragment$$ExternalSyntheticLambda3(AboutThisAppNavFragment aboutThisAppNavFragment, Ref.ObjectRef objectRef) {
        this.f$0 = aboutThisAppNavFragment;
        this.f$1 = objectRef;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            AboutThisAppNavFragment.onCreateView$lambda$3(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}

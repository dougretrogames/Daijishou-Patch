package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class MenuHostHelper$$ExternalSyntheticLambda1 implements LifecycleEventObserver {
    public final /* synthetic */ MenuHostHelper f$0;
    public final /* synthetic */ MenuProvider f$1;

    public /* synthetic */ MenuHostHelper$$ExternalSyntheticLambda1(MenuHostHelper menuHostHelper, MenuProvider menuProvider) {
        this.f$0 = menuHostHelper;
        this.f$1 = menuProvider;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f$0.m3169lambda$addMenuProvider$0$androidxcoreviewMenuHostHelper(this.f$1, lifecycleOwner, event);
    }
}

package androidx.navigation.fragment;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class FragmentNavigator$fragmentViewObserver$1$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ FragmentNavigator f$0;
    public final /* synthetic */ NavBackStackEntry f$1;

    public /* synthetic */ FragmentNavigator$fragmentViewObserver$1$$ExternalSyntheticLambda0(FragmentNavigator fragmentNavigator, NavBackStackEntry navBackStackEntry) {
        this.f$0 = fragmentNavigator;
        this.f$1 = navBackStackEntry;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        FragmentNavigator$fragmentViewObserver$1.invoke$lambda$0(this.f$0, this.f$1, lifecycleOwner, event);
    }
}

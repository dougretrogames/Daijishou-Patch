package com.magneticchen.daijishou.abstract_fragment_classes;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.FragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackStackViewPagerFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/magneticchen/daijishou/abstract_fragment_classes/BackStackViewPagerFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/ViewPagerFragment;", "()V", "navFragmentContainerId", "", "getNavFragmentContainerId", "()I", "onBackPressed", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BackStackViewPagerFragment extends ViewPagerFragment {
    public abstract int getNavFragmentContainerId();

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onBackPressed() {
        super.onBackPressed();
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(getNavFragmentContainerId());
        Intrinsics.checkNotNull(fragmentFindFragmentById);
        NavController navControllerFindNavController = FragmentKt.findNavController(fragmentFindFragmentById);
        Intrinsics.checkNotNull(navControllerFindNavController.getCurrentDestination());
        if (navControllerFindNavController.getCurrentDestination() == null) {
            return true;
        }
        NavDestination currentDestination = navControllerFindNavController.getCurrentDestination();
        Intrinsics.checkNotNull(currentDestination);
        if (currentDestination.getId() == navControllerFindNavController.getGraph().getStartDestinationId()) {
            return true;
        }
        navControllerFindNavController.navigateUp();
        return false;
    }
}

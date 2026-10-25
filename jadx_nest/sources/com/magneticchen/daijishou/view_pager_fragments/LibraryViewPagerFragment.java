package com.magneticchen.daijishou.view_pager_fragments;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.FragmentKt;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.BackStackViewPagerFragment;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment;
import com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerType;
import com.magneticchen.daijishou.view_models.LibraryViewModel;
import com.magneticchen.daijishou.view_pager_selected_parameters.LibraryPageSelectedParameters;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: LibraryViewPagerFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000 12\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\fH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J \u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020,H\u0016J\b\u00100\u001a\u00020,H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/magneticchen/daijishou/view_pager_fragments/LibraryViewPagerFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/BackStackViewPagerFragment;", "()V", "destinationChangedListener", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "displayNameStringId", "", "getDisplayNameStringId", "()I", "setDisplayNameStringId", "(I)V", "fullscreen", "", "getFullscreen", "()Z", "id", "", "getId", "()Ljava/lang/String;", "libraryViewModel", "Lcom/magneticchen/daijishou/view_models/LibraryViewModel;", "getLibraryViewModel", "()Lcom/magneticchen/daijishou/view_models/LibraryViewModel;", "libraryViewModel$delegate", "Lkotlin/Lazy;", "navFragmentContainerId", "getNavFragmentContainerId", "navHostFragment", "Landroidx/fragment/app/Fragment;", "onBackPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onHotKeyPressed", "hotkeyCode", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onPageSelected", "", "pageSelectedParameters", "", "onPause", "onResume", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class LibraryViewPagerFragment extends BackStackViewPagerFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private NavController.OnDestinationChangedListener destinationChangedListener;
    private boolean fullscreen = false;

    /* JADX INFO: renamed from: libraryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy libraryViewModel;
    private Fragment navHostFragment;
    private final String id = ViewPagerType.LIBRARY.getId();
    private int displayNameStringId = R.string.library_page;
    private final int navFragmentContainerId = R.id.library_nav_container;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$3(NavController controller, NavDestination destination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(destination, "destination");
    }

    public LibraryViewPagerFragment() {
        LibraryViewPagerFragment libraryViewPagerFragment = this;
        this.libraryViewModel = FragmentViewModelLazyKt.createViewModelLazy(libraryViewPagerFragment, Reflection.getOrCreateKotlinClass(LibraryViewModel.class), new LibraryViewPagerFragment$special$$inlined$activityViewModels$default$1(libraryViewPagerFragment), new LibraryViewPagerFragment$special$$inlined$activityViewModels$default$2(null, libraryViewPagerFragment), new LibraryViewPagerFragment$special$$inlined$activityViewModels$default$3(libraryViewPagerFragment));
    }

    /* JADX INFO: compiled from: LibraryViewPagerFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/view_pager_fragments/LibraryViewPagerFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/view_pager_fragments/LibraryViewPagerFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LibraryViewPagerFragment newInstance() {
            return new LibraryViewPagerFragment();
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public String getStringId() {
        return this.id;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public int getDisplayNameStringId() {
        return this.displayNameStringId;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public void setDisplayNameStringId(int i) {
        this.displayNameStringId = i;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public boolean getFullscreen() {
        return this.fullscreen;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.BackStackViewPagerFragment
    public int getNavFragmentContainerId() {
        return this.navFragmentContainerId;
    }

    private final LibraryViewModel getLibraryViewModel() {
        return (LibraryViewModel) this.libraryViewModel.getValue();
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public void onPageSelected(Object pageSelectedParameters) {
        Fragment fragment;
        NavController navControllerFindNavController;
        super.onPageSelected(pageSelectedParameters);
        if (pageSelectedParameters == null || (fragment = this.navHostFragment) == null || (navControllerFindNavController = FragmentKt.findNavController(fragment)) == null) {
            return;
        }
        LibraryPageSelectedParameters libraryPageSelectedParameters = (LibraryPageSelectedParameters) pageSelectedParameters;
        NavDestination currentDestination = navControllerFindNavController.getCurrentDestination();
        Integer numValueOf = currentDestination != null ? Integer.valueOf(currentDestination.getId()) : null;
        if (libraryPageSelectedParameters.getFilterMode() == -1) {
            if (libraryPageSelectedParameters.getPlatformId() == -1 || libraryPageSelectedParameters.getPlatformId() == getLibraryViewModel().getSelectedPlatformId()) {
                return;
            }
            getLibraryViewModel().setSelectedPlatformId(libraryPageSelectedParameters.getPlatformId());
            return;
        }
        if (libraryPageSelectedParameters.getPlatformId() != -1 && libraryPageSelectedParameters.getPlatformId() != getLibraryViewModel().getSelectedPlatformId()) {
            getLibraryViewModel().setSelectedPlatformId(libraryPageSelectedParameters.getPlatformId());
        }
        Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("fromOnPageSelected", true), TuplesKt.to("filterMode", Integer.valueOf(libraryPageSelectedParameters.getFilterMode())));
        if (numValueOf != null && numValueOf.intValue() == R.id.libraryCollectionWallpaperViewNavFragment) {
            navControllerFindNavController.navigate(R.id.libraryCollectionWallpaperViewToPlatformLibraryGridViewAction, bundleBundleOf);
        } else if (numValueOf != null && numValueOf.intValue() == R.id.libraryCollectionThumbnailsViewNavFragment) {
            navControllerFindNavController.navigate(R.id.libraryCollectionThumbnailsViewToPlatformLibraryGridViewAction, bundleBundleOf);
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.BackStackViewPagerFragment, com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onBackPressed() {
        Fragment fragment = this.navHostFragment;
        if (fragment != null) {
            Fragment primaryNavigationFragment = fragment.getChildFragmentManager().getPrimaryNavigationFragment();
            Intrinsics.checkNotNull(primaryNavigationFragment, "null cannot be cast to non-null type com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment");
            if (((DaijishouFragment) primaryNavigationFragment).onBackPressed()) {
                return super.onBackPressed();
            }
            return false;
        }
        return super.onBackPressed();
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onHotKeyPressed(int hotkeyCode, int keyCode, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(hotkeyCode, keyCode, keyEvent);
        Fragment fragment = this.navHostFragment;
        if (fragment == null) {
            return false;
        }
        Fragment primaryNavigationFragment = fragment.getChildFragmentManager().getPrimaryNavigationFragment();
        Intrinsics.checkNotNull(primaryNavigationFragment, "null cannot be cast to non-null type com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment");
        return ((DaijishouFragment) primaryNavigationFragment).onHotKeyPressed(hotkeyCode, keyCode, keyEvent);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.view_pager_fragment_library, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(getNavFragmentContainerId());
        this.navHostFragment = fragmentFindFragmentById;
        Intrinsics.checkNotNull(fragmentFindFragmentById);
        NavController navControllerFindNavController = FragmentKt.findNavController(fragmentFindFragmentById);
        LibraryViewPagerFragment$$ExternalSyntheticLambda0 libraryViewPagerFragment$$ExternalSyntheticLambda0 = new LibraryViewPagerFragment$$ExternalSyntheticLambda0();
        this.destinationChangedListener = libraryViewPagerFragment$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNull(libraryViewPagerFragment$$ExternalSyntheticLambda0);
        navControllerFindNavController.addOnDestinationChangedListener(libraryViewPagerFragment$$ExternalSyntheticLambda0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        NavController.OnDestinationChangedListener onDestinationChangedListener = this.destinationChangedListener;
        if (onDestinationChangedListener != null) {
            Fragment fragment = this.navHostFragment;
            Intrinsics.checkNotNull(fragment);
            FragmentKt.findNavController(fragment).removeOnDestinationChangedListener(onDestinationChangedListener);
        }
    }
}

package com.magneticchen.daijishou.nav_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.FragmentKt;
import com.google.android.material.button.MaterialButton;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.PlatformNavFragment;
import com.magneticchen.daijishou.application_data.StringPreference;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.dialog_fragments.DownloadPlatformsDialogFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: PlatformEmptyNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/PlatformEmptyNavFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/PlatformNavFragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlatformEmptyNavFragment extends PlatformNavFragment {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* INFO: compiled from: PlatformEmptyNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/PlatformEmptyNavFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/nav_fragments/PlatformEmptyNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlatformEmptyNavFragment newInstance() {
            return new PlatformEmptyNavFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_library_collection_empty, container, false);
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.fragment_library_empty_button);
        NavController navControllerFindNavController = FragmentKt.findNavController(this);
        materialButton.setOnClickListener(new PlatformEmptyNavFragment$$ExternalSyntheticLambda0(this));
        navControllerFindNavController.getGraph().setStartDestination(R.id.platformEmptyNavFragment);
        getDaijishouLibrary().getAllVisiblePlatformsOrderedByShortName().observe(getViewLifecycleOwner(), new PlatformEmptyNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass2(navControllerFindNavController)));
        return viewInflate;
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(PlatformEmptyNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DownloadPlatformsDialogFragment.INSTANCE.newInstance().show(this$0.getChildFragmentManager(), "download_platforms");
    }

    /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformEmptyNavFragment$onCreateView$2, reason: invalid class name */
    /* INFO: compiled from: PlatformEmptyNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda<Unit> implements Function1<List<? extends PlatformEntity>, Unit> {
        final /* synthetic */ NavController $navController;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(NavController navController) {
            super(1);
            this.$navController = navController;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlatformEntity> list) {
            invoke2((List<PlatformEntity>) list);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<PlatformEntity> list) {
            Intrinsics.checkNotNull(list);
            if (list.isEmpty()) {
                return;
            }
            NavOptions navOptionsBuild = NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), R.id.platformEmptyNavFragment, true, false, 4, (Object) null).build();
            String string = PlatformEmptyNavFragment.this.getDefaultSharedPreferences().getString(StringPreference.LIBRARY_COLLECTION_VIEW_MODE.getKey(), StringPreference.LIBRARY_COLLECTION_VIEW_MODE.getDefaultValue());
            if (Intrinsics.areEqual(string, "0")) {
                this.$navController.getGraph().setStartDestination(R.id.libraryCollectionWallpaperViewNavFragment);
                NavDestination currentDestination = this.$navController.getCurrentDestination();
                if (currentDestination == null || currentDestination.getId() != R.id.platformEmptyNavFragment) {
                    return;
                }
                this.$navController.navigate(PlatformEmptyNavFragmentDirections.INSTANCE.platformEmptyToLibraryCollectionWallpaperViewAction(), navOptionsBuild);
                return;
            }
            if (Intrinsics.areEqual(string, "1")) {
                this.$navController.getGraph().setStartDestination(R.id.libraryCollectionThumbnailsViewNavFragment);
                NavDestination currentDestination2 = this.$navController.getCurrentDestination();
                if (currentDestination2 == null || currentDestination2.getId() != R.id.platformEmptyNavFragment) {
                    return;
                }
                this.$navController.navigate(PlatformEmptyNavFragmentDirections.INSTANCE.platformEmptyToLibraryCollectionThumbnailsViewAction(), navOptionsBuild);
                return;
            }
            this.$navController.getGraph().setStartDestination(R.id.libraryCollectionWebViewViewNavFragment);
            NavDestination currentDestination3 = this.$navController.getCurrentDestination();
            if (currentDestination3 == null || currentDestination3.getId() != R.id.platformEmptyNavFragment) {
                return;
            }
            this.$navController.navigate(PlatformEmptyNavFragmentDirections.INSTANCE.platformEmptyToLibraryCollectionWallpaperViewAction(), navOptionsBuild);
        }
    }
}

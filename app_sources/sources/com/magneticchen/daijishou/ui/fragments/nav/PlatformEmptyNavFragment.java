package com.magneticchen.daijishou.ui.fragments.nav;

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
import com.magneticchen.daijishou.data.StringPreference;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment;
import com.magneticchen.daijishou.ui.fragments.p000abstract.PlatformNavFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlatformEmptyNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/PlatformNavFragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlatformEmptyNavFragment extends PlatformNavFragment {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: PlatformEmptyNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_library_collection_empty, viewGroup, false);
        MaterialButton materialButtonFindViewById = viewInflate.findViewById(R.id.fragment_library_empty_button);
        final NavController navControllerFindNavController = FragmentKt.findNavController(this);
        materialButtonFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformEmptyNavFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlatformEmptyNavFragment.onCreateView$lambda$0(this.f$0, view);
            }
        });
        navControllerFindNavController.getGraph().setStartDestination(R.id.platformEmptyNavFragment);
        getDaijishouLibrary().getAllVisiblePlatformsOrderedByShortName().observe(getViewLifecycleOwner(), new PlatformEmptyNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends PlatformEntity>, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformEmptyNavFragment.onCreateView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlatformEntity> list) {
                invoke2((List<PlatformEntity>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<PlatformEntity> list) {
                Intrinsics.checkNotNull(list);
                if (list.isEmpty()) {
                    return;
                }
                NavOptions navOptionsBuild = NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), R.id.platformEmptyNavFragment, true, false, 4, (Object) null).build();
                String string = PlatformEmptyNavFragment.this.getDefaultSharedPreferences().getString(StringPreference.LIBRARY_COLLECTION_VIEW_MODE.getKey(), StringPreference.LIBRARY_COLLECTION_VIEW_MODE.getDefaultValue());
                if (Intrinsics.areEqual(string, "0")) {
                    navControllerFindNavController.getGraph().setStartDestination(R.id.libraryCollectionWallpaperViewNavFragment);
                    NavDestination currentDestination = navControllerFindNavController.getCurrentDestination();
                    if (currentDestination == null || currentDestination.getId() != 2131362614) {
                        return;
                    }
                    navControllerFindNavController.navigate(PlatformEmptyNavFragmentDirections.Companion.platformEmptyToLibraryCollectionWallpaperViewAction(), navOptionsBuild);
                    return;
                }
                if (Intrinsics.areEqual(string, "1")) {
                    navControllerFindNavController.getGraph().setStartDestination(R.id.libraryCollectionThumbnailsViewNavFragment);
                    NavDestination currentDestination2 = navControllerFindNavController.getCurrentDestination();
                    if (currentDestination2 == null || currentDestination2.getId() != 2131362614) {
                        return;
                    }
                    navControllerFindNavController.navigate(PlatformEmptyNavFragmentDirections.Companion.platformEmptyToLibraryCollectionThumbnailsViewAction(), navOptionsBuild);
                    return;
                }
                navControllerFindNavController.getGraph().setStartDestination(R.id.libraryCollectionWebViewViewNavFragment);
                NavDestination currentDestination3 = navControllerFindNavController.getCurrentDestination();
                if (currentDestination3 == null || currentDestination3.getId() != 2131362614) {
                    return;
                }
                navControllerFindNavController.navigate(PlatformEmptyNavFragmentDirections.Companion.platformEmptyToLibraryCollectionWallpaperViewAction(), navOptionsBuild);
            }
        }));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(PlatformEmptyNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DownloadPlatformsDialogFragment.Companion.newInstance().show(this$0.getChildFragmentManager(), "download_platforms");
    }
}

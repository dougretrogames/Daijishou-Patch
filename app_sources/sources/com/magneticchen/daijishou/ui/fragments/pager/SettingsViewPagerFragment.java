package com.magneticchen.daijishou.ui.fragments.pager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.NavHostFragment;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.ui.fragments.p000abstract.BackStackViewPagerFragment;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouPreferenceFragment;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouPreferenceFragmentCompat;
import com.magneticchen.daijishou.ui.fragments.p000abstract.ViewPagerType;
import com.magneticchen.daijishou.ui.fragments.settings.SettingsNavFragment;
import com.magneticchen.daijishou.ui.model.SettingsViewModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: SettingsViewPagerFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010)\u001a\u00020\u0010H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/pager/SettingsViewPagerFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/BackStackViewPagerFragment;", "()V", "displayNameStringId", "", "getDisplayNameStringId", "()I", "setDisplayNameStringId", "(I)V", "id", "", "getId", "()Ljava/lang/String;", "navFragmentContainerId", "getNavFragmentContainerId", "settingsNavFragment", "Lcom/magneticchen/daijishou/ui/fragments/settings/SettingsNavFragment;", "settingsViewModel", "Lcom/magneticchen/daijishou/ui/model/SettingsViewModel;", "getSettingsViewModel", "()Lcom/magneticchen/daijishou/ui/model/SettingsViewModel;", "settingsViewModel$delegate", "Lkotlin/Lazy;", "useDefaultWallpaper", "", "getUseDefaultWallpaper", "()Z", "setUseDefaultWallpaper", "(Z)V", "onBackPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "requireSettingsNavFragment", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SettingsViewPagerFragment extends BackStackViewPagerFragment {
    public static final Companion Companion = new Companion(null);
    private SettingsNavFragment settingsNavFragment;
    private final Lazy settingsViewModel$delegate;
    private boolean useDefaultWallpaper;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f51id = ViewPagerType.SETTINGS.getId();
    private int displayNameStringId = R.string.settings_page;
    private final int navFragmentContainerId = R.id.settings_nav_container;

    public SettingsViewPagerFragment() {
        final SettingsViewPagerFragment settingsViewPagerFragment = this;
        final Function0 function0 = null;
        this.settingsViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(settingsViewPagerFragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.SettingsViewPagerFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return settingsViewPagerFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.SettingsViewPagerFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? settingsViewPagerFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.SettingsViewPagerFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return settingsViewPagerFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.ViewPagerFragment
    public String getId() {
        return this.f51id;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.ViewPagerFragment
    public int getDisplayNameStringId() {
        return this.displayNameStringId;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.ViewPagerFragment
    public void setDisplayNameStringId(int i) {
        this.displayNameStringId = i;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.BackStackViewPagerFragment
    public int getNavFragmentContainerId() {
        return this.navFragmentContainerId;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.ViewPagerFragment
    public boolean getUseDefaultWallpaper() {
        return this.useDefaultWallpaper;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.ViewPagerFragment
    public void setUseDefaultWallpaper(boolean z) {
        this.useDefaultWallpaper = z;
    }

    private final SettingsViewModel getSettingsViewModel() {
        return (SettingsViewModel) this.settingsViewModel$delegate.getValue();
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.BackStackViewPagerFragment, com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public boolean onBackPressed() {
        NavHostFragment navHostFragmentFindFragmentById = getChildFragmentManager().findFragmentById(R.id.settings_nav_container);
        Intrinsics.checkNotNull(navHostFragmentFindFragmentById, "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        NavHostFragment navHostFragment = navHostFragmentFindFragmentById;
        List fragments = navHostFragment.getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        Fragment fragment = (Fragment) CollectionsKt.getOrNull(fragments, 0);
        if (fragment == null) {
            return true;
        }
        if (fragment instanceof SettingsNavFragment) {
            return ((SettingsNavFragment) fragment).onBackPressed();
        }
        if (fragment instanceof DaijishouPreferenceFragmentCompat) {
            if (((DaijishouPreferenceFragmentCompat) fragment).onBackPressed()) {
                navHostFragment.getChildFragmentManager().popBackStack();
            }
            return false;
        }
        if (fragment instanceof DaijishouPreferenceFragment) {
            if (((DaijishouPreferenceFragment) fragment).onBackPressed()) {
                navHostFragment.getChildFragmentManager().popBackStack();
            }
            return false;
        }
        navHostFragment.getChildFragmentManager().popBackStack();
        return false;
    }

    /* JADX INFO: compiled from: SettingsViewPagerFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/pager/SettingsViewPagerFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/pager/SettingsViewPagerFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SettingsViewPagerFragment newInstance() {
            return new SettingsViewPagerFragment();
        }
    }

    private final SettingsNavFragment requireSettingsNavFragment() {
        if (this.settingsNavFragment == null) {
            this.settingsNavFragment = new SettingsNavFragment();
        }
        SettingsNavFragment settingsNavFragment = this.settingsNavFragment;
        Intrinsics.checkNotNull(settingsNavFragment);
        return settingsNavFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final View viewInflate = inflater.inflate(R.layout.view_pager_fragment_settings, viewGroup, false);
        getSettingsViewModel().getTitleLiveData().observe(getViewLifecycleOwner(), new SettingsViewPagerFragment$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.SettingsViewPagerFragment.onCreateView.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                ((TextView) viewInflate.findViewById(R.id.settings_title_text_view)).setText(str);
            }
        }));
        return viewInflate;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.ViewPagerFragment, com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        NavHostFragment navHostFragmentFindFragmentById = childFragmentManager.findFragmentById(R.id.settings_nav_container);
        Intrinsics.checkNotNull(navHostFragmentFindFragmentById, "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        NavHostFragment navHostFragment = navHostFragmentFindFragmentById;
        if (bundle == null) {
            FragmentManager childFragmentManager2 = navHostFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager2.beginTransaction();
            fragmentTransactionBeginTransaction.replace(R.id.settings_nav_container, requireSettingsNavFragment());
            fragmentTransactionBeginTransaction.commit();
        }
    }
}

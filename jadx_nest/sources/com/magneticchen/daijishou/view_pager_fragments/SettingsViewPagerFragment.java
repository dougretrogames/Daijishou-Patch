package com.magneticchen.daijishou.view_pager_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.fragment.NavHostFragment;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.BackStackViewPagerFragment;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragment;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragmentCompat;
import com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerType;
import com.magneticchen.daijishou.settings_nav_fragments.SettingsNavFragment;
import com.magneticchen.daijishou.view_models.SettingsViewModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* INFO: compiled from: SettingsViewPagerFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010)\u001a\u00020\u0010H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/magneticchen/daijishou/view_pager_fragments/SettingsViewPagerFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/BackStackViewPagerFragment;", "()V", "displayNameStringId", "", "getDisplayNameStringId", "()I", "setDisplayNameStringId", "(I)V", "id", "", "getId", "()Ljava/lang/String;", "navFragmentContainerId", "getNavFragmentContainerId", "settingsNavFragment", "Lcom/magneticchen/daijishou/settings_nav_fragments/SettingsNavFragment;", "settingsViewModel", "Lcom/magneticchen/daijishou/view_models/SettingsViewModel;", "getSettingsViewModel", "()Lcom/magneticchen/daijishou/view_models/SettingsViewModel;", "settingsViewModel$delegate", "Lkotlin/Lazy;", "useDefaultWallpaper", "", "getUseDefaultWallpaper", "()Z", "setUseDefaultWallpaper", "(Z)V", "onBackPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "requireSettingsNavFragment", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SettingsViewPagerFragment extends BackStackViewPagerFragment {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SettingsNavFragment settingsNavFragment;

    /* INFO: renamed from: settingsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingsViewModel;
    private boolean useDefaultWallpaper;
    private final String id = ViewPagerType.SETTINGS.getId();
    private int displayNameStringId = R.string.settings_page;
    private final int navFragmentContainerId = R.id.settings_nav_container;

    public SettingsViewPagerFragment() {
        SettingsViewPagerFragment settingsViewPagerFragment = this;
        this.settingsViewModel = FragmentViewModelLazyKt.createViewModelLazy(settingsViewPagerFragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new SettingsViewPagerFragment$special$$inlined$activityViewModels$default$1(settingsViewPagerFragment), new SettingsViewPagerFragment$special$$inlined$activityViewModels$default$2(null, settingsViewPagerFragment), new SettingsViewPagerFragment$special$$inlined$activityViewModels$default$3(settingsViewPagerFragment));
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

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.BackStackViewPagerFragment
    public int getNavFragmentContainerId() {
        return this.navFragmentContainerId;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public boolean getUseDefaultWallpaper() {
        return this.useDefaultWallpaper;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public void setUseDefaultWallpaper(boolean z) {
        this.useDefaultWallpaper = z;
    }

    private final SettingsViewModel getSettingsViewModel() {
        return (SettingsViewModel) this.settingsViewModel.getValue();
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.BackStackViewPagerFragment, com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onBackPressed() {
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(R.id.settings_nav_container);
        Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        NavHostFragment navHostFragment = (NavHostFragment) fragmentFindFragmentById;
        List<Fragment> fragments = navHostFragment.getChildFragmentManager().getFragments();
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

    /* INFO: compiled from: SettingsViewPagerFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/view_pager_fragments/SettingsViewPagerFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/view_pager_fragments/SettingsViewPagerFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.view_pager_fragment_settings, container, false);
        getSettingsViewModel().getTitleLiveData().observe(getViewLifecycleOwner(), new SettingsViewPagerFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass1(viewInflate)));
        return viewInflate;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.view_pager_fragments.SettingsViewPagerFragment$onCreateView$1, reason: invalid class name */
    /* INFO: compiled from: SettingsViewPagerFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "settingsTitle", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda<Unit> implements Function1<String, Unit> {
        final /* synthetic */ View $view;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(View view) {
            super(1);
            this.$view = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            ((TextView) this.$view.findViewById(R.id.settings_title_text_view)).setText(str);
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment, com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Fragment fragmentFindFragmentById = childFragmentManager.findFragmentById(R.id.settings_nav_container);
        Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        NavHostFragment navHostFragment = (NavHostFragment) fragmentFindFragmentById;
        navHostFragment.getNavController();
        if (savedInstanceState == null) {
            FragmentManager childFragmentManager2 = navHostFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager2.beginTransaction();
            fragmentTransactionBeginTransaction.replace(R.id.settings_nav_container, requireSettingsNavFragment());
            fragmentTransactionBeginTransaction.commit();
        }
    }
}

package com.magneticchen.daijishou.view_pager_fragments;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.BackStackViewPagerFragment;
import com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerType;
import com.magneticchen.daijishou.activities.MainActivity;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetNavFragment;
import com.magneticchen.daijishou.daijishou_widget.widgets.category.CategoryWidgetNavFragment;
import com.magneticchen.daijishou.live_data.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.nav_fragments.WidgetGridNavFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: WidgetsViewPagerFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u0001:\u0001<B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020\fH\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J \u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000204H\u0016J\b\u00106\u001a\u000204H\u0016J\u001a\u00107\u001a\u0002042\u0006\u00108\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00109\u001a\u00020\u0004H\u0002J\b\u0010:\u001a\u00020$H\u0002J\b\u0010;\u001a\u000204H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\bR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0012R\u000e\u0010\"\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/magneticchen/daijishou/view_pager_fragments/WidgetsViewPagerFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/BackStackViewPagerFragment;", "()V", "categoryWidgetNavFragment", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/category/CategoryWidgetNavFragment;", "displayNameStringId", "", "getDisplayNameStringId", "()I", "setDisplayNameStringId", "(I)V", "fullscreen", "", "getFullscreen", "()Z", "handleWallpaperMyself", "getHandleWallpaperMyself", "setHandleWallpaperMyself", "(Z)V", "id", "", "getId", "()Ljava/lang/String;", "navFragmentContainerId", "getNavFragmentContainerId", "navHostFragment", "Landroidx/fragment/app/Fragment;", "nextFocusDown", "getNextFocusDown", "onBackStackChangedListener", "Landroidx/fragment/app/FragmentManager$OnBackStackChangedListener;", "useDefaultWallpaper", "getUseDefaultWallpaper", "setUseDefaultWallpaper", "useWidgetPage", "widgetGridNavFragment", "Lcom/magneticchen/daijishou/nav_fragments/WidgetGridNavFragment;", "onBackPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onHotKeyPressed", "hotkeyCode", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onPause", "", "onResume", "onStart", "onViewCreated", "view", "requireGenresWidgetNavFragment", "requireWidgetGridNavFragment", "updateWallpaper", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetsViewPagerFragment extends BackStackViewPagerFragment {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CategoryWidgetNavFragment categoryWidgetNavFragment;
    private boolean fullscreen = false;
    private Fragment navHostFragment;
    private FragmentManager.OnBackStackChangedListener onBackStackChangedListener;
    private WidgetGridNavFragment widgetGridNavFragment;
    private final String id = ViewPagerType.WIDGETS.getId();
    private final int nextFocusDown = R.id.fragment_widget_grid_clock;
    private int displayNameStringId = R.string.widgets_page;
    private final int navFragmentContainerId = R.id.widgets_nav_container;
    private boolean useDefaultWallpaper = true;
    private boolean handleWallpaperMyself = true;
    private boolean useWidgetPage = true;

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public String getStringId() {
        return this.id;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public int getNextFocusDown() {
        return this.nextFocusDown;
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

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public boolean getUseDefaultWallpaper() {
        return this.useDefaultWallpaper;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public void setUseDefaultWallpaper(boolean z) {
        this.useDefaultWallpaper = z;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public boolean getHandleWallpaperMyself() {
        return this.handleWallpaperMyself;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public void setHandleWallpaperMyself(boolean z) {
        this.handleWallpaperMyself = z;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onHotKeyPressed(int hotkeyCode, int keyCode, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(hotkeyCode, keyCode, keyEvent);
        Fragment fragment = this.navHostFragment;
        Intrinsics.checkNotNull(fragment);
        Fragment fragment2 = fragment.getChildFragmentManager().getFragments().get(0);
        if (fragment2 instanceof WidgetGridNavFragment) {
            return ((WidgetGridNavFragment) fragment2).onHotKeyPressed(hotkeyCode, keyCode, keyEvent);
        }
        if (fragment2 instanceof WidgetNavFragment) {
            return ((WidgetNavFragment) fragment2).onHotKeyPressed(hotkeyCode, keyCode, keyEvent);
        }
        return false;
    }

    /* INFO: Access modifiers changed from: private */
    public final WidgetGridNavFragment requireWidgetGridNavFragment() {
        if (this.widgetGridNavFragment == null) {
            this.widgetGridNavFragment = WidgetGridNavFragment.INSTANCE.newInstance();
        }
        WidgetGridNavFragment widgetGridNavFragment = this.widgetGridNavFragment;
        Intrinsics.checkNotNull(widgetGridNavFragment);
        return widgetGridNavFragment;
    }

    /* INFO: Access modifiers changed from: private */
    public final CategoryWidgetNavFragment requireGenresWidgetNavFragment() {
        if (this.categoryWidgetNavFragment == null) {
            this.categoryWidgetNavFragment = CategoryWidgetNavFragment.INSTANCE.newInstance();
        }
        CategoryWidgetNavFragment categoryWidgetNavFragment = this.categoryWidgetNavFragment;
        Intrinsics.checkNotNull(categoryWidgetNavFragment);
        return categoryWidgetNavFragment;
    }

    /* INFO: compiled from: WidgetsViewPagerFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/view_pager_fragments/WidgetsViewPagerFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/view_pager_fragments/WidgetsViewPagerFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WidgetsViewPagerFragment newInstance() {
            return new WidgetsViewPagerFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.navHostFragment = getChildFragmentManager().findFragmentById(getNavFragmentContainerId());
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.BackStackViewPagerFragment, com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onBackPressed() {
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(getNavFragmentContainerId());
        Intrinsics.checkNotNull(fragmentFindFragmentById);
        Fragment fragment = fragmentFindFragmentById.getChildFragmentManager().getFragments().get(0);
        if (fragment instanceof WidgetGridNavFragment) {
            return ((WidgetGridNavFragment) fragment).onBackPressed();
        }
        if (fragment instanceof CategoryWidgetNavFragment) {
            if (!getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_WIDGET_PAGE.getKey(), BooleanPreference.USE_WIDGET_PAGE.getDefaultValue())) {
                return ((CategoryWidgetNavFragment) fragment).onBackPressed();
            }
            if (((CategoryWidgetNavFragment) fragment).onBackPressed()) {
                fragmentFindFragmentById.getChildFragmentManager().popBackStack();
            }
            return false;
        }
        if (fragment instanceof WidgetNavFragment) {
            if (((WidgetNavFragment) fragment).onBackPressed()) {
                fragmentFindFragmentById.getChildFragmentManager().popBackStack();
            }
            return false;
        }
        fragmentFindFragmentById.getChildFragmentManager().popBackStack();
        return false;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment, com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(getNavFragmentContainerId());
        Intrinsics.checkNotNull(fragmentFindFragmentById);
        boolean z = getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_WIDGET_PAGE.getKey(), BooleanPreference.USE_WIDGET_PAGE.getDefaultValue());
        List<Fragment> fragments = fragmentFindFragmentById.getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        Fragment fragment = (Fragment) CollectionsKt.getOrNull(fragments, 0);
        if (z && (z != this.useWidgetPage || fragment == null)) {
            fragmentFindFragmentById.getChildFragmentManager().beginTransaction().replace(getNavFragmentContainerId(), requireWidgetGridNavFragment(), WidgetGridNavFragment.class.getName()).commit();
            updateDisplayNameStringId(R.string.widgets_page);
        } else if (!z && (z != this.useWidgetPage || !(fragment instanceof CategoryWidgetNavFragment))) {
            fragmentFindFragmentById.getChildFragmentManager().beginTransaction().replace(getNavFragmentContainerId(), requireGenresWidgetNavFragment(), CategoryWidgetNavFragment.class.getName()).commit();
            updateDisplayNameStringId(R.string.widget_face_category_title);
        }
        this.useWidgetPage = z;
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.USE_WIDGET_PAGE.getKey(), BooleanPreference.USE_WIDGET_PAGE.getDefaultValue()).observe(getViewLifecycleOwner(), new WidgetsViewPagerFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass1()));
        super.onViewCreated(view, savedInstanceState);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.view_pager_fragments.WidgetsViewPagerFragment$onViewCreated$1, reason: invalid class name */
    /* INFO: compiled from: WidgetsViewPagerFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "useWidgetPage", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            if (Intrinsics.areEqual(bool, Boolean.valueOf(WidgetsViewPagerFragment.this.useWidgetPage))) {
                return;
            }
            WidgetsViewPagerFragment widgetsViewPagerFragment = WidgetsViewPagerFragment.this;
            Intrinsics.checkNotNull(bool);
            widgetsViewPagerFragment.useWidgetPage = bool.booleanValue();
            Fragment fragmentFindFragmentById = WidgetsViewPagerFragment.this.getChildFragmentManager().findFragmentById(WidgetsViewPagerFragment.this.getNavFragmentContainerId());
            Intrinsics.checkNotNull(fragmentFindFragmentById);
            if (bool.booleanValue()) {
                fragmentFindFragmentById.getChildFragmentManager().beginTransaction().replace(WidgetsViewPagerFragment.this.getNavFragmentContainerId(), WidgetsViewPagerFragment.this.requireWidgetGridNavFragment(), WidgetGridNavFragment.class.getName()).commit();
                WidgetsViewPagerFragment.this.updateDisplayNameStringId(R.string.widgets_page);
            } else {
                fragmentFindFragmentById.getChildFragmentManager().beginTransaction().replace(WidgetsViewPagerFragment.this.getNavFragmentContainerId(), WidgetsViewPagerFragment.this.requireGenresWidgetNavFragment(), CategoryWidgetNavFragment.class.getName()).commit();
                WidgetsViewPagerFragment.this.updateDisplayNameStringId(R.string.widget_face_category_title);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.view_pager_fragment_widgets, container, false);
    }

    private final void updateWallpaper() {
        Fragment fragment = this.navHostFragment;
        Intrinsics.checkNotNull(fragment);
        Fragment fragment2 = fragment.getChildFragmentManager().getFragments().get(0);
        if (fragment2 instanceof WidgetGridNavFragment) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.magneticchen.daijishou.activities.MainActivity");
            ((MainActivity) fragmentActivityRequireActivity).useDefaultWallpaper(this, false);
        } else if ((fragment2 instanceof WidgetNavFragment) && ((WidgetNavFragment) fragment2).getUseDefaultWallpaper()) {
            FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
            Intrinsics.checkNotNull(fragmentActivityRequireActivity2, "null cannot be cast to non-null type com.magneticchen.daijishou.activities.MainActivity");
            ((MainActivity) fragmentActivityRequireActivity2).useDefaultWallpaper(this, false);
        } else {
            FragmentActivity fragmentActivityRequireActivity3 = requireActivity();
            Intrinsics.checkNotNull(fragmentActivityRequireActivity3, "null cannot be cast to non-null type com.magneticchen.daijishou.activities.MainActivity");
            ((MainActivity) fragmentActivityRequireActivity3).clearWallpaperImage(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.navHostFragment = getChildFragmentManager().findFragmentById(getNavFragmentContainerId());
        updateWallpaper();
        this.onBackStackChangedListener = new WidgetsViewPagerFragment$$ExternalSyntheticLambda0(this);
        Fragment fragment = this.navHostFragment;
        Intrinsics.checkNotNull(fragment);
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        FragmentManager.OnBackStackChangedListener onBackStackChangedListener = this.onBackStackChangedListener;
        Intrinsics.checkNotNull(onBackStackChangedListener);
        childFragmentManager.addOnBackStackChangedListener(onBackStackChangedListener);
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$0(WidgetsViewPagerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateWallpaper();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        FragmentManager.OnBackStackChangedListener onBackStackChangedListener = this.onBackStackChangedListener;
        if (onBackStackChangedListener != null) {
            Fragment fragment = this.navHostFragment;
            Intrinsics.checkNotNull(fragment);
            fragment.getChildFragmentManager().removeOnBackStackChangedListener(onBackStackChangedListener);
        }
    }
}

package com.magneticchen.daijishou.nav_fragments;

import android.app.Application;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.FragmentKt;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.PlatformNavFragment;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.application_data.StringPreference;
import com.magneticchen.daijishou.daijishou_uri.DaijishouUriHandler;
import com.magneticchen.daijishou.live_data.SharedPreferenceStringLiveData;
import com.magneticchen.daijishou.view_models.DaijishouViewModel;
import com.magneticchen.daijishou.view_models.LibraryViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* INFO: compiled from: LibraryCollectionWebViewViewNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J \u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u001dH\u0016J\b\u0010-\u001a\u00020\u001dH\u0016J\u001a\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u00100\u001a\u00020\u001dH\u0002J\b\u00101\u001a\u00020\u001dH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionWebViewViewNavFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/PlatformNavFragment;", "()V", "daijishouUriHandler", "Lcom/magneticchen/daijishou/daijishou_uri/DaijishouUriHandler;", "getDaijishouUriHandler", "()Lcom/magneticchen/daijishou/daijishou_uri/DaijishouUriHandler;", "setDaijishouUriHandler", "(Lcom/magneticchen/daijishou/daijishou_uri/DaijishouUriHandler;)V", "libraryViewModel", "Lcom/magneticchen/daijishou/view_models/LibraryViewModel;", "getLibraryViewModel", "()Lcom/magneticchen/daijishou/view_models/LibraryViewModel;", "libraryViewModel$delegate", "Lkotlin/Lazy;", "model", "Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "model$delegate", "navController", "Landroidx/navigation/NavController;", "progressBar", "Landroid/widget/ProgressBar;", "webView", "Landroid/webkit/WebView;", "onBackPressed", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHotKeyPressed", "hotkeyCode", "", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onKioskMode", "onNoneKioskMode", "onViewCreated", "view", "switchNext", "switchPrevious", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LibraryCollectionWebViewViewNavFragment extends PlatformNavFragment {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int PLATFORM_LIBRARY_GRID_VIEW_MODE = 1;
    public static final int PLATFORM_LIBRARY_LIST_VIEW_MODE = 0;
    public static final float RECYCLER_VIEW_SCROLL_OFFSET = 32.0f;
    private static final Typeface typeface;
    public DaijishouUriHandler daijishouUriHandler;

    /* INFO: renamed from: libraryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy libraryViewModel;

    /* INFO: renamed from: model$delegate, reason: from kotlin metadata */
    private final Lazy model;
    private NavController navController;
    public ProgressBar progressBar;
    public WebView webView;

    private final void switchNext() {
    }

    private final void switchPrevious() {
    }

    public LibraryCollectionWebViewViewNavFragment() {
        LibraryCollectionWebViewViewNavFragment libraryCollectionWebViewViewNavFragment = this;
        this.libraryViewModel = FragmentViewModelLazyKt.createViewModelLazy(libraryCollectionWebViewViewNavFragment, Reflection.getOrCreateKotlinClass(LibraryViewModel.class), new LibraryCollectionWebViewViewNavFragment$special$$inlined$activityViewModels$default$1(libraryCollectionWebViewViewNavFragment), new LibraryCollectionWebViewViewNavFragment$special$$inlined$activityViewModels$default$2(null, libraryCollectionWebViewViewNavFragment), new LibraryCollectionWebViewViewNavFragment$special$$inlined$activityViewModels$default$3(libraryCollectionWebViewViewNavFragment));
        this.model = FragmentViewModelLazyKt.createViewModelLazy(libraryCollectionWebViewViewNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new LibraryCollectionWebViewViewNavFragment$special$$inlined$activityViewModels$default$4(libraryCollectionWebViewViewNavFragment), new LibraryCollectionWebViewViewNavFragment$special$$inlined$activityViewModels$default$5(null, libraryCollectionWebViewViewNavFragment), new LibraryCollectionWebViewViewNavFragment$special$$inlined$activityViewModels$default$6(libraryCollectionWebViewViewNavFragment));
    }

    /* INFO: compiled from: LibraryCollectionWebViewViewNavFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionWebViewViewNavFragment$Companion;", "", "()V", "PLATFORM_LIBRARY_GRID_VIEW_MODE", "", "PLATFORM_LIBRARY_LIST_VIEW_MODE", "RECYCLER_VIEW_SCROLL_OFFSET", "", "typeface", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "newInstance", "Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionWebViewViewNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LibraryCollectionWebViewViewNavFragment newInstance() {
            return new LibraryCollectionWebViewViewNavFragment();
        }
    }

    static {
        typeface = Build.VERSION.SDK_INT >= 28 ? Typeface.create(null, Constants.semiBolderWeight, false) : Typeface.defaultFromStyle(1);
    }

    private final LibraryViewModel getLibraryViewModel() {
        return (LibraryViewModel) this.libraryViewModel.getValue();
    }

    private final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model.getValue();
    }

    public final DaijishouUriHandler getDaijishouUriHandler() {
        DaijishouUriHandler daijishouUriHandler = this.daijishouUriHandler;
        if (daijishouUriHandler != null) {
            return daijishouUriHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("daijishouUriHandler");
        return null;
    }

    public final void setDaijishouUriHandler(DaijishouUriHandler daijishouUriHandler) {
        Intrinsics.checkNotNullParameter(daijishouUriHandler, "<set-?>");
        this.daijishouUriHandler = daijishouUriHandler;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public void onKioskMode() {
        super.onKioskMode();
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public void onNoneKioskMode() {
        super.onNoneKioskMode();
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onHotKeyPressed(int hotkeyCode, int keyCode, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(hotkeyCode, keyCode, keyEvent);
        return false;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(requireContext(), "requireContext(...)");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        Application application = fragmentActivityRequireActivity.getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setDaijishouUriHandler(((DaijishouApplication) application).getDaijishouUriHandler());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_library_collection_web_view_view, container, false);
        this.navController = FragmentKt.findNavController(this);
        View viewFindViewById = viewInflate.findViewById(R.id.library_collection_web_view_view_web_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.webView = (WebView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.library_collection_web_view_view_progress_bar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.progressBar = (ProgressBar) viewFindViewById2;
        LibraryCollectionWebViewViewNavFragment$onCreateView$webViewClient$1 libraryCollectionWebViewViewNavFragment$onCreateView$webViewClient$1 = new LibraryCollectionWebViewViewNavFragment$onCreateView$webViewClient$1(this);
        WebView webView = this.webView;
        WebView webView2 = null;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.setBackgroundColor(0);
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView3 = null;
        }
        webView3.setWebViewClient(libraryCollectionWebViewViewNavFragment$onCreateView$webViewClient$1);
        WebView webView4 = this.webView;
        if (webView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView4 = null;
        }
        webView4.getSettings().setJavaScriptEnabled(true);
        WebView webView5 = this.webView;
        if (webView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView2 = webView5;
        }
        webView2.loadUrl("http://localhost:1787");
        new SharedPreferenceStringLiveData(getDefaultSharedPreferences(), StringPreference.LIBRARY_COLLECTION_VIEW_MODE.getKey(), StringPreference.LIBRARY_COLLECTION_VIEW_MODE.getDefaultValue()).observe(getViewLifecycleOwner(), new LibraryCollectionWebViewViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass1()));
        return viewInflate;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.LibraryCollectionWebViewViewNavFragment$onCreateView$1, reason: invalid class name */
    /* INFO: compiled from: LibraryCollectionWebViewViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<Unit> implements Function1<String, Unit> {
        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            NavController navController = null;
            if (Intrinsics.areEqual(str, "0")) {
                NavOptions navOptionsBuild = NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), R.id.libraryCollectionWebViewViewNavFragment, true, false, 4, (Object) null).build();
                NavController navController2 = LibraryCollectionWebViewViewNavFragment.this.navController;
                if (navController2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                    navController2 = null;
                }
                navController2.getGraph().setStartDestination(R.id.libraryCollectionWallpaperViewNavFragment);
                NavController navController3 = LibraryCollectionWebViewViewNavFragment.this.navController;
                if (navController3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                    navController3 = null;
                }
                NavDestination currentDestination = navController3.getCurrentDestination();
                if (currentDestination == null || currentDestination.getId() != R.id.libraryCollectionWebViewViewNavFragment) {
                    return;
                }
                NavController navController4 = LibraryCollectionWebViewViewNavFragment.this.navController;
                if (navController4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                } else {
                    navController = navController4;
                }
                navController.navigate(LibraryCollectionWebViewViewNavFragmentDirections.INSTANCE.libraryCollectionWebViewViewToLibraryCollectionWallpaperViewAction(), navOptionsBuild);
                return;
            }
            if (Intrinsics.areEqual(str, "1")) {
                NavOptions navOptionsBuild2 = NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), R.id.libraryCollectionWebViewViewNavFragment, true, false, 4, (Object) null).build();
                NavController navController5 = LibraryCollectionWebViewViewNavFragment.this.navController;
                if (navController5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                    navController5 = null;
                }
                navController5.getGraph().setStartDestination(R.id.libraryCollectionThumbnailsViewNavFragment);
                NavController navController6 = LibraryCollectionWebViewViewNavFragment.this.navController;
                if (navController6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                    navController6 = null;
                }
                NavDestination currentDestination2 = navController6.getCurrentDestination();
                if (currentDestination2 == null || currentDestination2.getId() != R.id.libraryCollectionWebViewViewNavFragment) {
                    return;
                }
                NavController navController7 = LibraryCollectionWebViewViewNavFragment.this.navController;
                if (navController7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                } else {
                    navController = navController7;
                }
                navController.navigate(LibraryCollectionWebViewViewNavFragmentDirections.INSTANCE.libraryCollectionWebViewViewToLibraryCollectionThumbnailsViewAction(), navOptionsBuild2);
            }
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }
}

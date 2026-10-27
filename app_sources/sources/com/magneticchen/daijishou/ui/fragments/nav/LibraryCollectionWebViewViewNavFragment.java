package com.magneticchen.daijishou.ui.fragments.nav;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.FragmentKt;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.StringPreference;
import com.magneticchen.daijishou.data.live.SharedPreferenceStringLiveData;
import com.magneticchen.daijishou.ui.fragments.p000abstract.PlatformNavFragment;
import com.magneticchen.daijishou.utils.DaijishouUriHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LibraryCollectionWebViewViewNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/nav/LibraryCollectionWebViewViewNavFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/PlatformNavFragment;", "()V", "daijishouUriHandler", "Lcom/magneticchen/daijishou/utils/DaijishouUriHandler;", "getDaijishouUriHandler", "()Lcom/magneticchen/daijishou/utils/DaijishouUriHandler;", "setDaijishouUriHandler", "(Lcom/magneticchen/daijishou/utils/DaijishouUriHandler;)V", "navController", "Landroidx/navigation/NavController;", "progressBar", "Landroid/widget/ProgressBar;", "webView", "Landroid/webkit/WebView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHotKeyPressed", "", "hotkeyCode", "", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onViewCreated", "view", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LibraryCollectionWebViewViewNavFragment extends PlatformNavFragment {
    public static final Companion Companion = new Companion(null);
    public static final int PLATFORM_LIBRARY_GRID_VIEW_MODE = 1;
    public static final int PLATFORM_LIBRARY_LIST_VIEW_MODE = 0;
    public static final float RECYCLER_VIEW_SCROLL_OFFSET = 32.0f;
    private static final Typeface typeface;
    public DaijishouUriHandler daijishouUriHandler;
    private NavController navController;
    private ProgressBar progressBar;
    private WebView webView;

    /* JADX INFO: compiled from: LibraryCollectionWebViewViewNavFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/nav/LibraryCollectionWebViewViewNavFragment$Companion;", "", "()V", "PLATFORM_LIBRARY_GRID_VIEW_MODE", "", "PLATFORM_LIBRARY_LIST_VIEW_MODE", "RECYCLER_VIEW_SCROLL_OFFSET", "", "typeface", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/nav/LibraryCollectionWebViewViewNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public boolean onHotKeyPressed(int i, int i2, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(i, i2, keyEvent);
        return false;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        Application application = fragmentActivityRequireActivity.getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setDaijishouUriHandler(((DaijishouApplication) application).getDaijishouUriHandler());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_library_collection_web_view_view, viewGroup, false);
        this.navController = FragmentKt.findNavController(this);
        View viewFindViewById = viewInflate.findViewById(R.id.library_collection_web_view_view_web_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.webView = (WebView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.library_collection_web_view_view_progress_bar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.progressBar = (ProgressBar) viewFindViewById2;
        WebViewClient webViewClient = new WebViewClient() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWebViewViewNavFragment$onCreateView$webViewClient$1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(request, "request");
                String string = request.getUrl().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                WebView webView = null;
                if (!this.this$0.getDaijishouUriHandler().isDaijishouFileUri(string)) {
                    WebView webView2 = this.this$0.webView;
                    if (webView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("webView");
                    } else {
                        webView = webView2;
                    }
                    webView.loadUrl(string);
                    return super.shouldOverrideUrlLoading(view, request);
                }
                String strDecodeFromDaijishouFileUri = this.this$0.getDaijishouUriHandler().decodeFromDaijishouFileUri(string);
                if (strDecodeFromDaijishouFileUri == null) {
                    return false;
                }
                WebView webView3 = this.this$0.webView;
                if (webView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                } else {
                    webView = webView3;
                }
                webView.loadUrl(strDecodeFromDaijishouFileUri);
                return true;
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url, "url");
                super.onPageStarted(view, url, bitmap);
                ProgressBar progressBar = this.this$0.progressBar;
                if (progressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                    progressBar = null;
                }
                progressBar.setVisibility(0);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url, "url");
                super.onPageFinished(view, url);
                ProgressBar progressBar = this.this$0.progressBar;
                if (progressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                    progressBar = null;
                }
                progressBar.setVisibility(8);
            }
        };
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
        webView3.setWebViewClient(webViewClient);
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
        new SharedPreferenceStringLiveData(getDefaultSharedPreferences(), StringPreference.LIBRARY_COLLECTION_VIEW_MODE.getKey(), StringPreference.LIBRARY_COLLECTION_VIEW_MODE.getDefaultValue()).observe(getViewLifecycleOwner(), new LibraryCollectionWebViewViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWebViewViewNavFragment.onCreateView.1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
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
                    if (currentDestination == null || currentDestination.getId() != 2131362372) {
                        return;
                    }
                    NavController navController4 = LibraryCollectionWebViewViewNavFragment.this.navController;
                    if (navController4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                    } else {
                        navController = navController4;
                    }
                    navController.navigate(LibraryCollectionWebViewViewNavFragmentDirections.Companion.libraryCollectionWebViewViewToLibraryCollectionWallpaperViewAction(), navOptionsBuild);
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
                    if (currentDestination2 == null || currentDestination2.getId() != 2131362372) {
                        return;
                    }
                    NavController navController7 = LibraryCollectionWebViewViewNavFragment.this.navController;
                    if (navController7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                    } else {
                        navController = navController7;
                    }
                    navController.navigate(LibraryCollectionWebViewViewNavFragmentDirections.Companion.libraryCollectionWebViewViewToLibraryCollectionThumbnailsViewAction(), navOptionsBuild2);
                }
            }
        }));
        return viewInflate;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
    }
}

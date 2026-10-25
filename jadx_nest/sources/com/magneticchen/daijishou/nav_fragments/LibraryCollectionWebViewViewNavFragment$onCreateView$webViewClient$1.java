package com.magneticchen.daijishou.nav_fragments;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LibraryCollectionWebViewViewNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/magneticchen/daijishou/nav_fragments/LibraryCollectionWebViewViewNavFragment$onCreateView$webViewClient$1", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "shouldOverrideUrlLoading", "", "request", "Landroid/webkit/WebResourceRequest;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LibraryCollectionWebViewViewNavFragment$onCreateView$webViewClient$1 extends WebViewClient {
    final /* synthetic */ LibraryCollectionWebViewViewNavFragment this$0;

    LibraryCollectionWebViewViewNavFragment$onCreateView$webViewClient$1(LibraryCollectionWebViewViewNavFragment libraryCollectionWebViewViewNavFragment) {
        this.this$0 = libraryCollectionWebViewViewNavFragment;
    }

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
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        super.onPageStarted(view, url, favicon);
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
}

package androidx.webkit.internal;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public class ApiHelperForM {
    private ApiHelperForM() {
    }

    public static void postMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
        webMessagePort.postMessage(webMessage);
    }

    public static void close(WebMessagePort webMessagePort) {
        webMessagePort.close();
    }

    /* JADX INFO: renamed from: androidx.webkit.internal.ApiHelperForM$1, reason: invalid class name */
    class AnonymousClass1 extends WebMessagePort.WebMessageCallback {
        final /* synthetic */ WebMessagePortCompat.WebMessageCallbackCompat val$callback;

        AnonymousClass1(WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
            this.val$callback = webMessageCallbackCompat;
        }

        @Override // android.webkit.WebMessagePort.WebMessageCallback
        public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
            this.val$callback.onMessage(new WebMessagePortImpl(webMessagePort), WebMessagePortImpl.frameworkMessageToCompat(webMessage));
        }
    }

    public static void setWebMessageCallback(WebMessagePort webMessagePort, WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
        webMessagePort.setWebMessageCallback(new AnonymousClass1(webMessageCallbackCompat));
    }

    /* JADX INFO: renamed from: androidx.webkit.internal.ApiHelperForM$2, reason: invalid class name */
    class AnonymousClass2 extends WebMessagePort.WebMessageCallback {
        final /* synthetic */ WebMessagePortCompat.WebMessageCallbackCompat val$callback;

        AnonymousClass2(WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
            this.val$callback = webMessageCallbackCompat;
        }

        @Override // android.webkit.WebMessagePort.WebMessageCallback
        public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
            this.val$callback.onMessage(new WebMessagePortImpl(webMessagePort), WebMessagePortImpl.frameworkMessageToCompat(webMessage));
        }
    }

    public static void setWebMessageCallback(WebMessagePort webMessagePort, WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat, Handler handler) {
        webMessagePort.setWebMessageCallback(new AnonymousClass2(webMessageCallbackCompat), handler);
    }

    public static WebMessage createWebMessage(WebMessageCompat webMessageCompat) {
        return new WebMessage(webMessageCompat.getData(), WebMessagePortImpl.compatToPorts(webMessageCompat.getPorts()));
    }

    public static WebMessageCompat createWebMessageCompat(WebMessage webMessage) {
        return new WebMessageCompat(webMessage.getData(), WebMessagePortImpl.portsToCompat(webMessage.getPorts()));
    }

    public static int getErrorCode(WebResourceError webResourceError) {
        return webResourceError.getErrorCode();
    }

    public static CharSequence getDescription(WebResourceError webResourceError) {
        return webResourceError.getDescription();
    }

    public static void setOffscreenPreRaster(WebSettings webSettings, boolean z) {
        webSettings.setOffscreenPreRaster(z);
    }

    public static boolean getOffscreenPreRaster(WebSettings webSettings) {
        return webSettings.getOffscreenPreRaster();
    }

    /* JADX INFO: renamed from: androidx.webkit.internal.ApiHelperForM$3, reason: invalid class name */
    class AnonymousClass3 extends WebView.VisualStateCallback {
        final /* synthetic */ WebViewCompat.VisualStateCallback val$callback;

        AnonymousClass3(WebViewCompat.VisualStateCallback visualStateCallback) {
            this.val$callback = visualStateCallback;
        }

        @Override // android.webkit.WebView.VisualStateCallback
        public void onComplete(long j) {
            this.val$callback.onComplete(j);
        }
    }

    public static void postVisualStateCallback(WebView webView, long j, WebViewCompat.VisualStateCallback visualStateCallback) {
        webView.postVisualStateCallback(j, new AnonymousClass3(visualStateCallback));
    }

    public static void postWebMessage(WebView webView, WebMessage webMessage, Uri uri) {
        webView.postWebMessage(webMessage, uri);
    }

    public static WebMessagePort[] createWebMessageChannel(WebView webView) {
        return webView.createWebMessageChannel();
    }
}

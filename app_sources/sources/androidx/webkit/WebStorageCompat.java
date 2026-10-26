package androidx.webkit;

import android.webkit.WebStorage;
import androidx.webkit.internal.WebStorageAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import java.util.concurrent.Executor;

/* INFO: loaded from: classes3.dex */
public final class WebStorageCompat {
    private WebStorageCompat() {
    }

    public static void deleteBrowsingData(WebStorage webStorage, Executor executor, Runnable runnable) {
        if (WebViewFeatureInternal.DELETE_BROWSING_DATA.isSupportedByWebView()) {
            getAdapter(webStorage).deleteBrowsingData(executor, runnable);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void deleteBrowsingData(WebStorage webStorage, Runnable runnable) {
        deleteBrowsingData(webStorage, new WebStorageCompat$$ExternalSyntheticLambda1(), runnable);
    }

    public static String deleteBrowsingDataForSite(WebStorage webStorage, String str, Executor executor, Runnable runnable) {
        if (WebViewFeatureInternal.DELETE_BROWSING_DATA.isSupportedByWebView()) {
            return getAdapter(webStorage).deleteBrowsingDataForSite(str, executor, runnable);
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static String deleteBrowsingDataForSite(WebStorage webStorage, String str, Runnable runnable) {
        return deleteBrowsingDataForSite(webStorage, str, new WebStorageCompat$$ExternalSyntheticLambda0(), runnable);
    }

    private static WebStorageAdapter getAdapter(WebStorage webStorage) {
        return WebViewGlueCommunicator.getCompatConverter().convertWebStorage(webStorage);
    }
}

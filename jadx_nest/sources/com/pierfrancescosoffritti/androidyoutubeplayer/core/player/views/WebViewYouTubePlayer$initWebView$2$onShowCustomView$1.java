package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import android.webkit.WebChromeClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: WebViewYouTubePlayer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class WebViewYouTubePlayer$initWebView$2$onShowCustomView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ WebChromeClient.CustomViewCallback $callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebViewYouTubePlayer$initWebView$2$onShowCustomView$1(WebChromeClient.CustomViewCallback customViewCallback) {
        super(0);
        this.$callback = customViewCallback;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$callback.onCustomViewHidden();
    }
}

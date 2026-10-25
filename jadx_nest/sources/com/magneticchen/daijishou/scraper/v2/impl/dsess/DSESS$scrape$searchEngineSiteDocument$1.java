package com.magneticchen.daijishou.scraper.v2.impl.dsess;

import android.net.Uri;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: DSESS.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lorg/jsoup/nodes/Document;", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DSESS$scrape$searchEngineSiteDocument$1 extends Lambda<Document> implements Function1<String, Document> {
    final /* synthetic */ Uri $searchEngineSiteURLUri;
    final /* synthetic */ DSESS this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DSESS$scrape$searchEngineSiteDocument$1(Uri uri, DSESS dsess) {
        super(1);
        this.$searchEngineSiteURLUri = uri;
        this.this$0 = dsess;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Document invoke(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Connection connectionConnect = Jsoup.connect(this.$searchEngineSiteURLUri.toString());
        DSESS dsess = this.this$0;
        Uri uri = this.$searchEngineSiteURLUri;
        connectionConnect.timeout(dsess.getConfig().getJsoupConnectTimeout());
        connectionConnect.userAgent(dsess.getConfig().getJsoupUserAgent());
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Map<String, String> cookiesFromURLStringFromCache = dsess.getCookiesFromURLStringFromCache(string, dsess.getConfig().getBaseURLStringCookiesCache());
        if (cookiesFromURLStringFromCache != null) {
            connectionConnect.cookies(cookiesFromURLStringFromCache);
        }
        try {
            return connectionConnect.get();
        } catch (java.io.IOException e) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(e);
        }
    }
}

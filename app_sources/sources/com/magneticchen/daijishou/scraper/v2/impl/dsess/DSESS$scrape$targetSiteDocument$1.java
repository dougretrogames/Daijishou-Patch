package com.magneticchen.daijishou.scraper.v2.impl.dsess;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/* INFO: compiled from: DSESS.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lorg/jsoup/nodes/Document;", "kotlin.jvm.PlatformType", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DSESS$scrape$targetSiteDocument$1 extends Lambda<Document> implements Function1<String, Document> {
    final /* synthetic */ String $siteURLString;
    final /* synthetic */ DSESS this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DSESS$scrape$targetSiteDocument$1(String str, DSESS dsess) {
        super(1);
        this.$siteURLString = str;
        this.this$0 = dsess;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Document invoke(String str) {
        Connection connectionConnect = Jsoup.connect(this.$siteURLString);
        DSESS dsess = this.this$0;
        String str2 = this.$siteURLString;
        connectionConnect.timeout(dsess.getConfig().getJsoupConnectTimeout());
        connectionConnect.userAgent(dsess.getConfig().getJsoupUserAgent());
        Map<String, String> cookiesFromURLStringFromCache = dsess.getCookiesFromURLStringFromCache(str2, dsess.getConfig().getBaseURLStringCookiesCache());
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

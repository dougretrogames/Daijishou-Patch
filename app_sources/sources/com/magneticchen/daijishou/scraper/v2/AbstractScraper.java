package com.magneticchen.daijishou.scraper.v2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.scraper.ScraperUtilsKt;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.jodah.expiringmap.ExpiringMap;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

/* INFO: compiled from: AbstractScraper.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017J<\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\f2\u001e\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00190\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\b\b\u0002\u0010%\u001a\u00020&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u00060\u0012R\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/magneticchen/daijishou/scraper/v2/AbstractScraper;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "config", "Lcom/magneticchen/daijishou/scraper/v2/ScraperConfig;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Lcom/magneticchen/daijishou/scraper/v2/ScraperConfig;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "getConfig", "()Lcom/magneticchen/daijishou/scraper/v2/ScraperConfig;", "failedToScrapeString", "", "getFailedToScrapeString", "()Ljava/lang/String;", "failedToScrapeString$delegate", "Lkotlin/Lazy;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "getBaseURLStringFromURL", "uRL", "Ljava/net/URL;", "getCookiesFromURLStringFromCache", "", "uRLString", "baseURLStringCookiesCache", "Lnet/jodah/expiringmap/ExpiringMap;", "hasAllMedia", "", "playableItemPreviewMediaIndex", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemPreviewMediaIndex;", "saveURLImageToPath", "", "url", "path", "shortEdgeSize", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractScraper {
    private final DaijishouApplication application;
    private final ScraperConfig config;

    /* INFO: renamed from: failedToScrapeString$delegate, reason: from kotlin metadata */
    private final Lazy failedToScrapeString;
    private final DaijishouApplication.WrappedLogger logger;

    public AbstractScraper(DaijishouApplication application, ScraperConfig config) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(config, "config");
        this.application = application;
        this.config = config;
        this.logger = application.getLogger();
        this.failedToScrapeString = LazyKt.lazy(new AbstractScraper$failedToScrapeString$2(this));
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    public final ScraperConfig getConfig() {
        return this.config;
    }

    protected final DaijishouApplication.WrappedLogger getLogger() {
        return this.logger;
    }

    protected final String getFailedToScrapeString() {
        return (String) this.failedToScrapeString.getValue();
    }

    public final boolean hasAllMedia(PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex) {
        Intrinsics.checkNotNullParameter(playableItemPreviewMediaIndex, "playableItemPreviewMediaIndex");
        return (playableItemPreviewMediaIndex.getBoxArtPath() == null || playableItemPreviewMediaIndex.getSnapshotPath() == null || playableItemPreviewMediaIndex.getBoxArtPath() == null) ? false : true;
    }

    public static /* synthetic */ void saveURLImageToPath$default(AbstractScraper abstractScraper, String str, String str2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveURLImageToPath");
        }
        if ((i2 & 4) != 0) {
            i = 720;
        }
        abstractScraper.saveURLImageToPath(str, str2, i);
    }

    public final void saveURLImageToPath(String url, String path, int shortEdgeSize) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new URL(url).openStream());
            Intrinsics.checkNotNullExpressionValue(bitmapDecodeStream, "decodeStream(...)");
            Bitmap resizedBitmap = ScraperUtilsKt.getResizedBitmap(bitmapDecodeStream, shortEdgeSize);
            Intrinsics.checkNotNull(resizedBitmap);
            resizedBitmap.compress(Constants.INSTANCE.getScraperFormat(), 100, new FileOutputStream(path));
        } catch (java.io.IOException e) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(e);
        }
    }

    public final Map<String, String> getCookiesFromURLStringFromCache(String uRLString, ExpiringMap<String, Map<String, String>> baseURLStringCookiesCache) {
        Intrinsics.checkNotNullParameter(uRLString, "uRLString");
        Intrinsics.checkNotNullParameter(baseURLStringCookiesCache, "baseURLStringCookiesCache");
        try {
            String baseURLStringFromURL = getBaseURLStringFromURL(new URL(uRLString));
            if (baseURLStringCookiesCache.containsKey(baseURLStringFromURL)) {
                return baseURLStringCookiesCache.get(baseURLStringFromURL);
            }
            if (!baseURLStringCookiesCache.containsKey(baseURLStringFromURL)) {
                Connection connectionConnect = Jsoup.connect(baseURLStringFromURL);
                connectionConnect.userAgent(this.config.getJsoupUserAgent());
                connectionConnect.timeout(this.config.getJsoupConnectTimeout());
                baseURLStringCookiesCache.put(baseURLStringFromURL, connectionConnect.execute().cookies());
            }
            return baseURLStringCookiesCache.get(baseURLStringFromURL);
        } catch (java.io.IOException e) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(e);
        }
    }

    public final String getBaseURLStringFromURL(URL uRL) {
        Intrinsics.checkNotNullParameter(uRL, "uRL");
        return uRL.getProtocol() + "://" + uRL.getHost();
    }
}

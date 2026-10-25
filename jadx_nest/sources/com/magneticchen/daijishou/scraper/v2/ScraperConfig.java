package com.magneticchen.daijishou.scraper.v2;

import android.graphics.Bitmap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.jodah.expiringmap.ExpiringMap;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: ScraperConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f0\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J!\u0010!\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f0\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Jq\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2 \b\u0002\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\tHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R)\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013¨\u0006*"}, d2 = {"Lcom/magneticchen/daijishou/scraper/v2/ScraperConfig;", "", "boxArtFilename", "", "snapshotFilename", "titleFilename", "scraperFormat", "Landroid/graphics/Bitmap$CompressFormat;", "scraperQuality", "", "baseURLStringCookiesCache", "Lnet/jodah/expiringmap/ExpiringMap;", "", "jsoupConnectTimeout", "jsoupUserAgent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap$CompressFormat;ILnet/jodah/expiringmap/ExpiringMap;ILjava/lang/String;)V", "getBaseURLStringCookiesCache", "()Lnet/jodah/expiringmap/ExpiringMap;", "getBoxArtFilename", "()Ljava/lang/String;", "getJsoupConnectTimeout", "()I", "getJsoupUserAgent", "getScraperFormat", "()Landroid/graphics/Bitmap$CompressFormat;", "getScraperQuality", "getSnapshotFilename", "getTitleFilename", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ScraperConfig {
    private final ExpiringMap<String, Map<String, String>> baseURLStringCookiesCache;
    private final String boxArtFilename;
    private final int jsoupConnectTimeout;
    private final String jsoupUserAgent;
    private final Bitmap.CompressFormat scraperFormat;
    private final int scraperQuality;
    private final String snapshotFilename;
    private final String titleFilename;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ScraperConfig copy$default(ScraperConfig scraperConfig, String str, String str2, String str3, Bitmap.CompressFormat compressFormat, int i, ExpiringMap expiringMap, int i2, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = scraperConfig.boxArtFilename;
        }
        if ((i3 & 2) != 0) {
            str2 = scraperConfig.snapshotFilename;
        }
        if ((i3 & 4) != 0) {
            str3 = scraperConfig.titleFilename;
        }
        if ((i3 & 8) != 0) {
            compressFormat = scraperConfig.scraperFormat;
        }
        if ((i3 & 16) != 0) {
            i = scraperConfig.scraperQuality;
        }
        if ((i3 & 32) != 0) {
            expiringMap = scraperConfig.baseURLStringCookiesCache;
        }
        if ((i3 & 64) != 0) {
            i2 = scraperConfig.jsoupConnectTimeout;
        }
        if ((i3 & 128) != 0) {
            str4 = scraperConfig.jsoupUserAgent;
        }
        int i4 = i2;
        String str5 = str4;
        int i5 = i;
        ExpiringMap expiringMap2 = expiringMap;
        return scraperConfig.copy(str, str2, str3, compressFormat, i5, expiringMap2, i4, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBoxArtFilename() {
        return this.boxArtFilename;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSnapshotFilename() {
        return this.snapshotFilename;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitleFilename() {
        return this.titleFilename;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Bitmap.CompressFormat getScraperFormat() {
        return this.scraperFormat;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getScraperQuality() {
        return this.scraperQuality;
    }

    public final ExpiringMap<String, Map<String, String>> component6() {
        return this.baseURLStringCookiesCache;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getJsoupConnectTimeout() {
        return this.jsoupConnectTimeout;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getJsoupUserAgent() {
        return this.jsoupUserAgent;
    }

    public final ScraperConfig copy(String boxArtFilename, String snapshotFilename, String titleFilename, Bitmap.CompressFormat scraperFormat, int scraperQuality, ExpiringMap<String, Map<String, String>> baseURLStringCookiesCache, int jsoupConnectTimeout, String jsoupUserAgent) {
        Intrinsics.checkNotNullParameter(boxArtFilename, "boxArtFilename");
        Intrinsics.checkNotNullParameter(snapshotFilename, "snapshotFilename");
        Intrinsics.checkNotNullParameter(titleFilename, "titleFilename");
        Intrinsics.checkNotNullParameter(scraperFormat, "scraperFormat");
        Intrinsics.checkNotNullParameter(baseURLStringCookiesCache, "baseURLStringCookiesCache");
        Intrinsics.checkNotNullParameter(jsoupUserAgent, "jsoupUserAgent");
        return new ScraperConfig(boxArtFilename, snapshotFilename, titleFilename, scraperFormat, scraperQuality, baseURLStringCookiesCache, jsoupConnectTimeout, jsoupUserAgent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScraperConfig)) {
            return false;
        }
        ScraperConfig scraperConfig = (ScraperConfig) other;
        return Intrinsics.areEqual(this.boxArtFilename, scraperConfig.boxArtFilename) && Intrinsics.areEqual(this.snapshotFilename, scraperConfig.snapshotFilename) && Intrinsics.areEqual(this.titleFilename, scraperConfig.titleFilename) && this.scraperFormat == scraperConfig.scraperFormat && this.scraperQuality == scraperConfig.scraperQuality && Intrinsics.areEqual(this.baseURLStringCookiesCache, scraperConfig.baseURLStringCookiesCache) && this.jsoupConnectTimeout == scraperConfig.jsoupConnectTimeout && Intrinsics.areEqual(this.jsoupUserAgent, scraperConfig.jsoupUserAgent);
    }

    public int hashCode() {
        return (((((((((((((this.boxArtFilename.hashCode() * 31) + this.snapshotFilename.hashCode()) * 31) + this.titleFilename.hashCode()) * 31) + this.scraperFormat.hashCode()) * 31) + Integer.hashCode(this.scraperQuality)) * 31) + this.baseURLStringCookiesCache.hashCode()) * 31) + Integer.hashCode(this.jsoupConnectTimeout)) * 31) + this.jsoupUserAgent.hashCode();
    }

    public String toString() {
        return "ScraperConfig(boxArtFilename=" + this.boxArtFilename + ", snapshotFilename=" + this.snapshotFilename + ", titleFilename=" + this.titleFilename + ", scraperFormat=" + this.scraperFormat + ", scraperQuality=" + this.scraperQuality + ", baseURLStringCookiesCache=" + this.baseURLStringCookiesCache + ", jsoupConnectTimeout=" + this.jsoupConnectTimeout + ", jsoupUserAgent=" + this.jsoupUserAgent + ")";
    }

    public ScraperConfig(String boxArtFilename, String snapshotFilename, String titleFilename, Bitmap.CompressFormat scraperFormat, int i, ExpiringMap<String, Map<String, String>> baseURLStringCookiesCache, int i2, String jsoupUserAgent) {
        Intrinsics.checkNotNullParameter(boxArtFilename, "boxArtFilename");
        Intrinsics.checkNotNullParameter(snapshotFilename, "snapshotFilename");
        Intrinsics.checkNotNullParameter(titleFilename, "titleFilename");
        Intrinsics.checkNotNullParameter(scraperFormat, "scraperFormat");
        Intrinsics.checkNotNullParameter(baseURLStringCookiesCache, "baseURLStringCookiesCache");
        Intrinsics.checkNotNullParameter(jsoupUserAgent, "jsoupUserAgent");
        this.boxArtFilename = boxArtFilename;
        this.snapshotFilename = snapshotFilename;
        this.titleFilename = titleFilename;
        this.scraperFormat = scraperFormat;
        this.scraperQuality = i;
        this.baseURLStringCookiesCache = baseURLStringCookiesCache;
        this.jsoupConnectTimeout = i2;
        this.jsoupUserAgent = jsoupUserAgent;
    }






    public final ExpiringMap<String, Map<String, String>> getBaseURLStringCookiesCache() {
        return this.baseURLStringCookiesCache;
    }


    public /* synthetic */ ScraperConfig(String str, String str2, String str3, Bitmap.CompressFormat compressFormat, int i, ExpiringMap expiringMap, int i2, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, compressFormat, i, expiringMap, (i3 & 64) != 0 ? 16000 : i2, (i3 & 128) != 0 ? "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36" : str4);
    }

}

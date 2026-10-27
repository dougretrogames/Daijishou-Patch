package com.magneticchen.daijishou.data.scraper.v2.impl.google;

import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.data.scraper.v2.AbstractScraper;
import com.magneticchen.daijishou.data.scraper.v2.ScraperConfig;
import com.magneticchen.daijishou.utils.UtilsKt;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: GoogleScraper.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ.\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/google/GoogleScraper;", "Lcom/magneticchen/daijishou/data/scraper/v2/AbstractScraper;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "config", "Lcom/magneticchen/daijishou/data/scraper/v2/ScraperConfig;", "googleConfig", "Lcom/magneticchen/daijishou/data/scraper/v2/impl/google/GoogleScraper$Config;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Lcom/magneticchen/daijishou/data/scraper/v2/ScraperConfig;Lcom/magneticchen/daijishou/data/scraper/v2/impl/google/GoogleScraper$Config;)V", "scrapePreviewMediaByKeywords", "Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;", "playableItemPreviewMediaIndex", "platformName", "", "keywords", "", "path", "toGenericName", "string", "Config", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GoogleScraper extends AbstractScraper {
    private final Config googleConfig;

    public /* synthetic */ GoogleScraper(DaijishouApplication daijishouApplication, ScraperConfig scraperConfig, Config config, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            config = new Config(null, null, null, null, 15, null);
        }
        this(daijishouApplication, scraperConfig, config);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleScraper(DaijishouApplication application, ScraperConfig config, Config googleConfig) {
        super(application, config);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(googleConfig, "googleConfig");
        this.googleConfig = googleConfig;
    }

    public final PlayableItemPreviewMediaIndex scrapePreviewMediaByKeywords(PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex, String str, List<String> keywords, String path) {
        Element elementSelectFirst;
        Intrinsics.checkNotNullParameter(playableItemPreviewMediaIndex, "playableItemPreviewMediaIndex");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(path, "path");
        String str2 = path + getConfig().getBoxArtFilename();
        Iterator<String> it = keywords.iterator();
        while (it.hasNext()) {
            try {
                String strEncode = URLEncoder.encode(toGenericName(it.next()) + " " + str + " box art wiki", "UTF-8");
                String queryURL = this.googleConfig.getQueryURL();
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                String str3 = String.format(queryURL, Arrays.copyOf(new Object[]{strEncode, UtilsKt.getLanguageAndCountry(locale)}, 2));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                Connection connectionConnect = Jsoup.connect(str3);
                connectionConnect.timeout(getConfig().getJsoupConnectTimeout());
                connectionConnect.userAgent(getConfig().getJsoupUserAgent());
                Map<String, String> cookiesFromURLStringFromCache = getCookiesFromURLStringFromCache(str3, getConfig().getBaseURLStringCookiesCache());
                if (cookiesFromURLStringFromCache != null) {
                    connectionConnect.cookies(cookiesFromURLStringFromCache);
                }
                Iterator it2 = connectionConnect.get().select("a[jsname=uy6ald]").iterator();
                while (it2.hasNext()) {
                    String strAttr = ((Element) it2.next()).attr("href");
                    String str4 = strAttr;
                    if (str4 != null && str4.length() != 0) {
                        Intrinsics.checkNotNull(strAttr);
                        if (StringsKt.contains$default((CharSequence) strAttr, (CharSequence) "en.wikipedia.org", false, 2, (Object) null) && (elementSelectFirst = Jsoup.connect(strAttr).get().selectFirst("td.infobox-image a")) != null) {
                            String strAttr2 = elementSelectFirst.attr("href");
                            String str5 = strAttr2;
                            if (str5 != null && str5.length() != 0) {
                                Element elementSelectFirst2 = Jsoup.connect(this.googleConfig.getWikiBaseURL() + strAttr2).get().selectFirst("div#file img");
                                if (elementSelectFirst2 != null) {
                                    String strAttr3 = elementSelectFirst2.attr("src");
                                    String str6 = strAttr3;
                                    if (str6 != null && str6.length() != 0) {
                                        saveURLImageToPath("https:" + strAttr3, str2, Constants.downloadedBoxArtImagesShortEdgeBase);
                                        playableItemPreviewMediaIndex.setBoxArtPath(getConfig().getBoxArtFilename());
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
            }
        }
        return playableItemPreviewMediaIndex;
    }

    private final String toGenericName(String str) {
        List<String> groupValues;
        String str2;
        MatchResult matchResultFind$default = Regex.find$default(this.googleConfig.getGenericNameRegex(), str, 0, 2, null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null && (str2 = groupValues.get(1)) != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str2.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                String strReplace = new Regex("\\s*-\\s+Disc\\s+\\d+\\s*", RegexOption.IGNORE_CASE).replace(lowerCase, "");
                if (strReplace != null) {
                    return new Regex("(\\s+|_+)").replace(strReplace, " ");
                }
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: GoogleScraper.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/google/GoogleScraper$Config;", "", "genericNameRegex", "Lkotlin/text/Regex;", "uRLStringToResultCache", "", "", "queryURL", "wikiBaseURL", "(Lkotlin/text/Regex;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getGenericNameRegex", "()Lkotlin/text/Regex;", "getQueryURL", "()Ljava/lang/String;", "getURLStringToResultCache", "()Ljava/util/Map;", "getWikiBaseURL", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Config {
        private final Regex genericNameRegex;
        private final String queryURL;
        private final Map<String, String> uRLStringToResultCache;
        private final String wikiBaseURL;

        public Config() {
            this(null, null, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Config copy$default(Config config, Regex regex, Map map, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                regex = config.genericNameRegex;
            }
            if ((i & 2) != 0) {
                map = config.uRLStringToResultCache;
            }
            if ((i & 4) != 0) {
                str = config.queryURL;
            }
            if ((i & 8) != 0) {
                str2 = config.wikiBaseURL;
            }
            return config.copy(regex, map, str, str2);
        }

        public final Regex component1() {
            return this.genericNameRegex;
        }

        public final Map<String, String> component2() {
            return this.uRLStringToResultCache;
        }

        public final String component3() {
            return this.queryURL;
        }

        public final String component4() {
            return this.wikiBaseURL;
        }

        public final Config copy(Regex genericNameRegex, Map<String, String> uRLStringToResultCache, String queryURL, String wikiBaseURL) {
            Intrinsics.checkNotNullParameter(genericNameRegex, "genericNameRegex");
            Intrinsics.checkNotNullParameter(uRLStringToResultCache, "uRLStringToResultCache");
            Intrinsics.checkNotNullParameter(queryURL, "queryURL");
            Intrinsics.checkNotNullParameter(wikiBaseURL, "wikiBaseURL");
            return new Config(genericNameRegex, uRLStringToResultCache, queryURL, wikiBaseURL);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return Intrinsics.areEqual(this.genericNameRegex, config.genericNameRegex) && Intrinsics.areEqual(this.uRLStringToResultCache, config.uRLStringToResultCache) && Intrinsics.areEqual(this.queryURL, config.queryURL) && Intrinsics.areEqual(this.wikiBaseURL, config.wikiBaseURL);
        }

        public int hashCode() {
            return (((((this.genericNameRegex.hashCode() * 31) + this.uRLStringToResultCache.hashCode()) * 31) + this.queryURL.hashCode()) * 31) + this.wikiBaseURL.hashCode();
        }

        public String toString() {
            return "Config(genericNameRegex=" + this.genericNameRegex + ", uRLStringToResultCache=" + this.uRLStringToResultCache + ", queryURL=" + this.queryURL + ", wikiBaseURL=" + this.wikiBaseURL + ")";
        }

        public Config(Regex genericNameRegex, Map<String, String> uRLStringToResultCache, String queryURL, String wikiBaseURL) {
            Intrinsics.checkNotNullParameter(genericNameRegex, "genericNameRegex");
            Intrinsics.checkNotNullParameter(uRLStringToResultCache, "uRLStringToResultCache");
            Intrinsics.checkNotNullParameter(queryURL, "queryURL");
            Intrinsics.checkNotNullParameter(wikiBaseURL, "wikiBaseURL");
            this.genericNameRegex = genericNameRegex;
            this.uRLStringToResultCache = uRLStringToResultCache;
            this.queryURL = queryURL;
            this.wikiBaseURL = wikiBaseURL;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Config(Regex regex, Map map, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            regex = (i & 1) != 0 ? Constants.INSTANCE.getToGenericNameRegex() : regex;
            if ((i & 2) != 0) {
                ExpiringMap expiringMapBuild = ExpiringMap.builder().maxSize(64).expiration(3L, TimeUnit.MINUTES).expirationPolicy(ExpirationPolicy.ACCESSED).build();
                Intrinsics.checkNotNullExpressionValue(expiringMapBuild, "build(...)");
                map = (Map) expiringMapBuild;
            }
            this(regex, map, (i & 4) != 0 ? "https://www.google.com/search?q=%s&hl=%s&tbm=isch" : str, (i & 8) != 0 ? "https://en.wikipedia.org" : str2);
        }

        public final Regex getGenericNameRegex() {
            return this.genericNameRegex;
        }

        public final Map<String, String> getURLStringToResultCache() {
            return this.uRLStringToResultCache;
        }

        public final String getQueryURL() {
            return this.queryURL;
        }

        public final String getWikiBaseURL() {
            return this.wikiBaseURL;
        }
    }
}

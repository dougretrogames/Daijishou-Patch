package com.magneticchen.daijishou.scraper.v2.impl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.scraper.v2.AbstractScraper;
import com.magneticchen.daijishou.scraper.v2.ScraperConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.eclipse.jgit.lib.ConfigConstants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

/* INFO: compiled from: BingScraper.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ.\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/magneticchen/daijishou/scraper/v2/impl/BingScraper;", "Lcom/magneticchen/daijishou/scraper/v2/AbstractScraper;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "config", "Lcom/magneticchen/daijishou/scraper/v2/ScraperConfig;", "bingConfig", "Lcom/magneticchen/daijishou/scraper/v2/impl/BingScraper$Config;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Lcom/magneticchen/daijishou/scraper/v2/ScraperConfig;Lcom/magneticchen/daijishou/scraper/v2/impl/BingScraper$Config;)V", "scrapePreviewMediaByKeywords", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemPreviewMediaIndex;", "playableItemPreviewMediaIndex", "platformName", "", "keywords", "", "path", "toGenericName", TypedValues.Custom.S_STRING, "Config", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BingScraper extends AbstractScraper {
    private final Config bingConfig;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BingScraper(DaijishouApplication application, ScraperConfig config, Config bingConfig) {
        super(application, config);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(bingConfig, "bingConfig");
        this.bingConfig = bingConfig;
    }

    public final PlayableItemPreviewMediaIndex scrapePreviewMediaByKeywords(PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex, String platformName, List<String> keywords, String path) {
        String strValueOf = "";
        Intrinsics.checkNotNullParameter(playableItemPreviewMediaIndex, "playableItemPreviewMediaIndex");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(path, "path");
        String str = path + getConfig().getBoxArtFilename();
        for (String str2 : keywords) {
            if (platformName == null) {
                try {
                    strValueOf = String.valueOf(toGenericName(str2));
                } catch (Exception e) {
                    getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                }
            } else {
                strValueOf = toGenericName(str2) + " " + platformName + " box-art";
            }
            String str3 = String.format(this.bingConfig.getQueryURL(), Arrays.copyOf(new Object[]{strValueOf}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            try {
                Element elementSelectFirst = Jsoup.connect(str3).get().selectFirst("a.iusc");
                if (elementSelectFirst != null) {
                    Element elementSelectFirst2 = Jsoup.connect(this.bingConfig.getBaseURL() + elementSelectFirst.attr("href")).get().selectFirst("div#mainImageViewer div[role=main] img");
                    if (elementSelectFirst2 != null) {
                        String strAttr = elementSelectFirst2.attr("src");
                        String str4 = strAttr;
                        if (str4 != null && !StringsKt.isBlank(str4)) {
                            Intrinsics.checkNotNull(strAttr);
                            saveURLImageToPath(strAttr, str, Constants.downloadedBoxArtImagesShortEdgeBase);
                            playableItemPreviewMediaIndex.setBoxArtPath(getConfig().getBoxArtFilename());
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            } catch (java.io.IOException e) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(e);
            }
        }
        return playableItemPreviewMediaIndex;
    }

    private final String toGenericName(String string) {
        List<String> groupValues;
        String str;
        MatchResult matchResultFind$default = Regex.find$default(this.bingConfig.getGenericNameRegex(), string, 0, 2, null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null && (str = groupValues.get(1)) != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                return new Regex("(\\s+|_+)").replace(lowerCase, " ");
            }
        }
        return null;
    }

    /* INFO: compiled from: BingScraper.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/magneticchen/daijishou/scraper/v2/impl/BingScraper$Config;", "", "genericNameRegex", "Lkotlin/text/Regex;", "queryURL", "", "baseURL", "(Lkotlin/text/Regex;Ljava/lang/String;Ljava/lang/String;)V", "getBaseURL", "()Ljava/lang/String;", "getGenericNameRegex", "()Lkotlin/text/Regex;", "getQueryURL", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Config {
        private final String baseURL;
        private final Regex genericNameRegex;
        private final String queryURL;

        public Config() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Config copy$default(Config config, Regex regex, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                regex = config.genericNameRegex;
            }
            if ((i & 2) != 0) {
                str = config.queryURL;
            }
            if ((i & 4) != 0) {
                str2 = config.baseURL;
            }
            return config.copy(regex, str, str2);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final Regex getGenericNameRegex() {
            return this.genericNameRegex;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final String getQueryURL() {
            return this.queryURL;
        }

        /* INFO: renamed from: component3, reason: from getter */
        public final String getBaseURL() {
            return this.baseURL;
        }

        public final Config copy(Regex genericNameRegex, String queryURL, String baseURL) {
            Intrinsics.checkNotNullParameter(genericNameRegex, "genericNameRegex");
            Intrinsics.checkNotNullParameter(queryURL, "queryURL");
            Intrinsics.checkNotNullParameter(baseURL, "baseURL");
            return new Config(genericNameRegex, queryURL, baseURL);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return Intrinsics.areEqual(this.genericNameRegex, config.genericNameRegex) && Intrinsics.areEqual(this.queryURL, config.queryURL) && Intrinsics.areEqual(this.baseURL, config.baseURL);
        }

        public int hashCode() {
            return (((this.genericNameRegex.hashCode() * 31) + this.queryURL.hashCode()) * 31) + this.baseURL.hashCode();
        }

        public String toString() {
            return "Config(genericNameRegex=" + this.genericNameRegex + ", queryURL=" + this.queryURL + ", baseURL=" + this.baseURL + ")";
        }

        public Config(Regex genericNameRegex, String queryURL, String baseURL) {
            Intrinsics.checkNotNullParameter(genericNameRegex, "genericNameRegex");
            Intrinsics.checkNotNullParameter(queryURL, "queryURL");
            Intrinsics.checkNotNullParameter(baseURL, "baseURL");
            this.genericNameRegex = genericNameRegex;
            this.queryURL = queryURL;
            this.baseURL = baseURL;
        }

        public /* synthetic */ Config(Regex regex, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Constants.INSTANCE.getToGenericNameRegex() : regex, (i & 2) != 0 ? "https://www.bing.com/images/search?q=%s&hl=en" : str, (i & 4) != 0 ? "https://www.bing.com" : str2);
        }



    }
}

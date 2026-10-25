package com.magneticchen.daijishou.scraper.v2.impl;

import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.scraper.v2.AbstractScraper;
import com.magneticchen.daijishou.scraper.v2.ScraperConfig;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.lib.ConfigConstants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: ArcadeItaliaScraper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fJ\u0010\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\nJ$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u0012\u001a\u00020\nJ\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u000e\u001a\u00020\nJ\u0016\u0010\u0014\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/magneticchen/daijishou/scraper/v2/impl/ArcadeItaliaScraper;", "Lcom/magneticchen/daijishou/scraper/v2/AbstractScraper;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "config", "Lcom/magneticchen/daijishou/scraper/v2/ScraperConfig;", "arcadeItaliaConfig", "Lcom/magneticchen/daijishou/scraper/v2/impl/ArcadeItaliaScraper$Config;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Lcom/magneticchen/daijishou/scraper/v2/ScraperConfig;Lcom/magneticchen/daijishou/scraper/v2/impl/ArcadeItaliaScraper$Config;)V", "scrapeDescriptionByKeywords", "", "keywords", "", "scrapeNameByName", "name", "scrapePreviewMediaByKeywords", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemPreviewMediaIndex;", "playableItemPreviewMediaIndex", "path", "scrapeScraperKeywordsByName", "scrapeYoutubeVideoIdByKeywords", "Config", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ArcadeItaliaScraper extends AbstractScraper {
    private final Config arcadeItaliaConfig;

    public /* synthetic */ ArcadeItaliaScraper(DaijishouApplication daijishouApplication, ScraperConfig scraperConfig, Config config, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(daijishouApplication, scraperConfig, (i & 4) != 0 ? new Config(null, null, null, null, null, null, 63, null) : config);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArcadeItaliaScraper(DaijishouApplication application, ScraperConfig config, Config arcadeItaliaConfig) {
        super(application, config);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(arcadeItaliaConfig, "arcadeItaliaConfig");
        this.arcadeItaliaConfig = arcadeItaliaConfig;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x018e  */
    public final PlayableItemPreviewMediaIndex scrapePreviewMediaByKeywords(PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex, List<String> keywords, String path) {
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(playableItemPreviewMediaIndex, "playableItemPreviewMediaIndex");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(path, "path");
        if (!hasAllMedia(playableItemPreviewMediaIndex)) {
            String str5 = path + getConfig().getSnapshotFilename();
            String str6 = path + getConfig().getBoxArtFilename();
            String str7 = path + getConfig().getTitleFilename();
            Iterator<String> it = keywords.iterator();
            while (it.hasNext()) {
                try {
                    String strEncode = URLEncoder.encode(it.next(), "UTF-8");
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str8 = String.format(this.arcadeItaliaConfig.getBaseUrl(), Arrays.copyOf(new Object[]{strEncode}, 1));
                    Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                    Document document = Jsoup.connect(str8).get();
                    if (playableItemPreviewMediaIndex.getBoxArtPath() == null) {
                        try {
                            Element elementSelectFirst = document.selectFirst("li[data-custom-tag=" + this.arcadeItaliaConfig.getBoxArtTag() + CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
                            if (elementSelectFirst != null) {
                                Element elementSelectFirst2 = elementSelectFirst.selectFirst("img");
                                String strAbsUrl = elementSelectFirst2 != null ? elementSelectFirst2.absUrl("src") : null;
                                if (strAbsUrl != null) {
                                    saveURLImageToPath(StringsKt.replace$default(strAbsUrl, "small/", "", false, 4, (Object) null), str6, Constants.downloadedBoxArtImagesShortEdgeBase);
                                    playableItemPreviewMediaIndex.setBoxArtPath(getConfig().getBoxArtFilename());
                                }
                            }
                        } catch (Exception e) {
                            getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                        }
                    }
                    if (playableItemPreviewMediaIndex.getSnapshotPath() != null) {
                        try {
                            Element elementSelectFirst3 = document.selectFirst("li[data-custom-tag=" + this.arcadeItaliaConfig.getSnapshotTag() + CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
                            if (elementSelectFirst3 == null) {
                                str = str6;
                                str3 = CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
                                str4 = "li[data-custom-tag=";
                            } else {
                                Element elementSelectFirst4 = elementSelectFirst3.selectFirst("img");
                                String strAbsUrl2 = elementSelectFirst4 != null ? elementSelectFirst4.absUrl("src") : null;
                                if (strAbsUrl2 != null) {
                                    try {
                                        ArcadeItaliaScraper arcadeItaliaScraper = this;
                                        String strReplace$default = StringsKt.replace$default(strAbsUrl2, "small/", "", false, 4, (Object) null);
                                        str3 = CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
                                        str = str6;
                                        str4 = "li[data-custom-tag=";
                                        try {
                                            AbstractScraper.saveURLImageToPath$default(arcadeItaliaScraper, strReplace$default, str5, 0, 4, null);
                                            playableItemPreviewMediaIndex.setSnapshotPath(getConfig().getSnapshotFilename());
                                        } catch (Exception e2) {
                                            Exception e = null;
                                            e = e2;
                                            getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                                        }
                                    } catch (Exception e3) {
                                        Exception e = e3;
                                        str = str6;
                                        str4 = "li[data-custom-tag=";
                                        str3 = CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
                                    }
                                } else {
                                    str = str6;
                                    str3 = CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
                                    str4 = "li[data-custom-tag=";
                                }
                            }
                        } catch (Exception e4) {
                            Exception e = e4;
                            str = str6;
                            str3 = CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
                            str4 = "li[data-custom-tag=";
                        }
                    } else {
                        str = str6;
                        str3 = CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
                        str4 = "li[data-custom-tag=";
                    }
                    try {
                        if (playableItemPreviewMediaIndex.getTitlePath() != null) {
                            try {
                                Element elementSelectFirst5 = document.selectFirst(str4 + this.arcadeItaliaConfig.getTitleTag() + str3);
                                if (elementSelectFirst5 != null) {
                                    Element elementSelectFirst6 = elementSelectFirst5.selectFirst("img");
                                    String strAbsUrl3 = elementSelectFirst6 != null ? elementSelectFirst6.absUrl("src") : null;
                                    if (strAbsUrl3 != null) {
                                        str2 = str7;
                                        try {
                                            AbstractScraper.saveURLImageToPath$default(this, StringsKt.replace$default(strAbsUrl3, "small/", "", false, 4, (Object) null), str2, 0, 4, null);
                                            playableItemPreviewMediaIndex.setTitlePath(getConfig().getTitleFilename());
                                        } catch (Exception e5) {
                                            Exception e = e5;
                                            try {
                                                getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                                            } catch (Exception e6) {
                                                getLogger().warn(this, ExceptionsKt.stackTraceToString(e6));
                                            }
                                        }
                                        str7 = str2;
                                    }
                                }
                            } catch (Exception e7) {
                                Exception e = e7;
                                str2 = str7;
                            }
                        }
                    } catch (Exception e8) {
                        Exception e = e8;
                        str2 = str7;
                        getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                        str7 = str2;
                        str6 = str;
                    }
                } catch (Exception e9) {
                    Exception e = e9;
                    str = str6;
                }
                str6 = str;
            }
        }
        return playableItemPreviewMediaIndex;
    }

    public final String scrapeYoutubeVideoIdByKeywords(List<String> keywords) {
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Iterator<String> it = keywords.iterator();
        while (true) {
            if (!it.hasNext()) {
                return null;
            }
            String next = it.next();
            try {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format(this.arcadeItaliaConfig.getBaseUrl(), Arrays.copyOf(new Object[]{next}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                Element elementSelectFirst = Jsoup.connect(str).get().selectFirst(".elenco_video");
                if (elementSelectFirst != null) {
                    Regex youtubeVideoIdRegex = this.arcadeItaliaConfig.getYoutubeVideoIdRegex();
                    String strAbsUrl = elementSelectFirst.absUrl("data-custom-src");
                    Intrinsics.checkNotNullExpressionValue(strAbsUrl, "absUrl(...)");
                    MatchResult matchResultFind$default = Regex.find$default(youtubeVideoIdRegex, strAbsUrl, 0, 2, null);
                    List<String> groupValues = matchResultFind$default != null ? matchResultFind$default.getGroupValues() : null;
                    if (groupValues != null) {
                        return groupValues.get(1);
                    }
                    continue;
                } else {
                    continue;
                }
            } catch (Exception e) {
                getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
            }
        }
    }

    public final String scrapeNameByName(String name) {
        Element elementParent;
        Element elementSelectFirst;
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(this.arcadeItaliaConfig.getBaseUrl(), Arrays.copyOf(new Object[]{name}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            Element elementSelectFirst2 = Jsoup.connect(str).get().selectFirst(".romset_name");
            if (elementSelectFirst2 == null || (elementParent = elementSelectFirst2.parent()) == null || (elementSelectFirst = elementParent.selectFirst(".dettaglio")) == null) {
                return null;
            }
            return elementSelectFirst.text();
        } catch (Exception e) {
            getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
        }
        return null;
    }

    public final List<String> scrapeScraperKeywordsByName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ArrayList();
    }

    public final String scrapeDescriptionByKeywords(List<String> keywords) {
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Iterator<String> it = keywords.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format(this.arcadeItaliaConfig.getBaseUrl(), Arrays.copyOf(new Object[]{next}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                Element elementSelectFirst = Jsoup.connect(str).get().selectFirst("#history_detail");
                if (elementSelectFirst != null) {
                    return elementSelectFirst.html();
                }
                continue;
            } catch (Exception e) {
                getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: ArcadeItaliaScraper.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006 "}, d2 = {"Lcom/magneticchen/daijishou/scraper/v2/impl/ArcadeItaliaScraper$Config;", "", "baseUrl", "", "genericNameRegex", "Lkotlin/text/Regex;", "boxArtTag", "snapshotTag", "titleTag", "youtubeVideoIdRegex", "(Ljava/lang/String;Lkotlin/text/Regex;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/text/Regex;)V", "getBaseUrl", "()Ljava/lang/String;", "getBoxArtTag", "getGenericNameRegex", "()Lkotlin/text/Regex;", "getSnapshotTag", "getTitleTag", "getYoutubeVideoIdRegex", "component1", "component2", "component3", "component4", "component5", "component6", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Config {
        private final String baseUrl;
        private final String boxArtTag;
        private final Regex genericNameRegex;
        private final String snapshotTag;
        private final String titleTag;
        private final Regex youtubeVideoIdRegex;

        public Config() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ Config copy$default(Config config, String str, Regex regex, String str2, String str3, String str4, Regex regex2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = config.baseUrl;
            }
            if ((i & 2) != 0) {
                regex = config.genericNameRegex;
            }
            if ((i & 4) != 0) {
                str2 = config.boxArtTag;
            }
            if ((i & 8) != 0) {
                str3 = config.snapshotTag;
            }
            if ((i & 16) != 0) {
                str4 = config.titleTag;
            }
            if ((i & 32) != 0) {
                regex2 = config.youtubeVideoIdRegex;
            }
            String str5 = str4;
            Regex regex3 = regex2;
            return config.copy(str, regex, str2, str3, str5, regex3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getBaseUrl() {
            return this.baseUrl;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Regex getGenericNameRegex() {
            return this.genericNameRegex;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getBoxArtTag() {
            return this.boxArtTag;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSnapshotTag() {
            return this.snapshotTag;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getTitleTag() {
            return this.titleTag;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Regex getYoutubeVideoIdRegex() {
            return this.youtubeVideoIdRegex;
        }

        public final Config copy(String baseUrl, Regex genericNameRegex, String boxArtTag, String snapshotTag, String titleTag, Regex youtubeVideoIdRegex) {
            Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
            Intrinsics.checkNotNullParameter(genericNameRegex, "genericNameRegex");
            Intrinsics.checkNotNullParameter(boxArtTag, "boxArtTag");
            Intrinsics.checkNotNullParameter(snapshotTag, "snapshotTag");
            Intrinsics.checkNotNullParameter(titleTag, "titleTag");
            Intrinsics.checkNotNullParameter(youtubeVideoIdRegex, "youtubeVideoIdRegex");
            return new Config(baseUrl, genericNameRegex, boxArtTag, snapshotTag, titleTag, youtubeVideoIdRegex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return Intrinsics.areEqual(this.baseUrl, config.baseUrl) && Intrinsics.areEqual(this.genericNameRegex, config.genericNameRegex) && Intrinsics.areEqual(this.boxArtTag, config.boxArtTag) && Intrinsics.areEqual(this.snapshotTag, config.snapshotTag) && Intrinsics.areEqual(this.titleTag, config.titleTag) && Intrinsics.areEqual(this.youtubeVideoIdRegex, config.youtubeVideoIdRegex);
        }

        public int hashCode() {
            return (((((((((this.baseUrl.hashCode() * 31) + this.genericNameRegex.hashCode()) * 31) + this.boxArtTag.hashCode()) * 31) + this.snapshotTag.hashCode()) * 31) + this.titleTag.hashCode()) * 31) + this.youtubeVideoIdRegex.hashCode();
        }

        public String toString() {
            return "Config(baseUrl=" + this.baseUrl + ", genericNameRegex=" + this.genericNameRegex + ", boxArtTag=" + this.boxArtTag + ", snapshotTag=" + this.snapshotTag + ", titleTag=" + this.titleTag + ", youtubeVideoIdRegex=" + this.youtubeVideoIdRegex + ")";
        }

        public Config(String baseUrl, Regex genericNameRegex, String boxArtTag, String snapshotTag, String titleTag, Regex youtubeVideoIdRegex) {
            Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
            Intrinsics.checkNotNullParameter(genericNameRegex, "genericNameRegex");
            Intrinsics.checkNotNullParameter(boxArtTag, "boxArtTag");
            Intrinsics.checkNotNullParameter(snapshotTag, "snapshotTag");
            Intrinsics.checkNotNullParameter(titleTag, "titleTag");
            Intrinsics.checkNotNullParameter(youtubeVideoIdRegex, "youtubeVideoIdRegex");
            this.baseUrl = baseUrl;
            this.genericNameRegex = genericNameRegex;
            this.boxArtTag = boxArtTag;
            this.snapshotTag = snapshotTag;
            this.titleTag = titleTag;
            this.youtubeVideoIdRegex = youtubeVideoIdRegex;
        }

        public /* synthetic */ Config(String str, Regex regex, String str2, String str3, String str4, Regex regex2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "http://adb.arcadeitalia.net/dettaglio_mame.php?game_name=%s&arcade_only=0&autosearch=1" : str, (i & 2) != 0 ? Constants.INSTANCE.getToGenericNameRegex() : regex, (i & 4) != 0 ? "Flyer-0" : str2, (i & 8) != 0 ? "Game-0" : str3, (i & 16) != 0 ? "Title-0" : str4, (i & 32) != 0 ? new Regex("^.*youtube\\.com.*/([^/|?]*).*") : regex2);
        }






    }
}

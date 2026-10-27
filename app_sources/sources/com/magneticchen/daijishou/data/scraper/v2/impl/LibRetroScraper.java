package com.magneticchen.daijishou.data.scraper.v2.impl;

import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.data.scraper.v2.AbstractScraper;
import com.magneticchen.daijishou.data.scraper.v2.ScraperConfig;
import com.magneticchen.daijishou.utils.ScraperUtilsKt;
import com.magneticchen.daijishou.utils.Utils;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: LibRetroScraper.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\u00020\u0001:\u0003#$%B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u001c\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\f2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J.\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J.\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J,\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c2\u0006\u0010\u001d\u001a\u00020\u000bJ\u0012\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\r\u001a6\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\f0\u000ej\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\f`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/LibRetroScraper;", "Lcom/magneticchen/daijishou/data/scraper/v2/AbstractScraper;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "config", "Lcom/magneticchen/daijishou/data/scraper/v2/ScraperConfig;", "libRetroConfig", "Lcom/magneticchen/daijishou/data/scraper/v2/impl/LibRetroScraper$Config;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Lcom/magneticchen/daijishou/data/scraper/v2/ScraperConfig;Lcom/magneticchen/daijishou/data/scraper/v2/impl/LibRetroScraper$Config;)V", "normalNameCache", "Lcom/magneticchen/daijishou/utils/Utils$MaxSizeHashMap;", "", "", "strictNameCache", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getResourceLinksBaseUrlGithub", "Lcom/magneticchen/daijishou/data/scraper/v2/impl/LibRetroScraper$ResourceLinks;", "systemName", "getResourceLinksBaseUrlWebsite", "resolveSystem", "resolveSystemBaseUrlGithub", "Lcom/magneticchen/daijishou/data/scraper/v2/impl/LibRetroScraper$Resolved;", "resolveSystemBaseUrlWebsite", "scrapeByKeywordsBaseUrlGithub", "Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;", "playableItemPreviewMediaIndex", "keywords", "", "path", "scrapeByKeywordsBaseUrlWebsite", "scrapePreviewMediaByKeywords", "toGenericName", "string", "toStrictGenericName", "Config", "Resolved", "ResourceLinks", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LibRetroScraper extends AbstractScraper {
    private final Config libRetroConfig;
    private final Utils.MaxSizeHashMap<String, Map<String, String>> normalNameCache;
    private final HashMap<String, Map<String, String>> strictNameCache;

    public /* synthetic */ LibRetroScraper(DaijishouApplication daijishouApplication, ScraperConfig scraperConfig, Config config, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            config = new Config(null, null, null, null, null, null, null, null, 255, null);
        }
        this(daijishouApplication, scraperConfig, config);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibRetroScraper(DaijishouApplication application, ScraperConfig config, Config libRetroConfig) {
        super(application, config);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(libRetroConfig, "libRetroConfig");
        this.libRetroConfig = libRetroConfig;
        this.normalNameCache = new Utils.MaxSizeHashMap<>(4);
        this.strictNameCache = new Utils.MaxSizeHashMap(4);
    }

    public final PlayableItemPreviewMediaIndex scrapePreviewMediaByKeywords(PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex, String systemName, List<String> keywords, String path) {
        Intrinsics.checkNotNullParameter(playableItemPreviewMediaIndex, "playableItemPreviewMediaIndex");
        Intrinsics.checkNotNullParameter(systemName, "systemName");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(path, "path");
        if (!resolveSystem(systemName).isEmpty()) {
            getLogger().info(this, "Successfully cached " + systemName + " from LibRetro.");
        }
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndexScrapeByKeywordsBaseUrlWebsite = scrapeByKeywordsBaseUrlWebsite(playableItemPreviewMediaIndex, systemName, keywords, path);
        return ScraperUtilsKt.hasAnyMedia(playableItemPreviewMediaIndexScrapeByKeywordsBaseUrlWebsite) ? playableItemPreviewMediaIndexScrapeByKeywordsBaseUrlWebsite : scrapeByKeywordsBaseUrlGithub(playableItemPreviewMediaIndexScrapeByKeywordsBaseUrlWebsite, systemName, keywords, path);
    }

    private final PlayableItemPreviewMediaIndex scrapeByKeywordsBaseUrlGithub(PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex, String str, List<String> list, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        ResourceLinks resourceLinksBaseUrlGithub = getResourceLinksBaseUrlGithub(str);
        String str7 = str2 + getConfig().getBoxArtFilename();
        String str8 = str2 + getConfig().getSnapshotFilename();
        String str9 = str2 + getConfig().getTitleFilename();
        for (String str10 : list) {
            Map<String, String> map = this.normalNameCache.get(str);
            if (map == null || (str4 = map.get(toGenericName(str10))) == null) {
                str3 = str9;
                str9 = str3;
            } else {
                if (playableItemPreviewMediaIndex.getBoxArtPath() == null) {
                    try {
                        AbstractScraper.saveURLImageToPath$default(this, resourceLinksBaseUrlGithub.getBoxArtURL() + str4 + ".png", str7, 0, 4, null);
                        playableItemPreviewMediaIndex.setBoxArtPath(getConfig().getBoxArtFilename());
                    } catch (Exception e) {
                        getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                    }
                }
                if (playableItemPreviewMediaIndex.getSnapshotPath() == null) {
                    try {
                        str6 = ".png";
                        str5 = str4;
                        String str11 = str8;
                        try {
                            AbstractScraper.saveURLImageToPath$default(this, resourceLinksBaseUrlGithub.getSnapshotURL() + str4 + ".png", str11, 0, 4, null);
                            try {
                                playableItemPreviewMediaIndex.setSnapshotPath(getConfig().getSnapshotFilename());
                            } catch (Exception e2) {
                                e = e2;
                                getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str8 = str11;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str5 = str4;
                        str6 = ".png";
                    }
                } else {
                    str5 = str4;
                    str6 = ".png";
                }
                if (playableItemPreviewMediaIndex.getTitlePath() == null) {
                    try {
                        str3 = str9;
                        try {
                            AbstractScraper.saveURLImageToPath$default(this, resourceLinksBaseUrlGithub.getTitleURL() + str5 + str6, str3, 0, 4, null);
                            playableItemPreviewMediaIndex.setTitlePath(getConfig().getTitleFilename());
                        } catch (Exception e5) {
                            e = e5;
                            getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                        }
                    } catch (Exception e6) {
                        e = e6;
                        str3 = str9;
                    }
                    str9 = str3;
                }
            }
        }
        String str12 = str9;
        if (ScraperUtilsKt.hasAnyMedia(playableItemPreviewMediaIndex)) {
            return playableItemPreviewMediaIndex;
        }
        new File(str7).delete();
        new File(str8).delete();
        new File(str12).delete();
        return playableItemPreviewMediaIndex;
    }

    private final PlayableItemPreviewMediaIndex scrapeByKeywordsBaseUrlWebsite(PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex, String str, List<String> list, String str2) {
        String str3;
        if (!resolveSystem(str).isEmpty()) {
            getLogger().info(this, "Successfully cached " + str + " from LibRetro.");
        }
        ResourceLinks resourceLinksBaseUrlWebsite = getResourceLinksBaseUrlWebsite(str);
        String str4 = str2 + getConfig().getSnapshotFilename();
        String str5 = str2 + getConfig().getBoxArtFilename();
        String str6 = str2 + getConfig().getTitleFilename();
        for (String str7 : list) {
            Map<String, String> map = this.normalNameCache.get(str);
            if (map != null && (str3 = map.get(toGenericName(str7))) != null) {
                Map<String, String> map2 = this.strictNameCache.get(str);
                String str8 = map2 != null ? map2.get(toStrictGenericName(str7)) : null;
                if (playableItemPreviewMediaIndex.getBoxArtPath() == null) {
                    if (str8 == null) {
                        throw new IOException("Next step.");
                    }
                    try {
                        saveURLImageToPath(resourceLinksBaseUrlWebsite.getBoxArtURL() + str8 + ".png", str5, Constants.downloadedBoxArtImagesShortEdgeBase);
                        playableItemPreviewMediaIndex.setBoxArtPath(getConfig().getBoxArtFilename());
                    } catch (Exception e) {
                        getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                        saveURLImageToPath(resourceLinksBaseUrlWebsite.getBoxArtURL() + str3 + ".png", str5, Constants.downloadedBoxArtImagesShortEdgeBase);
                        playableItemPreviewMediaIndex.setBoxArtPath(getConfig().getBoxArtFilename());
                    }
                    getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                    try {
                        saveURLImageToPath(resourceLinksBaseUrlWebsite.getBoxArtURL() + str3 + ".png", str5, Constants.downloadedBoxArtImagesShortEdgeBase);
                        playableItemPreviewMediaIndex.setBoxArtPath(getConfig().getBoxArtFilename());
                    } catch (Exception e2) {
                        getLogger().warn(this, ExceptionsKt.stackTraceToString(e2));
                    }
                }
                if (playableItemPreviewMediaIndex.getSnapshotPath() == null) {
                    if (str8 == null) {
                        throw new IOException("Next step.");
                    }
                    try {
                        saveURLImageToPath(resourceLinksBaseUrlWebsite.getSnapshotURL() + str8 + ".png", str4, Constants.downloadedBoxArtImagesShortEdgeBase);
                        playableItemPreviewMediaIndex.setSnapshotPath(getConfig().getSnapshotFilename());
                    } catch (Exception e3) {
                        getLogger().warn(this, ExceptionsKt.stackTraceToString(e3));
                        saveURLImageToPath(resourceLinksBaseUrlWebsite.getSnapshotURL() + str3 + ".png", str4, Constants.downloadedBoxArtImagesShortEdgeBase);
                        playableItemPreviewMediaIndex.setSnapshotPath(getConfig().getSnapshotFilename());
                    }
                    getLogger().warn(this, ExceptionsKt.stackTraceToString(e3));
                    try {
                        saveURLImageToPath(resourceLinksBaseUrlWebsite.getSnapshotURL() + str3 + ".png", str4, Constants.downloadedBoxArtImagesShortEdgeBase);
                        playableItemPreviewMediaIndex.setSnapshotPath(getConfig().getSnapshotFilename());
                    } catch (Exception e4) {
                        getLogger().warn(this, ExceptionsKt.stackTraceToString(e4));
                    }
                }
                if (playableItemPreviewMediaIndex.getTitlePath() != null) {
                    continue;
                } else {
                    if (str8 == null) {
                        throw new IOException("Next step.");
                    }
                    try {
                        saveURLImageToPath(resourceLinksBaseUrlWebsite.getTitleURL() + str8 + ".png", str6, Constants.downloadedBoxArtImagesShortEdgeBase);
                        playableItemPreviewMediaIndex.setTitlePath(getConfig().getTitleFilename());
                    } catch (Exception e5) {
                        getLogger().warn(this, ExceptionsKt.stackTraceToString(e5));
                        saveURLImageToPath(resourceLinksBaseUrlWebsite.getTitleURL() + str3 + ".png", str6, Constants.downloadedBoxArtImagesShortEdgeBase);
                        playableItemPreviewMediaIndex.setTitlePath(getConfig().getTitleFilename());
                    }
                    getLogger().warn(this, ExceptionsKt.stackTraceToString(e5));
                    try {
                        saveURLImageToPath(resourceLinksBaseUrlWebsite.getTitleURL() + str3 + ".png", str6, Constants.downloadedBoxArtImagesShortEdgeBase);
                        playableItemPreviewMediaIndex.setTitlePath(getConfig().getTitleFilename());
                    } catch (Exception e6) {
                        getLogger().warn(this, ExceptionsKt.stackTraceToString(e6));
                    }
                }
            }
        }
        return playableItemPreviewMediaIndex;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<String, String> resolveSystem(String str) {
        Map<String, String> map = this.normalNameCache.get(str);
        if (map != null) {
            return map;
        }
        Resolved resolvedResolveSystemBaseUrlGithub = resolveSystemBaseUrlGithub(str);
        int i = 3;
        Map map2 = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        if (resolvedResolveSystemBaseUrlGithub == null) {
            resolvedResolveSystemBaseUrlGithub = new Resolved(map2, objArr5 == true ? 1 : 0, i, objArr4 == true ? 1 : 0);
        }
        Resolved resolvedResolveSystemBaseUrlWebsite = resolveSystemBaseUrlWebsite(str);
        if (resolvedResolveSystemBaseUrlWebsite == null) {
            resolvedResolveSystemBaseUrlWebsite = new Resolved(objArr3 == true ? 1 : 0, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
        }
        Map<String, String> mapPlus = MapsKt.plus(resolvedResolveSystemBaseUrlWebsite.getStrict(), resolvedResolveSystemBaseUrlGithub.getStrict());
        Map<String, String> mapPlus2 = MapsKt.plus(resolvedResolveSystemBaseUrlWebsite.getNormal(), resolvedResolveSystemBaseUrlGithub.getNormal());
        this.normalNameCache.put(str, mapPlus2);
        this.strictNameCache.put(str, mapPlus);
        return mapPlus2;
    }

    private final Resolved resolveSystemBaseUrlWebsite(String str) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            ResourceLinks resourceLinksBaseUrlWebsite = getResourceLinksBaseUrlWebsite(str);
            Iterator it = CollectionsKt.flatten(CollectionsKt.listOf((Object[]) new Elements[]{Jsoup.connect(resourceLinksBaseUrlWebsite.getBoxArtURL()).maxBodySize(0).get().select("a"), Jsoup.connect(resourceLinksBaseUrlWebsite.getSnapshotURL()).maxBodySize(0).get().select("a"), Jsoup.connect(resourceLinksBaseUrlWebsite.getTitleURL()).maxBodySize(0).get().select("a")})).iterator();
            while (it.hasNext()) {
                String strAttr = ((Element) it.next()).attr("href");
                Intrinsics.checkNotNullExpressionValue(strAttr, "attr(...)");
                String str2 = (String) StringsKt.split$default((CharSequence) strAttr, new String[]{".png"}, false, 0, 6, (Object) null).get(0);
                String strDecode = URLDecoder.decode(str2, "UTF-8");
                Intrinsics.checkNotNullExpressionValue(strDecode, "decode(...)");
                String genericName = toGenericName(strDecode);
                String strDecode2 = URLDecoder.decode(str2, "UTF-8");
                Intrinsics.checkNotNullExpressionValue(strDecode2, "decode(...)");
                String strictGenericName = toStrictGenericName(strDecode2);
                if (genericName != null && !map2.containsKey(genericName)) {
                    map2.put(genericName, str2);
                }
                if (strictGenericName != null && !map.containsKey(strictGenericName)) {
                    map.put(strictGenericName, str2);
                }
            }
            return new Resolved(map, map2);
        } catch (Exception e) {
            getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
            return null;
        }
    }

    private final Resolved resolveSystemBaseUrlGithub(String str) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            ResourceLinks resourceLinksBaseUrlGithub = getResourceLinksBaseUrlGithub(str);
            Iterator it = CollectionsKt.flatten(CollectionsKt.listOf((Object[]) new Elements[]{Jsoup.connect(resourceLinksBaseUrlGithub.getBoxArtURL()).get().select("div.Details > div[role=grid] div[role=row] a.Link--primary"), Jsoup.connect(resourceLinksBaseUrlGithub.getSnapshotURL()).get().select("div.Details > div[role=grid] div[role=row] a.Link--primary"), Jsoup.connect(resourceLinksBaseUrlGithub.getTitleURL()).get().select("div.Details > div[role=grid] div[role=row] a.Link--primary")})).iterator();
            while (it.hasNext()) {
                try {
                    String strAttr = ((Element) it.next()).attr("title");
                    Intrinsics.checkNotNullExpressionValue(strAttr, "attr(...)");
                    String str2 = (String) StringsKt.split$default((CharSequence) strAttr, new String[]{".png"}, false, 0, 6, (Object) null).get(0);
                    String genericName = toGenericName(str2);
                    if (genericName != null && !map2.containsKey(genericName)) {
                        map2.put(genericName, str2);
                    }
                    String strDecode = URLDecoder.decode(str2, "UTF-8");
                    Intrinsics.checkNotNullExpressionValue(strDecode, "decode(...)");
                    String strictGenericName = toStrictGenericName(strDecode);
                    if (strictGenericName != null && !map.containsKey(strictGenericName)) {
                        map.put(strictGenericName, str2);
                    }
                } catch (Exception e) {
                    getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                }
            }
            return new Resolved(map, map2);
        } catch (Exception e2) {
            getLogger().warn(this, ExceptionsKt.stackTraceToString(e2));
            return null;
        }
    }

    private final ResourceLinks getResourceLinksBaseUrlGithub(String str) {
        String str2 = this.libRetroConfig.getBaseUrlGithubIndex() + StringsKt.replace$default(str, " ", "_", false, 4, (Object) null) + "/tree/master/";
        return new ResourceLinks(str2, str2 + this.libRetroConfig.getBoxArtsPath() + "/", str2 + this.libRetroConfig.getSnapshotsPath() + "/", str2 + this.libRetroConfig.getTitlesPath());
    }

    private final ResourceLinks getResourceLinksBaseUrlWebsite(String str) {
        String str2 = this.libRetroConfig.getBaseUrlWebsite() + str + "/";
        return new ResourceLinks(str2, str2 + this.libRetroConfig.getBoxArtsPath() + "/", str2 + this.libRetroConfig.getSnapshotsPath() + "/", str2 + this.libRetroConfig.getTitlesPath() + "/");
    }

    private final String toGenericName(String str) {
        List<String> groupValues;
        String str2;
        MatchResult matchResultFind$default = Regex.find$default(this.libRetroConfig.getGenericNameRegex(), str, 0, 2, null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null && (str2 = groupValues.get(1)) != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str2.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                String strReplace = new Regex("\\s*-\\s+Disc\\s+\\d+\\s*", RegexOption.IGNORE_CASE).replace(lowerCase, "");
                if (strReplace != null) {
                    String strReplace2 = new Regex("(\\s+|_+)").replace(strReplace, " ");
                    if (strReplace2 != null) {
                        return new Regex("[^0-9a-zA-Z]+").replace(strReplace2, "");
                    }
                }
            }
        }
        return null;
    }

    private final String toStrictGenericName(String str) {
        return new Regex("[^0-9a-zA-Z]+").replace(str, "");
    }

    /* JADX INFO: compiled from: LibRetroScraper.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J5\u0010\f\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/LibRetroScraper$Resolved;", "", "strict", "", "", "normal", "(Ljava/util/Map;Ljava/util/Map;)V", "getNormal", "()Ljava/util/Map;", "getStrict", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Resolved {
        private final Map<String, String> normal;
        private final Map<String, String> strict;

        /* JADX WARN: Multi-variable type inference failed */
        public Resolved() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Resolved copy$default(Resolved resolved, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                map = resolved.strict;
            }
            if ((i & 2) != 0) {
                map2 = resolved.normal;
            }
            return resolved.copy(map, map2);
        }

        public final Map<String, String> component1() {
            return this.strict;
        }

        public final Map<String, String> component2() {
            return this.normal;
        }

        public final Resolved copy(Map<String, String> strict, Map<String, String> normal) {
            Intrinsics.checkNotNullParameter(strict, "strict");
            Intrinsics.checkNotNullParameter(normal, "normal");
            return new Resolved(strict, normal);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Resolved)) {
                return false;
            }
            Resolved resolved = (Resolved) obj;
            return Intrinsics.areEqual(this.strict, resolved.strict) && Intrinsics.areEqual(this.normal, resolved.normal);
        }

        public int hashCode() {
            return (this.strict.hashCode() * 31) + this.normal.hashCode();
        }

        public String toString() {
            return "Resolved(strict=" + this.strict + ", normal=" + this.normal + ")";
        }

        public Resolved(Map<String, String> strict, Map<String, String> normal) {
            Intrinsics.checkNotNullParameter(strict, "strict");
            Intrinsics.checkNotNullParameter(normal, "normal");
            this.strict = strict;
            this.normal = normal;
        }

        public /* synthetic */ Resolved(HashMap map, HashMap map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new HashMap() : map, (i & 2) != 0 ? new HashMap() : map2);
        }

        public final Map<String, String> getStrict() {
            return this.strict;
        }

        public final Map<String, String> getNormal() {
            return this.normal;
        }
    }

    /* JADX INFO: compiled from: LibRetroScraper.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/LibRetroScraper$ResourceLinks;", "", "baseURL", "", "boxArtURL", "snapshotURL", "titleURL", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBaseURL", "()Ljava/lang/String;", "getBoxArtURL", "getSnapshotURL", "getTitleURL", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResourceLinks {
        private final String baseURL;
        private final String boxArtURL;
        private final String snapshotURL;
        private final String titleURL;

        public static /* synthetic */ ResourceLinks copy$default(ResourceLinks resourceLinks, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = resourceLinks.baseURL;
            }
            if ((i & 2) != 0) {
                str2 = resourceLinks.boxArtURL;
            }
            if ((i & 4) != 0) {
                str3 = resourceLinks.snapshotURL;
            }
            if ((i & 8) != 0) {
                str4 = resourceLinks.titleURL;
            }
            return resourceLinks.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.baseURL;
        }

        public final String component2() {
            return this.boxArtURL;
        }

        public final String component3() {
            return this.snapshotURL;
        }

        public final String component4() {
            return this.titleURL;
        }

        public final ResourceLinks copy(String baseURL, String boxArtURL, String snapshotURL, String titleURL) {
            Intrinsics.checkNotNullParameter(baseURL, "baseURL");
            Intrinsics.checkNotNullParameter(boxArtURL, "boxArtURL");
            Intrinsics.checkNotNullParameter(snapshotURL, "snapshotURL");
            Intrinsics.checkNotNullParameter(titleURL, "titleURL");
            return new ResourceLinks(baseURL, boxArtURL, snapshotURL, titleURL);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResourceLinks)) {
                return false;
            }
            ResourceLinks resourceLinks = (ResourceLinks) obj;
            return Intrinsics.areEqual(this.baseURL, resourceLinks.baseURL) && Intrinsics.areEqual(this.boxArtURL, resourceLinks.boxArtURL) && Intrinsics.areEqual(this.snapshotURL, resourceLinks.snapshotURL) && Intrinsics.areEqual(this.titleURL, resourceLinks.titleURL);
        }

        public int hashCode() {
            return (((((this.baseURL.hashCode() * 31) + this.boxArtURL.hashCode()) * 31) + this.snapshotURL.hashCode()) * 31) + this.titleURL.hashCode();
        }

        public String toString() {
            return "ResourceLinks(baseURL=" + this.baseURL + ", boxArtURL=" + this.boxArtURL + ", snapshotURL=" + this.snapshotURL + ", titleURL=" + this.titleURL + ")";
        }

        public ResourceLinks(String baseURL, String boxArtURL, String snapshotURL, String titleURL) {
            Intrinsics.checkNotNullParameter(baseURL, "baseURL");
            Intrinsics.checkNotNullParameter(boxArtURL, "boxArtURL");
            Intrinsics.checkNotNullParameter(snapshotURL, "snapshotURL");
            Intrinsics.checkNotNullParameter(titleURL, "titleURL");
            this.baseURL = baseURL;
            this.boxArtURL = boxArtURL;
            this.snapshotURL = snapshotURL;
            this.titleURL = titleURL;
        }

        public final String getBaseURL() {
            return this.baseURL;
        }

        public final String getBoxArtURL() {
            return this.boxArtURL;
        }

        public final String getSnapshotURL() {
            return this.snapshotURL;
        }

        public final String getTitleURL() {
            return this.titleURL;
        }
    }

    /* JADX INFO: compiled from: LibRetroScraper.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006&"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/LibRetroScraper$Config;", "", "boxArtsPath", "", "snapshotsPath", "titlesPath", "baseUrlWebsite", "baseUrlGithub", "baseUrlGithubIndex", "genericNameRegex", "Lkotlin/text/Regex;", "strictGenericNameRegex", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/text/Regex;Lkotlin/text/Regex;)V", "getBaseUrlGithub", "()Ljava/lang/String;", "getBaseUrlGithubIndex", "getBaseUrlWebsite", "getBoxArtsPath", "getGenericNameRegex", "()Lkotlin/text/Regex;", "getSnapshotsPath", "getStrictGenericNameRegex", "getTitlesPath", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Config {
        private final String baseUrlGithub;
        private final String baseUrlGithubIndex;
        private final String baseUrlWebsite;
        private final String boxArtsPath;
        private final Regex genericNameRegex;
        private final String snapshotsPath;
        private final Regex strictGenericNameRegex;
        private final String titlesPath;

        public Config() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        public static /* synthetic */ Config copy$default(Config config, String str, String str2, String str3, String str4, String str5, String str6, Regex regex, Regex regex2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = config.boxArtsPath;
            }
            if ((i & 2) != 0) {
                str2 = config.snapshotsPath;
            }
            if ((i & 4) != 0) {
                str3 = config.titlesPath;
            }
            if ((i & 8) != 0) {
                str4 = config.baseUrlWebsite;
            }
            if ((i & 16) != 0) {
                str5 = config.baseUrlGithub;
            }
            if ((i & 32) != 0) {
                str6 = config.baseUrlGithubIndex;
            }
            if ((i & 64) != 0) {
                regex = config.genericNameRegex;
            }
            if ((i & 128) != 0) {
                regex2 = config.strictGenericNameRegex;
            }
            Regex regex3 = regex;
            Regex regex4 = regex2;
            String str7 = str5;
            String str8 = str6;
            return config.copy(str, str2, str3, str4, str7, str8, regex3, regex4);
        }

        public final String component1() {
            return this.boxArtsPath;
        }

        public final String component2() {
            return this.snapshotsPath;
        }

        public final String component3() {
            return this.titlesPath;
        }

        public final String component4() {
            return this.baseUrlWebsite;
        }

        public final String component5() {
            return this.baseUrlGithub;
        }

        public final String component6() {
            return this.baseUrlGithubIndex;
        }

        public final Regex component7() {
            return this.genericNameRegex;
        }

        public final Regex component8() {
            return this.strictGenericNameRegex;
        }

        public final Config copy(String boxArtsPath, String snapshotsPath, String titlesPath, String baseUrlWebsite, String baseUrlGithub, String baseUrlGithubIndex, Regex genericNameRegex, Regex strictGenericNameRegex) {
            Intrinsics.checkNotNullParameter(boxArtsPath, "boxArtsPath");
            Intrinsics.checkNotNullParameter(snapshotsPath, "snapshotsPath");
            Intrinsics.checkNotNullParameter(titlesPath, "titlesPath");
            Intrinsics.checkNotNullParameter(baseUrlWebsite, "baseUrlWebsite");
            Intrinsics.checkNotNullParameter(baseUrlGithub, "baseUrlGithub");
            Intrinsics.checkNotNullParameter(baseUrlGithubIndex, "baseUrlGithubIndex");
            Intrinsics.checkNotNullParameter(genericNameRegex, "genericNameRegex");
            Intrinsics.checkNotNullParameter(strictGenericNameRegex, "strictGenericNameRegex");
            return new Config(boxArtsPath, snapshotsPath, titlesPath, baseUrlWebsite, baseUrlGithub, baseUrlGithubIndex, genericNameRegex, strictGenericNameRegex);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return Intrinsics.areEqual(this.boxArtsPath, config.boxArtsPath) && Intrinsics.areEqual(this.snapshotsPath, config.snapshotsPath) && Intrinsics.areEqual(this.titlesPath, config.titlesPath) && Intrinsics.areEqual(this.baseUrlWebsite, config.baseUrlWebsite) && Intrinsics.areEqual(this.baseUrlGithub, config.baseUrlGithub) && Intrinsics.areEqual(this.baseUrlGithubIndex, config.baseUrlGithubIndex) && Intrinsics.areEqual(this.genericNameRegex, config.genericNameRegex) && Intrinsics.areEqual(this.strictGenericNameRegex, config.strictGenericNameRegex);
        }

        public int hashCode() {
            return (((((((((((((this.boxArtsPath.hashCode() * 31) + this.snapshotsPath.hashCode()) * 31) + this.titlesPath.hashCode()) * 31) + this.baseUrlWebsite.hashCode()) * 31) + this.baseUrlGithub.hashCode()) * 31) + this.baseUrlGithubIndex.hashCode()) * 31) + this.genericNameRegex.hashCode()) * 31) + this.strictGenericNameRegex.hashCode();
        }

        public String toString() {
            return "Config(boxArtsPath=" + this.boxArtsPath + ", snapshotsPath=" + this.snapshotsPath + ", titlesPath=" + this.titlesPath + ", baseUrlWebsite=" + this.baseUrlWebsite + ", baseUrlGithub=" + this.baseUrlGithub + ", baseUrlGithubIndex=" + this.baseUrlGithubIndex + ", genericNameRegex=" + this.genericNameRegex + ", strictGenericNameRegex=" + this.strictGenericNameRegex + ")";
        }

        public Config(String boxArtsPath, String snapshotsPath, String titlesPath, String baseUrlWebsite, String baseUrlGithub, String baseUrlGithubIndex, Regex genericNameRegex, Regex strictGenericNameRegex) {
            Intrinsics.checkNotNullParameter(boxArtsPath, "boxArtsPath");
            Intrinsics.checkNotNullParameter(snapshotsPath, "snapshotsPath");
            Intrinsics.checkNotNullParameter(titlesPath, "titlesPath");
            Intrinsics.checkNotNullParameter(baseUrlWebsite, "baseUrlWebsite");
            Intrinsics.checkNotNullParameter(baseUrlGithub, "baseUrlGithub");
            Intrinsics.checkNotNullParameter(baseUrlGithubIndex, "baseUrlGithubIndex");
            Intrinsics.checkNotNullParameter(genericNameRegex, "genericNameRegex");
            Intrinsics.checkNotNullParameter(strictGenericNameRegex, "strictGenericNameRegex");
            this.boxArtsPath = boxArtsPath;
            this.snapshotsPath = snapshotsPath;
            this.titlesPath = titlesPath;
            this.baseUrlWebsite = baseUrlWebsite;
            this.baseUrlGithub = baseUrlGithub;
            this.baseUrlGithubIndex = baseUrlGithubIndex;
            this.genericNameRegex = genericNameRegex;
            this.strictGenericNameRegex = strictGenericNameRegex;
        }

        public /* synthetic */ Config(String str, String str2, String str3, String str4, String str5, String str6, Regex regex, Regex regex2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "Named_Boxarts" : str, (i & 2) != 0 ? "Named_Snaps" : str2, (i & 4) != 0 ? "Named_Titles" : str3, (i & 8) != 0 ? "https://thumbnails.libretro.com/" : str4, (i & 16) != 0 ? "https://raw.githubusercontent.com/libretro-thumbnails/" : str5, (i & 32) != 0 ? "https://github.com/libretro-thumbnails/" : str6, (i & 64) != 0 ? Constants.INSTANCE.getToGenericNameRegex() : regex, (i & 128) != 0 ? new Regex("^\\s*([^\\.]*)\\s*(?:\\.)*.*$", RegexOption.IGNORE_CASE) : regex2);
        }

        public final String getBoxArtsPath() {
            return this.boxArtsPath;
        }

        public final String getSnapshotsPath() {
            return this.snapshotsPath;
        }

        public final String getTitlesPath() {
            return this.titlesPath;
        }

        public final String getBaseUrlWebsite() {
            return this.baseUrlWebsite;
        }

        public final String getBaseUrlGithub() {
            return this.baseUrlGithub;
        }

        public final String getBaseUrlGithubIndex() {
            return this.baseUrlGithubIndex;
        }

        public final Regex getGenericNameRegex() {
            return this.genericNameRegex;
        }

        public final Regex getStrictGenericNameRegex() {
            return this.strictGenericNameRegex;
        }
    }
}

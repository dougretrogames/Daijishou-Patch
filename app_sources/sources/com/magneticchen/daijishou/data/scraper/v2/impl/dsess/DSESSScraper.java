package com.magneticchen.daijishou.data.scraper.v2.impl.dsess;

import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.Genre;
import com.magneticchen.daijishou.data.Genres;
import com.magneticchen.daijishou.data.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.data.scraper.v2.AbstractScraper;
import com.magneticchen.daijishou.data.scraper.v2.ScraperConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;

/* JADX INFO: compiled from: DSESSScraper.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\tJ,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000eJ6\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\u0016\u001a\u00020\tJ(\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000eR\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESSScraper;", "Lcom/magneticchen/daijishou/data/scraper/v2/AbstractScraper;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "config", "Lcom/magneticchen/daijishou/data/scraper/v2/ScraperConfig;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Lcom/magneticchen/daijishou/data/scraper/v2/ScraperConfig;)V", "dSESSFromDSESSStringCache", "", "", "Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS;", "getDSESSFromDSESSString", "string", "scrapeGenresByKeywords", "", "Lcom/magneticchen/daijishou/data/Genre;", "dsessString", "platformName", "keywords", "scrapePreviewMediaByKeywords", "Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;", "playableItemPreviewMediaIndex", "path", "scrapeYoutubeVideoIdByKeywords", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DSESSScraper extends AbstractScraper {
    private final Map<String, DSESS> dSESSFromDSESSStringCache;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DSESSScraper(DaijishouApplication application, ScraperConfig config) {
        super(application, config);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(config, "config");
        Map<String, DSESS> mapBuild = ExpiringMap.builder().maxSize(64).expiration(30L, TimeUnit.MINUTES).expirationPolicy(ExpirationPolicy.ACCESSED).build();
        Intrinsics.checkNotNullExpressionValue(mapBuild, "build(...)");
        this.dSESSFromDSESSStringCache = mapBuild;
    }

    public final List<Genre> scrapeGenresByKeywords(String dsessString, String str, List<String> keywords) {
        Intrinsics.checkNotNullParameter(dsessString, "dsessString");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        List listListOf = CollectionsKt.listOf(DSESS.Scraper.TARGET_GENRES);
        Locale locale = Locale.getDefault();
        DSESS dSESSFromDSESSString = getDSESSFromDSESSString(dsessString);
        if (!listListOf.contains(dSESSFromDSESSString.getDsessParts().getScraper())) {
            return CollectionsKt.emptyList();
        }
        if (!dSESSFromDSESSString.getDsessParts().getTemplateTags().contains(DSESS.Template.TAG_SCRAPER_KEYWORD) && !dSESSFromDSESSString.getDsessParts().getTemplateTags().contains(DSESS.Template.TAG_SCRAPER_KEYWORD_NORMALIZED)) {
            return CollectionsKt.emptyList();
        }
        Iterator<String> it = keywords.iterator();
        while (it.hasNext()) {
            try {
                String strScrape = dSESSFromDSESSString.scrape(dSESSFromDSESSString.toGenericName(it.next()), str, locale);
                if (strScrape != null) {
                    List<Genre> listExtractGenresFromString = Genres.INSTANCE.extractGenresFromString(strScrape);
                    if (!listExtractGenresFromString.isEmpty()) {
                        return listExtractGenresFromString;
                    }
                }
            } catch (Exception e) {
                getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
            }
        }
        return CollectionsKt.emptyList();
    }

    public final PlayableItemPreviewMediaIndex scrapePreviewMediaByKeywords(PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex, String dsessString, String str, List<String> keywords, String path) {
        String str2;
        DSESS dsess;
        Intrinsics.checkNotNullParameter(playableItemPreviewMediaIndex, "playableItemPreviewMediaIndex");
        Intrinsics.checkNotNullParameter(dsessString, "dsessString");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(path, "path");
        List listListOf = CollectionsKt.listOf((Object[]) new DSESS.Scraper[]{DSESS.Scraper.TARGET_BOX_ART, DSESS.Scraper.TARGET_SNAPSHOT, DSESS.Scraper.TARGET_TITLE});
        String str3 = path + getConfig().getBoxArtFilename();
        String str4 = path + getConfig().getSnapshotFilename();
        String str5 = path + getConfig().getTitleFilename();
        Locale locale = Locale.getDefault();
        DSESS dSESSFromDSESSString = getDSESSFromDSESSString(dsessString);
        if (listListOf.contains(dSESSFromDSESSString.getDsessParts().getScraper()) && (dSESSFromDSESSString.getDsessParts().getTemplateTags().contains(DSESS.Template.TAG_SCRAPER_KEYWORD) || dSESSFromDSESSString.getDsessParts().getTemplateTags().contains(DSESS.Template.TAG_SCRAPER_KEYWORD_NORMALIZED))) {
            Iterator<String> it = keywords.iterator();
            while (it.hasNext()) {
                String genericName = dSESSFromDSESSString.toGenericName(it.next());
                if (playableItemPreviewMediaIndex.getBoxArtPath() == null) {
                    if (dSESSFromDSESSString.getDsessParts().getScraper() == DSESS.Scraper.TARGET_BOX_ART) {
                        try {
                            String strScrape = dSESSFromDSESSString.scrape(genericName, str, locale);
                            Intrinsics.checkNotNull(strScrape);
                            saveURLImageToPath(strScrape, str3, Constants.downloadedBoxArtImagesShortEdgeBase);
                            playableItemPreviewMediaIndex.setBoxArtPath(getConfig().getBoxArtFilename());
                        } catch (Exception e) {
                            getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                        }
                    }
                    if (playableItemPreviewMediaIndex.getSnapshotPath() == null && dSESSFromDSESSString.getDsessParts().getScraper() == DSESS.Scraper.TARGET_SNAPSHOT) {
                        try {
                            String strScrape2 = dSESSFromDSESSString.scrape(genericName, str, locale);
                            Intrinsics.checkNotNull(strScrape2);
                            AbstractScraper.saveURLImageToPath$default(this, strScrape2, str4, 0, 4, null);
                            playableItemPreviewMediaIndex.setSnapshotPath(getConfig().getSnapshotFilename());
                        } catch (Exception e2) {
                            getLogger().warn(this, ExceptionsKt.stackTraceToString(e2));
                        }
                    }
                    if (playableItemPreviewMediaIndex.getTitlePath() == null && dSESSFromDSESSString.getDsessParts().getScraper() == DSESS.Scraper.TARGET_TITLE) {
                        try {
                            String strScrape3 = dSESSFromDSESSString.scrape(genericName, str, locale);
                            DSESSScraper dSESSScraper = this;
                            Intrinsics.checkNotNull(strScrape3);
                            dsess = dSESSFromDSESSString;
                            str2 = str5;
                            try {
                                AbstractScraper.saveURLImageToPath$default(dSESSScraper, strScrape3, str2, 0, 4, null);
                                playableItemPreviewMediaIndex.setTitlePath(getConfig().getTitleFilename());
                            } catch (Exception e3) {
                                e = e3;
                                getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                            }
                        } catch (Exception e4) {
                            e = e4;
                            str2 = str5;
                            dsess = dSESSFromDSESSString;
                        }
                        dSESSFromDSESSString = dsess;
                        str5 = str2;
                    }
                }
            }
        }
        return playableItemPreviewMediaIndex;
    }

    public final String scrapeYoutubeVideoIdByKeywords(String dsessString, String str, List<String> keywords) {
        Intrinsics.checkNotNullParameter(dsessString, "dsessString");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        List listListOf = CollectionsKt.listOf(DSESS.Scraper.TARGET_YOUTUBE);
        Locale locale = Locale.getDefault();
        DSESS dSESSFromDSESSString = getDSESSFromDSESSString(dsessString);
        if (!listListOf.contains(dSESSFromDSESSString.getDsessParts().getScraper())) {
            return null;
        }
        if (!dSESSFromDSESSString.getDsessParts().getTemplateTags().contains(DSESS.Template.TAG_SCRAPER_KEYWORD) && !dSESSFromDSESSString.getDsessParts().getTemplateTags().contains(DSESS.Template.TAG_SCRAPER_KEYWORD_NORMALIZED)) {
            return null;
        }
        Iterator<String> it = keywords.iterator();
        while (it.hasNext()) {
            try {
                String strScrape = dSESSFromDSESSString.scrape(dSESSFromDSESSString.toGenericName(it.next()), str, locale);
                if (strScrape != null) {
                    return strScrape;
                }
            } catch (Exception e) {
                getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DSESS getDSESSFromDSESSString$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (DSESS) tmp0.invoke(obj);
    }

    public final DSESS getDSESSFromDSESSString(final String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        Map<String, DSESS> map = this.dSESSFromDSESSStringCache;
        final Function1<String, DSESS> function1 = new Function1<String, DSESS>() { // from class: com.magneticchen.daijishou.data.scraper.v2.impl.dsess.DSESSScraper.getDSESSFromDSESSString.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public final DSESS invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new DSESS(DSESSScraper.this.getApplication(), DSESSScraper.this.getConfig(), string, null, 8, null);
            }
        };
        DSESS dsessComputeIfAbsent = map.computeIfAbsent(string, new Function() { // from class: com.magneticchen.daijishou.data.scraper.v2.impl.dsess.DSESSScraper$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DSESSScraper.getDSESSFromDSESSString$lambda$0(function1, obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(dsessComputeIfAbsent, "computeIfAbsent(...)");
        return dsessComputeIfAbsent;
    }
}

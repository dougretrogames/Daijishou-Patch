package com.magneticchen.daijishou.scraper.v2.impl.dsess;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_library_db.Genre;
import com.magneticchen.daijishou.daijishou_library_db.Genres;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.scraper.v2.AbstractScraper;
import com.magneticchen.daijishou.scraper.v2.ScraperConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;

/* JADX INFO: compiled from: DSESSScraper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\tJ,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000eJ6\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\u0016\u001a\u00020\tJ(\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000eR\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/magneticchen/daijishou/scraper/v2/impl/dsess/DSESSScraper;", "Lcom/magneticchen/daijishou/scraper/v2/AbstractScraper;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "config", "Lcom/magneticchen/daijishou/scraper/v2/ScraperConfig;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Lcom/magneticchen/daijishou/scraper/v2/ScraperConfig;)V", "dSESSFromDSESSStringCache", "", "", "Lcom/magneticchen/daijishou/scraper/v2/impl/dsess/DSESS;", "getDSESSFromDSESSString", TypedValues.Custom.S_STRING, "scrapeGenresByKeywords", "", "Lcom/magneticchen/daijishou/daijishou_library_db/Genre;", "dsessString", "platformName", "keywords", "scrapePreviewMediaByKeywords", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemPreviewMediaIndex;", "playableItemPreviewMediaIndex", "path", "scrapeYoutubeVideoIdByKeywords", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    public final List<Genre> scrapeGenresByKeywords(String dsessString, String platformName, List<String> keywords) {
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
                String strScrape = dSESSFromDSESSString.scrape(dSESSFromDSESSString.toGenericName(it.next()), platformName, locale);
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

    public final PlayableItemPreviewMediaIndex scrapePreviewMediaByKeywords(PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex, String dsessString, String platformName, List<String> keywords, String path) {
        String str;
        DSESS dsess;
        Intrinsics.checkNotNullParameter(playableItemPreviewMediaIndex, "playableItemPreviewMediaIndex");
        Intrinsics.checkNotNullParameter(dsessString, "dsessString");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(path, "path");
        List listListOf = CollectionsKt.listOf(new DSESS.Scraper[]{DSESS.Scraper.TARGET_BOX_ART, DSESS.Scraper.TARGET_SNAPSHOT, DSESS.Scraper.TARGET_TITLE});
        String str2 = path + getConfig().getBoxArtFilename();
        String str3 = path + getConfig().getSnapshotFilename();
        String str4 = path + getConfig().getTitleFilename();
        Locale locale = Locale.getDefault();
        DSESS dSESSFromDSESSString = getDSESSFromDSESSString(dsessString);
        if (listListOf.contains(dSESSFromDSESSString.getDsessParts().getScraper()) && (dSESSFromDSESSString.getDsessParts().getTemplateTags().contains(DSESS.Template.TAG_SCRAPER_KEYWORD) || dSESSFromDSESSString.getDsessParts().getTemplateTags().contains(DSESS.Template.TAG_SCRAPER_KEYWORD_NORMALIZED))) {
            Iterator<String> it = keywords.iterator();
            while (it.hasNext()) {
                String genericName = dSESSFromDSESSString.toGenericName(it.next());
                if (playableItemPreviewMediaIndex.getBoxArtPath() == null) {
                    if (dSESSFromDSESSString.getDsessParts().getScraper() == DSESS.Scraper.TARGET_BOX_ART) {
                        try {
                            String strScrape = dSESSFromDSESSString.scrape(genericName, platformName, locale);
                            Intrinsics.checkNotNull(strScrape);
                            saveURLImageToPath(strScrape, str2, Constants.downloadedBoxArtImagesShortEdgeBase);
                            playableItemPreviewMediaIndex.setBoxArtPath(getConfig().getBoxArtFilename());
                        } catch (Exception e) {
                            getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                        }
                    }
                    if (playableItemPreviewMediaIndex.getSnapshotPath() == null && dSESSFromDSESSString.getDsessParts().getScraper() == DSESS.Scraper.TARGET_SNAPSHOT) {
                        try {
                            String strScrape2 = dSESSFromDSESSString.scrape(genericName, platformName, locale);
                            Intrinsics.checkNotNull(strScrape2);
                            AbstractScraper.saveURLImageToPath$default(this, strScrape2, str3, 0, 4, null);
                            playableItemPreviewMediaIndex.setSnapshotPath(getConfig().getSnapshotFilename());
                        } catch (Exception e2) {
                            getLogger().warn(this, ExceptionsKt.stackTraceToString(e2));
                        }
                    }
                    if (playableItemPreviewMediaIndex.getTitlePath() == null && dSESSFromDSESSString.getDsessParts().getScraper() == DSESS.Scraper.TARGET_TITLE) {
                        try {
                            String strScrape3 = dSESSFromDSESSString.scrape(genericName, platformName, locale);
                            DSESSScraper dSESSScraper = this;
                            Intrinsics.checkNotNull(strScrape3);
                            dsess = dSESSFromDSESSString;
                            str = str4;
                            try {
                                AbstractScraper.saveURLImageToPath$default(dSESSScraper, strScrape3, str, 0, 4, null);
                                playableItemPreviewMediaIndex.setTitlePath(getConfig().getTitleFilename());
                            } catch (Exception e3) {
                                Exception e = null;
                                e = e3;
                                getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                            }
                        } catch (Exception e4) {
                            Exception e = null;
                            e = e4;
                            str = str4;
                            dsess = dSESSFromDSESSString;
                        }
                        dSESSFromDSESSString = dsess;
                        str4 = str;
                    }
                }
            }
        }
        return playableItemPreviewMediaIndex;
    }

    public final String scrapeYoutubeVideoIdByKeywords(String dsessString, String platformName, List<String> keywords) {
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
                String strScrape = dSESSFromDSESSString.scrape(dSESSFromDSESSString.toGenericName(it.next()), platformName, locale);
                if (strScrape != null) {
                    return strScrape;
                }
            } catch (Exception e) {
                getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.scraper.v2.impl.dsess.DSESSScraper$getDSESSFromDSESSString$1, reason: invalid class name */
    /* JADX INFO: compiled from: DSESSScraper.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/magneticchen/daijishou/scraper/v2/impl/dsess/DSESS;", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<DSESS> implements Function1<String, DSESS> {
        final /* synthetic */ String $string;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str) {
            super(1);
            this.$string = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public final DSESS invoke(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new DSESS(DSESSScraper.this.getApplication(), DSESSScraper.this.getConfig(), this.$string, null, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DSESS getDSESSFromDSESSString$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (DSESS) tmp0.invoke(obj);
    }

    public final DSESS getDSESSFromDSESSString(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        DSESS dsessComputeIfAbsent = this.dSESSFromDSESSStringCache.computeIfAbsent(string, new DSESSScraper$$ExternalSyntheticLambda0(new AnonymousClass1(string)));
        Intrinsics.checkNotNullExpressionValue(dsessComputeIfAbsent, "computeIfAbsent(...)");
        return dsessComputeIfAbsent;
    }
}

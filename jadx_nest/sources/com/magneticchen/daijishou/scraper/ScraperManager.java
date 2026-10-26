package com.magneticchen.daijishou.scraper;

import android.graphics.Bitmap;
import android.net.Uri;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_library_db.Genre;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.scraper.v2.ScraperConfig;
import com.magneticchen.daijishou.scraper.v2.impl.ArcadeItaliaScraper;
import com.magneticchen.daijishou.scraper.v2.impl.IGDBScraper;
import com.magneticchen.daijishou.scraper.v2.impl.LibRetroScraper;
import com.magneticchen.daijishou.scraper.v2.impl.RawPico8Scraper;
import com.magneticchen.daijishou.scraper.v2.impl.dsess.DSESSScraper;
import com.magneticchen.daijishou.scraper.v2.impl.google.GoogleKGSearchScraper;
import com.magneticchen.daijishou.scraper.v2.impl.google.GoogleScraper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;

/* INFO: compiled from: ScraperManager.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u000bJ,\u0010!\u001a\u00020\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0#2\b\u0010$\u001a\u0004\u0018\u00010\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0#J2\u0010&\u001a\b\u0012\u0004\u0012\u00020'0#2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0#2\b\u0010$\u001a\u0004\u0018\u00010\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0#J\u001e\u0010(\u001a\u0004\u0018\u00010\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0#2\u0006\u0010)\u001a\u00020\u000bJ.\u0010*\u001a\u00020+2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0#2\b\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010,\u001a\u00020-2\u0006\u0010 \u001a\u00020\u000bJ4\u0010.\u001a\u00020+2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0#2\b\u0010$\u001a\u0004\u0018\u00010\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0#2\u0006\u0010 \u001a\u00020\u000bJ\"\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000b0#2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0#2\u0006\u0010)\u001a\u00020\u000bJ.\u00100\u001a\u0004\u0018\u00010\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0#2\b\u0010$\u001a\u0004\u0018\u00010\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R~\u0010\t\u001ar\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012$\u0012\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b \f*\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r0\r \f*8\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012$\u0012\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b \f*\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r0\r\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00060\u001bR\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/magneticchen/daijishou/scraper/ScraperManager;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "arcadeItaliaScraper", "Lcom/magneticchen/daijishou/scraper/v2/impl/ArcadeItaliaScraper;", "baseURLStringCookiesCache", "Lnet/jodah/expiringmap/ExpiringMap;", "", "kotlin.jvm.PlatformType", "", "dSESSScraper", "Lcom/magneticchen/daijishou/scraper/v2/impl/dsess/DSESSScraper;", "getDSESSScraper", "()Lcom/magneticchen/daijishou/scraper/v2/impl/dsess/DSESSScraper;", "googleKGSearchScraper", "Lcom/magneticchen/daijishou/scraper/v2/impl/google/GoogleKGSearchScraper;", "googleScraper", "Lcom/magneticchen/daijishou/scraper/v2/impl/google/GoogleScraper;", "iGDBScraper", "Lcom/magneticchen/daijishou/scraper/v2/impl/IGDBScraper;", "libRetroScraper", "Lcom/magneticchen/daijishou/scraper/v2/impl/LibRetroScraper;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "rawPico8Scraper", "Lcom/magneticchen/daijishou/scraper/v2/impl/RawPico8Scraper;", "getPlayableItemPreviewMediaIndexFromPath", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemPreviewMediaIndex;", "path", "scrapeDescriptionByPlatformNameAndKeywords", "sources", "", "platformName", "keywords", "scrapeGenresByKeywords", "Lcom/magneticchen/daijishou/daijishou_library_db/Genre;", "scrapeNameByName", "name", "scrapePreviewMediaByFileUri", "", "fileUri", "Landroid/net/Uri;", "scrapePreviewMediaByKeywords", "scrapeScraperKeywordsByName", "scrapeYoutubeVideoIdByKeywords", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScraperManager {
    private final DaijishouApplication application;
    private final ArcadeItaliaScraper arcadeItaliaScraper;
    private final ExpiringMap<String, Map<String, String>> baseURLStringCookiesCache;
    private final DSESSScraper dSESSScraper;
    private final GoogleKGSearchScraper googleKGSearchScraper;
    private final GoogleScraper googleScraper;
    private final IGDBScraper iGDBScraper;
    private final LibRetroScraper libRetroScraper;
    private final DaijishouApplication.WrappedLogger logger;
    private final RawPico8Scraper rawPico8Scraper;

    public ScraperManager(DaijishouApplication application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this.logger = application.getLogger();
        ExpiringMap baseURLStringCookiesCache = ExpiringMap.builder().maxSize(64).expiration(30L, TimeUnit.MINUTES).expirationPolicy(ExpirationPolicy.CREATED).build();
        this.baseURLStringCookiesCache = baseURLStringCookiesCache;
        Bitmap.CompressFormat scraperFormat = Constants.INSTANCE.getScraperFormat();
        Intrinsics.checkNotNullExpressionValue(baseURLStringCookiesCache, "baseURLStringCookiesCache");
        this.libRetroScraper = new LibRetroScraper(application, new ScraperConfig(Constants.scraperBoxArtFileName, Constants.scraperSnapshotFileName, Constants.scraperTitleFileName, scraperFormat, 100, baseURLStringCookiesCache, 0, null, 192, null), null, 4, null);
        Bitmap.CompressFormat scraperFormat2 = Constants.INSTANCE.getScraperFormat();
        Intrinsics.checkNotNullExpressionValue(baseURLStringCookiesCache, "baseURLStringCookiesCache");
        this.iGDBScraper = new IGDBScraper(application, new ScraperConfig(Constants.scraperBoxArtFileName, Constants.scraperSnapshotFileName, Constants.scraperTitleFileName, scraperFormat2, 100, baseURLStringCookiesCache, 0, null, 192, null), null, 4, null);
        Bitmap.CompressFormat scraperFormat3 = Constants.INSTANCE.getScraperFormat();
        Intrinsics.checkNotNullExpressionValue(baseURLStringCookiesCache, "baseURLStringCookiesCache");
        this.googleScraper = new GoogleScraper(application, new ScraperConfig(Constants.scraperBoxArtFileName, Constants.scraperSnapshotFileName, Constants.scraperTitleFileName, scraperFormat3, 100, baseURLStringCookiesCache, 0, null, 192, null), null, 4, null);
        Bitmap.CompressFormat scraperFormat4 = Constants.INSTANCE.getScraperFormat();
        Intrinsics.checkNotNullExpressionValue(baseURLStringCookiesCache, "baseURLStringCookiesCache");
        this.googleKGSearchScraper = new GoogleKGSearchScraper(application, new ScraperConfig(Constants.scraperBoxArtFileName, Constants.scraperSnapshotFileName, Constants.scraperTitleFileName, scraperFormat4, 100, baseURLStringCookiesCache, 0, null, 192, null), null, 4, null);
        Bitmap.CompressFormat scraperFormat5 = Constants.INSTANCE.getScraperFormat();
        Intrinsics.checkNotNullExpressionValue(baseURLStringCookiesCache, "baseURLStringCookiesCache");
        this.arcadeItaliaScraper = new ArcadeItaliaScraper(application, new ScraperConfig(Constants.scraperBoxArtFileName, Constants.scraperSnapshotFileName, Constants.scraperTitleFileName, scraperFormat5, 100, baseURLStringCookiesCache, 0, null, 192, null), null, 4, null);
        Bitmap.CompressFormat scraperFormat6 = Constants.INSTANCE.getScraperFormat();
        Intrinsics.checkNotNullExpressionValue(baseURLStringCookiesCache, "baseURLStringCookiesCache");
        this.rawPico8Scraper = new RawPico8Scraper(application, new ScraperConfig(Constants.scraperBoxArtFileName, Constants.scraperSnapshotFileName, Constants.scraperTitleFileName, scraperFormat6, 100, baseURLStringCookiesCache, 0, null, 192, null));
        Bitmap.CompressFormat scraperFormat7 = Constants.INSTANCE.getScraperFormat();
        Intrinsics.checkNotNullExpressionValue(baseURLStringCookiesCache, "baseURLStringCookiesCache");
        this.dSESSScraper = new DSESSScraper(application, new ScraperConfig(Constants.scraperBoxArtFileName, Constants.scraperSnapshotFileName, Constants.scraperTitleFileName, scraperFormat7, 100, baseURLStringCookiesCache, 0, null, 192, null));
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    public final DSESSScraper getDSESSScraper() {
        return this.dSESSScraper;
    }

    public final boolean scrapePreviewMediaByKeywords(List<String> sources, String platformName, List<String> keywords, String path) throws IOException {
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex;
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(path, "path");
        File file = new File(path);
        file.mkdirs();
        File file2 = new File(file, "index.json");
        if (file2.exists()) {
            String string = IOUtils.toString(new FileInputStream(file2), StandardCharsets.UTF_8);
            Json companion = Json.Default;
            KSerializer<PlayableItemPreviewMediaIndex> kSerializerSerializer = PlayableItemPreviewMediaIndex.INSTANCE.serializer();
            Intrinsics.checkNotNull(string);
            playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) companion.decodeFromString(kSerializerSerializer, string);
        } else {
            playableItemPreviewMediaIndex = new PlayableItemPreviewMediaIndex((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }
        for (String str : sources) {
            try {
                if (StringsKt.startsWith$default(str, "LIBRETRO:", false, 2, (Object) null)) {
                    this.libRetroScraper.scrapePreviewMediaByKeywords(playableItemPreviewMediaIndex, (String) StringsKt.split$default((CharSequence) str, new String[]{CollectionUtils.COLON}, false, 0, 6, (Object) null).get(1), keywords, path);
                } else if (Intrinsics.areEqual(str, "ARCADE_ITALIA:MAME")) {
                    this.arcadeItaliaScraper.scrapePreviewMediaByKeywords(playableItemPreviewMediaIndex, keywords, path);
                } else if (Intrinsics.areEqual(str, "DSESS:")) {
                    this.dSESSScraper.scrapePreviewMediaByKeywords(playableItemPreviewMediaIndex, str, platformName, keywords, path);
                }
            } catch (Exception e) {
                this.logger.warn(this, ExceptionsKt.stackTraceToString(e));
            }
        }
        if (playableItemPreviewMediaIndex.getBoxArtPath() == null && this.application.getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_AGGRESSIVE_SCRAPING.getKey(), BooleanPreference.USE_AGGRESSIVE_SCRAPING.getDefaultValue())) {
            try {
                this.googleScraper.scrapePreviewMediaByKeywords(playableItemPreviewMediaIndex, platformName, keywords, path);
            } catch (Exception e2) {
                this.logger.warn(this, ExceptionsKt.stackTraceToString(e2));
            }
        }
        boolean zHasAnyMedia = ScraperUtilsKt.hasAnyMedia(playableItemPreviewMediaIndex);
        if (zHasAnyMedia) {
            Json jsonJson$default = JsonKt.Json$default(null, ScraperManager$scrapePreviewMediaByKeywords$format$1.INSTANCE, 1, null);
            jsonJson$default.getSerializersModule();
            String strEncodeToString = jsonJson$default.encodeToString(PlayableItemPreviewMediaIndex.INSTANCE.serializer(), playableItemPreviewMediaIndex);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file2));
            try {
                outputStreamWriter.write(strEncodeToString);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(outputStreamWriter, null);
            } catch (Throwable th) {
                                    CloseableKt.closeFinally(outputStreamWriter, th);
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        } else if (file.exists()) {
            FilesKt.deleteRecursively(file);
        }
        return zHasAnyMedia;
    }

    public final boolean scrapePreviewMediaByFileUri(List<String> sources, String platformName, Uri fileUri, String path) throws IOException {
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex;
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(fileUri, "fileUri");
        Intrinsics.checkNotNullParameter(path, "path");
        if (Intrinsics.areEqual(fileUri, Uri.EMPTY)) {
            return false;
        }
        File file = new File(path);
        file.mkdirs();
        File file2 = new File(file, "index.json");
        if (file2.exists()) {
            String string = IOUtils.toString(new FileInputStream(file2), StandardCharsets.UTF_8);
            Json companion = Json.Default;
            KSerializer<PlayableItemPreviewMediaIndex> kSerializerSerializer = PlayableItemPreviewMediaIndex.INSTANCE.serializer();
            Intrinsics.checkNotNull(string);
            playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) companion.decodeFromString(kSerializerSerializer, string);
        } else {
            playableItemPreviewMediaIndex = new PlayableItemPreviewMediaIndex((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }
        Iterator<String> it = sources.iterator();
        while (it.hasNext()) {
            try {
                if (Intrinsics.areEqual(it.next(), "RAW:PICO-8")) {
                    this.rawPico8Scraper.scrapePreviewMediaByFileUri(playableItemPreviewMediaIndex, fileUri, path);
                }
            } catch (Exception e) {
                this.logger.warn(this, ExceptionsKt.stackTraceToString(e));
            }
        }
        if (ScraperUtilsKt.hasAnyMedia(playableItemPreviewMediaIndex)) {
            Json jsonJson$default = JsonKt.Json$default(null, ScraperManager$scrapePreviewMediaByFileUri$format$1.INSTANCE, 1, null);
            jsonJson$default.getSerializersModule();
            String strEncodeToString = jsonJson$default.encodeToString(PlayableItemPreviewMediaIndex.INSTANCE.serializer(), playableItemPreviewMediaIndex);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file2));
            try {
                outputStreamWriter.write(strEncodeToString);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(outputStreamWriter, null);
            } catch (Throwable th) {
                                    CloseableKt.closeFinally(outputStreamWriter, th);
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        } else if (file.exists()) {
            FilesKt.deleteRecursively(file);
        }
        return ScraperUtilsKt.hasAllMedia(playableItemPreviewMediaIndex);
    }

    public final List<Genre> scrapeGenresByKeywords(List<String> sources, String platformName, List<String> keywords) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        for (String str : sources) {
            try {
                if (StringsKt.startsWith$default(str, "DSESS:", false, 2, (Object) null)) {
                    List<Genre> listScrapeGenresByKeywords = this.dSESSScraper.scrapeGenresByKeywords(str, platformName, keywords);
                    if (!listScrapeGenresByKeywords.isEmpty()) {
                        return listScrapeGenresByKeywords;
                    }
                } else {
                    continue;
                }
            } catch (Exception e) {
                this.logger.warn(this, ExceptionsKt.stackTraceToString(e));
            }
        }
        return CollectionsKt.emptyList();
    }

    public final String scrapeYoutubeVideoIdByKeywords(List<String> sources, String platformName, List<String> keywords) {
        String strScrapeYoutubeVideoIdByKeywords;
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        this.logger.debug(this, "scrapeYoutubeVideoIdByKeywords");
        for (String str : sources) {
            try {
                if (Intrinsics.areEqual(str, "ARCADE_ITALIA:MAME")) {
                    String strScrapeYoutubeVideoIdByKeywords2 = this.arcadeItaliaScraper.scrapeYoutubeVideoIdByKeywords(keywords);
                    if (strScrapeYoutubeVideoIdByKeywords2 != null) {
                        return strScrapeYoutubeVideoIdByKeywords2;
                    }
                } else if (StringsKt.startsWith$default(str, "DSESS:", false, 2, (Object) null) && (strScrapeYoutubeVideoIdByKeywords = this.dSESSScraper.scrapeYoutubeVideoIdByKeywords(str, platformName, keywords)) != null) {
                    return strScrapeYoutubeVideoIdByKeywords;
                }
            } catch (Exception e) {
                this.logger.warn(this, ExceptionsKt.stackTraceToString(e));
            }
        }
        try {
            this.logger.debug(this, "scrapeYoutubeVideoIdByKeywords: defaultYoutubeVideoIdDSESSFormat");
            return this.dSESSScraper.scrapeYoutubeVideoIdByKeywords(Constants.defaultYoutubeVideoIdDSESSFormat, platformName, keywords);
        } catch (Exception e2) {
            this.logger.warn(this, ExceptionsKt.stackTraceToString(e2));
            return this.iGDBScraper.scrapeYoutubeVideoIdByKeywords("GAMES:TAGS(scraperKeyword): search \"{scraperKeyword}\";", keywords);
        }
    }

    public final String scrapeDescriptionByPlatformNameAndKeywords(List<String> sources, String platformName, List<String> keywords) {
        String strScrapeDescriptionByKeywords;
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Iterator<String> it = sources.iterator();
        while (it.hasNext()) {
            try {
                if (Intrinsics.areEqual(it.next(), "ARCADE_ITALIA:MAME") && (strScrapeDescriptionByKeywords = this.arcadeItaliaScraper.scrapeDescriptionByKeywords(keywords)) != null) {
                    return strScrapeDescriptionByKeywords;
                }
            } catch (Exception e) {
                this.logger.warn(this, ExceptionsKt.stackTraceToString(e));
            }
        }
        try {
            return this.googleKGSearchScraper.scrapeDescriptionByPlatformNameAndKeywords(platformName, keywords);
        } catch (Exception e) {
            this.logger.warn(this, ExceptionsKt.stackTraceToString(e));
            return null;
        }
    }

    public final String scrapeNameByName(List<String> sources, String name) {
        String strScrapeNameByName;
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(name, "name");
        Iterator<String> it = sources.iterator();
        while (it.hasNext()) {
            try {
                if (Intrinsics.areEqual(it.next(), "ARCADE_ITALIA:MAME") && (strScrapeNameByName = this.arcadeItaliaScraper.scrapeNameByName(name)) != null) {
                    return strScrapeNameByName;
                }
            } catch (Exception e) {
                this.logger.warn(this, ExceptionsKt.stackTraceToString(e));
            }
        }
        return null;
    }

    public final List<String> scrapeScraperKeywordsByName(List<String> sources, String name) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(name, "name");
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = sources.iterator();
        while (it.hasNext()) {
            try {
                if (Intrinsics.areEqual(it.next(), "ARCADE_ITALIA:MAME")) {
                    arrayList.addAll(this.arcadeItaliaScraper.scrapeScraperKeywordsByName(name));
                }
            } catch (Exception e) {
                this.logger.warn(this, ExceptionsKt.stackTraceToString(e));
            }
        }
        return arrayList;
    }

    public final PlayableItemPreviewMediaIndex getPlayableItemPreviewMediaIndexFromPath(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        String str = path + "index.json";
        if (!new File(str).exists()) {
            return null;
        }
        String string;
        try {
            string = IOUtils.toString(new FileInputStream(str), StandardCharsets.UTF_8);
        } catch (java.io.IOException e) {
            this.logger.warn(this, ExceptionsKt.stackTraceToString(e));
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return (PlayableItemPreviewMediaIndex) Json.Default.decodeFromString(com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex$$serializer.INSTANCE, string);
    }
}

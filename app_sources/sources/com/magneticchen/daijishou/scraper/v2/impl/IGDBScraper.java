package com.magneticchen.daijishou.scraper.v2.impl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.api.igdb.apicalypse.APICalypse;
import com.api.igdb.request.IGDBWrapper;
import com.api.igdb.request.ProtoRequestKt;
import com.google.android.gms.actions.SearchIntents;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.scraper.v2.AbstractScraper;
import com.magneticchen.daijishou.scraper.v2.ScraperConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.lib.ConfigConstants;
import proto.Game;
import proto.GameVideo;

/* INFO: compiled from: IGDBScraper.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u001e\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0011J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/magneticchen/daijishou/scraper/v2/impl/IGDBScraper;", "Lcom/magneticchen/daijishou/scraper/v2/AbstractScraper;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "config", "Lcom/magneticchen/daijishou/scraper/v2/ScraperConfig;", "igdbConfig", "Lcom/magneticchen/daijishou/scraper/v2/impl/IGDBScraper$Config;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Lcom/magneticchen/daijishou/scraper/v2/ScraperConfig;Lcom/magneticchen/daijishou/scraper/v2/impl/IGDBScraper$Config;)V", "addOptionsByQuery", "Lcom/api/igdb/apicalypse/APICalypse;", "api", SearchIntents.EXTRA_QUERY, "", "getEndpointFromQuery", "body", "getTemplateTagsFromQuery", "", "scrapeYoutubeVideoIdByKeywords", "keywords", "toGenericName", TypedValues.Custom.S_STRING, "Config", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IGDBScraper extends AbstractScraper {
    private final Config igdbConfig;

    public /* synthetic */ IGDBScraper(DaijishouApplication daijishouApplication, ScraperConfig scraperConfig, Config config, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(daijishouApplication, scraperConfig, (i & 4) != 0 ? new Config(null, null, null, null, null, 31, null) : config);
    }

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IGDBScraper(DaijishouApplication application, ScraperConfig config, Config igdbConfig) {
        super(application, config);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(igdbConfig, "igdbConfig");
        this.igdbConfig = igdbConfig;
        IGDBWrapper.INSTANCE.setCredentials(Constants.igdbClientId, Constants.igdbAccessToken);
    }

    /* WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final String scrapeYoutubeVideoIdByKeywords(String query, List<String> keywords) {
        APICalypse aPICalypseAddOptionsByQuery;
        List<String> groupValues;
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        String endpointFromQuery = getEndpointFromQuery(query);
        List<String> templateTagsFromQuery = getTemplateTagsFromQuery(query);
        if (templateTagsFromQuery.size() != 1 && !Intrinsics.areEqual(templateTagsFromQuery.get(0), "scraperKeyword")) {
            return null;
        }
        MatchResult matchResultFind$default = Regex.find$default(this.igdbConfig.getQueryRegex(), query, 0, 2, null);
        if (((matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) ? null : groupValues.get(1)) != null) {
            Iterator<String> it = keywords.iterator();
            while (it.hasNext()) {
                String genericName = toGenericName(it.next());
                if (genericName != null) {
                    String str = query;
                    try {
                        String strReplace$default = StringsKt.replace$default(str, "{scraperKeyword}", genericName, false, 4, (Object) null);
                        if (Intrinsics.areEqual(endpointFromQuery, "GAMES")) {
                            aPICalypseAddOptionsByQuery = addOptionsByQuery(new APICalypse().fields("videos").limit(1).search(genericName), strReplace$default);
                        } else {
                            if (Intrinsics.areEqual(endpointFromQuery, "SEARCH")) {
                                throw new NotImplementedError("The search endpoint is not currently supported.");
                            }
                            aPICalypseAddOptionsByQuery = null;
                        }
                        if (aPICalypseAddOptionsByQuery == null) {
                            return null;
                        }
                        List<Game> listGames = ProtoRequestKt.games(IGDBWrapper.INSTANCE, aPICalypseAddOptionsByQuery);
                        if (!listGames.isEmpty()) {
                            Iterator<Game> it2 = listGames.iterator();
                            while (it2.hasNext()) {
                                Game next = it2.next();
                                try {
                                    if (next.getVideosCount() > 0) {
                                        List<GameVideo> listGameVideos = ProtoRequestKt.gameVideos(IGDBWrapper.INSTANCE, new APICalypse().fields("*").where("id = " + next.getVideosList().get(0).getId()));
                                        if (!listGameVideos.isEmpty()) {
                                            return listGameVideos.get(0).getVideoId();
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
                    } catch (Exception e2) {
                        getLogger().warn(this, ExceptionsKt.stackTraceToString(e2));
                    }
                    query = str;
                }
            }
        }
        return null;
    }

    private final List<String> getTemplateTagsFromQuery(String body) {
        List<String> groupValues;
        String str;
        MatchResult matchResultFind$default = Regex.find$default(this.igdbConfig.getTemplateTagsRegex(), body, 0, 2, null);
        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = groupValues.get(1)) == null) {
            return CollectionsKt.emptyList();
        }
        return StringsKt.split$default((CharSequence) str, new String[]{CollectionUtils.COMMA}, false, 0, 6, (Object) null);
    }

    private final APICalypse addOptionsByQuery(APICalypse api, String query) {
        List<String> groupValues;
        List<String> groupValues2;
        String str = query;
        String str2 = null;
        MatchResult matchResultFind$default = Regex.find$default(this.igdbConfig.getQueryOptionWhereRegex(), str, 0, 2, null);
        String str3 = (matchResultFind$default == null || (groupValues2 = matchResultFind$default.getGroupValues()) == null) ? null : groupValues2.get(1);
        if (str3 != null) {
            return api.where(str3);
        }
        MatchResult matchResultFind$default2 = Regex.find$default(this.igdbConfig.getQueryOptionSearchRegex(), str, 0, 2, null);
        if (matchResultFind$default2 != null && (groupValues = matchResultFind$default2.getGroupValues()) != null) {
            str2 = groupValues.get(1);
        }
        return str2 != null ? api.search(str2) : api;
    }

    private final String toGenericName(String string) {
        List<String> groupValues;
        String str;
        MatchResult matchResultFind$default = Regex.find$default(this.igdbConfig.getGenericNameRegex(), string, 0, 2, null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null && (str = groupValues.get(1)) != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                String strReplace = new Regex("\\s*-\\s+Disc\\s+\\d+\\s*", RegexOption.IGNORE_CASE).replace(lowerCase, "");
                if (strReplace != null) {
                    String strReplace2 = new Regex("[^0-9a-zA-Z\\s]+").replace(strReplace, "");
                    if (strReplace2 != null) {
                        return new Regex("(\\s+|_+)").replace(strReplace2, " ");
                    }
                }
            }
        }
        return null;
    }

    private final String getEndpointFromQuery(String body) {
        List listSplit$default = StringsKt.split$default((CharSequence) body, new String[]{CollectionUtils.COLON}, false, 0, 6, (Object) null);
        if (listSplit$default.isEmpty()) {
            return null;
        }
        return (String) listSplit$default.get(0);
    }

    /* INFO: compiled from: IGDBScraper.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/magneticchen/daijishou/scraper/v2/impl/IGDBScraper$Config;", "", "genericNameRegex", "Lkotlin/text/Regex;", "templateTagsRegex", "queryRegex", "queryOptionWhereRegex", "queryOptionSearchRegex", "(Lkotlin/text/Regex;Lkotlin/text/Regex;Lkotlin/text/Regex;Lkotlin/text/Regex;Lkotlin/text/Regex;)V", "getGenericNameRegex", "()Lkotlin/text/Regex;", "getQueryOptionSearchRegex", "getQueryOptionWhereRegex", "getQueryRegex", "getTemplateTagsRegex", "component1", "component2", "component3", "component4", "component5", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Config {
        private final Regex genericNameRegex;
        private final Regex queryOptionSearchRegex;
        private final Regex queryOptionWhereRegex;
        private final Regex queryRegex;
        private final Regex templateTagsRegex;

        public Config() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ Config copy$default(Config config, Regex regex, Regex regex2, Regex regex3, Regex regex4, Regex regex5, int i, Object obj) {
            if ((i & 1) != 0) {
                regex = config.genericNameRegex;
            }
            if ((i & 2) != 0) {
                regex2 = config.templateTagsRegex;
            }
            if ((i & 4) != 0) {
                regex3 = config.queryRegex;
            }
            if ((i & 8) != 0) {
                regex4 = config.queryOptionWhereRegex;
            }
            if ((i & 16) != 0) {
                regex5 = config.queryOptionSearchRegex;
            }
            Regex regex6 = regex5;
            Regex regex7 = regex3;
            return config.copy(regex, regex2, regex7, regex4, regex6);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final Regex getGenericNameRegex() {
            return this.genericNameRegex;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final Regex getTemplateTagsRegex() {
            return this.templateTagsRegex;
        }

        /* INFO: renamed from: component3, reason: from getter */
        public final Regex getQueryRegex() {
            return this.queryRegex;
        }

        /* INFO: renamed from: component4, reason: from getter */
        public final Regex getQueryOptionWhereRegex() {
            return this.queryOptionWhereRegex;
        }

        /* INFO: renamed from: component5, reason: from getter */
        public final Regex getQueryOptionSearchRegex() {
            return this.queryOptionSearchRegex;
        }

        public final Config copy(Regex genericNameRegex, Regex templateTagsRegex, Regex queryRegex, Regex queryOptionWhereRegex, Regex queryOptionSearchRegex) {
            Intrinsics.checkNotNullParameter(genericNameRegex, "genericNameRegex");
            Intrinsics.checkNotNullParameter(templateTagsRegex, "templateTagsRegex");
            Intrinsics.checkNotNullParameter(queryRegex, "queryRegex");
            Intrinsics.checkNotNullParameter(queryOptionWhereRegex, "queryOptionWhereRegex");
            Intrinsics.checkNotNullParameter(queryOptionSearchRegex, "queryOptionSearchRegex");
            return new Config(genericNameRegex, templateTagsRegex, queryRegex, queryOptionWhereRegex, queryOptionSearchRegex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return Intrinsics.areEqual(this.genericNameRegex, config.genericNameRegex) && Intrinsics.areEqual(this.templateTagsRegex, config.templateTagsRegex) && Intrinsics.areEqual(this.queryRegex, config.queryRegex) && Intrinsics.areEqual(this.queryOptionWhereRegex, config.queryOptionWhereRegex) && Intrinsics.areEqual(this.queryOptionSearchRegex, config.queryOptionSearchRegex);
        }

        public int hashCode() {
            return (((((((this.genericNameRegex.hashCode() * 31) + this.templateTagsRegex.hashCode()) * 31) + this.queryRegex.hashCode()) * 31) + this.queryOptionWhereRegex.hashCode()) * 31) + this.queryOptionSearchRegex.hashCode();
        }

        public String toString() {
            return "Config(genericNameRegex=" + this.genericNameRegex + ", templateTagsRegex=" + this.templateTagsRegex + ", queryRegex=" + this.queryRegex + ", queryOptionWhereRegex=" + this.queryOptionWhereRegex + ", queryOptionSearchRegex=" + this.queryOptionSearchRegex + ")";
        }

        public Config(Regex genericNameRegex, Regex templateTagsRegex, Regex queryRegex, Regex queryOptionWhereRegex, Regex queryOptionSearchRegex) {
            Intrinsics.checkNotNullParameter(genericNameRegex, "genericNameRegex");
            Intrinsics.checkNotNullParameter(templateTagsRegex, "templateTagsRegex");
            Intrinsics.checkNotNullParameter(queryRegex, "queryRegex");
            Intrinsics.checkNotNullParameter(queryOptionWhereRegex, "queryOptionWhereRegex");
            Intrinsics.checkNotNullParameter(queryOptionSearchRegex, "queryOptionSearchRegex");
            this.genericNameRegex = genericNameRegex;
            this.templateTagsRegex = templateTagsRegex;
            this.queryRegex = queryRegex;
            this.queryOptionWhereRegex = queryOptionWhereRegex;
            this.queryOptionSearchRegex = queryOptionSearchRegex;
        }

        public /* synthetic */ Config(Regex regex, Regex regex2, Regex regex3, Regex regex4, Regex regex5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Constants.INSTANCE.getToGenericNameRegex() : regex, (i & 2) != 0 ? new Regex("^[^:]+:TAGS\\(([0-9a-zA-Z,]*)\\):.*$") : regex2, (i & 4) != 0 ? new Regex("^[^:]+:TAGS\\([0-9a-zA-Z,]*\\):(.*)$") : regex3, (i & 8) != 0 ? new Regex("^.*where\\s+((?:[^;\"]|\"[^\"\\\\]*(?:\\\\.[^\"\\\\]*)*\")*);.*$") : regex4, (i & 16) != 0 ? new Regex("^.*search\\s+\"((?:[^;\"]|[^\"\\\\]*(?:\\\\.[^\"\\\\]*)*)*)\";.*$") : regex5);
        }





    }
}

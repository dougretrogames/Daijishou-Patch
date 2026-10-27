package com.magneticchen.daijishou.data.scraper.v2.impl.dsess;

import android.net.Uri;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionToCategoryPairEntity;
import com.magneticchen.daijishou.data.scraper.v2.AbstractScraper;
import com.magneticchen.daijishou.data.scraper.v2.ScraperConfig;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
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
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: DSESS.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 F2\u00020\u0001:\bFGHIJKLMB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ4\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00070\u001aj\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0007`\u001cH\u0002J4\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00070\u001aj\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0007`\u001cH\u0002J¦\u0001\u0010\u001f\u001a\u00020\u00072\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00070!2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00070!2\u0006\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0(2\b\u0010)\u001a\u0004\u0018\u00010\u00072\b\u0010*\u001a\u0004\u0018\u00010\u00072\b\u0010+\u001a\u0004\u0018\u00010\u00072\b\u0010,\u001a\u0004\u0018\u00010\u00072\b\u0010-\u001a\u0004\u0018\u00010\u00072\b\u0010.\u001a\u0004\u0018\u00010\u00072\b\u0010/\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u00100\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001c\u00101\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00070!2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J \u00102\u001a\b\u0012\u0004\u0012\u00020\u0007032\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u00104\u001a\u00020\u0007H\u0002J\\\u00105\u001a\b\u0012\u0004\u0012\u000206032\u0006\u00107\u001a\u0002082\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00070\u001aj\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0007`\u001c2\b\u0010&\u001a\u0004\u0018\u00010\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0(2\b\u0010)\u001a\u0004\u0018\u00010\u0007H\u0002J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020\u001b0:2\u0006\u0010;\u001a\u00020\u0007H\u0002J\u0012\u0010<\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u0017H\u0002J,\u0010?\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CJ\u0010\u0010D\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010E\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS;", "Lcom/magneticchen/daijishou/data/scraper/v2/AbstractScraper;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "config", "Lcom/magneticchen/daijishou/data/scraper/v2/ScraperConfig;", "string", "", "dsessConfig", "Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$Config;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Lcom/magneticchen/daijishou/data/scraper/v2/ScraperConfig;Ljava/lang/String;Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$Config;)V", "getDsessConfig", "()Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$Config;", "dsessParts", "Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$DSESSParts;", "getDsessParts", "()Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$DSESSParts;", "scraperTargetRegex", "Lkotlin/text/Regex;", "getString", "()Ljava/lang/String;", "templateTagsRegex", "applyTemplateTagsToDSESSURLUri", "Landroid/net/Uri;", "dsessURLUri", "templateValues", "Ljava/util/HashMap;", "Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$Template;", "Lkotlin/collections/HashMap;", "applyTemplateTagsToString", "templateTagValueHashMap", "createDebugLog", "templates", "", "searchEngineSiteURLUri", "dsessUrlParameters", "Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$Parameter;", "dsessTargetSiteSelector", "dsessTargetSiteLabelSubselector", "dsessTargetSiteLabelMatchers", "", "dsessTargetSiteLinkSubselector", "dsessTargetSite", "dsessSelector", "dsessAttribute", "dsessExtractor", "dsessReplacer", "dsessReplacerValue", "extractDSESSPartsFromDSESSString", "extractDSESSURLParametersFromDESSURLUri", "extractStringListFromTightString", "", "splitterRegexString", "extractTargetSiteElementWithInfoListFromElements", "Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$TargetSiteElementWithInfo;", "targetSiteElements", "Lorg/jsoup/select/Elements;", "extractTemplateTagsFromString", "", "templateTagsString", "normalizeString", "removeDsessURLParametersFromDsessURLUri", "uri", "scrape", "scraperKeyword", "platformName", "locale", "Ljava/util/Locale;", "toGenericName", "toStrictGenericName", "Companion", "Config", "DSESSData", "DSESSParts", "Parameter", "Scraper", "TargetSiteElementWithInfo", "Template", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DSESS extends AbstractScraper {
    public static final Companion Companion = new Companion(null);
    private static final ExpiringMap<String, String> dSESSURLUriStringToResultCache = ExpiringMap.builder().maxSize(64).expiration(3, TimeUnit.MINUTES).expirationPolicy(ExpirationPolicy.ACCESSED).build();
    private static final Map<String, Document> dSESSURLUriStringToSearchEngineSiteDocCache;
    private static final ExpiringMap<String, Document> targetSiteURLStringToTargetSiteDocCache;
    private final Config dsessConfig;
    private final DSESSParts dsessParts;
    private final Regex scraperTargetRegex;
    private final String string;
    private final Regex templateTagsRegex;

    /* JADX INFO: compiled from: DSESS.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Template.values().length];
            try {
                iArr[Template.TAG_SCRAPER_KEYWORD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Template.TAG_SCRAPER_KEYWORD_NORMALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Template.TAG_PLATFORM_NAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Template.TAG_LOCALE_LANGUAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Template.TAG_LOCALE_COUNTRY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Template.TAG_LOCALE_LANGUAGE_AND_COUNTRY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final String getString() {
        return this.string;
    }

    public /* synthetic */ DSESS(DaijishouApplication daijishouApplication, ScraperConfig scraperConfig, String str, Config config, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 8) != 0) {
            config = new Config(null, null, null, 7, null);
        }
        this(daijishouApplication, scraperConfig, str, config);
    }

    public final Config getDsessConfig() {
        return this.dsessConfig;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DSESS(DaijishouApplication application, ScraperConfig config, String string, Config dsessConfig) {
        super(application, config);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(dsessConfig, "dsessConfig");
        this.string = string;
        this.dsessConfig = dsessConfig;
        this.scraperTargetRegex = new Regex("^DSESS:([^:]*):.*$");
        this.templateTagsRegex = new Regex("^DSESS:[^:]*:TAGS\\(([^)]*)\\).*$");
        this.dsessParts = extractDSESSPartsFromDSESSString(string);
    }

    public final DSESSParts getDsessParts() {
        return this.dsessParts;
    }

    /* JADX INFO: compiled from: DSESS.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002RN\u0010\u0003\u001aB\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006* \u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\n\u001aB\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\t0\t \u0006* \u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\t0\t\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$Companion;", "", "()V", "dSESSURLUriStringToResultCache", "Lnet/jodah/expiringmap/ExpiringMap;", "", "kotlin.jvm.PlatformType", "dSESSURLUriStringToSearchEngineSiteDocCache", "", "Lorg/jsoup/nodes/Document;", "targetSiteURLStringToTargetSiteDocCache", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Map<String, Document> mapBuild = ExpiringMap.builder().maxSize(64).expiration(3L, TimeUnit.MINUTES).expirationPolicy(ExpirationPolicy.ACCESSED).build();
        Intrinsics.checkNotNullExpressionValue(mapBuild, "build(...)");
        dSESSURLUriStringToSearchEngineSiteDocCache = mapBuild;
        targetSiteURLStringToTargetSiteDocCache = ExpiringMap.builder().maxSize(128).expiration(3L, TimeUnit.MINUTES).expirationPolicy(ExpirationPolicy.ACCESSED).build();
    }

    public static /* synthetic */ String scrape$default(DSESS dsess, String str, String str2, Locale locale, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            locale = null;
        }
        return dsess.scrape(str, str2, locale);
    }

    public final String scrape(String str, String str2, Locale locale) throws UnsupportedEncodingException {
        List listEmptyList;
        String str3;
        String strHtml;
        List<String> groupValues;
        HashMap<Template, String> map = new HashMap<>();
        for (Template template : this.dsessParts.getTemplateTags()) {
            switch (WhenMappings.$EnumSwitchMapping$0[template.ordinal()]) {
                case 1:
                    Intrinsics.checkNotNull(str);
                    map.put(template, str);
                    break;
                case 2:
                    HashMap<Template, String> map2 = map;
                    Intrinsics.checkNotNull(str);
                    String strNormalizeString = normalizeString(str);
                    if (strNormalizeString == null) {
                        strNormalizeString = str;
                    }
                    map2.put(template, strNormalizeString);
                    break;
                case 3:
                    Intrinsics.checkNotNull(str2);
                    map.put(template, str2);
                    break;
                case 4:
                    Intrinsics.checkNotNull(locale);
                    String language = locale.getLanguage();
                    Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
                    map.put(template, language);
                    break;
                case 5:
                    Intrinsics.checkNotNull(locale);
                    String country = locale.getCountry();
                    Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
                    map.put(template, country);
                    break;
                case 6:
                    Intrinsics.checkNotNull(locale);
                    map.put(template, locale.getLanguage() + "-" + locale.getCountry());
                    break;
                default:
                    map.put(template, "");
                    break;
            }
        }
        String dsessURL = this.dsessParts.getDsessURL();
        Intrinsics.checkNotNull(dsessURL);
        Uri uriApplyTemplateTagsToDSESSURLUri = applyTemplateTagsToDSESSURLUri(Uri.parse(applyTemplateTagsToString(dsessURL, map)), map);
        Map dSESSURLUriStringToResultCache2 = dSESSURLUriStringToResultCache;
        String str4 = (String) dSESSURLUriStringToResultCache2.get(uriApplyTemplateTagsToDSESSURLUri.toString());
        if (str4 != null) {
            getLogger().debug(this, "dSESSString -> " + this.string + "\n\nresultString:\n" + str4 + "\n\nReturn with cached result.");
            return str4;
        }
        Map<Parameter, String> mapExtractDSESSURLParametersFromDESSURLUri = extractDSESSURLParametersFromDESSURLUri(uriApplyTemplateTagsToDSESSURLUri);
        String str5 = mapExtractDSESSURLParametersFromDESSURLUri.get(Parameter.TARGET_SITE_SELECTOR);
        if (str5 == null) {
            str5 = "a";
        }
        String str6 = mapExtractDSESSURLParametersFromDESSURLUri.get(Parameter.TARGET_SITE_LABEL_SUBSELECTOR);
        String str7 = mapExtractDSESSURLParametersFromDESSURLUri.get(Parameter.TARGET_SITE_LABEL_MATCHERS);
        String str8 = mapExtractDSESSURLParametersFromDESSURLUri.get(Parameter.TARGET_SITE_LINK_SUBSELECTOR);
        String str9 = mapExtractDSESSURLParametersFromDESSURLUri.get(Parameter.TARGET_SITE);
        String str10 = mapExtractDSESSURLParametersFromDESSURLUri.get(Parameter.SELECTOR);
        String str11 = mapExtractDSESSURLParametersFromDESSURLUri.get(Parameter.ATTRIBUTE);
        String str12 = mapExtractDSESSURLParametersFromDESSURLUri.get(Parameter.EXTRACTOR);
        String str13 = mapExtractDSESSURLParametersFromDESSURLUri.get(Parameter.REPLACER);
        String str14 = mapExtractDSESSURLParametersFromDESSURLUri.get(Parameter.REPLACER_VALUE);
        String str15 = str7;
        if (str15 != null && str15.length() != 0) {
            listEmptyList = extractTemplateTagsFromString(str7);
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        Collection<? extends Template> collection = listEmptyList;
        final Uri uriRemoveDsessURLParametersFromDsessURLUri = removeDsessURLParametersFromDsessURLUri(uriApplyTemplateTagsToDSESSURLUri);
        String string = uriApplyTemplateTagsToDSESSURLUri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String str16 = str5;
        String string2 = uriRemoveDsessURLParametersFromDsessURLUri.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        String strCreateDebugLog = createDebugLog(map, string, string2, mapExtractDSESSURLParametersFromDESSURLUri, str16, str6, collection, str8, str9, str10, str11, str12, str13, str14);
        if (str10 == null) {
            Intrinsics.checkNotNullExpressionValue(dSESSURLUriStringToResultCache2, "dSESSURLUriStringToResultCache");
            dSESSURLUriStringToResultCache2.put(uriApplyTemplateTagsToDSESSURLUri.toString(), null);
            getLogger().debug(this, "Aborted because dsessSelector is null.\n" + strCreateDebugLog);
            return null;
        }
        Map<String, Document> map3 = dSESSURLUriStringToSearchEngineSiteDocCache;
        String string3 = uriRemoveDsessURLParametersFromDsessURLUri.toString();
        final Function1<String, Document> function1 = new Function1<String, Document>() { // from class: com.magneticchen.daijishou.data.scraper.v2.impl.dsess.DSESS$scrape$searchEngineSiteDocument$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public final Document invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Connection connectionConnect = Jsoup.connect(uriRemoveDsessURLParametersFromDsessURLUri.toString());
                DSESS dsess = this;
                Uri uri = uriRemoveDsessURLParametersFromDsessURLUri;
                connectionConnect.timeout(dsess.getConfig().getJsoupConnectTimeout());
                connectionConnect.userAgent(dsess.getConfig().getJsoupUserAgent());
                String string4 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
                Map<String, String> cookiesFromURLStringFromCache = dsess.getCookiesFromURLStringFromCache(string4, dsess.getConfig().getBaseURLStringCookiesCache());
                if (cookiesFromURLStringFromCache != null) {
                    connectionConnect.cookies(cookiesFromURLStringFromCache);
                }
                return connectionConnect.get();
            }
        };
        Document documentComputeIfAbsent = map3.computeIfAbsent(string3, new Function() { // from class: com.magneticchen.daijishou.data.scraper.v2.impl.dsess.DSESS$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DSESS.scrape$lambda$0(function1, obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(documentComputeIfAbsent, "computeIfAbsent(...)");
        Document document = documentComputeIfAbsent;
        if (str9 != null) {
            Elements elementsSelect = document.select(str16);
            Intrinsics.checkNotNullExpressionValue(elementsSelect, "select(...)");
            str3 = null;
            Iterator<TargetSiteElementWithInfo> it = extractTargetSiteElementWithInfoListFromElements(elementsSelect, map, str16, collection, str8).iterator();
            while (true) {
                if (it.hasNext()) {
                    TargetSiteElementWithInfo next = it.next();
                    final String targetSiteLink = next.getTargetSiteLink();
                    if (targetSiteLink != null) {
                        strCreateDebugLog = strCreateDebugLog + "targetSite candidate -> score: " + next.getScore() + ", siteURLString: " + targetSiteLink + "\n";
                        if (new Regex(str9).matches(targetSiteLink)) {
                            ExpiringMap<String, Document> expiringMap = targetSiteURLStringToTargetSiteDocCache;
                            final Function1<String, Document> function2 = new Function1<String, Document>() { // from class: com.magneticchen.daijishou.data.scraper.v2.impl.dsess.DSESS$scrape$targetSiteDocument$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                

                                @Override // kotlin.jvm.functions.Function1
                                public final Document invoke(String str17) {
                                    Connection connectionConnect = Jsoup.connect(targetSiteLink);
                                    DSESS dsess = this;
                                    String str18 = targetSiteLink;
                                    connectionConnect.timeout(dsess.getConfig().getJsoupConnectTimeout());
                                    connectionConnect.userAgent(dsess.getConfig().getJsoupUserAgent());
                                    Map<String, String> cookiesFromURLStringFromCache = dsess.getCookiesFromURLStringFromCache(str18, dsess.getConfig().getBaseURLStringCookiesCache());
                                    if (cookiesFromURLStringFromCache != null) {
                                        connectionConnect.cookies(cookiesFromURLStringFromCache);
                                    }
                                    return connectionConnect.get();
                                }
                            };
                            document = (Document) expiringMap.computeIfAbsent(targetSiteLink, new Function() { // from class: com.magneticchen.daijishou.data.scraper.v2.impl.dsess.DSESS$$ExternalSyntheticLambda1
                                @Override // java.util.function.Function
                                public final Object apply(Object obj) {
                                    return DSESS.scrape$lambda$1(function2, obj);
                                }
                            });
                        }
                    }
                } else {
                    document = null;
                }
            }
        } else {
            str3 = null;
        }
        String str17 = strCreateDebugLog + "targetSiteURL finale -> " + (document != null ? document.baseUri() : str3) + "\n";
        if (document == null) {
            dSESSURLUriStringToResultCache.remove(uriApplyTemplateTagsToDSESSURLUri.toString());
            getLogger().debug(this, "Aborted because targetSiteDocument is null.\n" + str17 + "\n");
            return str3;
        }
        Element elementSelectFirst = document.selectFirst(str10);
        if (elementSelectFirst == null) {
            dSESSURLUriStringToResultCache.remove(uriApplyTemplateTagsToDSESSURLUri.toString());
            getLogger().debug(this, "Aborted because selectedDocument is null. Using dSESSSelector '" + str10 + "'.\n" + str17 + "\n");
            return str3;
        }
        if (str11 != null) {
            strHtml = elementSelectFirst.attr(str11);
        } else {
            strHtml = elementSelectFirst.html();
        }
        String strDecode = URLDecoder.decode(strHtml, "UTF-8");
        String str18 = str17 + "SelectedContentString is '" + strDecode + "'\n";
        if (str12 != null) {
            Regex regex = new Regex(str12);
            Intrinsics.checkNotNull(strDecode);
            MatchResult matchResultFind$default = Regex.find$default(regex, strDecode, 0, 2, str3);
            strDecode = (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) ? str3 : groupValues.get(1);
        }
        String str19 = str18 + "StringAfterExtractor is '" + strDecode + "'\n";
        if (str13 != null && str14 != null) {
            strDecode = strDecode != null ? new Regex(str13).replace(strDecode, str14) : str3;
        }
        String str20 = str19 + "StringAfterReplacer is '" + strDecode + "'\n";
        if (str11 != null && strDecode != null && StringsKt.startsWith$default(strDecode, "/", false, 2, (Object) str3)) {
            strDecode = getBaseURLStringFromURL(new URL(document.baseUri())) + strDecode;
        }
        String str21 = (str20 + "ResultString is '" + strDecode + "'\n") + "Process successful.";
        Map dSESSURLUriStringToResultCache3 = dSESSURLUriStringToResultCache;
        Intrinsics.checkNotNullExpressionValue(dSESSURLUriStringToResultCache3, "dSESSURLUriStringToResultCache");
        dSESSURLUriStringToResultCache3.put(uriApplyTemplateTagsToDSESSURLUri.toString(), strDecode);
        getLogger().debug(this, str21);
        return strDecode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Document scrape$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (Document) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Document scrape$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (Document) tmp0.invoke(obj);
    }

    private final Uri applyTemplateTagsToDSESSURLUri(Uri uri, HashMap<Template, String> map) {
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
        for (String str : queryParameterNames) {
            String queryParameter = uri.getQueryParameter(str);
            if (queryParameter != null) {
                String strReplace$default = queryParameter;
                for (Map.Entry<Template, String> entry : map.entrySet()) {
                    Template key = entry.getKey();
                    strReplace$default = StringsKt.replace$default(strReplace$default, key.getLabel(), entry.getValue(), false, 4, (Object) null);
                }
                builderClearQuery.appendQueryParameter(str, strReplace$default);
            }
        }
        Uri uriBuild = builderClearQuery.build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "build(...)");
        return uriBuild;
    }

    private final String normalizeString(String str) {
        List<String> groupValues;
        String str2;
        MatchResult matchResultFind$default = Regex.find$default(this.dsessConfig.getGenericNameRegex(), str, 0, 2, null);
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
                        return new Regex("[^0-9a-zA-Z\\s]+").replace(strReplace2, "");
                    }
                }
            }
        }
        return null;
    }

    private final String applyTemplateTagsToString(String str, HashMap<Template, String> map) throws UnsupportedEncodingException {
        String strReplace$default = str;
        for (Map.Entry<Template, String> entry : map.entrySet()) {
            Template key = entry.getKey();
            String value = entry.getValue();
            String label = key.getLabel();
            String strEncode = URLEncoder.encode(value, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(strEncode, "encode(...)");
            strReplace$default = StringsKt.replace$default(StringsKt.replace$default(strReplace$default, label, strEncode, false, 4, (Object) null), "+", "%20", false, 4, (Object) null);
        }
        return strReplace$default;
    }

    private final Uri removeDsessURLParametersFromDsessURLUri(Uri uri) {
        Parameter next;
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
        for (String str : queryParameterNames) {
            Iterator<Parameter> it = Parameter.getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(next.getLabel(), str));
            if (next == null) {
                builderClearQuery.appendQueryParameter(str, uri.getQueryParameter(str));
            }
        }
        Uri uriBuild = builderClearQuery.build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "build(...)");
        return uriBuild;
    }

    private final DSESSParts extractDSESSPartsFromDSESSString(String str) {
        Scraper next;
        List<String> groupValues;
        List<String> groupValues2;
        List<String> groupValues3;
        ArrayList arrayList = new ArrayList();
        String str2 = str;
        String str3 = null;
        MatchResult matchResultFind$default = Regex.find$default(this.scraperTargetRegex, str2, 0, 2, null);
        String str4 = (matchResultFind$default == null || (groupValues3 = matchResultFind$default.getGroupValues()) == null) ? null : groupValues3.get(1);
        Iterator<Scraper> it = Scraper.getEntries().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(next.getLabel(), str4));
        Scraper scraper = next;
        if (scraper == null) {
            scraper = Scraper.TARGET_NONE;
        }
        MatchResult matchResultFind$default2 = Regex.find$default(this.templateTagsRegex, str2, 0, 2, null);
        String str5 = (matchResultFind$default2 == null || (groupValues2 = matchResultFind$default2.getGroupValues()) == null) ? null : groupValues2.get(1);
        if (str5 != null) {
            arrayList.addAll(extractTemplateTagsFromString(str5));
        }
        MatchResult matchResultFind$default3 = Regex.find$default(this.dsessConfig.getDSESSURLRegex(), str2, 0, 2, null);
        if (matchResultFind$default3 != null && (groupValues = matchResultFind$default3.getGroupValues()) != null) {
            str3 = groupValues.get(1);
        }
        return new DSESSParts(scraper, arrayList, str3);
    }

    private final Set<Template> extractTemplateTagsFromString(String str) {
        Template next;
        HashSet hashSet = new HashSet();
        List listExtractStringListFromTightString$default = extractStringListFromTightString$default(this, str, null, 2, null);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : listExtractStringListFromTightString$default) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        for (String str2 : arrayList) {
            Iterator<Template> it = Template.getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(next.getLabel(), "{" + str2 + "}"));
            Template template = next;
            if (template != null) {
                hashSet.add(template);
            }
        }
        return hashSet;
    }

    static /* synthetic */ List extractStringListFromTightString$default(DSESS dsess, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "\\,";
        }
        return dsess.extractStringListFromTightString(str, str2);
    }

    private final List<String> extractStringListFromTightString(String str, String str2) {
        return new Regex("\\s*" + str2 + "\\s*").split(str, 0);
    }

    private final Map<Parameter, String> extractDSESSURLParametersFromDESSURLUri(Uri uri) {
        HashMap map = new HashMap();
        for (Parameter parameter : Parameter.getEntries()) {
            String queryParameter = uri.getQueryParameter(parameter.getLabel());
            if (queryParameter != null) {
                map.put(parameter, queryParameter);
            }
        }
        return map;
    }

    private final List<TargetSiteElementWithInfo> extractTargetSiteElementWithInfoListFromElements(Elements elements, HashMap<Template, String> map, String str, Collection<? extends Template> collection, String str2) {
        ArrayList<TargetSiteElementWithInfo> arrayList = new ArrayList();
        Iterator it = elements.iterator();
        while (true) {
            String strAbsUrl = null;
            if (!it.hasNext()) {
                break;
            }
            Element element = (Element) it.next();
            Element elementSelectFirst = element.selectFirst(str2 == null ? "a" : str2);
            if (elementSelectFirst != null) {
                strAbsUrl = elementSelectFirst.absUrl("href");
            }
            Intrinsics.checkNotNull(element);
            arrayList.add(new TargetSiteElementWithInfo(0, strAbsUrl, null, element, 5, null));
        }
        if (str == null || map.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        if (collection.isEmpty()) {
            Set<Template> setKeySet = map.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
            arrayList2.addAll(setKeySet);
        } else {
            arrayList2.addAll(collection);
        }
        for (TargetSiteElementWithInfo targetSiteElementWithInfo : arrayList) {
            String strText = targetSiteElementWithInfo.getTargetSiteElement().select(str).text();
            targetSiteElementWithInfo.setLabel(strText);
            Intrinsics.checkNotNull(strText);
            String strictGenericName = toStrictGenericName(strText);
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                String str3 = map.get((Template) it2.next());
                if (str3 != null) {
                    String strictGenericName2 = toStrictGenericName(str3);
                    if (Intrinsics.areEqual(strictGenericName2, strictGenericName)) {
                        targetSiteElementWithInfo.setScore(targetSiteElementWithInfo.getScore() + 5);
                    } else if (StringsKt.contains$default((CharSequence) strictGenericName, (CharSequence) strictGenericName2, false, 2, (Object) null)) {
                        targetSiteElementWithInfo.setScore(targetSiteElementWithInfo.getScore() + 1);
                    }
                }
            }
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.magneticchen.daijishou.data.scraper.v2.impl.dsess.DSESS$extractTargetSiteElementWithInfoListFromElements$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((DSESS.TargetSiteElementWithInfo) t).getScore()), Integer.valueOf(((DSESS.TargetSiteElementWithInfo) t2).getScore()));
            }
        });
    }

    private final String toStrictGenericName(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return new Regex("[^0-9a-zA-Z]+").replace(lowerCase, "");
    }

    public final String toGenericName(String string) {
        List<String> groupValues;
        String str;
        Intrinsics.checkNotNullParameter(string, "string");
        MatchResult matchResultFind$default = Regex.find$default(this.dsessConfig.getGenericNameRegex(), string, 0, 2, null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null && (str = groupValues.get(1)) != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
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

    private final String createDebugLog(Map<Template, String> map, String str, String str2, Map<Parameter, String> map2, String str3, String str4, Collection<? extends Template> collection, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbAppend = sb.append("Meta:");
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend.append('\n'), "append(...)");
        StringBuilder sbAppend2 = sb.append("  dSESSString -> " + this.string);
        Intrinsics.checkNotNullExpressionValue(sbAppend2, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend2.append('\n'), "append(...)");
        StringBuilder sbAppend3 = sb.append("  templateTagPairList -> " + map);
        Intrinsics.checkNotNullExpressionValue(sbAppend3, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend3.append('\n'), "append(...)");
        StringBuilder sbAppend4 = sb.append("  dSESSStringAfterAppliedTemplate -> " + str);
        Intrinsics.checkNotNullExpressionValue(sbAppend4, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend4.append('\n'), "append(...)");
        StringBuilder sbAppend5 = sb.append("  searchEngineSiteURL -> " + str2);
        Intrinsics.checkNotNullExpressionValue(sbAppend5, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend5.append('\n'), "append(...)");
        StringBuilder sbAppend6 = sb.append("  dSESSURLParameters -> " + map2);
        Intrinsics.checkNotNullExpressionValue(sbAppend6, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend6.append('\n'), "append(...)");
        Intrinsics.checkNotNullExpressionValue(sb.append('\n'), "append(...)");
        StringBuilder sbAppend7 = sb.append("Select The Target Site:");
        Intrinsics.checkNotNullExpressionValue(sbAppend7, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend7.append('\n'), "append(...)");
        StringBuilder sbAppend8 = sb.append("  dSESSTargetSiteSelector -> " + str3);
        Intrinsics.checkNotNullExpressionValue(sbAppend8, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend8.append('\n'), "append(...)");
        StringBuilder sbAppend9 = sb.append("  dSESSTargetSiteLabelSubselector -> " + str4);
        Intrinsics.checkNotNullExpressionValue(sbAppend9, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend9.append('\n'), "append(...)");
        StringBuilder sbAppend10 = sb.append("  dSESSTargetSiteLabelMatchers -> " + collection);
        Intrinsics.checkNotNullExpressionValue(sbAppend10, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend10.append('\n'), "append(...)");
        StringBuilder sbAppend11 = sb.append("  dSESSTargetSiteLinkSubselector -> " + str5);
        Intrinsics.checkNotNullExpressionValue(sbAppend11, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend11.append('\n'), "append(...)");
        StringBuilder sbAppend12 = sb.append("  dSESSTargetSite (Regex) -> " + str6);
        Intrinsics.checkNotNullExpressionValue(sbAppend12, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend12.append('\n'), "append(...)");
        Intrinsics.checkNotNullExpressionValue(sb.append('\n'), "append(...)");
        StringBuilder sbAppend13 = sb.append("In The Target Site:");
        Intrinsics.checkNotNullExpressionValue(sbAppend13, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend13.append('\n'), "append(...)");
        StringBuilder sbAppend14 = sb.append("  dSESSSelector -> " + str7);
        Intrinsics.checkNotNullExpressionValue(sbAppend14, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend14.append('\n'), "append(...)");
        StringBuilder sbAppend15 = sb.append("  dSESSAttribute -> " + str8);
        Intrinsics.checkNotNullExpressionValue(sbAppend15, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend15.append('\n'), "append(...)");
        StringBuilder sbAppend16 = sb.append("  dSESSExtractor (Regex) -> " + str9);
        Intrinsics.checkNotNullExpressionValue(sbAppend16, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend16.append('\n'), "append(...)");
        StringBuilder sbAppend17 = sb.append("  dSESSReplacer (Regex) -> " + str10);
        Intrinsics.checkNotNullExpressionValue(sbAppend17, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend17.append('\n'), "append(...)");
        StringBuilder sbAppend18 = sb.append("  dSESSReplacerValue -> " + str11);
        Intrinsics.checkNotNullExpressionValue(sbAppend18, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend18.append('\n'), "append(...)");
        Intrinsics.checkNotNullExpressionValue(sb.append('\n'), "append(...)");
        StringBuilder sbAppend19 = sb.append("Executed results:");
        Intrinsics.checkNotNullExpressionValue(sbAppend19, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend19.append('\n'), "append(...)");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: compiled from: DSESS.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0015J\u0015\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u0015\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\rHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003JÃ\u0001\u00105\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$¨\u0006<"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$DSESSData;", "", "templates", "", "Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$Template;", "", "dsessURLUri", "searchEngineSiteURLUri", "dsessUrlParameters", "Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$Parameter;", "dsessTargetSiteSelector", "dsessTargetSiteLabelSubselector", "dsessTargetSiteLabelMatchers", "", "dsessTargetSiteLinkSubselector", "dsessTargetSite", "dsessSelector", "dsessAttribute", "dsessExtractor", "dsessReplacer", "dsessReplacerValue", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDsessAttribute", "()Ljava/lang/String;", "getDsessExtractor", "getDsessReplacer", "getDsessReplacerValue", "getDsessSelector", "getDsessTargetSite", "getDsessTargetSiteLabelMatchers", "()Ljava/util/Collection;", "getDsessTargetSiteLabelSubselector", "getDsessTargetSiteLinkSubselector", "getDsessTargetSiteSelector", "getDsessURLUri", "getDsessUrlParameters", "()Ljava/util/Map;", "getSearchEngineSiteURLUri", "getTemplates", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DSESSData {
        private final String dsessAttribute;
        private final String dsessExtractor;
        private final String dsessReplacer;
        private final String dsessReplacerValue;
        private final String dsessSelector;
        private final String dsessTargetSite;
        private final Collection<Template> dsessTargetSiteLabelMatchers;
        private final String dsessTargetSiteLabelSubselector;
        private final String dsessTargetSiteLinkSubselector;
        private final String dsessTargetSiteSelector;
        private final String dsessURLUri;
        private final Map<Parameter, String> dsessUrlParameters;
        private final String searchEngineSiteURLUri;
        private final Map<Template, String> templates;

        public final Map<Template, String> component1() {
            return this.templates;
        }

        public final String component10() {
            return this.dsessSelector;
        }

        public final String component11() {
            return this.dsessAttribute;
        }

        public final String component12() {
            return this.dsessExtractor;
        }

        public final String component13() {
            return this.dsessReplacer;
        }

        public final String component14() {
            return this.dsessReplacerValue;
        }

        public final String component2() {
            return this.dsessURLUri;
        }

        public final String component3() {
            return this.searchEngineSiteURLUri;
        }

        public final Map<Parameter, String> component4() {
            return this.dsessUrlParameters;
        }

        public final String component5() {
            return this.dsessTargetSiteSelector;
        }

        public final String component6() {
            return this.dsessTargetSiteLabelSubselector;
        }

        public final Collection<Template> component7() {
            return this.dsessTargetSiteLabelMatchers;
        }

        public final String component8() {
            return this.dsessTargetSiteLinkSubselector;
        }

        public final String component9() {
            return this.dsessTargetSite;
        }

        public final DSESSData copy(Map<Template, String> templates, String dsessURLUri, String searchEngineSiteURLUri, Map<Parameter, String> dsessUrlParameters, String dsessTargetSiteSelector, String str, Collection<? extends Template> dsessTargetSiteLabelMatchers, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            Intrinsics.checkNotNullParameter(templates, "templates");
            Intrinsics.checkNotNullParameter(dsessURLUri, "dsessURLUri");
            Intrinsics.checkNotNullParameter(searchEngineSiteURLUri, "searchEngineSiteURLUri");
            Intrinsics.checkNotNullParameter(dsessUrlParameters, "dsessUrlParameters");
            Intrinsics.checkNotNullParameter(dsessTargetSiteSelector, "dsessTargetSiteSelector");
            Intrinsics.checkNotNullParameter(dsessTargetSiteLabelMatchers, "dsessTargetSiteLabelMatchers");
            return new DSESSData(templates, dsessURLUri, searchEngineSiteURLUri, dsessUrlParameters, dsessTargetSiteSelector, str, dsessTargetSiteLabelMatchers, str2, str3, str4, str5, str6, str7, str8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DSESSData)) {
                return false;
            }
            DSESSData dSESSData = (DSESSData) obj;
            return Intrinsics.areEqual(this.templates, dSESSData.templates) && Intrinsics.areEqual(this.dsessURLUri, dSESSData.dsessURLUri) && Intrinsics.areEqual(this.searchEngineSiteURLUri, dSESSData.searchEngineSiteURLUri) && Intrinsics.areEqual(this.dsessUrlParameters, dSESSData.dsessUrlParameters) && Intrinsics.areEqual(this.dsessTargetSiteSelector, dSESSData.dsessTargetSiteSelector) && Intrinsics.areEqual(this.dsessTargetSiteLabelSubselector, dSESSData.dsessTargetSiteLabelSubselector) && Intrinsics.areEqual(this.dsessTargetSiteLabelMatchers, dSESSData.dsessTargetSiteLabelMatchers) && Intrinsics.areEqual(this.dsessTargetSiteLinkSubselector, dSESSData.dsessTargetSiteLinkSubselector) && Intrinsics.areEqual(this.dsessTargetSite, dSESSData.dsessTargetSite) && Intrinsics.areEqual(this.dsessSelector, dSESSData.dsessSelector) && Intrinsics.areEqual(this.dsessAttribute, dSESSData.dsessAttribute) && Intrinsics.areEqual(this.dsessExtractor, dSESSData.dsessExtractor) && Intrinsics.areEqual(this.dsessReplacer, dSESSData.dsessReplacer) && Intrinsics.areEqual(this.dsessReplacerValue, dSESSData.dsessReplacerValue);
        }

        public int hashCode() {
            int iHashCode = ((((((((this.templates.hashCode() * 31) + this.dsessURLUri.hashCode()) * 31) + this.searchEngineSiteURLUri.hashCode()) * 31) + this.dsessUrlParameters.hashCode()) * 31) + this.dsessTargetSiteSelector.hashCode()) * 31;
            String str = this.dsessTargetSiteLabelSubselector;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.dsessTargetSiteLabelMatchers.hashCode()) * 31;
            String str2 = this.dsessTargetSiteLinkSubselector;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.dsessTargetSite;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.dsessSelector;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.dsessAttribute;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.dsessExtractor;
            int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.dsessReplacer;
            int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.dsessReplacerValue;
            return iHashCode8 + (str8 != null ? str8.hashCode() : 0);
        }

        public String toString() {
            return "DSESSData(templates=" + this.templates + ", dsessURLUri=" + this.dsessURLUri + ", searchEngineSiteURLUri=" + this.searchEngineSiteURLUri + ", dsessUrlParameters=" + this.dsessUrlParameters + ", dsessTargetSiteSelector=" + this.dsessTargetSiteSelector + ", dsessTargetSiteLabelSubselector=" + this.dsessTargetSiteLabelSubselector + ", dsessTargetSiteLabelMatchers=" + this.dsessTargetSiteLabelMatchers + ", dsessTargetSiteLinkSubselector=" + this.dsessTargetSiteLinkSubselector + ", dsessTargetSite=" + this.dsessTargetSite + ", dsessSelector=" + this.dsessSelector + ", dsessAttribute=" + this.dsessAttribute + ", dsessExtractor=" + this.dsessExtractor + ", dsessReplacer=" + this.dsessReplacer + ", dsessReplacerValue=" + this.dsessReplacerValue + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DSESSData(Map<Template, String> templates, String dsessURLUri, String searchEngineSiteURLUri, Map<Parameter, String> dsessUrlParameters, String dsessTargetSiteSelector, String str, Collection<? extends Template> dsessTargetSiteLabelMatchers, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            Intrinsics.checkNotNullParameter(templates, "templates");
            Intrinsics.checkNotNullParameter(dsessURLUri, "dsessURLUri");
            Intrinsics.checkNotNullParameter(searchEngineSiteURLUri, "searchEngineSiteURLUri");
            Intrinsics.checkNotNullParameter(dsessUrlParameters, "dsessUrlParameters");
            Intrinsics.checkNotNullParameter(dsessTargetSiteSelector, "dsessTargetSiteSelector");
            Intrinsics.checkNotNullParameter(dsessTargetSiteLabelMatchers, "dsessTargetSiteLabelMatchers");
            this.templates = templates;
            this.dsessURLUri = dsessURLUri;
            this.searchEngineSiteURLUri = searchEngineSiteURLUri;
            this.dsessUrlParameters = dsessUrlParameters;
            this.dsessTargetSiteSelector = dsessTargetSiteSelector;
            this.dsessTargetSiteLabelSubselector = str;
            this.dsessTargetSiteLabelMatchers = dsessTargetSiteLabelMatchers;
            this.dsessTargetSiteLinkSubselector = str2;
            this.dsessTargetSite = str3;
            this.dsessSelector = str4;
            this.dsessAttribute = str5;
            this.dsessExtractor = str6;
            this.dsessReplacer = str7;
            this.dsessReplacerValue = str8;
        }

        public final Map<Template, String> getTemplates() {
            return this.templates;
        }

        public final String getDsessURLUri() {
            return this.dsessURLUri;
        }

        public final String getSearchEngineSiteURLUri() {
            return this.searchEngineSiteURLUri;
        }

        public final Map<Parameter, String> getDsessUrlParameters() {
            return this.dsessUrlParameters;
        }

        public final String getDsessTargetSiteSelector() {
            return this.dsessTargetSiteSelector;
        }

        public final String getDsessTargetSiteLabelSubselector() {
            return this.dsessTargetSiteLabelSubselector;
        }

        public final Collection<Template> getDsessTargetSiteLabelMatchers() {
            return this.dsessTargetSiteLabelMatchers;
        }

        public final String getDsessTargetSiteLinkSubselector() {
            return this.dsessTargetSiteLinkSubselector;
        }

        public final String getDsessTargetSite() {
            return this.dsessTargetSite;
        }

        public final String getDsessSelector() {
            return this.dsessSelector;
        }

        public final String getDsessAttribute() {
            return this.dsessAttribute;
        }

        public final String getDsessExtractor() {
            return this.dsessExtractor;
        }

        public final String getDsessReplacer() {
            return this.dsessReplacer;
        }

        public final String getDsessReplacerValue() {
            return this.dsessReplacerValue;
        }
    }

    /* JADX INFO: compiled from: DSESS.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$DSESSParts;", "", ExtensionRepositoryExtensionToCategoryPairEntity.SCRAPER_CATEGORY, "Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$Scraper;", "templateTags", "", "Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$Template;", "dsessURL", "", "(Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$Scraper;Ljava/util/List;Ljava/lang/String;)V", "getDsessURL", "()Ljava/lang/String;", "getScraper", "()Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$Scraper;", "getTemplateTags", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DSESSParts {
        private final String dsessURL;
        private final Scraper scraper;
        private final List<Template> templateTags;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DSESSParts copy$default(DSESSParts dSESSParts, Scraper scraper, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                scraper = dSESSParts.scraper;
            }
            if ((i & 2) != 0) {
                list = dSESSParts.templateTags;
            }
            if ((i & 4) != 0) {
                str = dSESSParts.dsessURL;
            }
            return dSESSParts.copy(scraper, list, str);
        }

        public final Scraper component1() {
            return this.scraper;
        }

        public final List<Template> component2() {
            return this.templateTags;
        }

        public final String component3() {
            return this.dsessURL;
        }

        public final DSESSParts copy(Scraper scraper, List<? extends Template> templateTags, String str) {
            Intrinsics.checkNotNullParameter(scraper, "scraper");
            Intrinsics.checkNotNullParameter(templateTags, "templateTags");
            return new DSESSParts(scraper, templateTags, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DSESSParts)) {
                return false;
            }
            DSESSParts dSESSParts = (DSESSParts) obj;
            return this.scraper == dSESSParts.scraper && Intrinsics.areEqual(this.templateTags, dSESSParts.templateTags) && Intrinsics.areEqual(this.dsessURL, dSESSParts.dsessURL);
        }

        public int hashCode() {
            int iHashCode = ((this.scraper.hashCode() * 31) + this.templateTags.hashCode()) * 31;
            String str = this.dsessURL;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "DSESSParts(scraper=" + this.scraper + ", templateTags=" + this.templateTags + ", dsessURL=" + this.dsessURL + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DSESSParts(Scraper scraper, List<? extends Template> templateTags, String str) {
            Intrinsics.checkNotNullParameter(scraper, "scraper");
            Intrinsics.checkNotNullParameter(templateTags, "templateTags");
            this.scraper = scraper;
            this.templateTags = templateTags;
            this.dsessURL = str;
        }

        public /* synthetic */ DSESSParts(Scraper scraper, List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(scraper, list, (i & 4) != 0 ? null : str);
        }

        public final Scraper getScraper() {
            return this.scraper;
        }

        public final List<Template> getTemplateTags() {
            return this.templateTags;
        }

        public final String getDsessURL() {
            return this.dsessURL;
        }
    }

    /* JADX INFO: compiled from: DSESS.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J5\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\""}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$TargetSiteElementWithInfo;", "", "score", "", "targetSiteLink", "", "label", "targetSiteElement", "Lorg/jsoup/nodes/Element;", "(ILjava/lang/String;Ljava/lang/String;Lorg/jsoup/nodes/Element;)V", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "getScore", "()I", "setScore", "(I)V", "getTargetSiteElement", "()Lorg/jsoup/nodes/Element;", "setTargetSiteElement", "(Lorg/jsoup/nodes/Element;)V", "getTargetSiteLink", "setTargetSiteLink", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TargetSiteElementWithInfo {
        private String label;
        private int score;
        private Element targetSiteElement;
        private String targetSiteLink;

        public static /* synthetic */ TargetSiteElementWithInfo copy$default(TargetSiteElementWithInfo targetSiteElementWithInfo, int i, String str, String str2, Element element, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = targetSiteElementWithInfo.score;
            }
            if ((i2 & 2) != 0) {
                str = targetSiteElementWithInfo.targetSiteLink;
            }
            if ((i2 & 4) != 0) {
                str2 = targetSiteElementWithInfo.label;
            }
            if ((i2 & 8) != 0) {
                element = targetSiteElementWithInfo.targetSiteElement;
            }
            return targetSiteElementWithInfo.copy(i, str, str2, element);
        }

        public final int component1() {
            return this.score;
        }

        public final String component2() {
            return this.targetSiteLink;
        }

        public final String component3() {
            return this.label;
        }

        public final Element component4() {
            return this.targetSiteElement;
        }

        public final TargetSiteElementWithInfo copy(int i, String str, String str2, Element targetSiteElement) {
            Intrinsics.checkNotNullParameter(targetSiteElement, "targetSiteElement");
            return new TargetSiteElementWithInfo(i, str, str2, targetSiteElement);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TargetSiteElementWithInfo)) {
                return false;
            }
            TargetSiteElementWithInfo targetSiteElementWithInfo = (TargetSiteElementWithInfo) obj;
            return this.score == targetSiteElementWithInfo.score && Intrinsics.areEqual(this.targetSiteLink, targetSiteElementWithInfo.targetSiteLink) && Intrinsics.areEqual(this.label, targetSiteElementWithInfo.label) && Intrinsics.areEqual(this.targetSiteElement, targetSiteElementWithInfo.targetSiteElement);
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.score) * 31;
            String str = this.targetSiteLink;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.label;
            return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.targetSiteElement.hashCode();
        }

        public String toString() {
            return "TargetSiteElementWithInfo(score=" + this.score + ", targetSiteLink=" + this.targetSiteLink + ", label=" + this.label + ", targetSiteElement=" + this.targetSiteElement + ")";
        }

        public TargetSiteElementWithInfo(int i, String str, String str2, Element targetSiteElement) {
            Intrinsics.checkNotNullParameter(targetSiteElement, "targetSiteElement");
            this.score = i;
            this.targetSiteLink = str;
            this.label = str2;
            this.targetSiteElement = targetSiteElement;
        }

        public /* synthetic */ TargetSiteElementWithInfo(int i, String str, String str2, Element element, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, element);
        }

        public final int getScore() {
            return this.score;
        }

        public final void setScore(int i) {
            this.score = i;
        }

        public final String getTargetSiteLink() {
            return this.targetSiteLink;
        }

        public final void setTargetSiteLink(String str) {
            this.targetSiteLink = str;
        }

        public final String getLabel() {
            return this.label;
        }

        public final void setLabel(String str) {
            this.label = str;
        }

        public final Element getTargetSiteElement() {
            return this.targetSiteElement;
        }

        public final void setTargetSiteElement(Element element) {
            Intrinsics.checkNotNullParameter(element, "<set-?>");
            this.targetSiteElement = element;
        }
    }

    /* JADX INFO: compiled from: DSESS.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$Config;", "", "genericNameRegex", "Lkotlin/text/Regex;", "templateTagsRegex", "dSESSURLRegex", "(Lkotlin/text/Regex;Lkotlin/text/Regex;Lkotlin/text/Regex;)V", "getDSESSURLRegex", "()Lkotlin/text/Regex;", "getGenericNameRegex", "getTemplateTagsRegex", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Config {
        private final Regex dSESSURLRegex;
        private final Regex genericNameRegex;
        private final Regex templateTagsRegex;

        public Config() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Config copy$default(Config config, Regex regex, Regex regex2, Regex regex3, int i, Object obj) {
            if ((i & 1) != 0) {
                regex = config.genericNameRegex;
            }
            if ((i & 2) != 0) {
                regex2 = config.templateTagsRegex;
            }
            if ((i & 4) != 0) {
                regex3 = config.dSESSURLRegex;
            }
            return config.copy(regex, regex2, regex3);
        }

        public final Regex component1() {
            return this.genericNameRegex;
        }

        public final Regex component2() {
            return this.templateTagsRegex;
        }

        public final Regex component3() {
            return this.dSESSURLRegex;
        }

        public final Config copy(Regex genericNameRegex, Regex templateTagsRegex, Regex dSESSURLRegex) {
            Intrinsics.checkNotNullParameter(genericNameRegex, "genericNameRegex");
            Intrinsics.checkNotNullParameter(templateTagsRegex, "templateTagsRegex");
            Intrinsics.checkNotNullParameter(dSESSURLRegex, "dSESSURLRegex");
            return new Config(genericNameRegex, templateTagsRegex, dSESSURLRegex);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return Intrinsics.areEqual(this.genericNameRegex, config.genericNameRegex) && Intrinsics.areEqual(this.templateTagsRegex, config.templateTagsRegex) && Intrinsics.areEqual(this.dSESSURLRegex, config.dSESSURLRegex);
        }

        public int hashCode() {
            return (((this.genericNameRegex.hashCode() * 31) + this.templateTagsRegex.hashCode()) * 31) + this.dSESSURLRegex.hashCode();
        }

        public String toString() {
            return "Config(genericNameRegex=" + this.genericNameRegex + ", templateTagsRegex=" + this.templateTagsRegex + ", dSESSURLRegex=" + this.dSESSURLRegex + ")";
        }

        public Config(Regex genericNameRegex, Regex templateTagsRegex, Regex dSESSURLRegex) {
            Intrinsics.checkNotNullParameter(genericNameRegex, "genericNameRegex");
            Intrinsics.checkNotNullParameter(templateTagsRegex, "templateTagsRegex");
            Intrinsics.checkNotNullParameter(dSESSURLRegex, "dSESSURLRegex");
            this.genericNameRegex = genericNameRegex;
            this.templateTagsRegex = templateTagsRegex;
            this.dSESSURLRegex = dSESSURLRegex;
        }

        public /* synthetic */ Config(Regex regex, Regex regex2, Regex regex3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Constants.INSTANCE.getToGenericNameRegex() : regex, (i & 2) != 0 ? new Regex("^DSESS:[^:]*:TAGS\\(([^)]*)\\).*$") : regex2, (i & 4) != 0 ? new Regex("^DSESS:[^:]*:TAGS\\([^)]*\\):(.*)$") : regex3);
        }

        public final Regex getGenericNameRegex() {
            return this.genericNameRegex;
        }

        public final Regex getTemplateTagsRegex() {
            return this.templateTagsRegex;
        }

        public final Regex getDSESSURLRegex() {
            return this.dSESSURLRegex;
        }
    }

    /* JADX INFO: compiled from: DSESS.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$Scraper;", "", "id", "", "label", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getId", "()I", "getLabel", "()Ljava/lang/String;", "TARGET_BOX_ART", "TARGET_SNAPSHOT", "TARGET_TITLE", "TARGET_YOUTUBE", "TARGET_DESCRIPTION", "TARGET_GENRES", "TARGET_NONE", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum Scraper {
        TARGET_BOX_ART(0, "BOX_ART"),
        TARGET_SNAPSHOT(1, "SNAPSHOT"),
        TARGET_TITLE(2, "TITLE"),
        TARGET_YOUTUBE(3, "YOUTUBE"),
        TARGET_DESCRIPTION(4, "DESCRIPTION"),
        TARGET_GENRES(5, "GENRES"),
        TARGET_NONE(-1, "NONE");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f46id;
        private final String label;

        public static EnumEntries<Scraper> getEntries() {
            return $ENTRIES;
        }

        Scraper(int i, String str) {
            this.f46id = i;
            this.label = str;
        }

        public final int getId() {
            return this.f46id;
        }

        public final String getLabel() {
            return this.label;
        }
    }

    /* JADX INFO: compiled from: DSESS.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$Template;", "", "id", "", "label", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getId", "()I", "getLabel", "()Ljava/lang/String;", "TAG_NONE", "TAG_SCRAPER_KEYWORD", "TAG_SCRAPER_KEYWORD_NORMALIZED", "TAG_PLATFORM_NAME", "TAG_LOCALE_LANGUAGE", "TAG_LOCALE_COUNTRY", "TAG_LOCALE_LANGUAGE_AND_COUNTRY", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum Template {
        TAG_NONE(0, ""),
        TAG_SCRAPER_KEYWORD(1, "{scraperKeyword}"),
        TAG_SCRAPER_KEYWORD_NORMALIZED(2, "{scraperKeywordNormalized}"),
        TAG_PLATFORM_NAME(3, "{platformName}"),
        TAG_LOCALE_LANGUAGE(4, "{localeLanguage}"),
        TAG_LOCALE_COUNTRY(5, "{localeCountry}"),
        TAG_LOCALE_LANGUAGE_AND_COUNTRY(6, "{localeLanguageAndCountry}");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f47id;
        private final String label;

        public static EnumEntries<Template> getEntries() {
            return $ENTRIES;
        }

        Template(int i, String str) {
            this.f47id = i;
            this.label = str;
        }

        public final int getId() {
            return this.f47id;
        }

        public final String getLabel() {
            return this.label;
        }
    }

    /* JADX INFO: compiled from: DSESS.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/dsess/DSESS$Parameter;", "", "id", "", "label", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getId", "()I", "getLabel", "()Ljava/lang/String;", "TARGET_SITE_SELECTOR", "TARGET_SITE_LABEL_SUBSELECTOR", "TARGET_SITE_LABEL_MATCHERS", "TARGET_SITE_LINK_SUBSELECTOR", "TARGET_SITE", "SELECTOR", "ATTRIBUTE", "EXTRACTOR", "REPLACER", "REPLACER_VALUE", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum Parameter {
        TARGET_SITE_SELECTOR(1, "dsess_target_site_selector"),
        TARGET_SITE_LABEL_SUBSELECTOR(2, "dsess_target_site_label_subselector"),
        TARGET_SITE_LABEL_MATCHERS(3, "dsess_target_site_label_matchers"),
        TARGET_SITE_LINK_SUBSELECTOR(4, "dsess_target_site_link_subselector"),
        TARGET_SITE(5, "dsess_target_site"),
        SELECTOR(6, "dsess_selector"),
        ATTRIBUTE(7, "dsess_attribute"),
        EXTRACTOR(8, "dsess_extractor"),
        REPLACER(9, "dsess_replacer"),
        REPLACER_VALUE(10, "dsess_replacer_value");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f45id;
        private final String label;

        public static EnumEntries<Parameter> getEntries() {
            return $ENTRIES;
        }

        Parameter(int i, String str) {
            this.f45id = i;
            this.label = str;
        }

        public final int getId() {
            return this.f45id;
        }

        public final String getLabel() {
            return this.label;
        }
    }
}

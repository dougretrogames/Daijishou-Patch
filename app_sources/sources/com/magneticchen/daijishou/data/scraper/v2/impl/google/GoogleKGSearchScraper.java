package com.magneticchen.daijishou.data.scraper.v2.impl.google;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.kgsearch.v1.Kgsearch;
import com.google.api.services.kgsearch.v1.model.SearchResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.magneticchen.daijishou.BuildConfig;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.scraper.v2.AbstractScraper;
import com.magneticchen.daijishou.data.scraper.v2.ScraperConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: GoogleKGSearchScraper.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001e\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fJ\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\nH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/google/GoogleKGSearchScraper;", "Lcom/magneticchen/daijishou/data/scraper/v2/AbstractScraper;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "config", "Lcom/magneticchen/daijishou/data/scraper/v2/ScraperConfig;", "googleKGConfig", "Lcom/magneticchen/daijishou/data/scraper/v2/impl/google/GoogleKGSearchScraper$Config;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Lcom/magneticchen/daijishou/data/scraper/v2/ScraperConfig;Lcom/magneticchen/daijishou/data/scraper/v2/impl/google/GoogleKGSearchScraper$Config;)V", "cleanUpBoxBrackets", "", "text", "scrapeDescriptionByPlatformNameAndKeywords", "platformName", "keywords", "", "searchGoogleResult", "Lcom/google/gson/JsonObject;", "keyword", "customScoring", "", "toGenericName", "string", "Config", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GoogleKGSearchScraper extends AbstractScraper {
    private final Config googleKGConfig;

    public /* synthetic */ GoogleKGSearchScraper(DaijishouApplication daijishouApplication, ScraperConfig scraperConfig, Config config, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            config = new Config(null, 0, null, null, null, null, null, 127, null);
        }
        this(daijishouApplication, scraperConfig, config);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleKGSearchScraper(DaijishouApplication application, ScraperConfig config, Config googleKGConfig) {
        super(application, config);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(googleKGConfig, "googleKGConfig");
        this.googleKGConfig = googleKGConfig;
    }

    public final String scrapeDescriptionByPlatformNameAndKeywords(String str, List<String> keywords) throws Exception {
        String genericName;
        Element elementSelectFirst;
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        for (String str2 : keywords) {
            if (str == null) {
                try {
                    genericName = toGenericName(str2);
                } catch (Exception e) {
                    getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                }
            } else {
                genericName = toGenericName(str2) + " " + str;
            }
            JsonObject jsonObjectSearchGoogleResult = searchGoogleResult(genericName, true);
            JsonObject asJsonObject = jsonObjectSearchGoogleResult.get("result").getAsJsonObject().get("detailedDescription").getAsJsonObject();
            String asString = asJsonObject.get("articleBody").getAsString();
            String asString2 = asJsonObject.get("url").getAsString();
            Intrinsics.checkNotNull(asString2);
            if (StringsKt.contains$default((CharSequence) asString2, (CharSequence) "wikipedia.org", false, 2, (Object) null)) {
                Connection connectionConnect = Jsoup.connect(asString2);
                connectionConnect.timeout(getConfig().getJsoupConnectTimeout());
                connectionConnect.userAgent(getConfig().getJsoupUserAgent());
                Document document = connectionConnect.get();
                Element elementSelectFirst2 = document.selectFirst("#mw-content-text div > p");
                String strText = elementSelectFirst2 != null ? elementSelectFirst2.text() : null;
                if (strText != null && strText.length() > asString.length()) {
                    asString = cleanUpBoxBrackets(strText) + " <br>";
                }
                Elements elementsSelect = document.select("table.infobox tr th[scope=row]");
                List<Element> listSubList = elementsSelect.subList(0, RangesKt.coerceAtMost(this.googleKGConfig.getMaxWikipediaTableRows(), elementsSelect.size()));
                Intrinsics.checkNotNullExpressionValue(listSubList, "subList(...)");
                for (Element element : listSubList) {
                    Element elementParent = element.parent();
                    if (elementParent != null && (elementSelectFirst = elementParent.selectFirst("td")) != null) {
                        elementSelectFirst.select("br, li").append("REPLACE_AS_COMMA");
                        String strText2 = element.text();
                        Intrinsics.checkNotNullExpressionValue(strText2, "text(...)");
                        String strReplace$default = StringsKt.replace$default(cleanUpBoxBrackets(strText2), "(s)", "s", false, 4, (Object) null);
                        String strText3 = elementSelectFirst.text();
                        Intrinsics.checkNotNullExpressionValue(strText3, "text(...)");
                        asString = asString + "<br><a href=''><b>" + strReplace$default + ":</b></a> " + new Regex("\\s*REPLACE_AS_COMMA\\s*").replace(cleanUpBoxBrackets(strText3), ", ");
                    }
                }
                getLogger().debug(this, "keyword: " + genericName + "\nclass:" + jsonObjectSearchGoogleResult.getClass() + "\nresponse.itemListElement:\n" + jsonObjectSearchGoogleResult.get("result"));
                String country = Locale.getDefault().getCountry();
                Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
                String lowerCase = country.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, "tw")) {
                    String language = Locale.getDefault().getLanguage();
                    Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
                    String lowerCase2 = language.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    Intrinsics.areEqual(lowerCase2, "zh");
                }
                Intrinsics.checkNotNull(asString);
                return asString;
            }
            continue;
        }
        throw new Exception(getFailedToScrapeString());
    }

    static /* synthetic */ JsonObject searchGoogleResult$default(GoogleKGSearchScraper googleKGSearchScraper, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return googleKGSearchScraper.searchGoogleResult(str, z);
    }

    private final JsonObject searchGoogleResult(String str, boolean z) {
        List listEmptyList;
        int i;
        SearchResponse searchResponse = (SearchResponse) this.googleKGConfig.getKgSearch().entities().search().setLimit(5).setLanguages(CollectionsKt.listOf(Locale.getDefault().getLanguage())).setQuery(String.valueOf(str)).execute();
        if (str == null || (listEmptyList = StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = searchResponse.getItemListElement().iterator();
        while (it.hasNext()) {
            JsonObject jsonObject = (JsonObject) this.googleKGConfig.getGson().fromJson(this.googleKGConfig.getGson().toJson(it.next()), JsonObject.class);
            String asString = jsonObject.get("result").getAsJsonObject().get("name").getAsString();
            List<String> list = listEmptyList;
            if ((list instanceof Collection) && list.isEmpty()) {
                i = 0;
            } else {
                i = 0;
                for (String str2 : list) {
                    Intrinsics.checkNotNull(asString);
                    if (StringsKt.contains((CharSequence) asString, (CharSequence) str2, true) && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            Integer numValueOf = Integer.valueOf(i);
            Intrinsics.checkNotNull(jsonObject);
            linkedHashMap.put(jsonObject, numValueOf);
        }
        if (z) {
            Iterator it2 = linkedHashMap.entrySet().iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it2.next();
            if (it2.hasNext()) {
                int iIntValue = ((Number) ((Map.Entry) next).getValue()).intValue();
                do {
                    Object next2 = it2.next();
                    int iIntValue2 = ((Number) ((Map.Entry) next2).getValue()).intValue();
                    if (iIntValue < iIntValue2) {
                        next = next2;
                        iIntValue = iIntValue2;
                    }
                } while (it2.hasNext());
            }
            return (JsonObject) ((Map.Entry) next).getKey();
        }
        Set setEntrySet = linkedHashMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(setEntrySet, "<get-entries>(...)");
        Object key = ((Map.Entry) CollectionsKt.first(setEntrySet)).getKey();
        Intrinsics.checkNotNull(key);
        return (JsonObject) key;
    }

    private final String toGenericName(String str) {
        List<String> groupValues;
        String str2;
        MatchResult matchResultFind$default = Regex.find$default(this.googleKGConfig.getGenericNameRegex(), str, 0, 2, null);
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

    private final String cleanUpBoxBrackets(String str) {
        return new Regex("\\[[^\\[]*]").replace(str, " ");
    }

    /* JADX INFO: compiled from: GoogleKGSearchScraper.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003J\t\u0010%\u001a\u00020\u000eHÆ\u0003J\t\u0010&\u001a\u00020\u0010HÆ\u0003JU\u0010'\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0006HÖ\u0001J\t\u0010,\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/google/GoogleKGSearchScraper$Config;", "", "wikipediaTableKeys", "", "", "maxWikipediaTableRows", "", "gson", "Lcom/google/gson/Gson;", "httpTransport", "Lcom/google/api/client/http/HttpTransport;", "jsonFactory", "Lcom/google/api/client/json/JsonFactory;", "genericNameRegex", "Lkotlin/text/Regex;", "kgSearch", "Lcom/google/api/services/kgsearch/v1/Kgsearch;", "(Ljava/util/List;ILcom/google/gson/Gson;Lcom/google/api/client/http/HttpTransport;Lcom/google/api/client/json/JsonFactory;Lkotlin/text/Regex;Lcom/google/api/services/kgsearch/v1/Kgsearch;)V", "getGenericNameRegex", "()Lkotlin/text/Regex;", "getGson", "()Lcom/google/gson/Gson;", "getHttpTransport", "()Lcom/google/api/client/http/HttpTransport;", "getJsonFactory", "()Lcom/google/api/client/json/JsonFactory;", "getKgSearch", "()Lcom/google/api/services/kgsearch/v1/Kgsearch;", "getMaxWikipediaTableRows", "()I", "getWikipediaTableKeys", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Config {
        private final Regex genericNameRegex;
        private final Gson gson;
        private final HttpTransport httpTransport;
        private final JsonFactory jsonFactory;
        private final Kgsearch kgSearch;
        private final int maxWikipediaTableRows;
        private final List<String> wikipediaTableKeys;

        public Config() {
            this(null, 0, null, null, null, null, null, 127, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Config copy$default(Config config, List list, int i, Gson gson, HttpTransport httpTransport, JsonFactory jsonFactory, Regex regex, Kgsearch kgsearch, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = config.wikipediaTableKeys;
            }
            if ((i2 & 2) != 0) {
                i = config.maxWikipediaTableRows;
            }
            if ((i2 & 4) != 0) {
                gson = config.gson;
            }
            if ((i2 & 8) != 0) {
                httpTransport = config.httpTransport;
            }
            if ((i2 & 16) != 0) {
                jsonFactory = config.jsonFactory;
            }
            if ((i2 & 32) != 0) {
                regex = config.genericNameRegex;
            }
            if ((i2 & 64) != 0) {
                kgsearch = config.kgSearch;
            }
            Regex regex2 = regex;
            Kgsearch kgsearch2 = kgsearch;
            JsonFactory jsonFactory2 = jsonFactory;
            Gson gson2 = gson;
            return config.copy(list, i, gson2, httpTransport, jsonFactory2, regex2, kgsearch2);
        }

        public final List<String> component1() {
            return this.wikipediaTableKeys;
        }

        public final int component2() {
            return this.maxWikipediaTableRows;
        }

        public final Gson component3() {
            return this.gson;
        }

        public final HttpTransport component4() {
            return this.httpTransport;
        }

        public final JsonFactory component5() {
            return this.jsonFactory;
        }

        public final Regex component6() {
            return this.genericNameRegex;
        }

        public final Kgsearch component7() {
            return this.kgSearch;
        }

        public final Config copy(List<String> wikipediaTableKeys, int i, Gson gson, HttpTransport httpTransport, JsonFactory jsonFactory, Regex genericNameRegex, Kgsearch kgSearch) {
            Intrinsics.checkNotNullParameter(wikipediaTableKeys, "wikipediaTableKeys");
            Intrinsics.checkNotNullParameter(gson, "gson");
            Intrinsics.checkNotNullParameter(httpTransport, "httpTransport");
            Intrinsics.checkNotNullParameter(jsonFactory, "jsonFactory");
            Intrinsics.checkNotNullParameter(genericNameRegex, "genericNameRegex");
            Intrinsics.checkNotNullParameter(kgSearch, "kgSearch");
            return new Config(wikipediaTableKeys, i, gson, httpTransport, jsonFactory, genericNameRegex, kgSearch);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return Intrinsics.areEqual(this.wikipediaTableKeys, config.wikipediaTableKeys) && this.maxWikipediaTableRows == config.maxWikipediaTableRows && Intrinsics.areEqual(this.gson, config.gson) && Intrinsics.areEqual(this.httpTransport, config.httpTransport) && Intrinsics.areEqual(this.jsonFactory, config.jsonFactory) && Intrinsics.areEqual(this.genericNameRegex, config.genericNameRegex) && Intrinsics.areEqual(this.kgSearch, config.kgSearch);
        }

        public int hashCode() {
            return (((((((((((this.wikipediaTableKeys.hashCode() * 31) + Integer.hashCode(this.maxWikipediaTableRows)) * 31) + this.gson.hashCode()) * 31) + this.httpTransport.hashCode()) * 31) + this.jsonFactory.hashCode()) * 31) + this.genericNameRegex.hashCode()) * 31) + this.kgSearch.hashCode();
        }

        public String toString() {
            return "Config(wikipediaTableKeys=" + this.wikipediaTableKeys + ", maxWikipediaTableRows=" + this.maxWikipediaTableRows + ", gson=" + this.gson + ", httpTransport=" + this.httpTransport + ", jsonFactory=" + this.jsonFactory + ", genericNameRegex=" + this.genericNameRegex + ", kgSearch=" + this.kgSearch + ")";
        }

        public Config(List<String> wikipediaTableKeys, int i, Gson gson, HttpTransport httpTransport, JsonFactory jsonFactory, Regex genericNameRegex, Kgsearch kgSearch) {
            Intrinsics.checkNotNullParameter(wikipediaTableKeys, "wikipediaTableKeys");
            Intrinsics.checkNotNullParameter(gson, "gson");
            Intrinsics.checkNotNullParameter(httpTransport, "httpTransport");
            Intrinsics.checkNotNullParameter(jsonFactory, "jsonFactory");
            Intrinsics.checkNotNullParameter(genericNameRegex, "genericNameRegex");
            Intrinsics.checkNotNullParameter(kgSearch, "kgSearch");
            this.wikipediaTableKeys = wikipediaTableKeys;
            this.maxWikipediaTableRows = i;
            this.gson = gson;
            this.httpTransport = httpTransport;
            this.jsonFactory = jsonFactory;
            this.genericNameRegex = genericNameRegex;
            this.kgSearch = kgSearch;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Config(List list, int i, Gson gson, HttpTransport httpTransport, JsonFactory jsonFactory, Regex regex, Kgsearch kgsearch, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            list = (i2 & 1) != 0 ? CollectionsKt.listOf("Developer(s)") : list;
            i = (i2 & 2) != 0 ? 12 : i;
            gson = (i2 & 4) != 0 ? new Gson() : gson;
            if ((i2 & 8) != 0) {
                NetHttpTransport netHttpTransportNewTrustedTransport = GoogleNetHttpTransport.newTrustedTransport();
                Intrinsics.checkNotNullExpressionValue(netHttpTransportNewTrustedTransport, "newTrustedTransport(...)");
                httpTransport = (HttpTransport) netHttpTransportNewTrustedTransport;
            }
            jsonFactory = (i2 & 16) != 0 ? (JsonFactory) new GsonFactory() : jsonFactory;
            regex = (i2 & 32) != 0 ? Constants.INSTANCE.getToGenericNameRegex() : regex;
            if ((i2 & 64) != 0) {
                kgsearch = new Kgsearch.Builder(httpTransport, jsonFactory, (HttpRequestInitializer) null).setGoogleClientRequestInitializer(new GoogleKGSearchRequestInitializer()).setApplicationName(BuildConfig.APPLICATION_ID).build();
                Intrinsics.checkNotNullExpressionValue(kgsearch, "build(...)");
            }
            this(list, i, gson, httpTransport, jsonFactory, regex, kgsearch);
        }

        public final List<String> getWikipediaTableKeys() {
            return this.wikipediaTableKeys;
        }

        public final int getMaxWikipediaTableRows() {
            return this.maxWikipediaTableRows;
        }

        public final Gson getGson() {
            return this.gson;
        }

        public final HttpTransport getHttpTransport() {
            return this.httpTransport;
        }

        public final JsonFactory getJsonFactory() {
            return this.jsonFactory;
        }

        public final Regex getGenericNameRegex() {
            return this.genericNameRegex;
        }

        public final Kgsearch getKgSearch() {
            return this.kgSearch;
        }
    }
}

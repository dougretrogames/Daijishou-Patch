package com.google.api.services.kgsearch.v1;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.kgsearch.v1.model.SearchResponse;
import java.io.IOException;
import java.util.List;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: loaded from: classes3.dex */
public class Kgsearch extends AbstractGoogleJsonClient {
    public static final String DEFAULT_BASE_URL = "https://kgsearch.googleapis.com/";
    public static final String DEFAULT_BATCH_PATH = "batch";
    public static final String DEFAULT_MTLS_ROOT_URL = "https://kgsearch.mtls.googleapis.com/";
    public static final String DEFAULT_ROOT_URL = "https://kgsearch.googleapis.com/";
    public static final String DEFAULT_SERVICE_PATH = "";

    static {
        boolean z = true;
        if ((GoogleUtils.MAJOR_VERSION.intValue() != 1 || (GoogleUtils.MINOR_VERSION.intValue() < 32 && (GoogleUtils.MINOR_VERSION.intValue() != 31 || GoogleUtils.BUGFIX_VERSION.intValue() < 1))) && GoogleUtils.MAJOR_VERSION.intValue() < 2) {
            z = false;
        }
        Preconditions.checkState(z, "You are currently running with version %s of google-api-client. You need at least version 1.31.1 of google-api-client to run version 2.0.0 of the Knowledge Graph Search API library.", GoogleUtils.VERSION);
    }

    public Kgsearch(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
        this(new Builder(httpTransport, jsonFactory, httpRequestInitializer));
    }

    Kgsearch(Builder builder) {
        super(builder);
    }

    @Override // com.google.api.client.googleapis.services.AbstractGoogleClient
    protected void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        super.initialize(abstractGoogleClientRequest);
    }

    public Entities entities() {
        return new Entities();
    }

    public class Entities {
        public Entities() {
        }

        public Search search() throws IOException {
            Search search = new Search();
            Kgsearch.this.initialize(search);
            return search;
        }

        public class Search extends KgsearchRequest<SearchResponse> {
            private static final String REST_PATH = "v1/entities:search";

            @Key
            private List<String> ids;

            @Key
            private Boolean indent;

            @Key
            private List<String> languages;

            @Key
            private Integer limit;

            @Key
            private Boolean prefix;

            @Key
            private String query;

            @Key
            private List<String> types;

            protected Search() {
                super(Kgsearch.this, "GET", REST_PATH, null, SearchResponse.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.kgsearch.v1.KgsearchRequest
            /* INFO: renamed from: set$Xgafv, reason: merged with bridge method [inline-methods] */
            public KgsearchRequest<SearchResponse> set$Xgafv2(String str) {
                return (Search) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.kgsearch.v1.KgsearchRequest
            /* INFO: renamed from: setAccessToken, reason: merged with bridge method [inline-methods] */
            public KgsearchRequest<SearchResponse> setAccessToken2(String str) {
                return (Search) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.kgsearch.v1.KgsearchRequest
            /* INFO: renamed from: setAlt, reason: merged with bridge method [inline-methods] */
            public KgsearchRequest<SearchResponse> setAlt2(String str) {
                return (Search) super.setAlt2(str);
            }

            @Override // com.google.api.services.kgsearch.v1.KgsearchRequest
            /* INFO: renamed from: setCallback, reason: merged with bridge method [inline-methods] */
            public KgsearchRequest<SearchResponse> setCallback2(String str) {
                return (Search) super.setCallback2(str);
            }

            @Override // com.google.api.services.kgsearch.v1.KgsearchRequest
            /* INFO: renamed from: setFields, reason: merged with bridge method [inline-methods] */
            public KgsearchRequest<SearchResponse> setFields2(String str) {
                return (Search) super.setFields2(str);
            }

            @Override // com.google.api.services.kgsearch.v1.KgsearchRequest
            /* INFO: renamed from: setKey, reason: merged with bridge method [inline-methods] */
            public KgsearchRequest<SearchResponse> setKey2(String str) {
                return (Search) super.setKey2(str);
            }

            @Override // com.google.api.services.kgsearch.v1.KgsearchRequest
            /* INFO: renamed from: setOauthToken, reason: merged with bridge method [inline-methods] */
            public KgsearchRequest<SearchResponse> setOauthToken2(String str) {
                return (Search) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.kgsearch.v1.KgsearchRequest
            /* INFO: renamed from: setPrettyPrint, reason: merged with bridge method [inline-methods] */
            public KgsearchRequest<SearchResponse> setPrettyPrint2(Boolean bool) {
                return (Search) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.kgsearch.v1.KgsearchRequest
            /* INFO: renamed from: setQuotaUser, reason: merged with bridge method [inline-methods] */
            public KgsearchRequest<SearchResponse> setQuotaUser2(String str) {
                return (Search) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.kgsearch.v1.KgsearchRequest
            /* INFO: renamed from: setUploadType, reason: merged with bridge method [inline-methods] */
            public KgsearchRequest<SearchResponse> setUploadType2(String str) {
                return (Search) super.setUploadType2(str);
            }

            @Override // com.google.api.services.kgsearch.v1.KgsearchRequest
            /* INFO: renamed from: setUploadProtocol, reason: merged with bridge method [inline-methods] */
            public KgsearchRequest<SearchResponse> setUploadProtocol2(String str) {
                return (Search) super.setUploadProtocol2(str);
            }

            public List<String> getIds() {
                return this.ids;
            }

            public Search setIds(List<String> list) {
                this.ids = list;
                return this;
            }

            public Boolean getIndent() {
                return this.indent;
            }

            public Search setIndent(Boolean bool) {
                this.indent = bool;
                return this;
            }

            public List<String> getLanguages() {
                return this.languages;
            }

            public Search setLanguages(List<String> list) {
                this.languages = list;
                return this;
            }

            public Integer getLimit() {
                return this.limit;
            }

            public Search setLimit(Integer num) {
                this.limit = num;
                return this;
            }

            public Boolean getPrefix() {
                return this.prefix;
            }

            public Search setPrefix(Boolean bool) {
                this.prefix = bool;
                return this;
            }

            public String getQuery() {
                return this.query;
            }

            public Search setQuery(String str) {
                this.query = str;
                return this;
            }

            public List<String> getTypes() {
                return this.types;
            }

            public Search setTypes(List<String> list) {
                this.types = list;
                return this;
            }

            @Override // com.google.api.services.kgsearch.v1.KgsearchRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Search set(String str, Object obj) {
                return (Search) super.set(str, obj);
            }
        }
    }

    public static final class Builder extends AbstractGoogleJsonClient.Builder {
        private static String chooseEndpoint(HttpTransport httpTransport) {
            String str = System.getenv("GOOGLE_API_USE_MTLS_ENDPOINT");
            if (str == null) {
                str = "auto";
            }
            if (!ConfigConstants.CONFIG_KEY_ALWAYS.equals(str)) {
                if ("auto".equals(str) && httpTransport != null && httpTransport.isMtls()) {
                    return Kgsearch.DEFAULT_MTLS_ROOT_URL;
                }
                return "https://kgsearch.googleapis.com/";
            }
            return Kgsearch.DEFAULT_MTLS_ROOT_URL;
        }

        public Builder(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
            super(httpTransport, jsonFactory, chooseEndpoint(httpTransport), "", httpRequestInitializer, false);
            setBatchPath(Kgsearch.DEFAULT_BATCH_PATH);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Kgsearch build() {
            return new Kgsearch(this);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setRootUrl(String str) {
            return (Builder) super.setRootUrl(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setServicePath(String str) {
            return (Builder) super.setServicePath(str);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setBatchPath(String str) {
            return (Builder) super.setBatchPath(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setApplicationName(String str) {
            return (Builder) super.setApplicationName(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressPatternChecks(boolean z) {
            return (Builder) super.setSuppressPatternChecks(z);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressRequiredParameterChecks(boolean z) {
            return (Builder) super.setSuppressRequiredParameterChecks(z);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressAllChecks(boolean z) {
            return (Builder) super.setSuppressAllChecks(z);
        }

        public Builder setKgsearchRequestInitializer(KgsearchRequestInitializer kgsearchRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer((GoogleClientRequestInitializer) kgsearchRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }
    }
}

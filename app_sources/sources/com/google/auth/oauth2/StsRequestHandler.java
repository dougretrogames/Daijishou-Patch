package com.google.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.GenericData;
import com.google.common.base.Joiner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.annotation.Nullable;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.transport.WalkEncryption;

/* INFO: loaded from: classes3.dex */
final class StsRequestHandler {
    private static final String PARSE_ERROR_PREFIX = "Error parsing token response.";
    private static final String TOKEN_EXCHANGE_GRANT_TYPE = "urn:ietf:params:oauth:grant-type:token-exchange";

    @Nullable
    private final HttpHeaders headers;
    private final HttpRequestFactory httpRequestFactory;

    @Nullable
    private final String internalOptions;
    private final StsTokenExchangeRequest request;
    private final String tokenExchangeEndpoint;

    /* synthetic */ StsRequestHandler(String str, StsTokenExchangeRequest stsTokenExchangeRequest, HttpRequestFactory httpRequestFactory, HttpHeaders httpHeaders, String str2, AnonymousClass1 anonymousClass1) {
        this(str, stsTokenExchangeRequest, httpRequestFactory, httpHeaders, str2);
    }

    private StsRequestHandler(String str, StsTokenExchangeRequest stsTokenExchangeRequest, HttpRequestFactory httpRequestFactory, @Nullable HttpHeaders httpHeaders, @Nullable String str2) {
        this.tokenExchangeEndpoint = str;
        this.request = stsTokenExchangeRequest;
        this.httpRequestFactory = httpRequestFactory;
        this.headers = httpHeaders;
        this.internalOptions = str2;
    }

    public static Builder newBuilder(String str, StsTokenExchangeRequest stsTokenExchangeRequest, HttpRequestFactory httpRequestFactory) {
        return new Builder(str, stsTokenExchangeRequest, httpRequestFactory, null);
    }

    public StsTokenExchangeResponse exchangeToken() throws IOException {
        HttpRequest httpRequestBuildPostRequest = this.httpRequestFactory.buildPostRequest(new GenericUrl(this.tokenExchangeEndpoint), new UrlEncodedContent(buildTokenRequest()));
        httpRequestBuildPostRequest.setParser(new JsonObjectParser(OAuth2Utils.JSON_FACTORY));
        HttpHeaders httpHeaders = this.headers;
        if (httpHeaders != null) {
            httpRequestBuildPostRequest.setHeaders(httpHeaders);
        }
        try {
            return buildResponse((GenericData) httpRequestBuildPostRequest.execute().parseAs(GenericData.class));
        } catch (HttpResponseException e) {
            throw OAuthException.createFromHttpResponseException(e);
        }
    }

    private GenericData buildTokenRequest() {
        GenericData genericData = new GenericData().set("grant_type", TOKEN_EXCHANGE_GRANT_TYPE).set("subject_token_type", this.request.getSubjectTokenType()).set("subject_token", this.request.getSubjectToken());
        ArrayList arrayList = new ArrayList();
        if (this.request.hasScopes()) {
            arrayList.addAll(this.request.getScopes());
            genericData.set("scope", Joiner.on(TokenParser.SP).join(arrayList));
        }
        genericData.set("requested_token_type", this.request.hasRequestedTokenType() ? this.request.getRequestedTokenType() : "urn:ietf:params:oauth:token-type:access_token");
        if (this.request.hasResource()) {
            genericData.set("resource", this.request.getResource());
        }
        if (this.request.hasAudience()) {
            genericData.set("audience", this.request.getAudience());
        }
        if (this.request.hasActingParty()) {
            genericData.set("actor_token", this.request.getActingParty().getActorToken());
            genericData.set("actor_token_type", this.request.getActingParty().getActorTokenType());
        }
        String str = this.internalOptions;
        if (str != null && !str.isEmpty()) {
            genericData.set("options", this.internalOptions);
        }
        return genericData;
    }

    private StsTokenExchangeResponse buildResponse(GenericData genericData) throws IOException {
        StsTokenExchangeResponse.Builder builderNewBuilder = StsTokenExchangeResponse.newBuilder(OAuth2Utils.validateString(genericData, "access_token", PARSE_ERROR_PREFIX), OAuth2Utils.validateString(genericData, "issued_token_type", PARSE_ERROR_PREFIX), OAuth2Utils.validateString(genericData, "token_type", PARSE_ERROR_PREFIX));
        if (genericData.containsKey("expires_in")) {
            builderNewBuilder.setExpiresInSeconds(OAuth2Utils.validateLong(genericData, "expires_in", PARSE_ERROR_PREFIX));
        }
        if (genericData.containsKey("refresh_token")) {
            builderNewBuilder.setRefreshToken(OAuth2Utils.validateString(genericData, "refresh_token", PARSE_ERROR_PREFIX));
        }
        if (genericData.containsKey("scope")) {
            builderNewBuilder.setScopes(Arrays.asList(OAuth2Utils.validateString(genericData, "scope", PARSE_ERROR_PREFIX).trim().split(WalkEncryption.Vals.REGEX_WS)));
        }
        return builderNewBuilder.build();
    }

    private GenericJson parseJson(String str) throws IOException {
        return (GenericJson) OAuth2Utils.JSON_FACTORY.createJsonParser(str).parseAndClose(GenericJson.class);
    }

    public static class Builder {

        @Nullable
        private HttpHeaders headers;
        private final HttpRequestFactory httpRequestFactory;

        @Nullable
        private String internalOptions;
        private final StsTokenExchangeRequest request;
        private final String tokenExchangeEndpoint;

        /* synthetic */ Builder(String str, StsTokenExchangeRequest stsTokenExchangeRequest, HttpRequestFactory httpRequestFactory, AnonymousClass1 anonymousClass1) {
            this(str, stsTokenExchangeRequest, httpRequestFactory);
        }

        private Builder(String str, StsTokenExchangeRequest stsTokenExchangeRequest, HttpRequestFactory httpRequestFactory) {
            this.tokenExchangeEndpoint = str;
            this.request = stsTokenExchangeRequest;
            this.httpRequestFactory = httpRequestFactory;
        }

        public Builder setHeaders(HttpHeaders httpHeaders) {
            this.headers = httpHeaders;
            return this;
        }

        public Builder setInternalOptions(String str) {
            this.internalOptions = str;
            return this;
        }

        public StsRequestHandler build() {
            return new StsRequestHandler(this.tokenExchangeEndpoint, this.request, this.httpRequestFactory, this.headers, this.internalOptions, null);
        }
    }
}

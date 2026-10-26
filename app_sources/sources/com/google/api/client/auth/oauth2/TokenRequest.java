package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Collection;
import org.apache.http.message.TokenParser;

/* INFO: loaded from: classes3.dex */
public class TokenRequest extends GenericData {
    HttpExecuteInterceptor clientAuthentication;

    @Key("grant_type")
    private String grantType;
    private final JsonFactory jsonFactory;
    HttpRequestInitializer requestInitializer;
    protected Class<? extends TokenResponse> responseClass;

    @Key("scope")
    private String scopes;
    private GenericUrl tokenServerUrl;
    private final HttpTransport transport;

    public TokenRequest(HttpTransport httpTransport, JsonFactory jsonFactory, GenericUrl genericUrl, String str) {
        this(httpTransport, jsonFactory, genericUrl, str, TokenResponse.class);
    }

    public TokenRequest(HttpTransport httpTransport, JsonFactory jsonFactory, GenericUrl genericUrl, String str, Class<? extends TokenResponse> cls) {
        this.transport = (HttpTransport) Preconditions.checkNotNull(httpTransport);
        this.jsonFactory = (JsonFactory) Preconditions.checkNotNull(jsonFactory);
        setTokenServerUrl(genericUrl);
        setGrantType(str);
        setResponseClass(cls);
    }

    public final HttpTransport getTransport() {
        return this.transport;
    }

    public final JsonFactory getJsonFactory() {
        return this.jsonFactory;
    }

    public final HttpRequestInitializer getRequestInitializer() {
        return this.requestInitializer;
    }

    public TokenRequest setRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
        this.requestInitializer = httpRequestInitializer;
        return this;
    }

    public final HttpExecuteInterceptor getClientAuthentication() {
        return this.clientAuthentication;
    }

    public TokenRequest setClientAuthentication(HttpExecuteInterceptor httpExecuteInterceptor) {
        this.clientAuthentication = httpExecuteInterceptor;
        return this;
    }

    public final GenericUrl getTokenServerUrl() {
        return this.tokenServerUrl;
    }

    public TokenRequest setTokenServerUrl(GenericUrl genericUrl) {
        this.tokenServerUrl = genericUrl;
        Preconditions.checkArgument(genericUrl.getFragment() == null);
        return this;
    }

    public final String getScopes() {
        return this.scopes;
    }

    public TokenRequest setScopes(Collection<String> collection) {
        this.scopes = collection == null ? null : Joiner.on(TokenParser.SP).join(collection);
        return this;
    }

    public final String getGrantType() {
        return this.grantType;
    }

    public TokenRequest setGrantType(String str) {
        this.grantType = (String) Preconditions.checkNotNull(str);
        return this;
    }

    public final Class<? extends TokenResponse> getResponseClass() {
        return this.responseClass;
    }

    public TokenRequest setResponseClass(Class<? extends TokenResponse> cls) {
        this.responseClass = cls;
        return this;
    }

    public final HttpResponse executeUnparsed() throws IOException {
        HttpRequest httpRequestBuildPostRequest = this.transport.createRequestFactory(new AnonymousClass1()).buildPostRequest(this.tokenServerUrl, new UrlEncodedContent(this));
        httpRequestBuildPostRequest.setParser(new JsonObjectParser(this.jsonFactory));
        httpRequestBuildPostRequest.setThrowExceptionOnExecuteError(false);
        HttpResponse httpResponseExecute = httpRequestBuildPostRequest.execute();
        if (httpResponseExecute.isSuccessStatusCode()) {
            return httpResponseExecute;
        }
        throw TokenResponseException.from(this.jsonFactory, httpResponseExecute);
    }

    /* INFO: renamed from: com.google.api.client.auth.oauth2.TokenRequest$1, reason: invalid class name */
    class AnonymousClass1 implements HttpRequestInitializer {
        AnonymousClass1() {
        }

        @Override // com.google.api.client.http.HttpRequestInitializer
        public void initialize(HttpRequest httpRequest) throws IOException {
            if (TokenRequest.this.requestInitializer != null) {
                TokenRequest.this.requestInitializer.initialize(httpRequest);
            }
            httpRequest.setInterceptor(new C00321(httpRequest.getInterceptor()));
        }

        /* INFO: renamed from: com.google.api.client.auth.oauth2.TokenRequest$1$1, reason: invalid class name and collision with other inner class name */
        class C00321 implements HttpExecuteInterceptor {
            final /* synthetic */ HttpExecuteInterceptor val$interceptor;

            C00321(HttpExecuteInterceptor httpExecuteInterceptor) {
                this.val$interceptor = httpExecuteInterceptor;
            }

            @Override // com.google.api.client.http.HttpExecuteInterceptor
            public void intercept(HttpRequest httpRequest) throws IOException {
                HttpExecuteInterceptor httpExecuteInterceptor = this.val$interceptor;
                if (httpExecuteInterceptor != null) {
                    httpExecuteInterceptor.intercept(httpRequest);
                }
                if (TokenRequest.this.clientAuthentication != null) {
                    TokenRequest.this.clientAuthentication.intercept(httpRequest);
                }
            }
        }
    }

    public TokenResponse execute() throws IOException {
        return (TokenResponse) executeUnparsed().parseAs((Class) this.responseClass);
    }

    @Override // com.google.api.client.util.GenericData
    public TokenRequest set(String str, Object obj) {
        return (TokenRequest) super.set(str, obj);
    }
}

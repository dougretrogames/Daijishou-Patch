package com.google.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.json.JsonObjectParser;
import com.google.auth.http.HttpTransportFactory;
import java.io.IOException;

/* INFO: loaded from: classes3.dex */
class UrlIdentityPoolSubjectTokenSupplier implements IdentityPoolSubjectTokenSupplier {
    private static final long serialVersionUID = 4964578313468011844L;
    private final IdentityPoolCredentialSource credentialSource;
    private final transient HttpTransportFactory transportFactory;

    UrlIdentityPoolSubjectTokenSupplier(IdentityPoolCredentialSource identityPoolCredentialSource, HttpTransportFactory httpTransportFactory) {
        this.credentialSource = identityPoolCredentialSource;
        this.transportFactory = httpTransportFactory;
    }

    @Override // com.google.auth.oauth2.IdentityPoolSubjectTokenSupplier
    public String getSubjectToken(ExternalAccountSupplierContext externalAccountSupplierContext) throws IOException {
        HttpRequest httpRequestBuildGetRequest = this.transportFactory.create().createRequestFactory().buildGetRequest(new GenericUrl(this.credentialSource.credentialLocation));
        httpRequestBuildGetRequest.setParser(new JsonObjectParser(OAuth2Utils.JSON_FACTORY));
        if (this.credentialSource.hasHeaders()) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.putAll(this.credentialSource.headers);
            httpRequestBuildGetRequest.setHeaders(httpHeaders);
        }
        try {
            return FileIdentityPoolSubjectTokenSupplier.parseToken(httpRequestBuildGetRequest.execute().getContent(), this.credentialSource);
        } catch (IOException e) {
            throw new IOException(String.format("Error getting subject token from metadata server: %s", e.getMessage()), e);
        }
    }
}

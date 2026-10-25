package com.google.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.json.webtoken.JsonWebToken;
import com.google.api.client.util.GenericData;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class GdchCredentials extends GoogleCredentials {
    private static final int DEFAULT_LIFETIME_IN_SECONDS = 3600;
    private static final String PARSE_ERROR_PREFIX = "Error parsing token refresh response. ";
    static final String SUPPORTED_FORMAT_VERSION = "1";
    private final URI apiAudience;
    private final String caCertPath;
    private final int lifetime;
    private final PrivateKey privateKey;
    private final String privateKeyId;
    private final String projectId;
    private final String serviceIdentityName;
    private final URI tokenServerUri;
    private transient HttpTransportFactory transportFactory;
    private final String transportFactoryClassName;

    GdchCredentials(Builder builder) {
        this.projectId = (String) Preconditions.checkNotNull(builder.projectId);
        this.privateKeyId = (String) Preconditions.checkNotNull(builder.privateKeyId);
        this.privateKey = (PrivateKey) Preconditions.checkNotNull(builder.privateKey);
        this.serviceIdentityName = (String) Preconditions.checkNotNull(builder.serviceIdentityName);
        this.tokenServerUri = (URI) Preconditions.checkNotNull(builder.tokenServerUri);
        HttpTransportFactory httpTransportFactory = (HttpTransportFactory) Preconditions.checkNotNull(builder.transportFactory);
        this.transportFactory = httpTransportFactory;
        this.transportFactoryClassName = httpTransportFactory.getClass().getName();
        this.caCertPath = builder.caCertPath;
        this.apiAudience = builder.apiAudience;
        this.lifetime = builder.lifetime;
    }

    static GdchCredentials fromJson(Map<String, Object> map) throws IOException {
        return fromJson(map, new TransportFactoryForGdch((String) map.get("ca_cert_path")));
    }

    static GdchCredentials fromJson(Map<String, Object> map, HttpTransportFactory httpTransportFactory) throws IOException {
        String strValidateField = validateField((String) map.get("format_version"), "format_version");
        String strValidateField2 = validateField((String) map.get("project"), "project");
        String strValidateField3 = validateField((String) map.get("private_key_id"), "private_key_id");
        String strValidateField4 = validateField((String) map.get("private_key"), "private_key");
        String strValidateField5 = validateField((String) map.get("name"), "name");
        String strValidateField6 = validateField((String) map.get("token_uri"), "token_uri");
        String str = (String) map.get("ca_cert_path");
        if (!SUPPORTED_FORMAT_VERSION.equals(strValidateField)) {
            throw new IOException(String.format("Only format version %s is supported.", SUPPORTED_FORMAT_VERSION));
        }
        try {
            return fromPkcs8(strValidateField4, newBuilder().setProjectId(strValidateField2).setPrivateKeyId(strValidateField3).setTokenServerUri(new URI(strValidateField6)).setServiceIdentityName(strValidateField5).setCaCertPath(str).setHttpTransportFactory(httpTransportFactory));
        } catch (URISyntaxException unused) {
            throw new IOException("Token server URI specified in 'token_uri' could not be parsed.");
        }
    }

    static GdchCredentials fromPkcs8(String str, Builder builder) throws IOException {
        builder.setPrivateKey(OAuth2Utils.privateKeyFromPkcs8(str));
        return new GdchCredentials(builder);
    }

    public GdchCredentials createWithGdchAudience(URI uri) throws IOException {
        Preconditions.checkNotNull(uri, "Audience are not configured for GDCH service account credentials.");
        return toBuilder().setGdchAudience(uri).build();
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials
    public AccessToken refreshAccessToken() throws IOException {
        Preconditions.checkNotNull(this.apiAudience, "Audience are not configured for GDCH service account. Specify the audience by calling createWithGDCHAudience.");
        JsonFactory jsonFactory = OAuth2Utils.JSON_FACTORY;
        String strCreateAssertion = createAssertion(jsonFactory, this.clock.currentTimeMillis(), getApiAudience());
        GenericData genericData = new GenericData();
        genericData.set("grant_type", "urn:ietf:params:oauth:token-type:token-exchange");
        genericData.set("assertion", strCreateAssertion);
        HttpRequest httpRequestBuildPostRequest = this.transportFactory.create().createRequestFactory().buildPostRequest(new GenericUrl(this.tokenServerUri), new UrlEncodedContent(genericData));
        httpRequestBuildPostRequest.setParser(new JsonObjectParser(jsonFactory));
        try {
            GenericData genericData2 = (GenericData) httpRequestBuildPostRequest.execute().parseAs(GenericData.class);
            return new AccessToken(OAuth2Utils.validateString(genericData2, "access_token", PARSE_ERROR_PREFIX), new Date(this.clock.currentTimeMillis() + (((long) OAuth2Utils.validateInt32(genericData2, "expires_in", PARSE_ERROR_PREFIX)) * 1000)));
        } catch (HttpResponseException e) {
            throw GoogleAuthException.createWithTokenEndpointResponseException(e, String.format("Error getting access token for GDCH service account: %s, iss: %s", e.getMessage(), getServiceIdentityName()));
        } catch (IOException e2) {
            throw GoogleAuthException.createWithTokenEndpointIOException(e2, String.format("Error getting access token for GDCH service account: %s, iss: %s", e2.getMessage(), getServiceIdentityName()));
        }
    }

    String createAssertion(JsonFactory jsonFactory, long j, URI uri) throws IOException {
        JsonWebSignature.Header header = new JsonWebSignature.Header();
        header.setAlgorithm("RS256");
        header.setType("JWT");
        header.setKeyId(this.privateKeyId);
        JsonWebToken.Payload payload = new JsonWebToken.Payload();
        payload.setIssuer(getIssuerSubjectValue(this.projectId, this.serviceIdentityName));
        payload.setSubject(getIssuerSubjectValue(this.projectId, this.serviceIdentityName));
        long j2 = j / 1000;
        payload.setIssuedAtTimeSeconds(Long.valueOf(j2));
        payload.setExpirationTimeSeconds(Long.valueOf(j2 + ((long) this.lifetime)));
        payload.setAudience(getTokenServerUri().toString());
        try {
            payload.set("api_audience", (Object) uri.toString());
            return JsonWebSignature.signUsingRsaSha256(this.privateKey, jsonFactory, header, payload);
        } catch (GeneralSecurityException e) {
            throw new IOException("Error signing service account access token request with private key.", e);
        }
    }

    static String getIssuerSubjectValue(String str, String str2) {
        return String.format("system:serviceaccount:%s:%s", str, str2);
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final String getPrivateKeyId() {
        return this.privateKeyId;
    }

    public final PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public final String getServiceIdentityName() {
        return this.serviceIdentityName;
    }

    public final URI getTokenServerUri() {
        return this.tokenServerUri;
    }

    public final URI getApiAudience() {
        return this.apiAudience;
    }

    public final HttpTransportFactory getTransportFactory() {
        return this.transportFactory;
    }

    public final String getCaCertPath() {
        return this.caCertPath;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public Builder toBuilder() {
        return new Builder(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.transportFactory = (HttpTransportFactory) newInstance(this.transportFactoryClassName);
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public int hashCode() {
        return Objects.hash(this.projectId, this.privateKeyId, this.privateKey, this.serviceIdentityName, this.tokenServerUri, this.transportFactoryClassName, this.apiAudience, this.caCertPath, Integer.valueOf(this.lifetime));
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public String toString() {
        return MoreObjects.toStringHelper(this).add("projectId", this.projectId).add("privateKeyId", this.privateKeyId).add("serviceIdentityName", this.serviceIdentityName).add("tokenServerUri", this.tokenServerUri).add("transportFactoryClassName", this.transportFactoryClassName).add("caCertPath", this.caCertPath).add("apiAudience", this.apiAudience).add("lifetime", this.lifetime).toString();
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public boolean equals(Object obj) {
        if (!(obj instanceof GdchCredentials)) {
            return false;
        }
        GdchCredentials gdchCredentials = (GdchCredentials) obj;
        return Objects.equals(this.projectId, gdchCredentials.projectId) && Objects.equals(this.privateKeyId, gdchCredentials.privateKeyId) && Objects.equals(this.privateKey, gdchCredentials.privateKey) && Objects.equals(this.serviceIdentityName, gdchCredentials.serviceIdentityName) && Objects.equals(this.tokenServerUri, gdchCredentials.tokenServerUri) && Objects.equals(this.transportFactoryClassName, gdchCredentials.transportFactoryClassName) && Objects.equals(this.apiAudience, gdchCredentials.apiAudience) && Objects.equals(this.caCertPath, gdchCredentials.caCertPath) && Objects.equals(Integer.valueOf(this.lifetime), Integer.valueOf(gdchCredentials.lifetime));
    }

    static InputStream readStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    public static class Builder extends GoogleCredentials.Builder {
        private URI apiAudience;
        private String caCertPath;
        private int lifetime;
        private PrivateKey privateKey;
        private String privateKeyId;
        private String projectId;
        private String serviceIdentityName;
        private URI tokenServerUri;
        private HttpTransportFactory transportFactory;

        protected Builder() {
            this.lifetime = GdchCredentials.DEFAULT_LIFETIME_IN_SECONDS;
        }

        protected Builder(GdchCredentials gdchCredentials) {
            this.lifetime = GdchCredentials.DEFAULT_LIFETIME_IN_SECONDS;
            this.projectId = gdchCredentials.projectId;
            this.privateKeyId = gdchCredentials.privateKeyId;
            this.privateKey = gdchCredentials.privateKey;
            this.serviceIdentityName = gdchCredentials.serviceIdentityName;
            this.tokenServerUri = gdchCredentials.tokenServerUri;
            this.transportFactory = gdchCredentials.transportFactory;
            this.caCertPath = gdchCredentials.caCertPath;
            this.lifetime = gdchCredentials.lifetime;
        }

        public Builder setProjectId(String str) {
            this.projectId = str;
            return this;
        }

        public Builder setPrivateKeyId(String str) {
            this.privateKeyId = str;
            return this;
        }

        public Builder setPrivateKey(PrivateKey privateKey) {
            this.privateKey = privateKey;
            return this;
        }

        public Builder setServiceIdentityName(String str) {
            this.serviceIdentityName = str;
            return this;
        }

        public Builder setTokenServerUri(URI uri) {
            this.tokenServerUri = uri;
            return this;
        }

        public Builder setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
            this.transportFactory = httpTransportFactory;
            return this;
        }

        public Builder setCaCertPath(String str) {
            this.caCertPath = str;
            return this;
        }

        public Builder setGdchAudience(URI uri) {
            this.apiAudience = uri;
            return this;
        }

        public String getProjectId() {
            return this.projectId;
        }

        public String getPrivateKeyId() {
            return this.privateKeyId;
        }

        public PrivateKey getPrivateKey() {
            return this.privateKey;
        }

        public String getServiceIdentityName() {
            return this.serviceIdentityName;
        }

        public URI getTokenServerUri() {
            return this.tokenServerUri;
        }

        public HttpTransportFactory getHttpTransportFactory() {
            return this.transportFactory;
        }

        public String getCaCertPath() {
            return this.caCertPath;
        }

        public int getLifetime() {
            return this.lifetime;
        }

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder, com.google.auth.oauth2.OAuth2Credentials.Builder
        public GdchCredentials build() {
            return new GdchCredentials(this);
        }
    }

    private static String validateField(String str, String str2) throws IOException {
        if (str == null || str.isEmpty()) {
            throw new IOException(String.format("Error reading GDCH service account credential from JSON, %s is misconfigured.", str2));
        }
        return str;
    }

    static class TransportFactoryForGdch implements HttpTransportFactory {
        HttpTransport transport;

        public TransportFactoryForGdch(String str) throws IOException {
            setTransport(str);
        }

        @Override // com.google.auth.http.HttpTransportFactory
        public HttpTransport create() {
            return this.transport;
        }

        private void setTransport(String str) throws IOException {
            if (str == null || str.isEmpty()) {
                this.transport = new NetHttpTransport();
                return;
            }
            try {
                this.transport = new NetHttpTransport.Builder().trustCertificatesFromStream(GdchCredentials.readStream(new File(str))).build();
            } catch (IOException e) {
                throw new IOException(String.format("Error reading certificate file from CA cert path, value '%s': %s", str, e.getMessage()), e);
            } catch (GeneralSecurityException e2) {
                throw new IOException("Error initiating transport with certificate stream.", e2);
            }
        }
    }
}

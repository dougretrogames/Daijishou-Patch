package com.google.api.client.auth.openidconnect;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Clock;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class IdTokenVerifier {
    public static final long DEFAULT_TIME_SKEW_SECONDS = 300;
    private static final String FEDERATED_SIGNON_CERT_URL = "https://www.googleapis.com/oauth2/v3/certs";
    private static final String IAP_CERT_URL = "https://www.gstatic.com/iap/verify/public_key-jwk";
    private static final String NOT_SUPPORTED_ALGORITHM = "Unexpected signing algorithm %s: expected either RS256 or ES256";
    static final String SKIP_SIGNATURE_ENV_VAR = "OAUTH_CLIENT_SKIP_SIGNATURE";
    private final long acceptableTimeSkewSeconds;
    private final Collection<String> audience;
    private final String certificatesLocation;
    private final Clock clock;
    private final Environment environment;
    private final Collection<String> issuers;
    private final LoadingCache<String, Map<String, PublicKey>> publicKeyCache;
    private static final Logger LOGGER = Logger.getLogger(IdTokenVerifier.class.getName());
    private static final Set<String> SUPPORTED_ALGORITHMS = ImmutableSet.of("RS256", "ES256");
    static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    public IdTokenVerifier() {
        this(new Builder());
    }

    protected IdTokenVerifier(Builder builder) {
        this.certificatesLocation = builder.certificatesLocation;
        this.clock = builder.clock;
        this.acceptableTimeSkewSeconds = builder.acceptableTimeSkewSeconds;
        this.issuers = builder.issuers == null ? null : Collections.unmodifiableCollection(builder.issuers);
        this.audience = builder.audience != null ? Collections.unmodifiableCollection(builder.audience) : null;
        this.publicKeyCache = CacheBuilder.newBuilder().expireAfterWrite(1L, TimeUnit.HOURS).build(new PublicKeyLoader(builder.httpTransportFactory == null ? new DefaultHttpTransportFactory() : builder.httpTransportFactory));
        this.environment = builder.environment == null ? new Environment() : builder.environment;
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final long getAcceptableTimeSkewSeconds() {
        return this.acceptableTimeSkewSeconds;
    }

    public final String getIssuer() {
        Collection<String> collection = this.issuers;
        if (collection == null) {
            return null;
        }
        return collection.iterator().next();
    }

    public final Collection<String> getIssuers() {
        return this.issuers;
    }

    public final Collection<String> getAudience() {
        return this.audience;
    }

    @Deprecated
    public boolean verify(IdToken idToken) {
        try {
            return verifyOrThrow(idToken);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), (Throwable) e);
            return false;
        }
    }

    public boolean verifyOrThrow(IdToken idToken) throws IOException {
        if (!verifyPayload(idToken)) {
            return false;
        }
        try {
            return verifySignature(idToken);
        } catch (VerificationException e) {
            LOGGER.log(Level.INFO, "Id token signature verification failed. ", (Throwable) e);
            return false;
        }
    }

    protected boolean verifyPayload(IdToken idToken) {
        Collection<String> collection = this.issuers;
        if (collection != null && !idToken.verifyIssuer(collection)) {
            return false;
        }
        Collection<String> collection2 = this.audience;
        return (collection2 == null || idToken.verifyAudience(collection2)) && idToken.verifyTime(this.clock.currentTimeMillis(), this.acceptableTimeSkewSeconds);
    }

    boolean verifySignature(IdToken idToken) throws IOException, VerificationException {
        if (Boolean.parseBoolean(this.environment.getVariable(SKIP_SIGNATURE_ENV_VAR))) {
            return true;
        }
        if (!SUPPORTED_ALGORITHMS.contains(idToken.getHeader().getAlgorithm())) {
            throw new VerificationException(String.format(NOT_SUPPORTED_ALGORITHM, idToken.getHeader().getAlgorithm()));
        }
        try {
            PublicKey publicKey = this.publicKeyCache.get(getCertificateLocation(idToken.getHeader())).get(idToken.getHeader().getKeyId());
            if (publicKey == null) {
                throw new IOException("Could not find public key for provided keyId: " + idToken.getHeader().getKeyId());
            }
            try {
                if (idToken.verifySignature(publicKey)) {
                    return true;
                }
                throw new VerificationException("Invalid signature");
            } catch (GeneralSecurityException e) {
                throw new VerificationException("Error validating token", e);
            }
        } catch (UncheckedExecutionException | ExecutionException e2) {
            throw new IOException("Error fetching public key from certificate location " + this.certificatesLocation, e2);
        }
    }

    private String getCertificateLocation(JsonWebSignature.Header header) throws VerificationException {
        String str = this.certificatesLocation;
        if (str != null) {
            return str;
        }
        String algorithm = header.getAlgorithm();
        algorithm.hashCode();
        if (algorithm.equals("ES256")) {
            return IAP_CERT_URL;
        }
        if (algorithm.equals("RS256")) {
            return FEDERATED_SIGNON_CERT_URL;
        }
        throw new VerificationException(String.format(NOT_SUPPORTED_ALGORITHM, header.getAlgorithm()));
    }

    public static class Builder {
        Collection<String> audience;
        String certificatesLocation;
        Environment environment;
        HttpTransportFactory httpTransportFactory;
        Collection<String> issuers;
        Clock clock = Clock.SYSTEM;
        long acceptableTimeSkewSeconds = 300;

        public IdTokenVerifier build() {
            return new IdTokenVerifier(this);
        }

        public final Clock getClock() {
            return this.clock;
        }

        public Builder setClock(Clock clock) {
            this.clock = (Clock) Preconditions.checkNotNull(clock);
            return this;
        }

        public final String getIssuer() {
            Collection<String> collection = this.issuers;
            if (collection == null) {
                return null;
            }
            return collection.iterator().next();
        }

        public Builder setIssuer(String str) {
            if (str == null) {
                return setIssuers(null);
            }
            return setIssuers(Collections.singleton(str));
        }

        public Builder setCertificatesLocation(String str) {
            this.certificatesLocation = str;
            return this;
        }

        public final Collection<String> getIssuers() {
            return this.issuers;
        }

        public Builder setIssuers(Collection<String> collection) {
            Preconditions.checkArgument(collection == null || !collection.isEmpty(), "Issuers must not be empty");
            this.issuers = collection;
            return this;
        }

        public final Collection<String> getAudience() {
            return this.audience;
        }

        public Builder setAudience(Collection<String> collection) {
            this.audience = collection;
            return this;
        }

        public final long getAcceptableTimeSkewSeconds() {
            return this.acceptableTimeSkewSeconds;
        }

        public Builder setAcceptableTimeSkewSeconds(long j) {
            Preconditions.checkArgument(j >= 0);
            this.acceptableTimeSkewSeconds = j;
            return this;
        }

        final Environment getEnvironment() {
            return this.environment;
        }

        Builder setEnvironment(Environment environment) {
            this.environment = environment;
            return this;
        }

        public Builder setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
            this.httpTransportFactory = httpTransportFactory;
            return this;
        }
    }

    static class PublicKeyLoader extends CacheLoader<String, Map<String, PublicKey>> {
        private static final int DEFAULT_NUMBER_OF_RETRIES = 2;
        private static final int INITIAL_RETRY_INTERVAL_MILLIS = 1000;
        private static final double RETRY_MULTIPLIER = 2.0d;
        private static final double RETRY_RANDOMIZATION_FACTOR = 0.1d;
        private final HttpTransportFactory httpTransportFactory;

        public static class JsonWebKey {

            @Key
            public String alg;

            @Key
            public String crv;

            @Key
            public String e;

            @Key
            public String kid;

            @Key
            public String kty;

            @Key
            public String n;

            @Key
            public String use;

            @Key
            public String x;

            @Key
            public String y;
        }

        public static class JsonWebKeySet extends GenericJson {

            @Key
            public List<JsonWebKey> keys;
        }

        PublicKeyLoader(HttpTransportFactory httpTransportFactory) {
            this.httpTransportFactory = httpTransportFactory;
        }

        @Override // com.google.common.cache.CacheLoader
        public Map<String, PublicKey> load(String str) throws Exception {
            try {
                HttpRequest parser = this.httpTransportFactory.create().createRequestFactory().buildGetRequest(new GenericUrl(str)).setParser(GsonFactory.getDefaultInstance().createJsonObjectParser());
                parser.setNumberOfRetries(2);
                parser.setUnsuccessfulResponseHandler(new HttpBackOffUnsuccessfulResponseHandler(new ExponentialBackOff.Builder().setInitialIntervalMillis(1000).setRandomizationFactor(RETRY_RANDOMIZATION_FACTOR).setMultiplier(RETRY_MULTIPLIER).build()).setBackOffRequired(HttpBackOffUnsuccessfulResponseHandler.BackOffRequired.ALWAYS));
                JsonWebKeySet jsonWebKeySet = (JsonWebKeySet) parser.execute().parseAs(JsonWebKeySet.class);
                ImmutableMap.Builder builder = new ImmutableMap.Builder();
                if (jsonWebKeySet.keys == null) {
                    for (String str2 : jsonWebKeySet.keySet()) {
                        builder.put(str2, buildPublicKey((String) jsonWebKeySet.get(str2)));
                    }
                } else {
                    for (JsonWebKey jsonWebKey : jsonWebKeySet.keys) {
                        try {
                            builder.put(jsonWebKey.kid, buildPublicKey(jsonWebKey));
                        } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidParameterSpecException e) {
                            IdTokenVerifier.LOGGER.log(Level.WARNING, "Failed to put a key into the cache", e);
                        }
                    }
                }
                ImmutableMap immutableMapBuild = builder.build();
                if (immutableMapBuild.isEmpty()) {
                    throw new VerificationException("No valid public key returned by the keystore: " + str);
                }
                return immutableMapBuild;
            } catch (IOException e2) {
                IdTokenVerifier.LOGGER.log(Level.WARNING, "Failed to get a certificate from certificate location " + str, (Throwable) e2);
                throw e2;
            }
        }

        private PublicKey buildPublicKey(JsonWebKey jsonWebKey) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidParameterSpecException {
            if ("ES256".equals(jsonWebKey.alg)) {
                return buildEs256PublicKey(jsonWebKey);
            }
            if ("RS256".equals(jsonWebKey.alg)) {
                return buildRs256PublicKey(jsonWebKey);
            }
            return null;
        }

        private PublicKey buildPublicKey(String str) throws CertificateException, UnsupportedEncodingException {
            return CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(str.getBytes("UTF-8"))).getPublicKey();
        }

        private PublicKey buildRs256PublicKey(JsonWebKey jsonWebKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
            com.google.common.base.Preconditions.checkArgument("RSA".equals(jsonWebKey.kty));
            com.google.common.base.Preconditions.checkNotNull(jsonWebKey.e);
            com.google.common.base.Preconditions.checkNotNull(jsonWebKey.n);
            return KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, Base64.decodeBase64(jsonWebKey.n)), new BigInteger(1, Base64.decodeBase64(jsonWebKey.e))));
        }

        private PublicKey buildEs256PublicKey(JsonWebKey jsonWebKey) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidParameterSpecException {
            com.google.common.base.Preconditions.checkArgument("EC".equals(jsonWebKey.kty));
            com.google.common.base.Preconditions.checkArgument("P-256".equals(jsonWebKey.crv));
            ECPoint eCPoint = new ECPoint(new BigInteger(1, Base64.decodeBase64(jsonWebKey.x)), new BigInteger(1, Base64.decodeBase64(jsonWebKey.y)));
            AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("EC");
            algorithmParameters.init(new ECGenParameterSpec("secp256r1"));
            return KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(eCPoint, (ECParameterSpec) algorithmParameters.getParameterSpec(ECParameterSpec.class)));
        }
    }

    static class VerificationException extends Exception {
        public VerificationException(String str) {
            super(str);
        }

        public VerificationException(String str, Throwable th) {
            super(str, th);
        }
    }

    static class DefaultHttpTransportFactory implements HttpTransportFactory {
        DefaultHttpTransportFactory() {
        }

        @Override // com.google.api.client.auth.openidconnect.HttpTransportFactory
        public HttpTransport create() {
            return IdTokenVerifier.HTTP_TRANSPORT;
        }
    }
}

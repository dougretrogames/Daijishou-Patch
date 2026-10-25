package com.google.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Clock;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.client.util.Key;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.base.Preconditions;
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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class TokenVerifier {
    private static final String FEDERATED_SIGNON_CERT_URL = "https://www.googleapis.com/oauth2/v3/certs";
    private static final String IAP_CERT_URL = "https://www.gstatic.com/iap/verify/public_key-jwk";
    private static final Set<String> SUPPORTED_ALGORITHMS = ImmutableSet.of("RS256", "ES256");
    private final String audience;
    private final String certificatesLocation;
    private final Clock clock;
    private final String issuer;
    private final PublicKey publicKey;
    private final LoadingCache<String, Map<String, PublicKey>> publicKeyCache;

    /* synthetic */ TokenVerifier(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private TokenVerifier(Builder builder) {
        this.audience = builder.audience;
        this.certificatesLocation = builder.certificatesLocation;
        this.issuer = builder.issuer;
        this.publicKey = builder.publicKey;
        this.clock = builder.clock;
        this.publicKeyCache = CacheBuilder.newBuilder().expireAfterWrite(1L, TimeUnit.HOURS).build(new PublicKeyLoader(builder.httpTransportFactory));
    }

    public static Builder newBuilder() {
        return new Builder().setClock(Clock.SYSTEM).setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY);
    }

    public JsonWebSignature verify(String str) throws VerificationException {
        try {
            JsonWebSignature jsonWebSignature = JsonWebSignature.parse(OAuth2Utils.JSON_FACTORY, str);
            String str2 = this.audience;
            if (str2 != null && !str2.equals(jsonWebSignature.getPayload().getAudience())) {
                throw new VerificationException("Expected audience does not match");
            }
            String str3 = this.issuer;
            if (str3 != null && !str3.equals(jsonWebSignature.getPayload().getIssuer())) {
                throw new VerificationException("Expected issuer does not match");
            }
            Long expirationTimeSeconds = jsonWebSignature.getPayload().getExpirationTimeSeconds();
            if (expirationTimeSeconds != null && expirationTimeSeconds.longValue() <= this.clock.currentTimeMillis() / 1000) {
                throw new VerificationException("Token is expired");
            }
            if (!SUPPORTED_ALGORITHMS.contains(jsonWebSignature.getHeader().getAlgorithm())) {
                throw new VerificationException("Unexpected signing algorithm: expected either RS256 or ES256");
            }
            PublicKey publicKey = this.publicKey;
            if (publicKey == null) {
                try {
                    publicKey = this.publicKeyCache.get(getCertificateLocation(jsonWebSignature)).get(jsonWebSignature.getHeader().getKeyId());
                } catch (UncheckedExecutionException | ExecutionException e) {
                    throw new VerificationException("Error fetching PublicKey from certificate location", e);
                }
            }
            if (publicKey == null) {
                throw new VerificationException("Could not find PublicKey for provided keyId: " + jsonWebSignature.getHeader().getKeyId());
            }
            try {
                if (jsonWebSignature.verifySignature(publicKey)) {
                    return jsonWebSignature;
                }
                throw new VerificationException("Invalid signature");
            } catch (GeneralSecurityException e2) {
                throw new VerificationException("Error validating token", e2);
            }
        } catch (IOException e3) {
            throw new VerificationException("Error parsing JsonWebSignature token", e3);
        }
    }

    private String getCertificateLocation(JsonWebSignature jsonWebSignature) throws VerificationException {
        String str = this.certificatesLocation;
        if (str != null) {
            return str;
        }
        String algorithm = jsonWebSignature.getHeader().getAlgorithm();
        algorithm.hashCode();
        if (algorithm.equals("ES256")) {
            return IAP_CERT_URL;
        }
        if (algorithm.equals("RS256")) {
            return FEDERATED_SIGNON_CERT_URL;
        }
        throw new VerificationException("Unknown algorithm");
    }

    public static class Builder {
        private String audience;
        private String certificatesLocation;
        private Clock clock;
        private HttpTransportFactory httpTransportFactory;
        private String issuer;
        private PublicKey publicKey;

        public Builder setAudience(String str) {
            this.audience = str;
            return this;
        }

        public Builder setCertificatesLocation(String str) {
            this.certificatesLocation = str;
            return this;
        }

        public Builder setIssuer(String str) {
            this.issuer = str;
            return this;
        }

        public Builder setPublicKey(PublicKey publicKey) {
            this.publicKey = publicKey;
            return this;
        }

        public Builder setClock(Clock clock) {
            this.clock = clock;
            return this;
        }

        public Builder setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
            this.httpTransportFactory = httpTransportFactory;
            return this;
        }

        public TokenVerifier build() {
            return new TokenVerifier(this, null);
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
            HttpRequest parser = this.httpTransportFactory.create().createRequestFactory().buildGetRequest(new GenericUrl(str)).setParser(OAuth2Utils.JSON_FACTORY.createJsonObjectParser());
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
                        e.printStackTrace();
                    }
                }
            }
            ImmutableMap immutableMapBuild = builder.build();
            if (immutableMapBuild.isEmpty()) {
                throw new VerificationException("No valid public key returned by the keystore: " + str);
            }
            return immutableMapBuild;
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
            Preconditions.checkArgument("RSA".equals(jsonWebKey.kty));
            Preconditions.checkNotNull(jsonWebKey.e);
            Preconditions.checkNotNull(jsonWebKey.n);
            return KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, Base64.decodeBase64(jsonWebKey.n)), new BigInteger(1, Base64.decodeBase64(jsonWebKey.e))));
        }

        private PublicKey buildEs256PublicKey(JsonWebKey jsonWebKey) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidParameterSpecException {
            Preconditions.checkArgument("EC".equals(jsonWebKey.kty));
            Preconditions.checkArgument("P-256".equals(jsonWebKey.crv));
            ECPoint eCPoint = new ECPoint(new BigInteger(1, Base64.decodeBase64(jsonWebKey.x)), new BigInteger(1, Base64.decodeBase64(jsonWebKey.y)));
            AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("EC");
            algorithmParameters.init(new ECGenParameterSpec("secp256r1"));
            return KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(eCPoint, (ECParameterSpec) algorithmParameters.getParameterSpec(ECParameterSpec.class)));
        }
    }

    public static class VerificationException extends Exception {
        public VerificationException(String str) {
            super(str);
        }

        public VerificationException(String str, Throwable th) {
            super(str, th);
        }
    }
}

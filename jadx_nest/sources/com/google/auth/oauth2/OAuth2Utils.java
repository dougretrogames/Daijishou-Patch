package com.google.auth.oauth2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.api.client.googleapis.auth.oauth2.GoogleOAuthConstants;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.PemReader;
import com.google.api.client.util.SecurityUtils;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.io.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpStatus;

/* INFO: loaded from: classes3.dex */
class OAuth2Utils {
    static final String BEARER_PREFIX = "Bearer ";
    static final String GRANT_TYPE_JWT_BEARER = "urn:ietf:params:oauth:grant-type:jwt-bearer";
    static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
    static final String TOKEN_RESPONSE_SCOPE = "scope";
    static final String TOKEN_TYPE_ACCESS_TOKEN = "urn:ietf:params:oauth:token-type:access_token";
    static final String TOKEN_TYPE_TOKEN_EXCHANGE = "urn:ietf:params:oauth:token-type:token-exchange";
    static final URI TOKEN_SERVER_URI = URI.create(GoogleOAuthConstants.TOKEN_SERVER_URL);
    static final URI TOKEN_REVOKE_URI = URI.create("https://oauth2.googleapis.com/revoke");
    static final URI USER_AUTH_URI = URI.create(GoogleOAuthConstants.AUTHORIZATION_SERVER_URL);
    static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    static final HttpTransportFactory HTTP_TRANSPORT_FACTORY = new DefaultHttpTransportFactory();
    static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static String VALUE_NOT_FOUND_MESSAGE = "%sExpected value %s not found.";
    private static String VALUE_WRONG_TYPE_MESSAGE = "%sExpected %s value %s of wrong type.";
    public static final Set<Integer> TOKEN_ENDPOINT_RETRYABLE_STATUS_CODES = new HashSet(Arrays.asList(500, 503, Integer.valueOf(HttpStatus.SC_REQUEST_TIMEOUT), Integer.valueOf(HttpStatus.SC_TOO_MANY_REQUESTS)));

    static class DefaultHttpTransportFactory implements HttpTransportFactory {
        DefaultHttpTransportFactory() {
        }

        @Override // com.google.auth.http.HttpTransportFactory
        public HttpTransport create() {
            return OAuth2Utils.HTTP_TRANSPORT;
        }
    }

    static boolean headersContainValue(HttpHeaders httpHeaders, String str, String str2) {
        Object obj = httpHeaders.get(str);
        if (obj instanceof Collection) {
            return ((Collection) obj).contains(str2);
        }
        return false;
    }

    static GenericJson parseJson(String str) throws IOException {
        return (GenericJson) new JsonObjectParser(JSON_FACTORY).parseAndClose((InputStream) new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8, GenericJson.class);
    }

    static String validateString(Map<String, Object> map, String str, String str2) throws IOException {
        Object obj = map.get(str);
        if (obj == null) {
            throw new IOException(String.format(VALUE_NOT_FOUND_MESSAGE, str2, str));
        }
        if (!(obj instanceof String)) {
            throw new IOException(String.format(VALUE_WRONG_TYPE_MESSAGE, str2, TypedValues.Custom.S_STRING, str));
        }
        return (String) obj;
    }

    static void writeInputStreamToFile(InputStream inputStream, String str) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
        try {
            ByteStreams.copy(inputStream, fileOutputStream);
        } finally {
            fileOutputStream.close();
        }
    }

    static String validateOptionalString(Map<String, Object> map, String str, String str2) throws IOException {
        Object obj = map.get(str);
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof String)) {
            throw new IOException(String.format(VALUE_WRONG_TYPE_MESSAGE, str2, TypedValues.Custom.S_STRING, str));
        }
        return (String) obj;
    }

    static List<String> validateOptionalListString(Map<String, Object> map, String str, String str2) throws IOException {
        Object obj = map.get(str);
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof List)) {
            throw new IOException(String.format(VALUE_WRONG_TYPE_MESSAGE, str2, "List<String>", str));
        }
        return (List) obj;
    }

    static int validateInt32(Map<String, Object> map, String str, String str2) throws IOException {
        Object obj = map.get(str);
        if (obj == null) {
            throw new IOException(String.format(VALUE_NOT_FOUND_MESSAGE, str2, str));
        }
        if (obj instanceof BigDecimal) {
            return ((BigDecimal) obj).intValueExact();
        }
        if (!(obj instanceof Integer)) {
            throw new IOException(String.format(VALUE_WRONG_TYPE_MESSAGE, str2, TypedValues.Custom.S_INT, str));
        }
        return ((Integer) obj).intValue();
    }

    static long validateLong(Map<String, Object> map, String str, String str2) throws IOException {
        Object obj = map.get(str);
        if (obj == null) {
            throw new IOException(String.format(VALUE_NOT_FOUND_MESSAGE, str2, str));
        }
        if (obj instanceof BigDecimal) {
            return ((BigDecimal) obj).longValueExact();
        }
        if (!(obj instanceof Long)) {
            throw new IOException(String.format(VALUE_WRONG_TYPE_MESSAGE, str2, "long", str));
        }
        return ((Long) obj).longValue();
    }

    static Map<String, Object> validateMap(Map<String, Object> map, String str, String str2) throws IOException {
        Object obj = map.get(str);
        if (obj == null) {
            throw new IOException(String.format(VALUE_NOT_FOUND_MESSAGE, str2, str));
        }
        if (!(obj instanceof Map)) {
            throw new IOException(String.format(VALUE_WRONG_TYPE_MESSAGE, str2, "Map", str));
        }
        return (Map) obj;
    }

    static PrivateKey privateKeyFromPkcs8(String str) throws IOException {
        PemReader.Section firstSectionAndClose = PemReader.readFirstSectionAndClose(new StringReader(str), "PRIVATE KEY");
        if (firstSectionAndClose == null) {
            throw new IOException("Invalid PKCS#8 data.");
        }
        try {
            return SecurityUtils.getRsaKeyFactory().generatePrivate(new PKCS8EncodedKeySpec(firstSectionAndClose.getBase64DecodedBytes()));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new IOException("Unexpected exception reading PKCS#8 data", e);
        }
    }

    private OAuth2Utils() {
    }
}

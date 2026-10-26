package org.eclipse.jgit.transport;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.util.Hex;
import org.eclipse.jgit.util.HttpSupport;

/* INFO: loaded from: classes5.dex */
public final class AwsRequestSignerV4 {
    private static final String ALGORITHM = "HMAC-SHA256";
    private static final String EMPTY_BODY_SHA256 = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";
    private static final String MAC_ALGORITHM = "HmacSHA256";
    private static final String SCHEME = "AWS4";
    private static final String TERMINATOR = "aws4_request";
    private static final DateTimeFormatter AMZ_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'");
    private static final DateTimeFormatter SCOPE_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");

    private AwsRequestSignerV4() {
    }

    public static void sign(HttpURLConnection httpURLConnection, Map<String, String> map, long j, String str, String str2, String str3, String str4, char[] cArr) {
        String host;
        HashMap map2 = new HashMap();
        httpURLConnection.getRequestProperties().forEach(new AwsRequestSignerV4$$ExternalSyntheticLambda1(map2));
        if (j > 0) {
            map2.put("Content-Length", String.valueOf(j));
        } else {
            str = EMPTY_BODY_SHA256;
        }
        map2.put("x-amz-content-sha256", str);
        OffsetDateTime offsetDateTimeAtOffset = Instant.now().atOffset(ZoneOffset.UTC);
        String str5 = offsetDateTimeAtOffset.format(AMZ_DATE_FORMAT);
        map2.put("x-amz-date", str5);
        URL url = httpURLConnection.getURL();
        int port = url.getPort();
        if (port > -1) {
            host = url.getHost().concat(CollectionUtils.COLON + port);
        } else {
            host = url.getHost();
        }
        map2.put("Host", host);
        String canonicalizeHeaderNames = getCanonicalizeHeaderNames(map2);
        String canonicalizedHeaderString = getCanonicalizedHeaderString(map2);
        String canonicalizedQueryString = getCanonicalizedQueryString(map);
        String str6 = httpURLConnection.getRequestMethod() + "\n" + getCanonicalizedResourcePath(url) + "\n" + canonicalizedQueryString + "\n" + canonicalizedHeaderString + "\n" + canonicalizeHeaderNames + "\n" + str;
        String str7 = offsetDateTimeAtOffset.format(SCOPE_DATE_FORMAT);
        String str8 = str7 + InternalZipConstants.ZIP_FILE_SEPARATOR + str3 + InternalZipConstants.ZIP_FILE_SEPARATOR + str2 + "/aws4_request";
        byte[] bArrSignStringWithKey = signStringWithKey("AWS4-HMAC-SHA256\n" + str5 + "\n" + str8 + "\n" + Hex.toHexString(hash(str6.getBytes(StandardCharsets.UTF_8))), signStringWithKey(TERMINATOR, signStringWithKey(str2, signStringWithKey(str3, signStringWithKey(str7, SCHEME.concat(new String(cArr)).getBytes(StandardCharsets.UTF_8))))));
        String str9 = "AWS4-HMAC-SHA256 " + ("Credential=" + str4 + InternalZipConstants.ZIP_FILE_SEPARATOR + str8) + ", " + ("SignedHeaders=" + canonicalizeHeaderNames) + ", " + ("Signature=" + Hex.toHexString(bArrSignStringWithKey));
        httpURLConnection.getClass();
        map2.forEach(new AwsRequestSignerV4$$ExternalSyntheticLambda2(httpURLConnection));
        httpURLConnection.setRequestProperty("Authorization", str9);
    }

    public static String calculateBodyHash(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            return EMPTY_BODY_SHA256;
        }
        return Hex.toHexString(hash(bArr));
    }

    private static String getCanonicalizeHeaderNames(Map<String, String> map) {
        return (String) map.keySet().stream().map(new AwsRequestSignerV4$$ExternalSyntheticLambda0()).sorted().collect(Collectors.joining(";"));
    }

    private static String getCanonicalizedHeaderString(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        map.keySet().stream().sorted(String.CASE_INSENSITIVE_ORDER).forEach(new AwsRequestSignerV4$$ExternalSyntheticLambda4(map, sb));
        return sb.toString();
    }

    static /* synthetic */ void lambda$3(Map map, StringBuilder sb, String str) {
        String strReplaceAll = str.toLowerCase().replaceAll(WalkEncryption.Vals.REGEX_WS, " ");
        sb.append(strReplaceAll).append(AbstractJsonLexerKt.COLON).append(((String) map.get(str)).replaceAll(WalkEncryption.Vals.REGEX_WS, " ")).append('\n');
    }

    private static String getCanonicalizedResourcePath(URL url) {
        String path;
        if (url == null || (path = url.getPath()) == null || path.isEmpty()) {
            return InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        String strUrlEncode = HttpSupport.urlEncode(path, true);
        return strUrlEncode.startsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) ? strUrlEncode : InternalZipConstants.ZIP_FILE_SEPARATOR.concat(strUrlEncode);
    }

    public static String getCanonicalizedQueryString(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        return (String) map.keySet().stream().sorted().map(new AwsRequestSignerV4$$ExternalSyntheticLambda3(map)).collect(Collectors.joining("&"));
    }

    static /* synthetic */ String lambda$4(Map map, String str) {
        return HttpSupport.urlEncode(str, false) + "=" + HttpSupport.urlEncode((String) map.get(str), false);
    }

    public static byte[] hash(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception e) {
            throw new RuntimeException(JGitText.get().couldNotHashByteArrayWithSha256, e);
        }
    }

    private static byte[] signStringWithKey(String str, byte[] bArr) {
        try {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            Mac mac = Mac.getInstance(MAC_ALGORITHM);
            mac.init(new SecretKeySpec(bArr, MAC_ALGORITHM));
            return mac.doFinal(bytes);
        } catch (Exception e) {
            throw new RuntimeException(JGitText.get().couldNotSignStringWithKey, e);
        }
    }
}

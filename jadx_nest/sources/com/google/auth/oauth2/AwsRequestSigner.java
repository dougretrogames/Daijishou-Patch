package com.google.auth.oauth2;

import com.google.auth.ServiceAccountSigner;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.io.BaseEncoding;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.lib.BranchConfig;

/* JADX INFO: loaded from: classes3.dex */
class AwsRequestSigner {
    private static final String AWS_REQUEST_TYPE = "aws4_request";
    private static final String HASHING_ALGORITHM = "AWS4-HMAC-SHA256";
    private final Map<String, String> additionalHeaders;
    private final AwsSecurityCredentials awsSecurityCredentials;
    private final AwsDates dates;
    private final String httpMethod;
    private final String region;
    private final String requestPayload;
    private final URI uri;

    /* synthetic */ AwsRequestSigner(AwsSecurityCredentials awsSecurityCredentials, String str, String str2, String str3, String str4, Map map, AwsDates awsDates, AnonymousClass1 anonymousClass1) {
        this(awsSecurityCredentials, str, str2, str3, str4, map, awsDates);
    }

    private AwsRequestSigner(AwsSecurityCredentials awsSecurityCredentials, String str, String str2, String str3, @Nullable String str4, @Nullable Map<String, String> map, @Nullable AwsDates awsDates) {
        this.awsSecurityCredentials = (AwsSecurityCredentials) Preconditions.checkNotNull(awsSecurityCredentials);
        this.httpMethod = (String) Preconditions.checkNotNull(str);
        this.uri = URI.create(str2).normalize();
        this.region = (String) Preconditions.checkNotNull(str3);
        this.requestPayload = str4 == null ? "" : str4;
        this.additionalHeaders = map != null ? new HashMap(map) : new HashMap();
        this.dates = awsDates == null ? AwsDates.generateXAmzDate() : awsDates;
    }

    AwsRequestSignature sign() {
        String next = Splitter.on(BranchConfig.LOCAL_REPOSITORY).split(this.uri.getHost()).iterator().next();
        Map<String, String> canonicalHeaders = getCanonicalHeaders(this.dates.getOriginalDate());
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = canonicalHeaders.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toLowerCase(Locale.US));
        }
        Collections.sort(arrayList);
        String strCreateCanonicalRequestHash = createCanonicalRequestHash(canonicalHeaders, arrayList);
        String str = this.dates.getFormattedDate() + InternalZipConstants.ZIP_FILE_SEPARATOR + this.region + InternalZipConstants.ZIP_FILE_SEPARATOR + next + "/aws4_request";
        String strCalculateAwsV4Signature = calculateAwsV4Signature(next, this.awsSecurityCredentials.getSecretAccessKey(), this.dates.getFormattedDate(), this.region, createStringToSign(strCreateCanonicalRequestHash, this.dates.getXAmzDate(), str));
        return new AwsRequestSignature.Builder().setSignature(strCalculateAwsV4Signature).setCanonicalHeaders(canonicalHeaders).setHttpMethod(this.httpMethod).setSecurityCredentials(this.awsSecurityCredentials).setCredentialScope(str).setUrl(this.uri.toString()).setDate(this.dates.getOriginalDate()).setRegion(this.region).setAuthorizationHeader(generateAuthorizationHeader(arrayList, this.awsSecurityCredentials.getAccessKeyId(), str, strCalculateAwsV4Signature)).build();
    }

    private String createCanonicalRequestHash(Map<String, String> map, List<String> list) {
        StringBuilder sbAppend = new StringBuilder(this.httpMethod).append("\n");
        sbAppend.append(this.uri.getRawPath().isEmpty() ? InternalZipConstants.ZIP_FILE_SEPARATOR : this.uri.getRawPath()).append("\n");
        sbAppend.append(this.uri.getRawQuery() != null ? this.uri.getRawQuery() : "").append("\n");
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str).append(CollectionUtils.COLON).append(map.get(str)).append("\n");
        }
        sbAppend.append((CharSequence) sb).append("\n");
        sbAppend.append(Joiner.on(';').join(list)).append("\n");
        sbAppend.append(getHexEncodedSha256Hash(this.requestPayload.getBytes(StandardCharsets.UTF_8)));
        return getHexEncodedSha256Hash(sbAppend.toString().getBytes(StandardCharsets.UTF_8));
    }

    private String createStringToSign(String str, String str2, String str3) {
        return "AWS4-HMAC-SHA256\n" + str2 + "\n" + str3 + "\n" + str;
    }

    private String calculateAwsV4Signature(String str, String str2, String str3, String str4, String str5) {
        return BaseEncoding.base16().lowerCase().encode(sign(sign(sign(sign(sign(("AWS4" + str2).getBytes(StandardCharsets.UTF_8), str3.getBytes(StandardCharsets.UTF_8)), str4.getBytes(StandardCharsets.UTF_8)), str.getBytes(StandardCharsets.UTF_8)), AWS_REQUEST_TYPE.getBytes(StandardCharsets.UTF_8)), str5.getBytes(StandardCharsets.UTF_8)));
    }

    private String generateAuthorizationHeader(List<String> list, String str, String str2, String str3) {
        return String.format("%s Credential=%s/%s, SignedHeaders=%s, Signature=%s", HASHING_ALGORITHM, str, str2, Joiner.on(';').join(list), str3);
    }

    private Map<String, String> getCanonicalHeaders(String str) {
        HashMap map = new HashMap();
        map.put("host", this.uri.getHost());
        if (!this.additionalHeaders.containsKey("date")) {
            map.put("x-amz-date", str);
        }
        if (this.awsSecurityCredentials.getSessionToken() != null && !this.awsSecurityCredentials.getSessionToken().isEmpty()) {
            map.put("x-amz-security-token", this.awsSecurityCredentials.getSessionToken());
        }
        for (String str2 : this.additionalHeaders.keySet()) {
            map.put(str2.toLowerCase(Locale.US), this.additionalHeaders.get(str2));
        }
        return map;
    }

    private static byte[] sign(byte[] bArr, byte[] bArr2) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(bArr, "HmacSHA256"));
            return mac.doFinal(bArr2);
        } catch (InvalidKeyException e) {
            throw new ServiceAccountSigner.SigningException("Invalid key used when calculating the AWS V4 Signature", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("HmacSHA256 must be supported by the JVM.", e2);
        }
    }

    private static String getHexEncodedSha256Hash(byte[] bArr) {
        try {
            return BaseEncoding.base16().lowerCase().encode(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(bArr));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to compute SHA-256 hash.", e);
        }
    }

    static Builder newBuilder(AwsSecurityCredentials awsSecurityCredentials, String str, String str2, String str3) {
        return new Builder(awsSecurityCredentials, str, str2, str3, null);
    }

    static class Builder {

        @Nullable
        private Map<String, String> additionalHeaders;
        private final AwsSecurityCredentials awsSecurityCredentials;

        @Nullable
        private AwsDates dates;
        private final String httpMethod;
        private final String region;

        @Nullable
        private String requestPayload;
        private final String url;

        /* synthetic */ Builder(AwsSecurityCredentials awsSecurityCredentials, String str, String str2, String str3, AnonymousClass1 anonymousClass1) {
            this(awsSecurityCredentials, str, str2, str3);
        }

        private Builder(AwsSecurityCredentials awsSecurityCredentials, String str, String str2, String str3) {
            this.awsSecurityCredentials = awsSecurityCredentials;
            this.httpMethod = str;
            this.url = str2;
            this.region = str3;
        }

        Builder setRequestPayload(String str) {
            this.requestPayload = str;
            return this;
        }

        Builder setAdditionalHeaders(Map<String, String> map) {
            if (map.containsKey("date") && map.containsKey("x-amz-date")) {
                throw new IllegalArgumentException("One of {date, x-amz-date} can be specified, not both.");
            }
            try {
                if (map.containsKey("date")) {
                    this.dates = AwsDates.fromDateHeader(map.get("date"));
                }
                if (map.containsKey("x-amz-date")) {
                    this.dates = AwsDates.fromXAmzDate(map.get("x-amz-date"));
                }
                this.additionalHeaders = map;
                return this;
            } catch (ParseException e) {
                throw new IllegalArgumentException("The provided date header value is invalid.", e);
            }
        }

        AwsRequestSigner build() {
            return new AwsRequestSigner(this.awsSecurityCredentials, this.httpMethod, this.url, this.region, this.requestPayload, this.additionalHeaders, this.dates, null);
        }
    }
}

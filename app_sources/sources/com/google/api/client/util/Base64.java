package com.google.api.client.util;

import com.google.common.io.BaseEncoding;

/* INFO: loaded from: classes3.dex */
@Deprecated
public class Base64 {
    private static final BaseEncoding BASE64_DECODER = BaseEncoding.base64().withSeparator("\n", 64);
    private static final BaseEncoding BASE64URL_DECODER = BaseEncoding.base64Url().withSeparator("\n", 64);

    public static byte[] encodeBase64(byte[] bArr) {
        return StringUtils.getBytesUtf8(encodeBase64String(bArr));
    }

    public static String encodeBase64String(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return BaseEncoding.base64().encode(bArr);
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return StringUtils.getBytesUtf8(encodeBase64URLSafeString(bArr));
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return BaseEncoding.base64Url().omitPadding().encode(bArr);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return decodeBase64(StringUtils.newStringUtf8(bArr));
    }

    public static byte[] decodeBase64(String str) {
        if (str == null) {
            return null;
        }
        try {
            return BASE64_DECODER.decode(str);
        } catch (IllegalArgumentException e) {
            if (e.getCause() instanceof BaseEncoding.DecodingException) {
                return BASE64URL_DECODER.decode(str.trim());
            }
            throw e;
        }
    }

    private Base64() {
    }
}

package com.google.api.client.auth.oauth;

import com.google.api.client.util.Base64;
import com.google.api.client.util.StringUtils;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.text.Typography;
import net.lingala.zip4j.util.InternalZipConstants;

/* INFO: loaded from: classes3.dex */
public final class OAuthHmacSigner implements OAuthSigner {
    public String clientSharedSecret;
    public String tokenSharedSecret;

    @Override // com.google.api.client.auth.oauth.OAuthSigner
    public String getSignatureMethod() {
        return "HMAC-SHA1";
    }

    @Override // com.google.api.client.auth.oauth.OAuthSigner
    public String computeSignature(String str) throws GeneralSecurityException {
        StringBuilder sb = new StringBuilder();
        String str2 = this.clientSharedSecret;
        if (str2 != null) {
            sb.append(OAuthParameters.escape(str2));
        }
        sb.append(Typography.amp);
        String str3 = this.tokenSharedSecret;
        if (str3 != null) {
            sb.append(OAuthParameters.escape(str3));
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(StringUtils.getBytesUtf8(sb.toString()), InternalZipConstants.AES_MAC_ALGORITHM);
        Mac mac = Mac.getInstance(InternalZipConstants.AES_MAC_ALGORITHM);
        mac.init(secretKeySpec);
        return Base64.encodeBase64String(mac.doFinal(StringUtils.getBytesUtf8(str)));
    }
}

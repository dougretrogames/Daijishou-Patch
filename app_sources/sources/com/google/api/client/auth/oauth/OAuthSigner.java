package com.google.api.client.auth.oauth;

import java.security.GeneralSecurityException;

/* INFO: loaded from: classes3.dex */
public interface OAuthSigner {
    String computeSignature(String str) throws GeneralSecurityException;

    String getSignatureMethod();
}

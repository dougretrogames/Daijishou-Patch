package com.google.auth.oauth2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultPKCEProvider implements PKCEProvider {
    private static final int MAX_CODE_VERIFIER_LENGTH = 127;
    private CodeChallenge codeChallenge;
    private String codeVerifier;

    private String createCodeVerifier() {
        byte[] bArr = new byte[127];
        new SecureRandom().nextBytes(bArr);
        return Base64.getUrlEncoder().encodeToString(bArr);
    }

    private CodeChallenge createCodeChallenge(String str) {
        return new CodeChallenge(str);
    }

    public DefaultPKCEProvider() {
        String strCreateCodeVerifier = createCodeVerifier();
        this.codeVerifier = strCreateCodeVerifier;
        this.codeChallenge = createCodeChallenge(strCreateCodeVerifier);
    }

    @Override // com.google.auth.oauth2.PKCEProvider
    public String getCodeVerifier() {
        return this.codeVerifier;
    }

    @Override // com.google.auth.oauth2.PKCEProvider
    public String getCodeChallenge() {
        return this.codeChallenge.getCodeChallenge();
    }

    @Override // com.google.auth.oauth2.PKCEProvider
    public String getCodeChallengeMethod() {
        return this.codeChallenge.getCodeChallengeMethod();
    }

    private class CodeChallenge {
        private String codeChallenge;
        private String codeChallengeMethod;

        CodeChallenge(String str) {
            try {
                byte[] bytes = str.getBytes();
                MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
                messageDigest.update(bytes);
                this.codeChallenge = Base64.getUrlEncoder().encodeToString(messageDigest.digest());
                this.codeChallengeMethod = "S256";
            } catch (NoSuchAlgorithmException unused) {
                this.codeChallenge = str;
                this.codeChallengeMethod = "plain";
            }
        }

        public String getCodeChallenge() {
            return this.codeChallenge;
        }

        public String getCodeChallengeMethod() {
            return this.codeChallengeMethod;
        }
    }
}

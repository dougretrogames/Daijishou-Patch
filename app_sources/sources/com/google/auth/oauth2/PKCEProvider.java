package com.google.auth.oauth2;

/* INFO: loaded from: classes3.dex */
public interface PKCEProvider {
    String getCodeChallenge();

    String getCodeChallengeMethod();

    String getCodeVerifier();
}

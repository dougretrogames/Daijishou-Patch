package com.google.auth.oauth2;

import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
final class ActingParty {
    private final String actorToken;
    private final String actorTokenType;

    ActingParty(String str, String str2) {
        this.actorToken = (String) Preconditions.checkNotNull(str);
        this.actorTokenType = (String) Preconditions.checkNotNull(str2);
    }

    String getActorToken() {
        return this.actorToken;
    }

    String getActorTokenType() {
        return this.actorTokenType;
    }
}

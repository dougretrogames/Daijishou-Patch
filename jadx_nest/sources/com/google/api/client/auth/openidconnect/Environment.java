package com.google.api.client.auth.openidconnect;

/* JADX INFO: loaded from: classes3.dex */
class Environment {
    Environment() {
    }

    public String getVariable(String str) {
        return System.getenv(str);
    }
}

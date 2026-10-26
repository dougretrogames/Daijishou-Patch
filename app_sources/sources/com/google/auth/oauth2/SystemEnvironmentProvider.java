package com.google.auth.oauth2;

import java.io.Serializable;

/* INFO: loaded from: classes3.dex */
class SystemEnvironmentProvider implements EnvironmentProvider, Serializable {
    static final SystemEnvironmentProvider INSTANCE = new SystemEnvironmentProvider();
    private static final long serialVersionUID = -4698164985883575244L;

    private SystemEnvironmentProvider() {
    }

    @Override // com.google.auth.oauth2.EnvironmentProvider
    public String getEnv(String str) {
        return System.getenv(str);
    }

    public static SystemEnvironmentProvider getInstance() {
        return INSTANCE;
    }
}

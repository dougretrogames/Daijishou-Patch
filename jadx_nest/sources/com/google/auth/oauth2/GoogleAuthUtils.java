package com.google.auth.oauth2;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class GoogleAuthUtils {
    public static final String getWellKnownCredentialsPath() {
        return getWellKnownCredentialsFile(DefaultCredentialsProvider.DEFAULT).getAbsolutePath();
    }

    static final String getWellKnownCredentialsPath(DefaultCredentialsProvider defaultCredentialsProvider) {
        return getWellKnownCredentialsFile(defaultCredentialsProvider).getAbsolutePath();
    }

    static final File getWellKnownCredentialsFile(DefaultCredentialsProvider defaultCredentialsProvider) {
        File file;
        String env = defaultCredentialsProvider.getEnv("CLOUDSDK_CONFIG");
        if (env != null) {
            file = new File(env);
        } else if (defaultCredentialsProvider.getOsName().indexOf("windows") >= 0) {
            file = new File(new File(defaultCredentialsProvider.getEnv("APPDATA")), "gcloud");
        } else {
            file = new File(new File(defaultCredentialsProvider.getProperty("user.home", ""), ".config"), "gcloud");
        }
        return new File(file, "application_default_credentials.json");
    }
}

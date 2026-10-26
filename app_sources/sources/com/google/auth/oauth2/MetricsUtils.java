package com.google.auth.oauth2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* INFO: loaded from: classes3.dex */
class MetricsUtils {
    static final String API_CLIENT_HEADER = "x-goog-api-client";
    private static final String authLibraryVersion = getAuthLibraryVersion();
    private static final String javaLanguageVersion = System.getProperty("java.version");

    MetricsUtils() {
    }

    static String getLanguageAndAuthLibraryVersions() {
        return String.format("gl-java/%s auth/%s", javaLanguageVersion, authLibraryVersion);
    }

    private static String getAuthLibraryVersion() {
        String property = "unknown-version";
        try {
            InputStream resourceAsStream = MetricsUtils.class.getResourceAsStream("/com/google/auth/oauth2/google-auth-library.properties");
            if (resourceAsStream != null) {
                try {
                    Properties properties = new Properties();
                    properties.load(resourceAsStream);
                    property = properties.getProperty("google-auth-library.version");
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (resourceAsStream != null) {
                            try {
                                resourceAsStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            }
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
        } catch (IOException unused) {
        }
        return property;
    }
}

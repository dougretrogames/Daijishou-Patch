package com.google.api.client.googleapis;

import com.google.api.client.util.SecurityUtils;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* INFO: loaded from: classes3.dex */
public final class GoogleUtils {
    public static final Integer BUGFIX_VERSION;
    public static final Integer MAJOR_VERSION;
    public static final Integer MINOR_VERSION;
    public static final String VERSION;
    static final Pattern VERSION_PATTERN;
    static KeyStore certTrustStore;

    static {
        String version = getVersion();
        VERSION = version;
        Pattern patternCompile = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)(-SNAPSHOT)?");
        VERSION_PATTERN = patternCompile;
        Matcher matcher = patternCompile.matcher(version);
        matcher.find();
        MAJOR_VERSION = Integer.valueOf(Integer.parseInt(matcher.group(1)));
        MINOR_VERSION = Integer.valueOf(Integer.parseInt(matcher.group(2)));
        BUGFIX_VERSION = Integer.valueOf(Integer.parseInt(matcher.group(3)));
    }

    public static synchronized KeyStore getCertificateTrustStore() throws GeneralSecurityException, IOException {
        if (certTrustStore == null) {
            certTrustStore = SecurityUtils.getPkcs12KeyStore();
            SecurityUtils.loadKeyStore(certTrustStore, GoogleUtils.class.getResourceAsStream("google.p12"), "notasecret");
        }
        return certTrustStore;
    }

    private static String getVersion() {
        String property = null;
        try {
            InputStream resourceAsStream = GoogleUtils.class.getResourceAsStream("/com/google/api/client/googleapis/google-api-client.properties");
            if (resourceAsStream != null) {
                try {
                    Properties properties = new Properties();
                    properties.load(resourceAsStream);
                    property = properties.getProperty("google-api-client.version");
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
        return property == null ? "unknown-version" : property;
    }

    private GoogleUtils() {
    }
}

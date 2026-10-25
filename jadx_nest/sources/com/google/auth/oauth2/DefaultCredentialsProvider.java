package com.google.auth.oauth2;

import com.google.auth.http.HttpTransportFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessControlException;
import java.util.Collections;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
class DefaultCredentialsProvider {
    static final String APP_ENGINE_SIGNAL_CLASS = "com.google.appengine.api.utils.SystemProperty";
    static final String CLOUDSDK_CLIENT_ID = "764086051850-6qr4p6gpi6hn506pt8ejuq83di341hur.apps.googleusercontent.com";
    static final String CLOUDSDK_CONFIG_DIRECTORY = "gcloud";
    static final String CLOUDSDK_CREDENTIALS_WARNING = "You are authenticating using user credentials. For production, we recommend using service account credentials.\n\nTo learn more about service account credentials, see http://cloud.google.com/docs/authentication/external/set-up-adc-on-cloud";
    static final String CLOUDSDK_MISSING_CREDENTIALS = "Your default credentials were not found. To set up Application Default Credentials for your environment, see https://cloud.google.com/docs/authentication/external/set-up-adc.";
    static final String CLOUD_SHELL_ENV_VAR = "DEVSHELL_CLIENT_PORT";
    static final String CREDENTIAL_ENV_VAR = "GOOGLE_APPLICATION_CREDENTIALS";
    static final String GCE_METADATA_HOST_ENV_VAR = "GCE_METADATA_HOST";
    static final String NO_GCE_CHECK_ENV_VAR = "NO_GCE_CHECK";
    static final String QUOTA_PROJECT_ENV_VAR = "GOOGLE_CLOUD_QUOTA_PROJECT";
    static final String SKIP_APP_ENGINE_ENV_VAR = "GOOGLE_APPLICATION_CREDENTIALS_SKIP_APP_ENGINE";
    public static final String SUPPRESS_GCLOUD_CREDS_WARNING_ENV_VAR = "SUPPRESS_GCLOUD_CREDS_WARNING";
    static final String WELL_KNOWN_CREDENTIALS_FILE = "application_default_credentials.json";
    private GoogleCredentials cachedCredentials = null;
    private boolean checkedAppEngine = false;
    private boolean checkedComputeEngine = false;
    static final DefaultCredentialsProvider DEFAULT = new DefaultCredentialsProvider();
    static final String SPECIFICATION_VERSION = System.getProperty("java.specification.version");
    static final String GAE_RUNTIME_VERSION = System.getProperty("com.google.appengine.runtime.version");
    static final String RUNTIME_JETTY_LOGGER = System.getProperty("org.eclipse.jetty.util.log.class");
    static final Logger LOGGER = Logger.getLogger(DefaultCredentialsProvider.class.getName());

    DefaultCredentialsProvider() {
    }

    final GoogleCredentials getDefaultCredentials(HttpTransportFactory httpTransportFactory) throws IOException {
        synchronized (this) {
            if (this.cachedCredentials == null) {
                this.cachedCredentials = getDefaultCredentialsUnsynchronized(httpTransportFactory);
            }
            GoogleCredentials googleCredentials = this.cachedCredentials;
            if (googleCredentials != null) {
                return googleCredentials;
            }
            throw new IOException(CLOUDSDK_MISSING_CREDENTIALS);
        }
    }

    private final GoogleCredentials getDefaultCredentialsUnsynchronized(HttpTransportFactory httpTransportFactory) throws Throwable {
        GoogleCredentials googleCredentialsTryGetComputeCredentials;
        String env;
        InputStream stream;
        String env2 = getEnv(CREDENTIAL_ENV_VAR);
        InputStream stream2 = null;
        if (env2 == null || env2.length() <= 0) {
            googleCredentialsTryGetComputeCredentials = null;
        } else {
            LOGGER.log(Level.FINE, String.format("Attempting to load credentials from file: %s", env2));
            try {
                try {
                    File file = new File(env2);
                    if (!isFile(file)) {
                        throw new IOException("File does not exist.");
                    }
                    stream = readStream(file);
                    try {
                        googleCredentialsTryGetComputeCredentials = GoogleCredentials.fromStream(stream, httpTransportFactory);
                        if (stream != null) {
                            stream.close();
                        }
                    } catch (IOException e) {
                        e = e;
                        throw new IOException(String.format("Error reading credential file from environment variable %s, value '%s': %s", CREDENTIAL_ENV_VAR, env2, e.getMessage()), e);
                    } catch (AccessControlException unused) {
                        if (stream != null) {
                            stream.close();
                        }
                        googleCredentialsTryGetComputeCredentials = null;
                    } catch (Throwable th) {
                        th = th;
                        stream2 = stream;
                        if (stream2 != null) {
                            stream2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e2) {
                e = e2;
            } catch (AccessControlException unused2) {
                stream = null;
            }
        }
        if (googleCredentialsTryGetComputeCredentials == null) {
            File wellKnownCredentialsFile = getWellKnownCredentialsFile();
            try {
                try {
                    if (isFile(wellKnownCredentialsFile)) {
                        LOGGER.log(Level.FINE, String.format("Attempting to load credentials from well known file: %s", wellKnownCredentialsFile.getCanonicalPath()));
                        stream2 = readStream(wellKnownCredentialsFile);
                        googleCredentialsTryGetComputeCredentials = GoogleCredentials.fromStream(stream2, httpTransportFactory);
                    }
                    if (stream2 != null) {
                        stream2.close();
                    }
                } catch (IOException e3) {
                    throw new IOException(String.format("Error reading credential file from location %s: %s", wellKnownCredentialsFile, e3.getMessage()));
                } catch (AccessControlException unused3) {
                    if (stream2 != null) {
                    }
                    warnAboutProblematicCredentials(googleCredentialsTryGetComputeCredentials);
                }
                warnAboutProblematicCredentials(googleCredentialsTryGetComputeCredentials);
            } catch (Throwable th3) {
                if (stream2 != null) {
                    stream2.close();
                }
                throw th3;
            }
        }
        if (googleCredentialsTryGetComputeCredentials == null && isOnGAEStandard7() && !skipAppEngineCredentialsCheck()) {
            LOGGER.log(Level.FINE, "Attempting to load credentials from GAE 7 Standard");
            googleCredentialsTryGetComputeCredentials = tryGetAppEngineCredential();
        }
        if (googleCredentialsTryGetComputeCredentials == null) {
            LOGGER.log(Level.FINE, "Attempting to load credentials from Cloud Shell");
            googleCredentialsTryGetComputeCredentials = tryGetCloudShellCredentials();
        }
        if (googleCredentialsTryGetComputeCredentials == null) {
            LOGGER.log(Level.FINE, "Attempting to load credentials from GCE");
            googleCredentialsTryGetComputeCredentials = tryGetComputeCredentials(httpTransportFactory);
        }
        return (googleCredentialsTryGetComputeCredentials == null || (env = getEnv(QUOTA_PROJECT_ENV_VAR)) == null || env.trim().length() <= 0) ? googleCredentialsTryGetComputeCredentials : googleCredentialsTryGetComputeCredentials.createWithQuotaProject(env);
    }

    private final File getWellKnownCredentialsFile() {
        return GoogleAuthUtils.getWellKnownCredentialsFile(this);
    }

    private void warnAboutProblematicCredentials(GoogleCredentials googleCredentials) {
        if ((googleCredentials instanceof UserCredentials) && !Boolean.parseBoolean(getEnv(SUPPRESS_GCLOUD_CREDS_WARNING_ENV_VAR)) && ComputeEngineCredentials.checkStaticGceDetection(this)) {
            LOGGER.log(Level.WARNING, CLOUDSDK_CREDENTIALS_WARNING);
        }
    }

    private boolean runningOnAppEngine() {
        try {
            try {
                Field field = forName(APP_ENGINE_SIGNAL_CLASS).getField("environment");
                return field.getType().getMethod("value", new Class[0]).invoke(field.get(null), new Object[0]) != null;
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                throw new RuntimeException(String.format("Unexpected error trying to determine if runnning on Google App Engine: %s", e.getMessage()), e);
            }
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private GoogleCredentials tryGetCloudShellCredentials() {
        String env = getEnv(CLOUD_SHELL_ENV_VAR);
        if (env != null) {
            return CloudShellCredentials.create(Integer.parseInt(env));
        }
        return null;
    }

    private GoogleCredentials tryGetAppEngineCredential() throws IOException {
        if (this.checkedAppEngine) {
            return null;
        }
        boolean zRunningOnAppEngine = runningOnAppEngine();
        this.checkedAppEngine = true;
        if (zRunningOnAppEngine) {
            return new AppEngineCredentials(Collections.emptyList(), Collections.emptyList());
        }
        return null;
    }

    private final GoogleCredentials tryGetComputeCredentials(HttpTransportFactory httpTransportFactory) {
        if (this.checkedComputeEngine) {
            return null;
        }
        boolean zIsOnGce = ComputeEngineCredentials.isOnGce(httpTransportFactory, this);
        this.checkedComputeEngine = true;
        if (zIsOnGce) {
            return ComputeEngineCredentials.newBuilder().setHttpTransportFactory(httpTransportFactory).build();
        }
        return null;
    }

    private boolean skipAppEngineCredentialsCheck() {
        String env = getEnv(SKIP_APP_ENGINE_ENV_VAR);
        if (env != null) {
            return env.equalsIgnoreCase("true") || env.equals("1");
        }
        return false;
    }

    protected boolean isOnGAEStandard7() {
        if (GAE_RUNTIME_VERSION != null) {
            return SPECIFICATION_VERSION.equals("1.7") || RUNTIME_JETTY_LOGGER == null;
        }
        return false;
    }

    String getOsName() {
        return getProperty("os.name", "").toLowerCase(Locale.US);
    }

    Class<?> forName(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    String getEnv(String str) {
        return System.getenv(str);
    }

    String getProperty(String str, String str2) {
        return System.getProperty(str, str2);
    }

    boolean isFile(File file) {
        return file.isFile();
    }

    InputStream readStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }
}

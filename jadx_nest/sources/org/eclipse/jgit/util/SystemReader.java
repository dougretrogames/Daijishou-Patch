package org.eclipse.jgit.util;

import androidx.compose.runtime.CompositionImpl$$ExternalSyntheticBackportWithForwarding0;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectChecker;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.storage.file.FileBasedConfig;
import org.eclipse.jgit.storage.file.UserConfigFile;
import org.eclipse.jgit.util.time.MonotonicClock;
import org.eclipse.jgit.util.time.MonotonicSystemClock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SystemReader {
    private static final SystemReader DEFAULT;
    private static final String GIT_TRACE_PERFORMANCE = "GIT_TRACE_PERFORMANCE";
    private static volatile SystemReader INSTANCE;
    private static volatile Boolean isLinux;
    private static volatile Boolean isMacOS;
    private static volatile Boolean isWindows;
    private volatile Charset defaultCharset;
    private ObjectChecker platformChecker;
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) SystemReader.class);
    private static final boolean performanceTrace = initPerformanceTrace();
    private AtomicReference<FileBasedConfig> systemConfig = new AtomicReference<>();
    private AtomicReference<FileBasedConfig> userConfig = new AtomicReference<>();
    private AtomicReference<FileBasedConfig> jgitConfig = new AtomicReference<>();

    @Deprecated
    public abstract long getCurrentTime();

    public abstract String getHostname();

    public abstract String getProperty(String str);

    @Deprecated
    public abstract int getTimezone(long j);

    public abstract String getenv(String str);

    public abstract FileBasedConfig openJGitConfig(Config config, FS fs);

    public abstract FileBasedConfig openSystemConfig(Config config, FS fs);

    public abstract FileBasedConfig openUserConfig(Config config, FS fs);

    static {
        Default r0 = new Default(null);
        r0.init();
        DEFAULT = r0;
        INSTANCE = r0;
    }

    private static boolean initPerformanceTrace() {
        String str = System.getenv(GIT_TRACE_PERFORMANCE);
        if (str == null) {
            str = System.getenv(GIT_TRACE_PERFORMANCE);
        }
        if (str != null) {
            return Boolean.valueOf(str).booleanValue();
        }
        return false;
    }

    private static class Default extends SystemReader {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile String hostname;

        /* synthetic */ Default(SystemReaderIA systemReaderIA) {
            this();
        }

        private Default() {
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public String getenv(String str) {
            return System.getenv(str);
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public String getProperty(String str) {
            return System.getProperty(str);
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public FileBasedConfig openSystemConfig(Config config, FS fs) {
            File gitSystemConfig;
            if (StringUtils.isEmptyOrNull(getenv(Constants.GIT_CONFIG_NOSYSTEM_KEY)) && (gitSystemConfig = fs.getGitSystemConfig()) != null) {
                return new FileBasedConfig(config, gitSystemConfig, fs);
            }
            return new AnonymousClass1(config, null, fs);
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.util.SystemReader$Default$1, reason: invalid class name */
        class AnonymousClass1 extends FileBasedConfig {
            @Override // org.eclipse.jgit.storage.file.FileBasedConfig
            public boolean isOutdated() {
                return false;
            }

            @Override // org.eclipse.jgit.storage.file.FileBasedConfig, org.eclipse.jgit.lib.StoredConfig
            public void load() {
            }

            AnonymousClass1(Config config, File file, FS fs) {
                super(config, file, fs);
            }
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public FileBasedConfig openUserConfig(Config config, FS fs) {
            File file = new File(fs.userHome(), ".gitconfig");
            Path xdgConfigDirectory = getXdgConfigDirectory(fs);
            if (xdgConfigDirectory != null) {
                return new UserConfigFile(config, file, xdgConfigDirectory.resolve("git").resolve("config").toFile(), fs);
            }
            return new FileBasedConfig(config, file, fs);
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public FileBasedConfig openJGitConfig(Config config, FS fs) {
            Path xdgConfigDirectory = getXdgConfigDirectory(fs);
            if (xdgConfigDirectory != null) {
                return new FileBasedConfig(config, xdgConfigDirectory.resolve("jgit").resolve("config").toFile(), fs);
            }
            return new FileBasedConfig(config, new File(fs.userHome(), ".jgitconfig"), fs);
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public String getHostname() {
            if (this.hostname == null) {
                try {
                    this.hostname = InetAddress.getLocalHost().getCanonicalHostName();
                } catch (UnknownHostException unused) {
                    this.hostname = "localhost";
                }
            }
            return this.hostname;
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public long getCurrentTime() {
            return System.currentTimeMillis();
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public Instant now() {
            return Instant.now();
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public int getTimezone(long j) {
            return getTimeZone().getOffset(j) / 60000;
        }
    }

    public static class Delegate extends SystemReader {
        private final SystemReader delegate;

        public Delegate(SystemReader systemReader) {
            this.delegate = systemReader;
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public String getHostname() {
            return this.delegate.getHostname();
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public String getenv(String str) {
            return this.delegate.getenv(str);
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public String getProperty(String str) {
            return this.delegate.getProperty(str);
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public FileBasedConfig openUserConfig(Config config, FS fs) {
            return this.delegate.openUserConfig(config, fs);
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public FileBasedConfig openSystemConfig(Config config, FS fs) {
            return this.delegate.openSystemConfig(config, fs);
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public FileBasedConfig openJGitConfig(Config config, FS fs) {
            return this.delegate.openJGitConfig(config, fs);
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public long getCurrentTime() {
            return this.delegate.getCurrentTime();
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public Instant now() {
            return this.delegate.now();
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public int getTimezone(long j) {
            return this.delegate.getTimezone(j);
        }

        @Override // org.eclipse.jgit.util.SystemReader
        public ZoneOffset getTimeZoneAt(Instant instant) {
            return this.delegate.getTimeZoneAt(instant);
        }
    }

    public static SystemReader getInstance() {
        return INSTANCE;
    }

    public static void setInstance(SystemReader systemReader) {
        isMacOS = null;
        isWindows = null;
        isLinux = null;
        if (systemReader == null) {
            INSTANCE = DEFAULT;
        } else {
            systemReader.init();
            INSTANCE = systemReader;
        }
    }

    private void init() {
        if (this.platformChecker == null) {
            setPlatformChecker();
        }
    }

    protected final void setPlatformChecker() {
        this.platformChecker = new ObjectChecker().setSafeForWindows(isWindows()).setSafeForMacOS(isMacOS());
    }

    public StoredConfig getUserConfig() throws ConfigInvalidException, IOException {
        FileBasedConfig fileBasedConfig = this.userConfig.get();
        if (fileBasedConfig == null) {
            CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.userConfig, null, openUserConfig(getSystemConfig(), FS.DETECTED));
            fileBasedConfig = this.userConfig.get();
        }
        updateAll(fileBasedConfig);
        return fileBasedConfig;
    }

    public StoredConfig getJGitConfig() throws ConfigInvalidException, IOException {
        FileBasedConfig fileBasedConfig = this.jgitConfig.get();
        if (fileBasedConfig == null) {
            CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.jgitConfig, null, openJGitConfig(null, FS.DETECTED));
            fileBasedConfig = this.jgitConfig.get();
        }
        updateAll(fileBasedConfig);
        return fileBasedConfig;
    }

    public StoredConfig getSystemConfig() throws ConfigInvalidException, IOException {
        FileBasedConfig fileBasedConfig = this.systemConfig.get();
        if (fileBasedConfig == null) {
            CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.systemConfig, null, openSystemConfig(getJGitConfig(), FS.DETECTED));
            fileBasedConfig = this.systemConfig.get();
        }
        updateAll(fileBasedConfig);
        return fileBasedConfig;
    }

    public Path getXdgConfigDirectory(FS fs) {
        String absolutePath = getenv(Constants.XDG_CONFIG_HOME);
        if (StringUtils.isEmptyOrNull(absolutePath)) {
            File fileUserHome = fs.userHome();
            if (fileUserHome == null) {
                return null;
            }
            absolutePath = new File(fileUserHome, ".config").getAbsolutePath();
        }
        try {
            return java.nio.file.Paths.get(absolutePath, new String[0]);
        } catch (InvalidPathException e) {
            LOG.error(JGitText.get().logXDGConfigHomeInvalid, absolutePath, e);
            return null;
        }
    }

    private void updateAll(Config config) throws ConfigInvalidException, IOException {
        if (config == null) {
            return;
        }
        updateAll(config.getBaseConfig());
        if (config instanceof FileBasedConfig) {
            FileBasedConfig fileBasedConfig = (FileBasedConfig) config;
            if (fileBasedConfig.isOutdated()) {
                LOG.debug("loading config {}", fileBasedConfig);
                fileBasedConfig.load();
            }
        }
    }

    public Instant now() {
        return Instant.ofEpochMilli(getCurrentTime());
    }

    public LocalDateTime civilNow() {
        return LocalDateTime.ofInstant(now(), getTimeZoneId());
    }

    public MonotonicClock getClock() {
        return new MonotonicSystemClock();
    }

    public ZoneOffset getTimeZoneAt(Instant instant) {
        return getTimeZoneId().getRules().getOffset(instant);
    }

    @Deprecated
    public TimeZone getTimeZone() {
        return TimeZone.getDefault();
    }

    public ZoneId getTimeZoneId() {
        return ZoneId.systemDefault();
    }

    public Locale getLocale() {
        return Locale.getDefault();
    }

    public Charset getDefaultCharset() {
        Charset charsetDefaultCharset = this.defaultCharset;
        if (charsetDefaultCharset == null) {
            String property = getProperty("native.encoding");
            try {
                if (!StringUtils.isEmptyOrNull(property)) {
                    charsetDefaultCharset = Charset.forName(property);
                }
            } catch (IllegalCharsetNameException | UnsupportedCharsetException unused) {
                LOG.error(JGitText.get().logInvalidDefaultCharset, property);
            }
            if (charsetDefaultCharset == null) {
                charsetDefaultCharset = Charset.defaultCharset();
            }
            this.defaultCharset = charsetDefaultCharset;
        }
        return charsetDefaultCharset;
    }

    public SimpleDateFormat getSimpleDateFormat(String str) {
        return new SimpleDateFormat(str);
    }

    public SimpleDateFormat getSimpleDateFormat(String str, Locale locale) {
        return new SimpleDateFormat(str, locale);
    }

    public DateFormat getDateTimeInstance(int i, int i2) {
        return DateFormat.getDateTimeInstance(i, i2);
    }

    public boolean isWindows() {
        if (isWindows == null) {
            isWindows = Boolean.valueOf(getOsName().startsWith("Windows"));
        }
        return isWindows.booleanValue();
    }

    public boolean isMacOS() {
        if (isMacOS == null) {
            String osName = getOsName();
            isMacOS = Boolean.valueOf("Mac OS X".equals(osName) || "Darwin".equals(osName));
        }
        return isMacOS.booleanValue();
    }

    public boolean isLinux() {
        if (isLinux == null) {
            isLinux = Boolean.valueOf(getOsName().toLowerCase().startsWith("linux"));
        }
        return isLinux.booleanValue();
    }

    public boolean isPerformanceTraceEnabled() {
        return performanceTrace;
    }

    private String getOsName() {
        return getProperty("os.name");
    }

    public void checkPath(String str) throws CorruptObjectException {
        this.platformChecker.checkPath(str);
    }

    public void checkPath(byte[] bArr) throws CorruptObjectException {
        this.platformChecker.checkPath(bArr, 0, bArr.length);
    }
}

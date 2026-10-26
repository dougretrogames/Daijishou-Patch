package com.google.gradle.osdetector;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.inject.Inject;
import kr.motd.maven.os.Detector;
import kr.motd.maven.os.FileOperationProvider;
import kr.motd.maven.os.SystemPropertyOperationProvider;
import org.gradle.api.Project;
import org.gradle.api.file.ProjectLayout;
import org.gradle.api.provider.Provider;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.util.GradleVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes4.dex */
public abstract class OsDetector {
    private static final Logger logger = LoggerFactory.getLogger(OsDetector.class.getName());
    private final List<String> classifierWithLikes = new ArrayList();
    private Impl impl;
    private final Project project;

    @Inject
    public abstract ProjectLayout getProjectLayout();

    @Inject
    public abstract ProviderFactory getProviderFactory();

    public OsDetector(Project project) {
        this.project = project;
    }

    public String getOs() {
        return (String) getImpl().detectedProperties.get(Detector.DETECTED_NAME);
    }

    public String getArch() {
        return (String) getImpl().detectedProperties.get(Detector.DETECTED_ARCH);
    }

    public String getClassifier() {
        return (String) getImpl().detectedProperties.get(Detector.DETECTED_CLASSIFIER);
    }

    public Release getRelease() {
        Impl impl = getImpl();
        if (impl.detectedProperties.get(Detector.DETECTED_RELEASE) == null) {
            return null;
        }
        return new Release(impl, null);
    }

    public synchronized void setClassifierWithLikes(List<String> list) {
        if (this.impl != null) {
            throw new IllegalStateException("classifierWithLikes must be set before osdetector is read.");
        }
        this.classifierWithLikes.clear();
        this.classifierWithLikes.addAll(list);
    }

    private synchronized Impl getImpl() {
        if (this.impl == null) {
            if (GradleVersion.current().compareTo(GradleVersion.version("6.5")) >= 0) {
                this.impl = new Impl(this.classifierWithLikes, new ConfigurationTimeSafeSystemPropertyOperations(this, null), new ConfigurationTimeSafeFileOperations(this, null));
            } else {
                this.impl = new Impl(this.classifierWithLikes);
            }
        }
        return this.impl;
    }

    public static class Release {
        private final Impl impl;

        /* synthetic */ Release(Impl impl, AnonymousClass1 anonymousClass1) {
            this(impl);
        }

        private Release(Impl impl) {
            this.impl = impl;
        }

        public String getId() {
            return (String) this.impl.detectedProperties.get(Detector.DETECTED_RELEASE);
        }

        public String getVersion() {
            return (String) this.impl.detectedProperties.get(Detector.DETECTED_RELEASE_VERSION);
        }

        public boolean isLike(String str) {
            return this.impl.detectedProperties.containsKey(Detector.DETECTED_RELEASE_LIKE_PREFIX + str);
        }
    }

    private static class Impl extends Detector {
        final Properties detectedProperties;

        Impl(List<String> list, SystemPropertyOperationProvider systemPropertyOperationProvider, FileOperationProvider fileOperationProvider) {
            super(systemPropertyOperationProvider, fileOperationProvider);
            Properties properties = new Properties();
            this.detectedProperties = properties;
            detect(properties, list);
        }

        Impl(List<String> list) {
            Properties properties = new Properties();
            this.detectedProperties = properties;
            detect(properties, list);
        }

        @Override // kr.motd.maven.os.Detector
        protected void log(String str) {
            OsDetector.logger.info(str);
        }

        @Override // kr.motd.maven.os.Detector
        protected void logProperty(String str, String str2) {
            OsDetector.logger.info(str + "=" + str2);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static <T> Provider<T> forUseAtConfigurationTime(Provider<T> provider) {
        return GradleVersion.current().compareTo(GradleVersion.version("7.4")) < 0 ? provider.forUseAtConfigurationTime() : provider;
    }

    private final class ConfigurationTimeSafeSystemPropertyOperations implements SystemPropertyOperationProvider {
        @Override // kr.motd.maven.os.SystemPropertyOperationProvider
        public String setSystemProperty(String str, String str2) {
            return null;
        }

        private ConfigurationTimeSafeSystemPropertyOperations() {
        }

        /* synthetic */ ConfigurationTimeSafeSystemPropertyOperations(OsDetector osDetector, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // kr.motd.maven.os.SystemPropertyOperationProvider
        public String getSystemProperty(String str) {
            return (String) OsDetector.forUseAtConfigurationTime(OsDetector.this.getProviderFactory().systemProperty(str)).getOrNull();
        }

        @Override // kr.motd.maven.os.SystemPropertyOperationProvider
        public String getSystemProperty(String str, String str2) {
            return (String) OsDetector.forUseAtConfigurationTime(OsDetector.this.getProviderFactory().systemProperty(str)).getOrElse(str2);
        }
    }

    private final class ConfigurationTimeSafeFileOperations implements FileOperationProvider {
        private ConfigurationTimeSafeFileOperations() {
        }

        /* synthetic */ ConfigurationTimeSafeFileOperations(OsDetector osDetector, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // kr.motd.maven.os.FileOperationProvider
        public InputStream readFile(String str) throws IOException {
            byte[] bArr = (byte[]) OsDetector.forUseAtConfigurationTime(OsDetector.this.getProviderFactory().fileContents(OsDetector.this.getProjectLayout().getProjectDirectory().file(str)).getAsBytes()).getOrNull();
            if (bArr == null) {
                throw new FileNotFoundException(str + " not exist");
            }
            return new ByteArrayInputStream(bArr);
        }
    }
}

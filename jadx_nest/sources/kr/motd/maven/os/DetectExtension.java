package kr.motd.maven.os;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.MavenExecutionException;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Build;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.DependencyManagement;
import org.apache.maven.model.Exclusion;
import org.apache.maven.model.Model;
import org.apache.maven.model.ModelBase;
import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.logging.Logger;
import org.codehaus.plexus.util.InterpolationFilterReader;

/* INFO: loaded from: classes5.dex */
@Component(hint = "detect-os", role = AbstractMavenLifecycleParticipant.class)
public class DetectExtension extends AbstractMavenLifecycleParticipant {
    private final Detector detector;
    private final Logger logger;

    @Inject
    public DetectExtension(Logger logger) {
        this.logger = logger;
        this.detector = new AnonymousClass1(logger);
    }

    /* INFO: renamed from: kr.motd.maven.os.DetectExtension$1, reason: invalid class name */
    class AnonymousClass1 extends Detector {
        final /* synthetic */ Logger val$logger;

        AnonymousClass1(Logger logger) {
            this.val$logger = logger;
        }

        @Override // kr.motd.maven.os.Detector
        protected void log(String str) {
            this.val$logger.info(str);
        }

        @Override // kr.motd.maven.os.Detector
        protected void logProperty(String str, String str2) {
            if (this.val$logger.isInfoEnabled()) {
                this.val$logger.info(str + ": " + str2);
            }
        }
    }

    /* INFO: Thrown type has an unknown type hierarchy: org.apache.maven.MavenExecutionException */
    public void afterProjectsRead(MavenSession mavenSession) throws MavenExecutionException {
        Properties properties = new Properties();
        properties.putAll(mavenSession.getSystemProperties());
        properties.putAll(mavenSession.getUserProperties());
        try {
            this.detector.detect(properties, getClassifierWithLikes(mavenSession));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(Detector.DETECTED_NAME, properties.getProperty(Detector.DETECTED_NAME));
            linkedHashMap.put(Detector.DETECTED_ARCH, properties.getProperty(Detector.DETECTED_ARCH));
            linkedHashMap.put(Detector.DETECTED_BITNESS, properties.getProperty(Detector.DETECTED_BITNESS));
            linkedHashMap.put(Detector.DETECTED_CLASSIFIER, properties.getProperty(Detector.DETECTED_CLASSIFIER));
            for (Map.Entry entry : properties.entrySet()) {
                if (entry.getKey().toString().startsWith(Detector.DETECTED_RELEASE)) {
                    linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
                }
            }
            injectSession(mavenSession, linkedHashMap);
            Iterator it = mavenSession.getProjects().iterator();
            while (it.hasNext()) {
                interpolate(linkedHashMap, (MavenProject) it.next());
            }
        } catch (DetectionException e) {
            throw new MavenExecutionException(e.getMessage(), mavenSession.getCurrentProject().getFile());
        }
    }

    private static List<String> getClassifierWithLikes(MavenSession mavenSession) {
        Properties properties = new Properties();
        properties.putAll(mavenSession.getUserProperties());
        properties.putAll(mavenSession.getCurrentProject().getProperties());
        return DetectMojo.getClassifierWithLikes(properties.getProperty("os.detection.classifierWithLikes"));
    }

    private void injectSession(MavenSession mavenSession, Map<String, String> map) {
        Properties systemProperties = mavenSession.getSystemProperties();
        systemProperties.setProperty(Detector.DETECTED_NAME, String.valueOf(map.get(Detector.DETECTED_NAME)));
        systemProperties.setProperty(Detector.DETECTED_ARCH, String.valueOf(map.get(Detector.DETECTED_ARCH)));
        systemProperties.setProperty(Detector.DETECTED_CLASSIFIER, String.valueOf(map.get(Detector.DETECTED_CLASSIFIER)));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().startsWith(Detector.DETECTED_RELEASE)) {
                systemProperties.setProperty(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        for (StackTraceElement stackTraceElement : new Exception().getStackTrace()) {
            if (String.valueOf(stackTraceElement.getClassName()).startsWith("org.jetbrains.idea.maven")) {
                return;
            }
        }
        RepositorySessionInjector.injectRepositorySession(this.logger, mavenSession, map);
    }

    private static void interpolate(Map<String, String> map, MavenProject mavenProject) {
        if (mavenProject == null) {
            return;
        }
        interpolate(map, mavenProject.getParent());
        interpolate(map, (ModelBase) mavenProject.getModel());
        Iterator it = mavenProject.getActiveProfiles().iterator();
        while (it.hasNext()) {
            interpolate(map, (ModelBase) it.next());
        }
    }

    private static void interpolate(Map<String, String> map, ModelBase modelBase) {
        Build build;
        Properties properties = modelBase.getProperties();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            properties.setProperty(entry.getKey(), String.valueOf(entry.getValue()));
        }
        interpolate(map, modelBase.getDependencies());
        DependencyManagement dependencyManagement = modelBase.getDependencyManagement();
        if (dependencyManagement != null) {
            interpolate(map, dependencyManagement.getDependencies());
        }
        if (!(modelBase instanceof Model) || (build = ((Model) modelBase).getBuild()) == null) {
            return;
        }
        Iterator it = build.getPlugins().iterator();
        while (it.hasNext()) {
            interpolate(map, ((Plugin) it.next()).getDependencies());
        }
        if (build.getPluginManagement() != null) {
            Iterator it2 = build.getPluginManagement().getPlugins().iterator();
            while (it2.hasNext()) {
                interpolate(map, ((Plugin) it2.next()).getDependencies());
            }
        }
    }

    private static void interpolate(Map<String, String> map, Iterable<Dependency> iterable) {
        if (iterable == null) {
            return;
        }
        for (Dependency dependency : iterable) {
            dependency.setGroupId(interpolate(map, dependency.getGroupId()));
            dependency.setArtifactId(interpolate(map, dependency.getArtifactId()));
            dependency.setVersion(interpolate(map, dependency.getVersion()));
            dependency.setClassifier(interpolate(map, dependency.getClassifier()));
            dependency.setSystemPath(interpolate(map, dependency.getSystemPath()));
            for (Exclusion exclusion : dependency.getExclusions()) {
                exclusion.setGroupId(interpolate(map, exclusion.getGroupId()));
                exclusion.setArtifactId(interpolate(map, exclusion.getArtifactId()));
            }
        }
    }

    @Nullable
    private static String interpolate(Map<String, String> map, String str) {
        if (str == null) {
            return null;
        }
        while (str.contains("${")) {
            InterpolationFilterReader interpolationFilterReader = new InterpolationFilterReader(new StringReader(str), map);
            StringWriter stringWriter = new StringWriter(str.length());
            while (true) {
                try {
                    int i = interpolationFilterReader.read();
                    if (i == -1) {
                        break;
                    }
                    stringWriter.write(i);
                } catch (IOException e) {
                    throw ((Error) new Error().initCause(e));
                }
            }
            String string = stringWriter.toString();
            if (str.equals(string)) {
                break;
            }
            str = string;
        }
        return str;
    }
}

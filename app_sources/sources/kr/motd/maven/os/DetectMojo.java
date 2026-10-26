package kr.motd.maven.os;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;

/* INFO: loaded from: classes5.dex */
public class DetectMojo extends AbstractMojo {
    static final String CLASSIFIER_WITH_LIKES_PROPERTY = "os.detection.classifierWithLikes";
    private String classifierWithLikes;
    private final Detector detector = new AnonymousClass1();
    private MavenProject project;

    /* INFO: renamed from: kr.motd.maven.os.DetectMojo$1, reason: invalid class name */
    class AnonymousClass1 extends Detector {
        AnonymousClass1() {
        }

        @Override // kr.motd.maven.os.Detector
        protected void log(String str) {
            DetectMojo.this.getLog().info(str);
        }

        @Override // kr.motd.maven.os.Detector
        protected void logProperty(String str, String str2) {
            Log log = DetectMojo.this.getLog();
            if (log.isInfoEnabled()) {
                log.info(str + ": " + str2);
            }
        }
    }

    /* INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoExecutionException */
    public void execute() throws MojoExecutionException {
        try {
            this.detector.detect(this.project.getProperties(), getClassifierWithLikes(this.classifierWithLikes));
        } catch (DetectionException e) {
            throw new MojoExecutionException(e.getMessage());
        }
    }

    public static List<String> getClassifierWithLikes(@Nullable String str) {
        if (str == null) {
            return Collections.emptyList();
        }
        String[] strArrSplit = str.split(CollectionUtils.COMMA);
        ArrayList arrayList = new ArrayList(strArrSplit.length);
        for (String str2 : strArrSplit) {
            String strTrim = str2.trim();
            if (!strTrim.isEmpty()) {
                arrayList.add(strTrim);
            }
        }
        return arrayList;
    }
}

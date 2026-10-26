package kr.motd.maven.os;

import java.util.Collections;
import java.util.Properties;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IStartup;

/* INFO: loaded from: classes5.dex */
public class EclipseStartup extends Detector implements IStartup {
    private static final String ID = EclipseStartup.class.getPackage().getName();
    private ILog logger;

    public void earlyStartup() {
        this.logger = Platform.getLog(Platform.getBundle(ID));
        detect(new Properties(), Collections.emptyList());
    }

    @Override // kr.motd.maven.os.Detector
    protected void log(String str) {
        this.logger.log(new Status(1, ID, str));
    }

    @Override // kr.motd.maven.os.Detector
    protected void logProperty(String str, String str2) {
        this.logger.log(new Status(1, ID, str + ": " + str2));
    }
}

package kr.motd.maven.os;

import java.lang.reflect.Field;
import java.util.Map;
import org.apache.maven.execution.MavenSession;
import org.codehaus.plexus.logging.Logger;
import org.eclipse.aether.RepositorySystemSession;

/* INFO: loaded from: classes5.dex */
final class RepositorySessionInjector {
    static void injectRepositorySession(Logger logger, MavenSession mavenSession, Map<String, String> map) {
        try {
            RepositorySystemSession repositorySession = mavenSession.getRepositorySession();
            Class<?> cls = repositorySession.getClass();
            Map map2 = (Map) cls.getDeclaredMethod("getSystemProperties", new Class[0]).invoke(repositorySession, new Object[0]);
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    map2.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
                Field declaredField = cls.getDeclaredField("systemProperties");
                declaredField.setAccessible(true);
                Map map3 = (Map) declaredField.get(repositorySession);
                for (Map.Entry<String, String> entry2 : map.entrySet()) {
                    map3.put(entry2.getKey(), entry2.getValue());
                }
            }
        } catch (Throwable th) {
            logger.warn("Failed to inject repository session properties.", th);
        }
    }

    private RepositorySessionInjector() {
    }
}

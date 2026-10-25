package org.eclipse.jgit.transport;

import java.util.Iterator;
import java.util.ServiceLoader;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.SystemReader;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SshSessionFactory {
    public abstract RemoteSession getSession(URIish uRIish, CredentialsProvider credentialsProvider, FS fs, int i) throws TransportException;

    public abstract String getType();

    private static class DefaultFactory {
        private static volatile SshSessionFactory INSTANCE = loadSshSessionFactory();

        private static SshSessionFactory loadSshSessionFactory() {
            Iterator it = ServiceLoader.load(SshSessionFactory.class).iterator();
            if (it.hasNext()) {
                return (SshSessionFactory) it.next();
            }
            return null;
        }

        private DefaultFactory() {
        }

        public static SshSessionFactory getInstance() {
            return INSTANCE;
        }

        public static void setInstance(SshSessionFactory sshSessionFactory) {
            if (sshSessionFactory != null) {
                INSTANCE = sshSessionFactory;
            } else {
                INSTANCE = loadSshSessionFactory();
            }
        }
    }

    public static SshSessionFactory getInstance() {
        return DefaultFactory.getInstance();
    }

    public static void setInstance(SshSessionFactory sshSessionFactory) {
        DefaultFactory.setInstance(sshSessionFactory);
    }

    public static String getLocalUserName() {
        return SystemReader.getInstance().getProperty(Constants.OS_USER_NAME_KEY);
    }

    public void releaseSession(RemoteSession remoteSession) {
        remoteSession.disconnect();
    }
}

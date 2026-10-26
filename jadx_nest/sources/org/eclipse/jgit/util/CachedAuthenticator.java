package org.eclipse.jgit.util;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

/* INFO: loaded from: classes5.dex */
public abstract class CachedAuthenticator extends Authenticator {
    private static final Collection<CachedAuthentication> cached = new CopyOnWriteArrayList();

    protected abstract PasswordAuthentication promptPasswordAuthentication();

    public static void add(CachedAuthentication cachedAuthentication) {
        cached.add(cachedAuthentication);
    }

    @Override // java.net.Authenticator
    protected final PasswordAuthentication getPasswordAuthentication() {
        String requestingHost = getRequestingHost();
        int requestingPort = getRequestingPort();
        for (CachedAuthentication cachedAuthentication : cached) {
            if (cachedAuthentication.host.equals(requestingHost) && cachedAuthentication.port == requestingPort) {
                return cachedAuthentication.toPasswordAuthentication();
            }
        }
        PasswordAuthentication passwordAuthenticationPromptPasswordAuthentication = promptPasswordAuthentication();
        if (passwordAuthenticationPromptPasswordAuthentication == null) {
            return null;
        }
        CachedAuthentication cachedAuthentication2 = new CachedAuthentication(requestingHost, requestingPort, passwordAuthenticationPromptPasswordAuthentication.getUserName(), new String(passwordAuthenticationPromptPasswordAuthentication.getPassword()));
        add(cachedAuthentication2);
        return cachedAuthentication2.toPasswordAuthentication();
    }

    public static class CachedAuthentication {
        final String host;
        final String pass;
        final int port;
        final String user;

        public CachedAuthentication(String str, int i, String str2, String str3) {
            this.host = str;
            this.port = i;
            this.user = str2;
            this.pass = str3;
        }

        PasswordAuthentication toPasswordAuthentication() {
            return new PasswordAuthentication(this.user, this.pass.toCharArray());
        }
    }
}

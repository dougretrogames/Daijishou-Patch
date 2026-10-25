package org.eclipse.jgit.transport.resolver;

import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class ServiceNotAuthorizedException extends Exception {
    private static final long serialVersionUID = 1;

    public ServiceNotAuthorizedException(String str, Throwable th) {
        super(str, th);
    }

    public ServiceNotAuthorizedException(String str) {
        super(str);
    }

    public ServiceNotAuthorizedException() {
        super(JGitText.get().unauthorized);
    }
}

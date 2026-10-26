package org.eclipse.jgit.transport.resolver;

import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class ServiceNotEnabledException extends Exception {
    private static final long serialVersionUID = 1;

    public ServiceNotEnabledException(String str, Throwable th) {
        super(str, th);
    }

    public ServiceNotEnabledException(String str) {
        super(str);
    }

    public ServiceNotEnabledException() {
        super(JGitText.get().serviceNotEnabledNoName);
    }
}

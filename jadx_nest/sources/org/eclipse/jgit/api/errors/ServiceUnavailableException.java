package org.eclipse.jgit.api.errors;

/* JADX INFO: loaded from: classes5.dex */
public class ServiceUnavailableException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public ServiceUnavailableException(String str, Throwable th) {
        super(str, th);
    }

    public ServiceUnavailableException(String str) {
        super(str);
    }
}

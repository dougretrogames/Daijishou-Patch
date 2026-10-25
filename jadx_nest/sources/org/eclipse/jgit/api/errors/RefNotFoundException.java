package org.eclipse.jgit.api.errors;

/* JADX INFO: loaded from: classes5.dex */
public class RefNotFoundException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public RefNotFoundException(String str, Throwable th) {
        super(str, th);
    }

    public RefNotFoundException(String str) {
        super(str);
    }
}

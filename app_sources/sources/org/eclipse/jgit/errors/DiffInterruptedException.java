package org.eclipse.jgit.errors;

/* INFO: loaded from: classes5.dex */
public class DiffInterruptedException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public DiffInterruptedException(String str, Throwable th) {
        super(str, th);
    }

    public DiffInterruptedException(String str) {
        super(str);
    }

    public DiffInterruptedException() {
    }
}

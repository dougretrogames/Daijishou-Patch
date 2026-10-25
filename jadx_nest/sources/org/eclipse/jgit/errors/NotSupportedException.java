package org.eclipse.jgit.errors;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class NotSupportedException extends IOException {
    private static final long serialVersionUID = 1;

    public NotSupportedException(String str) {
        super(str);
    }

    public NotSupportedException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}

package org.eclipse.jgit.errors;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class ObjectWritingException extends IOException {
    private static final long serialVersionUID = 1;

    public ObjectWritingException(String str) {
        super(str);
    }

    public ObjectWritingException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}

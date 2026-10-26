package org.eclipse.jgit.transport;

import java.io.IOException;

/* INFO: loaded from: classes5.dex */
public class WriteAbortedException extends IOException {
    private static final long serialVersionUID = 1;

    public WriteAbortedException() {
    }

    public WriteAbortedException(String str) {
        super(str);
    }

    public WriteAbortedException(String str, Throwable th) {
        super(str, th);
    }
}

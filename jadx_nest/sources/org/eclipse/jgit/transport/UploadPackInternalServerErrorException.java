package org.eclipse.jgit.transport;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class UploadPackInternalServerErrorException extends IOException {
    private static final long serialVersionUID = 1;

    public UploadPackInternalServerErrorException(Throwable th) {
        initCause(th);
    }
}

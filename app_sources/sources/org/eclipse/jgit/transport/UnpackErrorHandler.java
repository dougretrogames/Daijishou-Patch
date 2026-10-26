package org.eclipse.jgit.transport;

import java.io.IOException;

/* INFO: loaded from: classes5.dex */
public interface UnpackErrorHandler {
    void handleUnpackException(Throwable th) throws IOException;
}

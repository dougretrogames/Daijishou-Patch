package org.eclipse.jgit.errors;

import java.io.IOException;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class IndexWriteException extends IOException {
    private static final long serialVersionUID = 1;

    public IndexWriteException() {
        super(JGitText.get().indexWriteException);
    }

    public IndexWriteException(String str) {
        super(str);
    }

    public IndexWriteException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}

package org.eclipse.jgit.errors;

import java.io.IOException;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class IndexReadException extends IOException {
    private static final long serialVersionUID = 1;

    public IndexReadException() {
        super(JGitText.get().indexWriteException);
    }

    public IndexReadException(String str) {
        super(str);
    }

    public IndexReadException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}

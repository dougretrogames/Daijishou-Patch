package org.eclipse.jgit.errors;

import java.io.IOException;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class UnpackException extends IOException {
    private static final long serialVersionUID = 1;

    public UnpackException(Throwable th) {
        super(JGitText.get().unpackException);
        initCause(th);
    }
}

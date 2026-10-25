package org.eclipse.jgit.dircache;

import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class InvalidPathException extends IllegalArgumentException {
    private static final long serialVersionUID = 1;

    public InvalidPathException(String str) {
        this(JGitText.get().invalidPath, str);
    }

    InvalidPathException(String str, Object... objArr) {
        super(MessageFormat.format(str, objArr));
    }
}

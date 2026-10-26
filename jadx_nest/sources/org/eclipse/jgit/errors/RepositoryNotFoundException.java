package org.eclipse.jgit.errors;

import java.io.File;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class RepositoryNotFoundException extends TransportException {
    private static final long serialVersionUID = 1;

    public RepositoryNotFoundException(File file) {
        this(file.getPath());
    }

    public RepositoryNotFoundException(File file, Throwable th) {
        this(file.getPath(), th);
    }

    public RepositoryNotFoundException(String str) {
        super(message(str));
    }

    public RepositoryNotFoundException(String str, Throwable th) {
        super(message(str), th);
    }

    private static String message(String str) {
        return MessageFormat.format(JGitText.get().repositoryNotFound, str);
    }
}

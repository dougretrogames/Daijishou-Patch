package org.eclipse.jgit.errors;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class LockFailedException extends IOException {
    private static final long serialVersionUID = 1;
    private File file;

    public LockFailedException(File file, String str, Throwable th) {
        super(str, th);
        this.file = file;
    }

    public LockFailedException(File file, String str) {
        super(str);
        this.file = file;
    }

    public LockFailedException(File file) {
        this(file, MessageFormat.format(JGitText.get().cannotLock, file));
    }

    public File getFile() {
        return this.file;
    }
}

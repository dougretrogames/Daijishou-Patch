package org.eclipse.jgit.errors;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class PackInvalidException extends IOException {
    private static final long serialVersionUID = 1;

    public PackInvalidException(File file, Throwable th) {
        this(file.getAbsolutePath(), th);
    }

    public PackInvalidException(String str, Throwable th) {
        super(MessageFormat.format(JGitText.get().packFileInvalid, str), th);
    }
}

package org.eclipse.jgit.errors;

import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class UnsupportedPackIndexVersionException extends IOException {
    private static final long serialVersionUID = 1;

    public UnsupportedPackIndexVersionException(int i) {
        super(MessageFormat.format(JGitText.get().unsupportedPackIndexVersion, Integer.valueOf(i)));
    }
}

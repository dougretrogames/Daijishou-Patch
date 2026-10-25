package org.eclipse.jgit.errors;

import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class UnsupportedPackVersionException extends IOException {
    private static final long serialVersionUID = 1;

    public UnsupportedPackVersionException(long j) {
        super(MessageFormat.format(JGitText.get().unsupportedPackVersion, Long.valueOf(j)));
    }
}

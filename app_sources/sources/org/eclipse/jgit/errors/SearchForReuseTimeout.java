package org.eclipse.jgit.errors;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.Duration;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class SearchForReuseTimeout extends IOException {
    private static final long serialVersionUID = 1;

    public SearchForReuseTimeout(Duration duration) {
        super(MessageFormat.format(JGitText.get().searchForReuseTimeout, Long.valueOf(duration.getSeconds())));
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

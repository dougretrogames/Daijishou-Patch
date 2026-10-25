package org.eclipse.jgit.api.errors;

import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class DetachedHeadException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public DetachedHeadException() {
        this(JGitText.get().detachedHeadDetected);
    }

    public DetachedHeadException(String str, Throwable th) {
        super(str, th);
    }

    public DetachedHeadException(String str) {
        super(str);
    }
}

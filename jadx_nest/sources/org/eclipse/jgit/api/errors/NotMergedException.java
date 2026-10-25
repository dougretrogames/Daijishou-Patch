package org.eclipse.jgit.api.errors;

import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class NotMergedException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public NotMergedException() {
        super(JGitText.get().notMergedExceptionMessage);
    }
}

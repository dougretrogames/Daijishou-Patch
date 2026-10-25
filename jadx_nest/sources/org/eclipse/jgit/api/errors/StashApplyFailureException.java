package org.eclipse.jgit.api.errors;

/* JADX INFO: loaded from: classes5.dex */
public class StashApplyFailureException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public StashApplyFailureException(String str, Throwable th) {
        super(str, th);
    }

    public StashApplyFailureException(String str) {
        super(str);
    }
}

package org.eclipse.jgit.api.errors;

/* JADX INFO: loaded from: classes5.dex */
public class PatchApplyException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public PatchApplyException(String str, Throwable th) {
        super(str, th);
    }

    public PatchApplyException(String str) {
        super(str);
    }
}

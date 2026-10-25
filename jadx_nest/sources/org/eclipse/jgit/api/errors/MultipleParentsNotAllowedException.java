package org.eclipse.jgit.api.errors;

/* JADX INFO: loaded from: classes5.dex */
public class MultipleParentsNotAllowedException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public MultipleParentsNotAllowedException(String str, Throwable th) {
        super(str, th);
    }

    public MultipleParentsNotAllowedException(String str) {
        super(str);
    }
}

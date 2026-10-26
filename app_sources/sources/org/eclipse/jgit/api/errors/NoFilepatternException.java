package org.eclipse.jgit.api.errors;

/* INFO: loaded from: classes5.dex */
public class NoFilepatternException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public NoFilepatternException(String str, Throwable th) {
        super(str, th);
    }

    public NoFilepatternException(String str) {
        super(str);
    }
}

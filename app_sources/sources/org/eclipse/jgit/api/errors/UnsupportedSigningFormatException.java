package org.eclipse.jgit.api.errors;

/* INFO: loaded from: classes5.dex */
public class UnsupportedSigningFormatException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public UnsupportedSigningFormatException(String str, Throwable th) {
        super(str, th);
    }

    public UnsupportedSigningFormatException(String str) {
        super(str);
    }
}

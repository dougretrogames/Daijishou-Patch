package org.eclipse.jgit.errors;

/* JADX INFO: loaded from: classes5.dex */
public class InvalidPatternException extends Exception {
    private static final long serialVersionUID = 1;
    private final String pattern;

    public InvalidPatternException(String str, String str2) {
        super(str);
        this.pattern = str2;
    }

    public InvalidPatternException(String str, String str2, Throwable th) {
        this(str, str2);
        initCause(th);
    }

    public String getPattern() {
        return this.pattern;
    }
}

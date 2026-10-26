package org.eclipse.jgit.errors;

/* INFO: loaded from: classes5.dex */
public class CommandFailedException extends Exception {
    private static final long serialVersionUID = 1;
    private int returnCode;

    public CommandFailedException(int i, String str) {
        super(str);
        this.returnCode = i;
    }

    public CommandFailedException(int i, String str, Throwable th) {
        super(str, th);
        this.returnCode = i;
    }

    public int getReturnCode() {
        return this.returnCode;
    }
}

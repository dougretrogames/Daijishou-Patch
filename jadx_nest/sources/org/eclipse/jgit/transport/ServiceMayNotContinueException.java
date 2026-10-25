package org.eclipse.jgit.transport;

import java.io.IOException;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class ServiceMayNotContinueException extends IOException {
    private static final int FORBIDDEN = 403;
    private static final long serialVersionUID = 1;
    private boolean output;
    private final int statusCode;

    public ServiceMayNotContinueException() {
        this.statusCode = 403;
    }

    public ServiceMayNotContinueException(String str) {
        super(str);
        this.statusCode = 403;
    }

    public ServiceMayNotContinueException(String str, int i) {
        super(str);
        this.statusCode = i;
    }

    public ServiceMayNotContinueException(String str, Throwable th) {
        super(str, th);
        this.statusCode = 403;
    }

    public ServiceMayNotContinueException(String str, Throwable th, int i) {
        super(str, th);
        this.statusCode = i;
    }

    public ServiceMayNotContinueException(Throwable th) {
        this(JGitText.get().internalServerError, th);
    }

    public boolean isOutput() {
        return this.output;
    }

    public void setOutput() {
        this.output = true;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}

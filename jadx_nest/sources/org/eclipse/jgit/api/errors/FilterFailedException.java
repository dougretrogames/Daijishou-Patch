package org.eclipse.jgit.api.errors;

import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class FilterFailedException extends GitAPIException {
    private static final long serialVersionUID = 1;
    private String filterCommand;
    private String path;
    private int rc;
    private String stderr;
    private byte[] stdout;

    public FilterFailedException(Exception exc, String str, String str2) {
        super(MessageFormat.format(JGitText.get().filterExecutionFailed, str, str2), exc);
        this.filterCommand = str;
        this.path = str2;
    }

    public FilterFailedException(int i, String str, String str2, byte[] bArr, String str3) {
        super(MessageFormat.format(JGitText.get().filterExecutionFailedRc, str, str2, Integer.valueOf(i), str3));
        this.rc = i;
        this.filterCommand = str;
        this.path = str2;
        this.stdout = bArr;
        this.stderr = str3;
    }

    public String getFilterCommand() {
        return this.filterCommand;
    }

    public String getPath() {
        return this.path;
    }

    public byte[] getOutput() {
        return this.stdout;
    }

    public String getError() {
        return this.stderr;
    }

    public int getReturnCode() {
        return this.rc;
    }
}

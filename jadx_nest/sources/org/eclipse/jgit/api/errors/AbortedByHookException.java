package org.eclipse.jgit.api.errors;

import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class AbortedByHookException extends GitAPIException {
    private static final long serialVersionUID = 1;
    private final String hookName;
    private final String hookStdErr;
    private final int returnCode;

    public AbortedByHookException(String str, String str2, int i) {
        super(MessageFormat.format(JGitText.get().commandRejectedByHook, str2, str));
        this.hookStdErr = str;
        this.hookName = str2;
        this.returnCode = i;
    }

    public String getHookName() {
        return this.hookName;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public String getHookStdErr() {
        return this.hookStdErr;
    }
}

package org.eclipse.jgit.errors;

import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class CheckoutConflictException extends IOException {
    private static final long serialVersionUID = 1;
    private final String[] conflicting;

    public CheckoutConflictException(String str) {
        super(MessageFormat.format(JGitText.get().checkoutConflictWithFile, str));
        this.conflicting = new String[]{str};
    }

    public CheckoutConflictException(String[] strArr) {
        super(MessageFormat.format(JGitText.get().checkoutConflictWithFiles, buildList(strArr)));
        this.conflicting = strArr;
    }

    public String[] getConflictingFiles() {
        return this.conflicting;
    }

    private static String buildList(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append("\n");
            sb.append(str);
        }
        return sb.toString();
    }
}

package org.eclipse.jgit.errors;

import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.transport.URIish;

/* JADX INFO: loaded from: classes5.dex */
public class TooLargeObjectInPackException extends TransportException {
    private static final long serialVersionUID = 1;

    public TooLargeObjectInPackException(long j) {
        super(MessageFormat.format(JGitText.get().receivePackObjectTooLarge1, Long.valueOf(j)));
    }

    public TooLargeObjectInPackException(long j, long j2) {
        super(MessageFormat.format(JGitText.get().receivePackObjectTooLarge2, Long.valueOf(j), Long.valueOf(j2)));
    }

    public TooLargeObjectInPackException(URIish uRIish, String str) {
        super(String.valueOf(uRIish.setPass(null)) + ": " + str);
    }
}

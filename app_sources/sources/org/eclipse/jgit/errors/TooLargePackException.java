package org.eclipse.jgit.errors;

import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.transport.URIish;

/* INFO: loaded from: classes5.dex */
public class TooLargePackException extends TransportException {
    private static final long serialVersionUID = 1;

    public TooLargePackException(long j) {
        super(MessageFormat.format(JGitText.get().receivePackTooLarge, Long.valueOf(j)));
    }

    public TooLargePackException(URIish uRIish, String str) {
        super(String.valueOf(uRIish.setPass(null)) + ": " + str);
    }
}

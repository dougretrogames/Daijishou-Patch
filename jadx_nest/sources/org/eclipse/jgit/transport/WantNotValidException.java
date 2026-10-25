package org.eclipse.jgit.transport;

import java.text.MessageFormat;
import org.eclipse.jgit.errors.PackProtocolException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;

/* JADX INFO: loaded from: classes5.dex */
public class WantNotValidException extends PackProtocolException {
    private static final long serialVersionUID = 1;

    public WantNotValidException(AnyObjectId anyObjectId) {
        super(msg(anyObjectId));
    }

    public WantNotValidException(AnyObjectId anyObjectId, Throwable th) {
        super(msg(anyObjectId), th);
    }

    private static String msg(AnyObjectId anyObjectId) {
        return MessageFormat.format(JGitText.get().wantNotValid, anyObjectId.name());
    }
}

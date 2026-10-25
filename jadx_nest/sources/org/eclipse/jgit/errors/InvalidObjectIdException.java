package org.eclipse.jgit.errors;

import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class InvalidObjectIdException extends IllegalArgumentException {
    private static final long serialVersionUID = 1;

    public InvalidObjectIdException(byte[] bArr, int i, int i2) {
        super(msg(bArr, i, i2));
    }

    public InvalidObjectIdException(String str) {
        super(MessageFormat.format(JGitText.get().invalidId, str));
    }

    private static String msg(byte[] bArr, int i, int i2) {
        try {
            return MessageFormat.format(JGitText.get().invalidId, new String(bArr, i, i2, StandardCharsets.US_ASCII));
        } catch (StringIndexOutOfBoundsException unused) {
            return JGitText.get().invalidId0;
        }
    }
}

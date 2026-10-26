package org.eclipse.jgit.errors;

import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectChecker;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
public class CorruptObjectException extends IOException {
    private static final long serialVersionUID = 1;
    private ObjectChecker.ErrorType errorType;

    public CorruptObjectException(ObjectChecker.ErrorType errorType, AnyObjectId anyObjectId, String str) {
        super(MessageFormat.format(JGitText.get().objectIsCorrupt3, errorType.getMessageId(), anyObjectId.name(), str));
        this.errorType = errorType;
    }

    public CorruptObjectException(AnyObjectId anyObjectId, String str) {
        super(MessageFormat.format(JGitText.get().objectIsCorrupt, anyObjectId.name(), str));
    }

    public CorruptObjectException(ObjectId objectId, String str) {
        super(MessageFormat.format(JGitText.get().objectIsCorrupt, objectId.name(), str));
    }

    public CorruptObjectException(String str) {
        super(str);
    }

    public CorruptObjectException(String str, Throwable th) {
        super(str);
        initCause(th);
    }

    @Nullable
    public ObjectChecker.ErrorType getErrorType() {
        return this.errorType;
    }
}

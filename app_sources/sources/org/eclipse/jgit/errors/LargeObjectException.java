package org.eclipse.jgit.errors;

import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
public class LargeObjectException extends RuntimeException {
    private static final long serialVersionUID = 1;
    private ObjectId objectId;

    public LargeObjectException() {
    }

    public LargeObjectException(Throwable th) {
        initCause(th);
    }

    public LargeObjectException(AnyObjectId anyObjectId) {
        setObjectId(anyObjectId);
    }

    public ObjectId getObjectId() {
        return this.objectId;
    }

    protected String getObjectName() {
        if (getObjectId() != null) {
            return getObjectId().name();
        }
        return JGitText.get().unknownObject;
    }

    public void setObjectId(AnyObjectId anyObjectId) {
        if (this.objectId == null) {
            this.objectId = anyObjectId.copy();
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return MessageFormat.format(JGitText.get().largeObjectException, getObjectName());
    }

    public static class OutOfMemory extends LargeObjectException {
        private static final long serialVersionUID = 1;

        public OutOfMemory(OutOfMemoryError outOfMemoryError) {
            initCause(outOfMemoryError);
        }

        @Override // org.eclipse.jgit.errors.LargeObjectException, java.lang.Throwable
        public String getMessage() {
            return MessageFormat.format(JGitText.get().largeObjectOutOfMemory, getObjectName());
        }
    }

    public static class ExceedsByteArrayLimit extends LargeObjectException {
        private static final long serialVersionUID = 1;

        @Override // org.eclipse.jgit.errors.LargeObjectException, java.lang.Throwable
        public String getMessage() {
            return MessageFormat.format(JGitText.get().largeObjectExceedsByteArray, getObjectName());
        }
    }

    public static class ExceedsLimit extends LargeObjectException {
        private static final long serialVersionUID = 1;
        private final long limit;
        private final long size;

        public ExceedsLimit(long j, long j2) {
            this.limit = j;
            this.size = j2;
        }

        @Override // org.eclipse.jgit.errors.LargeObjectException, java.lang.Throwable
        public String getMessage() {
            return MessageFormat.format(JGitText.get().largeObjectExceedsLimit, getObjectName(), Long.valueOf(this.limit), Long.valueOf(this.size));
        }
    }
}

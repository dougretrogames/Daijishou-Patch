package org.eclipse.jgit.errors;

import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
public class MissingObjectException extends IOException {
    private static final long serialVersionUID = 1;
    private final ObjectId missing;

    public MissingObjectException(ObjectId objectId, String str) {
        super(MessageFormat.format(JGitText.get().missingObject, str, objectId.name()));
        this.missing = objectId.copy();
    }

    public MissingObjectException(ObjectId objectId, int i) {
        this(objectId, Constants.typeString(i));
    }

    public MissingObjectException(AbbreviatedObjectId abbreviatedObjectId, int i) {
        super(MessageFormat.format(JGitText.get().missingObject, Constants.typeString(i), abbreviatedObjectId.name()));
        this.missing = null;
    }

    public ObjectId getObjectId() {
        return this.missing;
    }
}

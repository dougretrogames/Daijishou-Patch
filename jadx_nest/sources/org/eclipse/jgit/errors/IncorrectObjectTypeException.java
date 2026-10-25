package org.eclipse.jgit.errors;

import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: loaded from: classes5.dex */
public class IncorrectObjectTypeException extends IOException {
    private static final long serialVersionUID = 1;

    public IncorrectObjectTypeException(ObjectId objectId, String str) {
        super(MessageFormat.format(JGitText.get().objectIsNotA, objectId.name(), str));
    }

    public IncorrectObjectTypeException(ObjectId objectId, int i) {
        this(objectId, Constants.typeString(i));
    }
}

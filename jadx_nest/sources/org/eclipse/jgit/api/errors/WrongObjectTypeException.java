package org.eclipse.jgit.api.errors;

import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
public class WrongObjectTypeException extends GitAPIException {
    private static final long serialVersionUID = 1;
    private String name;
    private int type;

    public WrongObjectTypeException(ObjectId objectId, int i) {
        super(MessageFormat.format(JGitText.get().objectIsNotA, objectId.name(), Constants.typeString(i)));
        this.name = objectId.name();
        this.type = i;
    }

    public String getObjectId() {
        return this.name;
    }

    public int getExpectedType() {
        return this.type;
    }
}

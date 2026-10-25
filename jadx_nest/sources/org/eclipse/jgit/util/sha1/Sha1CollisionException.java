package org.eclipse.jgit.util.sha1;

import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: loaded from: classes5.dex */
public class Sha1CollisionException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public Sha1CollisionException(ObjectId objectId) {
        super(MessageFormat.format(JGitText.get().sha1CollisionDetected, objectId.name()));
    }
}

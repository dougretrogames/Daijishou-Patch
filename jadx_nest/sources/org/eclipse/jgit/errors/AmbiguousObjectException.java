package org.eclipse.jgit.errors;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collection;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: loaded from: classes5.dex */
public class AmbiguousObjectException extends IOException {
    private static final long serialVersionUID = 1;
    private final Collection<ObjectId> candidates;
    private final AbbreviatedObjectId missing;

    public AmbiguousObjectException(AbbreviatedObjectId abbreviatedObjectId, Collection<ObjectId> collection) {
        super(MessageFormat.format(JGitText.get().ambiguousObjectAbbreviation, abbreviatedObjectId.name()));
        this.missing = abbreviatedObjectId;
        this.candidates = collection;
    }

    public AbbreviatedObjectId getAbbreviatedObjectId() {
        return this.missing;
    }

    public Collection<ObjectId> getCandidates() {
        return this.candidates;
    }
}

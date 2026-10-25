package org.eclipse.jgit.revwalk;

import java.io.IOException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.AnyObjectId;

/* JADX INFO: loaded from: classes5.dex */
public class RevBlob extends RevObject {
    @Override // org.eclipse.jgit.revwalk.RevObject
    public final int getType() {
        return 3;
    }

    protected RevBlob(AnyObjectId anyObjectId) {
        super(anyObjectId);
    }

    @Override // org.eclipse.jgit.revwalk.RevObject
    void parseHeaders(RevWalk revWalk) throws IOException {
        if (revWalk.reader.has(this)) {
            this.flags |= 1;
            return;
        }
        throw new MissingObjectException(this, getType());
    }

    @Override // org.eclipse.jgit.revwalk.RevObject
    void parseBody(RevWalk revWalk) throws IOException {
        if ((this.flags & 1) == 0) {
            parseHeaders(revWalk);
        }
    }
}

package org.eclipse.jgit.fnmatch;

import java.util.List;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractHead implements Head {
    private List<Head> newHeads = null;
    private final boolean star;

    protected abstract boolean matches(char c);

    AbstractHead(boolean z) {
        this.star = z;
    }

    public final void setNewHeads(List<Head> list) {
        if (this.newHeads != null) {
            throw new IllegalStateException(JGitText.get().propertyIsAlreadyNonNull);
        }
        this.newHeads = list;
    }

    @Override // org.eclipse.jgit.fnmatch.Head
    public List<Head> getNextHeads(char c) {
        if (matches(c)) {
            return this.newHeads;
        }
        return FileNameMatcher.EMPTY_HEAD_LIST;
    }

    boolean isStar() {
        return this.star;
    }
}

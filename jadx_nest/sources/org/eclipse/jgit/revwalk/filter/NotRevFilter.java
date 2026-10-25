package org.eclipse.jgit.revwalk.filter;

import java.io.IOException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

/* JADX INFO: loaded from: classes5.dex */
public class NotRevFilter extends RevFilter {
    private final RevFilter a;

    public static RevFilter create(RevFilter revFilter) {
        return new NotRevFilter(revFilter);
    }

    private NotRevFilter(RevFilter revFilter) {
        this.a = revFilter;
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public RevFilter negate() {
        return this.a;
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public boolean include(RevWalk revWalk, RevCommit revCommit) throws IOException {
        return !this.a.include(revWalk, revCommit);
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public boolean requiresCommitBody() {
        return this.a.requiresCommitBody();
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public RevFilter clone() {
        return new NotRevFilter(this.a.clone());
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public String toString() {
        return "NOT " + this.a.toString();
    }
}

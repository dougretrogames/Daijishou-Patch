package org.eclipse.jgit.revwalk.filter;

import java.io.IOException;
import org.eclipse.jgit.errors.StopWalkException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

/* JADX INFO: loaded from: classes5.dex */
public class SkipRevFilter extends RevFilter {
    private int count;
    private final int skip;

    public static RevFilter create(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(JGitText.get().skipMustBeNonNegative);
        }
        return new SkipRevFilter(i);
    }

    private SkipRevFilter(int i) {
        this.skip = i;
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public boolean include(RevWalk revWalk, RevCommit revCommit) throws IOException, StopWalkException {
        int i = this.skip;
        int i2 = this.count;
        this.count = i2 + 1;
        return i <= i2;
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public RevFilter clone() {
        return new SkipRevFilter(this.skip);
    }
}

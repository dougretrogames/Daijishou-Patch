package org.eclipse.jgit.revwalk.filter;

import java.io.IOException;
import org.eclipse.jgit.errors.StopWalkException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

/* JADX INFO: loaded from: classes5.dex */
public class MaxCountRevFilter extends RevFilter {
    private int count = 0;
    private int maxCount;

    public static RevFilter create(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(JGitText.get().maxCountMustBeNonNegative);
        }
        return new MaxCountRevFilter(i);
    }

    private MaxCountRevFilter(int i) {
        this.maxCount = i;
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public boolean include(RevWalk revWalk, RevCommit revCommit) throws IOException, StopWalkException {
        int i = this.count + 1;
        this.count = i;
        if (i <= this.maxCount) {
            return true;
        }
        throw StopWalkException.INSTANCE;
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public RevFilter clone() {
        return new MaxCountRevFilter(this.maxCount);
    }
}

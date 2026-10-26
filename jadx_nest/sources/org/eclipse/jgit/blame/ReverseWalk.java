package org.eclipse.jgit.blame;

import java.io.IOException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
final class ReverseWalk extends RevWalk {
    ReverseWalk(Repository repository) {
        super(repository);
    }

    @Override // org.eclipse.jgit.revwalk.RevWalk
    public ReverseCommit next() throws IOException {
        ReverseCommit reverseCommit = (ReverseCommit) super.next();
        if (reverseCommit == null) {
            return null;
        }
        for (int i = 0; i < reverseCommit.getParentCount(); i++) {
            ((ReverseCommit) reverseCommit.getParent(i)).addChild(reverseCommit);
        }
        return reverseCommit;
    }

    @Override // org.eclipse.jgit.revwalk.RevWalk
    protected RevCommit createCommit(AnyObjectId anyObjectId) {
        return new ReverseCommit(anyObjectId);
    }

    static final class ReverseCommit extends RevCommit {
        private static final ReverseCommit[] NO_CHILDREN = new ReverseCommit[0];
        private ReverseCommit[] children;

        ReverseCommit(AnyObjectId anyObjectId) {
            super(anyObjectId);
            this.children = NO_CHILDREN;
        }

        void addChild(ReverseCommit reverseCommit) {
            ReverseCommit[] reverseCommitArr = this.children;
            int length = reverseCommitArr.length;
            if (length == 0) {
                this.children = new ReverseCommit[]{reverseCommit};
                return;
            }
            if (length == 1) {
                this.children = new ReverseCommit[]{reverseCommit, reverseCommitArr[0]};
                return;
            }
            ReverseCommit[] reverseCommitArr2 = new ReverseCommit[length + 1];
            reverseCommitArr2[0] = reverseCommit;
            System.arraycopy(reverseCommitArr, 0, reverseCommitArr2, 1, length);
            this.children = reverseCommitArr2;
        }

        int getChildCount() {
            return this.children.length;
        }

        ReverseCommit getChild(int i) {
            return this.children[i];
        }
    }
}

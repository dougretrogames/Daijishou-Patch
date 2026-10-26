package org.eclipse.jgit.revwalk.filter;

import java.io.IOException;
import java.util.Arrays;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevFlag;
import org.eclipse.jgit.revwalk.RevFlagSet;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
public abstract class RevFlagFilter extends RevFilter {
    final RevFlagSet flags;

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public RevFilter clone() {
        return this;
    }

    public static RevFilter has(RevFlag revFlag) {
        RevFlagSet revFlagSet = new RevFlagSet();
        revFlagSet.add(revFlag);
        return new HasAll(revFlagSet);
    }

    public static RevFilter hasAll(RevFlag... revFlagArr) {
        RevFlagSet revFlagSet = new RevFlagSet();
        revFlagSet.addAll(Arrays.asList(revFlagArr));
        return new HasAll(revFlagSet);
    }

    public static RevFilter hasAll(RevFlagSet revFlagSet) {
        return new HasAll(new RevFlagSet(revFlagSet));
    }

    public static RevFilter hasAny(RevFlag... revFlagArr) {
        RevFlagSet revFlagSet = new RevFlagSet();
        revFlagSet.addAll(Arrays.asList(revFlagArr));
        return new HasAny(revFlagSet);
    }

    public static RevFilter hasAny(RevFlagSet revFlagSet) {
        return new HasAny(new RevFlagSet(revFlagSet));
    }

    RevFlagFilter(RevFlagSet revFlagSet) {
        this.flags = revFlagSet;
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public String toString() {
        return super.toString() + String.valueOf(this.flags);
    }

    private static class HasAll extends RevFlagFilter {
        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean requiresCommitBody() {
            return false;
        }

        HasAll(RevFlagSet revFlagSet) {
            super(revFlagSet);
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean include(RevWalk revWalk, RevCommit revCommit) throws IOException {
            return revCommit.hasAll(this.flags);
        }
    }

    private static class HasAny extends RevFlagFilter {
        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean requiresCommitBody() {
            return false;
        }

        HasAny(RevFlagSet revFlagSet) {
            super(revFlagSet);
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean include(RevWalk revWalk, RevCommit revCommit) throws IOException {
            return revCommit.hasAny(this.flags);
        }
    }
}

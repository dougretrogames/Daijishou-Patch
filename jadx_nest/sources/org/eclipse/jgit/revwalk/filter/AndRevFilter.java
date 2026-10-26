package org.eclipse.jgit.revwalk.filter;

import java.io.IOException;
import java.util.Collection;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
public abstract class AndRevFilter extends RevFilter {
    public static RevFilter create(RevFilter revFilter, RevFilter revFilter2) {
        if (revFilter == ALL) {
            return revFilter2;
        }
        return revFilter2 == ALL ? revFilter : new Binary(revFilter, revFilter2);
    }

    public static RevFilter create(RevFilter[] revFilterArr) {
        if (revFilterArr.length == 2) {
            return create(revFilterArr[0], revFilterArr[1]);
        }
        if (revFilterArr.length < 2) {
            throw new IllegalArgumentException(JGitText.get().atLeastTwoFiltersNeeded);
        }
        RevFilter[] revFilterArr2 = new RevFilter[revFilterArr.length];
        System.arraycopy(revFilterArr, 0, revFilterArr2, 0, revFilterArr.length);
        return new List(revFilterArr2);
    }

    public static RevFilter create(Collection<RevFilter> collection) {
        if (collection.size() < 2) {
            throw new IllegalArgumentException(JGitText.get().atLeastTwoFiltersNeeded);
        }
        int size = collection.size();
        RevFilter[] revFilterArr = new RevFilter[size];
        collection.toArray(revFilterArr);
        if (size == 2) {
            return create(revFilterArr[0], revFilterArr[1]);
        }
        return new List(revFilterArr);
    }

    private static class Binary extends AndRevFilter {
        private final RevFilter a;
        private final RevFilter b;
        private final boolean requiresCommitBody;

        Binary(RevFilter revFilter, RevFilter revFilter2) {
            this.a = revFilter;
            this.b = revFilter2;
            this.requiresCommitBody = revFilter.requiresCommitBody() || revFilter2.requiresCommitBody();
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean include(RevWalk revWalk, RevCommit revCommit) throws IOException {
            return this.a.include(revWalk, revCommit) && this.b.include(revWalk, revCommit);
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean requiresCommitBody() {
            return this.requiresCommitBody;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public RevFilter clone() {
            return new Binary(this.a.clone(), this.b.clone());
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public String toString() {
            return "(" + this.a.toString() + " AND " + this.b.toString() + ")";
        }
    }

    private static class List extends AndRevFilter {
        private final boolean requiresCommitBody;
        private final RevFilter[] subfilters;

        List(RevFilter[] revFilterArr) {
            this.subfilters = revFilterArr;
            boolean zRequiresCommitBody = false;
            for (RevFilter revFilter : revFilterArr) {
                zRequiresCommitBody |= revFilter.requiresCommitBody();
            }
            this.requiresCommitBody = zRequiresCommitBody;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean include(RevWalk revWalk, RevCommit revCommit) throws IOException {
            for (RevFilter revFilter : this.subfilters) {
                if (!revFilter.include(revWalk, revCommit)) {
                    return false;
                }
            }
            return true;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean requiresCommitBody() {
            return this.requiresCommitBody;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public RevFilter clone() {
            int length = this.subfilters.length;
            RevFilter[] revFilterArr = new RevFilter[length];
            for (int i = 0; i < length; i++) {
                revFilterArr[i] = this.subfilters[i].clone();
            }
            return new List(revFilterArr);
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public String toString() {
            StringBuilder sb = new StringBuilder("(");
            for (int i = 0; i < this.subfilters.length; i++) {
                if (i > 0) {
                    sb.append(" AND ");
                }
                sb.append(this.subfilters[i].toString());
            }
            sb.append(")");
            return sb.toString();
        }
    }
}

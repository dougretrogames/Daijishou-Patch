package org.eclipse.jgit.treewalk.filter;

import java.io.IOException;
import java.util.Collection;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.treewalk.TreeWalk;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AndTreeFilter extends TreeFilter {
    public static TreeFilter create(TreeFilter treeFilter, TreeFilter treeFilter2) {
        if (treeFilter == ALL) {
            return treeFilter2;
        }
        return treeFilter2 == ALL ? treeFilter : new Binary(treeFilter, treeFilter2);
    }

    public static TreeFilter create(TreeFilter[] treeFilterArr) {
        if (treeFilterArr.length == 2) {
            return create(treeFilterArr[0], treeFilterArr[1]);
        }
        if (treeFilterArr.length < 2) {
            throw new IllegalArgumentException(JGitText.get().atLeastTwoFiltersNeeded);
        }
        TreeFilter[] treeFilterArr2 = new TreeFilter[treeFilterArr.length];
        System.arraycopy(treeFilterArr, 0, treeFilterArr2, 0, treeFilterArr.length);
        return new List(treeFilterArr2);
    }

    public static TreeFilter create(Collection<TreeFilter> collection) {
        if (collection.size() < 2) {
            throw new IllegalArgumentException(JGitText.get().atLeastTwoFiltersNeeded);
        }
        int size = collection.size();
        TreeFilter[] treeFilterArr = new TreeFilter[size];
        collection.toArray(treeFilterArr);
        if (size == 2) {
            return create(treeFilterArr[0], treeFilterArr[1]);
        }
        return new List(treeFilterArr);
    }

    private static class Binary extends AndTreeFilter {
        private final TreeFilter a;
        private final TreeFilter b;

        Binary(TreeFilter treeFilter, TreeFilter treeFilter2) {
            this.a = treeFilter;
            this.b = treeFilter2;
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public boolean include(TreeWalk treeWalk) throws IOException {
            return matchFilter(treeWalk) <= 0;
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public int matchFilter(TreeWalk treeWalk) throws IOException {
            int iMatchFilter;
            int iMatchFilter2 = this.a.matchFilter(treeWalk);
            if (iMatchFilter2 == 1 || (iMatchFilter = this.b.matchFilter(treeWalk)) == 1) {
                return 1;
            }
            return (iMatchFilter2 == -1 || iMatchFilter == -1) ? -1 : 0;
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public boolean shouldBeRecursive() {
            return this.a.shouldBeRecursive() || this.b.shouldBeRecursive();
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public TreeFilter clone() {
            return new Binary(this.a.clone(), this.b.clone());
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public String toString() {
            return "(" + this.a.toString() + " AND " + this.b.toString() + ")";
        }
    }

    private static class List extends AndTreeFilter {
        private final TreeFilter[] subfilters;

        List(TreeFilter[] treeFilterArr) {
            this.subfilters = treeFilterArr;
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public boolean include(TreeWalk treeWalk) throws IOException {
            return matchFilter(treeWalk) <= 0;
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public int matchFilter(TreeWalk treeWalk) throws IOException {
            int i = 0;
            for (TreeFilter treeFilter : this.subfilters) {
                int iMatchFilter = treeFilter.matchFilter(treeWalk);
                if (iMatchFilter == 1) {
                    return 1;
                }
                if (iMatchFilter == -1) {
                    i = -1;
                }
            }
            return i;
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public boolean shouldBeRecursive() {
            for (TreeFilter treeFilter : this.subfilters) {
                if (treeFilter.shouldBeRecursive()) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public TreeFilter clone() {
            int length = this.subfilters.length;
            TreeFilter[] treeFilterArr = new TreeFilter[length];
            for (int i = 0; i < length; i++) {
                treeFilterArr[i] = this.subfilters[i].clone();
            }
            return new List(treeFilterArr);
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
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

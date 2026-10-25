package org.eclipse.jgit.treewalk.filter;

import java.io.IOException;
import org.eclipse.jgit.treewalk.TreeWalk;

/* JADX INFO: loaded from: classes5.dex */
public class NotTreeFilter extends TreeFilter {
    private final TreeFilter a;

    public static TreeFilter create(TreeFilter treeFilter) {
        return new NotTreeFilter(treeFilter);
    }

    private NotTreeFilter(TreeFilter treeFilter) {
        this.a = treeFilter;
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public TreeFilter negate() {
        return this.a;
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public boolean include(TreeWalk treeWalk) throws IOException {
        return matchFilter(treeWalk) == 0;
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public int matchFilter(TreeWalk treeWalk) throws IOException {
        int iMatchFilter = this.a.matchFilter(treeWalk);
        if (iMatchFilter == 0) {
            return 1;
        }
        return iMatchFilter == 1 ? 0 : -1;
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public boolean shouldBeRecursive() {
        return this.a.shouldBeRecursive();
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public TreeFilter clone() {
        TreeFilter treeFilterClone = this.a.clone();
        return treeFilterClone == this.a ? this : new NotTreeFilter(treeFilterClone);
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public String toString() {
        return "NOT " + this.a.toString();
    }
}

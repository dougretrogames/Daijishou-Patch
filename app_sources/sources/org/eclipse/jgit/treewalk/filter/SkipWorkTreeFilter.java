package org.eclipse.jgit.treewalk.filter;

import org.eclipse.jgit.dircache.DirCacheEntry;
import org.eclipse.jgit.dircache.DirCacheIterator;
import org.eclipse.jgit.treewalk.TreeWalk;

/* INFO: loaded from: classes5.dex */
public class SkipWorkTreeFilter extends TreeFilter {
    private final int treeIdx;

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public TreeFilter clone() {
        return this;
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public boolean shouldBeRecursive() {
        return false;
    }

    public SkipWorkTreeFilter(int i) {
        this.treeIdx = i;
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public boolean include(TreeWalk treeWalk) {
        DirCacheEntry dirCacheEntry;
        DirCacheIterator dirCacheIterator = (DirCacheIterator) treeWalk.getTree(this.treeIdx, DirCacheIterator.class);
        return dirCacheIterator == null || (dirCacheEntry = dirCacheIterator.getDirCacheEntry()) == null || !dirCacheEntry.isSkipWorkTree();
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public String toString() {
        return "SkipWorkTree(" + this.treeIdx + ")";
    }
}

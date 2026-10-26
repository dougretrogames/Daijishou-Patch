package org.eclipse.jgit.treewalk.filter;

import org.eclipse.jgit.dircache.DirCacheEntry;
import org.eclipse.jgit.dircache.DirCacheIterator;
import org.eclipse.jgit.treewalk.TreeWalk;

/* INFO: loaded from: classes5.dex */
public final class InterIndexDiffFilter extends TreeFilter {
    public static final TreeFilter INSTANCE = new InterIndexDiffFilter();
    private static final int baseTree = 0;

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public TreeFilter clone() {
        return this;
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public boolean shouldBeRecursive() {
        return false;
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public boolean include(TreeWalk treeWalk) {
        int treeCount = treeWalk.getTreeCount();
        if (treeCount == 1) {
            return true;
        }
        int rawMode = treeWalk.getRawMode(0);
        for (int i = 1; i < treeCount; i++) {
            DirCacheIterator dirCacheIterator = (DirCacheIterator) treeWalk.getTree(0, DirCacheIterator.class);
            DirCacheIterator dirCacheIterator2 = (DirCacheIterator) treeWalk.getTree(i, DirCacheIterator.class);
            if (dirCacheIterator != null && dirCacheIterator2 != null) {
                DirCacheEntry dirCacheEntry = dirCacheIterator.getDirCacheEntry();
                DirCacheEntry dirCacheEntry2 = dirCacheIterator2.getDirCacheEntry();
                if (dirCacheEntry != null && dirCacheEntry2 != null) {
                    if (dirCacheEntry.isAssumeValid() != dirCacheEntry2.isAssumeValid()) {
                        return true;
                    }
                    if (dirCacheEntry.isAssumeValid()) {
                        return false;
                    }
                }
            }
            if (treeWalk.getRawMode(i) != rawMode || !treeWalk.idEqual(i, 0)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public String toString() {
        return "INTERINDEX_DIFF";
    }
}

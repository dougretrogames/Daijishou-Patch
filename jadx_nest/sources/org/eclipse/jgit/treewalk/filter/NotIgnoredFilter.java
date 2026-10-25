package org.eclipse.jgit.treewalk.filter;

import java.io.IOException;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.WorkingTreeIterator;

/* JADX INFO: loaded from: classes5.dex */
public class NotIgnoredFilter extends TreeFilter {
    private final int index;

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public TreeFilter clone() {
        return this;
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public boolean shouldBeRecursive() {
        return false;
    }

    public NotIgnoredFilter(int i) {
        this.index = i;
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public boolean include(TreeWalk treeWalk) throws IOException {
        WorkingTreeIterator workingTreeIterator = (WorkingTreeIterator) treeWalk.getTree(this.index, WorkingTreeIterator.class);
        return workingTreeIterator == null || !workingTreeIterator.isEntryIgnored();
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public String toString() {
        return "NotIgnored(" + this.index + ")";
    }
}

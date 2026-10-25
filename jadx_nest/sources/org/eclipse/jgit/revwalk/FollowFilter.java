package org.eclipse.jgit.revwalk;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import org.eclipse.jgit.diff.DiffConfig;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.PathFilter;
import org.eclipse.jgit.treewalk.filter.TreeFilter;

/* JADX INFO: loaded from: classes5.dex */
public class FollowFilter extends TreeFilter {
    final DiffConfig cfg;
    private final PathFilter path;
    private RenameCallback renameCallback;

    public static FollowFilter create(String str, DiffConfig diffConfig) {
        return new FollowFilter(PathFilter.create(str), diffConfig);
    }

    FollowFilter(PathFilter pathFilter, DiffConfig diffConfig) {
        this.path = pathFilter;
        this.cfg = diffConfig;
    }

    public String getPath() {
        return this.path.getPath();
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public boolean include(TreeWalk treeWalk) throws IOException {
        return this.path.include(treeWalk) && ANY_DIFF.include(treeWalk);
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public boolean shouldBeRecursive() {
        return this.path.shouldBeRecursive() || ANY_DIFF.shouldBeRecursive();
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public Optional<Set<byte[]>> getPathsBestEffort() {
        return this.path.getPathsBestEffort();
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public TreeFilter clone() {
        return new FollowFilter(this.path.clone(), this.cfg);
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public String toString() {
        return "(FOLLOW(" + this.path.toString() + ") AND " + ANY_DIFF.toString() + ")";
    }

    public RenameCallback getRenameCallback() {
        return this.renameCallback;
    }

    public void setRenameCallback(RenameCallback renameCallback) {
        this.renameCallback = renameCallback;
    }
}

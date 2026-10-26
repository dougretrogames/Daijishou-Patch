package org.eclipse.jgit.treewalk.filter;

import java.io.IOException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.treewalk.TreeWalk;

/* INFO: loaded from: classes5.dex */
public class PathSuffixFilter extends TreeFilter {
    final byte[] pathRaw;
    final String pathStr;

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public TreeFilter clone() {
        return this;
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public boolean shouldBeRecursive() {
        return true;
    }

    public static PathSuffixFilter create(String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException(JGitText.get().emptyPathNotPermitted);
        }
        return new PathSuffixFilter(str);
    }

    private PathSuffixFilter(String str) {
        this.pathStr = str;
        this.pathRaw = Constants.encode(str);
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public boolean include(TreeWalk treeWalk) throws IOException {
        if (treeWalk.isSubtree()) {
            return true;
        }
        byte[] bArr = this.pathRaw;
        return treeWalk.isPathSuffix(bArr, bArr.length);
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public int matchFilter(TreeWalk treeWalk) throws IOException {
        if (treeWalk.isSubtree()) {
            return -1;
        }
        return super.matchFilter(treeWalk);
    }
}

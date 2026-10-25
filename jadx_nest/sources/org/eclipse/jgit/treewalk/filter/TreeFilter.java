package org.eclipse.jgit.treewalk.filter;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import kotlin.text.Typography;
import org.apache.commons.codec.language.bm.Rule;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.jgit.treewalk.TreeWalk;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TreeFilter {
    public static final TreeFilter ALL = new AllFilter(null);
    public static final TreeFilter ANY_DIFF = new AnyDiffFilter(null);

    @Override // 
    public abstract TreeFilter clone();

    public abstract boolean include(TreeWalk treeWalk) throws IOException;

    public abstract boolean shouldBeRecursive();

    private static final class AllFilter extends TreeFilter {
        /* synthetic */ AllFilter(TreeFilterIA treeFilterIA) {
            this();
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public TreeFilter clone() {
            return this;
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public boolean include(TreeWalk treeWalk) {
            return true;
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public boolean shouldBeRecursive() {
            return false;
        }

        private AllFilter() {
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public String toString() {
            return Rule.ALL;
        }
    }

    private static final class AnyDiffFilter extends TreeFilter {
        private static final int baseTree = 0;

        /* synthetic */ AnyDiffFilter(TreeFilterIA treeFilterIA) {
            this();
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public TreeFilter clone() {
            return this;
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public boolean shouldBeRecursive() {
            return false;
        }

        private AnyDiffFilter() {
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public boolean include(TreeWalk treeWalk) {
            int treeCount = treeWalk.getTreeCount();
            if (treeCount == 1) {
                return true;
            }
            int rawMode = treeWalk.getRawMode(0);
            for (int i = 1; i < treeCount; i++) {
                if (treeWalk.getRawMode(i) != rawMode || !treeWalk.idEqual(i, 0)) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public String toString() {
            return "ANY_DIFF";
        }
    }

    public TreeFilter negate() {
        return NotTreeFilter.create(this);
    }

    public int matchFilter(TreeWalk treeWalk) throws IOException {
        return !include(treeWalk) ? 1 : 0;
    }

    public Optional<Set<byte[]>> getPathsBestEffort() {
        return Optional.empty();
    }

    public String toString() {
        String name = getClass().getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            name = name.substring(iLastIndexOf + 1);
        }
        return name.replace(Typography.dollar, FilenameUtils.EXTENSION_SEPARATOR);
    }
}

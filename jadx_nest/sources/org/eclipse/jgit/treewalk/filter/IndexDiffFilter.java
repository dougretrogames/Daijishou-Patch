package org.eclipse.jgit.treewalk.filter;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.dircache.DirCacheEntry;
import org.eclipse.jgit.dircache.DirCacheIterator;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.WorkingTreeIterator;

/* INFO: loaded from: classes5.dex */
public class IndexDiffFilter extends TreeFilter {
    private final int dirCache;
    private final boolean honorIgnores;
    private final Set<String> ignoredPaths;
    private final ArrayDeque<String> untrackedFolders;
    private final ArrayDeque<String> untrackedParentFolders;
    private final int workingTree;

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public TreeFilter clone() {
        return this;
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public boolean shouldBeRecursive() {
        return true;
    }

    public IndexDiffFilter(int i, int i2) {
        this(i, i2, true);
    }

    public IndexDiffFilter(int i, int i2, boolean z) {
        this.ignoredPaths = new HashSet();
        this.untrackedParentFolders = new ArrayDeque<>();
        this.untrackedFolders = new ArrayDeque<>();
        this.dirCache = i;
        this.workingTree = i2;
        this.honorIgnores = z;
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public boolean include(TreeWalk treeWalk) throws IOException {
        DirCacheEntry dirCacheEntry;
        int treeCount = treeWalk.getTreeCount();
        int rawMode = treeWalk.getRawMode(this.workingTree);
        WorkingTreeIterator workingTreeIteratorWorkingTree = workingTree(treeWalk);
        String pathString = treeWalk.getPathString();
        DirCacheIterator dirCacheIterator = (DirCacheIterator) treeWalk.getTree(this.dirCache, DirCacheIterator.class);
        if (dirCacheIterator != null && (dirCacheEntry = dirCacheIterator.getDirCacheEntry()) != null) {
            if (dirCacheEntry.isAssumeValid()) {
                return false;
            }
            if (dirCacheEntry.getStage() != 0) {
                return true;
            }
        }
        if (!treeWalk.isPostOrderTraversal()) {
            if (FileMode.TREE.equals(rawMode) && (!this.honorIgnores || !workingTreeIteratorWorkingTree.isEntryIgnored())) {
                copyUntrackedFolders(pathString);
                this.untrackedParentFolders.addFirst(pathString);
            }
            for (int i = 0; i < treeCount; i++) {
                int rawMode2 = treeWalk.getRawMode(i);
                if (i != this.workingTree && rawMode2 != 0 && FileMode.TREE.equals(rawMode2)) {
                    this.untrackedParentFolders.clear();
                    break;
                }
            }
        }
        if (rawMode == 0) {
            return true;
        }
        int rawMode3 = treeWalk.getRawMode(this.dirCache);
        if (rawMode3 == 0) {
            if (!this.honorIgnores || !workingTreeIteratorWorkingTree.isEntryIgnored()) {
                return true;
            }
            this.ignoredPaths.add(workingTreeIteratorWorkingTree.getEntryPathString());
            int i2 = 0;
            while (i2 < treeCount && (i2 == this.dirCache || i2 == this.workingTree || treeWalk.getRawMode(i2) == 0)) {
                i2++;
            }
            return i2 != treeCount;
        }
        if (treeWalk.isSubtree()) {
            return true;
        }
        for (int i3 = 0; i3 < treeCount; i3++) {
            if (i3 != this.dirCache && i3 != this.workingTree && (treeWalk.getRawMode(i3) != rawMode3 || !treeWalk.idEqual(i3, this.dirCache))) {
                return true;
            }
        }
        return workingTreeIteratorWorkingTree.isModified(dirCacheIterator == null ? null : dirCacheIterator.getDirCacheEntry(), true, treeWalk.getObjectReader());
    }

    private void copyUntrackedFolders(String str) {
        String strRemoveFirst = null;
        while (!this.untrackedParentFolders.isEmpty()) {
            if (str.startsWith(this.untrackedParentFolders.getFirst() + InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                break;
            } else {
                strRemoveFirst = this.untrackedParentFolders.removeFirst();
            }
        }
        if (strRemoveFirst != null) {
            while (!this.untrackedFolders.isEmpty() && this.untrackedFolders.getLast().startsWith(strRemoveFirst + InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                this.untrackedFolders.removeLast();
            }
            this.untrackedFolders.addLast(strRemoveFirst);
        }
    }

    private WorkingTreeIterator workingTree(TreeWalk treeWalk) {
        return (WorkingTreeIterator) treeWalk.getTree(this.workingTree, WorkingTreeIterator.class);
    }

    @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
    public String toString() {
        return "INDEX_DIFF_FILTER";
    }

    public Set<String> getIgnoredPaths() {
        return this.ignoredPaths;
    }

    public List<String> getUntrackedFolders() {
        ArrayList arrayList = new ArrayList(this.untrackedFolders);
        if (!this.untrackedParentFolders.isEmpty()) {
            String last = this.untrackedParentFolders.getLast();
            while (!arrayList.isEmpty() && ((String) arrayList.get(arrayList.size() - 1)).startsWith(last)) {
                arrayList.remove(arrayList.size() - 1);
            }
            arrayList.add(last);
        }
        return arrayList;
    }
}

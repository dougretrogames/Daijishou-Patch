package org.eclipse.jgit.merge;

import java.io.IOException;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.dircache.DirCacheBuilder;
import org.eclipse.jgit.dircache.DirCacheEntry;
import org.eclipse.jgit.errors.UnmergedPathException;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.NameConflictTreeWalk;

/* JADX INFO: loaded from: classes5.dex */
public class StrategySimpleTwoWayInCore extends ThreeWayMergeStrategy {
    protected StrategySimpleTwoWayInCore() {
    }

    @Override // org.eclipse.jgit.merge.MergeStrategy
    public String getName() {
        return "simple-two-way-in-core";
    }

    @Override // org.eclipse.jgit.merge.ThreeWayMergeStrategy, org.eclipse.jgit.merge.MergeStrategy
    public ThreeWayMerger newMerger(Repository repository) {
        return new InCoreMerger(repository);
    }

    @Override // org.eclipse.jgit.merge.ThreeWayMergeStrategy, org.eclipse.jgit.merge.MergeStrategy
    public ThreeWayMerger newMerger(Repository repository, boolean z) {
        return newMerger(repository);
    }

    @Override // org.eclipse.jgit.merge.MergeStrategy
    public ThreeWayMerger newMerger(ObjectInserter objectInserter, Config config) {
        return new InCoreMerger(objectInserter);
    }

    private static class InCoreMerger extends ThreeWayMerger {
        private static final int T_BASE = 0;
        private static final int T_OURS = 1;
        private static final int T_THEIRS = 2;
        private DirCacheBuilder builder;
        private final DirCache cache;
        private ObjectId resultTree;
        private final NameConflictTreeWalk tw;

        InCoreMerger(Repository repository) {
            super(repository);
            this.tw = new NameConflictTreeWalk(repository, this.reader);
            this.cache = DirCache.newInCore();
        }

        InCoreMerger(ObjectInserter objectInserter) {
            super(objectInserter);
            this.tw = new NameConflictTreeWalk(null, this.reader);
            this.cache = DirCache.newInCore();
        }

        @Override // org.eclipse.jgit.merge.Merger
        protected boolean mergeImpl() throws IOException {
            this.tw.addTree(mergeBase());
            this.tw.addTree(this.sourceTrees[0]);
            this.tw.addTree(this.sourceTrees[1]);
            this.builder = this.cache.builder();
            boolean z = false;
            while (this.tw.next()) {
                int rawMode = this.tw.getRawMode(1);
                int rawMode2 = this.tw.getRawMode(2);
                if (rawMode == rawMode2 && this.tw.idEqual(1, 2)) {
                    add(1, 0);
                } else {
                    int rawMode3 = this.tw.getRawMode(0);
                    if (rawMode3 == rawMode && this.tw.idEqual(0, 1)) {
                        add(2, 0);
                    } else if (rawMode3 == rawMode2 && this.tw.idEqual(0, 2)) {
                        add(1, 0);
                    } else {
                        if (nonTree(rawMode3)) {
                            add(0, 1);
                            z = true;
                        }
                        if (nonTree(rawMode)) {
                            add(1, 2);
                            z = true;
                        }
                        if (nonTree(rawMode2)) {
                            add(2, 3);
                            z = true;
                        }
                        if (this.tw.isSubtree()) {
                            this.tw.enterSubtree();
                        }
                    }
                }
            }
            this.builder.finish();
            this.builder = null;
            if (z) {
                return false;
            }
            try {
                ObjectInserter objectInserter = getObjectInserter();
                this.resultTree = this.cache.writeTree(objectInserter);
                objectInserter.flush();
                return true;
            } catch (UnmergedPathException unused) {
                this.resultTree = null;
                return false;
            }
        }

        private static boolean nonTree(int i) {
            return (i == 0 || FileMode.TREE.equals(i)) ? false : true;
        }

        private void add(int i, int i2) throws IOException {
            AbstractTreeIterator tree = getTree(i);
            if (tree != null) {
                if (FileMode.TREE.equals(this.tw.getRawMode(i))) {
                    this.builder.addTree(this.tw.getRawPath(), i2, this.reader, this.tw.getObjectId(i));
                    return;
                }
                DirCacheEntry dirCacheEntry = new DirCacheEntry(this.tw.getRawPath(), i2);
                dirCacheEntry.setObjectIdFromRaw(tree.idBuffer(), tree.idOffset());
                dirCacheEntry.setFileMode(this.tw.getFileMode(i));
                this.builder.add(dirCacheEntry);
            }
        }

        private AbstractTreeIterator getTree(int i) {
            return this.tw.getTree(i, AbstractTreeIterator.class);
        }

        @Override // org.eclipse.jgit.merge.Merger
        public ObjectId getResultTreeId() {
            return this.resultTree;
        }
    }
}

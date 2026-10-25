package org.eclipse.jgit.dircache;

import java.io.IOException;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;

/* JADX INFO: loaded from: classes5.dex */
public class DirCacheBuildIterator extends DirCacheIterator {
    private final DirCacheBuilder builder;

    public DirCacheBuildIterator(DirCacheBuilder dirCacheBuilder) {
        super(dirCacheBuilder.getDirCache());
        this.builder = dirCacheBuilder;
    }

    DirCacheBuildIterator(DirCacheBuildIterator dirCacheBuildIterator, DirCacheTree dirCacheTree) {
        super(dirCacheBuildIterator, dirCacheTree);
        this.builder = dirCacheBuildIterator.builder;
    }

    @Override // org.eclipse.jgit.dircache.DirCacheIterator, org.eclipse.jgit.treewalk.AbstractTreeIterator
    public AbstractTreeIterator createSubtreeIterator(ObjectReader objectReader) throws IOException {
        if (this.currentSubtree == null) {
            throw new IncorrectObjectTypeException(getEntryObjectId(), Constants.TYPE_TREE);
        }
        return new DirCacheBuildIterator(this, this.currentSubtree);
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public void skip() throws CorruptObjectException {
        if (this.currentSubtree != null) {
            this.builder.keep(this.ptr, this.currentSubtree.getEntrySpan());
        } else {
            this.builder.keep(this.ptr, 1);
        }
        next(1);
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public void stopWalk() {
        int i = this.ptr;
        int entryCount = this.cache.getEntryCount();
        if (i < entryCount) {
            this.builder.keep(i, entryCount - i);
        }
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    protected boolean needsStopWalk() {
        return this.ptr < this.cache.getEntryCount();
    }
}

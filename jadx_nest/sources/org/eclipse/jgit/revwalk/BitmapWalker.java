package org.eclipse.jgit.revwalk;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.internal.revwalk.AddToBitmapFilter;
import org.eclipse.jgit.internal.revwalk.AddToBitmapWithCacheFilter;
import org.eclipse.jgit.internal.revwalk.AddUnseenToBitmapFilter;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BitmapIndex;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.revwalk.filter.ObjectFilter;

/* JADX INFO: loaded from: classes5.dex */
public final class BitmapWalker {
    private final BitmapIndex bitmapIndex;
    private long countOfBitmapIndexMisses;
    private final ProgressMonitor pm;
    private BitmapIndex.Bitmap prevBitmap;
    private AnyObjectId prevCommit;
    private final ObjectWalk walker;

    public BitmapWalker(ObjectWalk objectWalk, BitmapIndex bitmapIndex, ProgressMonitor progressMonitor) {
        this.walker = objectWalk;
        this.bitmapIndex = bitmapIndex;
        this.pm = progressMonitor == null ? NullProgressMonitor.INSTANCE : progressMonitor;
    }

    public void setPrevCommit(AnyObjectId anyObjectId) {
        this.prevCommit = anyObjectId;
    }

    public void setPrevBitmap(BitmapIndex.Bitmap bitmap) {
        this.prevBitmap = bitmap;
    }

    public long getCountOfBitmapIndexMisses() {
        return this.countOfBitmapIndexMisses;
    }

    public BitmapIndex.BitmapBuilder findObjects(Iterable<? extends ObjectId> iterable, BitmapIndex.BitmapBuilder bitmapBuilder, boolean z) throws IOException {
        if (!z) {
            return findObjectsWalk(iterable, bitmapBuilder, false);
        }
        try {
            return findObjectsWalk(iterable, bitmapBuilder, true);
        } catch (MissingObjectException unused) {
            BitmapIndex.BitmapBuilder bitmapBuilderNewBitmapBuilder = this.bitmapIndex.newBitmapBuilder();
            Iterator<? extends ObjectId> it = iterable.iterator();
            while (it.hasNext()) {
                BitmapIndex.Bitmap bitmap = this.bitmapIndex.getBitmap(it.next());
                if (bitmap != null) {
                    bitmapBuilderNewBitmapBuilder.or(bitmap);
                }
            }
            for (ObjectId objectId : iterable) {
                if (!bitmapBuilderNewBitmapBuilder.contains(objectId)) {
                    try {
                        bitmapBuilderNewBitmapBuilder.or((BitmapIndex.Bitmap) findObjectsWalk(Arrays.asList(objectId), bitmapBuilderNewBitmapBuilder, false));
                    } catch (MissingObjectException unused2) {
                    }
                }
            }
            return bitmapBuilderNewBitmapBuilder;
        }
    }

    private BitmapIndex.BitmapBuilder findObjectsWalk(Iterable<? extends ObjectId> iterable, BitmapIndex.BitmapBuilder bitmapBuilder, boolean z) throws IOException {
        this.walker.reset();
        BitmapIndex.BitmapBuilder bitmapBuilderNewBitmapBuilder = this.bitmapIndex.newBitmapBuilder();
        Iterator<? extends ObjectId> it = iterable.iterator();
        while (it.hasNext()) {
            BitmapIndex.Bitmap bitmap = this.bitmapIndex.getBitmap(it.next());
            if (bitmap != null) {
                bitmapBuilderNewBitmapBuilder.or(bitmap);
            }
        }
        boolean z2 = false;
        for (ObjectId objectId : iterable) {
            try {
                if (!bitmapBuilderNewBitmapBuilder.contains(objectId)) {
                    ObjectWalk objectWalk = this.walker;
                    objectWalk.markStart(objectWalk.parseAny(objectId));
                    z2 = true;
                }
            } catch (MissingObjectException e) {
                if (!z) {
                    throw e;
                }
            }
        }
        if (z2) {
            if (this.prevCommit != null) {
                this.walker.setRevFilter(new AddToBitmapWithCacheFilter(this.prevCommit, this.prevBitmap, bitmapBuilderNewBitmapBuilder));
            } else if (bitmapBuilder == null) {
                this.walker.setRevFilter(new AddToBitmapFilter(bitmapBuilderNewBitmapBuilder));
            } else {
                this.walker.setRevFilter(new AddUnseenToBitmapFilter(bitmapBuilder, bitmapBuilderNewBitmapBuilder));
            }
            this.walker.setObjectFilter(new BitmapObjectFilter(bitmapBuilderNewBitmapBuilder));
            while (this.walker.next() != null) {
                this.pm.update(1);
                this.countOfBitmapIndexMisses++;
            }
            while (true) {
                RevObject revObjectNextObject = this.walker.nextObject();
                if (revObjectNextObject == null) {
                    break;
                }
                bitmapBuilderNewBitmapBuilder.addObject(revObjectNextObject, revObjectNextObject.getType());
                this.pm.update(1);
            }
        }
        return bitmapBuilderNewBitmapBuilder;
    }

    static class BitmapObjectFilter extends ObjectFilter {
        private final BitmapIndex.BitmapBuilder bitmap;

        BitmapObjectFilter(BitmapIndex.BitmapBuilder bitmapBuilder) {
            this.bitmap = bitmapBuilder;
        }

        @Override // org.eclipse.jgit.revwalk.filter.ObjectFilter
        public final boolean include(ObjectWalk objectWalk, AnyObjectId anyObjectId) throws IOException {
            return !this.bitmap.contains(anyObjectId);
        }
    }
}

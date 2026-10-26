package org.eclipse.jgit.internal.revwalk;

import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BitmapIndex;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevFlag;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.revwalk.filter.RevFilter;

/* INFO: loaded from: classes5.dex */
public class AddToBitmapWithCacheFilter extends RevFilter {
    private final BitmapIndex.BitmapBuilder bitmap;
    private final BitmapIndex.Bitmap cachedBitmap;
    private final AnyObjectId cachedCommit;

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public final boolean requiresCommitBody() {
        return false;
    }

    public AddToBitmapWithCacheFilter(AnyObjectId anyObjectId, BitmapIndex.Bitmap bitmap, BitmapIndex.BitmapBuilder bitmapBuilder) {
        this.cachedCommit = anyObjectId;
        this.cachedBitmap = bitmap;
        this.bitmap = bitmapBuilder;
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public final boolean include(RevWalk revWalk, RevCommit revCommit) {
        if (!this.bitmap.contains(revCommit)) {
            BitmapIndex.Bitmap bitmap = this.bitmap.getBitmapIndex().getBitmap(revCommit);
            if (bitmap != null) {
                this.bitmap.or(bitmap);
            } else if (this.cachedCommit.equals((AnyObjectId) revCommit)) {
                this.bitmap.or(this.cachedBitmap);
            } else {
                this.bitmap.addObject(revCommit, 1);
                return true;
            }
        }
        for (RevCommit revCommit2 : revCommit.getParents()) {
            revCommit2.add(RevFlag.SEEN);
        }
        return false;
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public final RevFilter clone() {
        throw new UnsupportedOperationException();
    }
}

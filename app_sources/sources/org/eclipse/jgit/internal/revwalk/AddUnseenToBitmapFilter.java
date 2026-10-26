package org.eclipse.jgit.internal.revwalk;

import org.eclipse.jgit.lib.BitmapIndex;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevFlag;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.revwalk.filter.RevFilter;

/* INFO: loaded from: classes5.dex */
public class AddUnseenToBitmapFilter extends RevFilter {
    private final BitmapIndex.BitmapBuilder bitmap;
    private final BitmapIndex.BitmapBuilder seen;

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public final boolean requiresCommitBody() {
        return false;
    }

    public AddUnseenToBitmapFilter(BitmapIndex.BitmapBuilder bitmapBuilder, BitmapIndex.BitmapBuilder bitmapBuilder2) {
        this.seen = bitmapBuilder;
        this.bitmap = bitmapBuilder2;
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public final boolean include(RevWalk revWalk, RevCommit revCommit) {
        if (!this.seen.contains(revCommit) && !this.bitmap.contains(revCommit)) {
            BitmapIndex.Bitmap bitmap = this.bitmap.getBitmapIndex().getBitmap(revCommit);
            if (bitmap != null) {
                this.bitmap.or(bitmap);
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

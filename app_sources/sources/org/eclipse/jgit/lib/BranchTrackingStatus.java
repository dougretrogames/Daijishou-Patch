package org.eclipse.jgit.lib;

import java.io.IOException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.revwalk.RevWalkUtils;
import org.eclipse.jgit.revwalk.filter.RevFilter;

/* INFO: loaded from: classes5.dex */
public class BranchTrackingStatus {
    private final int aheadCount;
    private final int behindCount;
    private final String remoteTrackingBranch;

    public static BranchTrackingStatus of(Repository repository, String str) throws IOException {
        Ref refExactRef;
        Ref refExactRef2;
        String strShortenRefName = Repository.shortenRefName(str);
        String str2 = Constants.R_HEADS + strShortenRefName;
        String trackingBranch = new BranchConfig(repository.getConfig(), strShortenRefName).getTrackingBranch();
        Throwable th = null;
        if (trackingBranch == null || (refExactRef = repository.exactRef(trackingBranch)) == null || (refExactRef2 = repository.exactRef(str2)) == null) {
            return null;
        }
        try {
            RevWalk revWalk = new RevWalk(repository);
            try {
                RevCommit commit = revWalk.parseCommit(refExactRef2.getObjectId());
                RevCommit commit2 = revWalk.parseCommit(refExactRef.getObjectId());
                revWalk.setRevFilter(RevFilter.MERGE_BASE);
                revWalk.markStart(commit);
                revWalk.markStart(commit2);
                RevCommit next = revWalk.next();
                revWalk.reset();
                revWalk.setRevFilter(RevFilter.ALL);
                return new BranchTrackingStatus(trackingBranch, RevWalkUtils.count(revWalk, commit, next), RevWalkUtils.count(revWalk, commit2, next));
            } finally {
                revWalk.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    private BranchTrackingStatus(String str, int i, int i2) {
        this.remoteTrackingBranch = str;
        this.aheadCount = i;
        this.behindCount = i2;
    }

    public String getRemoteTrackingBranch() {
        return this.remoteTrackingBranch;
    }

    public int getAheadCount() {
        return this.aheadCount;
    }

    public int getBehindCount() {
        return this.behindCount;
    }
}

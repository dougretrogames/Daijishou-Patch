package org.eclipse.jgit.api;

import org.eclipse.jgit.transport.FetchResult;

/* JADX INFO: loaded from: classes5.dex */
public class PullResult {
    private final FetchResult fetchResult;
    private final String fetchedFrom;
    private final MergeResult mergeResult;
    private final RebaseResult rebaseResult;

    PullResult(FetchResult fetchResult, String str, MergeResult mergeResult) {
        this.fetchResult = fetchResult;
        this.fetchedFrom = str;
        this.mergeResult = mergeResult;
        this.rebaseResult = null;
    }

    PullResult(FetchResult fetchResult, String str, RebaseResult rebaseResult) {
        this.fetchResult = fetchResult;
        this.fetchedFrom = str;
        this.mergeResult = null;
        this.rebaseResult = rebaseResult;
    }

    public FetchResult getFetchResult() {
        return this.fetchResult;
    }

    public MergeResult getMergeResult() {
        return this.mergeResult;
    }

    public RebaseResult getRebaseResult() {
        return this.rebaseResult;
    }

    public String getFetchedFrom() {
        return this.fetchedFrom;
    }

    public boolean isSuccessful() {
        MergeResult mergeResult = this.mergeResult;
        if (mergeResult != null) {
            return mergeResult.getMergeStatus().isSuccessful();
        }
        RebaseResult rebaseResult = this.rebaseResult;
        if (rebaseResult != null) {
            return rebaseResult.getStatus().isSuccessful();
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        FetchResult fetchResult = this.fetchResult;
        if (fetchResult != null) {
            sb.append(fetchResult.toString());
        } else {
            sb.append("No fetch result");
        }
        sb.append("\n");
        MergeResult mergeResult = this.mergeResult;
        if (mergeResult != null) {
            sb.append(mergeResult.toString());
        } else {
            RebaseResult rebaseResult = this.rebaseResult;
            if (rebaseResult != null) {
                sb.append(rebaseResult.toString());
            } else {
                sb.append("No update result");
            }
        }
        return sb.toString();
    }
}

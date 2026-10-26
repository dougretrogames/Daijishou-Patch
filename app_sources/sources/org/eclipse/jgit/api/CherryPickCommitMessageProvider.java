package org.eclipse.jgit.api;

import org.eclipse.jgit.revwalk.RevCommit;

/* INFO: loaded from: classes5.dex */
public interface CherryPickCommitMessageProvider {
    public static final CherryPickCommitMessageProvider ORIGINAL = new CherryPickCommitMessageProvider$$ExternalSyntheticLambda0();
    public static final CherryPickCommitMessageProvider ORIGINAL_WITH_REFERENCE = new CherryPickCommitMessageProvider$$ExternalSyntheticLambda1();

    String getCherryPickedCommitMessage(RevCommit revCommit);

    private static boolean messageEndsWithFooter(RevCommit revCommit) {
        return revCommit.getRawBuffer().length == revCommit.getFooterLines().stream().mapToInt(new CherryPickCommitMessageProvider$$ExternalSyntheticLambda2()).max().orElse(-1);
    }
}

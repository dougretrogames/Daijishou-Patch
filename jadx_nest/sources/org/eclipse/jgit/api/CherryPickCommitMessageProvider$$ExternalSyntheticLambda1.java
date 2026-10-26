package org.eclipse.jgit.api;

import org.eclipse.jgit.revwalk.RevCommit;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class CherryPickCommitMessageProvider$$ExternalSyntheticLambda1 implements CherryPickCommitMessageProvider {
    @Override // org.eclipse.jgit.api.CherryPickCommitMessageProvider
    public final String getCherryPickedCommitMessage(RevCommit revCommit) {
        return String.format("%s%s(cherry picked from commit %s)", revCommit.getFullMessage(), CherryPickCommitMessageProvider.messageEndsWithFooter(revCommit) ? "\n" : "\n\n", revCommit.getName());
    }
}

package org.eclipse.jgit.api;

import org.eclipse.jgit.revwalk.RevCommit;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class CherryPickCommitMessageProvider$$ExternalSyntheticLambda0 implements CherryPickCommitMessageProvider {
    @Override // org.eclipse.jgit.api.CherryPickCommitMessageProvider
    public final String getCherryPickedCommitMessage(RevCommit revCommit) {
        return revCommit.getFullMessage();
    }
}

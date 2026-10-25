package org.eclipse.jgit.revwalk;

import org.eclipse.jgit.diff.DiffEntry;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RenameCallback {
    public abstract void renamed(DiffEntry diffEntry);

    public void renamed(DiffEntry diffEntry, RevCommit revCommit) {
        renamed(diffEntry);
    }
}

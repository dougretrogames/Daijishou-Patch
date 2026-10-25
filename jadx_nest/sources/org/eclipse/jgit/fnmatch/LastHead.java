package org.eclipse.jgit.fnmatch;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
final class LastHead implements Head {
    static final Head INSTANCE = new LastHead();

    private LastHead() {
    }

    @Override // org.eclipse.jgit.fnmatch.Head
    public List<Head> getNextHeads(char c) {
        return FileNameMatcher.EMPTY_HEAD_LIST;
    }
}

package org.eclipse.jgit.diff;

import org.eclipse.jgit.diff.Sequence;

/* JADX INFO: loaded from: classes5.dex */
public final class HashedSequence<S extends Sequence> extends Sequence {
    final S base;
    final int[] hashes;

    HashedSequence(S s, int[] iArr) {
        this.base = s;
        this.hashes = iArr;
    }

    @Override // org.eclipse.jgit.diff.Sequence
    public int size() {
        return this.base.size();
    }
}

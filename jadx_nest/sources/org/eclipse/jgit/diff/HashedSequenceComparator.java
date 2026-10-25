package org.eclipse.jgit.diff;

import org.eclipse.jgit.diff.Sequence;

/* JADX INFO: loaded from: classes5.dex */
public final class HashedSequenceComparator<S extends Sequence> extends SequenceComparator<HashedSequence<S>> {
    private final SequenceComparator<? super S> cmp;

    HashedSequenceComparator(SequenceComparator<? super S> sequenceComparator) {
        this.cmp = sequenceComparator;
    }

    @Override // org.eclipse.jgit.diff.SequenceComparator
    public boolean equals(HashedSequence<S> hashedSequence, int i, HashedSequence<S> hashedSequence2, int i2) {
        return hashedSequence.hashes[i] == hashedSequence2.hashes[i2] && this.cmp.equals(hashedSequence.base, i, hashedSequence2.base, i2);
    }

    @Override // org.eclipse.jgit.diff.SequenceComparator
    public int hash(HashedSequence<S> hashedSequence, int i) {
        return hashedSequence.hashes[i];
    }
}

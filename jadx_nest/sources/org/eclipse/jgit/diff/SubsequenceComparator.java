package org.eclipse.jgit.diff;

import org.eclipse.jgit.diff.Sequence;

/* JADX INFO: loaded from: classes5.dex */
public final class SubsequenceComparator<S extends Sequence> extends SequenceComparator<Subsequence<S>> {
    private final SequenceComparator<? super S> cmp;

    public SubsequenceComparator(SequenceComparator<? super S> sequenceComparator) {
        this.cmp = sequenceComparator;
    }

    @Override // org.eclipse.jgit.diff.SequenceComparator
    public boolean equals(Subsequence<S> subsequence, int i, Subsequence<S> subsequence2, int i2) {
        return this.cmp.equals(subsequence.base, i + subsequence.begin, subsequence2.base, i2 + subsequence2.begin);
    }

    @Override // org.eclipse.jgit.diff.SequenceComparator
    public int hash(Subsequence<S> subsequence, int i) {
        return this.cmp.hash(subsequence.base, i + subsequence.begin);
    }
}

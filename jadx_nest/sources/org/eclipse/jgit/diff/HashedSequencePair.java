package org.eclipse.jgit.diff;

import org.eclipse.jgit.diff.Sequence;

/* JADX INFO: loaded from: classes5.dex */
public class HashedSequencePair<S extends Sequence> {
    private final S baseA;
    private final S baseB;
    private HashedSequence<S> cachedA;
    private HashedSequence<S> cachedB;
    private final SequenceComparator<? super S> cmp;

    public HashedSequencePair(SequenceComparator<? super S> sequenceComparator, S s, S s2) {
        this.cmp = sequenceComparator;
        this.baseA = s;
        this.baseB = s2;
    }

    public HashedSequenceComparator<S> getComparator() {
        return new HashedSequenceComparator<>(this.cmp);
    }

    public HashedSequence<S> getA() {
        if (this.cachedA == null) {
            this.cachedA = wrap(this.baseA);
        }
        return this.cachedA;
    }

    public HashedSequence<S> getB() {
        if (this.cachedB == null) {
            this.cachedB = wrap(this.baseB);
        }
        return this.cachedB;
    }

    private HashedSequence<S> wrap(S s) {
        int size = s.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = this.cmp.hash(s, i);
        }
        return new HashedSequence<>(s, iArr);
    }
}

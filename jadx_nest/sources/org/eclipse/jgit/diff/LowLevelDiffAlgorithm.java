package org.eclipse.jgit.diff;

/* JADX INFO: loaded from: classes5.dex */
public abstract class LowLevelDiffAlgorithm extends DiffAlgorithm {
    public abstract <S extends Sequence> void diffNonCommon(EditList editList, HashedSequenceComparator<S> hashedSequenceComparator, HashedSequence<S> hashedSequence, HashedSequence<S> hashedSequence2, Edit edit);

    @Override // org.eclipse.jgit.diff.DiffAlgorithm
    public <S extends Sequence> EditList diffNonCommon(SequenceComparator<? super S> sequenceComparator, S s, S s2) {
        HashedSequencePair hashedSequencePair = new HashedSequencePair(sequenceComparator, s, s2);
        HashedSequenceComparator<S> comparator = hashedSequencePair.getComparator();
        HashedSequence<S> a = hashedSequencePair.getA();
        HashedSequence<S> b = hashedSequencePair.getB();
        EditList editList = new EditList();
        diffNonCommon(editList, comparator, a, b, new Edit(0, s.size(), 0, s2.size()));
        return editList;
    }
}

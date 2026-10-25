package org.eclipse.jgit.diff;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class HistogramDiff extends LowLevelDiffAlgorithm {
    DiffAlgorithm fallback = MyersDiff.INSTANCE;
    int maxChainLength = 64;

    public void setFallbackAlgorithm(DiffAlgorithm diffAlgorithm) {
        this.fallback = diffAlgorithm;
    }

    public void setMaxChainLength(int i) {
        this.maxChainLength = i;
    }

    @Override // org.eclipse.jgit.diff.LowLevelDiffAlgorithm
    public <S extends Sequence> void diffNonCommon(EditList editList, HashedSequenceComparator<S> hashedSequenceComparator, HashedSequence<S> hashedSequence, HashedSequence<S> hashedSequence2, Edit edit) {
        new State(editList, hashedSequenceComparator, hashedSequence, hashedSequence2).diffRegion(edit);
    }

    private class State<S extends Sequence> {
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$Edit$Type;
        private final HashedSequence<S> a;
        private final HashedSequence<S> b;
        private final HashedSequenceComparator<S> cmp;
        final EditList edits;
        private final List<Edit> queue = new ArrayList();

        static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$Edit$Type() {
            int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$diff$Edit$Type;
            if (iArr != null) {
                return iArr;
            }
            int[] iArr2 = new int[Edit.Type.valuesCustom().length];
            try {
                iArr2[Edit.Type.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr2[Edit.Type.EMPTY.ordinal()] = 4;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[Edit.Type.INSERT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Edit.Type.REPLACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            $SWITCH_TABLE$org$eclipse$jgit$diff$Edit$Type = iArr2;
            return iArr2;
        }

        State(EditList editList, HashedSequenceComparator<S> hashedSequenceComparator, HashedSequence<S> hashedSequence, HashedSequence<S> hashedSequence2) {
            this.cmp = hashedSequenceComparator;
            this.a = hashedSequence;
            this.b = hashedSequence2;
            this.edits = editList;
        }

        void diffRegion(Edit edit) {
            diffReplace(edit);
            while (!this.queue.isEmpty()) {
                List<Edit> list = this.queue;
                diff(list.remove(list.size() - 1));
            }
        }

        private void diffReplace(Edit edit) {
            Edit editFindLongestCommonSequence = new HistogramDiffIndex(HistogramDiff.this.maxChainLength, this.cmp, this.a, this.b, edit).findLongestCommonSequence();
            if (editFindLongestCommonSequence != null) {
                if (editFindLongestCommonSequence.isEmpty()) {
                    this.edits.add(edit);
                    return;
                } else {
                    this.queue.add(edit.after(editFindLongestCommonSequence));
                    this.queue.add(edit.before(editFindLongestCommonSequence));
                    return;
                }
            }
            if (HistogramDiff.this.fallback instanceof LowLevelDiffAlgorithm) {
                ((LowLevelDiffAlgorithm) HistogramDiff.this.fallback).diffNonCommon(this.edits, this.cmp, this.a, this.b, edit);
                return;
            }
            if (HistogramDiff.this.fallback != null) {
                SubsequenceComparator<HashedSequence<S>> subsequenceComparatorSubcmp = subcmp();
                Subsequence subsequenceA = Subsequence.a(this.a, edit);
                Subsequence subsequenceB = Subsequence.b(this.b, edit);
                this.edits.addAll(Subsequence.toBase(HistogramDiff.this.fallback.diffNonCommon(subsequenceComparatorSubcmp, subsequenceA, subsequenceB), subsequenceA, subsequenceB));
                return;
            }
            this.edits.add(edit);
        }

        private void diff(Edit edit) {
            int i = $SWITCH_TABLE$org$eclipse$jgit$diff$Edit$Type()[edit.getType().ordinal()];
            if (i == 1 || i == 2) {
                this.edits.add(edit);
                return;
            }
            if (i == 3) {
                if (edit.getLengthA() == 1 && edit.getLengthB() == 1) {
                    this.edits.add(edit);
                    return;
                } else {
                    diffReplace(edit);
                    return;
                }
            }
            throw new IllegalStateException();
        }

        private SubsequenceComparator<HashedSequence<S>> subcmp() {
            return new SubsequenceComparator<>(this.cmp);
        }
    }
}

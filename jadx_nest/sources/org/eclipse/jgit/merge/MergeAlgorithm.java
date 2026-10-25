package org.eclipse.jgit.merge;

import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.jgit.diff.DiffAlgorithm;
import org.eclipse.jgit.diff.Edit;
import org.eclipse.jgit.diff.HistogramDiff;
import org.eclipse.jgit.diff.Sequence;
import org.eclipse.jgit.diff.SequenceComparator;

/* JADX INFO: loaded from: classes5.dex */
public final class MergeAlgorithm {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$merge$ContentMergeStrategy;
    private static final Edit END_EDIT = new Edit(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private final DiffAlgorithm diffAlg;
    private ContentMergeStrategy strategy;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$merge$ContentMergeStrategy() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$merge$ContentMergeStrategy;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[ContentMergeStrategy.valuesCustom().length];
        try {
            iArr2[ContentMergeStrategy.CONFLICT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[ContentMergeStrategy.OURS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[ContentMergeStrategy.THEIRS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[ContentMergeStrategy.UNION.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$merge$ContentMergeStrategy = iArr2;
        return iArr2;
    }

    public MergeAlgorithm() {
        this(new HistogramDiff());
    }

    public MergeAlgorithm(DiffAlgorithm diffAlgorithm) {
        this.strategy = ContentMergeStrategy.CONFLICT;
        this.diffAlg = diffAlgorithm;
    }

    public ContentMergeStrategy getContentMergeStrategy() {
        return this.strategy;
    }

    public void setContentMergeStrategy(ContentMergeStrategy contentMergeStrategy) {
        if (contentMergeStrategy == null) {
            contentMergeStrategy = ContentMergeStrategy.CONFLICT;
        }
        this.strategy = contentMergeStrategy;
    }

    private static boolean isEndEdit(Edit edit) {
        return edit == END_EDIT;
    }

    public <S extends Sequence> MergeResult<S> merge(SequenceComparator<S> sequenceComparator, S s, S s2, S s3) {
        int endA;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        char c;
        int i7;
        SequenceComparator<S> sequenceComparator2 = sequenceComparator;
        S s4 = s;
        S s5 = s2;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(s4);
        arrayList.add(s5);
        arrayList.add(s3);
        MergeResult<S> mergeResult = new MergeResult<>(arrayList);
        int i8 = 2;
        int i9 = 1;
        int i10 = 0;
        if (s5.size() == 0) {
            if (s3.size() != 0) {
                if (!this.diffAlg.diff(sequenceComparator2, s4, s3).isEmpty()) {
                    int i11 = $SWITCH_TABLE$org$eclipse$jgit$merge$ContentMergeStrategy()[this.strategy.ordinal()];
                    if (i11 == 2) {
                        mergeResult.add(1, 0, 0, MergeChunk.ConflictState.NO_CONFLICT);
                        return mergeResult;
                    }
                    if (i11 == 3 || i11 == 4) {
                        mergeResult.add(2, 0, s3.size(), MergeChunk.ConflictState.NO_CONFLICT);
                        return mergeResult;
                    }
                    mergeResult.add(1, 0, 0, MergeChunk.ConflictState.FIRST_CONFLICTING_RANGE);
                    mergeResult.add(0, 0, s4.size(), MergeChunk.ConflictState.BASE_CONFLICTING_RANGE);
                    mergeResult.add(2, 0, s3.size(), MergeChunk.ConflictState.NEXT_CONFLICTING_RANGE);
                    return mergeResult;
                }
                mergeResult.add(1, 0, 0, MergeChunk.ConflictState.NO_CONFLICT);
                return mergeResult;
            }
            mergeResult.add(1, 0, 0, MergeChunk.ConflictState.NO_CONFLICT);
            return mergeResult;
        }
        if (s3.size() == 0) {
            if (!this.diffAlg.diff(sequenceComparator2, s4, s5).isEmpty()) {
                int i12 = $SWITCH_TABLE$org$eclipse$jgit$merge$ContentMergeStrategy()[this.strategy.ordinal()];
                if (i12 != 2) {
                    if (i12 == 3) {
                        mergeResult.add(2, 0, 0, MergeChunk.ConflictState.NO_CONFLICT);
                        return mergeResult;
                    }
                    if (i12 != 4) {
                        mergeResult.add(1, 0, s5.size(), MergeChunk.ConflictState.FIRST_CONFLICTING_RANGE);
                        mergeResult.add(0, 0, s4.size(), MergeChunk.ConflictState.BASE_CONFLICTING_RANGE);
                        mergeResult.add(2, 0, 0, MergeChunk.ConflictState.NEXT_CONFLICTING_RANGE);
                        return mergeResult;
                    }
                }
                mergeResult.add(1, 0, s5.size(), MergeChunk.ConflictState.NO_CONFLICT);
                return mergeResult;
            }
            mergeResult.add(2, 0, 0, MergeChunk.ConflictState.NO_CONFLICT);
            return mergeResult;
        }
        Iterator<Edit> it = this.diffAlg.diff(sequenceComparator2, s4, s5).iterator();
        Iterator<Edit> it2 = this.diffAlg.diff(sequenceComparator2, s4, s3).iterator();
        Edit editNextEdit = nextEdit(it);
        Edit editNextEdit2 = nextEdit(it2);
        int endA2 = 0;
        while (true) {
            if (isEndEdit(editNextEdit2) && isEndEdit(editNextEdit)) {
                break;
            }
            if (editNextEdit.getEndA() < editNextEdit2.getBeginA()) {
                if (endA2 != editNextEdit.getBeginA()) {
                    mergeResult.add(i10, endA2, editNextEdit.getBeginA(), MergeChunk.ConflictState.NO_CONFLICT);
                }
                mergeResult.add(i9, editNextEdit.getBeginB(), editNextEdit.getEndB(), MergeChunk.ConflictState.NO_CONFLICT);
                endA2 = editNextEdit.getEndA();
                editNextEdit = nextEdit(it);
            } else if (editNextEdit2.getEndA() < editNextEdit.getBeginA()) {
                if (endA2 != editNextEdit2.getBeginA()) {
                    mergeResult.add(i10, endA2, editNextEdit2.getBeginA(), MergeChunk.ConflictState.NO_CONFLICT);
                }
                mergeResult.add(i8, editNextEdit2.getBeginB(), editNextEdit2.getEndB(), MergeChunk.ConflictState.NO_CONFLICT);
                endA2 = editNextEdit2.getEndA();
                editNextEdit2 = nextEdit(it2);
            } else {
                if (editNextEdit.getBeginA() != endA2 && editNextEdit2.getBeginA() != endA2) {
                    mergeResult.add(i10, endA2, Math.min(editNextEdit.getBeginA(), editNextEdit2.getBeginA()), MergeChunk.ConflictState.NO_CONFLICT);
                }
                int beginA = editNextEdit.getBeginA();
                int beginA2 = editNextEdit2.getBeginA();
                int beginB = editNextEdit.getBeginB();
                int beginB2 = editNextEdit2.getBeginB();
                if (editNextEdit.getBeginA() < editNextEdit2.getBeginA()) {
                    beginA2 -= editNextEdit2.getBeginA() - editNextEdit.getBeginA();
                    beginB2 -= editNextEdit2.getBeginA() - editNextEdit.getBeginA();
                } else {
                    beginA -= editNextEdit.getBeginA() - editNextEdit2.getBeginA();
                    beginB -= editNextEdit.getBeginA() - editNextEdit2.getBeginA();
                }
                Edit editNextEdit3 = nextEdit(it);
                Edit edit = editNextEdit2;
                editNextEdit2 = nextEdit(it2);
                Edit edit2 = edit;
                int i13 = i9;
                while (true) {
                    if (editNextEdit.getEndA() >= editNextEdit2.getBeginA()) {
                        edit2 = editNextEdit2;
                        editNextEdit2 = nextEdit(it2);
                    } else {
                        if (edit2.getEndA() < editNextEdit3.getBeginA()) {
                            break;
                        }
                        editNextEdit = editNextEdit3;
                        editNextEdit3 = nextEdit(it);
                    }
                }
                int endA3 = editNextEdit.getEndA();
                int endA4 = edit2.getEndA();
                int endB = editNextEdit.getEndB();
                int endB2 = edit2.getEndB();
                Iterator<Edit> it3 = it;
                if (editNextEdit.getEndA() < edit2.getEndA()) {
                    endA = endA3 + (edit2.getEndA() - editNextEdit.getEndA());
                    endB += edit2.getEndA() - editNextEdit.getEndA();
                } else {
                    endA4 += editNextEdit.getEndA() - edit2.getEndA();
                    endB2 += editNextEdit.getEndA() - edit2.getEndA();
                    endA = endA3;
                }
                int i14 = endB;
                int i15 = i14 - beginB;
                int i16 = i15 - (endB2 - beginB2);
                if (i16 > 0) {
                    i15 -= i16;
                }
                Edit edit3 = editNextEdit3;
                int i17 = i15;
                Edit edit4 = edit2;
                int i18 = 0;
                while (true) {
                    i = i17;
                    if (i18 >= i17) {
                        i2 = i18;
                        break;
                    }
                    i2 = i18;
                    if (!sequenceComparator2.equals(s5, beginB + i18, s3, beginB2 + i2)) {
                        break;
                    }
                    i18 = i2 + 1;
                    i17 = i;
                }
                int i19 = i - i2;
                int i20 = 0;
                while (true) {
                    if (i20 >= i19) {
                        i3 = i19;
                        i4 = i20;
                        break;
                    }
                    i3 = i19;
                    i4 = i20;
                    if (!sequenceComparator2.equals(s5, (i14 - i20) - 1, s3, (endB2 - i20) - 1)) {
                        break;
                    }
                    i20 = i4 + 1;
                    i19 = i3;
                }
                int i21 = i3 - i4;
                if (i2 > 0) {
                    mergeResult.add(i13, beginB, beginB + i2, MergeChunk.ConflictState.NO_CONFLICT);
                }
                if (i21 > 0 || i16 != 0) {
                    int i22 = $SWITCH_TABLE$org$eclipse$jgit$merge$ContentMergeStrategy()[this.strategy.ordinal()];
                    if (i22 != 2) {
                        if (i22 != 3) {
                            c = 4;
                            if (i22 == 4) {
                                i6 = 0;
                                i5 = 2;
                                mergeResult.add(1, beginB + i2, i14 - i4, MergeChunk.ConflictState.NO_CONFLICT);
                                mergeResult.add(2, beginB2 + i2, endB2 - i4, MergeChunk.ConflictState.NO_CONFLICT);
                            } else {
                                mergeResult.add(1, beginB + i2, i14 - i4, MergeChunk.ConflictState.FIRST_CONFLICTING_RANGE);
                                i6 = 0;
                                mergeResult.add(0, Math.min(beginA, beginA2) + i2, Math.min(s.size(), Math.max(endA, endA4)) - i4, MergeChunk.ConflictState.BASE_CONFLICTING_RANGE);
                                i5 = 2;
                                mergeResult.add(2, beginB2 + i2, endB2 - i4, MergeChunk.ConflictState.NEXT_CONFLICTING_RANGE);
                            }
                        } else {
                            i6 = 0;
                            i5 = 2;
                            c = 4;
                            mergeResult.add(2, beginB2 + i2, endB2 - i4, MergeChunk.ConflictState.NO_CONFLICT);
                        }
                        i7 = 1;
                    } else {
                        i5 = 2;
                        i6 = 0;
                        c = 4;
                        i7 = 1;
                        mergeResult.add(1, beginB + i2, i14 - i4, MergeChunk.ConflictState.NO_CONFLICT);
                    }
                } else {
                    i7 = 1;
                    i6 = 0;
                    i5 = 2;
                    c = 4;
                }
                if (i4 > 0) {
                    mergeResult.add(i7, i14 - i4, i14, MergeChunk.ConflictState.NO_CONFLICT);
                }
                endA2 = Math.max(editNextEdit.getEndA(), edit4.getEndA());
                i8 = i5;
                sequenceComparator2 = sequenceComparator;
                s4 = s;
                i9 = i7;
                i10 = i6;
                it = it3;
                editNextEdit = edit3;
                s5 = s2;
            }
        }
        if (endA2 < s4.size()) {
            mergeResult.add(i10, endA2, s4.size(), MergeChunk.ConflictState.NO_CONFLICT);
        }
        return mergeResult;
    }

    private static Edit nextEdit(Iterator<Edit> it) {
        return it.hasNext() ? it.next() : END_EDIT;
    }
}

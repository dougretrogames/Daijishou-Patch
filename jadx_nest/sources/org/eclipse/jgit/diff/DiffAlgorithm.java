package org.eclipse.jgit.diff;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DiffAlgorithm {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$DiffAlgorithm$SupportedAlgorithm;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$Edit$Type;

    public enum SupportedAlgorithm {
        MYERS,
        HISTOGRAM;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static SupportedAlgorithm[] valuesCustom() {
            SupportedAlgorithm[] supportedAlgorithmArrValuesCustom = values();
            int length = supportedAlgorithmArrValuesCustom.length;
            SupportedAlgorithm[] supportedAlgorithmArr = new SupportedAlgorithm[length];
            System.arraycopy(supportedAlgorithmArrValuesCustom, 0, supportedAlgorithmArr, 0, length);
            return supportedAlgorithmArr;
        }
    }

    public abstract <S extends Sequence> EditList diffNonCommon(SequenceComparator<? super S> sequenceComparator, S s, S s2);

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$DiffAlgorithm$SupportedAlgorithm() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffAlgorithm$SupportedAlgorithm;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[SupportedAlgorithm.valuesCustom().length];
        try {
            iArr2[SupportedAlgorithm.HISTOGRAM.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[SupportedAlgorithm.MYERS.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$diff$DiffAlgorithm$SupportedAlgorithm = iArr2;
        return iArr2;
    }

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

    public static DiffAlgorithm getAlgorithm(SupportedAlgorithm supportedAlgorithm) {
        int i = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffAlgorithm$SupportedAlgorithm()[supportedAlgorithm.ordinal()];
        if (i == 1) {
            return MyersDiff.INSTANCE;
        }
        if (i == 2) {
            return new HistogramDiff();
        }
        throw new IllegalArgumentException();
    }

    public <S extends Sequence> EditList diff(SequenceComparator<? super S> sequenceComparator, S s, S s2) {
        Edit editReduceCommonStartEnd = sequenceComparator.reduceCommonStartEnd(s, s2, coverEdit(s, s2));
        int i = $SWITCH_TABLE$org$eclipse$jgit$diff$Edit$Type()[editReduceCommonStartEnd.getType().ordinal()];
        if (i == 1 || i == 2) {
            return EditList.singleton(editReduceCommonStartEnd);
        }
        if (i != 3) {
            if (i == 4) {
                return new EditList(0);
            }
            throw new IllegalStateException();
        }
        if (editReduceCommonStartEnd.getLengthA() == 1 && editReduceCommonStartEnd.getLengthB() == 1) {
            return EditList.singleton(editReduceCommonStartEnd);
        }
        SubsequenceComparator subsequenceComparator = new SubsequenceComparator(sequenceComparator);
        Subsequence subsequenceA = Subsequence.a(s, editReduceCommonStartEnd);
        Subsequence subsequenceB = Subsequence.b(s2, editReduceCommonStartEnd);
        return normalize(sequenceComparator, Subsequence.toBase(diffNonCommon(subsequenceComparator, subsequenceA, subsequenceB), subsequenceA, subsequenceB), s, s2);
    }

    private static <S extends Sequence> Edit coverEdit(S s, S s2) {
        return new Edit(0, s.size(), 0, s2.size());
    }

    private static <S extends Sequence> EditList normalize(SequenceComparator<? super S> sequenceComparator, EditList editList, S s, S s2) {
        int size = editList.size() - 1;
        Edit edit = null;
        while (size >= 0) {
            Edit edit2 = editList.get(size);
            Edit.Type type = edit2.getType();
            int size2 = edit == null ? s.size() : edit.beginA;
            int size3 = edit == null ? s2.size() : edit.beginB;
            if (type == Edit.Type.INSERT) {
                while (edit2.endA < size2 && edit2.endB < size3 && sequenceComparator.equals(s2, edit2.beginB, s2, edit2.endB)) {
                    edit2.shift(1);
                }
            } else if (type == Edit.Type.DELETE) {
                while (edit2.endA < size2 && edit2.endB < size3 && sequenceComparator.equals(s, edit2.beginA, s, edit2.endA)) {
                    edit2.shift(1);
                }
            }
            size--;
            edit = edit2;
        }
        return editList;
    }
}

package org.eclipse.jgit.merge;

/* JADX INFO: loaded from: classes5.dex */
public class MergeChunk {
    private final int begin;
    private final ConflictState conflictState;
    private final int end;
    private final int sequenceIndex;

    public enum ConflictState {
        NO_CONFLICT,
        FIRST_CONFLICTING_RANGE,
        BASE_CONFLICTING_RANGE,
        NEXT_CONFLICTING_RANGE;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static ConflictState[] valuesCustom() {
            ConflictState[] conflictStateArrValuesCustom = values();
            int length = conflictStateArrValuesCustom.length;
            ConflictState[] conflictStateArr = new ConflictState[length];
            System.arraycopy(conflictStateArrValuesCustom, 0, conflictStateArr, 0, length);
            return conflictStateArr;
        }
    }

    protected MergeChunk(int i, int i2, int i3, ConflictState conflictState) {
        this.sequenceIndex = i;
        this.begin = i2;
        this.end = i3;
        this.conflictState = conflictState;
    }

    public int getSequenceIndex() {
        return this.sequenceIndex;
    }

    public int getBegin() {
        return this.begin;
    }

    public int getEnd() {
        return this.end;
    }

    public ConflictState getConflictState() {
        return this.conflictState;
    }
}

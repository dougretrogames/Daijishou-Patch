package org.eclipse.jgit.merge;

import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.diff.Sequence;
import org.eclipse.jgit.util.IntList;

/* INFO: loaded from: classes5.dex */
public class MergeResult<S extends Sequence> implements Iterable<MergeChunk> {
    static final MergeChunk.ConflictState[] states = MergeChunk.ConflictState.valuesCustom();
    final IntList chunks = new IntList();
    private boolean containsConflicts = false;
    private final List<S> sequences;

    public MergeResult(List<S> list) {
        this.sequences = list;
    }

    public void add(int i, int i2, int i3, MergeChunk.ConflictState conflictState) {
        this.chunks.add(conflictState.ordinal());
        this.chunks.add(i);
        this.chunks.add(i2);
        this.chunks.add(i3);
        if (conflictState != MergeChunk.ConflictState.NO_CONFLICT) {
            this.containsConflicts = true;
        }
    }

    public List<S> getSequences() {
        return this.sequences;
    }

    /* INFO: renamed from: org.eclipse.jgit.merge.MergeResult$1, reason: invalid class name */
    class AnonymousClass1 implements Iterator<MergeChunk> {
        int idx;

        AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.idx < MergeResult.this.chunks.size();
        }

        @Override // java.util.Iterator
        public MergeChunk next() {
            MergeChunk.ConflictState[] conflictStateArr = MergeResult.states;
            IntList intList = MergeResult.this.chunks;
            int i = this.idx;
            this.idx = i + 1;
            MergeChunk.ConflictState conflictState = conflictStateArr[intList.get(i)];
            IntList intList2 = MergeResult.this.chunks;
            int i2 = this.idx;
            this.idx = i2 + 1;
            int i3 = intList2.get(i2);
            IntList intList3 = MergeResult.this.chunks;
            int i4 = this.idx;
            this.idx = i4 + 1;
            int i5 = intList3.get(i4);
            IntList intList4 = MergeResult.this.chunks;
            int i6 = this.idx;
            this.idx = i6 + 1;
            return new MergeChunk(i3, i5, intList4.get(i6), conflictState);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<MergeChunk> iterator() {
        return new AnonymousClass1();
    }

    public boolean containsConflicts() {
        return this.containsConflicts;
    }

    protected void setContainsConflicts(boolean z) {
        this.containsConflicts = z;
    }
}

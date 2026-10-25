package org.eclipse.jgit.diff;

import org.eclipse.jgit.diff.Sequence;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SequenceComparator<S extends Sequence> {
    public abstract boolean equals(S s, int i, S s2, int i2);

    public abstract int hash(S s, int i);

    public Edit reduceCommonStartEnd(S s, S s2, Edit edit) {
        while (edit.beginA < edit.endA && edit.beginB < edit.endB && equals(s, edit.beginA, s2, edit.beginB)) {
            edit.beginA++;
            edit.beginB++;
        }
        while (edit.beginA < edit.endA && edit.beginB < edit.endB && equals(s, edit.endA - 1, s2, edit.endB - 1)) {
            edit.endA--;
            edit.endB--;
        }
        return edit;
    }
}

package org.eclipse.jgit.diff;

import java.util.Iterator;
import org.eclipse.jgit.diff.Sequence;

/* JADX INFO: loaded from: classes5.dex */
public final class Subsequence<S extends Sequence> extends Sequence {
    final S base;
    final int begin;
    private final int size;

    public static <S extends Sequence> Subsequence<S> a(S s, Edit edit) {
        return new Subsequence<>(s, edit.beginA, edit.endA);
    }

    public static <S extends Sequence> Subsequence<S> b(S s, Edit edit) {
        return new Subsequence<>(s, edit.beginB, edit.endB);
    }

    public static <S extends Sequence> void toBase(Edit edit, Subsequence<S> subsequence, Subsequence<S> subsequence2) {
        edit.beginA += subsequence.begin;
        edit.endA += subsequence.begin;
        edit.beginB += subsequence2.begin;
        edit.endB += subsequence2.begin;
    }

    public static <S extends Sequence> EditList toBase(EditList editList, Subsequence<S> subsequence, Subsequence<S> subsequence2) {
        Iterator<Edit> it = editList.iterator();
        while (it.hasNext()) {
            toBase(it.next(), subsequence, subsequence2);
        }
        return editList;
    }

    public Subsequence(S s, int i, int i2) {
        this.base = s;
        this.begin = i;
        this.size = i2 - i;
    }

    @Override // org.eclipse.jgit.diff.Sequence
    public int size() {
        return this.size;
    }
}

package org.eclipse.jgit.notes;

/* INFO: loaded from: classes5.dex */
abstract class InMemoryNoteBucket extends NoteBucket {
    NonNoteEntry nonNotes;
    final int prefixLen;

    abstract InMemoryNoteBucket append(Note note);

    InMemoryNoteBucket(int i) {
        this.prefixLen = i;
    }
}

package org.eclipse.jgit.notes;

import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class NotesMergeConflictException extends IOException {
    private static final long serialVersionUID = 1;

    public NotesMergeConflictException(Note note, Note note2, Note note3) {
        super(MessageFormat.format(JGitText.get().mergeConflictOnNotes, noteOn(note, note2, note3), noteData(note), noteData(note2), noteData(note3)));
    }

    public NotesMergeConflictException(NonNoteEntry nonNoteEntry, NonNoteEntry nonNoteEntry2, NonNoteEntry nonNoteEntry3) {
        super(MessageFormat.format(JGitText.get().mergeConflictOnNonNoteEntries, name(nonNoteEntry), name(nonNoteEntry2), name(nonNoteEntry3)));
    }

    private static String noteOn(Note note, Note note2, Note note3) {
        if (note != null) {
            return note.name();
        }
        if (note2 != null) {
            return note2.name();
        }
        return note3.name();
    }

    private static String noteData(Note note) {
        if (note != null) {
            return note.getData().name();
        }
        return "";
    }

    private static String name(NonNoteEntry nonNoteEntry) {
        return nonNoteEntry != null ? nonNoteEntry.name() : "";
    }
}

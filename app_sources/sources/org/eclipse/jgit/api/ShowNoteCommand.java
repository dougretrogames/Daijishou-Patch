package org.eclipse.jgit.api;

import java.io.IOException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.notes.Note;
import org.eclipse.jgit.notes.NoteMap;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
public class ShowNoteCommand extends GitCommand<Note> {

    /* INFO: renamed from: id, reason: collision with root package name */
    private RevObject f112id;
    private String notesRef;

    protected ShowNoteCommand(Repository repository) {
        super(repository);
        this.notesRef = Constants.R_NOTES_COMMITS;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Note call() throws GitAPIException {
        checkCallable();
        NoteMap noteMapNewEmptyMap = NoteMap.newEmptyMap();
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.repo);
            try {
                Ref refExactRef = this.repo.exactRef(this.notesRef);
                if (refExactRef != null) {
                    noteMapNewEmptyMap = NoteMap.read(revWalk.getObjectReader(), revWalk.parseCommit(refExactRef.getObjectId()));
                }
                return noteMapNewEmptyMap.getNote(this.f112id);
            } finally {
                revWalk.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                try {
                    th.addSuppressed(th2);
                } catch (IOException e) {
                    throw new JGitInternalException(e.getMessage(), e);
                }
            }
            throw null;
        }
    }

    public ShowNoteCommand setObjectId(RevObject revObject) {
        checkCallable();
        this.f112id = revObject;
        return this;
    }

    public ShowNoteCommand setNotesRef(String str) {
        checkCallable();
        this.notesRef = str;
        return this;
    }
}

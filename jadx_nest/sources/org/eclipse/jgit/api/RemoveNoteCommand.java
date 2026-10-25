package org.eclipse.jgit.api;

import java.io.IOException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.notes.Note;
import org.eclipse.jgit.notes.NoteMap;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevWalk;

/* JADX INFO: loaded from: classes5.dex */
public class RemoveNoteCommand extends GitCommand<Note> {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private RevObject f111id;
    private String notesRef;

    protected RemoveNoteCommand(Repository repository) {
        super(repository);
        this.notesRef = Constants.R_NOTES_COMMITS;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Note call() throws GitAPIException {
        NoteMap noteMap;
        RevCommit revCommit;
        checkCallable();
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.repo);
            try {
                ObjectInserter objectInserterNewObjectInserter = this.repo.newObjectInserter();
                try {
                    NoteMap noteMapNewEmptyMap = NoteMap.newEmptyMap();
                    Ref refExactRef = this.repo.exactRef(this.notesRef);
                    if (refExactRef != null) {
                        RevCommit commit = revWalk.parseCommit(refExactRef.getObjectId());
                        revCommit = commit;
                        noteMap = NoteMap.read(revWalk.getObjectReader(), commit);
                    } else {
                        noteMap = noteMapNewEmptyMap;
                        revCommit = null;
                    }
                    noteMap.set(this.f111id, null, objectInserterNewObjectInserter);
                    AddNoteCommand.commitNoteMap(this.repo, this.notesRef, revWalk, noteMap, revCommit, objectInserterNewObjectInserter, "Notes removed by 'git notes remove'");
                    Note note = noteMap.getNote(this.f111id);
                    if (objectInserterNewObjectInserter != null) {
                        objectInserterNewObjectInserter.close();
                    }
                    revWalk.close();
                    return note;
                } catch (Throwable th2) {
                    if (objectInserterNewObjectInserter == null) {
                        throw th2;
                    }
                    objectInserterNewObjectInserter.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    th = th3;
                } else if (null != th3) {
                    th.addSuppressed(th3);
                }
                revWalk.close();
                throw th;
            }
        } catch (Throwable th4) {
            if (0 == 0) {
                throw th4;
            }
            if (null != th4) {
                try {
                    th.addSuppressed(th4);
                } catch (IOException e) {
                    throw new JGitInternalException(e.getMessage(), e);
                }
            }
            throw null;
        }
    }

    public RemoveNoteCommand setObjectId(RevObject revObject) {
        checkCallable();
        this.f111id = revObject;
        return this;
    }

    public RemoveNoteCommand setNotesRef(String str) {
        checkCallable();
        this.notesRef = str;
        return this;
    }
}
